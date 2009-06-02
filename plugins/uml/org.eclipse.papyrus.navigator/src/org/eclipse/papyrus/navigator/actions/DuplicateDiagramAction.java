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
package org.eclipse.papyrus.navigator.actions;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.EMFCommandOperation;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.action.Action;
import org.eclipse.papyrus.navigator.internal.Activator;
import org.eclipse.papyrus.navigator.internal.utils.NavigatorUtils;

/**
 * Action used to duplicate the given diagram
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class DuplicateDiagramAction extends Action {

	Diagram diagram;

	public DuplicateDiagramAction(Diagram diagram) {
		this.diagram = diagram;
		setImageDescriptor(Activator.getImageDescriptor("icons/etool16/duplicate.png"));
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
		TransactionalEditingDomain editingDomain = NavigatorUtils.getTransactionalEditingDomain();
		if (editingDomain != null) {
			// Clone the current diagram
			Diagram clonedDiagram = (Diagram) EcoreUtil.copy(diagram);
			// Give a new name
			clonedDiagram.setName("Copy of " + diagram.getName());

			Command command = new AddCommand(editingDomain, diagram.eResource().getContents(), clonedDiagram);
			EMFCommandOperation operation = new EMFCommandOperation(editingDomain, command);
			// Execute changes through a Command so that Undo/Redo is supported
			editingDomain.getCommandStack().execute(operation.getCommand());

		}

	}

}
