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
package org.eclipse.papyrus.diagram.clazz.custom.command;

import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.diagram.clazz.custom.helper.MultiAssociationHelper;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationNodeEditPart;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

/**
 * This is the command in charge to supress the association and associated
 * properties
 * 
 * @author Patrick Tessier
 */
public class DisplayAllAssociationBranchCommand implements
		IObjectActionDelegate {

	private AssociationNodeEditPart selectedElement;

	/**
	 * constructor of this command
	 * 
	 * @param request
	 *            see {@link DestroyElementRequest}
	 */
	public DisplayAllAssociationBranchCommand() {
		super();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void run(IAction action) {
		MultiAssociationHelper multiAssociationHelper = new MultiAssociationHelper(
				selectedElement.getEditingDomain());
		selectedElement.getDiagramEditDomain().getDiagramCommandStack()
				.execute(
						multiAssociationHelper
								.displayAllBranchesCommand(selectedElement));
	}

	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			Object selectedobject = ((IStructuredSelection) selection)
					.getFirstElement();
			if (selectedobject instanceof AssociationNodeEditPart) {
				selectedElement = (AssociationNodeEditPart) selectedobject;
			}
		}
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// TODO Auto-generated method stub

	}
}
