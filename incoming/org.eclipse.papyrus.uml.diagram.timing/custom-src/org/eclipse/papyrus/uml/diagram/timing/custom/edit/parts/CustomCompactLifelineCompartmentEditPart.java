/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.parts;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.layout.FreeFormLayoutEx;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.timing.custom.figures.CompactStateFigure;
import org.eclipse.papyrus.uml.diagram.timing.custom.figures.CrossFigure;
import org.eclipse.papyrus.uml.diagram.timing.custom.figures.DimensioningArrowFigure;
import org.eclipse.papyrus.uml.diagram.timing.custom.figures.GeneralOrderingHorizontalFigure;
import org.eclipse.papyrus.uml.diagram.timing.custom.figures.SmallSquareFigure;
import org.eclipse.papyrus.uml.diagram.timing.custom.figures.VerticalMarkFigure;
import org.eclipse.papyrus.uml.diagram.timing.custom.layouts.FillLayout;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.Constants;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.FigureUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineCompartmentEditPartCN;

public class CustomCompactLifelineCompartmentEditPart extends CompactLifelineCompartmentEditPartCN {

	/**
	 * This offset lets compact states align with full states, which appear after the state definition compartment
	 * (which is 100 pixels wide)
	 */
	public static final int FIRST_STATE_OFFSET = Constants.STATE_DEFINITIONS_WIDTH;

	public CustomCompactLifelineCompartmentEditPart(final View view) {
		super(view);
	}

	@Override
	public IFigure createFigure() {
		final ResizableCompartmentFigure figure = (ResizableCompartmentFigure) super.createFigure();
		figure.setBorder(null);
		figure.getScrollPane().setBorder(null);
		figure.setLayoutManager(new FillLayout());

		figure.getContentPane().setLayoutManager(new FreeFormLayoutEx() {
			@Override
			public void layout(final IFigure container) {
				// reset the layout so that the BorderItemsAwareFreeFormLayer fills its parent FreeformViewport
				if (!(container.getParent().getLayoutManager() instanceof FillLayout)) {
					container.getParent().setLayoutManager(new FillLayout());
				}

				// The grand-parent is a FreeformViewport, which lets its child expand outside of its clientArea, and
				// constantly resets the bounds (in org.eclipse.draw2d.FreeformViewport#readjustScrollBars)
				// So, layout based on the grand-parent's clientArea.
				final Rectangle clientArea = container.getParent().getClientArea();
				@SuppressWarnings("unchecked")
				final List<IFigure> children = container.getChildren();
				int x = clientArea.x + FIRST_STATE_OFFSET;
				final int centerY = clientArea.y + clientArea.height / 2;
				int currentStateInvariantX = 0;
				int currentStateInvariantWidth = 0;
				int currentStateInvariantHeight = 0;
				int lastOccurrenceX = 0;
				boolean currentStateInvariantInfinite = false;

				boolean destruction = false;
				int destructionX = Integer.MAX_VALUE;
				for (int i = 0; i < children.size(); i++) {
					final IFigure child = children.get(i);
					final CrossFigure crossFigure = FigureUtils.findChildFigureInstance(child, CrossFigure.class);
					if (crossFigure != null) {
						final Rectangle constraint = (Rectangle) getConstraint(child);
						destruction = true;
						destructionX = constraint.x;
					}
				}

				IFigure nextChild = null;
				for (int i = 0; i < children.size(); i++) {
					final IFigure child = children.get(i);
					if (i < children.size() - 1) {
						nextChild = children.get(i + 1);
					} else {
						nextChild = null;
					}

					final IFigure occurrenceFigure = getOccurrenceChild(child);
					final CompactStateFigure stateInvariantFigure = FigureUtils.findChildFigureInstance(child, CompactStateFigure.class);
					final VerticalMarkFigure verticalMarkFigure = FigureUtils.findChildFigureInstance(child, VerticalMarkFigure.class);
					final DimensioningArrowFigure dimensioningArrowFigure = FigureUtils.findChildFigureInstance(figure, DimensioningArrowFigure.class);
					final GeneralOrderingHorizontalFigure generalOrderingHorizontalFigure = FigureUtils.findChildFigureInstance(figure,
							GeneralOrderingHorizontalFigure.class);

					// This is the bounds that the user tries to set. We further constrain these bounds.
					final Rectangle constraint = (Rectangle) getConstraint(child);

					// OccurrenceSpecification, MessageOccurrenceSpecification or DestructionOccurrenceSpecification
					if (occurrenceFigure != null) {
						final Dimension preferredSize = occurrenceFigure.getPreferredSize();

						if (nextChild != null && FigureUtils.findChildFigureInstance(nextChild, CompactStateFigure.class) != null) {
							// this is an occurrence specification marking a state change
							// => center it vertically
							child.setBounds(new Rectangle(constraint.x, centerY - preferredSize.height / 2, preferredSize.width, preferredSize.height));
							x = constraint.x + preferredSize.width;
						} else {
							int posX = constraint.x;
							// make sure the OccurrenceSpecification stays
							// within the bounds of its containing StateInvariant
							posX = Math.max(posX, currentStateInvariantX - SmallSquareFigure.RADIUS);
							posX = Math.min(posX, currentStateInvariantX + currentStateInvariantWidth - SmallSquareFigure.RADIUS);
							// also make sure it doesn't appear before the previous occurrence
							posX = Math.max(posX, lastOccurrenceX);

							// let the user move the OccurrenceSpecification near the top or bottom of the
							// StateInvariant on top of which it appears, and snap it to this position
							final int halfHeight = CompactStateFigure.computeHalfHeightAtAbscissa(posX - currentStateInvariantX + SmallSquareFigure.RADIUS,
									currentStateInvariantWidth, currentStateInvariantHeight, currentStateInvariantInfinite);
							final int topPos = centerY - halfHeight - SmallSquareFigure.RADIUS;
							final int bottomPos = centerY + halfHeight - SmallSquareFigure.RADIUS - 1;
							int posY;
							if (Math.abs(constraint.y - topPos) < Math.abs(constraint.y - bottomPos)) {
								posY = topPos;
							} else {
								posY = bottomPos;
							}
							child.setBounds(new Rectangle(posX, posY, preferredSize.width, preferredSize.height));
							x = posX + preferredSize.width;
							lastOccurrenceX = x;
						}
					}
					// StateInvariant
					else if (stateInvariantFigure != null) {
						final Dimension preferredSize = stateInvariantFigure.getPreferredSize();
						final int height = Math.min(preferredSize.height, clientArea.height);

						final int width;
						// the StateInvariant stops where the next state change occurrence begins
						final IFigure nextStateChangeOccurrence = findNextStateChangeOccurrence(children, i + 1);
						if (nextStateChangeOccurrence != null) {
							stateInvariantFigure.setInfinite(false);
							currentStateInvariantInfinite = false;
							width = ((Rectangle) getConstraint(nextStateChangeOccurrence)).x - x;
						} else if (destruction) {
							stateInvariantFigure.setInfinite(false);
							currentStateInvariantInfinite = false;
							width = destructionX - x;
						} else {
							stateInvariantFigure.setInfinite(true);
							currentStateInvariantInfinite = true;
							// if the StateInvariant is the last element, then it continues until the end
							width = clientArea.width - x;
						}
						child.setBounds(new Rectangle(x, centerY - height / 2, width, height));
						currentStateInvariantX = x;
						currentStateInvariantWidth = width;
						currentStateInvariantHeight = height;
						x += width;
					} else if (verticalMarkFigure != null) {
						// time observation or constraint
						final Dimension size = verticalMarkFigure.getPreferredSize();
						final int margin = 3;
						// put it right above the StateInvariants
						final int y = centerY - CompactStateFigure.PREFERRED_HEIGHT / 2 - VerticalMarkFigure.PREFERRED_HEIGHT - margin;
						child.setBounds(new Rectangle(constraint.x, y, size.width, size.height));
					} else if (dimensioningArrowFigure != null) {
						// duration observation or constraint
						final Dimension size = dimensioningArrowFigure.getPreferredSize();
						if (constraint.width == Integer.MAX_VALUE) {
							// it has no end => set the right side of the compartment as the end
							child.setBounds(new Rectangle(constraint.x, constraint.y, clientArea.width - constraint.x, size.height));
						} else {
							child.setBounds(new Rectangle(constraint.x, constraint.y, constraint.width, size.height));
						}
					} else if (generalOrderingHorizontalFigure != null) {
						// general ordering
						final Dimension size = generalOrderingHorizontalFigure.getPreferredSize();
						child.setBounds(new Rectangle(constraint.x, constraint.y, constraint.width, size.height));
					}
				}
			}

			@Override
			protected Dimension calculatePreferredSize(final IFigure container, final int wHint, final int hHint) {
				return new Dimension(-1, -1);
			}
		});

		return figure;
	}

	protected static IFigure getOccurrenceChild(final IFigure child) {
		IFigure occurrenceFigure = FigureUtils.findChildFigureInstance(child, SmallSquareFigure.class);
		if (occurrenceFigure == null) {
			occurrenceFigure = FigureUtils.findChildFigureInstance(child, CrossFigure.class);
		}
		return occurrenceFigure;
	}

	protected static IFigure findNextStateChangeOccurrence(final List<IFigure> children, final int startIndex) {
		for (int i = startIndex; i < children.size() - 1; i++) {
			final IFigure figure1 = children.get(i);
			final IFigure figure2 = children.get(i + 1);
			// an OccurrenceSpecification followed by a StateInvariant means a state change
			if (getOccurrenceChild(figure1) != null && FigureUtils.findChildFigureInstance(figure2, CompactStateFigure.class) != null) {
				return figure1;
			}
		}
		return null;
	}

	/**
	 * Hide the scrollbar
	 * 
	 * @see http://wiki.eclipse.org/Papyrus_Developer_Guide/NoScrollbar
	 */
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		((ResizableCompartmentFigure) getFigure()).getScrollPane().setScrollBarVisibility(org.eclipse.draw2d.ScrollPane.NEVER);
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
		if (request instanceof CreateConnectionRequest) {
			final CreateConnectionRequest createConnectionRequest = (CreateConnectionRequest) request;
			if (RequestConstants.REQ_CONNECTION_START.equals(request.getType())) {
				if (createConnectionRequest.getTargetEditPart() instanceof CompactLifelineCompartmentEditPartCN) {
					createConnectionRequest.setTargetEditPart(getParent());
				}
				return getParent().getCommand(request);
			} else if (RequestConstants.REQ_CONNECTION_END.equals(request.getType())) {
				if (createConnectionRequest.getSourceEditPart() instanceof CompactLifelineCompartmentEditPartCN) {
					createConnectionRequest.setSourceEditPart(getParent());
				}
				return getParent().getCommand(request);
			}
		}
		return super.getCommand(request);
	}
}
