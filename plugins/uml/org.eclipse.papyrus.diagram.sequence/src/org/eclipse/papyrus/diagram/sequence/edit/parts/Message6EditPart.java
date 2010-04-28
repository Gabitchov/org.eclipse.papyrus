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
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.diagram.sequence.edit.policies.CreationOnMessageEditPolicy;
import org.eclipse.papyrus.diagram.sequence.edit.policies.Message6ItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.sequence.figures.EllipseDecoration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class Message6EditPart extends ConnectionNodeEditPart

implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4008;

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
	public Message6EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new Message6ItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationOnMessageEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof MessageName6EditPart) {
			((MessageName6EditPart)childEditPart).setLabel(getPrimaryShape().getFigureMessageLostLabelFigure());
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
		if(childEditPart instanceof MessageName6EditPart) {
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
		return new MessageLost();
	}

	/**
	 * @generated
	 */
	public MessageLost getPrimaryShape() {
		return (MessageLost)getFigure();
	}

	/**
	 * @generated
	 */
	public class MessageLost extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureMessageLostLabelFigure;

		/**
		 * @generated
		 */
		public MessageLost() {
			this.setLineWidth(1);
			this.setForegroundColor(ColorConstants.black);

			createContents();
			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private void createContents() {


			fFigureMessageLostLabelFigure = new WrappingLabel();
			fFigureMessageLostLabelFigure.setText("");

			fFigureMessageLostLabelFigure.setFont(FFIGUREMESSAGELOSTLABELFIGURE_FONT);



			this.add(fFigureMessageLostLabelFigure);


		}

		/**
		 * @generated
		 */
		private RotatableDecoration createTargetDecoration() {
			EllipseDecoration df = new EllipseDecoration();




			df.setAlwaysFill(true);




			df.setPreferredSize(new Dimension(10, 10));



			return df;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureMessageLostLabelFigure() {
			return fFigureMessageLostLabelFigure;
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
	static final Font FFIGUREMESSAGELOSTLABELFIGURE_FONT = new Font(Display.getCurrent(), "SANS", 9, SWT.NORMAL);

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
