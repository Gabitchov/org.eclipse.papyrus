package org.eclipse.papyrus.uml.diagram.composite.custom.edit.policies;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.papyrus.uml.diagram.common.helper.PortLabelHelper;
import org.eclipse.papyrus.uml.diagram.common.helper.PropertyLabelHelper;
import org.eclipse.papyrus.uml.diagram.composite.custom.preferences.PropertyPreferencePage;
import org.eclipse.papyrus.uml.tools.utils.ICustomAppearence;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;


public class PortLabelEditPolicy extends PropertyLabelEditPolicy {
	/**
	 * {@inheritDoc}
	 */
	public int getDefaultDisplayValue() {
		return ICustomAppearence.DEFAULT_UML_PORT;
	}
	/**
	 * {@inheritDoc}
	 */
	public String getMaskLabel(int value) {
		return PortLabelHelper.getInstance().getMaskLabel(value);
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<String> getMaskLabels() {
		return PortLabelHelper.getInstance().getMaskLabels();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Map<Integer, String> getMasks() {
		return PortLabelHelper.getInstance().getMasks();
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<Integer> getMaskValues() {
		return PortLabelHelper.getInstance().getMaskValues();
	}

	public String getPreferencePageID() {
		return PropertyPreferencePage.ID;
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
		case UMLPackage.PORT__IS_CONJUGATED:
		case UMLPackage.PROPERTY__VISIBILITY:
		case UMLPackage.PROPERTY__IS_DERIVED:
		case UMLPackage.PROPERTY__DEFAULT_VALUE:
		case UMLPackage.PROPERTY__SUBSETTED_PROPERTY:
		case UMLPackage.PROPERTY__REDEFINED_PROPERTY:
		case UMLPackage.PROPERTY__IS_ORDERED:
		case UMLPackage.PROPERTY__IS_UNIQUE:
		case UMLPackage.PROPERTY__IS_READ_ONLY:
			refreshDisplay();
			break;
		case UMLPackage.PROPERTY__TYPE:
		case UMLPackage.PROPERTY__LOWER:
		case UMLPackage.PROPERTY__LOWER_VALUE:
		case UMLPackage.PROPERTY__UPPER:
		case UMLPackage.PROPERTY__UPPER_VALUE:

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
				if(notification.getOldValue() != null) {
					getDiagramEventBroker().removeNotificationListener((EObject)notification.getOldValue(), this);
				}
				if(notification.getNewValue() != null) {
					getDiagramEventBroker().addNotificationListener((EObject)notification.getNewValue(), this);
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
		PortLabelHelper.getInstance().refreshEditPartDisplay((GraphicalEditPart)getHost());
	}

}
