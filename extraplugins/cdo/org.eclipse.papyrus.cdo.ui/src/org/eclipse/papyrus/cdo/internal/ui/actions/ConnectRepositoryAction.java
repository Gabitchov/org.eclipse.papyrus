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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.operation.IRunnableWithProgress;
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
public class ConnectRepositoryAction extends AbstractRepositoryAction {

	public ConnectRepositoryAction(IWorkbenchPart part) {
		super(Messages.ConnectRepositoryAction_0, Activator.getIcon(Activator.ICON_CONNECT_REPOSITORY_ENABLED), Activator.getIcon(Activator.ICON_CONNECT_REPOSITORY_DISABLED), part);
	}

	@Override
	protected boolean isEnabledFor(IPapyrusRepository repository) {
		return !repository.isConnected();
	}

	@Override
	public void run(final IPapyrusRepository repository) {
		try {
			getPart().getSite().getWorkbenchWindow().run(true, false, new IRunnableWithProgress() {

				@Override
				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {

					IStatus status = repository.connect();
					if(status.matches(IStatus.WARNING | IStatus.ERROR)) {
						StatusAdapter adapter = new StatusAdapter(status);
						adapter.setProperty(IStatusAdapterConstants.TIMESTAMP_PROPERTY, System.currentTimeMillis());
						adapter.setProperty(IStatusAdapterConstants.TITLE_PROPERTY, Messages.ConnectRepositoryAction_errorTitle);
						StatusManager.getManager().handle(adapter, StatusManager.SHOW);
					}
				}
			});
		} catch (Exception e) {
			Activator.log.error("Unexpected exception in async repository connection.", e); //$NON-NLS-1$
		}
	}
}
