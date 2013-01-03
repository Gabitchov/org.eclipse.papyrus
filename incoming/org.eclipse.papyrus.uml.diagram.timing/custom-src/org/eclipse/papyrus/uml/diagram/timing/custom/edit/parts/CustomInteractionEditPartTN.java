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
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.parts;

import java.util.List;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.figure.node.StereotypePropertiesCompartment;
import org.eclipse.papyrus.uml.diagram.timing.custom.figures.CustomInteractionRectangleFigure;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.Constants;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.EditPartUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.GateEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.InteractionCompartmentEditPartTN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.InteractionEditPartTN;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLVisualIDRegistry;

public class CustomInteractionEditPartTN extends InteractionEditPartTN {

	private static final int HEADER_HEIGHT_PADDING = 4;
	private static final int MIN_HEADER_HEIGHT = 21;

	public CustomInteractionEditPartTN(final View view) {
		super(view);
	}

	@Override
	protected IFigure createNodeShape() {
		final CustomInteractionRectangleFigure interactionRectangleFigure = new CustomInteractionRectangleFigure();
		interactionRectangleFigure.getCompartmentFigure().setOutline(false);
		interactionRectangleFigure.getNameLabel().setVisible(false);
		// disable the shadow because it stays behind after move then Ctrl+Z
		interactionRectangleFigure.setShadow(false);

		interactionRectangleFigure.setLayoutManager(new AbstractLayout() {

			public void layout(final IFigure container) {
				// TODO futur use
				// final boolean displayTimeRuler = interactionRectangleFigure.isDisplayTimeRuler();
				final Rectangle clientArea = container.getClientArea();
				@SuppressWarnings("unchecked")
				final List<IFigure> children = container.getChildren();
				int consumedHeight = 0;
				for (int i = 0; i < children.size(); i++) {
					final IFigure child = children.get(i);
					if (child.equals(interactionRectangleFigure.getHeaderLabelContainer())) {
						final int height = Math.max(interactionRectangleFigure.getHeaderLabel().getPreferredSize().height + HEADER_HEIGHT_PADDING,
								MIN_HEADER_HEIGHT);
						child.setBounds(new Rectangle(clientArea.x, clientArea.y + consumedHeight, clientArea.width, height));
						consumedHeight = consumedHeight + height;
					} else if (child.equals(interactionRectangleFigure.getCompartmentFigure())) {
						child.setBounds(new Rectangle(clientArea.x, clientArea.y + consumedHeight, clientArea.width, clientArea.height - 3 - consumedHeight
								- Constants.TIME_RULER_HEIGHT));

					} else if (child instanceof StereotypePropertiesCompartment) {
						final int height = child.getPreferredSize().height;
						child.setBounds(new Rectangle(clientArea.x, clientArea.y + consumedHeight, clientArea.width, height));
						consumedHeight += height;
					} else if (child.equals(interactionRectangleFigure.getTimeRulerContainerFigure())) {
						child.setBounds(new Rectangle(clientArea.x, clientArea.y + clientArea.height - Constants.TIME_RULER_HEIGHT, clientArea.width,
								Constants.TIME_RULER_HEIGHT));
						consumedHeight += Constants.TIME_RULER_HEIGHT;
					} else if (i == 0 && !(child instanceof WrappingLabel)) {
						consumedHeight = consumedHeight + child.getPreferredSize().height;
						child.setBounds(new Rectangle(clientArea.x, clientArea.y, clientArea.width, consumedHeight));
					} else {
						if (i == 0 && !(child instanceof WrappingLabel)) {
							consumedHeight = consumedHeight + child.getPreferredSize().height;
							child.setBounds(new Rectangle(clientArea.x, clientArea.y, clientArea.width, consumedHeight));
						} else {
							child.setBounds(new Rectangle(clientArea.x, clientArea.y, 0, 0));
						}
					}
				}
			}

			@Override
			protected Dimension calculatePreferredSize(final IFigure container, final int wHint, final int hHint) {
				return new Dimension(-1, -1);
			}
		});

		return this.primaryShape = interactionRectangleFigure;
	}

	@Override
	public Command getCommand(final Request request) {
		// redirect the "drop objects" request to the compartment
		if (request instanceof DropObjectsRequest) {
			final DropObjectsRequest dropObjectsRequest = (DropObjectsRequest) request;
			final EditPart compartment = EditPartUtils.findFirstChildEditPartWithId(this, InteractionCompartmentEditPartTN.VISUAL_ID);
			if (compartment != null) {
				return compartment.getCommand(dropObjectsRequest);
			}
			Activator.log.error(new IllegalStateException("No " + InteractionCompartmentEditPartTN.class.getSimpleName() + " found in the " //$NON-NLS-1$ //$NON-NLS-2$
					+ CustomInteractionEditPartTN.class.getSimpleName()));
		}
		return super.getCommand(request);
	}

	@Override
	protected LayoutEditPolicy createLayoutEditPolicy() {
		final org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			@Override
			protected EditPolicy createChildEditPolicy(final EditPart child) {
				final View childView = (View) child.getModel();
				final int visualID = UMLVisualIDRegistry.getVisualID(childView);
				// don't let Gates be resized
				if (visualID == GateEditPart.VISUAL_ID) {
					return new BorderItemSelectionEditPolicy();
				}
				return new NonResizableEditPolicy();
			}

			@Override
			protected Command getMoveChildrenCommand(final Request request) {
				return null;
			}

			@Override
			protected Command getCreateCommand(final CreateRequest request) {
				return null;
			}
		};
		return lep;
	}
}
