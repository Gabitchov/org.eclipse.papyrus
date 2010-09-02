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
 *  Saadia Dhouib saadia.dhouib@cea.fr  - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.diagram.communication.custom.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionAnchorsCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionEndsCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.diagram.communication.custom.messages.Messages;
import org.eclipse.papyrus.diagram.communication.edit.parts.LifelineEditPartCN;
import org.eclipse.papyrus.diagram.communication.edit.parts.MessageEditPart;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.uml2.uml.Message;



/**
 * The Class MessageInverseOrientation permits to inverse the orientation of a message.
 */
public class MessageInverseOrientation implements IObjectActionDelegate {

	/** The selected element. */
	private MessageEditPart selectedElement;

	/** The source. */
	private EObject source;

	/** The target. */
	private EObject target;


	/**
	 * Instantiates a new message inverse orientation.
	 */
	public MessageInverseOrientation() {
	}



	/**
	 * Run.
	 * 
	 * @param action
	 *        the action
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */

	public void run(IAction action) {
		// TODO Auto-generated method stub
		CompoundCommand command = new CompoundCommand();
		TransactionalEditingDomain domain = selectedElement.getEditingDomain();

		//The source Lifeline of the message
		source = ((LifelineEditPartCN)selectedElement.getSource()).resolveSemanticElement();
		//The target Lifeline of the message
		target = ((LifelineEditPartCN)selectedElement.getTarget()).resolveSemanticElement();

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
		org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionEndsCommand setconnectionendscommand = new SetConnectionEndsCommand(domain, Messages.MessageInverseOrientation_setconnectionends);
		org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionAnchorsCommand setconnectionanchorscommand = new SetConnectionAnchorsCommand(domain, Messages.MessageInverseOrientation_setconnectionanchors);
		setconnectionendscommand.setEdgeAdaptor(selectedElement);
		setconnectionendscommand.setNewSourceAdaptor(selectedElement.getTarget());
		setconnectionendscommand.setNewTargetAdaptor(selectedElement.getSource());

		setconnectionanchorscommand.setEdgeAdaptor(selectedElement);
		Edge edge = (Edge)selectedElement.getModel();
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
	 * Gets the link.
	 * 
	 * @return the link
	 */
	protected Message getLink() {
		return (Message)selectedElement.resolveSemanticElement();

	}

	/**
	 * Selection changed.
	 * 
	 * @param action
	 *        the action
	 * @param selection
	 *        the selection
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
	 */

	public void selectionChanged(IAction action, ISelection selection) {
		if(selection instanceof IStructuredSelection) {
			Object selectedobject = ((IStructuredSelection)selection).getFirstElement();
			if(selectedobject instanceof MessageEditPart) {
				selectedElement = (MessageEditPart)selectedobject;
				//link = (Message)selectedElement.resolveSemanticElement();
			}
		}

	}

	/**
	 * Sets the active part.
	 * 
	 * @param action
	 *        the action
	 * @param targetPart
	 *        the target part
	 * @see org.eclipse.ui.IObjectActionDelegate#setActivePart(org.eclipse.jface.action.IAction, org.eclipse.ui.IWorkbenchPart)
	 */

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// TODO Auto-generated method stub

	}

}
