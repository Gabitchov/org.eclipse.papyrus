/*****************************************************************************
 * Copyright (c) 2010, 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - Factor out workspace storage for pluggable storage providers (CDO)
 *****************************************************************************/
package org.eclipse.papyrus.customization.properties.ui;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.papyrus.customization.properties.Activator;
import org.eclipse.papyrus.customization.properties.storage.actions.IContextCopyAction;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.runtime.ConfigurationManager;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.statushandlers.StatusManager;

/**
 * An action to build a new Property view context from an existing one.
 * 
 * @author Camille Letavernier
 */
public class CopyContextAction {

	private IContextCopyAction delegate;

	public CopyContextAction(IContextCopyAction delegate) {
		super();

		this.delegate = delegate;
	}

	/**
	 * Copy an existing context to a new one with the given name.
	 * The new context is registered to the {@link ConfigurationManager}.
	 * To enable the edition of the context, an invisible project is created
	 * in the workspace. The files are stored in the runtime plugin's preference
	 * folder.
	 * 
	 * @param source
	 *        The source Context to copy
	 * @param targetName
	 *        The name of the new context
	 * @param activate
	 *        If true, the new context will be activated and available immediately,
	 *        while the previous one will be disabled to avoid conflicts
	 * @return
	 *         The new Context or {@code null} if it was not created (because of error or user cancellation
	 */
	public Context copy(final Context source, final String targetName, final boolean activate) {
		final Context[] result = { null };

		ProgressMonitorDialog dialog = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());
		try {
			dialog.run(true, true, new IRunnableWithProgress() {

				@Override
				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					try {
						result[0] = delegate.copy(source, targetName, monitor);

						if(result[0] != null) {
							ConfigurationManager.getInstance().addContext(result[0], activate);
							if(activate) {
								ConfigurationManager.getInstance().disableContext(source, true);
							}
						}
					} catch (CoreException ex) {
						throw new InvocationTargetException(ex);
					}
				}

			});
		} catch (InvocationTargetException ex) {
			if(ex.getTargetException() instanceof CoreException) {
				CoreException ce = (CoreException)ex.getTargetException();
				Activator.log.error(ce);
				StatusManager.getManager().handle(ce.getStatus(), StatusManager.SHOW);
			} else {
				Activator.log.error(ex);
			}
		} catch (InterruptedException ex) {
			Activator.log.error(ex);
		}

		return result[0];
	}
}
