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

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.cdo.core.CommitException;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;
import org.eclipse.papyrus.cdo.core.IPapyrusRepositoryManager;
import org.eclipse.papyrus.cdo.internal.core.PapyrusRepositoryManager;
import org.eclipse.papyrus.cdo.internal.ui.l10n.Messages;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.statushandlers.IStatusAdapterConstants;
import org.eclipse.ui.statushandlers.StatusAdapter;
import org.eclipse.ui.statushandlers.StatusManager;

/**
 * This is the RemoveRepositoryAction type. Enjoy.
 */
public class RemoveRepositoryAction
		extends AbstractRepositoryAction {

	public RemoveRepositoryAction(IWorkbenchPart part) {
		super(Messages.RemoveRepositoryAction_0, ISharedImages.IMG_TOOL_DELETE,
			ISharedImages.IMG_TOOL_DELETE_DISABLED, part);
		
		setActionDefinitionId(IWorkbenchCommandConstants.EDIT_DELETE);
	}

	@Override
	protected boolean isEnabledFor(IPapyrusRepository repository) {
		return true;
	}

	@Override
	protected void run(IPapyrusRepository repository) {
		boolean connected = repository.isConnected();

		String message = connected
			? Messages.RemoveRepositoryAction_1
			: Messages.RemoveRepositoryAction_2;

		if (MessageDialog.openQuestion(getPart().getSite().getShell(),
			Messages.RemoveRepositoryAction_3, NLS.bind(message, repository.getName()))) {
			IPapyrusRepositoryManager mgr = PapyrusRepositoryManager.INSTANCE;

			if (!connected) {
				// just remove it. Easy
				mgr.removeRepository(repository);
				mgr.saveRepositories();
			} else {
				try {
					repository.disconnect();

					// don't proceed with removing the repository if disconnect
					// failed
					mgr.removeRepository(repository);
					mgr.saveRepositories();
				} catch (CommitException e) {
					StatusAdapter adapter = new StatusAdapter(e.getStatus());
					adapter.setProperty(IStatusAdapterConstants.TITLE_PROPERTY,
						Messages.RemoveRepositoryAction_4);
					StatusManager.getManager().handle(adapter,
						StatusManager.SHOW);
				}
			}
		}
	}
}
