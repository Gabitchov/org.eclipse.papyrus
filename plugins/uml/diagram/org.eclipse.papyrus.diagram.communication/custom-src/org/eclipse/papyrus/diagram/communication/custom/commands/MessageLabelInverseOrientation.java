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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.diagram.communication.edit.parts.LifelineEditPartCN;
import org.eclipse.papyrus.diagram.communication.edit.parts.MessageNameEditPart;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;



/**
 * The Class MessageLabelInverseOrientation is intended to reverse the orientation of the message arrow
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

		//The source Lifeline of the connection
		source = (EObject)((LifelineEditPartCN)((ConnectionEditPart)selectedElement.getParent()).getSource()).resolveSemanticElement();
		//The target Lifeline of the connection
		target = (EObject)((LifelineEditPartCN)((ConnectionEditPart)selectedElement.getParent()).getTarget()).resolveSemanticElement();



		//if the selected element is a label that represents a message
		if(selectedElement.resolveSemanticElement() instanceof Message) {
			//request to change the source by the target (semantically)

			ReorientRelationshipRequest req = null;

			//request to change the target by the source (semantically)

			ReorientRelationshipRequest req2 = null;

			//create a command to execute the request req

			CustomMessageReorientCommand reorientcommandSrc = null;

			//create a command to execute the request req2

			CustomMessageReorientCommand reorientcommandTarget = null;


			Message message = (Message)selectedElement.resolveSemanticElement();
			MessageEnd sendEvent = message.getSendEvent();
			MessageEnd rcvEvent = message.getReceiveEvent();

			EList<InteractionFragment> listSrc = ((Lifeline)source).getCoveredBys();



			//get the source and target lifelines of the message
			EObject srcLifeline = null;
			EObject targetLifeline = null;
			if(!listSrc.isEmpty()) {
				done: for(int i = 0; i < listSrc.size(); i++) {
					if(listSrc.get(i).equals(rcvEvent)) {
						srcLifeline = target;
						targetLifeline = source;
						break done;

					} else if(listSrc.get(i).equals(sendEvent)) {
						srcLifeline = source;
						targetLifeline = target;

						break done;

					}
				}
				//request to change the source by the target (semantically)
				req = new ReorientRelationshipRequest(domain, (EObject)message, targetLifeline, srcLifeline, 1);

				//request to change the target by the source (semantically)
				req2 = new ReorientRelationshipRequest(domain, (EObject)message, srcLifeline, targetLifeline, 2);

				//create a command to execute the request req
				reorientcommandSrc = new CustomMessageReorientCommand(req);

				//create a command to execute the request req2
				reorientcommandTarget = new CustomMessageReorientCommand(req2);


				//only change semantically the source and target of the message			
				command.add(new ICommandProxy(reorientcommandSrc));

				command.add(new ICommandProxy(reorientcommandTarget));


			}
			//Execute the command
			selectedElement.getDiagramEditDomain().getDiagramCommandStack().execute(command);

			((IGraphicalEditPart)selectedElement).refresh();

		}
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
	 * Gets the UML message.
	 * 
	 * @return the UML message
	 */
	protected Message getMessage() {
		return (Message)selectedElement.resolveSemanticElement();
	}

}
