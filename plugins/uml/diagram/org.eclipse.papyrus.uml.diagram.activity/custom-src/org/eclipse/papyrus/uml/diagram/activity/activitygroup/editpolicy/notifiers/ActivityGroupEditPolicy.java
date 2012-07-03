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
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.IContainerNodeDescriptor;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.IGroupEditPolicies;

/**
 * The aim of the edit policy if to notify changes to the Group Framework for Activities Elements
 * 
 * @author arthur daussy
 * 
 */
public class ActivityGroupEditPolicy extends GroupNotifyingOnMoveEditPolicy {

	/**
	 * 
	 * @param groupDescriptor
	 *        IContainerNodeDescriptor
	 */
	public ActivityGroupEditPolicy(IContainerNodeDescriptor groupDescriptor) {
		super(groupDescriptor);
	}

	/**
	 * Override in order to:
	 * - prevent Move of more than one Activity Group
	 * - Initial Moving Edit Part State
	 */
	@Override
	public Command getCommand(Request request) {
		if(understandsRequest(request)) {
			if(request instanceof ChangeBoundsRequest) {
				ChangeBoundsRequest chRq = (ChangeBoundsRequest)request;
				int compt = 0;
				if(chRq.getEditParts() != null) {
					for(Object p : chRq.getEditParts()) {
						if(p instanceof EditPart) {
							EditPart part = (EditPart)p;
							EditPolicy policy = part.getEditPolicy(IGroupEditPolicies.GROUP_FRAMEWORK_NOTIFYING_ON_MOVE_EDIT_POLICY);
							if(policy instanceof ActivityGroupEditPolicy) {
								compt++;
							}
						}
					}
					if(compt > 1) {
						return UnexecutableCommand.INSTANCE;
					}
				}
				initMovingPartState(chRq);
				Command cmd = super.getCommand(request);
				stopMovingPartState(chRq);
				return cmd;
			}
		}
		return null;
	}

	@Override
	public boolean understandsRequest(Request req) {
		if(req instanceof ChangeBoundsRequest) {
			return true;
		}
		return false;
	}
}
