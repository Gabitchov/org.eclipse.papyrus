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
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Polyline;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.NonResizableEditPolicyEx;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.NonResizableLabelEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.internal.figures.LabelHelper;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.tools.DragEditPartsTrackerEx;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.PointListUtilities;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;

/**
 * This class offers the same features as {@link NonResizableLabelEditPolicy}, except that move is privileged instead of drag and drop.
 * It is useful for edit parts on messages.
 */
public class MoveableNonResizableLabelEditPolicy extends NonResizableEditPolicyEx {

	@Override
	protected List<?> createSelectionHandles() {
		MoveHandle mh = new MoveHandle((GraphicalEditPart)getHost());
		mh.setBorder(null);
		mh.setDragTracker(createSelectionHandleDragTracker());
		return Collections.singletonList(mh);
	}

	private Polyline tether = null;

	@Override
	protected void eraseChangeBoundsFeedback(ChangeBoundsRequest request) {
		super.eraseChangeBoundsFeedback(request);
		if(tether != null) {
			removeFeedback(tether);
		}
		tether = null;
	}

	@Override
	protected IFigure createDragSourceFeedbackFigure() {
		IFigure feedback = super.createDragSourceFeedbackFigure();
		tether = new Polyline();
		tether.setLineStyle(Graphics.LINE_DASHDOT);
		tether.setForegroundColor(((IGraphicalEditPart)getHost()).getFigure().getForegroundColor());
		addFeedback(tether);
		return feedback;
	}

	/**
	 * Calculates a point located at the middel of the parent connection
	 * 
	 * @return the point
	 */
	private Point getReferencePoint() {
		if(getHost().getParent() instanceof AbstractConnectionEditPart) {
			PointList ptList = ((Connection)((ConnectionEditPart)getHost().getParent()).getFigure()).getPoints();
			Point refPoint = PointListUtilities.calculatePointRelativeToLine(ptList, 0, 50, true);
			return refPoint;
		} else if(getHost().getParent() instanceof GraphicalEditPart) {
			return ((AbstractGraphicalEditPart)getHost().getParent()).getFigure().getBounds().getCenter();
		}
		return null;
	}

	@Override
	protected void showChangeBoundsFeedback(ChangeBoundsRequest request) {
		super.showChangeBoundsFeedback(request);
		IFigure p = getDragSourceFeedbackFigure();
		Rectangle r = p.getBounds();
		Point refPoint = getReferencePoint();
		// translate the feedback figure
		PrecisionRectangle rect = new PrecisionRectangle(getInitialFeedbackBounds().getCopy());
		getHostFigure().translateToAbsolute(rect);
		rect.translate(request.getMoveDelta());
		rect.resize(request.getSizeDelta());
		p.translateToRelative(rect);
		p.setBounds(rect);
		Rectangle centerMain = null;
		// TODO: remove this hack. We should be using the reference point for
		// the teher end, however,
		// the reference point is causing miscaculation when positioning. This
		// has to be redone in version 2.
		if(((IGraphicalEditPart)getHost().getParent()).getFigure() instanceof Connection) {
			centerMain = new Rectangle(refPoint.x, refPoint.y, 0, 0);
			getHostFigure().translateToAbsolute(centerMain);
			p.translateToRelative(centerMain);
		} else {
			centerMain = ((IGraphicalEditPart)getHost().getParent()).getFigure().getBounds().getCopy();
			centerMain.translate(centerMain.width / 2, centerMain.height / 2);
			getHostFigure().translateToAbsolute(centerMain);
			p.translateToRelative(centerMain);
		}
		PrecisionRectangle ref = new PrecisionRectangle(centerMain);
		Point midTop = new Point(r.x + r.width / 2, r.y);
		Point midBottom = new Point(r.x + r.width / 2, r.y + r.height);
		Point midLeft = new Point(r.x, r.y + r.height / 2);
		Point midRight = new Point(r.x + r.width, r.y + r.height / 2);
		Point startPoint = midTop;
		int x = r.x + r.width / 2 - refPoint.x;
		int y = r.y + r.height / 2 - refPoint.y;
		if(y > 0 && y > x && y > -x) {
			startPoint = midTop;
		} else if(y < 0 && y < x && y < -x) {
			startPoint = midBottom;
		} else if(x < 0 && y > x && y < -x) {
			startPoint = midRight;
		} else {
			startPoint = midLeft;
		}
		tether.setStart(startPoint);
		tether.setEnd(ref.getLocation());
	}

	@Override
	protected Command getMoveCommand(ChangeBoundsRequest request) {
		GraphicalEditPart editPart = (GraphicalEditPart)getHost();
		Point refPoint = getReferencePoint();
		// translate the feedback figure
		PrecisionRectangle rect = new PrecisionRectangle(getInitialFeedbackBounds().getCopy());
		getHostFigure().translateToAbsolute(rect);
		rect.translate(request.getMoveDelta());
		rect.resize(request.getSizeDelta());
		getHostFigure().translateToRelative(rect);
		Point normalPoint = LabelHelper.offsetFromRelativeCoordinate(getHostFigure(), rect, refPoint);
		ICommand moveCommand = new SetBoundsCommand(editPart.getEditingDomain(), DiagramUIMessages.MoveLabelCommand_Label_Location, new EObjectAdapter((View)editPart.getModel()), normalPoint);
		return new ICommandProxy(moveCommand);
	}

	/**
	 * Overridden to use a customized drag tracker for the handles. The <code>isMove()</code> method of the drag tracker needs to be overridden
	 * as the parent of the label and connection will not be the same as the
	 * target editpart, instead it returns true always since labels can only be
	 * moved and not resized.
	 * 
	 * @return a drag tracker
	 */
	protected DragTracker createSelectionHandleDragTracker() {
		return new DragEditPartsTrackerEx(getHost()) {

			@Override
			protected boolean isMove() {
				return true;
			}
		};
	}
}
