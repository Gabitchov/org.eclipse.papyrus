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
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.custom.policies;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.core.listenerservice.IPapyrusListener;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Specific edit policy for label displaying stereotypes and their properties for edges representing UML elements.
 */
public class PropertyLabelEditPolicy extends GraphicalEditPolicy implements NotificationListener, IPapyrusListener {

	public static final String PROPERTY_LABEL_DISPLAY_POLICY = "PropertyLabelDisplayEditPolicy";

	/**
	 * Creates a new PropertyLabelEditPolicy
	 */
	public PropertyLabelEditPolicy() {
		super();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void activate() {
		// retrieve the view and the element managed by the edit part
		View view = getView();
		if (view == null) {
			return;
		}
		Property property = getUMLElement();

		// adds a listener on the view and the element controlled by the editpart
		getDiagramEventBroker().addNotificationListener(view, this);
		getDiagramEventBroker().addNotificationListener(property, this);

		// adds a listener to the element itself, and to linked elements, like Type
		if (property.getType() != null) {
			getDiagramEventBroker().addNotificationListener(property.getType(), this);
		}

		refreshDisplay();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void deactivate() {
		// retrieve the view and the element managed by the edit part
		View view = getView();
		if (view == null) {
			return;
		}
		Property property = getUMLElement();

		// remove notification on element and view
		getDiagramEventBroker().removeNotificationListener(view, this);

		if (property == null) {
			return;
		}
		getDiagramEventBroker().removeNotificationListener(property, this);

		if (property.getType() != null) {
			getDiagramEventBroker().removeNotificationListener(property.getType(), this);
		}

	}

	/**
	 * Gets the diagram event broker from the editing domain.
	 * 
	 * @return the diagram event broker
	 */
	protected DiagramEventBroker getDiagramEventBroker() {
		TransactionalEditingDomain theEditingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		if (theEditingDomain != null) {
			return DiagramEventBroker.getInstance(theEditingDomain);
		}
		return null;
	}

	/**
	 * Returns the {@link Property} managed by this edit part.
	 * 
	 * @return
	 */
	public Property getUMLElement() {
		return (Property) getView().getElement();
	}

	/**
	 * Returns the view controlled by the host edit part
	 * 
	 * @return the view controlled by the host edit part
	 */
	protected View getView() {
		return (View) getHost().getModel();
	}

	/**
	 * 
	 * {@inheritedDoc}
	 */
	public void notifyChanged(Notification notification) {
		// change the label of the figure managed by the host edit part (managed by the parent edit part in general...)
		// it must be changed only if:
		// - the annotation corresponding to the display of the stereotype changes
		// - the stereotype application list has changed
		Object object = notification.getNotifier();
		Property property = getUMLElement();

		if (object == null) {
			return;
		}

		if (object.equals(property)) {
			notifyPropertyChanged(property, notification);
		} else if (object.equals(property.getType())) {
			notifyPropertyTypeChanged(property.getType(), notification);
		}

	}

	/**
	 * notifies that the the property has changed.
	 * 
	 * @param property
	 *            the property that has changed
	 * @param notification
	 *            the notification send when the element has been changed
	 */
	protected void notifyPropertyChanged(Property property, Notification notification) {
		switch (notification.getFeatureID(Property.class)) {
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

			switch (notification.getEventType()) {
			// if it is added => adds listener to the type element
			case Notification.ADD:
			case Notification.ADD_MANY: // should never happen
				getDiagramEventBroker().addNotificationListener((EObject) notification.getNewValue(), this);
				refreshDisplay();
				// if it is removed => removes listener from the type element
				break;

			case Notification.REMOVE:
			case Notification.REMOVE_MANY: // should never happen
				getDiagramEventBroker().removeNotificationListener((EObject) notification.getOldValue(), this);
				refreshDisplay();
				break;
			// if it is set, remove the old one and adds the new one. this is the method use when the type is set or removed...
			case Notification.SET:
				if (notification.getNewValue() != null) {
					getDiagramEventBroker().addNotificationListener((EObject) notification.getNewValue(), this);
				}
				if (notification.getOldValue() != null) {
					getDiagramEventBroker().removeNotificationListener((EObject) notification.getOldValue(), this);
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
	 *            the type of the property that has changed
	 * @param notification
	 *            the notification send when the element has been changed
	 */
	protected void notifyPropertyTypeChanged(Type type, Notification notification) {
		switch (notification.getFeatureID(Property.class)) {
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
	public void refreshDisplay() {
		// calls the helper for this edit Part
		PropertyLabelHelper.refreshEditPartDisplay((GraphicalEditPart) getHost());
	}

}
