/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */

package org.eclipse.papyrus.uml.diagram.statemachine.custom.edit.part;

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.commands.CustomStateMachineResizeCommand;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.figures.StateMachineFigure;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.helpers.Zone;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateMachineEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateMachineNameEditPart;

public class CustomStateMachineNameEditPart extends StateMachineNameEditPart {

	public CustomStateMachineNameEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		removeEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);
		removeEditPolicy(EditPolicyRoles.POPUPBAR_ROLE);

	}

	@Override
	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);

		refreshVisuals();
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();

		View stateMachineLabelView = (View)getModel();
		View stateMachineView = (View)stateMachineLabelView.eContainer();
		View stateMachineCompartView = (View)stateMachineView.getChildren().get(1);

		StateMachineFigure stateFigure = ((StateMachineEditPart)getParent()).getPrimaryShape();
		int width = stateFigure.getBounds().width;
		// calculate height for labels via position of the rectangle figure after the labels. Layout managers such as the
		// AutomaticCompartmentLayoutManager add extra space on top of the first label which would not be accounted for
		// when adding the space for the labels.
		int height = 0;
		if(stateMachineCompartView.isVisible() && (stateFigure.getStateMachineCompartmentFigure() != null)) {
			stateFigure.validate(); // validate the figure, assure that layout manager is called.
			height = stateFigure.getStateMachineCompartmentFigure().getBounds().y - stateFigure.getBounds().y + 1;
			// Sanity check
			if(height < 0) {
				height = 0;
			}
		}
		else {
			height = stateFigure.getNameLabel().getBounds().height;
		}

		int stateMachineHeight = Zone.getHeight(stateMachineView);
		int stateMachineWidth = Zone.getWidth(stateMachineView);

		int stateMachineCompartHeight = Zone.getHeight(stateMachineCompartView);

		int dx = width - stateMachineWidth;
		int dy = stateMachineCompartHeight + height - stateMachineHeight;
		int x = Zone.getX(stateMachineView);
		int y = Zone.getY(stateMachineView);

		if((stateMachineHeight != -1) && (width != 0) && (dy != 0)) {
			dx = (dx > 0) ? dx : 0;
			// a resize request, which we route to the specific ResizeCommand
			IAdaptable adaptableForStateMachine = new SemanticAdapter(null, stateMachineView);
			ChangeBoundsRequest internalResizeRequest = new ChangeBoundsRequest();
			internalResizeRequest.setResizeDirection(PositionConstants.EAST);
			internalResizeRequest.setSizeDelta(new Dimension(dx, dy));
			Rectangle rect = new Rectangle(x, y, stateMachineWidth + dx, stateMachineHeight + dy);

			CustomStateMachineResizeCommand internalResizeCommand = new CustomStateMachineResizeCommand(adaptableForStateMachine, getDiagramPreferencesHint(), getEditingDomain(), DiagramUIMessages.CreateCommand_Label, internalResizeRequest, rect, true);
			internalResizeCommand.setOptions(Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE));
			try {
				internalResizeCommand.execute(null, null);
			} catch (ExecutionException e) {
			}
		}
	}
}
