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
package org.eclipse.papyrus.cdo.internal.ui.actions;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.papyrus.cdo.core.CommitException;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;
import org.eclipse.papyrus.cdo.internal.ui.Activator;
import org.eclipse.papyrus.cdo.internal.ui.l10n.Messages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.statushandlers.IStatusAdapterConstants;
import org.eclipse.ui.statushandlers.StatusAdapter;
import org.eclipse.ui.statushandlers.StatusManager;

/**
 * This is the ConnectRepositoryAction type. Enjoy.
 */
public class DisconnectRepositoryAction
		extends AbstractRepositoryAction {

	public DisconnectRepositoryAction(IWorkbenchPart part) {
		super(Messages.DisconnectRepositoryAction_0, Activator
			.getIcon(Activator.ICON_DISCONNECT_REPOSITORY_ENABLED), Activator
			.getIcon(Activator.ICON_DISCONNECT_REPOSITORY_DISABLED), part);
	}

	@Override
	protected boolean isEnabledFor(IPapyrusRepository repository) {
		return repository.isConnected();
	}

	@Override
	protected void run(final IPapyrusRepository repository) {
		final CommitException[] commitFailure = new CommitException[1];

		try {
			getPart().getSite().getWorkbenchWindow()
				.run(true, false, new IRunnableWithProgress() {

					public void run(IProgressMonitor monitor)
							throws InvocationTargetException,
							InterruptedException {

						try {
							repository.disconnect();
						} catch (CommitException e) {
							commitFailure[0] = e;
						}
					}
				});
		} catch (Exception e) {
			Activator.log.error(
				"Unexpected exception in async repository connection.", e); //$NON-NLS-1$
		}

		if (commitFailure[0] != null) {
			StatusAdapter adapter = new StatusAdapter(
				commitFailure[0].getStatus());
			adapter.setProperty(IStatusAdapterConstants.TITLE_PROPERTY,
				Messages.DisconnectRepositoryAction_2);
			StatusManager.getManager().handle(adapter, StatusManager.SHOW);
		}
	}
}
