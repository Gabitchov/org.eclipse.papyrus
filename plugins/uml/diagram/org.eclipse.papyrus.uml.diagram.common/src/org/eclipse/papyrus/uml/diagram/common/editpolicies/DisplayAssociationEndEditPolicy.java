/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Nizar GUEDIDI (CEA LIST) - Update getUMLElement()
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.uml.diagram.common.helper.PropertyLabelHelper;
import org.eclipse.papyrus.uml.tools.utils.ICustomAppearance;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * I is used to display the label of an association branch
 */
public class DisplayAssociationEndEditPolicy extends AbstractMaskManagedEditPolicy {

	/** label helper for the property */
	protected PropertyLabelHelper propertyLabelHelper;

	/**
	 * Creates a new PropertyLabelEditPolicy
	 */
	public DisplayAssociationEndEditPolicy() {
		super();
	}

	@Override
	protected Element initSemanticElement() {
		return propertyLabelHelper.getUMLElement(((GraphicalEditPart)getHost()));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addAdditionalListeners() {
		// adds a listener to the element itself, and to linked elements, like Type
		if(getUMLElement().getType() != null) {
			getDiagramEventBroker().addNotificationListener(getUMLElement().getType(), this);
		}
		getDiagramEventBroker().addNotificationListener(getUMLElement().getUpperValue(), this);
		getDiagramEventBroker().addNotificationListener(getUMLElement().getLowerValue(), this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Collection<String> getDefaultDisplayValue() {
		return Arrays.asList(ICustomAppearance.DISP_VISIBILITY, ICustomAppearance.DISP_DERIVE, ICustomAppearance.DISP_NAME);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, String> getMasks() {
		return propertyLabelHelper.getMasks();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Property getUMLElement() {
		EObject element = super.getUMLElement();
		if(element instanceof Property) {
			return (Property)element;
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
		Property property = getUMLElement();
		if(property == null) {
			return;
		}
		//in order to find the role to display we need to now target of the edge, so it is important to have a notification about the change of the target
		if((notification.getFeature().equals(NotationPackage.eINSTANCE.getEdge_Target())) || (notification.getFeature().equals(NotationPackage.eINSTANCE.getEdge_Source()))) {
			refreshDisplay();
		}
		if(object == null) {
			return;
		}
		if(notification.getFeature().equals(UMLPackage.eINSTANCE.getLiteralInteger_Value())) {
			refreshDisplay();
		} else if(notification.getFeature().equals(UMLPackage.eINSTANCE.getLiteralUnlimitedNatural_Value())) {
			refreshDisplay();
		}
		if(object.equals(property)) {
			notifyPropertyChanged(property, notification);
		} else if(object.equals(property.getType())) {
			notifyPropertyTypeChanged(property.getType(), notification);
		}
		if(isMaskManagedAnnotation(object)) {
			refreshDisplay();
		}
		if(isRemovedMaskManagedLabelAnnotation(object, notification)) {
			refreshDisplay();
		}
	}

	/**
	 * notifies that the the property has changed.
	 *
	 * @param property
	 *        the property that has changed
	 * @param notification
	 *        the notification send when the element has been changed
	 */
	protected void notifyPropertyChanged(Property property, Notification notification) {
		switch(notification.getFeatureID(Property.class)) {
		case UMLPackage.PROPERTY__NAME:
		case UMLPackage.PROPERTY__VISIBILITY:
		case UMLPackage.PROPERTY__IS_DERIVED:
		case UMLPackage.PROPERTY__LOWER:
		case UMLPackage.PROPERTY__LOWER_VALUE:
		case UMLPackage.PROPERTY__UPPER:
		case UMLPackage.PROPERTY__UPPER_VALUE:
		case UMLPackage.PROPERTY__DEFAULT_VALUE:
		case UMLPackage.PROPERTY__SUBSETTED_PROPERTY:
		case UMLPackage.PROPERTY__REDEFINED_PROPERTY:
		case UMLPackage.PROPERTY__IS_ORDERED:
		case UMLPackage.PROPERTY__IS_UNIQUE:
		case UMLPackage.PROPERTY__IS_READ_ONLY:
			refreshDisplay();
			break;
		case UMLPackage.PROPERTY__TYPE:
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
	 * notifies that the type of the property has changed.
	 *
	 * @param type
	 *        the type of the property that has changed
	 * @param notification
	 *        the notification send when the element has been changed
	 */
	protected void notifyPropertyTypeChanged(Type type, Notification notification) {
		switch(notification.getFeatureID(Property.class)) {
		case UMLPackage.TYPE__NAME:
			refreshDisplay(); // type name has changed => refresh the property display
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
		propertyLabelHelper.refreshEditPartDisplay((GraphicalEditPart)getHost());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void removeAdditionalListeners() {
		super.removeAdditionalListeners();
		if(getUMLElement() != null && getUMLElement().getType() != null) {
			getDiagramEventBroker().removeNotificationListener(getUMLElement().getType(), this);
		}
	}
	//	/**
	//	 * {@inheritDoc}
	//	 */
	//	public void setDefaultDisplayValue() {
	//		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
	//		if(editingDomain != null) {
	//			editingDomain.getCommandStack().execute(new RemoveEAnnotationCommand(editingDomain, (EModelElement)getHost().getModel(), VisualInformationPapyrusConstants.CUSTOM_APPEARENCE_ANNOTATION));
	//		}
	//
	//	}
	//
	//	/**
	//	 * {@inheritDoc}
	//	 */
	//	public void updateDisplayValue(int newValue) {
	//		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
	//		if(editingDomain != null) {
	//			editingDomain.getCommandStack().execute(new AddMaskManagedLabelDisplayCommand(editingDomain, (EModelElement)getHost().getModel(), newValue));
	//		}
	//	}
}
