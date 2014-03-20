/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.command;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.uml.diagram.clazz.custom.helper.CustomMultiAssociationHelper;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AssociationNodeEditPart;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

/**
 * This is the command in charge to delete the association and associated properties.
 */
public class DisplayAllAssociationBranchCommand implements IObjectActionDelegate {

	/** The selected element. */
	private AssociationNodeEditPart selectedElement;

	/**
	 * constructor of this command.
	 */
	public DisplayAllAssociationBranchCommand() {
		super();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void run(IAction action) {
		CustomMultiAssociationHelper multiAssociationHelper = new CustomMultiAssociationHelper(selectedElement.getEditingDomain());
		selectedElement.getDiagramEditDomain().getDiagramCommandStack().execute(multiAssociationHelper.displayAllBranchesCommand(selectedElement));
	}

	/**
	 * {@inheritedDoc}
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			Object selectedobject = ((IStructuredSelection) selection).getFirstElement();
			if (selectedobject instanceof AssociationNodeEditPart) {
				selectedElement = (AssociationNodeEditPart) selectedobject;
			}
		}
	}

	/**
	 * {@inheritedDoc}
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// TODO Auto-generated method stub
	}
}
