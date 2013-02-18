/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.modelexplorer.handlers;

import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.commands.DestroyElementPapyrusCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;

/**
 * Handler for the delete Diagram action
 * 
 * 
 * 
 */
public class DeleteDiagramHandler extends AbstractDiagramCommandHandler {


	/**
	 * 
	 * @see org.eclipse.papyrus.views.modelexplorer.handler.AbstractCommandHandler#getCommand()
	 * 
	 * @return
	 */
	@Override
	protected Command getCommand() {
		TransactionalEditingDomain editingDomain = getEditingDomain();
		final IPageManager pageManager = getPageManager();

		List<Diagram> diagrams = getSelectedDiagrams();

		if(editingDomain != null && pageManager != null && !diagrams.isEmpty()) {
			CompoundCommand command = new CompoundCommand();

			for(final Diagram diagram : diagrams) {

				Command sashRemoveComd = new RecordingCommand(editingDomain, "Remove page") {

					@Override
					protected void doExecute() {
						pageManager.removePage(diagram);
					}

				};
				// the destroy element command is a good way to destroy the cross reference
				command.append(sashRemoveComd);
				command.append(new GMFtoEMFCommandWrapper(new DestroyElementPapyrusCommand(new DestroyElementRequest(diagram, false))));
			}
			return command.isEmpty() ? UnexecutableCommand.INSTANCE : command;
		}
		return UnexecutableCommand.INSTANCE;
	}
}
