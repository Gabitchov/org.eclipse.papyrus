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

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.PapyrusCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.timing.custom.Messages;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands.RefreshCommandForDo;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands.RefreshCommandForUndo;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.EditPartUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.StateInvariantUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.TimeRulerUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.ViewUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.InteractionEditPartTN;
import org.eclipse.uml2.uml.Interaction;

public class CustomInteractionCompartmentCreationEditPolicy extends PapyrusCreationEditPolicy {

	public CustomInteractionCompartmentCreationEditPolicy() {
	}

	@Override
	protected Command getCreateCommand(final CreateViewRequest request) {
		final ICommandProxy superCommand = (ICommandProxy)super.getCreateCommand(request);
		final List<? extends ViewDescriptor> viewDescriptors = request.getViewDescriptors();
		if(request instanceof CreateViewAndElementRequest && viewDescriptors.size() == 1) {
			final String semanticHint = viewDescriptors.get(0).getSemanticHint();
			final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(getHost().getModel());
			if(Integer.toString(CompactLifelineEditPartCN.VISUAL_ID).equals(semanticHint)) {
				final View interactionView = (View)getHost().getParent().getModel();
				final Interaction interaction = (Interaction)interactionView.getElement();
				// note: only add a StateInvariant to the Lifeline if the request is a CreateViewAndElementRequest,
				// and not merely a CreateViewRequest, because we don't want to create a new StateInvariant if this is
				// only a drop for an existing Lifeline
				final CompoundCommand compoundCommand = new CompoundCommand(Messages.CustomInteractionCompartmentCreationEditPolicy_CreateCompactLifeline);
				final InteractionEditPartTN interactionEditPart = getInteractionEditPart();
				compoundCommand.add(new RefreshCommandForUndo(interactionEditPart));
				compoundCommand.add(createCompactStateInvariantCommand(superCommand, interaction));
				compoundCommand.add(new ICommandProxy(TimeRulerUtils.getCreateFreeTimeRulerCommand(superCommand, editingDomain, false)));
				compoundCommand.add(new RefreshCommandForDo(interactionEditPart));
				return compoundCommand;
			}
			if(Integer.toString(FullLifelineEditPartCN.VISUAL_ID).equals(semanticHint)) {
				final CompoundCommand compoundCommand = new CompoundCommand(Messages.CustomInteractionCompartmentCreationEditPolicy_CreateFullLifeline);
				final InteractionEditPartTN interactionEditPart = getInteractionEditPart();
				compoundCommand.add(new RefreshCommandForUndo(interactionEditPart));
				compoundCommand.add(superCommand);
				compoundCommand.add(new ICommandProxy(TimeRulerUtils.getCreateFreeTimeRulerCommand(superCommand, editingDomain, false)));
				compoundCommand.add(new RefreshCommandForDo(interactionEditPart));
				return compoundCommand;
			}
		}
		return superCommand;
	}

	private static Command createCompactStateInvariantCommand(final Command superCommand, final Interaction interaction) {
		final CompoundCommand compoundCommand = new CompoundCommand(Messages.CustomCompactLifelifeCompactStateInvariantCreationEditPolicy_CreateStateInvariant);
		// creates the compact lifeline View
		compoundCommand.add(superCommand);

		final CommandResult superCommandResult = ((ICommandProxy)superCommand).getICommand().getCommandResult();

		final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(interaction);
		if(editingDomain == null) {
			throw new IllegalStateException("no editing domain"); //$NON-NLS-1$
		}

		final AbstractTransactionalCommand initStateDefinitionCommand = new AbstractTransactionalCommand(editingDomain, Messages.CustomCompactLifelifeCompactStateInvariantCreationEditPolicy_InitializeStateInvariant, null) {

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				// the result from the super command that creates the view
				final ViewDescriptor viewDescriptor = (ViewDescriptor)superCommandResult.getReturnValue();
				final View compactLifelineView = (View)viewDescriptor.getAdapter(View.class);
				final View compactLifelineCompartmentView = ViewUtils.findCompactTimelineCompartmentView(compactLifelineView);
				StateInvariantUtils.createCompactStateInvariant(compactLifelineCompartmentView, -1, -1, -1);
				return CommandResult.newOKCommandResult();
			}
		};
		compoundCommand.add(new ICommandProxy(initStateDefinitionCommand));
		return compoundCommand;
	}

	protected InteractionEditPartTN getInteractionEditPart() {
		return (InteractionEditPartTN)EditPartUtils.findParentEditPartWithId(getHost(), InteractionEditPartTN.VISUAL_ID);
	}

	protected CompactLifelineCompartmentEditPartCN getCompactLifelineCompartmentEditPart() {
		return (CompactLifelineCompartmentEditPartCN)EditPartUtils.findFirstChildEditPartWithId(getHost(), CompactLifelineCompartmentEditPartCN.VISUAL_ID);
	}
}
