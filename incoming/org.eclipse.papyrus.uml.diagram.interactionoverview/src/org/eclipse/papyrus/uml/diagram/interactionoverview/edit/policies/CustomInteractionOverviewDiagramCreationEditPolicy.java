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

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.PapyrusCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.interactionoverview.part.Messages;

public class CustomInteractionOverviewDiagramCreationEditPolicy extends PapyrusCreationEditPolicy {

	public CustomInteractionOverviewDiagramCreationEditPolicy() {
	}

	@Override
	protected Command getCreateCommand(final CreateViewRequest request) {
		final Command superCommand = super.getCreateCommand(request);
		final List<? extends ViewDescriptor> viewDescriptors = request.getViewDescriptors();
		if(request instanceof CreateViewAndElementRequest && viewDescriptors.size() == 1) {
			final String semanticHint = viewDescriptors.get(0).getSemanticHint();
			if(Integer.toString(ActivityEditPart.VISUAL_ID).equals(semanticHint)) {
				final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(getHost().getModel());
				final CompoundCommand compoundCommand = new CompoundCommand(Messages.CustomInteractionOverviewDiagramCreationEditPolicy_CreateActivity);
				compoundCommand.add(superCommand);

				return compoundCommand;
			}
		}
		return superCommand;
	}
}
