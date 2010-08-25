/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib saadia.dhouib@cea.fr  - Adapted from Composite Structure Diagram
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.communication.custom.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionAnchorsCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionEndsCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.diagram.communication.custom.messages.Messages;
import org.eclipse.papyrus.diagram.communication.edit.parts.LifelineEditPartCN;
import org.eclipse.papyrus.diagram.communication.edit.parts.MessageNameEditPart;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.uml2.uml.Message;



/**
 * The Class MessageLabelInverseOrientation.
 */
public class MessageLabelInverseOrientation implements IObjectActionDelegate {


	/** The selected element. */
	private MessageNameEditPart selectedElement;



	/** The source. */
	private EObject source;

	/** The target. */
	private EObject target;


	/**
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 * 
	 * @param action
	 */

	public void run(IAction action) {

		CompoundCommand command = new CompoundCommand();
		TransactionalEditingDomain domain = ((IGraphicalEditPart)selectedElement.getParent()).getEditingDomain();

		//The source Lifeline of the message
		source = (EObject)((LifelineEditPartCN)((ConnectionEditPart)selectedElement.getParent()).getSource()).resolveSemanticElement();
		//The target Lifeline of the message
		target = (EObject)((LifelineEditPartCN)((ConnectionEditPart)selectedElement.getParent()).getTarget()).resolveSemanticElement();

		//request to change the source by the target (semantically)
		ReorientRelationshipRequest req = new ReorientRelationshipRequest(domain, getLink(), target, source, 1);

		//request to change the target by the source (semantically)
		ReorientRelationshipRequest req2 = new ReorientRelationshipRequest(domain, getLink(), source, target, 2);

		//create a command to execute the request req
		CustomMessageReorientCommand reorientcommandSrc = new CustomMessageReorientCommand(req);

		//create a command to execute the request req2
		CustomMessageReorientCommand reorientcommandTarget = new CustomMessageReorientCommand(req2);


		//Create two command to change graphically the orientation of the message
		//the first command is to reverse the connection ends
		//the second command is to reverse the connection anchors
		org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionEndsCommand setconnectionendscommand = new SetConnectionEndsCommand(domain, Messages.MessageLabelInverseOrientation_setconnectionends);
		org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionAnchorsCommand setconnectionanchorscommand = new SetConnectionAnchorsCommand(domain, Messages.MessageLabelInverseOrientation_setconnectionanchors);
		setconnectionendscommand.setEdgeAdaptor(selectedElement.getParent());
		setconnectionendscommand.setNewSourceAdaptor(((ConnectionEditPart)selectedElement.getParent()).getTarget());
		setconnectionendscommand.setNewTargetAdaptor(((ConnectionEditPart)selectedElement.getParent()).getSource());

		setconnectionanchorscommand.setEdgeAdaptor(selectedElement);
		Edge edge = (Edge)selectedElement.getParent().getModel();
		IdentityAnchor aSrc = (IdentityAnchor)edge.getSourceAnchor();
		IdentityAnchor aTarget = (IdentityAnchor)edge.getTargetAnchor();
		if(aTarget != null) {
			setconnectionanchorscommand.setNewSourceTerminal(aTarget.getId());
		}
		if(aSrc != null) {
			setconnectionanchorscommand.setNewTargetTerminal(aSrc.getId());
		}

		command.add(new ICommandProxy(reorientcommandSrc));

		command.add(new ICommandProxy(reorientcommandTarget));

		command.add(new ICommandProxy(setconnectionendscommand));

		command.add(new ICommandProxy(setconnectionanchorscommand));

		//Execute the command
		selectedElement.getDiagramEditDomain().getDiagramCommandStack().execute(command);
	}


	/**
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
	 * 
	 * @param action
	 * @param selection
	 */

	public void selectionChanged(IAction action, ISelection selection) {
		if(selection instanceof IStructuredSelection) {
			Object selectedobject = ((IStructuredSelection)selection).getFirstElement();
			if(selectedobject instanceof MessageNameEditPart) {
				selectedElement = (MessageNameEditPart)selectedobject;
				//link = (Message)selectedElement.resolveSemanticElement();
			}
		}

	}

	/**
	 * @see org.eclipse.ui.IObjectActionDelegate#setActivePart(org.eclipse.jface.action.IAction, org.eclipse.ui.IWorkbenchPart)
	 * 
	 * @param action
	 * @param targetPart
	 */

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// TODO Auto-generated method stub

	}

	/**
	 * Gets the link.
	 * 
	 * @return the link
	 */
	protected Message getLink() {
		return (Message)((ConnectionEditPart)selectedElement.getParent()).resolveSemanticElement();
	}

}
