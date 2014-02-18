/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.composite.custom.edit.policies;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AbstractMaskManagedEditPolicy;
import org.eclipse.papyrus.uml.diagram.composite.custom.helper.ParameterLabelHelper;
import org.eclipse.papyrus.uml.tools.utils.ICustomAppearance;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Specific edit policy for label displaying stereotypes and their properties for edges representing
 * UML elements.
 */
public class ParameterLabelEditPolicy extends AbstractMaskManagedEditPolicy {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addAdditionalListeners() {
		super.addAdditionalListeners();
		Parameter parameter = getUMLElement();
		if(parameter == null) {
			// check semantic element is not null and this is really an instance of Parameter
			return;
		}
		// adds a listener to the element itself, and to linked elements, like Type
		if(parameter.getType() != null) {
			getDiagramEventBroker().addNotificationListener(parameter.getType(), this);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<String> getDefaultDisplayValue() {
		return ICustomAppearance.DEFAULT_UML_PARAMETER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, String> getMasks() {
		return ParameterLabelHelper.getInstance().getMasks();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Parameter getUMLElement() {
		return (Parameter)super.getUMLElement();
	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		// change the label of the figure managed by the host edit part (managed by the parent edit
		// part in general...)
		// it must be changed only if:
		// - the annotation corresponding to the display of the stereotype changes
		// - the stereotype application list has changed
		Object object = notification.getNotifier();
		Parameter parameter = (Parameter)hostSemanticElement;

		if((object == null) || (hostSemanticElement == null)) {
			return;
		}

		if(object.equals(parameter)) {
			notifyParameterChanged(parameter, notification);
		} else if(object.equals(parameter.getType())) {
			notifyParameterTypeChanged(parameter.getType(), notification);
		}

		if(isMaskManagedAnnotation(object)) {
			refreshDisplay();
		}

		if(isRemovedMaskManagedLabelAnnotation(object, notification)) {
			refreshDisplay();
		}

	}

	/**
	 * notifies that the the parameter has changed.
	 *
	 * @param parameter
	 *        the parameter that has changed
	 * @param notification
	 *        the notification send when the element has been changed
	 */
	protected void notifyParameterChanged(Parameter parameter, Notification notification) {
		switch(notification.getFeatureID(Parameter.class)) {
		case UMLPackage.PARAMETER__NAME:
		case UMLPackage.PARAMETER__VISIBILITY:
		case UMLPackage.PARAMETER__DIRECTION:
		case UMLPackage.PARAMETER__LOWER:
		case UMLPackage.PARAMETER__LOWER_VALUE:
		case UMLPackage.PARAMETER__UPPER:
		case UMLPackage.PARAMETER__UPPER_VALUE:
		case UMLPackage.PARAMETER__DEFAULT_VALUE:
		case UMLPackage.PARAMETER__EFFECT:
		case UMLPackage.PARAMETER__IS_ORDERED:
		case UMLPackage.PARAMETER__IS_UNIQUE:
		case UMLPackage.PARAMETER__IS_EXCEPTION:
		case UMLPackage.PARAMETER__IS_STREAM:
			refreshDisplay();
			break;
		case UMLPackage.PARAMETER__TYPE:

			switch(notification.getEventType()) {
			// if it is added => adds listener to the type element
			case Notification.ADD:
				getDiagramEventBroker().addNotificationListener((EObject)notification.getNewValue(), this);
				refreshDisplay();
				// if it is removed => removes listener from the type element
				break;
			case Notification.ADD_MANY: // should never happen
				if(notification.getNewValue() instanceof List<?>) {
					List<?> addedElements = (List<?>)notification.getNewValue();
					for(Object addedElement : addedElements) {
						if(addedElement instanceof EObject) {
							getDiagramEventBroker().addNotificationListener((EObject)addedElement, this);
						}
					}
				}
				refreshDisplay();
				break;
			case Notification.REMOVE:
				getDiagramEventBroker().removeNotificationListener((EObject)notification.getOldValue(), this);
				refreshDisplay();
				break;
			case Notification.REMOVE_MANY: // should never happen
				if(notification.getOldValue() instanceof List<?>) {
					List<?> removedElements = (List<?>)notification.getOldValue();
					for(Object removedElement : removedElements) {
						if(removedElement instanceof EObject) {
							getDiagramEventBroker().removeNotificationListener((EObject)removedElement, this);
						}
					}
				}
				refreshDisplay();
				break;
			// if it is set, remove the old one and adds the new one. this is the method use when
			// the type is set or removed...
			case Notification.SET:
				if(notification.getNewValue() != null) {
					getDiagramEventBroker().addNotificationListener((EObject)notification.getNewValue(), this);
				}
				if(notification.getOldValue() != null) {
					getDiagramEventBroker().removeNotificationListener((EObject)notification.getOldValue(), this);
				}
				refreshDisplay();

			default:
				break;

			}

			break;
		default:
			// does nothing in other cases
			break;
		}
	}

	/**
	 * notifies that the type of the parameter has changed.
	 *
	 * @param type
	 *        the type of the parameter that has changed
	 * @param notification
	 *        the notification send when the element has been changed
	 */
	protected void notifyParameterTypeChanged(Type type, Notification notification) {
		switch(notification.getFeatureID(Parameter.class)) {
		case UMLPackage.TYPE__NAME:
			refreshDisplay(); // type name has changed => refresh the parameter display
			break;
		default:
			// does nothing by default
			break;
		}
	}

	/**
	 * Refreshes the display of the edit part
	 */
	@Override
	public void refreshDisplay() {
		// calls the helper for this edit Part
		ParameterLabelHelper.getInstance().refreshEditPartDisplay((GraphicalEditPart)getHost());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void removeAdditionalListeners() {
		super.removeAdditionalListeners();
		Parameter parameter = getUMLElement();
		if(parameter == null) {
			// check semantic element is not null and this is really an instance of Parameter
			return;
		}
		if(parameter.getType() != null) {
			getDiagramEventBroker().removeNotificationListener(parameter.getType(), this);
		}
	}
}
