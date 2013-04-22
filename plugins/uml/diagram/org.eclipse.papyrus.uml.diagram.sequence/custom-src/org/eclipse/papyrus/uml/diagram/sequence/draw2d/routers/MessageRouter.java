/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.draw2d.routers;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Ray;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.draw2d.ui.figures.BaseSlidableAnchor;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.draw2d.ui.figures.OrthogonalConnectionAnchor;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.PointListUtilities;
import org.eclipse.gmf.runtime.draw2d.ui.internal.routers.ObliqueRouter;
import org.eclipse.gmf.runtime.draw2d.ui.internal.routers.OrthogonalRouterUtilities;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.papyrus.uml.diagram.sequence.edit.helpers.AnchorHelper;
import org.eclipse.papyrus.uml.diagram.sequence.figures.LifelineFigure;
import org.eclipse.papyrus.uml.diagram.sequence.figures.MessageAsync;
import org.eclipse.papyrus.uml.diagram.sequence.figures.MessageCreate;

/**
 * A multi behavior router which enable to draw message.
 * It can behave as an oblique router (with no bendpoint), or as an horizontal router (with no bendpoint),
 * or as a rectilinear router with 2 bendpoints.
 * 
 * @author mvelten and vhemery
 */
@SuppressWarnings({ "restriction", "deprecation" })
public class MessageRouter extends ObliqueRouter {

	private static final int MAX_DELTA = 10;

	public static enum RouterKind {
		HORIZONTAL, OBLIQUE, SELF;

		public static RouterKind getKind(Connection conn, PointList newLine) {
			if(isSelfConnection(conn)) {
				return SELF;
			}
			if(isHorizontalConnection(conn, newLine)) {
				return HORIZONTAL;
			}
			return OBLIQUE;
		}

		private static boolean isHorizontalConnection(Connection conn, PointList newLine) {
			if(!(conn instanceof MessageAsync)) {
				return false;
			}
			Point sourcePoint = newLine.getFirstPoint();
			Point targetPoint = newLine.getLastPoint();
			return Math.abs(sourcePoint.y - targetPoint.y) <= MAX_DELTA;
		}

		/**
		 * It is self if the parent lifeline is the same.
		 */
		private static boolean isSelfConnection(Connection conn) {
			if(conn == null || conn.getSourceAnchor() == null || conn.getTargetAnchor() == null) {
				return false;
			}
			IFigure sourceLifeline = conn.getSourceAnchor().getOwner();
			while(sourceLifeline != null && !(sourceLifeline instanceof LifelineFigure)) {
				sourceLifeline = sourceLifeline.getParent();
			}
			IFigure targetLifeline = conn.getTargetAnchor().getOwner();
			while(targetLifeline != null && !(targetLifeline instanceof LifelineFigure)) {
				targetLifeline = targetLifeline.getParent();
			}
			return sourceLifeline != null && sourceLifeline.equals(targetLifeline);
		}
	}

	@Override
	public void routeLine(Connection conn, int nestedRoutingDepth, PointList newLine) {
		Point sourcePoint, targetPoint;
		switch(RouterKind.getKind(conn, newLine)) {
		case HORIZONTAL:
			originalRectilinearRouteLine(conn, nestedRoutingDepth, newLine);
			// force 2 bendpoints on the same Y coordinate
			sourcePoint = newLine.getFirstPoint();
			targetPoint = newLine.getLastPoint();
			targetPoint.y = sourcePoint.y;
			newLine.removeAllPoints();
			newLine.addPoint(sourcePoint);
			newLine.addPoint(targetPoint);
			break;
		case OBLIQUE:
			super.routeLine(conn, nestedRoutingDepth, newLine);
			adjustCreateEndpoint(conn, newLine);
			// force 2 bendpoints only
			if(newLine.size() > 2) {
				sourcePoint = newLine.getFirstPoint();
				targetPoint = newLine.getLastPoint();
				newLine.removeAllPoints();
				newLine.addPoint(sourcePoint);
				newLine.addPoint(targetPoint);
			}
			break;
		case SELF:
			// Handle special routing: self connections and intersecting shapes connections
			if(checkSelfRelConnection(conn, newLine)) {
				super.resetEndPointsToEdge(conn, newLine);
				OrthogonalRouterUtilities.transformToOrthogonalPointList(newLine, getOffShapeDirection(getAnchorOffRectangleDirection(newLine.getFirstPoint(), sourceBoundsRelativeToConnection(conn))), getOffShapeDirection(getAnchorOffRectangleDirection(newLine.getLastPoint(), targetBoundsRelativeToConnection(conn))));
				removeRedundantPoints(newLine);
				return;
			}
			break;
		}
	}

	protected boolean checkShapesIntersect(Connection conn, PointList newLine) {
		if(conn.getTargetAnchor().getOwner() instanceof AnchorHelper.CombinedFragmentNodeFigure) {
			return false;
		}
		return super.checkShapesIntersect(conn, newLine);
	}

	protected void adjustCreateEndpoint(Connection conn, PointList newLine) {
		if(conn instanceof MessageCreate) {
			if(newLine.size() >= 2) {
				Point start = newLine.getFirstPoint();
				Point end = newLine.getLastPoint();
				if(start.y != end.y) {
					start.y = end.y;
					newLine.setPoint(start, 0);
				}
			}
		}
	}

	@Override
	protected void getSelfRelVertices(Connection conn, PointList newLine) {
		//Copy the points calculated from Bendpoints.
		PointList oldLine = newLine.getCopy();
		rectilinearResetEndPointsToEdge(conn, newLine);
		IFigure owner = conn.getSourceAnchor().getOwner();
		Point middle = owner.getBounds().getCenter();
		// ensure that the end points are anchored properly to the shape.
		Point ptS2 = newLine.getPoint(0);
		Point ptS1 = conn.getSourceAnchor().getReferencePoint();
		conn.translateToRelative(ptS1);
		Point ptAbsS2 = new Point(ptS2);
		conn.translateToAbsolute(ptAbsS2);
		Point ptEdge = conn.getSourceAnchor().getLocation(ptAbsS2);
		conn.translateToRelative(ptEdge);
		ptS1 = getStraightEdgePoint(ptEdge, ptS1, ptS2);
		Point ptE2 = newLine.getPoint(newLine.size() - 1);
		Point ptE1 = conn.getTargetAnchor().getReferencePoint();
		conn.translateToRelative(ptE1);
		Point ptAbsE2 = new Point(ptE2);
		conn.translateToAbsolute(ptAbsE2);
		ptEdge = conn.getTargetAnchor().getLocation(ptAbsE2);
		conn.translateToRelative(ptEdge);
		ptE1 = getStraightEdgePoint(ptEdge, ptE1, ptE2);
		newLine.removeAllPoints();
		newLine.addPoint(ptS1);
		// Fixed bug about custom self message. If there are 4 points, insert middle two ones for supporting bendpoints.
		if(oldLine.size() == 4) {
			Point p2 = oldLine.getPoint(1);
			Point p3 = oldLine.getPoint(2);
			int x = Math.min(p2.x, p3.x);
			newLine.addPoint(x, ptS1.y);
			newLine.addPoint(x, ptE1.y);
		} else {
			// insert two points
			Point extraPoint1 = ptS2.getTranslated(ptE2).scale(0.5);
			if(isOnRightHand(conn, owner, middle)) {
				extraPoint1.translate(SELFRELSIZEINIT, 0);
			} else {
				extraPoint1.translate(-SELFRELSIZEINIT, 0);
			}
			Point extraPoint2 = extraPoint1.getCopy();
			if(isFeedback(conn)) {
				extraPoint1.y = ptS2.y;
				extraPoint2.y = ptE2.y;
			} else {
				extraPoint1.y = ptS1.y;
				extraPoint2.y = ptE1.y;
			}
			newLine.addPoint(extraPoint1);
			newLine.addPoint(extraPoint2);
		}
		newLine.addPoint(ptE1);
	}

	protected boolean isOnRightHand(Connection conn, IFigure owner, Point middle) {
		boolean right = true;
		if(conn.getTargetAnchor() instanceof AnchorHelper.SideAnchor) {
			AnchorHelper.SideAnchor anchor = (AnchorHelper.SideAnchor)conn.getTargetAnchor();
			right = anchor.isRight();
		} else {
			PointList list = conn.getPoints();
			if(list.getPoint(0).x > list.getPoint(1).x)
				right = false;
		}
		return right;
	}

	@Override
	protected boolean checkSelfRelConnection(Connection conn, PointList newLine) {
		if(RouterKind.getKind(conn, newLine).equals(RouterKind.SELF)) {
			getSelfRelVertices(conn, newLine);
			return true;
		}
		return false;
	}

	/**
	 * All the code after this comment is copied from RectilinearRouter and RouterHelper
	 * 
	 * Copyright (c) 2002, 2010 IBM Corporation and others.
	 */
	private void originalRectilinearRouteLine(Connection conn, int nestedRoutingDepth, PointList newLine) {
		boolean skipNormalization = (routerFlags & ROUTER_FLAG_SKIPNORMALIZATION) != 0;
		// if we are reorienting, then just default to the super class implementation and
		// don't try to do rectilinear routing.
		if(isReorienting(conn)) {
			super.routeLine(conn, nestedRoutingDepth, newLine);
			return;
		}
		/*
		 * Remove and store former anchor points. Anchor points will be re-calculated anyway.
		 * However, the old anchor points may be useful if connection didn't have any bend points
		 * except the anchor points.
		 */
		Point lastStartAnchor = newLine.removePoint(0);
		Point lastEndAnchor = newLine.removePoint(newLine.size() - 1);
		/*
		 * Check if connection is rectilinear and if not make it rectilinear
		 */
		if(!OrthogonalRouterUtilities.isRectilinear(newLine)) {
			OrthogonalRouterUtilities.transformToOrthogonalPointList(newLine, PositionConstants.NONE, PositionConstants.NONE);
		}
		removeRedundantPoints(newLine);
		/*
		 * Remove unnecessary points that are contained within source and/or target shapes
		 * as well as insert extra points if all points are within source and/or target shapes
		 */
		removePointsInViews(conn, newLine, lastStartAnchor, lastEndAnchor);
		Dimension tolerance = new Dimension(3, 0);
		if(!isFeedback(conn))
			tolerance = (Dimension)MapModeUtil.getMapMode(conn).DPtoLP(tolerance);
		/*
		 * Normalize polyline to eliminate extra segments. (This makes 3 segments collapsing into
		 * one, while line segments are moved)
		 */
		if(!skipNormalization) {
			if(PointListUtilities.normalizeSegments(newLine, tolerance.width)) {
				/*
				 * Normalization can make our polyline not rectilinear. Hence, we need to normalize
				 * segments of polyline to straight line tolerance.
				 */
				normalizeToStraightLineTolerance(newLine, tolerance.width);
			}
		}
		/*
		 * Normalization is not touching the end points, hence we'd like to handle this here.
		 * If distance between start and end (which are the only points in a polyline) points
		 * is too short we'll remove one of the points
		 */
		if(newLine.size() == 2) {
			Ray middleSeg = new Ray(newLine.getFirstPoint(), newLine.getLastPoint());
			if(middleSeg.length() <= tolerance.width) {
				newLine.removePoint(0);
			}
		}
		/*
		 * Calculate connection anchor points and possibly some extra routing work to keep
		 * the connection rectilinear if anchor points make it not rectilinear.
		 */
		rectilinearResetEndPointsToEdge(conn, newLine);
		if(nestedRoutingDepth < 1 && !isValidRectilinearLine(conn, newLine)) {
			routeLine(conn, ++nestedRoutingDepth, newLine);
		}
	}

	/**
	 * Rectilinear polyline is invalid if:
	 * 1. First bend point is within the source
	 * 2. Last bend point is within the target
	 * 3. First bend point and source anchor are on different sides of the source shape
	 * 4. Last bend point and target anchor are on different sides of the target shape
	 * 
	 * @param conn
	 *        connection
	 * @param line
	 *        rectilinear polyline
	 * @return <code>true</code> if the line is valid
	 */
	private boolean isValidRectilinearLine(Connection conn, PointList line) {
		if(!(conn.getSourceAnchor().getOwner() instanceof Connection)) {
			Rectangle source = new PrecisionRectangle(FigureUtilities.getAnchorableFigureBounds(conn.getSourceAnchor().getOwner()));
			conn.getSourceAnchor().getOwner().translateToAbsolute(source);
			conn.translateToRelative(source);
			if(source.contains(line.getPoint(1))) {
				return false;
			}
			int firstSegmentOrientation = line.getFirstPoint().x == line.getPoint(1).x ? PositionConstants.VERTICAL : PositionConstants.HORIZONTAL;
			if(getOutisePointOffRectanglePosition(line.getPoint(1), source) != getAnchorLocationBasedOnSegmentOrientation(line.getFirstPoint(), source, firstSegmentOrientation)) {
				return false;
			}
		}
		if(!(conn.getTargetAnchor().getOwner() instanceof Connection)) {
			Rectangle target = new PrecisionRectangle(FigureUtilities.getAnchorableFigureBounds(conn.getTargetAnchor().getOwner()));
			conn.getTargetAnchor().getOwner().translateToAbsolute(target);
			conn.translateToRelative(target);
			if(target.contains(line.getPoint(line.size() - 2))) {
				return false;
			}
			int lastSegmentOrientation = line.getLastPoint().x == line.getPoint(line.size() - 2).x ? PositionConstants.VERTICAL : PositionConstants.HORIZONTAL;
			if(getOutisePointOffRectanglePosition(line.getPoint(line.size() - 2), target) != getAnchorLocationBasedOnSegmentOrientation(line.getLastPoint(), target, lastSegmentOrientation)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Calculates geographic position of a point located outside the given rectangle relative
	 * to the rectangle
	 * 
	 * @param p
	 *        point outside of rectangle
	 * @param r
	 *        the rectangle
	 * @return geographic position of the point relative to the recatangle
	 */
	private int getOutisePointOffRectanglePosition(Point p, Rectangle r) {
		int position = PositionConstants.NONE;
		if(r.x > p.x) {
			position |= PositionConstants.WEST;
		} else if(r.x + r.width < p.x) {
			position |= PositionConstants.EAST;
		}
		if(r.y > p.y) {
			position |= PositionConstants.NORTH;
		} else if(r.y + r.height < p.y) {
			position |= PositionConstants.SOUTH;
		}
		return position;
	}

	/**
	 * Given the coordinates of the connection anchor point the shape's rectangle and the
	 * orientation of the first rectilinear connection segment that comes out from the anchor
	 * point the method detemines on which geographic side of the rectangle the anchor point
	 * is located on.
	 * 
	 * @param anchorPoint
	 *        coordinates of the anchor point
	 * @param rectangle
	 *        the shape's bounding rectangle
	 * @param segmentOrientation
	 *        orinetation of the segment coming out from the anchor point
	 * @return geographic position of the anchor point relative to the rectangle
	 */
	private int getAnchorLocationBasedOnSegmentOrientation(Point anchorPoint, Rectangle rectangle, int segmentOrientation) {
		if(segmentOrientation == PositionConstants.VERTICAL) {
			if(Math.abs(anchorPoint.y - rectangle.y) < Math.abs(anchorPoint.y - rectangle.y - rectangle.height)) {
				return PositionConstants.NORTH;
			} else {
				return PositionConstants.SOUTH;
			}
		} else if(segmentOrientation == PositionConstants.HORIZONTAL) {
			if(Math.abs(anchorPoint.x - rectangle.x) < Math.abs(anchorPoint.x - rectangle.x - rectangle.width)) {
				return PositionConstants.WEST;
			} else {
				return PositionConstants.EAST;
			}
		}
		return PositionConstants.NONE;
	}

	/**
	 * Goes through line segments of a polyline and makes strict straight segments
	 * from nearly straight segments.
	 * 
	 * @param line
	 *        polyline
	 * @param tolerance
	 *        tolerance value specifying nearly straight lines.
	 */
	private void normalizeToStraightLineTolerance(PointList line, int tolerance) {
		for(int i = 0; i < line.size() - 1; i++) {
			Point pt1 = line.getPoint(i);
			Point pt2 = line.getPoint(i + 1);
			if(Math.abs(pt1.x - pt2.x) < tolerance) {
				line.setPoint(new Point(pt1.x, pt2.y), i + 1);
			} else if(Math.abs(pt1.y - pt2.y) < tolerance) {
				line.setPoint(new Point(pt2.x, pt1.y), i + 1);
			}
		}
	}

	/**
	 * Removes consecutive points contained within the source shape and removes consecutive
	 * points contained within the target shape. If all points have been removed an extra point
	 * outside source and target shapes will be added.
	 * 
	 * @param conn
	 *        connection
	 * @param newLine
	 *        polyline of the connection (routed connection)
	 * @param start
	 *        old start anchor point
	 * @param end
	 *        old end anchor point
	 */
	private void removePointsInViews(Connection conn, PointList newLine, Point start, Point end) {
		/*
		 * Get the bounds of anchorable figure of the source and target and translate it to
		 * connection relative coordinates.
		 */
		PrecisionRectangle source = conn.getSourceAnchor().getOwner() != null ? new PrecisionRectangle(FigureUtilities.getAnchorableFigureBounds(conn.getSourceAnchor().getOwner())) : null;
		PrecisionRectangle target = conn.getTargetAnchor().getOwner() != null ? new PrecisionRectangle(FigureUtilities.getAnchorableFigureBounds(conn.getTargetAnchor().getOwner())) : null;
		if(source != null) {
			conn.getSourceAnchor().getOwner().translateToAbsolute(source);
			conn.translateToRelative(source);
		}
		if(target != null) {
			conn.getTargetAnchor().getOwner().translateToAbsolute(target);
			conn.translateToRelative(target);
		}
		Point lastRemovedFromSource = null;
		Point lastRemovedFromTarget = null;
		/*
		 * Starting from the first point of polyline remove points that are contained
		 * within the source shape until the first point outside is found.
		 * Remember the point that was removed from the source shape last for a possible
		 * case of all points removed from polyline.
		 */
		if(!(conn.getSourceAnchor().getOwner() instanceof Connection) && newLine.size() != 0 && source.contains(new PrecisionPoint(newLine.getFirstPoint()))) {
			lastRemovedFromSource = newLine.removePoint(0);
			for(int i = 0; i < newLine.size() && source.contains(new PrecisionPoint(newLine.getPoint(i))); i++) {
				lastRemovedFromSource = newLine.removePoint(i--);
			}
		}
		/*
		 * Starting from the end point of polyline remove points that are contained
		 * within the target shape until the first point outside is found.
		 * Remember the point that was removed from the target shape last for a possible
		 * case of all points removed from polyline.
		 */
		if(!(conn.getTargetAnchor().getOwner() instanceof Connection) && newLine.size() != 0 && target.contains(new PrecisionPoint(newLine.getLastPoint()))) {
			lastRemovedFromTarget = newLine.removePoint(newLine.size() - 1);
			for(int i = newLine.size(); i > 0 && target.contains(new PrecisionPoint(newLine.getPoint(i - 1))); i--) {
				lastRemovedFromTarget = newLine.removePoint(i - 1);
			}
		}
		/*
		 * Handle the special case of all points removed from polyline.
		 */
		if(newLine.size() == 0) {
			Dimension tolerance = new Dimension(1, 0);
			if(!isFeedback(conn))
				tolerance = (Dimension)MapModeUtil.getMapMode(conn).DPtoLP(tolerance);
			int toleranceValue = tolerance.width;
			if(lastRemovedFromSource == null) {
				lastRemovedFromSource = start;
			}
			if(lastRemovedFromTarget == null) {
				lastRemovedFromTarget = end;
			}
			/*
			 * If last point removed from source and the points removed from target form
			 * a vertical or horizontal line we'll find a point located on this line and is
			 * outside of source and target shape and insert it in the polyline.
			 * The check for vertical and horizontal segment is using tolerance value, because
			 * bend point location extracted from RelativeBendpoint can have precision errors due
			 * to non-integer weight factors.
			 */
			if(Math.abs(lastRemovedFromSource.x - lastRemovedFromTarget.x) < toleranceValue) {
				// Vertical
				if(source.preciseY < target.preciseY) {
					newLine.addPoint(lastRemovedFromSource.x, (source.getBottom().y + target.getTop().y) / 2);
				} else {
					newLine.addPoint(lastRemovedFromSource.x, (source.getTop().y + target.getBottom().y) / 2);
				}
			} else if(Math.abs(lastRemovedFromSource.y - lastRemovedFromTarget.y) < toleranceValue) {
				// Horizontal
				if(source.preciseX < target.preciseX) {
					newLine.addPoint((source.getRight().x + target.getLeft().x) / 2, lastRemovedFromSource.y);
				} else {
					newLine.addPoint((source.getLeft().x + target.getRight().x) / 2, lastRemovedFromSource.y);
				}
			} else if((conn.getSourceAnchor() instanceof BaseSlidableAnchor && StringStatics.BLANK.equals(((BaseSlidableAnchor)conn.getSourceAnchor()).getTerminal()) && (conn.getTargetAnchor() instanceof BaseSlidableAnchor && StringStatics.BLANK.equals(((BaseSlidableAnchor)conn.getTargetAnchor()).getTerminal())))) {
				/*
				 * This a special case for old diagrams with rectilinear connections routed by
				 * the old router to look good with the new router
				 */
				if(lastRemovedFromSource != null && lastRemovedFromTarget != null) {
					newLine.addPoint((lastRemovedFromSource.x + lastRemovedFromTarget.x) / 2, (lastRemovedFromSource.y + lastRemovedFromTarget.y) / 2);
				} else {
					double startX = Math.max(source.preciseX, target.preciseX);
					double endX = Math.min(source.preciseX + source.preciseWidth, target.preciseX + target.preciseWidth);
					double startY = Math.max(source.preciseY, target.preciseY);
					double endY = Math.min(source.preciseY + source.preciseHeight, target.preciseY + target.preciseHeight);
					if(startX < endX) {
						if(source.preciseY < target.preciseY) {
							newLine.addPoint((int)Math.round((startX + endX) / 2.0), (source.getBottom().y + target.getTop().y) / 2);
						} else {
							newLine.addPoint((int)Math.round((startX + endX) / 2.0), (source.getTop().y + target.getBottom().y) / 2);
						}
					} else if(startY < endY) {
						if(source.preciseX < target.preciseX) {
							newLine.addPoint((source.getRight().x + target.getLeft().x) / 2, (int)Math.round((startY + endY) / 2.0));
						} else {
							newLine.addPoint((source.getLeft().x + target.getRight().x) / 2, (int)Math.round((startY + endY) / 2.0));
						}
					}
				}
			}
		}
	}

	protected void rectilinearResetEndPointsToEdge(Connection conn, PointList line) {
		if(isReorienting(conn)) {
			/*
			 * If the connection doesn't have a shape as a source or target we'll
			 * let the oblique router to do the work. The connection doesn't need to
			 * be rectilinear at this point. There is no support for making a rectilinear
			 * connection for which one of the ends is not connected to anything.
			 */
			super.resetEndPointsToEdge(conn, line);
			return;
		}
		PrecisionRectangle source = sourceBoundsRelativeToConnection(conn);
		PrecisionRectangle target = targetBoundsRelativeToConnection(conn);
		int offSourceDirection = PositionConstants.NONE;
		int offTargetDirection = PositionConstants.NONE;
		int sourceAnchorRelativeLocation = PositionConstants.NONE;
		int targetAnchorRelativeLocation = PositionConstants.NONE;
		if(line.size() == 0) {
			/*
			 * If there are no valid bend points, we'll use the oblique connection anchor points
			 * and just convert the polyline from oblique to rectilinear.
			 */
			// Need to add 2 dumb points to ensure that RouterHelper#resetEndPointsToEdge works
			line.addPoint(new Point());
			line.addPoint(new Point());
			super.resetEndPointsToEdge(conn, line);
			sourceAnchorRelativeLocation = getAnchorOffRectangleDirection(line.getFirstPoint(), source);
			targetAnchorRelativeLocation = getAnchorOffRectangleDirection(line.getLastPoint(), target);
			/*
			 * We need to find two points offset from the source and target anchors outside the shapes
			 * such that when the polyline is converted to rectilinear from oblique we won't have
			 * rectilinear line segments alligned with source or target shapes edges.
			 */
			Point offStart = line.getFirstPoint();
			Point offEnd = line.getLastPoint();
			Dimension offsetDim = offStart.getDifference(offEnd).scale(0.5);
			offStart.translate(getTranslationValue(sourceAnchorRelativeLocation, Math.abs(offsetDim.width), Math.abs(offsetDim.height)));
			offEnd.translate(getTranslationValue(targetAnchorRelativeLocation, Math.abs(offsetDim.width), Math.abs(offsetDim.height)));
			line.insertPoint(offStart, 1);
			line.insertPoint(offEnd, 2);
			offSourceDirection = getOffShapeDirection(sourceAnchorRelativeLocation);
			offTargetDirection = getOffShapeDirection(targetAnchorRelativeLocation);
		} else {
			Point start = line.getFirstPoint();
			Point end = line.getLastPoint();
			if(conn.getSourceAnchor() instanceof OrthogonalConnectionAnchor) {
				line.insertPoint(OrthogonalRouterUtilities.getOrthogonalLineSegToAnchorLoc(conn, conn.getSourceAnchor(), start).getOrigin(), 0);
			} else {
				/*
				 * If anchor is not supporting orthogonal connections we'll use the oblique connection
				 * anchors and then convert it to rectilinear.
				 */
				PrecisionPoint reference = new PrecisionPoint(start);
				conn.getSourceAnchor().getOwner().translateToAbsolute(reference);
				PrecisionPoint anchorLocation = new PrecisionPoint(conn.getSourceAnchor().getLocation(reference));
				conn.translateToRelative(anchorLocation);
				line.insertPoint(anchorLocation, 0);
			}
			if(conn.getTargetAnchor() instanceof OrthogonalConnectionAnchor) {
				line.addPoint(OrthogonalRouterUtilities.getOrthogonalLineSegToAnchorLoc(conn, conn.getTargetAnchor(), end).getOrigin());
			} else {
				/*
				 * If anchor is not supporting orthogonal connections we'll use the oblique connection
				 * anchors and then convert it to rectilinear.
				 */
				PrecisionPoint reference = new PrecisionPoint(end);
				conn.getSourceAnchor().getOwner().translateToAbsolute(reference);
				PrecisionPoint anchorLocation = new PrecisionPoint(conn.getTargetAnchor().getLocation(reference));
				conn.translateToRelative(anchorLocation);
				line.addPoint(anchorLocation);
			}
			sourceAnchorRelativeLocation = getAnchorOffRectangleDirection(line.getFirstPoint(), source);
			offSourceDirection = getOffShapeDirection(sourceAnchorRelativeLocation);
			targetAnchorRelativeLocation = getAnchorOffRectangleDirection(line.getLastPoint(), target);
			offTargetDirection = getOffShapeDirection(targetAnchorRelativeLocation);
		}
		/*
		 * Convert the polyline to rectilinear. If the connection is rectilinear already then the
		 * connection will remain as it is.
		 */
		OrthogonalRouterUtilities.transformToOrthogonalPointList(line, offSourceDirection, offTargetDirection);
		removeRedundantPoints(line);
	}

	/**
	 * Returns a translation dimension for the anchor point. Translation dimension
	 * translates the anchor point off the shape. The off shape direction
	 * is specified by the relative to the shape geographic position of the anchor
	 * 
	 * @param position
	 *        relative to the shape geographic position of the anchor
	 * @param xFactorValue
	 *        translation value along x-axis
	 * @param yFactorValue
	 *        translation value along y-axis
	 * @return
	 */
	private Dimension getTranslationValue(int position, int xFactorValue, int yFactorValue) {
		Dimension translationDimension = new Dimension();
		if(position == PositionConstants.EAST) {
			translationDimension.width = xFactorValue;
		} else if(position == PositionConstants.SOUTH) {
			translationDimension.height = yFactorValue;
		} else if(position == PositionConstants.WEST) {
			translationDimension.width = -xFactorValue;
		} else if(position == PositionConstants.NORTH) {
			translationDimension.height = -yFactorValue;
		}
		return translationDimension;
	}

	/**
	 * Target bounding rectangle relative to connection figure coordinates
	 * 
	 * @param conn
	 *        connection
	 * @return <code>PrecisionRectangle</code> target bounds relative to connection's coordinate
	 *         system
	 */
	private PrecisionRectangle targetBoundsRelativeToConnection(Connection conn) {
		PrecisionRectangle target = new PrecisionRectangle(conn.getTargetAnchor().getOwner().getBounds());
		conn.getTargetAnchor().getOwner().translateToAbsolute(target);
		conn.translateToRelative(target);
		return target;
	}

	/**
	 * Iterates through points of a polyline and does the following:
	 * if 3 points lie on the same line the middle point is removed
	 * 
	 * @param line
	 *        polyline's points
	 */
	private boolean removeRedundantPoints(PointList line) {
		int initialNumberOfPoints = line.size();
		if(line.size() > 2) {
			PointList newLine = new PointList(line.size());
			newLine.addPoint(line.removePoint(0));
			while(line.size() >= 2) {
				Point p0 = newLine.getLastPoint();
				Point p1 = line.getPoint(0);
				Point p2 = line.getPoint(1);
				if(p0.x == p1.x && p0.x == p2.x) {
					// Have two vertical segments in a row
					// get rid of the point between
					line.removePoint(0);
				} else if(p0.y == p1.y && p0.y == p2.y) {
					// Have two horizontal segments in a row
					// get rid of the point between
					line.removePoint(0);
				} else {
					newLine.addPoint(line.removePoint(0));
				}
			}
			while(line.size() > 0) {
				newLine.addPoint(line.removePoint(0));
			}
			line.removeAllPoints();
			line.addAll(newLine);
		}
		return line.size() != initialNumberOfPoints;
	}

	/**
	 * Determines whether the rectilinear line segment coming out of the shape should be
	 * horizontal or vertical based on the anchor geographic position relative to the shape
	 * 
	 * @param anchorRelativeLocation
	 * @return
	 */
	private int getOffShapeDirection(int anchorRelativeLocation) {
		if(anchorRelativeLocation == PositionConstants.EAST || anchorRelativeLocation == PositionConstants.WEST) {
			return PositionConstants.HORIZONTAL;
		} else if(anchorRelativeLocation == PositionConstants.NORTH || anchorRelativeLocation == PositionConstants.SOUTH) {
			return PositionConstants.VERTICAL;
		}
		return PositionConstants.NONE;
	}

	/**
	 * Source bounding rectangle relative to connection figure coordinates
	 * 
	 * @param conn
	 *        connection
	 * @return <code>PrecisionRectangle</code> source bounds relative to connection's coordinate
	 *         system
	 */
	private PrecisionRectangle sourceBoundsRelativeToConnection(Connection conn) {
		PrecisionRectangle source = new PrecisionRectangle(conn.getSourceAnchor().getOwner().getBounds());
		conn.getSourceAnchor().getOwner().translateToAbsolute(source);
		conn.translateToRelative(source);
		return source;
	}

	/**
	 * Determines the relative to rectangle geographic location of a point.
	 * Example: If shape is closer to the the top edge of the rectangle location
	 * would be north.
	 * Method used to determine which side of shape's bounding rectangle is closer
	 * to connection's anchor point.
	 * All geometric quantities must be in the same coordinate system.
	 * 
	 * @param anchorPoint
	 *        location of the anchor point
	 * @param rect
	 *        bounding rectangle of the shape
	 * @return
	 */
	private int getAnchorOffRectangleDirection(Point anchorPoint, Rectangle rect) {
		int position = PositionConstants.NORTH;
		int criteriaValue = Math.abs(anchorPoint.y - rect.y);
		int tempCriteria = Math.abs(anchorPoint.y - rect.y - rect.height);
		if(tempCriteria < criteriaValue) {
			criteriaValue = tempCriteria;
			position = PositionConstants.SOUTH;
		}
		tempCriteria = Math.abs(anchorPoint.x - rect.x);
		if(tempCriteria < criteriaValue) {
			criteriaValue = tempCriteria;
			position = PositionConstants.WEST;
		}
		tempCriteria = Math.abs(anchorPoint.x - rect.x - rect.width);
		if(tempCriteria < criteriaValue) {
			criteriaValue = tempCriteria;
			position = PositionConstants.EAST;
		}
		return position;
	}

	/**
	 * @param conn
	 *        the <code>Connection</code> that is to be check if it is a feedback
	 *        connection or not.
	 * @return <code>true</code> is it is a feedback connection, <code>false</code> otherwise.
	 */
	private static boolean isFeedback(Connection conn) {
		Dimension dim = new Dimension(100, 100);
		Dimension dimCheck = dim.getCopy();
		conn.translateToRelative(dimCheck);
		return dim.equals(dimCheck);
	}
}
