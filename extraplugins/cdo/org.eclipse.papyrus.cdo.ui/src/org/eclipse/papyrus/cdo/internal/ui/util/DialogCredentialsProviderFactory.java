/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.util;

import java.util.concurrent.Callable;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.net4j.util.security.IPasswordCredentials;
import org.eclipse.net4j.util.security.IPasswordCredentialsProvider2;
import org.eclipse.net4j.util.security.PasswordCredentials;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;
import org.eclipse.papyrus.cdo.internal.core.ICredentialsProviderFactory;
import org.eclipse.papyrus.cdo.internal.core.IInteractiveCredentialsProvider;
import org.eclipse.papyrus.cdo.internal.ui.Activator;
import org.eclipse.papyrus.cdo.internal.ui.dialogs.RepositoryCredentialsDialog;
import org.eclipse.papyrus.cdo.internal.ui.l10n.Messages;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.google.common.base.Strings;

/**
 * This is the DialogCredentialsProviderFactory type. Enjoy.
 */
public class DialogCredentialsProviderFactory
		implements ICredentialsProviderFactory {

	private volatile IWorkbenchWindow activeWindow;

	public DialogCredentialsProviderFactory() {
		super();

		PlatformUI.getWorkbench().addWindowListener(new IWindowListener() {

			public void windowActivated(IWorkbenchWindow window) {
				activeWindow = window;
			}

			public void windowClosed(IWorkbenchWindow window) {
				if (activeWindow == window) {
					activeWindow = null;
				}
			}

			public void windowOpened(IWorkbenchWindow window) {
				// pass
			}

			public void windowDeactivated(IWorkbenchWindow window) {
				// pass
			}

		});
	}

	public IPasswordCredentialsProvider2 createCredentialsProvider(
			IPapyrusRepository repository) {

		return new CredentialsProvider(repository);
	}

	//
	// Nested types
	//

	private class CredentialsProvider
			implements IInteractiveCredentialsProvider {

		private IPapyrusRepository repository;

		CredentialsProvider(IPapyrusRepository repository) {
			super();

			this.repository = repository;
		}

		public boolean isInteractive() {
			return true;
		}

		public IPasswordCredentials getCredentials() {
			return getCredentials(null);
		}

		public IPasswordCredentials getCredentials(String realm) {
			IPasswordCredentials result;

			String username = repository.getUsername();
			String password = repository.getPassword();

			if (!Strings.isNullOrEmpty(username)
				&& !Strings.isNullOrEmpty(password)) {
				// use stored creds
				result = new PasswordCredentials(username,
					password.toCharArray());
			} else {
				// OK, prompt the user, then
				result = call(new Callable<IPasswordCredentials>() {

					public IPasswordCredentials call() {
						return openDialog();
					}
				});
			}

			return result;
		}

		private Shell getCurrentShell() {
			return (activeWindow != null)
				? activeWindow.getShell()
				: Display.getDefault().getActiveShell();
		}

		private IPasswordCredentials openDialog() {
			IPasswordCredentials result = null;

			RepositoryCredentialsDialog dlg = new RepositoryCredentialsDialog(
				getCurrentShell(), repository);
			if (dlg.open() == Window.OK) {
				result = dlg.getCredentials();
			}

			return result;
		}

		public void reportCredentialsFailure(final SecurityException e) {
			call(new Callable<Void>() {

				public Void call() {
					MessageDialog.openWarning(getCurrentShell(),
						Messages.DialogCredentialsProviderFactory_0, e.getLocalizedMessage());
					return null;
				}
			});
		}

		private <T> T call(final Callable<T> callable) {
			final Object[] result = new Object[1];

			final Shell parentShell = getCurrentShell();

			if (parentShell.getDisplay() == Display.getCurrent()) {
				try {
					result[0] = (T) callable.call();
				} catch (Exception e) {
					Activator.log.error(e);
				}
			} else {
				parentShell.getDisplay().syncExec(new Runnable() {

					public void run() {
						try {
							result[0] = callable.call();
						} catch (Exception e) {
							Activator.log.error(e);
						}
					}
				});
			}

			// this is safe according to the 'callable' type
			@SuppressWarnings("unchecked")
			T resultAsT = (T) result[0];

			return resultAsT;
		}
	}
}
