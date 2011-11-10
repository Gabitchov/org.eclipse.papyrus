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
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * Model Handler for the navigation of Association ends
 */
public class AssociationEndNavigationModelHandler implements IEMFModelHandler {

	/** list of available values */
	private final List<String> availableValues;

	/** id of this model handler */
	public final static String ID = "AssociationEndNavigation"; //$NON-NLS-1$

	/**
	 * Creates a new AssociationEndOwnerModelHandler.
	 */
	public AssociationEndNavigationModelHandler() {
		super();
		this.availableValues = Arrays.asList("true", "false"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * {@inheritDoc}
	 */
	public void setValueInModel(EObject objectToEdit, Object newValue) {
		if(!(objectToEdit instanceof Property)) {
			Activator.log.warn("the object to edit is not a Property"); //$NON-NLS-1$
			return;
		}

		boolean isNavigable = Boolean.parseBoolean((String)newValue);

		Property property = (Property)objectToEdit;
		Association association = property.getAssociation();
		if(association == null) {
			Activator.log.warn("the property is not a member end of an association"); //$NON-NLS-1$
			return;
		}

		EStructuralFeature feature = UMLPackage.eINSTANCE.getAssociation_NavigableOwnedEnd();
		List<Property> attributeList = new ArrayList<Property>();
		attributeList.addAll(association.getNavigableOwnedEnds());
		if(isNavigable) {
			attributeList.add(property);
		} else {
			attributeList.remove(property);
		}
		association.eSet(feature, attributeList);
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
		if(association.getNavigableOwnedEnds().contains(property)) {
			return "true"; //$NON-NLS-1$
		}
		return "false"; //$NON-NLS-1$

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
		return "AssociationEndNavigationHandler"; //$NON-NLS-1$
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
	public AssociationEndNavigationHandlerState createState(boolean readOnly) {
		return new AssociationEndNavigationHandlerState(this, readOnly);
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
		// nothing specific here
		// should perhaps filter a bit more here, but seems to be sufficient here.
		Object notificationFeature = notification.getFeature();
		if(!(UMLPackage.eINSTANCE.getAssociation_NavigableOwnedEnd().equals(notificationFeature))) {
			return;
		}

		switch(notification.getEventType()) {
		case Notification.ADD:
		case Notification.ADD_MANY:
		case Notification.REMOVE:
		case Notification.REMOVE_MANY:
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

			// add also to the association owner
			// remove also the association
			if(object instanceof Property) {
				Association association = ((Property)object).getAssociation();
				if(association != null) {
					association.eAdapters().add(controller);
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeListenersFromModel(List<? extends EObject> objectsToEdit, EMFPropertyEditorController controller) {
		for(EObject object : objectsToEdit) {
			object.eAdapters().remove(controller);

			// remove also the association
			if(object instanceof Property) {
				Association association = ((Property)object).getAssociation();
				if(association != null) {
					association.eAdapters().remove(controller);
				}
			}
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
		if(!(objectToEdit instanceof Property)) {
			Activator.log.warn("the object to edit is not a Property"); //$NON-NLS-1$
			return null;
		}

		boolean isNavigable = Boolean.parseBoolean((String)newValue);

		Property property = (Property)objectToEdit;
		Association association = property.getAssociation();
		if(association == null) {
			Activator.log.warn("the property is not a member end of an association"); //$NON-NLS-1$
			return null;
		}

		EStructuralFeature feature = UMLPackage.eINSTANCE.getAssociation_NavigableOwnedEnd();
		List<Property> attributeList = new ArrayList<Property>();
		attributeList.addAll(association.getNavigableOwnedEnds());
		if(isNavigable) {
			attributeList.add(property);
		} else {
			attributeList.remove(property);
		}

		return new SetRequest[]{ new SetRequest(domain, association, feature, attributeList) };
	}
}
