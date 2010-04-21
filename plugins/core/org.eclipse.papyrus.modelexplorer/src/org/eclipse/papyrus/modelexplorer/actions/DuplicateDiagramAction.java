/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.modelexplorer.actions;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.action.Action;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.modelexplorer.Activator;
import org.eclipse.papyrus.sasheditor.contentprovider.di.IPageMngr;

/**
 * Action used to duplicate the given diagram
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class DuplicateDiagramAction extends Action {

	Diagram diagram;

	IPageMngr pageMngr;

	public DuplicateDiagramAction(IPageMngr pageMngr, Diagram diagram) {
		this.diagram = diagram;
		this.pageMngr = pageMngr;

		setImageDescriptor(Activator
				.getImageDescriptor("icons/etool16/duplicate.png"));
		setText("Duplicate");
		setEnabled(true);
	}

	/**
	 * Duplicate the given diagram
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		TransactionalEditingDomain editingDomain = EditorUtils
				.getTransactionalEditingDomain();
		if (editingDomain != null) {

			// Create a compound command containing removing of the sash and
			// removing from GMF
			// resource.
			CompoundCommand command = new CompoundCommand();

			// Clone the current diagram
			final Diagram newDiagram = (Diagram) EcoreUtil.copy(diagram);
			// Give a new name
			newDiagram.setName("Copy of " + diagram.getName());

			Command addGmfDiagramCmd = new AddCommand(editingDomain, diagram
					.eResource().getContents(), newDiagram);
			// EMFCommandOperation operation = new
			// EMFCommandOperation(editingDomain,
			// addGmfDiagramCmd);

			Command sashOpenComd = new RecordingCommand(editingDomain) {

				@Override
				protected void doExecute() {
					pageMngr.openPage(newDiagram);
				}
			};

			// TODO : synchronize with Cedric
			// command.append(operation.getCommand());
			command.append(addGmfDiagramCmd);
			command.append(sashOpenComd);
			// Execute changes through a Command so that Undo/Redo is supported
			editingDomain.getCommandStack().execute(command);

		}

	}

}
