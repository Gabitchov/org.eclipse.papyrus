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
import org.eclipse.jface.action.Action;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;
import org.eclipse.papyrus.cdo.core.IPapyrusRepositoryManager;
import org.eclipse.papyrus.cdo.internal.core.PapyrusRepositoryManager;
import org.eclipse.papyrus.cdo.internal.ui.Activator;
import org.eclipse.papyrus.cdo.internal.ui.dialogs.AddRepositoryDialog;
import org.eclipse.papyrus.cdo.internal.ui.l10n.Messages;
import org.eclipse.ui.IWorkbenchPart;

/**
 * This is the AddRepositoryAction type. Enjoy.
 */
public class AddRepositoryAction
		extends Action {

	private IWorkbenchPart part;

	public AddRepositoryAction(IWorkbenchPart part) {
		super(Messages.AddRepositoryAction_0, Activator
			.getIcon(Activator.ICON_ADD_REPOSITORY));

		this.part = part;
	}

	@Override
	public void run() {
		AddRepositoryDialog dlg = new AddRepositoryDialog(part.getSite()
			.getShell());
		if (dlg.open() == Window.OK) {
			IPapyrusRepositoryManager mgr = PapyrusRepositoryManager.INSTANCE;
			String url = dlg.getURL();

			IPapyrusRepository repository = mgr.getRepository(url);

			if (repository == null) {
				repository = mgr.createRepository(url);
				repository.setName(dlg.getName());
			}

			mgr.saveRepositories();

			if (!repository.isConnected()) {
				final IPapyrusRepository _repository = repository;
				try {
					part.getSite().getWorkbenchWindow()
						.run(true, false, new IRunnableWithProgress() {

							public void run(IProgressMonitor monitor)
									throws InvocationTargetException,
									InterruptedException {

								_repository.connect();
							}
						});
				} catch (Exception e) {
					Activator.log.error(
						"Unexpected exception in async repository connection.", //$NON-NLS-1$
						e);
				}
			}
		}
	}
}
