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
 *  Saadia Dhouib saadia.dhouib@cea.fr  
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.communication.custom.util;

import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.commands.SetConnectionBendpointsCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.helper.ElementHelper;
import org.eclipse.papyrus.diagram.communication.custom.commands.CustomMessageSemanticCreateCommand;
import org.eclipse.papyrus.diagram.communication.custom.commands.CustomMessageViewCreateCommand;

// TODO: Auto-generated Javadoc
/**
 * The class MessageHelper to manage creating messages as labels of only one connection.
 */

public class MessageHelper extends ElementHelper {

	/**
	 * Instantiates a new message helper.
	 * 
	 * @param editDomain
	 *        the edit domain
	 */
	public MessageHelper(TransactionalEditingDomain editDomain) {
		super();
		this.editDomain = editDomain;
	}


	/**
	 * Gets the command.
	 * 
	 * @param createConnectionViewAndElementRequest
	 *        the create connection view and element request
	 * @param command
	 *        the command
	 * @param link
	 *        the link
	 * @return the command
	 */
	public Command getCommand(CreateConnectionViewAndElementRequest createConnectionViewAndElementRequest, Command command, ConnectionEditPart link) {
		// 0. creation of variables
		command = new CompoundCommand();
		EditPart sourceEditPart = createConnectionViewAndElementRequest.getSourceEditPart();
		EditPart targetEditPart = createConnectionViewAndElementRequest.getTargetEditPart();

		Point sourceLocation = null;
		Point targetLocation = null;
		Point nodeLocation = null;

		//	NamedElement messageSemanticElement = null;// message that will be added as a label of the existing connection
		//	IAdaptable message = null;
		//View parentView = null;

		// 1. initialization
		ICommandProxy startcommand = ((ICommandProxy)createConnectionViewAndElementRequest.getStartCommand());
		Iterator<?> ite = ((CompositeCommand)startcommand.getICommand()).iterator();

		while(ite.hasNext()) {
			ICommand currentCommand = (ICommand)ite.next();
			if(currentCommand instanceof SetConnectionBendpointsCommand) {
				sourceLocation = ((SetConnectionBendpointsCommand)currentCommand).getSourceRefPoint();
				targetLocation = ((SetConnectionBendpointsCommand)currentCommand).getTargetRefPoint();
				nodeLocation = new Point((sourceLocation.x + targetLocation.x) / 2, (sourceLocation.y + targetLocation.y) / 2);

			}
		}
		//nodeLocation.x = (sourceLocation.x + targetLocation.x) / 2;
		//nodeLocation.y = (sourceLocation.y + targetLocation.y) / 2;
		// ---------------------------------------------------------
		// help to debug
		// System.err.println("+ 1. initialization");
		//System.err.println("+-> sourceLocation:" + sourceLocation);
		//System.err.println("+-> targetLocation:" + targetLocation);
		// System.err.println("+-> dependencyView:" + dependencyView);
		// System.err.println("+-> dependency:" + dependency);
		//System.err.println("+-> nodeLocation:" + nodeLocation);
		// System.err.println("+-> newSemanticElement:" + newSemanticElement);
		// System.err.println("+-> feature:" + feature);
		// System.err.println("+-> parentView:" + parentView);
		// ---------------------------------------------------------

		//2. Aggregates the semantic creation command

		EObject targetlifeline = (EObject)((View)targetEditPart.getModel()).getElement();
		EObject sourcelifeline = (EObject)((View)sourceEditPart.getModel()).getElement();
		CreateElementRequestAdapter requestAdapter = ((CreateConnectionViewAndElementRequest)createConnectionViewAndElementRequest).getConnectionViewAndElementDescriptor().getCreateElementRequestAdapter();
		CreateRelationshipRequest createElementRequest = (CreateRelationshipRequest)requestAdapter.getAdapter(CreateRelationshipRequest.class);
		CustomMessageSemanticCreateCommand customMessageCreateComand = new CustomMessageSemanticCreateCommand(createElementRequest, sourcelifeline, targetlifeline);
		Command realSemanticCommand = new ICommandProxy(customMessageCreateComand);
		((CompoundCommand)command).add(realSemanticCommand);


		//3. Aggregates the create node command
		//parentView = (View)((View)sourceEditPart.getModel()).eContainer();

		CustomMessageViewCreateCommand nodeCreation = new CustomMessageViewCreateCommand(getEditingDomain(), (EditPartViewer)sourceEditPart.getViewer(), ((IGraphicalEditPart)sourceEditPart).getDiagramPreferencesHint(), nodeLocation, (IAdaptable)((ICommand)customMessageCreateComand).getCommandResult().getReturnValue(), link);

		((CompoundCommand)command).add(new ICommandProxy(nodeCreation));

		//return the command that contains the semantic creation and the view creation
		return command;
	}



}
