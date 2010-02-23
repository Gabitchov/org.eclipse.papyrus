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
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - customization for CollaborationUse
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.composite.custom.edit.policies;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.common.editpolicies.AbstractMaskManagedEditPolicy;
import org.eclipse.papyrus.diagram.composite.custom.helper.CollaborationUseLabelHelper;
import org.eclipse.papyrus.diagram.composite.custom.preferences.CollaborationUsePreferencePage;
import org.eclipse.papyrus.diagram.composite.custom.preferences.IPapyrusCollaborationUsePreferencesConstant;
import org.eclipse.papyrus.diagram.composite.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.umlutils.ICustomAppearence;
import org.eclipse.papyrus.umlutils.ui.VisualInformationPapyrusConstant;
import org.eclipse.papyrus.umlutils.ui.command.AddMaskManagedLabelDisplayCommand;
import org.eclipse.papyrus.umlutils.ui.command.RemoveEAnnotationCommand;
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
	public void addAdditionalListeners() {
		// adds a listener to the element itself, and to linked elements, like Type
		if(getUMLElement().getType() != null) {
			getDiagramEventBroker().addNotificationListener(getUMLElement().getType(), this);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public int getCurrentDisplayValue() {
		EAnnotation propertyDisplay = ((View)getHost().getModel()).getEAnnotation(VisualInformationPapyrusConstant.CUSTOM_APPEARENCE_ANNOTATION);
		int displayValue = getDefaultDisplayValue();
		if(propertyDisplay != null) {
			displayValue = Integer.parseInt(propertyDisplay.getDetails().get(VisualInformationPapyrusConstant.CUSTOM_APPEARANCE_MASK_VALUE));
		} else {
			// no specific information => look in preferences
			IPreferenceStore store = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
			int displayValueTemp = store.getInt(IPapyrusCollaborationUsePreferencesConstant.LABEL_DISPLAY_PREFERENCE);
			if(displayValueTemp != 0) {
				displayValue = displayValueTemp;
			}
		}
		return displayValue;
	}

	/**
	 * {@inheritDoc}
	 */
	public int getDefaultDisplayValue() {
		return ICustomAppearence.DEFAULT_UML_PROPERTY;
	}

	/**
	 * Gets the diagram event broker from the editing domain.
	 * 
	 * @return the diagram event broker
	 */
	protected DiagramEventBroker getDiagramEventBroker() {
		TransactionalEditingDomain theEditingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		if(theEditingDomain != null) {
			return DiagramEventBroker.getInstance(theEditingDomain);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getMaskLabel(int value) {
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
	public Map<Integer, String> getMasks() {
		return CollaborationUseLabelHelper.getInstance().getMasks();
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<Integer> getMaskValues() {
		return CollaborationUseLabelHelper.getInstance().getMaskValues();
	}

	public String getPreferencePageID() {
		return CollaborationUsePreferencePage.ID;
	}

	/**
	 * Returns the {@link Property} managed by this edit part.
	 * 
	 * @return
	 */
	public CollaborationUse getUMLElement() {
		return (CollaborationUse)getView().getElement();
	}

	/**
	 * Returns the view controlled by the host edit part
	 * 
	 * @return the view controlled by the host edit part
	 */
	protected View getView() {
		return (View)getHost().getModel();
	}

	/**
	 * Returns <code>true</code> if the specified object is the annotation in charge of the mask
	 * managed label.
	 * 
	 * @param object
	 *        the object to be checked
	 * @return <code>true</code> if the object is an {@link EAnnotation} and its source is the
	 *         correct one.
	 */
	protected boolean isMaskManagedAnnotation(Object object) {
		// check the notifier is an annotation
		if((object instanceof EAnnotation)) {

			// notifier is the eAnnotation. Check this is the annotation in charge of the property
			// label display
			if(VisualInformationPapyrusConstant.CUSTOM_APPEARENCE_ANNOTATION.equals(((EAnnotation)object).getSource())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns <code>true</code> if the the annotation in charge of the mask managed label is
	 * removed from the given object which should be a View.
	 * 
	 * @param object
	 *        the object to be checked
	 * @param notification
	 *        the notification passed to the policy (which is a listener)
	 * @return <code>true</code> if the object is an {@link EAnnotation} and its source is the
	 *         correct one.
	 */
	protected boolean isRemovedMaskManagedLabelAnnotation(Object object, Notification notification) {
		// object is a model element, that means it has EAnnotations
		if(object instanceof EModelElement) {

			// something was removed.
			if(notification.getEventType() == Notification.REMOVE) {
				Object oldValue = notification.getOldValue();

				// this is an annotation which is returned
				if(oldValue instanceof EAnnotation) {
					// returns true if the annotation has the correct source
					return VisualInformationPapyrusConstant.CUSTOM_APPEARENCE_ANNOTATION.equals(((EAnnotation)oldValue).getSource());
				}
			}
		}
		return false;
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
		CollaborationUse collaborationUse = getUMLElement();

		if(object == null) {
			return;
		}

		if(object.equals(collaborationUse)) {
			notifyCollaborationUseChanged(collaborationUse, notification);
		} else if(object.equals(collaborationUse.getType())) {
			notifyCollaborationUseTypeChanged(collaborationUse.getType(), notification);
		}

		if(isMaskManagedAnnotation(object)) {
			refreshDisplay();
		}

		if(isRemovedMaskManagedLabelAnnotation(object, notification)) {
			refreshDisplay();
		}

	}

	/**
	 * notifies that the CollaborationUse has changed.
	 * 
	 * @param collaborationUse
	 *        the CollaborationUse that has changed
	 * @param notification
	 *        the notification send when the element has been changed
	 */
	protected void notifyCollaborationUseChanged(CollaborationUse collaborationUse, Notification notification) {
		switch(notification.getFeatureID(CollaborationUse.class)) {
		case UMLPackage.COLLABORATION_USE__NAME:
		case UMLPackage.COLLABORATION_USE__VISIBILITY:
			refreshDisplay();
			break;
		case UMLPackage.COLLABORATION_USE__TYPE:

			switch(notification.getEventType()) {
			// if it is added => adds listener to the type element
			case Notification.ADD:
			case Notification.ADD_MANY: // should never happen
				getDiagramEventBroker().addNotificationListener((EObject)notification.getNewValue(), this);
				refreshDisplay();
				// if it is removed => removes listener from the type element
				break;

			case Notification.REMOVE:
			case Notification.REMOVE_MANY: // should never happen
				getDiagramEventBroker().removeNotificationListener((EObject)notification.getOldValue(), this);
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
	 * notifies that the type of the CollaborationUse has changed.
	 * 
	 * @param type
	 *        the type of the CollaborationUse that has changed
	 * @param notification
	 *        the notification send when the element has been changed
	 */
	protected void notifyCollaborationUseTypeChanged(Collaboration type, Notification notification) {
		switch(notification.getFeatureID(CollaborationUse.class)) {
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
		CollaborationUseLabelHelper.getInstance().refreshEditPartDisplay((GraphicalEditPart)getHost());
	}

	/**
	 * 
	 */
	protected void removeAdditionalListeners() {
		if(getUMLElement().getType() != null) {
			getDiagramEventBroker().removeNotificationListener(getUMLElement().getType(), this);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void setDefaultDisplayValue() {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		if(editingDomain != null) {
			editingDomain.getCommandStack().execute(new RemoveEAnnotationCommand(editingDomain, (EModelElement)getHost().getModel(), VisualInformationPapyrusConstant.CUSTOM_APPEARENCE_ANNOTATION));
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public void updateDisplayValue(int newValue) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		if(editingDomain != null) {
			editingDomain.getCommandStack().execute(new AddMaskManagedLabelDisplayCommand(editingDomain, (EModelElement)getHost().getModel(), newValue));
		}
	}

}
