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
 *  Vincent Lorenzo (CEA-LIST) vincent.lorenzo@cea.fr
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.runtime.modelhandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.views.properties.runtime.controller.EMFPropertyEditorController;
import org.eclipse.papyrus.views.properties.runtime.modelhandler.emf.IEMFModelHandler;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IBoundedValuesPropertyEditorDescriptor;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.papyrus.uml.properties.runtime.Activator;
import org.eclipse.papyrus.uml.properties.runtime.Messages;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * Model Handler for the Owner of Association ends
 */
public class AssociationEndOwnerModelHandler implements IEMFModelHandler {

	/** list of available values */
	private final List<String> availableValues;

	/** id of this model handler */
	public final static String ID = "AssociationEndOwner"; //$NON-NLS-1$

	/**
	 * Creates a new AssociationEndOwnerModelHandler.
	 */
	public AssociationEndOwnerModelHandler() {
		super();
		this.availableValues = Arrays.asList(Messages.AssociationEndOwnerModelHandler_ComboValue_Association, Messages.AssociationEndOwnerModelHandler_ComboValue_Class);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setValueInModel(EObject objectToEdit, Object newValue) {
		if(!(newValue instanceof String)) {
			Activator.log.warn("the new value for the association end owner handler was no a String"); //$NON-NLS-1$
			return;
		}

		if(!(objectToEdit instanceof Property)) {
			Activator.log.warn("the object to edit is not a Property"); //$NON-NLS-1$
			return;
		}

		Property property = (Property)objectToEdit;
		Association association = property.getAssociation();
		if(association == null) {
			Activator.log.warn("the property is not a member end of an association"); //$NON-NLS-1$
			return;
		}
		String value = (String)newValue;

		Type owner = null;
		if(Messages.AssociationEndOwnerModelHandler_ComboValue_Class.equals(value)) {
			// it already belongs to the right component, does not change...
			if(!(property.getOwner() instanceof Association)) {
				return;
			} else {
				//look for the owner of the property to Set
				List<Type> ownerList = association.getEndTypes();
				if(ownerList.get(0).equals(property.getType()) && ownerList.size() > 1) {
					owner = ownerList.get(1);
				} else {
					owner = ownerList.get(0);
				}
			}
			// this is a classifier , construct and run the command
			EStructuralFeature feature = UMLPackage.eINSTANCE.getStructuredClassifier_OwnedAttribute();
			if(owner instanceof org.eclipse.uml2.uml.Class) {
				List<Property> attributeList = new ArrayList<Property>();
				attributeList.addAll(((org.eclipse.uml2.uml.Class)owner).getAttributes());
				attributeList.add(property);
				((org.eclipse.uml2.uml.Class)owner).eSet(feature, attributeList);
				return;
			}
			Activator.log.error("The owner was not a class: " + owner, null); //$NON-NLS-1$
			return;
		} else {
			EStructuralFeature feature = UMLPackage.eINSTANCE.getAssociation_OwnedEnd();
			List<Property> attributeList = new ArrayList<Property>();
			attributeList.addAll(association.getOwnedEnds());
			attributeList.add(property);
			association.eSet(feature, attributeList);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public void completeEditorDescriptor(IPropertyEditorDescriptor descriptor, List<? extends EObject> objectToEdit) {
		if(descriptor instanceof IBoundedValuesPropertyEditorDescriptor) {
			((IBoundedValuesPropertyEditorDescriptor)descriptor).setAvailableValues(getAvailableValues(null));
		} else {
			Activator.log.warn(descriptor + "could not be completed."); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getValueToEdit(EObject objectToEdit) {
		if(!(objectToEdit instanceof Property)) {
			Activator.log.warn("the object to edit is not a Property"); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

		Property property = (Property)objectToEdit;
		Association association = property.getAssociation();
		if(association == null) {
			Activator.log.warn("the property is not a member end of an association"); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

		if(association.equals(property.getOwner())) {
			return Messages.AssociationEndOwnerModelHandler_ComboValue_Association;
		}
		return Messages.AssociationEndOwnerModelHandler_ComboValue_Class;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isChangeable(List<? extends EObject> objectsToEdit) {
		// always true for this implementation
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getId() {
		return ID;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return "AssociationEndOwnerHandler"; //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getImage() {
		return Activator.getImage("/icons/ModelHandler.gif"); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 */
	public AssociationEndOwnerHandlerState createState(boolean readOnly) {
		return new AssociationEndOwnerHandlerState(this, readOnly);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<String> getAvailableValues(EObject objects) {
		return availableValues;
	}

	/**
	 * {@inheritDoc}
	 */
	public void handleNotifyChange(Notification notification, List<? extends EObject> objects, EMFPropertyEditorController adapter) {
		Object notificationFeature = notification.getFeature();
		if(!(UMLPackage.eINSTANCE.getProperty_OwningAssociation().equals(notificationFeature))) {
			return;
		}


		switch(notification.getEventType()) {
		case Notification.SET:
		case Notification.UNSET:
			adapter.refreshDisplay();
			break;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void addListenersToModel(List<? extends EObject> objectsToEdit, EMFPropertyEditorController controller) {
		for(EObject object : objectsToEdit) {
			object.eAdapters().add(controller);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeListenersFromModel(List<? extends EObject> objectsToEdit, EMFPropertyEditorController controller) {
		for(EObject object : objectsToEdit) {
			object.eAdapters().remove(controller);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<IUndoableOperation> getCreateValueOperations(List<? extends EObject> objectsToEdit, Composite parent) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean canCreateValueOperations(List<? extends EObject> objectsToEdit) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public IUndoableOperation getDeleteValueOperation(List<? extends EObject> objectsToEdit, Composite parent, List<Integer> indexes) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean canCreateDeleteValueOperation(List<? extends EObject> objectsToEdit) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public IUndoableOperation getEditValueOperation(List<? extends EObject> objectsToEdit, int index, Composite parent, Object value) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean canCreateEditValueOperation(List<? extends EObject> objectsToEdit) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public IUndoableOperation getMoveValueOperation(List<? extends EObject> objectsToEdit, List<Integer> indexes, Composite parent, int delta) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean canCreateMoveValueOperation(List<? extends EObject> objectsToEdit, List<Integer> indexes, Composite parent, int delta) {
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.views.properties.runtime.modelhandler.emf.IEMFModelHandler#getSetRequest(org.eclipse.emf.transaction.TransactionalEditingDomain,
	 *      org.eclipse.emf.ecore.EObject, java.lang.Object)
	 * 
	 * @param domain
	 * @param objectToEdit
	 * @param newValue
	 * @return
	 */
	public SetRequest[] getSetRequest(TransactionalEditingDomain domain, EObject objectToEdit, Object newValue) {
		if(!(newValue instanceof String)) {
			Activator.log.warn("the new value for the association end owner handler was no a String"); //$NON-NLS-1$
			return null;
		}

		if(!(objectToEdit instanceof Property)) {
			Activator.log.warn("the object to edit is not a Property"); //$NON-NLS-1$
			return null;
		}

		Property property = (Property)objectToEdit;
		Association association = property.getAssociation();
		if(association == null) {
			Activator.log.warn("the property is not a member end of an association"); //$NON-NLS-1$
			return null;
		}
		String value = (String)newValue;

		Type owner = null;
		if(Messages.AssociationEndOwnerModelHandler_ComboValue_Class.equals(value)) {
			// it already belongs to the right component, does not change...
			if(!(property.getOwner() instanceof Association)) {
				return null;
			} else {
				//look for the owner of the property to Set
				List<Type> ownerList = association.getEndTypes();
				if(ownerList.get(0).equals(property.getType()) && ownerList.size() > 1) {
					owner = ownerList.get(1);
				} else {
					owner = ownerList.get(0);
				}
			}
			// this is a classifier , construct and run the command
			EStructuralFeature feature = UMLPackage.eINSTANCE.getStructuredClassifier_OwnedAttribute();
			if(owner instanceof org.eclipse.uml2.uml.Class) {
				List<Property> attributeList = new ArrayList<Property>();
				attributeList.addAll(((org.eclipse.uml2.uml.Class)owner).getAttributes());
				attributeList.add(property);
				return new SetRequest[]{ new SetRequest(domain, owner, feature, attributeList) };
			}
			Activator.log.error("The owner was not a class: " + owner, null); //$NON-NLS-1$
			return null;
		} else {
			EStructuralFeature feature = UMLPackage.eINSTANCE.getAssociation_OwnedEnd();
			List<Property> attributeList = new ArrayList<Property>();
			attributeList.addAll(association.getOwnedEnds());
			attributeList.add(property);
			return new SetRequest[]{ new SetRequest(domain, association, feature, attributeList) };
		}
	}
}
