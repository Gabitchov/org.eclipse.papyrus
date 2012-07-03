/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Arthur Daussy (Atos) - Initial API and implementation
 *   Arthur Daussy - 371712 : 372745: [ActivityDiagram] Major refactoring group framework
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.activitygroup.editpolicy.notifiers;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.GroupRequestAdvisor;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.IContainerNodeDescriptor;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.IGroupEditPolicies;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.IGroupRequestAdvisor;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.request.AbstractGroupRequest;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.utils.DebugUtils;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.utils.Utils;

/**
 * Implementation of {@link GroupListenerEditPolicy} for Activity Group
 * 
 * @author adaussy
 * 
 */
public class GroupNotifyingOnMoveEditPolicy extends GroupListenerEditPolicy {

	public GroupNotifyingOnMoveEditPolicy(IContainerNodeDescriptor groupDescriptor) {
		super(groupDescriptor);
	}

	/**
	 * Override to :
	 * -> Put in "Movin state" this edit part and all its children which are Group Framework concern
	 */
	@Override
	public Command getCommand(Request request) {
		if(request instanceof ChangeBoundsRequest) {
			final ChangeBoundsRequest req = (ChangeBoundsRequest)request;
			CompositeCommand cc = new CompositeCommand("GroupNotifyingEditPolicy ");
			for(final EditPart part : Utils.getTargetedEditPart(req)) {
				ICommand cmd = getGroupRequestAdvisor().notifyGroupFramework(new AbstractGroupRequest((IGraphicalEditPart)getHost(), Utils.getChangeBoundsRequestCopy(req, part), part, getTargetGroupDescriptor(part)) {

					public GroupRequestType getGroupRequestType() {
						return GroupRequestType.MOVE;
					}
				});
				if(cmd != null && cmd.canExecute()) {
					cc.compose(cmd);
				}
			}
			stopMovingPartState(req);
			if(cc != null && cc.canExecute()) {
				return new ICommandProxy(cc);
			}
		}
		return null;
	}

	/**
	 * Set the art concern by the request to "Moving state" {@link IGroupNotifier#isPartMoving()}
	 * 
	 * @param req
	 */
	public void stopMovingPartState(final ChangeBoundsRequest req) {
		Iterable<IGraphicalEditPart> targetedEditPart = Utils.getTargetedEditPart(req);
		stopMovingParts(targetedEditPart);
	}

	/**
	 * Set all part specify and its descendant to "Moving State"
	 * 
	 * @param targetedEditPart
	 */
	protected void stopMovingParts(Iterable<IGraphicalEditPart> targetedEditPart) {
		if(targetedEditPart != null) {
			for(EditPart part : targetedEditPart) {
				EditPolicy editPolicy = part.getEditPolicy(IGroupEditPolicies.GROUP_FRAMEWORK_NOTIFYING_ON_MOVE_EDIT_POLICY);
				if(editPolicy instanceof GroupNotifyingOnMoveEditPolicy) {
					GroupNotifyingOnMoveEditPolicy editPolicy2 = (GroupNotifyingOnMoveEditPolicy)editPolicy;
					if(DebugUtils.isDebugging()) {
						StringBuilder stringBuilder = new StringBuilder();
						stringBuilder.append(Utils.getCorrectLabel(editPolicy2.getEObject()));
						stringBuilder.append(" is stoping to move");
						DebugUtils.getLog().debug(stringBuilder.toString());
					}
					editPolicy2.stopMoving();
				}
				stopMovingParts(part.getChildren());
			}
		}
	}

	public void initMovingPartState(final ChangeBoundsRequest req) {
		Iterable<IGraphicalEditPart> targetedEditPart = Utils.getTargetedEditPart(req);
		startMovingParts(req, targetedEditPart);
	}

	protected void startMovingParts(final ChangeBoundsRequest req, Iterable<IGraphicalEditPart> targetedEditPart) {
		if(targetedEditPart != null) {
			for(final EditPart part : targetedEditPart) {
				EditPolicy editPolicy = part.getEditPolicy(IGroupEditPolicies.GROUP_FRAMEWORK_NOTIFYING_ON_MOVE_EDIT_POLICY);
				if(editPolicy instanceof GroupNotifyingOnMoveEditPolicy) {
					GroupNotifyingOnMoveEditPolicy editPolicy2 = (GroupNotifyingOnMoveEditPolicy)editPolicy;
					if(DebugUtils.isDebugging()) {
						StringBuilder stringBuilder = new StringBuilder();
						stringBuilder.append(Utils.getCorrectLabel(editPolicy2.getEObject()));
						stringBuilder.append(" is start to move");
						DebugUtils.getLog().debug(stringBuilder.toString());
					}
					editPolicy2.startMoving(req);
				}
				startMovingParts(req, part.getChildren());
			}
		}
	}

	protected IGroupRequestAdvisor getGroupRequestAdvisor() {
		return GroupRequestAdvisor.getInstance();
	}

	/**
	 * Override in order to accept correct request
	 */
	@Override
	public boolean understandsRequest(Request req) {
		if(req instanceof ChangeBoundsRequest) {
			return true;
		}
		return false;
	}
}
