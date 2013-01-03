/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.policies;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.NonResizableEditPolicyEx;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands.RefreshCommandForDo;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands.RefreshCommandForUndo;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.FigureUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.ViewUtils;

/**
 * Handles re-ordering Views inside their compartment through drag&drop. This policy is meant to be installed on a list
 * compartment.
 */
// meant to be overridden
@SuppressWarnings("static-method")
public class GenericListCompartmentLayoutEditPolicy extends ConstrainedToolbarLayoutEditPolicy {

	private static final int LAYOUT_FEEDBACK_HEIGHT = 4;
	private static final int MARGIN_BEFORE_FIRST = 4;
	private static final int MARGIN_AFTER_LAST = 4;

	protected IFigure layoutFeedbackFigure = null;

	protected GraphicalEditPart getEditPartToRefresh() {
		return (GraphicalEditPart) getHost();
	}

	protected int getLayoutFeedbackHeight() {
		return LAYOUT_FEEDBACK_HEIGHT;
	}

	@Override
	protected EditPolicy createChildEditPolicy(final EditPart child) {
		EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
		if (result == null) {
			// add an edit policy so that children can be moved
			result = new NonResizableEditPolicyEx();
		}
		return result;
	}

	@Override
	protected Command getMoveChildrenCommand(final Request request) {
		if (request instanceof ChangeBoundsRequest) {
			final ChangeBoundsRequest changeBoundsRequest = (ChangeBoundsRequest) request;

			final InsertionPoint insertionPoint = computeClosestInsertionPoint(changeBoundsRequest.getLocation().y);
			if (insertionPoint == null) {
				return UnexecutableCommand.INSTANCE;
			}

			final GraphicalEditPart hostEditPart = (GraphicalEditPart) getHost();
			final View compartmentView = (View) hostEditPart.getModel();
			@SuppressWarnings("unchecked")
			final List<EditPart> editParts = changeBoundsRequest.getEditParts();
			for (final EditPart editPart : editParts) {
				if (editPart instanceof GraphicalEditPart) {
					final GraphicalEditPart graphicalEditPart = (GraphicalEditPart) editPart;
					final View view = (View) graphicalEditPart.getModel();

					final GraphicalEditPart editPartToRefresh = getEditPartToRefresh();
					final CompoundCommand compoundCommand = new CompoundCommand();
					compoundCommand.add(new RefreshCommandForUndo(editPartToRefresh));
					compoundCommand.add(new ICommandProxy(ViewUtils.getMoveViewCommand(compartmentView, view, insertionPoint.getIndex())));
					compoundCommand.add(new RefreshCommandForDo(editPartToRefresh));
					return compoundCommand;
				}
			}
		}
		return null;
	}

	@Override
	protected void showLayoutTargetFeedback(final Request request) {
		if (request instanceof ChangeBoundsRequest) {
			eraseLayoutTargetFeedback();
			final ChangeBoundsRequest changeBoundsRequest = (ChangeBoundsRequest) request;

			final InsertionPoint insertionPoint = computeClosestInsertionPoint(changeBoundsRequest.getLocation().y);
			if (insertionPoint == null) {
				return;
			}

			final Rectangle containerBounds = new Rectangle(getHostFigure().getBounds());
			getHostFigure().translateToAbsolute(containerBounds);
			final int layoutFeedbackHeight = getLayoutFeedbackHeight();
			final Rectangle feedbackBounds = new Rectangle(containerBounds.x, insertionPoint.getLocation() - layoutFeedbackHeight / 2, containerBounds.width,
					layoutFeedbackHeight);

			final Point origin = FigureUtils.getLayeredPaneOrigin(getHostFigure());
			feedbackBounds.translate(origin);
			final double scale = FigureUtils.getScale(getHostFigure());
			feedbackBounds.width *= scale;
			feedbackBounds.height *= scale;
			this.layoutFeedbackFigure = createLayoutTargetFeedbackFigure(feedbackBounds);
		}
	}

	protected class InsertionPoint {
		int index;
		int location;

		public InsertionPoint(final int index, final int location) {
			this.index = index;
			this.location = location;
		}

		public int getIndex() {
			return this.index;
		}

		public int getLocation() {
			return this.location;
		}
	}

	protected InsertionPoint computeClosestInsertionPoint(final int offset) {
		@SuppressWarnings("unchecked")
		final List<GraphicalEditPart> children = getHost().getChildren();
		if (children.isEmpty()) {
			return null;
		}
		final List<InsertionPoint> insertionPoints = computeInsertionPoints(children);

		final TreeMap<Integer, InsertionPoint> distanceMap = new TreeMap<Integer, InsertionPoint>();
		for (final InsertionPoint insertionPoint : insertionPoints) {
			final int distance = Math.abs(offset - insertionPoint.getLocation());
			distanceMap.put(Integer.valueOf(distance), insertionPoint);
		}
		final Entry<Integer, InsertionPoint> firstEntry = distanceMap.firstEntry();
		return firstEntry.getValue();
	}

	protected int getMarginBeforeFirst() {
		return MARGIN_BEFORE_FIRST;
	}

	protected int getMarginAfterLast() {
		return MARGIN_AFTER_LAST;
	}

	protected List<InsertionPoint> computeInsertionPoints(final List<GraphicalEditPart> children) {
		final int size = children.size();
		final List<InsertionPoint> insertionPoints = new ArrayList<GenericListCompartmentLayoutEditPolicy.InsertionPoint>();
		Rectangle previousBounds = null;
		for (int i = 0; i < size; i++) {
			final GraphicalEditPart childEditPart = children.get(i);
			final Rectangle bounds = new Rectangle(childEditPart.getFigure().getBounds());
			getHostFigure().translateToAbsolute(bounds);

			if (previousBounds != null) {
				// an insertion point between two figures
				insertionPoints.add(new InsertionPoint(i, (previousBounds.y + previousBounds.height + bounds.y) / 2));
			} else {
				// an insertion point before the first figure
				insertionPoints.add(new InsertionPoint(i, bounds.y - getMarginBeforeFirst()));
			}
			if (i == size - 1) {
				// last insertion point: after the last figure
				insertionPoints.add(new InsertionPoint(i + 1, bounds.y + bounds.height + getMarginAfterLast()));
			}
			previousBounds = bounds;
		}
		return insertionPoints;
	}

	protected IFigure createLayoutTargetFeedbackFigure(final Rectangle bounds) {
		final RectangleFigure r = new RectangleFigure();
		r.setForegroundColor(ColorConstants.darkBlue);
		r.setBackgroundColor(ColorConstants.lightBlue);
		r.setBounds(bounds);
		r.validate();
		addFeedback(r);
		return r;
	}

	@Override
	protected void eraseLayoutTargetFeedback(final Request request) {
		eraseLayoutTargetFeedback();
	}

	protected void eraseLayoutTargetFeedback() {
		if (this.layoutFeedbackFigure != null) {
			removeFeedback(this.layoutFeedbackFigure);
			this.layoutFeedbackFigure = null;
		}
	}

	@Override
	protected Command getCreateCommand(final CreateRequest request) {
		return null;
	}

}
