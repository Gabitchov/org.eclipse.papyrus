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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.diagram.sequence.edit.policies.Message3ItemSemanticEditPolicy;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class Message3EditPart extends ConnectionNodeEditPart

implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4005;

	/**
	 * Title for dialog of block message sort modification error
	 */
	private static final String BLOCK_SORT_MODIFICATION_TITLE = "Forbidden action"; //$NON-NLS-1$

	/**
	 * Message for dialog of block message sort modification error
	 */
	private static final String BLOCK_SORT_MODIFICATION_MSG = "It's impossible to change the message sort"; //$NON-NLS-1$

	/**
	 * The current message sort
	 */
	private MessageSort messageSort;

	/**
	 * @generated
	 */
	public Message3EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new Message3ItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof MessageName3EditPart) {
			((MessageName3EditPart)childEditPart).setLabel(getPrimaryShape().getFigureMessageReplyLabelFigure());
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
		if(childEditPart instanceof MessageName3EditPart) {
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
		return new MessageReply();
	}

	/**
	 * @generated
	 */
	public MessageReply getPrimaryShape() {
		return (MessageReply)getFigure();
	}

	/**
	 * @generated
	 */
	public class MessageReply extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureMessageReplyLabelFigure;

		/**
		 * @generated
		 */
		public MessageReply() {
			this.setLineWidth(1);
			this.setLineStyle(Graphics.LINE_DASH);
			this.setForegroundColor(ColorConstants.black);

			createContents();
			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private void createContents() {


			fFigureMessageReplyLabelFigure = new WrappingLabel();
			fFigureMessageReplyLabelFigure.setText("");

			fFigureMessageReplyLabelFigure.setFont(FFIGUREMESSAGEREPLYLABELFIGURE_FONT);



			this.add(fFigureMessageReplyLabelFigure);


		}

		/**
		 * @generated
		 */
		private RotatableDecoration createTargetDecoration() {
			PolylineDecoration df = new PolylineDecoration();
			df.setLineWidth(1);
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
		public WrappingLabel getFigureMessageReplyLabelFigure() {
			return fFigureMessageReplyLabelFigure;
		}

		/**
		 * Block bend points
		 */
		@Override
		public void setRoutingStyles(boolean closestDistance, boolean avoidObstacles) {
			super.setRoutingStyles(true, avoidObstacles);
		}

	}

	/**
	 * @generated
	 */
	static final Font FFIGUREMESSAGEREPLYLABELFIGURE_FONT = new Font(Display.getCurrent(), "SANS", 9, SWT.NORMAL);

	/**
	 * Block bend point
	 */
	@Override
	public Command getCommand(Request request) {
		if(request.getType().equals(REQ_CREATE_BENDPOINT) || request.getType().equals(REQ_MOVE_BENDPOINT)) {
			return UnexecutableCommand.INSTANCE;
		}
		return super.getCommand(request);
	}

	/**
	 * Block message sort modification
	 */
	@Override
	protected void handleNotificationEvent(Notification notification) {
		Object feature = notification.getFeature();

		if(UMLPackage.eINSTANCE.getMessage_MessageSort().equals(feature) && (messageSort == null || !messageSort.equals(notification.getNewValue()))) {
			Object oldValue = notification.getOldValue();
			if(oldValue instanceof MessageSort) {
				Message message = (Message)resolveSemanticElement();
				MessageDialog.openWarning(Display.getCurrent().getActiveShell(), BLOCK_SORT_MODIFICATION_TITLE, BLOCK_SORT_MODIFICATION_MSG);
				// TODO Improve cancelation method
				message.setMessageSort((MessageSort)oldValue);
				messageSort = (MessageSort)oldValue;
				return;
			}
		}
		super.handleNotificationEvent(notification);
	}

}
