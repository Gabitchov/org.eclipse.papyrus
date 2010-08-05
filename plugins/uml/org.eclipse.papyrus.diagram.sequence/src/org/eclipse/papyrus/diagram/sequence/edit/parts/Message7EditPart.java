/*****************************************************************************
 * Copyright (c) 2009 CEA
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
package org.eclipse.papyrus.diagram.sequence.edit.parts;

import org.eclipse.draw2d.AutomaticRouter;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.internal.figures.ConnectionLayerEx;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.RoutingStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.editpolicies.AppliedStereotypeLinkLabelDisplayEditPolicy;
import org.eclipse.papyrus.diagram.common.figure.edge.UMLEdgeFigure;
import org.eclipse.papyrus.diagram.sequence.draw2d.routers.MessageRouter;
import org.eclipse.papyrus.diagram.sequence.edit.policies.CreationOnMessageEditPolicy;
import org.eclipse.papyrus.diagram.sequence.edit.policies.LifelineChildGraphicalNodeEditPolicy;
import org.eclipse.papyrus.diagram.sequence.edit.policies.Message7ItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.sequence.edit.policies.MessageConnectionEditPolicy;
import org.eclipse.papyrus.diagram.sequence.figures.EllipseDecoration;
import org.eclipse.papyrus.diagram.sequence.util.SequenceUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageSort;

/**
 * @generated
 */
public class Message7EditPart extends ConnectionNodeEditPart

implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4009;

	/**
	 * @generated
	 */
	public Message7EditPart(View view) {
		super(view);
	}

	/**
	 * Installs a router on the edit part, depending on the <code>RoutingStyle</code> Use the specific message router rather than the default oblique
	 * one.
	 * 
	 * @generated NOT
	 */
	protected void installRouter() {
		ConnectionLayer cLayer = (ConnectionLayer)getLayer(LayerConstants.CONNECTION_LAYER);
		RoutingStyle style = (RoutingStyle)((View)getModel()).getStyle(NotationPackage.Literals.ROUTING_STYLE);

		if(style != null && cLayer instanceof ConnectionLayerEx) {

			ConnectionLayerEx cLayerEx = (ConnectionLayerEx)cLayer;
			Routing routing = style.getRouting();
			if(Routing.MANUAL_LITERAL == routing) {
				ConnectionRouter router = cLayerEx.getObliqueRouter();
				// replace the oblique router by the message router
				if(router instanceof AutomaticRouter) {
					if(LifelineChildGraphicalNodeEditPolicy.messageRouter == null) {

						LifelineChildGraphicalNodeEditPolicy.messageRouter = new MessageRouter();
					}
					((AutomaticRouter)router).setNextRouter(LifelineChildGraphicalNodeEditPolicy.messageRouter);
				}
				getConnectionFigure().setConnectionRouter(router);
			} else if(Routing.RECTILINEAR_LITERAL == routing) {
				getConnectionFigure().setConnectionRouter(cLayerEx.getRectilinearRouter());
			} else if(Routing.TREE_LITERAL == routing) {
				getConnectionFigure().setConnectionRouter(cLayerEx.getTreeRouter());
			}

		}

		refreshRouterChange();
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new Message7ItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationOnMessageEditPolicy());
		installEditPolicy(EditPolicy.CONNECTION_ROLE, new MessageConnectionEditPolicy());
		installEditPolicy(AppliedStereotypeLinkLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new AppliedStereotypeLinkLabelDisplayEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof MessageName7EditPart) {
			((MessageName7EditPart)childEditPart).setLabel(getPrimaryShape().getFigureMessageFoundLabelFigure());
			return true;
		}
		if(childEditPart instanceof MessageFoundAppliedStereotypeEditPart) {
			((MessageFoundAppliedStereotypeEditPart)childEditPart).setLabel(getPrimaryShape().getAppliedStereotypeLabel());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if(addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof MessageName7EditPart) {
			return true;
		}
		if(childEditPart instanceof MessageFoundAppliedStereotypeEditPart) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if(removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so you may safely remove
	 * <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */

	protected Connection createConnectionFigure() {
		return new MessageFound();
	}

	/**
	 * @generated
	 */
	public MessageFound getPrimaryShape() {
		return (MessageFound)getFigure();
	}

	/**
	 * @generated NOT inherits from UMLEdgeFigure to manage stereotype label
	 */
	public class MessageFound extends UMLEdgeFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureMessageFoundLabelFigure;

		/**
		 * @generated
		 */
		private WrappingLabel fAppliedStereotypeLabel;

		/**
		 * @generated NOT call the super constructor
		 */
		public MessageFound() {
			super();
			this.setForegroundColor(ColorConstants.black);

			createContents();
			setSourceDecoration(createSourceDecoration());
			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated NOT
		 */
		protected void createContents() {
			super.createContents();

			fFigureMessageFoundLabelFigure = new WrappingLabel();
			fFigureMessageFoundLabelFigure.setText("");

			fFigureMessageFoundLabelFigure.setFont(FFIGUREMESSAGEFOUNDLABELFIGURE_FONT);

			this.add(fFigureMessageFoundLabelFigure);

		}

		/**
		 * @generated
		 */
		private RotatableDecoration createSourceDecoration() {
			EllipseDecoration df = new EllipseDecoration();

			df.setAlwaysFill(true);

			df.setPreferredSize(new Dimension(10, 10));

			return df;
		}

		/**
		 * @generated
		 */
		private RotatableDecoration createTargetDecoration() {
			PolylineDecoration df = new PolylineDecoration();
			df.setForegroundColor(ColorConstants.black);
			PointList pl = new PointList();
			pl.addPoint(getMapMode().DPtoLP(-2), getMapMode().DPtoLP(2));
			pl.addPoint(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0));
			pl.addPoint(getMapMode().DPtoLP(-2), getMapMode().DPtoLP(-2));
			df.setTemplate(pl);
			df.setScale(getMapMode().DPtoLP(7), getMapMode().DPtoLP(3));
			return df;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureMessageFoundLabelFigure() {
			return fFigureMessageFoundLabelFigure;
		}

		/**
		 * @generated NOT get the stereotype label of super class
		 */
		public WrappingLabel getAppliedStereotypeLabel() {
			return super.getAppliedStereotypeLabel();
		}

	}

	/**
	 * @generated
	 */
	static final Font FFIGUREMESSAGEFOUNDLABELFIGURE_FONT = new Font(Display.getCurrent(), "SANS", 9, SWT.NORMAL);

	/**
	 * Block message sort modification
	 */
	@Override
	protected void handleNotificationEvent(Notification notification) {
		SequenceUtil.handleMessageSortChange(getEditingDomain(), notification, (Message)resolveSemanticElement(), MessageSort.ASYNCH_CALL_LITERAL);
		super.handleNotificationEvent(notification);
	}

	/**
	 * @generated NOT Override for redirecting creation request to the lifeline
	 */
	@Override
	public void showSourceFeedback(Request request) {
		if(request instanceof CreateUnspecifiedTypeRequest) {
			getSource().showSourceFeedback(request);
			getTarget().showSourceFeedback(request);
		}
		super.showSourceFeedback(request);
	}

	/**
	 * @generated NOT Override for redirecting creation request to the lifeline
	 */
	@Override
	public void eraseSourceFeedback(Request request) {
		if(request instanceof CreateUnspecifiedTypeRequest) {
			getSource().eraseSourceFeedback(request);
			getTarget().eraseSourceFeedback(request);
		}
		super.eraseSourceFeedback(request);
	}

}
