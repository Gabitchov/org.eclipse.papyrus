/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.handlers.GraphicalCommandHandler;
import org.eclipse.papyrus.uml.diagram.timing.custom.Messages;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.TickUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.TimeRulerUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.ViewUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.DestructionOccurrenceSpecificationEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageOccurrenceSpecificationEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.OccurrenceSpecificationEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.providers.UMLViewProvider;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.OccurrenceSpecification;

public class CreateTickCommand extends GraphicalCommandHandler {

	@Override
	protected Command getCommand() {
		final CompoundCommand cmd = new CompoundCommand(Messages.CreateTickCommand_attachTick);
		final ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
		if(!selection.isEmpty() && selection instanceof IStructuredSelection) {
			final IStructuredSelection structSelection = (IStructuredSelection)selection;
			for(final Object object : structSelection.toArray()) {
				if(object instanceof OccurrenceSpecificationEditPartCN || object instanceof MessageOccurrenceSpecificationEditPartCN || object instanceof DestructionOccurrenceSpecificationEditPartCN) {
					cmd.add(attachTick((GraphicalEditPart)object));
				}
			}
		}
		return cmd;
	}

	private static Command attachTick(final GraphicalEditPart osEditPart) {
		final IGraphicalEditPart tickContainer = TimeRulerUtils.findClosestTimeRuler(osEditPart);
		if(tickContainer == null) {
			Activator.log.error("No tick container found", new Exception()); //$NON-NLS-1$
			return UnexecutableCommand.INSTANCE;
		}
		final View tickContainerView = (View)tickContainer.getModel();

		final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(osEditPart.getEditingDomain());
		final Node osView = (Node)osEditPart.getModel();
		final OccurrenceSpecification os = (OccurrenceSpecification)osView.getElement();
		// if the Lifeline or Interaction compartment already contains a tick for this occurrence,
		// then don't let a duplicate be created
		if(TickUtils.containsTickFor(tickContainerView, os)) {
			return UnexecutableCommand.INSTANCE;
		}
		final AbstractTransactionalCommand createTickCommand = new AbstractTransactionalCommand(editingDomain, Messages.CreateTickCommand_CreateTick, null) {

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				final UMLViewProvider umlViewProvider = new UMLViewProvider();
				final Node tickNode = umlViewProvider.createNode_26(null, tickContainerView, ViewUtil.APPEND, true, osEditPart.getDiagramPreferencesHint());
				TickUtils.associateTickNodeToOccurrenceNode(tickNode, osView, false);
				tickContainer.refresh();
				ViewUtils.performEditRequest(tickNode, osEditPart.getViewer());
				return CommandResult.newOKCommandResult(tickNode);
			}
		};
		return new ICommandProxy(createTickCommand);
	}
}
