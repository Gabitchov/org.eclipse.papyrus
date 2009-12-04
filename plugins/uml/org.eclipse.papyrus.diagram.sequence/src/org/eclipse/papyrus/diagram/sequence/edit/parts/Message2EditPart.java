/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
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
import org.eclipse.papyrus.diagram.sequence.edit.policies.Message2ItemSemanticEditPolicy;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class Message2EditPart extends ConnectionNodeEditPart

implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4004;

	/**
	 * Title for dialog of block message sort modification error
	 * 
	 * @generated NOT
	 */
	private static final String BLOCK_SORT_MODIFICATION_TITLE = "Forbidden action"; //$NON-NLS-1$

	/**
	 * Message for dialog of block message sort modification error
	 * 
	 * @generated NOT
	 */
	private static final String BLOCK_SORT_MODIFICATION_MSG = "It's impossible to change the message sort"; //$NON-NLS-1$

	/**
	 * The current message sort
	 * 
	 * @generated NOT
	 */
	private MessageSort messageSort;

	/**
	 * @generated
	 */
	public Message2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new Message2ItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof MessageName2EditPart) {
			((MessageName2EditPart)childEditPart).setLabel(getPrimaryShape().getFigureMessageAsyncLabelFigure());
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
		if(childEditPart instanceof MessageName2EditPart) {
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
		return new MessageAsync();
	}

	/**
	 * @generated
	 */
	public MessageAsync getPrimaryShape() {
		return (MessageAsync)getFigure();
	}

	/**
	 * @generated
	 */
	public class MessageAsync extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureMessageAsyncLabelFigure;

		/**
		 * @generated
		 */
		public MessageAsync() {
			this.setLineWidth(1);

			createContents();
			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureMessageAsyncLabelFigure = new WrappingLabel();
			fFigureMessageAsyncLabelFigure.setText("");
			fFigureMessageAsyncLabelFigure.setForegroundColor(ColorConstants.black);

			fFigureMessageAsyncLabelFigure.setFont(FFIGUREMESSAGEASYNCLABELFIGURE_FONT);

			this.add(fFigureMessageAsyncLabelFigure);

		}

		/**
		 * Generated NOT for block bend points
		 * 
		 * @generated NOT
		 */
		@Override
		public void setRoutingStyles(boolean closestDistance, boolean avoidObstacles) {
			super.setRoutingStyles(true, avoidObstacles);
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
		public WrappingLabel getFigureMessageAsyncLabelFigure() {
			return fFigureMessageAsyncLabelFigure;
		}

	}

	/**
	 * @generated
	 */
	static final Font FFIGUREMESSAGEASYNCLABELFIGURE_FONT = new Font(Display.getCurrent(), "SANS", 9, SWT.NORMAL);

	/**
	 * Generated not for block bend point
	 * 
	 * @generated NOT
	 */
	@Override
	public Command getCommand(Request request) {
		if(request.getType().equals(REQ_CREATE_BENDPOINT) || request.getType().equals(REQ_MOVE_BENDPOINT)) {
			return UnexecutableCommand.INSTANCE;
		}
		return super.getCommand(request);
	}

	/**
	 * Generated not for block message sort modification
	 * 
	 * @generated NOT
	 */
	@Override
	protected void handleNotificationEvent(Notification notification) {
		Object feature = notification.getFeature();

		if(UMLPackage.eINSTANCE.getMessage_MessageSort().equals(feature)
				&& (messageSort == null || !messageSort.equals(notification.getNewValue()))) {
			Object oldValue = notification.getOldValue();
			if(oldValue instanceof MessageSort) {
				Message message = (Message)resolveSemanticElement();
				MessageDialog.openWarning(Display.getCurrent().getActiveShell(), BLOCK_SORT_MODIFICATION_TITLE,
						BLOCK_SORT_MODIFICATION_MSG);
				// TODO Improve cancelation method
				message.setMessageSort((MessageSort)oldValue);
				messageSort = (MessageSort)oldValue;
				return;
			}
		}
		super.handleNotificationEvent(notification);
	}

}
