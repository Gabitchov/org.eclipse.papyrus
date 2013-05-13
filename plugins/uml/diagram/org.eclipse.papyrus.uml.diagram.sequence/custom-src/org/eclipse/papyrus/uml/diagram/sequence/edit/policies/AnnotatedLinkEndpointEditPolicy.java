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
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
import org.eclipse.gef.handles.ConnectionEndpointHandle;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gef.tools.ConnectionEndpointTracker;
import org.eclipse.swt.SWT;

/**
 * An editpolicy for handling reconnections of an {@link AnnotatedLinkEditPart}.
 * 
 * @see AnnotatedLinkStartEditPolicy
 * @see AnnotatedLinkEndEditPolicy
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class AnnotatedLinkEndpointEditPolicy extends ConnectionEndpointEditPolicy {

	private IFigure anchorFeedback;

	@Override
	public void eraseSourceFeedback(Request request) {
		if(AnnotatedLinkStartEditPolicy.REQ_ANNOTATED_LINK_REORIENT_START.equals(request.getType()) || AnnotatedLinkEndEditPolicy.REQ_ANNOTATED_LINK_REORIENT_END.equals(request.getType())) {
			eraseConnectionMoveFeedback((ReconnectRequest)request);
		}
	}

	@Override
	public void showSourceFeedback(Request request) {
		if(AnnotatedLinkStartEditPolicy.REQ_ANNOTATED_LINK_REORIENT_START.equals(request.getType()) || AnnotatedLinkEndEditPolicy.REQ_ANNOTATED_LINK_REORIENT_END.equals(request.getType())) {
			showConnectionMoveFeedback((ReconnectRequest)request);
		}
	}

	@Override
	protected void showConnectionMoveFeedback(ReconnectRequest request) {
		super.showConnectionMoveFeedback(request);
		EditPart target = request.getTarget();
		boolean showFeedback = target != null;
		if(target != null) {
			Command command = target.getCommand(request);
			showFeedback = command != null && command.canExecute();
		}
		if(showFeedback) {
			Point location = null;
			Connection connection = getConnection();
			PointList points = connection.getPoints().getCopy();
			if(request.isMovingStartAnchor()) {
				location = points.getFirstPoint();
			} else {
				location = points.getLastPoint();
			}
			connection.translateToAbsolute(location);
			setFeedbackLocation(getAnchorFeedback(), location);
		} else {
			if(anchorFeedback != null && anchorFeedback.getParent() != null) {
				removeFeedback(anchorFeedback);
			}
			anchorFeedback = null;
		}
	}

	@Override
	protected void eraseConnectionMoveFeedback(ReconnectRequest request) {
		super.eraseConnectionMoveFeedback(request);
		if(anchorFeedback != null && anchorFeedback.getParent() != null) {
			removeFeedback(anchorFeedback);
		}
		anchorFeedback = null;
	}

	private void setFeedbackLocation(IFigure feedback, Point location) {
		if(feedback == null || location == null) {
			return;
		}
		Point p = location.getCopy();
		Dimension d = feedback.getSize();
		p.x = p.x - d.width / 2;
		p.y = p.y - d.height / 2;
		feedback.translateToRelative(p);
		feedback.setLocation(p);
	}

	private IFigure getAnchorFeedback() {
		if(anchorFeedback == null || anchorFeedback.getParent() == null) {
			Ellipse feedback = new Ellipse();
			feedback.setLineWidth(2);
			feedback.setAntialias(SWT.ON);
			feedback.setSize(10, 10);
			getFeedbackLayer().add(feedback);
			anchorFeedback = feedback;
		}
		return anchorFeedback;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected List createSelectionHandles() {
		List list = new ArrayList();
		list.add(new ConnectionEndpointHandle((ConnectionEditPart)getHost(), ConnectionLocator.SOURCE) {

			@Override
			protected DragTracker createDragTracker() {
				ConnectionEndpointTracker tracker = new ConnectionEndpointTracker((ConnectionEditPart)getOwner()) {

					@Override
					protected Request createTargetRequest() {
						ReconnectRequest request = new ReconnectRequest(getCommandName()) {

							@Override
							public boolean isMovingStartAnchor() {
								return true;
							}
						};
						request.setConnectionEditPart(getConnectionEditPart());
						return request;
					}
				};
				tracker.setCommandName(AnnotatedLinkStartEditPolicy.REQ_ANNOTATED_LINK_REORIENT_START);
				tracker.setDefaultCursor(getCursor());
				return tracker;
			}
		});
		list.add(new ConnectionEndpointHandle((ConnectionEditPart)getHost(), ConnectionLocator.TARGET) {

			@Override
			protected DragTracker createDragTracker() {
				ConnectionEndpointTracker tracker = new ConnectionEndpointTracker((ConnectionEditPart)getOwner()) {

					@Override
					protected Request createTargetRequest() {
						ReconnectRequest request = new ReconnectRequest(getCommandName()) {

							@Override
							public boolean isMovingStartAnchor() {
								return false;
							}
						};
						request.setConnectionEditPart(getConnectionEditPart());
						return request;
					}
				};
				tracker.setCommandName(AnnotatedLinkEndEditPolicy.REQ_ANNOTATED_LINK_REORIENT_END);
				tracker.setDefaultCursor(getCursor());
				return tracker;
			}
		});
		return list;
	}
}
