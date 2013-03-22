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
package org.eclipse.papyrus.uml.diagram.activity.helper;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.activity.edit.helpers.AcceptEventActionEditHelper;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.AcceptEventActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.AcceptEventActionEditPart.AcceptEventActionFigure;
import org.eclipse.papyrus.uml.diagram.common.helper.NotificationHelper;
import org.eclipse.papyrus.uml.diagram.common.providers.UIAdapterImpl;
import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * The AcceptEventActionSwitchHelper class is used to help updating an
 * AcceptEventAction's figure. It enables to switch between the classic pentagon
 * representation and the hourglass representation of an AcceptTimeEventAction.
 */
public class AcceptEventActionSwitchHelper extends NotificationHelper {

	/** The size factor between the classic figure and the hourglass figure */
	private static final int REDUCE_WIDTH_FACTOR_FOR_HOURGLASS = 4;

	/**
	 * The UI adapter that listens model update to detect when figure switch
	 * must be performed
	 */
	private UIAdapter adapter = new UIAdapter();

	/** The edit part which this helper handles the switch for */
	private AcceptEventActionEditPart editPart;

	/**
	 * Construct a new switch helper which will automatically manage the switch
	 * when properties are edited.
	 * 
	 * @param acceptEventActionEditPart
	 *        the part of an AcceptEventAction, for which the switch must be
	 *        managed.
	 */
	public AcceptEventActionSwitchHelper(AcceptEventActionEditPart acceptEventActionEditPart) {
		editPart = acceptEventActionEditPart;
		this.setModelListener(adapter);
	}

	/**
	 * Private class UIAdapter. This class listens at appropriate model elements
	 * to detect when an AcceptEventAction becomes an AcceptTimeEventAction.
	 */
	private class UIAdapter extends UIAdapterImpl {

		/**
		 * Notify the changes by updating listened elements if necessary and
		 * performing the switch if necessary.
		 * 
		 * @see org.eclipse.papyrus.uml.diagram.common.providers.UIAdapterImpl#safeNotifyChanged(org.eclipse.emf.common.notify.Notification)
		 * @param msg
		 *        the notification message
		 */
		@Override
		protected void safeNotifyChanged(Notification msg) {
			if(UMLPackage.eINSTANCE.getAcceptEventAction_Trigger().equals(msg.getFeature())) {
				// listen trigger once the list is modified
				if(msg.getNewValue() instanceof List<?>) {
					for(Object value : (List<?>)msg.getNewValue()) {
						if(value instanceof Notifier) {
							listenObject((Notifier)value);
						}
					}
				} else if(msg.getNewValue() instanceof Notifier) {
					listenObject((Notifier)msg.getNewValue());
				}
				if(msg.getOldValue() instanceof List<?>) {
					for(Object value : (List<?>)msg.getOldValue()) {
						if(value instanceof Notifier) {
							unlistenObject((Notifier)value);
						}
					}
				} else if(msg.getOldValue() instanceof Notifier) {
					unlistenObject((Notifier)msg.getNewValue());
				}
				updateAcceptEventActionFigure();
			} else if(UMLPackage.eINSTANCE.getTrigger_Event().equals(msg.getFeature())) {
				updateAcceptEventActionFigure();
			}
		}
	}

	/**
	 * Get the AcceptEventAction model element managed by the edit part
	 * 
	 * @return AcceptEventAction model element
	 */
	public AcceptEventAction getAction() {
		EObject resolveSemanticElement = editPart.resolveSemanticElement();
		if(resolveSemanticElement instanceof AcceptEventAction) {
			return (AcceptEventAction)resolveSemanticElement;
		}
		return null;
	}

	/**
	 * Update the figure representation, to switch to or from the hourglass
	 * representation
	 */
	public void updateAcceptEventActionFigure() {
		AcceptEventActionFigure actionFigure = editPart.getPrimaryShape();
		boolean useHourglassFigure = CustomAcceptEventActionEditHelper.isAcceptTimeEventAction(getAction());
		boolean hourglassAlreadyUsed = actionFigure.isTemplateForAcceptTimeEventActionUsed();
		if(useHourglassFigure != hourglassAlreadyUsed) {
			// set usage of the correct figure
			actionFigure.useTemplateForAcceptTimeEventAction(useHourglassFigure);
			// arrange the figure so that style remains coherent
			if(editPart.getModel() instanceof View) {
				int locX = actionFigure.getLocation().x;
				int width = actionFigure.getSize().width;
				int newWidth = width;
				if(useHourglassFigure) {
					// switching to hourglass, reduce width
					newWidth = width / REDUCE_WIDTH_FACTOR_FOR_HOURGLASS;
				} else {
					// switching to pentagon, augment width
					newWidth = width * REDUCE_WIDTH_FACTOR_FOR_HOURGLASS;
				}
				// adapt location to keep same center
				ViewUtil.setStructuralFeatureValue((View)editPart.getModel(), NotationPackage.eINSTANCE.getLocation_X(), locX + (width - newWidth) / 2);
				ViewUtil.setStructuralFeatureValue((View)editPart.getModel(), NotationPackage.eINSTANCE.getSize_Width(), newWidth);
			}
		}
	}

	/**
	 * Add listener on an element and its appropriate children in case of an
	 * AcceptEventAction
	 * 
	 * @param element
	 *        The object to listen
	 */
	@Override
	public void listenObject(Notifier element) {
		super.listenObject(element);
		if(element instanceof AcceptEventAction) {
			// also listen at children triggers of the action
			for(Trigger trigger : ((AcceptEventAction)element).getTriggers()) {
				super.listenObject(trigger);
			}
		}
	}
}
