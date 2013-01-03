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
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest.ViewAndElementDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.PapyrusCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.timing.custom.Messages;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands.RefreshCommandForDo;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.FigureUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.ViewUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.GateEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.InteractionEditPartTN;

public class CustomInteractionCreationEditPolicy extends PapyrusCreationEditPolicy {

	public CustomInteractionCreationEditPolicy() {
	}

	@Override
	protected Command getCreateCommand(final CreateViewRequest request) {
		final ICommandProxy superCommand = (ICommandProxy) super.getCreateCommand(request);
		final List<? extends ViewDescriptor> viewDescriptors = request.getViewDescriptors();
		if (request instanceof CreateViewAndElementRequest && viewDescriptors.size() == 1) {
			final String semanticHint = viewDescriptors.get(0).getSemanticHint();
			if (Integer.toString(GateEditPart.VISUAL_ID).equals(semanticHint)) {
				return getCreateGateCommand(request, superCommand);
			}
		}
		return superCommand;
	}

	/** Override the base creation command in order to position the new Gate Node where the user clicks */
	private Command getCreateGateCommand(final CreateViewRequest request, final ICommandProxy superCommand) {
		final CompoundCommand compoundCommand = new CompoundCommand(Messages.CustomInteractionCreationEditPolicy_CreateGate);
		compoundCommand.add(superCommand);
		final ICommand iCommand = superCommand.getICommand();
		final TransactionalEditingDomain editingDomain = ((AbstractEMFOperation) iCommand).getEditingDomain();
		compoundCommand.add(new ICommandProxy(new AbstractTransactionalCommand(editingDomain, Messages.CustomInteractionCreationEditPolicy_PositionGate, null) {
			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				final CommandResult commandResult = iCommand.getCommandResult();
				final Object returnValue = commandResult.getReturnValue();
				final ViewAndElementDescriptor descriptor = (ViewAndElementDescriptor) returnValue;
				final Node node = (Node) descriptor.getAdapter(Node.class);

				final Node interactionView = (Node) ViewUtils.findSuperViewWithId(node, InteractionEditPartTN.VISUAL_ID);
				final Location interactionLocation = (Location) interactionView.getLayoutConstraint();

				final IFigure hostFigure = ((GraphicalEditPart) getHost()).getFigure();
				final Point point = new Point(request.getLocation());
				final Point origin = FigureUtils.getLayeredPaneOrigin(hostFigure);
				point.translate(origin);
				final Point location = FigureUtils.scaleByZoom(point, hostFigure);

				final Location loc = NotationFactory.eINSTANCE.createLocation();
				loc.setX(location.x - interactionLocation.getX());
				loc.setY(location.y - interactionLocation.getY());
				node.setLayoutConstraint(loc);

				return CommandResult.newOKCommandResult();
			}
		}));
		compoundCommand.add(new RefreshCommandForDo((GraphicalEditPart) getHost()));
		return compoundCommand;
	}
}
