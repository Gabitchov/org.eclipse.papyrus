/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.policies;

import java.util.List;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.PapyrusCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.timing.custom.Messages;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands.RefreshCommandForDo;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands.RefreshCommandForUndo;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.TimeRulerUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.InteractionEditPartTN;

/** Adds a free time ruler to new Interactions. */
public class CustomTimingDiagramCreationEditPolicy extends PapyrusCreationEditPolicy {

	public CustomTimingDiagramCreationEditPolicy() {
	}

	@Override
	protected Command getCreateCommand(final CreateViewRequest request) {
		final Command superCommand = super.getCreateCommand(request);
		final List<? extends ViewDescriptor> viewDescriptors = request.getViewDescriptors();
		if (request instanceof CreateViewAndElementRequest && viewDescriptors.size() == 1) {
			final String semanticHint = viewDescriptors.get(0).getSemanticHint();
			if (Integer.toString(InteractionEditPartTN.VISUAL_ID).equals(semanticHint)) {
				final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(getHost().getModel());
				final CompoundCommand compoundCommand = new CompoundCommand(Messages.CustomTimingDiagramCreationEditPolicy_CreateInteraction);
				compoundCommand.add(new RefreshCommandForUndo((IGraphicalEditPart) getHost()));
				compoundCommand.add(superCommand);
				compoundCommand.add(new ICommandProxy(TimeRulerUtils.getCreateFreeTimeRulerCommand(superCommand, editingDomain, true)));
				compoundCommand.add(new RefreshCommandForDo((IGraphicalEditPart) getHost()));
				return compoundCommand;
			}
		}
		return superCommand;
	}
}
