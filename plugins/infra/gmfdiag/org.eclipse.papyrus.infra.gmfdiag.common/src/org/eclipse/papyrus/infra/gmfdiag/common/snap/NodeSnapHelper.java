/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Vincent Lorenzo - CEA LIST
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.common.snap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.tools.DragEditPartsTracker;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.ruler.SnapToHelperUtil;

/**
 * 
 * this class allows to determine the best location for a node on the grid
 * 
 * Adapted code from DragEditPartsTrackerEx
 * TODO : PapyrusDragEditPartTracker should use me
 */
@SuppressWarnings("restriction")
public class NodeSnapHelper {

	/**
	 * if true, we snap on the four corner of the figures
	 */
	protected final boolean snapOnCorners;

	/**
	 * if true, we snap on the four middle side of the figures
	 */
	protected final boolean snapOnMiddles;

	/**
	 * if true, we snap on the center of the figure
	 */
	protected final boolean snapOnCenter;

	/**
	 * the snap helper to use
	 */
	private SnapToHelper helper;

	/**
	 * the bounds of the figure to snap
	 */
	private Rectangle figureToSnapBounds;

	/**
	 * the compoundSourceRectangle, see {@link DragEditPartsTracker} for further informations
	 */
	private Rectangle compoundSourceRectangle;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param helper
	 *        the snap helper
	 * @param figureToSnapBounds
	 *        the bounds of the figure to snap
	 * 
	 */
	public NodeSnapHelper(final SnapToHelper helper, final Rectangle figureToSnapBounds) {
		this(helper, figureToSnapBounds, figureToSnapBounds);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param helper
	 *        the snap helper
	 * @param figureToSnapBounds
	 *        the bounds of the figure to snap
	 * @param compoundSourceRectangle
	 *        see {@link DragEditPartsTracker} for further informations
	 */
	public NodeSnapHelper(final SnapToHelper helper, final Rectangle figureToSnapBounds, final Rectangle compoundSourceRectangle) {
		this(helper, figureToSnapBounds, compoundSourceRectangle, true, false, false);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param helper
	 * @param figureToSnapBounds
	 * @param snapOnCorners
	 * @param snapOnMiddles
	 * @param snapOnCenter
	 */
	public NodeSnapHelper(final SnapToHelper helper, final Rectangle figureToSnapBounds, final boolean snapOnCorners, final boolean snapOnMiddles, final boolean snapOnCenter) {
		this(helper, figureToSnapBounds, figureToSnapBounds, snapOnCorners, snapOnMiddles, snapOnCenter);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param helper
	 * @param figureToSnapBounds
	 * @param compoundSourceRectangle
	 * @param snapOnCorners
	 * @param snapOnMiddles
	 * @param snapOnCenter
	 */
	public NodeSnapHelper(final SnapToHelper helper, final Rectangle figureToSnapBounds, final Rectangle compoundSourceRectangle, final boolean snapOnCorners, final boolean snapOnMiddles, final boolean snapOnCenter) {
		this.helper = helper;
		this.figureToSnapBounds = figureToSnapBounds;
		this.compoundSourceRectangle = compoundSourceRectangle;
		this.snapOnCorners = snapOnCorners;
		this.snapOnMiddles = snapOnMiddles;
		this.snapOnCenter = snapOnCenter;
	}

	/**
	 * This method can be overridden by clients to customize the snapping
	 * behavior.
	 * 
	 * @param request
	 *        the <code>ChangeBoundsRequest</code> from which the move delta
	 *        can be extracted and updated
	 *        We use <code>ChangeBoundsRequest</code> to be compatible with snap edit part tracker!
	 */
	@SuppressWarnings({ "unchecked" })
	public void snapPoint(ChangeBoundsRequest request) {
		if(getSnapToHelper() != null && request.isSnapToEnabled()) {

			//test to know if we are moving using keyboard
			//TODO not useful here
			//			if(!getCurrentInput().isAnyButtonDown()) {
			//				calculateSnapPointFromArrowKey(request);
			//				return;
			//			}
			int restrictedDirection = 0;
			restrictedDirection = restrictedDirection | PositionConstants.EAST;
			restrictedDirection = restrictedDirection | PositionConstants.WEST;
			restrictedDirection = restrictedDirection | PositionConstants.SOUTH;
			restrictedDirection = restrictedDirection | PositionConstants.NORTH;
			request.getExtendedData().put(SnapToHelperUtil.RESTRICTED_DIRECTIONS, restrictedDirection);

			final Map<Double, PrecisionPoint> distVSPoint = new HashMap<Double, PrecisionPoint>();
			if(this.snapOnCorners) {
				distVSPoint.putAll(getCornerDistances(request));
			}

			if(this.snapOnMiddles) {
				distVSPoint.putAll(getMiddleDistances(request));
			}

			if(this.snapOnCenter) {
				distVSPoint.putAll(getCenterDistances(request));
			}

			final List<Double> distances = new ArrayList<Double>(distVSPoint.keySet());
			if(distances.size() > 0) {
				double min = distances.get(0);
				for(int i = 1; i < distances.size() - 1; i++) {
					min = Math.min(min, distances.get(i));
				}
				request.setMoveDelta(distVSPoint.get(min));
			}
		}
	}

	/**
	 * 
	 * @param request
	 *        a move request
	 * @return
	 *         the restricted direction for the request
	 */
	protected final int getRestrictedDirection(final ChangeBoundsRequest request) {
		int restrictedDirection = 0;
		final Point delta = request.getMoveDelta();
		if(delta.x > 0) {
			restrictedDirection = restrictedDirection | PositionConstants.EAST;
			restrictedDirection = restrictedDirection | PositionConstants.WEST;
		}
		if(delta.x < 0) {
			restrictedDirection = restrictedDirection | PositionConstants.EAST;
			restrictedDirection = restrictedDirection | PositionConstants.WEST;
		}
		if(delta.y > 0) {
			restrictedDirection = restrictedDirection | PositionConstants.SOUTH;
			restrictedDirection = restrictedDirection | PositionConstants.NORTH;
		}
		if(delta.y < 0) {
			restrictedDirection = restrictedDirection | PositionConstants.SOUTH;
			restrictedDirection = restrictedDirection | PositionConstants.NORTH;
		}
		return restrictedDirection;
	}

	/**
	 * 
	 * @param request
	 *        the move request
	 */
	@SuppressWarnings("unchecked")
	protected void calculateSnapPointFromArrowKey(final ChangeBoundsRequest request) {
		if(request.getEditParts().size() == 0) {
			return;
		}
		final Object ep = request.getEditParts().get(0);
		if(!(ep instanceof IGraphicalEditPart)) {
			return;
		}
		final RootEditPart root = ((IGraphicalEditPart)ep).getRoot();
		if(!(root instanceof DiagramRootEditPart)) {
			return;
		}
		final double gridSpacing = ((DiagramRootEditPart)root).getGridSpacing();
		int max = (int)(1 + gridSpacing);
		int restrictedDirection = getRestrictedDirection(request);
		final Point delta = request.getMoveDelta();
		final Point newDelta = new Point(0, 0);
		int newMove = 0;
		while(newMove < max) {
			newMove++;
			if(delta.x > 0) {
				newDelta.x = (int)newMove + delta.x;
			}
			if(delta.x < 0) {
				newDelta.x = (-newMove) + delta.x;
			}
			if(delta.y > 0) {
				newDelta.y = newMove + delta.y;
			}
			if(delta.y < 0) {
				newDelta.y = (-newMove) + delta.y;
			}
			request.setMoveDelta(newDelta);
			request.getExtendedData().put(SnapToHelperUtil.RESTRICTED_DIRECTIONS, restrictedDirection);

			final Map<Double, PrecisionPoint> distVSPoint = new HashMap<Double, PrecisionPoint>();
			if(this.snapOnCorners) {
				distVSPoint.putAll(getCornerDistances(request));
			}

			if(this.snapOnMiddles) {
				distVSPoint.putAll(getMiddleDistances(request));
			}

			if(this.snapOnCenter) {
				distVSPoint.putAll(getCenterDistances(request));
			}

			final List<Double> distances = new ArrayList<Double>(distVSPoint.keySet());
			if(distances.size() > 0) {
				double min = distances.get(0);
				//We look for the minus distance
				for(int i = 1; i < distances.size() - 1; i++) {
					min = Math.min(min, distances.get(i));
				}
				final Point minPoint = distVSPoint.get(min);
				//the distance can't be null
				if(minPoint.x != 0 || minPoint.y != 0) {
					//the calculate move must be in the same direction than the keyboard move 
					if(Integer.signum(minPoint.x) == Integer.signum(delta.x) && Integer.signum(minPoint.y) == Integer.signum(delta.y)) {
						request.setMoveDelta(distVSPoint.get(min));
						return;
					}
				}
			}
		}
	}

	/**
	 * 
	 * @param request
	 * @return
	 *         a map with the couple distance and delta point to anchor by the corner of the figure
	 */
	protected Map<Double, PrecisionPoint> getCornerDistances(final ChangeBoundsRequest request) {
		final Map<Double, PrecisionPoint> distVSPoints = new HashMap<Double, PrecisionPoint>();
		if(getSnapToHelper() != null && request.isSnapToEnabled()) {
			final Point moveDelta = request.getMoveDelta();
			PrecisionRectangle jointRect = getCompoundSourceRectangle();
			jointRect.translate(moveDelta);

			//calculate the delta to anchor on the top left corner
			final PrecisionPoint topLeftCornerDelta = new PrecisionPoint(moveDelta);
			final PrecisionRectangle baseRectTopLeft = getSourceRectangle();
			baseRectTopLeft.translate(moveDelta);
			getSnapToHelper().snapPoint(request, PositionConstants.HORIZONTAL | PositionConstants.VERTICAL, new PrecisionRectangle[]{ baseRectTopLeft, jointRect }, topLeftCornerDelta);

			//calculate the delta to anchor on the top right corner
			final PrecisionPoint topRightCornerDelta = new PrecisionPoint(moveDelta);
			final PrecisionRectangle baseRectTopRight = getSourceRectangle();
			baseRectTopRight.setX(baseRectTopRight.x + baseRectTopRight.width);
			baseRectTopRight.translate(moveDelta);
			getSnapToHelper().snapPoint(request, PositionConstants.HORIZONTAL | PositionConstants.VERTICAL, new PrecisionRectangle[]{ baseRectTopRight, jointRect }, topRightCornerDelta);

			//calculate the delta to anchor on the bottom left corner
			final PrecisionPoint bottomLeftCornerDelta = new PrecisionPoint(moveDelta);
			final PrecisionRectangle baseRectBottomLeft = getSourceRectangle();
			baseRectBottomLeft.setY(baseRectBottomLeft.y + baseRectBottomLeft.height);
			baseRectBottomLeft.translate(moveDelta);
			getSnapToHelper().snapPoint(request, PositionConstants.HORIZONTAL | PositionConstants.VERTICAL, new PrecisionRectangle[]{ baseRectBottomLeft, jointRect }, bottomLeftCornerDelta);

			//calculate the delta to anchor on the bottom right corner
			final PrecisionPoint bottomRightCornerDelta = new PrecisionPoint(moveDelta);
			final PrecisionRectangle baseRectBottomRight = getSourceRectangle();
			baseRectBottomRight.setX(baseRectBottomRight.x + baseRectBottomRight.width);
			baseRectBottomRight.setY(baseRectBottomRight.y + baseRectBottomRight.height);
			baseRectBottomRight.translate(moveDelta);
			getSnapToHelper().snapPoint(request, PositionConstants.HORIZONTAL | PositionConstants.VERTICAL, new PrecisionRectangle[]{ baseRectBottomRight, jointRect }, bottomRightCornerDelta);

			final Point ref = baseRectTopLeft.getTopLeft();
			distVSPoints.put(distance(ref, topLeftCornerDelta), topLeftCornerDelta);
			//			distVSPoints.put(distance(ref, topRightCornerDelta), topRightCornerDelta);
			//			distVSPoints.put(distance(ref, bottomLeftCornerDelta), bottomLeftCornerDelta);
			//			distVSPoints.put(distance(ref, bottomRightCornerDelta), bottomRightCornerDelta);
		}
		return distVSPoints;
	}

	/**
	 * 
	 * @param request
	 * @return
	 *         a map with the couple distance and delta point to anchor by the middle of each side of the figure
	 */
	protected Map<Double, PrecisionPoint> getMiddleDistances(final ChangeBoundsRequest request) {
		final Map<Double, PrecisionPoint> distVSPoints = new HashMap<Double, PrecisionPoint>();
		if(getSnapToHelper() != null && request.isSnapToEnabled()) {
			final Point moveDelta = request.getMoveDelta();

			PrecisionRectangle jointRect = getCompoundSourceRectangle();
			jointRect.translate(moveDelta);
			//calculate the delta to anchor on the middle top point
			final PrecisionPoint middleTopDelta = new PrecisionPoint(moveDelta);
			final PrecisionRectangle baseRectMiddleTop = getSourceRectangle();
			baseRectMiddleTop.setPreciseLocation(baseRectMiddleTop.preciseX() + (baseRectMiddleTop.preciseWidth() / 2), baseRectMiddleTop.preciseY());
			baseRectMiddleTop.translate(moveDelta);
			getSnapToHelper().snapPoint(request, PositionConstants.HORIZONTAL | PositionConstants.VERTICAL, new PrecisionRectangle[]{ baseRectMiddleTop, jointRect }, middleTopDelta);

			//calculate the delta to anchor on the middle left point
			final PrecisionPoint middleLeftDelta = new PrecisionPoint(moveDelta);
			final PrecisionRectangle baseRectMiddleLeft = getSourceRectangle();
			baseRectMiddleLeft.setPreciseLocation(baseRectMiddleLeft.preciseX(), baseRectMiddleLeft.preciseY() + (baseRectMiddleLeft.preciseWidth() / 2));
			baseRectMiddleLeft.translate(moveDelta);
			getSnapToHelper().snapPoint(request, PositionConstants.HORIZONTAL | PositionConstants.VERTICAL, new PrecisionRectangle[]{ baseRectMiddleLeft, jointRect }, middleLeftDelta);

			//calculate the delta to anchor on the middle right point
			final PrecisionPoint middleRightDelta = new PrecisionPoint(moveDelta);
			final PrecisionRectangle baseRectMiddleRight = getSourceRectangle();
			baseRectMiddleRight.setPreciseLocation(baseRectMiddleRight.preciseX() + baseRectMiddleRight.preciseWidth(), baseRectMiddleRight.preciseY() + (baseRectMiddleRight.preciseHeight() / 2));
			baseRectMiddleRight.translate(moveDelta);
			getSnapToHelper().snapPoint(request, PositionConstants.HORIZONTAL | PositionConstants.VERTICAL, new PrecisionRectangle[]{ baseRectMiddleRight, jointRect }, middleRightDelta);

			//calculate the delta to anchor on the middle bottom
			final PrecisionPoint middleBottomDelta = new PrecisionPoint(moveDelta);
			final PrecisionRectangle baseRectMiddleBottom = getSourceRectangle();
			baseRectMiddleBottom.setPreciseLocation(baseRectMiddleBottom.preciseX() + (baseRectMiddleBottom.preciseWidth() / 2), baseRectMiddleBottom.preciseY() + baseRectMiddleBottom.preciseHeight());
			baseRectMiddleBottom.translate(moveDelta);
			getSnapToHelper().snapPoint(request, PositionConstants.HORIZONTAL | PositionConstants.VERTICAL, new PrecisionRectangle[]{ baseRectMiddleBottom, jointRect }, middleBottomDelta);

			final Point ref = baseRectMiddleTop.getTopLeft();
			distVSPoints.put(distance(ref, middleTopDelta), middleTopDelta);
			distVSPoints.put(distance(ref, middleLeftDelta), middleLeftDelta);
			distVSPoints.put(distance(ref, middleRightDelta), middleRightDelta);
			distVSPoints.put(distance(ref, middleBottomDelta), middleBottomDelta);
		}

		return distVSPoints;
	}

	/**
	 * 
	 * @param request
	 * @return
	 *         a map with the couple distance and delta point to anchor by the center of the figure
	 */
	protected Map<Double, PrecisionPoint> getCenterDistances(final ChangeBoundsRequest request) {
		final Map<Double, PrecisionPoint> distVSPoints = new HashMap<Double, PrecisionPoint>();
		if(getSnapToHelper() != null && request.isSnapToEnabled()) {
			final Point moveDelta = request.getMoveDelta();

			PrecisionRectangle jointRect = getCompoundSourceRectangle();
			jointRect.translate(moveDelta);
			//calculate the delta to anchor on the middle top point
			final PrecisionPoint centerDelta = new PrecisionPoint(moveDelta);
			final PrecisionRectangle baseRectCenter = getSourceRectangle();
			baseRectCenter.setPreciseLocation(baseRectCenter.preciseX() + (baseRectCenter.preciseWidth() / 2), baseRectCenter.preciseY() + (baseRectCenter.preciseHeight() / 2));
			baseRectCenter.translate(moveDelta);
			getSnapToHelper().snapPoint(request, PositionConstants.HORIZONTAL | PositionConstants.VERTICAL, new PrecisionRectangle[]{ baseRectCenter, jointRect }, centerDelta);

			final Point ref = baseRectCenter.getTopLeft();
			distVSPoints.put(distance(ref, centerDelta), centerDelta);
		}

		return distVSPoints;
	}

	/**
	 * 
	 * @return
	 *         the compoundSourceRectangle
	 */
	private PrecisionRectangle getCompoundSourceRectangle() {
		return new PrecisionRectangle(this.compoundSourceRectangle);
	}

	/**
	 * 
	 * @return
	 *         the source rectangle
	 */
	private PrecisionRectangle getSourceRectangle() {
		return new PrecisionRectangle(this.figureToSnapBounds);
	}

	/**
	 * 
	 * @param pt1
	 *        a first point
	 * @param pt2
	 *        the second point
	 * @return
	 *         the distance between the two points
	 */
	protected final double distance(final Point pt1, final Point pt2) {
		double deltaX = pt1.preciseX() - pt2.preciseX();
		double deltaY = pt1.preciseY() - pt2.preciseY();
		return Math.hypot(deltaX, deltaY);
	}

	/**
	 * 
	 * @return
	 *         the snap helper
	 */
	protected final SnapToHelper getSnapToHelper() {
		return this.helper;
	}
}
