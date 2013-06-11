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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.helper.NotificationHelper;
import org.eclipse.papyrus.uml.diagram.common.providers.UIAdapterImpl;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.MessageLabelEditPolicy.ICustomMessageLabel;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.UMLTextSelectionEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.util.GateHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.SelfMessageHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomMessageName2EditPart extends MessageName2EditPart implements ICustomMessageLabel {

	private NotificationHelper notifier = new NotificationHelper(new UIAdapterImpl() {

		@Override
		protected void safeNotifyChanged(Notification msg) {
			handleNotificationEvent(msg);
		}
	});

	private NotificationHelper firstDirectEditListener = null;

	/**
	 * Constructor.
	 * 
	 * @param view
	 */
	public CustomMessageName2EditPart(View view) {
		super(view);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#deactivate()
	 * 
	 */
	@Override
	public void deactivate() {
		notifier.unlistenAll();
		super.deactivate();
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#activate()
	 * 
	 */
	@Override
	public void activate() {
		super.activate();
		Message outerCFMessage = getOuterCFMessage();
		if(outerCFMessage != null) {
			notifier.listenObject(outerCFMessage);
		}
	}

	private Message getOuterCFMessage() {
		EObject element = resolveSemanticElement();
		if(element instanceof Message) {
			return GateHelper.getOuterCFMessage((Message)element);
		}
		return null;
	}

	@Override
	public void refreshBounds() {
		super.refreshBounds();
		Message2EditPart parent = (Message2EditPart)getParent();
		//Update location of label for self linked message.
		if(SelfMessageHelper.isSelfLink(parent)) {
			SelfMessageHelper.updateLabelLocation(this);
		}
	}

	@Override
	protected void refreshLabel() {
		EditPolicy maskLabelPolicy = getParent().getEditPolicy(IMaskManagedLabelEditPolicy.MASK_MANAGED_LABEL_EDIT_POLICY);
		if(maskLabelPolicy == null) {
			setLabelTextHelper(getFigure(), getLabelText());
			setLabelIconHelper(getFigure(), getLabelIcon());
		}
		Object pdEditPolicy = getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
		if(pdEditPolicy instanceof UMLTextSelectionEditPolicy) {
			((UMLTextSelectionEditPolicy)pdEditPolicy).refreshFeedback();
		}
		Object sfEditPolicy = getEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE);
		if(sfEditPolicy instanceof UMLTextSelectionEditPolicy) {
			((UMLTextSelectionEditPolicy)sfEditPolicy).refreshFeedback();
		}
	}

	@Override
	public void refreshFont() {
		FontStyle style = (FontStyle)getFontStyleOwnerView().getStyle(NotationPackage.eINSTANCE.getFontStyle());
		if(style != null) {
			FontData fontData = new FontData(style.getFontName(), style.getFontHeight(), (style.isBold() ? SWT.BOLD : SWT.NORMAL) | (style.isItalic() ? SWT.ITALIC : SWT.NORMAL));
			setFont(fontData);
		}
	}

	private View getFontStyleOwnerView() {
		return (View)getParent().getModel();
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageName2EditPart#performDirectEditRequest(org.eclipse.gef.Request)
	 * 
	 * @param request
	 */
	@Override
	protected void performDirectEditRequest(Request request) {
		Object data = request.getExtendedData().get(SequenceRequestConstant.DIRECT_EDIT_AFTER_CREATION);
		if(data != null && "true".equals(data.toString())) {
			EObject element = resolveSemanticElement();
			if(element instanceof Message) {
				//By using suggestion name for message in CombinedFragment.
				MessageEnd sendEvent = ((Message)element).getSendEvent();
				if(sendEvent instanceof Gate && GateHelper.isInnerCFGate((Gate)sendEvent)) {
					return;
				}
				MessageEnd receiveEvent = ((Message)element).getReceiveEvent();
				if(receiveEvent instanceof Gate && GateHelper.isInnerCFGate((Gate)receiveEvent)) {
					return;
				}
				final Message message = (Message)element;
				firstDirectEditListener = new NotificationHelper(new UIAdapterImpl() {

					@Override
					protected void safeNotifyChanged(Notification msg) {
						if(message == msg.getNotifier() && UMLPackage.eINSTANCE.getNamedElement_Name() == msg.getFeature()) {
							postFirstTimeDirectEdit(message);
							firstDirectEditListener.unlistenAll();
							firstDirectEditListener = null;
						}
					}
				});
				firstDirectEditListener.listenObject(message);
			}
		}
		super.performDirectEditRequest(request);
	}

	/**
	 * This method would be called once after first direct edit at the end of creation.
	 * 
	 * Update name of Gate to suggested name with the linked nessage.
	 */
	protected void postFirstTimeDirectEdit(Message message) {
		GateHelper.updateGateWithMessage(message, true);
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageName2EditPart#handleNotificationEvent(org.eclipse.emf.common.notify.Notification)
	 * 
	 * @param event
	 */
	@Override
	protected void handleNotificationEvent(Notification event) {
		//		if(event.getNotifier() == getOuterCFMessage() && UMLPackage.eINSTANCE.getNamedElement_Name() == event.getFeature()) {
		//			Message message = (Message)resolveSemanticElement();
		//			message.setName(getOuterCFMessage().getName());
		//		}
		super.handleNotificationEvent(event);
	}
}
