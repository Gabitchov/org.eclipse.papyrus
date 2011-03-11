/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.groups.edit.policies;


import java.util.List;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.groups.commands.ChangeGraphicalParentCommand;
import org.eclipse.papyrus.diagram.common.groups.core.utils.Utils;
import org.eclipse.papyrus.diagram.common.groups.utils.GroupRequestConstants;

/**
 * This edit policy is used to handle node positioning inside a group after creation.
 * You can find example of uses of this policy in {@link org.eclipse.papyrus.diagram.activity.edit.policies.CompartmentXYLayoutEditPolicy} or in
 * {@link org.eclipse.papyrus.diagram.activity.edit.parts.ActivityPartitionActivityPartitionContentCompartmentEditPart}
 * 
 * @author arthur daussy
 */
public class XYLayoutEditGroupPolicy extends XYLayoutEditPolicy {


	/**
	 * overrife this method in order to take into account the difference between graphical parent and model parent.
	 * If there are different there is a delta to compute and the figure has to be translated.
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy#getConstraintFor(org.eclipse.gef.requests.CreateRequest)
	 * @param request
	 * @return
	 */
	@Override
	protected Object getConstraintFor(CreateRequest request) {
		if(request.getExtendedData().containsKey(CreateInGroupEditPolicy.GRAPHICAL_PARENT) && request.getExtendedData().containsKey(CreateInGroupEditPolicy.NEW_PARENT_HOST)) {
			IGraphicalEditPart graphicalParent = (IGraphicalEditPart)request.getExtendedData().get(CreateInGroupEditPolicy.GRAPHICAL_PARENT);
			IGraphicalEditPart newHost = (IGraphicalEditPart)request.getExtendedData().get(CreateInGroupEditPolicy.NEW_PARENT_HOST);
			Dimension delta = Utils.computeDeltaToChangeParent(newHost, graphicalParent);
			Rectangle rectangle = (Rectangle)super.getConstraintFor(request);
			rectangle.translate(delta.width, delta.height);
			return (Object)rectangle;
		}
		return super.getConstraintFor(request);
	}

	/**
	 * Override the super method in order to disable the command if the command has already been created on another edit part
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy#getCommand(org.eclipse.gef.Request)
	 * 
	 * @param request
	 *        Global Request
	 * @return Command
	 */
	@Override
	public Command getCommand(Request request) {
		if(understandsRequest(request)) {
			return super.getCommand(request);
		}
		return null;
	}

	/**
	 * Override to be able to prevent several execution of the CreateCommand
	 * The Create command will only be used if the new host parent is in the request
	 * 
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#understandsRequest(org.eclipse.gef.Request)
	 * 
	 * @param req
	 *        Global request
	 * @return
	 */
	@Override
	public boolean understandsRequest(Request req) {
		return canHandleCreateRequestOnlyIfNewParent(req, (IGraphicalEditPart)getHost());
	}

	/**
	 * Return true except if the request is a create request in which {@link CreateInGroupEditPolicy#OLD_PARENT} and
	 * {@link CreateInGroupEditPolicy#NEW_PARENT_HOST} are set and are different
	 * 
	 * @param req
	 *        The global request
	 * @param getHost
	 *        The host on the edit policy
	 * @return True if can execute
	 */
	public static boolean canHandleCreateRequestOnlyIfNewParent(Request req, IGraphicalEditPart getHost) {
		//If there is a NEW_PARENT_HOST data then its means than the command has been asked to another edit part before
		//	If this host is the new host then it executes the create command
		//	Else do nothing
		//Else the command will not be asked to another EditPart so I have to execute it
		if(req.getExtendedData().containsKey(CreateInGroupEditPolicy.NEW_PARENT_HOST)) {
			IGraphicalEditPart newParent = (IGraphicalEditPart)req.getExtendedData().get(CreateInGroupEditPolicy.NEW_PARENT_HOST);
			if(((getHost).equals(newParent))) {
				return true;
			} else {
				return false;
			}
		}
		return true;
	}

	/**
	 * TODO make the javadoc
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy#getCreateCommand(org.eclipse.gef.requests.CreateRequest)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected Command getCreateCommand(CreateRequest request) {
		if(request.getExtendedData().containsKey(GroupRequestConstants.GRAPHICAL_CHILDREN)) {
			TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
			Command createCommand = super.getCreateCommand(request);
			CompositeCommand compositeCreateCmd = new CompositeCommand(createCommand.getLabel());
			compositeCreateCmd.compose(new CommandProxy(createCommand));
			List<IGraphicalEditPart> automaticChildren = (List<IGraphicalEditPart>)request.getExtendedData().get(GroupRequestConstants.GRAPHICAL_CHILDREN);
			for(IGraphicalEditPart child : automaticChildren) {
				if (child instanceof IGraphicalEditPart){					
					String label = createCommand + ": Change child graphical parent";
					ChangeGraphicalParentCommand cmd = new ChangeGraphicalParentCommand(editingDomain, label, request, child);
					if (cmd != null){
						compositeCreateCmd.compose(cmd);					
					}
				}
			}
			return new ICommandProxy(compositeCreateCmd);
		}
		return super.getCreateCommand(request);
	}





}
