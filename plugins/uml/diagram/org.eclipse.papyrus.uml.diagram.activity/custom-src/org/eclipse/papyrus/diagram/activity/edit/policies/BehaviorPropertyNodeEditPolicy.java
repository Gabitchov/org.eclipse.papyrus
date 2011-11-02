/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
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
package org.eclipse.papyrus.diagram.activity.edit.policies;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineShape;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gef.requests.AlignmentRequest;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.NonResizableEditPolicyEx;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.internal.figures.LabelHelper;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

public class BehaviorPropertyNodeEditPolicy extends NonResizableEditPolicyEx {

	private PolylineShape linkFeedback = null;

	/**
	 * @see org.eclipse.gef.editpolicies.NonResizableEditPolicy#createSelectionHandles()
	 */
	protected List createSelectionHandles() {
		MoveHandle mh = new MoveHandle((GraphicalEditPart)getHost());
		mh.setBorder(null);
		return Collections.singletonList(mh);
	}

	/**
	 * Calls other methods as appropriate.
	 */
	public void eraseSourceFeedback(Request request) {
		if((REQ_MOVE.equals(request.getType()) && isDragAllowed()) || REQ_CLONE.equals(request.getType()) || REQ_ADD.equals(request.getType()) || RequestConstants.REQ_DROP.equals(request.getType()))
			eraseChangeBoundsFeedback((ChangeBoundsRequest)request);
	}

	/**
	 * Calls other methods as appropriate.
	 */
	public void showSourceFeedback(Request request) {
		if((REQ_MOVE.equals(request.getType()) && isDragAllowed()) || REQ_ADD.equals(request.getType()) || REQ_CLONE.equals(request.getType()) || RequestConstants.REQ_DROP.equals(request.getType()))
			showChangeBoundsFeedback((ChangeBoundsRequest)request);
	}

	/**
	 * Returns the command contribution to a change bounds request.
	 * 
	 * @param request
	 *        the change bounds requesgt
	 * @return the command contribution to the request
	 */
	protected Command getMoveCommand(ChangeBoundsRequest request) {

		// translate the feedback figure
		PrecisionRectangle rect = new PrecisionRectangle(getInitialFeedbackBounds().getCopy());
		getHostFigure().translateToAbsolute(rect);
		rect.translate(request.getMoveDelta());
		rect.resize(request.getSizeDelta());
		getHostFigure().translateToRelative(rect);

		if(getHost() instanceof IBorderItemEditPart) {
			IBorderItemEditPart borderItemEP = (IBorderItemEditPart)getHost();
			IBorderItemLocator borderItemLocator = borderItemEP.getBorderItemLocator();
			if(borderItemLocator != null) {
				Rectangle realLocation = borderItemLocator.getValidLocation(rect.getCopy(), borderItemEP.getFigure());
				Point parentOrigin = borderItemEP.getFigure().getParent().getBounds().getTopLeft();
				Dimension d = realLocation.getTopLeft().getDifference(parentOrigin);
				Point location = new Point(d.width, d.height);
				ICommand moveCommand = new SetBoundsCommand(borderItemEP.getEditingDomain(), DiagramUIMessages.Commands_MoveElement, new EObjectAdapter((View)getHost().getModel()), location);
				return new ICommandProxy(moveCommand);
			}
		} else if(getHost() instanceof LabelEditPart) {
			LabelEditPart editPart = (LabelEditPart)getHost();
			Point refPoint = editPart.getReferencePoint();
			Point normalPoint = LabelHelper.offsetFromRelativeCoordinate(getHostFigure(), rect, refPoint);
			ICommand moveCommand = new SetBoundsCommand(editPart.getEditingDomain(), DiagramUIMessages.Commands_MoveElement, new EObjectAdapter((View)editPart.getModel()), normalPoint);
			return new ICommandProxy(moveCommand);
		}
		return null;
	}

	/** Return <tt>null</tt> to avoid handling the request. */
	protected Command getAlignCommand(AlignmentRequest request) {
		return null;
	}

	/**
	 * Erase the feedback link figure
	 * 
	 * @see org.eclipse.gef.editpolicies.NonResizableEditPolicy#eraseChangeBoundsFeedback(org.eclipse.gef.requests.ChangeBoundsRequest)
	 */
	protected void eraseChangeBoundsFeedback(ChangeBoundsRequest request) {
		super.eraseChangeBoundsFeedback(request);
		if(linkFeedback != null)
			removeFeedback(linkFeedback);
		linkFeedback = null;
	}

	/**
	 * Create the feedback link figure
	 * 
	 * @see org.eclipse.gef.editpolicies.NonResizableEditPolicy#createDragSourceFeedbackFigure()
	 */
	protected IFigure createDragSourceFeedbackFigure() {
		IFigure feedback = super.createDragSourceFeedbackFigure();
		linkFeedback = new PolylineShape();
		linkFeedback.setLineWidth(1);
		linkFeedback.setLineStyle(Graphics.LINE_DASHDOT);
		linkFeedback.setForegroundColor(((IGraphicalEditPart)getHost()).getFigure().getForegroundColor());
		addFeedback(linkFeedback);
		return feedback;
	}

	/**
	 * Show link feedback
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy#showChangeBoundsFeedback(org.eclipse.gef.requests.ChangeBoundsRequest)
	 */
	protected void showChangeBoundsFeedback(org.eclipse.gef.requests.ChangeBoundsRequest request) {
		if(getHost() instanceof IBorderItemEditPart) {
			IBorderItemEditPart borderItemEP = (IBorderItemEditPart)getHost();
			IBorderItemLocator borderItemLocator = borderItemEP.getBorderItemLocator();

			if(borderItemLocator != null) {
				IFigure feedback = getDragSourceFeedbackFigure();
				PrecisionRectangle rect = new PrecisionRectangle(getInitialFeedbackBounds().getCopy());
				getHostFigure().translateToAbsolute(rect);
				rect.translate(request.getMoveDelta());
				rect.resize(request.getSizeDelta());
				getHostFigure().translateToRelative(rect);
				Rectangle realLocation = borderItemLocator.getValidLocation(rect.getCopy(), borderItemEP.getFigure());
				getHostFigure().translateToAbsolute(realLocation);
				feedback.translateToRelative(realLocation);
				feedback.setBounds(realLocation);
			}
		} else {
			super.showChangeBoundsFeedback(request);
		}

		// translate the feedback figure
		IFigure p = getDragSourceFeedbackFigure();

		PrecisionRectangle rect = new PrecisionRectangle(getInitialFeedbackBounds().getCopy());
		getHostFigure().translateToAbsolute(rect);
		rect.translate(request.getMoveDelta());
		rect.resize(request.getSizeDelta());

		p.translateToRelative(rect);
		p.setBounds(rect);

		Point referencePoint = getReferencePoint(request);
		Point end = getLinkEndPoint(request, referencePoint);
		linkFeedback.setEnd(end);
		Point start = getLinkStartPoint(request, referencePoint, end);
		if(start != null) {
			linkFeedback.setStart(start);
		} else {
			linkFeedback.setStart(referencePoint);
		}
	};

	/**
	 * Get the reference point at the center of the parent figure
	 * 
	 * @param request
	 *        change bounds request
	 * @return point
	 */
	private Point getReferencePoint(ChangeBoundsRequest request) {

		Point refPoint = ((LabelEditPart)getHost()).getReferencePoint();

		Rectangle centerMain = null;
		if(((IGraphicalEditPart)getHost().getParent()).getFigure() instanceof Connection) {
			centerMain = new Rectangle(refPoint.x, refPoint.y, 0, 0);
		} else {
			centerMain = ((IGraphicalEditPart)getHost().getParent()).getFigure().getBounds().getCopy();
			centerMain.translate(centerMain.width / 2, centerMain.height / 2);
		}

		PrecisionRectangle ref = new PrecisionRectangle(centerMain);
		getHostFigure().translateToAbsolute(ref);
		getDragSourceFeedbackFigure().translateToRelative(ref);
		return ref.getLocation();
	}

	/**
	 * Get the point for starting the link
	 * 
	 * @param request
	 *        change bounds request
	 * @param referencePoint
	 *        the reference point at the center of the start figure
	 * @param endPoint
	 *        the end point at the border of the end figure
	 * @return point where to start the link
	 */
	private Point getLinkStartPoint(ChangeBoundsRequest request, Point referencePoint, Point endPoint) {
		Point u1 = referencePoint;
		Point u2 = endPoint;
		if(getHost().getParent() instanceof AbstractBorderedShapeEditPart) {
			// the parent figure is a node : choose a point on its border
			AbstractBorderedShapeEditPart parentPart = (AbstractBorderedShapeEditPart)getHost().getParent();
			IFigure fig = parentPart.getMainFigure();
			if(fig instanceof NodeFigure) {
				PointList pointsList = ((NodeFigure)fig).getPolygonPoints().getCopy();
				// translate points relatively to drag feedback
				fig.translateToAbsolute(pointsList);
				getDragSourceFeedbackFigure().translateToRelative(pointsList);
				return getIntersectionPoint(pointsList, u1, u2);
			}
		}
		// either computation failed or the parent figure is a link
		return referencePoint;
	}

	/**
	 * Get the point for ending the link
	 * 
	 * @param request
	 *        change bounds request
	 * @param referencePoint
	 *        the reference point at the center of the start figure
	 * @return point
	 */
	private Point getLinkEndPoint(ChangeBoundsRequest request, Point referencePoint) {
		Rectangle rect = getDragSourceFeedbackFigure().getBounds();
		Point endPoint = getAppropriateBorderPoint(referencePoint, rect);
		return endPoint;
	}

	/**
	 * Get the point on the border intersection the segment
	 * 
	 * @param polygonalBounds
	 *        the list of points tracing the border
	 * @param insidePoint
	 *        first segment extremity
	 * @param outsideExtremity
	 *        second segment extremity
	 * @return the intersection point or null if none
	 */
	public static Point getIntersectionPoint(PointList polygonalBounds, Point insidePoint, Point outsideExtremity) {
		Point intersection = null;
		int i = 0;
		while(intersection == null && i < polygonalBounds.size() - 1) {
			Point v1 = polygonalBounds.getPoint(i).getCopy();
			Point v2 = polygonalBounds.getPoint(i + 1).getCopy();
			intersection = getIntersection(insidePoint, outsideExtremity, v1, v2);
			i++;
		}
		return intersection;
	}

	/**
	 * Get the point of the border which is the more appropriated to link to the reference point
	 * 
	 * @param referencePoint
	 *        point to refer to, which the link is directed to (not necessary an end of the link)
	 * @param border
	 *        the border on which an anchoring point must be chosen
	 * @return a point of the border to use as link end
	 */
	public static Point getAppropriateBorderPoint(Point referencePoint, Rectangle border) {
		Point midTop = new Point(border.x + border.width / 2, border.y);
		Point midBottom = new Point(border.x + border.width / 2, border.y + border.height);
		Point midLeft = new Point(border.x, border.y + border.height / 2);
		Point midRight = new Point(border.x + border.width, border.y + border.height / 2);

		Dimension diffTop = referencePoint.getDifference(midTop);
		Dimension diffBottom = referencePoint.getDifference(midBottom);
		Dimension diffRight = referencePoint.getDifference(midRight);
		Dimension diffLeft = referencePoint.getDifference(midLeft);

		Point startPoint = midBottom;
		if(diffBottom.height > 0) {
			// check if right or left is more appropriated
			if(diffLeft.width < 0 && diffBottom.height < -diffLeft.width) {
				startPoint = midLeft;
			} else if(diffRight.width > 0 && diffBottom.height < diffRight.width) {
				startPoint = midRight;
			} else {
				startPoint = midBottom;
			}
		} else if(diffTop.height < 0) {
			// check if right or left is more appropriated
			if(diffLeft.width < 0 && -diffTop.height < -diffLeft.width) {
				startPoint = midLeft;
			} else if(diffRight.width > 0 && -diffTop.height < diffRight.width) {
				startPoint = midRight;
			} else {
				startPoint = midTop;
			}
		} else if(diffLeft.width < 0) {
			startPoint = midLeft;
		} else if(diffRight.width > 0) {
			startPoint = midRight;
		}
		return startPoint;
	}

	/**
	 * Get the intersection between segments joining the points
	 * 
	 * @param u1
	 *        the first extremity of the u segment
	 * @param u2
	 *        the second extremity of the u segment
	 * @param v1
	 *        the first extremity of the v segment
	 * @param v2
	 *        the second extremity of the v segment
	 * @return the intersection point or null if none
	 */
	public static Point getIntersection(Point u1, Point u2, Point v1, Point v2) {
		float denom = ((u2.y - u1.y) * (v2.x - v1.x)) - ((u2.x - u1.x) * (v2.y - v1.y));
		float nume_a = ((u2.x - u1.x) * (v1.y - u1.y)) - ((u2.y - u1.y) * (v1.x - u1.x));
		float nume_b = ((v2.x - v1.x) * (v1.y - u1.y)) - ((v2.y - v1.y) * (v1.x - u1.x));

		if(denom == 0.0f) {
			return null;
		}
		float ua = nume_a / denom;
		float ub = nume_b / denom;

		if(ua >= 0.0f && ua <= 1.0f && ub >= 0.0f && ub <= 1.0f) {
			// Get the intersection point.
			Float x = v1.x + ua * (v2.x - v1.x);
			Float y = v1.y + ua * (v2.y - v1.y);
			return new Point(x.intValue(), y.intValue());
		}
		return null;
	}
}
