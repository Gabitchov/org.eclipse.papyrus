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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.infra.gmfdiag.modelexplorer.messages.Messages;

/**
 * This handler provides the duplicate action for the diagrams
 * 
 * 
 * 
 */
public class DuplicateDiagramHandler extends AbstractDiagramCommandHandler {

	/**
	 * 
	 * @see org.eclipse.papyrus.views.modelexplorer.handler.AbstractCommandHandler#getCommand()
	 * 
	 * @return
	 */
	@Override
	protected Command getCommand() {
		TransactionalEditingDomain editingDomain = getEditingDomain();
		final IPageMngr pageManager = getPageManager();
		List<Diagram> diagrams = getSelectedDiagrams();

		if(editingDomain != null && pageManager != null && !diagrams.isEmpty()) {
			CompoundCommand command = new CompoundCommand();
			for(Diagram diagram : diagrams) {

				// Clone the current diagram
				final Diagram newDiagram = EcoreUtil.copy(diagram);
				// Give a new name
				newDiagram.setName(NLS.bind(Messages.DuplicateDiagramHandler_CopyOf, diagram.getName()));
				Command addGmfDiagramCmd = new AddCommand(editingDomain, diagram.eResource().getContents(), newDiagram);
				// EMFCommandOperation operation = new
				// EMFCommandOperation(editingDomain,
				// addGmfDiagramCmd);

				Command sashOpenComd = new RecordingCommand(editingDomain) {

					@Override
					protected void doExecute() {
						pageManager.openPage(newDiagram);
					}
				};

				// TODO : synchronize with Cedric
				// command.append(operation.getCommand());
				command.append(addGmfDiagramCmd);
				command.append(sashOpenComd);
			}
			return command.isEmpty() ? UnexecutableCommand.INSTANCE : command;
		}
		return UnexecutableCommand.INSTANCE;
	}
}
