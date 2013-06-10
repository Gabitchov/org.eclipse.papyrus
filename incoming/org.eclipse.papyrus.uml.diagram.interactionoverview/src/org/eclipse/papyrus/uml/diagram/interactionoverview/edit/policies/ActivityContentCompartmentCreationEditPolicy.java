/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.interactionoverview.edit.policies;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.PapyrusCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.interactionoverview.edit.commands.CreateSnapshotForInteractionFromViewDescriptorCommand;
import org.eclipse.papyrus.uml.diagram.interactionoverview.edit.part.CallBehaviorActionAsInteractionEditPart;
import org.eclipse.papyrus.uml.diagram.interactionoverview.part.Messages;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands.RefreshCommandForDo;


public class ActivityContentCompartmentCreationEditPolicy extends PapyrusCreationEditPolicy {


	@Override
	protected Command getCreateCommand(final CreateViewRequest request) {
		final ICommandProxy superCommand = (ICommandProxy)super.getCreateCommand(request);
		final List<? extends ViewDescriptor> viewDescriptors = request.getViewDescriptors();
		if(request instanceof CreateViewAndElementRequest && viewDescriptors.size() == 1) {
			final String semanticHint = viewDescriptors.get(0).getSemanticHint();
			if(Integer.toString(CallBehaviorActionAsInteractionEditPart.VISUAL_ID).equals(semanticHint)) {
				return getCreateCallBehaviorActionAsInteractionCommand(request, superCommand);
			}
		} else if(request instanceof CreateViewRequest && viewDescriptors.size() == 1) {
			final String semanticHint = viewDescriptors.get(0).getSemanticHint();
			if(Integer.toString(CallBehaviorActionAsInteractionEditPart.VISUAL_ID).equals(semanticHint)) {
				return getCreateCallBehaviorActionAsInteractionCommand(request, superCommand);
			}
		}
		return superCommand;
	}

	protected Command getCreateCallBehaviorActionAsInteractionCommand(final CreateViewRequest request, final ICommandProxy superCommand) {
		final CompoundCommand compoundCommand = new CompoundCommand(Messages.ActivityContentCompartmentCreationEditPolicy_CreateCallBehaviorActionAsInteractionCommand);
		compoundCommand.add(superCommand);
		compoundCommand.add(new ICommandProxy(CreateSnapshotForInteractionFromViewDescriptorCommand.create(superCommand.getICommand(), (GraphicalEditPart)getHost())));
		compoundCommand.add(new RefreshCommandForDo((org.eclipse.gef.GraphicalEditPart)getHost()));
		return compoundCommand;
	}

}
