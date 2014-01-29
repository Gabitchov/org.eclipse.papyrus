/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *  Nizar GUEDIDI (CEA LIST) - Update getUMLElement()
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.custom.edit.policies;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AbstractMaskManagedEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.helper.OperationLabelHelper;
import org.eclipse.papyrus.uml.tools.utils.ICustomAppearence;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Specific edit policy for label displaying stereotypes and their properties for edges representing
 * UML elements.
 */
public class OperationLabelEditPolicy extends AbstractMaskManagedEditPolicy {

	/**
	 * Creates a new PropertyLabelEditPolicy
	 */
	public OperationLabelEditPolicy() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addAdditionalListeners() {
		super.addAdditionalListeners();
		Operation operation = getUMLElement();
		// check host semantic element is not null
		if(operation == null) {
			return;
		}
		// adds a listener to the element itself, and to linked elements, like Type
		for(Parameter parameter : operation.getOwnedParameters()) {
			getDiagramEventBroker().addNotificationListener(parameter, this);
			// should also add this element as a listener of parameter type
			if(parameter.getType() != null) {
				getDiagramEventBroker().addNotificationListener(parameter.getType(), this);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getDefaultDisplayValue() {
		return ICustomAppearence.DEFAULT_UML_OPERATION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getMaskLabel(int value) {
		return OperationLabelHelper.getInstance().getMaskLabel(value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<String> getMaskLabels() {
		return OperationLabelHelper.getInstance().getMaskLabels();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<Integer, String> getMasks() {
		return OperationLabelHelper.getInstance().getMasks();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<Integer> getMaskValues() {
		return OperationLabelHelper.getInstance().getMaskValues();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPreferencePageID() {
		return "org.eclipse.papyrus.uml.diagram.clazz.custom.preferences.OperationPreferencePage";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Operation getUMLElement() {
		if(hostSemanticElement instanceof Operation) {
			return (Operation)hostSemanticElement;
		}
		return null;
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
		Operation operation = getUMLElement();
		if(object == null) {
			return;
		}
		if(object.equals(operation)) {
			notifyOperationChanged(operation, notification);
		} else if(isParameter(object)) {
			notifyParameterChanged(notification);
		} else if(isParameterType(object)) {
			notifyParameterTypeChanged(notification);
		}
		if(isMaskManagedAnnotation(object)) {
			refreshDisplay();
		}
		if(isRemovedMaskManagedLabelAnnotation(object, notification)) {
			refreshDisplay();
		}
	}

	/**
	 * Checks if the given object is one of the parameter type of the operation
	 *
	 * @param object
	 *        the object to test
	 * @return <code>true</code> if the object corresponds to the type of a parameter of the
	 *         operation
	 */
	protected boolean isParameterType(Object object) {
		if(!(object instanceof Type)) {
			return false;
		}
		for(Parameter parameter : getUMLElement().getOwnedParameters()) {
			if(object.equals(parameter.getType())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if the given object is one of the parameter of the operation
	 *
	 * @param object
	 *        the object to test
	 * @return <code>true</code> if the object is a parameter of the operation
	 */
	protected boolean isParameter(Object object) {
		if(!(object instanceof Parameter)) {
			return false;
		}
		return getUMLElement().getOwnedParameters().contains(object);
	}

	/**
	 * notifies that a parameter of the operation has changed.
	 *
	 * @param parameter
	 *        the {@link Parameter} that has changed
	 * @param notification
	 *        the notification send when the element has been changed
	 */
	protected void notifyParameterChanged(Notification notification) {
		switch(notification.getFeatureID(Parameter.class)) {
		case UMLPackage.PARAMETER__NAME:
		case UMLPackage.PARAMETER__DEFAULT_VALUE:
		case UMLPackage.PARAMETER__DIRECTION:
		case UMLPackage.PARAMETER__IS_STREAM:
		case UMLPackage.PARAMETER__IS_ORDERED:
		case UMLPackage.PARAMETER__LOWER:
		case UMLPackage.PARAMETER__UPPER:
		case UMLPackage.PARAMETER__LOWER_VALUE:
		case UMLPackage.PARAMETER__UPPER_VALUE:
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
	 * notifies that a parameter of the operation has changed.
	 *
	 * @param parameter
	 *        the {@link Parameter} that has changed
	 * @param notification
	 *        the notification send when the element has been changed
	 */
	protected void notifyParameterTypeChanged(Notification notification) {
		// should be type.class, but seems to be a bug if this is put instead.
		switch(notification.getFeatureID(notification.getNotifier().getClass())) {
		case UMLPackage.TYPE__NAME:
		case UMLPackage.TYPE__TEMPLATE_PARAMETER:
		case UMLPackage.TYPE__VISIBILITY:
			refreshDisplay();
			break;
		default:
			// does nothing in other cases
			break;
		}
	}

	/**
	 * notifies that the the property has changed.
	 *
	 * @param operation
	 *        the operation that has changed
	 * @param notification
	 *        the notification send when the element has been changed
	 */
	protected void notifyOperationChanged(Operation operation, Notification notification) {
		switch(notification.getFeatureID(Operation.class)) {
		case UMLPackage.OPERATION__NAME:
		case UMLPackage.OPERATION__VISIBILITY:
		case UMLPackage.OPERATION__IS_UNIQUE:
		case UMLPackage.OPERATION__REDEFINED_OPERATION:
		case UMLPackage.OPERATION__IS_ORDERED:
		case UMLPackage.OPERATION__LOWER:
		case UMLPackage.OPERATION__UPPER:
		case UMLPackage.OPERATION__IS_STATIC:
			refreshDisplay();
			break;
		case UMLPackage.OPERATION__OWNED_PARAMETER:
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
	 * Refreshes the display of the edit part
	 */
	@Override
	public void refreshDisplay() {
		// calls the helper for this edit Part
		OperationLabelHelper.getInstance().refreshEditPartDisplay((GraphicalEditPart)getHost());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void removeAdditionalListeners() {
		super.removeAdditionalListeners();
		Operation operation = getUMLElement();
		// check host semantic element is not null
		if(operation == null) {
			return;
		}
		for(Parameter parameter : operation.getOwnedParameters()) {
			getDiagramEventBroker().removeNotificationListener(parameter, this);
			// remove parameter type listener
			if(parameter.getType() != null) {
				getDiagramEventBroker().removeNotificationListener(parameter.getType(), this);
			}
		}
	}
}
