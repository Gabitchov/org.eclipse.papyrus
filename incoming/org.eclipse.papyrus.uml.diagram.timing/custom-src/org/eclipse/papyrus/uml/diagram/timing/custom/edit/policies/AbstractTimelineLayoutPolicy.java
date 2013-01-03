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
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.timing.custom.Messages;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.parts.CustomCompactLifelineCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.timing.custom.figures.SmallSquareFigure;
import org.eclipse.papyrus.uml.diagram.timing.custom.figures.VerticalMarkFigure;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.Constants;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.ViewUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineCompartmentEditPartCN;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.TimeObservation;
import org.eclipse.uml2.uml.UMLPackage;

/** This factors out common code between the layouts for the compact and full Lifelines. */
public class AbstractTimelineLayoutPolicy extends XYLayoutEditPolicy {

	public static final Request UPDATE_LAYOUT_REQUEST = new Request("UPDATE_LAYOUT"); //$NON-NLS-1$

	@Override
	public Command getCommand(final Request request) {
		if (request instanceof ChangeBoundsRequest && request.getType() == RequestConstants.REQ_ADD) {
			// deny adding an element into another element (since this breaks everything)
			request.setType(REQ_MOVE_CHILDREN);
		}
		if (request == UPDATE_LAYOUT_REQUEST) {
			return getUpdateTimeElementsCommand();
		}
		final Command superCommand = super.getCommand(request);
		// update the locations of time elements each time an element is added or moved in the timeline
		if (superCommand != null && (request instanceof ChangeBoundsRequest || request.getType() == RequestConstants.REQ_CREATE)) {
			final CompoundCommand compoundCommand = new CompoundCommand();
			compoundCommand.add(superCommand);
			compoundCommand.add(getUpdateTimeElementsCommand());
			return compoundCommand;
		}
		return superCommand;
	}

	/**
	 * Returns a command that moves the given node (that represents an OccurrenceSpecification) <code>moveDeltaX</code>
	 * pixels to the right (or left if negative).
	 * 
	 * @param occurrenceSpecificationNode
	 *            the node to move
	 * @param moveDelta
	 *            how much to move
	 * @param timelineCompartmentView
	 *            the parent compartment
	 * @param occurrenceSpecificationIndex
	 *            the index of the OccurrenceSpecification Node in its parent compartment
	 * @param nodesToIgnore
	 *            these nodes will not constrain the new position
	 * @return the command
	 */
	protected static Command getMoveOccurrenceSpecificationCommand(final Node occurrenceSpecificationNode, final Point moveDelta,
			final View timelineCompartmentView, final int occurrenceSpecificationIndex, final List<Node> nodesToIgnore) {
		final LayoutConstraint layoutConstraint = occurrenceSpecificationNode.getLayoutConstraint();
		if (layoutConstraint instanceof Location) {
			final Location location = (Location) layoutConstraint;
			final int posX = location.getX() + moveDelta.x;
			final int posY = location.getY() + moveDelta.y;
			final int min = findMin(timelineCompartmentView, occurrenceSpecificationIndex, nodesToIgnore);
			final int max = findMax(timelineCompartmentView, occurrenceSpecificationIndex, nodesToIgnore);
			final OccurrenceSpecification occurrenceSpecification = (OccurrenceSpecification) occurrenceSpecificationNode.getElement();
			final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(occurrenceSpecification);
			return new ICommandProxy(new AbstractTransactionalCommand(editingDomain, Messages.AbstractTimelineLayoutPolicy_MoveOccurrenceSpecification, null) {
				@Override
				protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
					final Location loc = NotationFactory.eINSTANCE.createLocation();
					// constrain the new position between the previous and next OccurrenceSpecifications
					final int newX = Math.max(Math.min(posX, max), min);
					loc.setX(newX);
					loc.setY(posY);
					occurrenceSpecificationNode.setLayoutConstraint(loc);
					return CommandResult.newOKCommandResult();
				}
			});
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Find the maximum abscissa of the OccurrenceSpecification at the given index
	 * 
	 * @param timelineCompartmentView
	 *            the parent timeline compartment view
	 * @param index
	 *            the index of the OccurrenceSpecification in the compartment view's children
	 * @param nodesToIgnore
	 * @param nodesToIgnore
	 *            these nodes will be ignored when computing the maximum position
	 * @return the maximum abscissa
	 */
	protected static int findMax(final View timelineCompartmentView, final int index, final List<Node> nodesToIgnore) {
		@SuppressWarnings("unchecked")
		final EList<View> children = timelineCompartmentView.getChildren();
		for (int i = index + 1; i < children.size(); i++) {
			final View childView = children.get(i);
			if (!nodesToIgnore.contains(childView) && childView.getElement() instanceof OccurrenceSpecification) {
				final LayoutConstraint layoutConstraint = ((Node) childView).getLayoutConstraint();
				if (layoutConstraint instanceof Location) {
					final Location location = (Location) layoutConstraint;
					return location.getX() - Constants.MINIMUM_DISTANCE_BETWEEN_OCCURRENCE_SPECIFICATIONS;
				}
			}
		}
		return Integer.MAX_VALUE;
	}

	/**
	 * Find the minimum abscissa of the OccurrenceSpecification at the given index
	 * 
	 * @param timelineCompartmentView
	 *            the parent timeline compartment view
	 * @param index
	 *            the index of the OccurrenceSpecification in the compartment view's children
	 * @param nodesToIgnore
	 *            these nodes will be ignored when computing the minimum position
	 * @return the minimum abscissa
	 */
	protected static int findMin(final View timelineCompartmentView, final int index, final List<Node> nodesToIgnore) {
		@SuppressWarnings("unchecked")
		final EList<View> children = timelineCompartmentView.getChildren();
		for (int i = index - 1; i >= 0; i--) {
			final View childView = children.get(i);
			if (!nodesToIgnore.contains(childView) && childView.getElement() instanceof OccurrenceSpecification) {
				final LayoutConstraint layoutConstraint = ((Node) childView).getLayoutConstraint();
				if (layoutConstraint instanceof Location) {
					final Location location = (Location) layoutConstraint;
					return location.getX() + Constants.MINIMUM_DISTANCE_BETWEEN_OCCURRENCE_SPECIFICATIONS;
				}
			}
		}
		return 0;
	}

	/** Returns a command that updates the positions of time elements, relative to the element they are attached to */
	protected Command getUpdateTimeElementsCommand() {
		final GraphicalEditPart timelineCompartmentEditPart = (GraphicalEditPart) getHost();
		final Node compartmentView = (Node) timelineCompartmentEditPart.getModel();
		final boolean compact = timelineCompartmentEditPart instanceof CompactLifelineCompartmentEditPartCN;
		final int width = timelineCompartmentEditPart.getFigure().getSize().width;
		final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(compartmentView);
		return new ICommandProxy(new AbstractTransactionalCommand(editingDomain, Messages.AbstractTimelineLayoutPolicy_UpdateLocationOfTimeElements, null) {
			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				@SuppressWarnings("unchecked")
				final EList<View> children = compartmentView.getChildren();
				for (final View child : children) {
					final EObject element = child.getElement();
					if (element instanceof TimeObservation) {
						final TimeObservation timeObservation = (TimeObservation) element;
						final Node timeObservationNode = ((Node) child);
						updateTimeElementLocation(timeObservationNode, timeObservation.getEvent(), children, compact, width);
					} else if (element instanceof TimeConstraint) {
						final TimeConstraint timeConstraint = (TimeConstraint) element;
						final Node timeConstraintNode = ((Node) child);
						final EList<Element> constrainedElements = timeConstraint.getConstrainedElements();
						if (constrainedElements.size() > 0) {
							final Element constrainedElement = constrainedElements.get(0);
							updateTimeElementLocation(timeConstraintNode, constrainedElement, children, compact, width);
						}
					} else if (element instanceof DurationObservation) {
						final DurationObservation durationObservation = (DurationObservation) element;
						final Node durationObservationNode = ((Node) child);
						final EList<NamedElement> events = durationObservation.getEvents();
						if (events.size() == 2) {
							final Element startElement = events.get(0);
							final Element endElement = events.get(1);
							updateDurationElementLocation(durationObservationNode, startElement, endElement, children);
						} else if (events.size() == 1) {
							final Element startEndElement = events.get(0);
							updateDurationElementLocation(durationObservationNode, startEndElement, startEndElement, children);
						}
					} else if (element instanceof DurationConstraint) {
						final DurationConstraint durationConstraint = (DurationConstraint) element;
						final Node durationConstraintNode = ((Node) child);
						final EList<Element> elements = durationConstraint.getConstrainedElements();
						if (elements.size() == 2) {
							final Element startElement = elements.get(0);
							final Element endElement = elements.get(1);
							updateDurationElementLocation(durationConstraintNode, startElement, endElement, children);
						} else if (elements.size() == 1) {
							final Element startEndElement = elements.get(0);
							updateDurationElementLocation(durationConstraintNode, startEndElement, startEndElement, children);
						}
					} else if (element instanceof GeneralOrdering) {
						final GeneralOrdering generalOrdering = (GeneralOrdering) element;
						final Node generalOrderingNode = ((Node) child);

						final OccurrenceSpecification before = generalOrdering.getBefore();
						final OccurrenceSpecification after = generalOrdering.getAfter();
						updateGeneralOrderingLocation(generalOrderingNode, before, after, children);
					}
				}
				return CommandResult.newOKCommandResult();
			}
		});
	}

	/**
	 * Set the horizontal location of the given time element View, so that it is aligned with its associated element
	 * 
	 * @param timeElementNode
	 *            the element to align
	 * @param alignmentElement
	 *            the element to align to
	 * @param timelineViews
	 *            the views contained in the timeline
	 * @param compact
	 *            whether this is a compact timeline
	 * @param max
	 *            the position to give the element if it has no end
	 */
	protected static void updateTimeElementLocation(final Node timeElementNode, final EObject alignmentElement, final EList<View> timelineViews,
			final boolean compact, final int max) {
		int occurrencePositionBefore = -1;
		int occurrencePositionAfter = -1;
		int lastOccurrencePosition = -1;
		boolean after = false;
		for (final View view : timelineViews) {
			if (view instanceof Node && ViewUtils.isViewFor(view, UMLPackage.eINSTANCE.getOccurrenceSpecification())) {
				final Node node = (Node) view;
				final LayoutConstraint layoutConstraint = node.getLayoutConstraint();
				if (layoutConstraint instanceof Location) {
					final Location location = (Location) layoutConstraint;
					lastOccurrencePosition = location.getX();
				}
			}
			if (after && view instanceof Node && ViewUtils.isViewFor(view, UMLPackage.eINSTANCE.getStateInvariant())) {
				// we found the first state change after the alignmentElement => memorize the occurrence position
				occurrencePositionAfter = lastOccurrencePosition;
				after = false;
			}
			if (view.getElement() == alignmentElement) {
				// memorize the first occurrence position before the alignmentElement
				occurrencePositionBefore = lastOccurrencePosition;
				after = true;
			}
		}

		boolean firstEvent = true;
		final EObject element = timeElementNode.getElement();
		if (element instanceof TimeObservation) {
			final TimeObservation timeObservation = (TimeObservation) element;
			firstEvent = timeObservation.isFirstEvent();
		} else if (element instanceof TimeConstraint) {
			final TimeConstraint timeConstraint = (TimeConstraint) element;
			firstEvent = timeConstraint.isFirstEvent();
		}

		if (firstEvent) {
			if (occurrencePositionBefore != -1) {
				setTimeElementNodeLocation(timeElementNode, occurrencePositionBefore);
			} else {
				if (compact) {
					setTimeElementNodeLocation(timeElementNode, CustomCompactLifelineCompartmentEditPart.FIRST_STATE_OFFSET);
				} else {
					setTimeElementNodeLocation(timeElementNode, 0);
				}
			}
		} else {
			if (occurrencePositionAfter != -1) {
				setTimeElementNodeLocation(timeElementNode, occurrencePositionAfter);
			} else {
				// the margin avoids the element pushing the rest outside
				final int margin = 5;
				setTimeElementNodeLocation(timeElementNode, max - margin);
			}
		}
	}

	/**
	 * Set the horizontal location of the given duration element View, so that it is aligned with its associated start
	 * and end elements
	 * 
	 * @param durationElementNode
	 *            the element to align
	 * @param startElement
	 *            the start element of the duration
	 * @param endElement
	 *            the end element of the duration
	 * @param timelineViews
	 *            the views contained in the timeline
	 */
	protected void updateDurationElementLocation(final Node durationElementNode, final Element startElement, final Element endElement,
			final EList<View> timelineViews) {
		int lastOccurrencePosition = getOriginX();
		int startPos = getOriginX();
		int endPos = -1;
		boolean onEndElement = false;
		for (final View view : timelineViews) {
			if (view instanceof Node) {
				final Node node = (Node) view;
				final LayoutConstraint layoutConstraint = node.getLayoutConstraint();
				final Location location = (Location) layoutConstraint;
				if (onEndElement && ViewUtils.isViewFor(view, UMLPackage.eINSTANCE.getDestructionOccurrenceSpecification())) {
					// if there is a DestructionOccurrenceSpecification, then the duration must end on it
					endPos = location.getX() + SmallSquareFigure.RADIUS + 1;
					onEndElement = false;
				}
				if (ViewUtils.isViewFor(view, UMLPackage.eINSTANCE.getOccurrenceSpecification())) {
					lastOccurrencePosition = location.getX();
				} else if (ViewUtils.isViewFor(view, UMLPackage.eINSTANCE.getStateInvariant())) {
					if (onEndElement) {
						endPos = lastOccurrencePosition + SmallSquareFigure.RADIUS + 1;
						onEndElement = false;
					}
				}
			}
			if (view.getElement() == startElement) {
				startPos = lastOccurrencePosition + SmallSquareFigure.RADIUS;
			}
			if (view.getElement() == endElement) {
				if (endElement instanceof OccurrenceSpecification) {
					endPos = lastOccurrencePosition + SmallSquareFigure.RADIUS + 1;
				} else {
					// on a StateInvariant => the next state change (an OccurrenceSpecification followed by
					// a StateInvariant) will determine the end of the StateInvariant
					onEndElement = true;
				}
			}
		}

		if (endPos == -1) {
			// the endElement has no end
			endPos = Integer.MAX_VALUE;
		}
		setDurationElementNodeLocation(durationElementNode, startPos, endPos);

	}

	// meant to be overridden
	@SuppressWarnings("static-method")
	protected int getOriginX() {
		return 0;
	}

	/**
	 * Set the location of the given time element to the given horizontal coordinate. The vertical coordinate is set to
	 * the location where the user clicked initially. Then we let the user change the vertical coordinate freely.
	 */
	protected static void setTimeElementNodeLocation(final Node timeElementNode, final int x) {
		final LayoutConstraint layoutConstraint = timeElementNode.getLayoutConstraint();
		final Location timeElementLocation;
		final int y;
		// it is a Bounds element when created; we change it to a Location
		if (layoutConstraint instanceof Bounds) {
			final Bounds initialBounds = (Bounds) layoutConstraint;
			timeElementLocation = NotationFactory.eINSTANCE.createLocation();
			// place it above the location where the user clicked
			y = initialBounds.getY() - VerticalMarkFigure.PREFERRED_HEIGHT - 5;
		} else if (layoutConstraint instanceof Location) {
			timeElementLocation = (Location) layoutConstraint;
			y = timeElementLocation.getY();
		} else {
			timeElementLocation = NotationFactory.eINSTANCE.createLocation();
			y = 0;
		}

		timeElementLocation.setX(x);
		timeElementLocation.setY(y);
		timeElementNode.setLayoutConstraint(timeElementLocation);
	}

	/**
	 * Set the location of the given duration node
	 * 
	 * @param durationElementNode
	 *            the node to position
	 * @param startPos
	 *            the horizontal starting position
	 * @param endPos
	 *            the horizontal ending position
	 */
	private static void setDurationElementNodeLocation(final Node durationElementNode, final int startPos, final int endPos) {
		final LayoutConstraint layoutConstraint = durationElementNode.getLayoutConstraint();

		final Bounds bounds;
		if (layoutConstraint instanceof Bounds) {
			bounds = (Bounds) layoutConstraint;
		} else {
			bounds = NotationFactory.eINSTANCE.createBounds();
			durationElementNode.setLayoutConstraint(bounds);
		}
		bounds.setX(startPos);
		if (endPos == Integer.MAX_VALUE) {
			bounds.setWidth(Integer.MAX_VALUE);
		} else {
			bounds.setWidth(endPos - startPos);
		}
	}

	/**
	 * Set the location of the given GeneralOrdering node so that it is aligned with the given <code>before</code> and
	 * <code>after</code> occurrences.
	 * 
	 * @param generalOrderingNode
	 *            the node to align
	 * @param before
	 *            the start element
	 * @param after
	 *            the end element
	 * @param timelineViews
	 *            all the Views in the timeline
	 */
	protected static void updateGeneralOrderingLocation(final Node generalOrderingNode, final OccurrenceSpecification before,
			final OccurrenceSpecification after, final EList<View> timelineViews) {
		int startPos = -1;
		int endPos = -1;
		for (final View view : timelineViews) {
			if (view instanceof Node) {
				final Node node = (Node) view;
				final LayoutConstraint layoutConstraint = node.getLayoutConstraint();
				final Location location = (Location) layoutConstraint;
				if (view.getElement() == before) {
					startPos = location.getX() + SmallSquareFigure.RADIUS;
				}
				if (view.getElement() == after) {
					endPos = location.getX() + SmallSquareFigure.RADIUS + 1;
				}
			}
		}
		if (startPos != -1 && endPos != -1) {
			setGeneralOrderingNodeLocation(generalOrderingNode, startPos, endPos);
		}
	}

	/**
	 * Set the location of the given {@link GeneralOrdering} node
	 * 
	 * @param generalOrderingNode
	 *            the node to position
	 * @param startPos
	 *            the horizontal starting position
	 * @param endPos
	 *            the horizontal ending position
	 */
	private static void setGeneralOrderingNodeLocation(final Node generalOrderingNode, final int startPos, final int endPos) {
		final LayoutConstraint layoutConstraint = generalOrderingNode.getLayoutConstraint();
		final Bounds bounds;
		if (layoutConstraint instanceof Bounds) {
			bounds = (Bounds) layoutConstraint;
		} else {
			bounds = NotationFactory.eINSTANCE.createBounds();
			generalOrderingNode.setLayoutConstraint(bounds);
		}
		bounds.setX(startPos);
		bounds.setWidth(endPos - startPos);
	}

}
