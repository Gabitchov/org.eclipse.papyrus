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
package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Graphics;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.AnnotatedLinkEndpointEditPolicy;


/**
 * Abstract link class for connections with Comment, Constraint and Observations.
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public abstract class AnnotatedLinkEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * Constructor.
	 * 
	 * @param view
	 */
	public AnnotatedLinkEditPart(View view) {
		super(view);
	}

	@Override
	protected Connection createConnectionFigure() {
		return new AnnotatedLinkDescriptor();
	}

	public AnnotatedLinkDescriptor getPrimaryShape() {
		return (AnnotatedLinkDescriptor)getFigure();
	}

	@Override
	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);
		Object feature = notification.getFeature();
		if(NotationPackage.eINSTANCE.getLineStyle_LineWidth().equals(feature)) {
			refreshLineWidth();
		}
	}

	@Override
	public EditPart getTargetEditPart(Request request) {
		EditPart ep = super.getTargetEditPart(request);

		if(ep != null && ep instanceof org.eclipse.gef.ConnectionEditPart) {
			if(request instanceof ReconnectRequest) {
				ReconnectRequest rRequest = (ReconnectRequest)request;

				// If this is just moving an anchor point on the same target or
				// source, then it is fine.  See bugzilla# 208408. 
				if(rRequest.isMovingStartAnchor()) {
					if(rRequest.getConnectionEditPart().getSource() == ep) {
						return ep;
					}
				} else if(rRequest.getConnectionEditPart().getTarget() == ep) {
					return ep;
				}

				// If source anchor is moved, the connection's source edit part
				// should not be taken into account for a cyclic dependency
				// check so as to avoid false checks. Same goes for the target
				// anchor. See bugzilla# 155243 -- we do not want to target a
				// connection that is already connected to us so that we do not
				// introduce a cyclic connection                
				if(isCyclicConnectionRequest((org.eclipse.gef.ConnectionEditPart)ep, rRequest.getConnectionEditPart(), false, rRequest.isMovingStartAnchor())) {
					return null;
				}
			}
		}

		return ep;
	}

	private boolean isCyclicConnectionRequest(org.eclipse.gef.ConnectionEditPart targetCEP, org.eclipse.gef.ConnectionEditPart sourceCEP, boolean checkSourceAndTargetEditParts, boolean doNotCheckSourceEditPart) {

		if(targetCEP == null || sourceCEP == null) {
			return false;
		}

		if(sourceCEP == targetCEP) {
			return true;
		}

		// first, do a cyclic check on source and target connections 
		// of the source connection itself.
		// (as every connection is also a node).

		HashSet set = new HashSet();
		getSourceAndTargetConnections(set, sourceCEP);
		if(set.contains(targetCEP.getFigure())) {
			return true;
		}


		// now do the cyclic check on the source and target of the source connection...  
		EditPart sourceEP = sourceCEP.getSource(), targetEP = sourceCEP.getTarget();

		if((sourceEP == targetCEP) || (targetEP == targetCEP)) {
			return true;
		} else {

			if(!checkSourceAndTargetEditParts && doNotCheckSourceEditPart) {
				// .
			} else if(sourceEP instanceof org.eclipse.gef.ConnectionEditPart && isCyclicConnectionRequest(targetCEP, (org.eclipse.gef.ConnectionEditPart)sourceEP, true, doNotCheckSourceEditPart)) {
				return true;
			}

			if(!checkSourceAndTargetEditParts && !doNotCheckSourceEditPart) {
				// .
			} else if(targetEP instanceof org.eclipse.gef.ConnectionEditPart && isCyclicConnectionRequest(targetCEP, (org.eclipse.gef.ConnectionEditPart)targetEP, true, doNotCheckSourceEditPart)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Retrieve the list of all source and target connections for the connection.
	 * 
	 * @param set
	 *        HashSet to add the connections to.
	 * @param connectionEditPart
	 *        the connection edit part.
	 */
	private void getSourceAndTargetConnections(HashSet set, org.eclipse.gef.ConnectionEditPart connectionEditPart) {

		if(connectionEditPart == null || set == null) {
			return;
		}

		for(Iterator i = connectionEditPart.getSourceConnections().iterator(); i.hasNext();) {

			org.eclipse.gef.ConnectionEditPart next = (org.eclipse.gef.ConnectionEditPart)i.next();
			Connection sourceConnection = (Connection)next.getFigure();
			set.add(sourceConnection);
			getSourceAndTargetConnections(set, next);
		}

		for(Iterator i = connectionEditPart.getTargetConnections().iterator(); i.hasNext();) {

			org.eclipse.gef.ConnectionEditPart next = (org.eclipse.gef.ConnectionEditPart)i.next();
			Connection targetConnection = (Connection)next.getFigure();
			set.add(targetConnection);
			getSourceAndTargetConnections(set, next);
		}


		//For message edit part, we need to collect all connections from message ends.
		if(connectionEditPart instanceof AbstractMessageEditPart) {
			List children = ((AbstractMessageEditPart)connectionEditPart).getChildren();
			for(Object object : children) {
				if(!(object instanceof MessageEndEditPart)) {
					continue;
				}
				for(Iterator i = ((MessageEndEditPart)object).getSourceConnections().iterator(); i.hasNext();) {

					org.eclipse.gef.ConnectionEditPart next = (org.eclipse.gef.ConnectionEditPart)i.next();
					Connection sourceConnection = (Connection)next.getFigure();
					set.add(sourceConnection);
					getSourceAndTargetConnections(set, next);
				}
				for(Iterator i = ((MessageEndEditPart)object).getTargetConnections().iterator(); i.hasNext();) {

					org.eclipse.gef.ConnectionEditPart next = (org.eclipse.gef.ConnectionEditPart)i.next();
					Connection targetConnection = (Connection)next.getFigure();
					set.add(targetConnection);
					getSourceAndTargetConnections(set, next);
				}
			}
		}
	}

	@Override
	protected void setLineWidth(int width) {
		getPrimaryShape().setLineWidth(width);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new AnnotatedLinkEndpointEditPolicy());
	}

	public class AnnotatedLinkDescriptor extends PolylineConnectionEx {

		public AnnotatedLinkDescriptor() {
			this.setLineStyle(Graphics.LINE_DASH);
		}
	}


}
