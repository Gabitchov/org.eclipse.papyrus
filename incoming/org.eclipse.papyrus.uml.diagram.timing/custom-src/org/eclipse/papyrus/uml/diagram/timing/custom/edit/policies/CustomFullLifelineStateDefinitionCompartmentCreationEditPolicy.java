/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
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
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.timing.custom.Messages;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands.RefreshCommandForDo;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands.RefreshCommandForUndo;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.EditPartUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.LifelineUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.StateDefinitionUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.StateInvariantUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.StateDefinitionEditPart;
import org.eclipse.uml2.uml.Lifeline;

/**
 * This EditPolicy creates a StateInvariant when the first StateDefinition is created, and links the StateInvariant to
 * the StateDefinition.
 */
public class CustomFullLifelineStateDefinitionCompartmentCreationEditPolicy extends CreationEditPolicy {

	public CustomFullLifelineStateDefinitionCompartmentCreationEditPolicy() {
	}

	@Override
	protected Command getCreateCommand(final CreateViewRequest request) {
		final Command superCommand = super.getCreateCommand(request);
		final List<? extends ViewDescriptor> viewDescriptors = request.getViewDescriptors();
		if(viewDescriptors.size() == 1 && Integer.toString(StateDefinitionEditPart.VISUAL_ID).equals(viewDescriptors.get(0).getSemanticHint())) {
			final View lifelineView = (View)getHost().getParent().getModel();
			final Lifeline lifeline = (Lifeline)lifelineView.getElement();
			final List<?> children = getHost().getChildren();
			final boolean firstStateDefinition = children.size() == 0;
			return createStateDefinitionCommand(superCommand, lifeline, firstStateDefinition);
		}
		return super.getCreateCommand(request);
	}

	private Command createStateDefinitionCommand(final Command superCommand, final Lifeline lifeline, final boolean first) {
		final CompoundCommand compoundCommand = new CompoundCommand(Messages.CustomFullLifelineStateDefinitionCompartmentCreationEditPolicy_CreateStateDefinition);
		final FullLifelineEditPartCN lifelineEditPart = getLifelineEditPart();
		compoundCommand.add(new RefreshCommandForUndo(lifelineEditPart));
		// creates the state definition View
		compoundCommand.add(superCommand);

		final CommandResult superCommandResult = ((ICommandProxy)superCommand).getICommand().getCommandResult();

		final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(lifeline);
		if(editingDomain == null) {
			throw new IllegalStateException("no editing domain"); //$NON-NLS-1$
		}

		final AbstractTransactionalCommand initStateDefinitionCommand = new AbstractTransactionalCommand(editingDomain, Messages.CustomFullLifelineStateDefinitionCompartmentCreationEditPolicy_InitializeStateDefinition, null) {

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				// the result from the super command that creates the view
				final ViewDescriptor viewDescriptor = (ViewDescriptor)superCommandResult.getReturnValue();
				final View stateDefinitionView = (View)viewDescriptor.getAdapter(View.class);

				// create the annotation for the StateDefinition
				StateDefinitionUtils.initNewStateDefinitionName(stateDefinitionView);

				if(first) {
					final String id = StateDefinitionUtils.getStateDefinitionViewID(stateDefinitionView);
					StateInvariantUtils.createStateInvariant(id, lifelineEditPart, -1, -1, -1);
					final View lifelineView = (View)lifelineEditPart.getModel();
					final Lifeline lifeline = (Lifeline)lifelineView.getElement();
					LifelineUtils.updateFragmentNames(lifeline, lifelineView);
				}
				return CommandResult.newOKCommandResult();
			}
		};
		compoundCommand.add(new ICommandProxy(initStateDefinitionCommand));
		compoundCommand.add(new RefreshCommandForDo(getLifelineEditPart()));
		return compoundCommand;
	}

	protected FullLifelineEditPartCN getLifelineEditPart() {
		return (FullLifelineEditPartCN)EditPartUtils.findParentEditPartWithId(getHost(), FullLifelineEditPartCN.VISUAL_ID);
	}

}
