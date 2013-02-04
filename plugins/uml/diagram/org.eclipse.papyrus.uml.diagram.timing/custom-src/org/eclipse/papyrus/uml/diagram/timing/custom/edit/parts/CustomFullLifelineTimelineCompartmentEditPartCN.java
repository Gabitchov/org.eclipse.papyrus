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
import java.util.Map;

import org.eclipse.draw2d.FreeformViewport;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.layout.FreeFormLayoutEx;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.timing.custom.figures.CrossFigure;
import org.eclipse.papyrus.uml.diagram.timing.custom.figures.DimensioningArrowFigure;
import org.eclipse.papyrus.uml.diagram.timing.custom.figures.FullStateFigure;
import org.eclipse.papyrus.uml.diagram.timing.custom.figures.FullStateInvariantVerticalLineFigure;
import org.eclipse.papyrus.uml.diagram.timing.custom.figures.GeneralOrderingHorizontalFigure;
import org.eclipse.papyrus.uml.diagram.timing.custom.figures.SmallSquareFigure;
import org.eclipse.papyrus.uml.diagram.timing.custom.figures.VerticalMarkFigure;
import org.eclipse.papyrus.uml.diagram.timing.custom.layouts.FillLayout;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.FigureUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.StateDefinitionUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.StateInvariantUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineTimelineCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.StateDefinitionEditPart;
import org.eclipse.uml2.uml.StateInvariant;

public class CustomFullLifelineTimelineCompartmentEditPartCN extends FullLifelineTimelineCompartmentEditPartCN {

	public CustomFullLifelineTimelineCompartmentEditPartCN(final View view) {
		super(view);
	}

	@Override
	public IFigure createFigure() {
		final ResizableCompartmentFigure figure = (ResizableCompartmentFigure)super.createFigure();
		figure.setBorder(null);
		figure.getScrollPane().setBorder(null);
		figure.setLayoutManager(new FillLayout());

		figure.getContentPane().setLayoutManager(new FreeFormLayoutEx() {

			@Override
			public void layout(final IFigure container) {
				final EditPartViewer viewer = CustomFullLifelineTimelineCompartmentEditPartCN.this.getRoot().getViewer();
				// reset the layout so that the BorderItemsAwareFreeFormLayer fills its parent FreeformViewport
				final IFigure parent = container.getParent();
				if(parent instanceof FreeformViewport) {
					final FreeformViewport freeformViewport = (FreeformViewport)parent;
					if(!(freeformViewport.getLayoutManager() instanceof FillLayout)) {
						freeformViewport.setLayoutManager(new FillLayout());
					}
					// reset the origin if it changed (for example, clicking on a label partly
					// outside the compartment reveals it by scrolling)
					freeformViewport.setViewLocation(0, 0);
				}

				// The grand-parent is a FreeformViewport, which lets its child expand outside of its clientArea, and
				// constantly resets the bounds (in org.eclipse.draw2d.FreeformViewport#readjustScrollBars)
				// So, layout based on the grand-parent's clientArea.
				final Rectangle clientArea = container.getParent().getClientArea();
				@SuppressWarnings("unchecked")
				final List<IFigure> children = container.getChildren();
				final Rectangle[] constraints = new Rectangle[children.size()];
				for(int i = 0; i < children.size(); i++) {
					constraints[i] = (Rectangle)getConstraint(children.get(i));
				}

				/*
				 * This is a 2-pass layout: first, layout the OccurrenceSpecifications and StateInvariants. Then, layout
				 * the VerticalLines, which depend on the bounds of both its previous and following element
				 * StateInvariants, and the time elements.
				 */
				layoutOccurrenceSpecificationsAndStateInvariants(viewer, clientArea, children, constraints);
				layoutVerticalLinesAndTimeElements(children, clientArea, constraints);
			}

			@Override
			protected Dimension calculatePreferredSize(final IFigure container, final int wHint, final int hHint) {
				return new Dimension(-1, -1);
			}
		});

		return figure;
	}

	/**
	 * Hide the scrollbar
	 * 
	 * @see http://wiki.eclipse.org/Papyrus_Developer_Guide/NoScrollbar
	 */
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		((ResizableCompartmentFigure)getFigure()).getScrollPane().setScrollBarVisibility(org.eclipse.draw2d.ScrollPane.NEVER);
		refreshBounds();
	}

	@Override
	public boolean isSelectable() {
		// No need to select the compartment.
		// This saves one click when selecting something inside.
		return false;
	}

	@Override
	public Command getCommand(final Request request) {
		// redirect connection requests to the Lifeline (for MessageLost and MessageFound)
		if(request instanceof CreateConnectionRequest) {
			final CreateConnectionRequest createConnectionRequest = (CreateConnectionRequest)request;
			if(RequestConstants.REQ_CONNECTION_START.equals(request.getType())) {
				if(createConnectionRequest.getTargetEditPart() instanceof FullLifelineTimelineCompartmentEditPartCN) {
					createConnectionRequest.setTargetEditPart(getParent());
				}
				return getParent().getCommand(request);
			} else if(RequestConstants.REQ_CONNECTION_END.equals(request.getType())) {
				if(createConnectionRequest.getSourceEditPart() instanceof FullLifelineTimelineCompartmentEditPartCN) {
					createConnectionRequest.setSourceEditPart(getParent());
				}
				return getParent().getCommand(request);
			}
		}
		return super.getCommand(request);
	}

	/** First pass of the layout */
	protected static void layoutOccurrenceSpecificationsAndStateInvariants(final EditPartViewer viewer, final Rectangle clientArea, final List<IFigure> figures, final Rectangle[] constraints) {

		int x = clientArea.x;
		int y = -1;
		int prevY = -1;
		Rectangle nextConstraint = null;
		IFigure nextFigure = null;
		IFigure nextChildFigure = null;
		for(int i = 0; i < figures.size(); i++) {
			final IFigure figure = figures.get(i);
			final FullStateFigure stateInvariantFigure = FigureUtils.findChildFigureInstance(figure, FullStateFigure.class);
			final SmallSquareFigure smallSquareFigure = FigureUtils.findChildFigureInstance(figure, SmallSquareFigure.class);
			final CrossFigure crossFigure = FigureUtils.findChildFigureInstance(figure, CrossFigure.class);

			if(stateInvariantFigure == null && smallSquareFigure == null && crossFigure == null) {
				continue;
			}

			// This is the bounds that the user tries to set. We further constrain these bounds.
			final Rectangle constraint = constraints[i];

			nextConstraint = null;
			nextFigure = null;
			for(int j = i + 1; j < figures.size(); j++) {
				final IFigure f = figures.get(j);
				nextChildFigure = FigureUtils.findChildFigureInstance(f, FullStateFigure.class);
				if(nextChildFigure == null) {
					nextChildFigure = FigureUtils.findChildFigureInstance(f, SmallSquareFigure.class);
				}
				if(nextChildFigure == null) {
					nextChildFigure = FigureUtils.findChildFigureInstance(f, CrossFigure.class);
				}
				if(nextChildFigure != null) {
					nextConstraint = constraints[j];
					nextFigure = f;
					break;
				}
			}

			IFigure occurrenceFigure = null;
			if(smallSquareFigure != null) {
				occurrenceFigure = smallSquareFigure;
			} else if(crossFigure != null) {
				occurrenceFigure = crossFigure;
			}

			// OccurrenceSpecification, MessageOccurrenceSpecification or DestructionOccurrenceSpecification
			if(occurrenceFigure != null) {
				final int occurrenceY;
				if(y == -1) {
					// the Lifeline starts by an OccurrenceSpecification => align it with the following StateInvariant
					if(nextChildFigure instanceof FullStateFigure) {
						occurrenceY = computeVerticalPosition(nextFigure, viewer);
					} else {
						Activator.log.warn("The Lifeline starts by an OccurrenceSpecification not followed by a StateInvariant"); //$NON-NLS-1$
						occurrenceY = 10;
					}
				} else {
					occurrenceY = y;
				}

				// set the OccurrenceSpecification y-coordinate to the one from the previous StateInvariant
				// keep the x-coordinate as-is
				final Dimension preferredSize = occurrenceFigure.getPreferredSize();
				figure.setBounds(new Rectangle(constraint.x, occurrenceY - preferredSize.height / 2, preferredSize.width, preferredSize.height));
				x = constraint.x + preferredSize.width;
			}

			// StateInvariant
			if(stateInvariantFigure != null) {
				final int computedY = computeVerticalPosition(figure, viewer);
				stateInvariantFigure.setPosY(computedY);

				if(y == -1) {
					// first state invariant
					prevY = computedY;
				} else {
					prevY = y;
				}

				y = computedY;

				final int width;
				if(nextConstraint != null) {
					// the StateInvariant stops where the next occurrence begins
					width = nextConstraint.x - x;
				} else {
					// if the StateInvariant is the last element, then it continues until the end
					width = clientArea.width - x;
				}

				if(prevY == y) {
					// a StateInvariant on the right of an OccurrenceSpecification (or at the beginning)
					figure.setBounds(new Rectangle(x, y - 5, width, 10));
				} else {
					// a StateInvariant on the top or bottom of the previous OccurrenceSpecification
					// => shift the line to eliminate the seam with the vertical line which is shifted too
					figure.setBounds(new Rectangle(x - SmallSquareFigure.RADIUS - 1, y - 5, width + SmallSquareFigure.RADIUS + 1, 10));
				}
				x += width;
			}
		}
	}

	private static int computeVerticalPosition(final IFigure stateInvariantFigure, final EditPartViewer viewer) {
		@SuppressWarnings("unchecked")
		final Map<IFigure, EditPart> visualPartMap = viewer.getVisualPartMap();
		final CustomFullStateInvariantEditPartCN stateInvariantEditPart = (CustomFullStateInvariantEditPartCN)visualPartMap.get(stateInvariantFigure);
		final View stateInvariantView = (View)stateInvariantEditPart.getModel();
		final StateInvariant stateInvariant = (StateInvariant)stateInvariantView.getElement();
		final String id = StateInvariantUtils.getStateInvariantId(stateInvariant);
		if(id == null) {
			Activator.log.error("null id for a StateInvariant", new Exception()); //$NON-NLS-1$
			return -1;
		}

		final View lifelineView = StateDefinitionUtils.getParentLifelineView(stateInvariantView);
		final View stateDefinition = StateDefinitionUtils.getStateDefinitionViewWithId(id, lifelineView);
		if(stateDefinition == null) {
			Activator.log.error("No StateDefinition found for the StateInvariant (id = " + id + ")", new Exception()); //$NON-NLS-1$//$NON-NLS-2$
			return -1;
		}

		final StateDefinitionEditPart stateDefinitionEditPart = (StateDefinitionEditPart)viewer.getEditPartRegistry().get(stateDefinition);
		final IFigure stateDefinitionFigure = stateDefinitionEditPart.getFigure();
		final Rectangle bounds = stateDefinitionFigure.getBounds();
		final int parentY = stateDefinitionFigure.getParent().getClientArea().y;
		return bounds.y + bounds.height / 2 - parentY;
	}

	/**
	 * Second pass of the layout: layout the VerticalLines, which depend on the bounds of both their previous and
	 * following StateInvariants, the time elements, which can be bound to an OccurrenceSpecification or StateInvariant,
	 * and the GeneralOrderings, which can be linked to OccurrenceSpecifications.
	 */
	protected static void layoutVerticalLinesAndTimeElements(final List<IFigure> figures, final Rectangle clientArea, final Rectangle[] constraints) {

		IFigure previousFigure = null;
		IFigure nextFigure = null;
		for(int i = 0; i < figures.size(); i++) {
			final IFigure figure = figures.get(i);
			final FullStateInvariantVerticalLineFigure verticalLineFigure = FigureUtils.findChildFigureInstance(figure, FullStateInvariantVerticalLineFigure.class);
			final VerticalMarkFigure verticalMarkFigure = FigureUtils.findChildFigureInstance(figure, VerticalMarkFigure.class);
			final DimensioningArrowFigure dimensioningArrowFigure = FigureUtils.findChildFigureInstance(figure, DimensioningArrowFigure.class);
			final GeneralOrderingHorizontalFigure generalOrderingHorizontalFigure = FigureUtils.findChildFigureInstance(figure, GeneralOrderingHorizontalFigure.class);

			nextFigure = null;
			if(i < figures.size() - 1) {
				nextFigure = figures.get(i + 1);
			}

			// This is the bounds that the user tries to set. We further constrain these bounds.
			final Rectangle constraint = constraints[i];

			// VerticalLine
			if(verticalLineFigure != null) {
				boolean showVerticalLine = false;
				if(nextFigure != null && previousFigure != null) {
					final Rectangle prev = previousFigure.getBounds();
					final int y = prev.y + prev.height / 2;
					final int x = prev.x + prev.width / 2;
					final Rectangle next = nextFigure.getBounds();
					final int y2 = next.y + next.height / 2;
					int y1 = y;
					final int sign = (int)Math.signum(y2 - y1);
					// move the start of the line outside the OccurrenceSpecification
					y1 += sign * (previousFigure.getBounds().height / 2);
					if(y != y2) {
						showVerticalLine = true;
					}
					final int verticalLineBoxWidth = 10;
					figure.setBounds(new Rectangle(x - verticalLineBoxWidth / 2, Math.min(y1, y2), verticalLineBoxWidth, Math.abs(y2 - y1)));
				} else {
					Activator.log.warn("VerticalLine not between two Figures"); //$NON-NLS-1$
				}
				figure.setVisible(showVerticalLine);
			} else if(verticalMarkFigure != null) {
				// time observation or constraint
				final Dimension size = verticalMarkFigure.getPreferredSize();
				figure.setBounds(new Rectangle(constraint.x, constraint.y, size.width, size.height));
			} else if(dimensioningArrowFigure != null) {
				// duration observation or constraint
				final Dimension size = dimensioningArrowFigure.getPreferredSize();
				if(constraint.width == Integer.MAX_VALUE) {
					// it has no end => set the right side of the compartment as the end
					figure.setBounds(new Rectangle(constraint.x, constraint.y, clientArea.width - constraint.x, size.height));
				} else {
					figure.setBounds(new Rectangle(constraint.x, constraint.y, constraint.width, size.height));
				}
			} else if(generalOrderingHorizontalFigure != null) {
				// general ordering
				final Dimension size = generalOrderingHorizontalFigure.getPreferredSize();
				figure.setBounds(new Rectangle(constraint.x, constraint.y, constraint.width, size.height));
			}

			previousFigure = figure;
		}
	}
}
