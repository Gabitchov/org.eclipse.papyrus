/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
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
import org.eclipse.papyrus.uml.diagram.composite.custom.helper.CollaborationUseLabelHelper;
import org.eclipse.papyrus.uml.tools.utils.ICustomAppearance;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Specific edit policy for label displaying stereotypes and their properties for edges representing
 * UML elements.
 */
public class CollaborationUseLabelEditPolicy extends AbstractMaskManagedEditPolicy {
	/**
	 * Creates a new CollaborationUseLabelEditPolicy
	 */
	public CollaborationUseLabelEditPolicy() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addAdditionalListeners() {
		super.addAdditionalListeners();
		CollaborationUse collaborationUse = getUMLElement();
		if (collaborationUse == null) {
			return;
		}
		// adds a listener to the element itself, and to linked elements, like Type
		if (collaborationUse.getType() != null) {
			getDiagramEventBroker().addNotificationListener(getUMLElement().getType(), this);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<String> getDefaultDisplayValue() {
		return ICustomAppearance.DEFAULT_UML_PROPERTY;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getMaskLabel(String value) {
		return CollaborationUseLabelHelper.getInstance().getMaskLabel(value);
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<String> getMaskLabels() {
		return CollaborationUseLabelHelper.getInstance().getMaskLabels();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, String> getMasks() {
		return CollaborationUseLabelHelper.getInstance().getMasks();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CollaborationUse getUMLElement() {
		return (CollaborationUse) super.getUMLElement();
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
		CollaborationUse collaborationUse = (CollaborationUse) hostSemanticElement;
		if ((object == null) || (hostSemanticElement == null)) {
			return;
		}
		if (object.equals(collaborationUse)) {
			notifyCollaborationUseChanged(collaborationUse, notification);
		} else if (object.equals(collaborationUse.getType())) {
			notifyCollaborationUseTypeChanged(collaborationUse.getType(), notification);
		}
		if (isMaskManagedAnnotation(object)) {
			refreshDisplay();
		}
		if (isRemovedMaskManagedLabelAnnotation(object, notification)) {
			refreshDisplay();
		}
	}

	/**
	 * notifies that the CollaborationUse has changed.
	 * 
	 * @param collaborationUse
	 *            the CollaborationUse that has changed
	 * @param notification
	 *            the notification send when the element has been changed
	 */
	protected void notifyCollaborationUseChanged(CollaborationUse collaborationUse, Notification notification) {
		switch (notification.getFeatureID(CollaborationUse.class)) {
		case UMLPackage.COLLABORATION_USE__NAME:
		case UMLPackage.COLLABORATION_USE__VISIBILITY:
			refreshDisplay();
			break;
		case UMLPackage.COLLABORATION_USE__TYPE:
			switch (notification.getEventType()) {
			// if it is added => adds listener to the type element
			case Notification.ADD:
				getDiagramEventBroker().addNotificationListener((EObject) notification.getNewValue(), this);
				refreshDisplay();
				// if it is removed => removes listener from the type element
				break;
			case Notification.ADD_MANY: // should never happen
				if (notification.getNewValue() instanceof List<?>) {
					List<?> addedElements = (List<?>) notification.getNewValue();
					for (Object addedElement : addedElements) {
						if (addedElement instanceof EObject) {
							getDiagramEventBroker().addNotificationListener((EObject) addedElement, this);
						}
					}
				}
				refreshDisplay();
				break;
			case Notification.REMOVE:
				getDiagramEventBroker().removeNotificationListener((EObject) notification.getOldValue(), this);
				refreshDisplay();
				break;
			case Notification.REMOVE_MANY: // should never happen
				if (notification.getOldValue() instanceof List<?>) {
					List<?> removedElements = (List<?>) notification.getOldValue();
					for (Object removedElement : removedElements) {
						if (removedElement instanceof EObject) {
							getDiagramEventBroker().removeNotificationListener((EObject) removedElement, this);
						}
					}
				}
				refreshDisplay();
				break;
			// if it is set, remove the old one and adds the new one. this is the method use when
			// the type is set or removed...
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
	 * notifies that the type of the CollaborationUse has changed.
	 * 
	 * @param type
	 *            the type of the CollaborationUse that has changed
	 * @param notification
	 *            the notification send when the element has been changed
	 */
	protected void notifyCollaborationUseTypeChanged(Collaboration type, Notification notification) {
		switch (notification.getFeatureID(CollaborationUse.class)) {
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
		CollaborationUseLabelHelper.getInstance().refreshEditPartDisplay((GraphicalEditPart) getHost());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void removeAdditionalListeners() {
		super.removeAdditionalListeners();
		CollaborationUse collaborationUse = getUMLElement();
		if (collaborationUse == null) {
			return;
		}
		if (collaborationUse.getType() != null) {
			getDiagramEventBroker().removeNotificationListener(collaborationUse.getType(), this);
		}
	}
}
