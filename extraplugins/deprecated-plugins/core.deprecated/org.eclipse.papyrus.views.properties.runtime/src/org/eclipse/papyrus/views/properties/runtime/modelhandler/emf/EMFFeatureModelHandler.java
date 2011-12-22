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
package org.eclipse.papyrus.views.properties.runtime.modelhandler.emf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.controller.EMFPropertyEditorController;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;


/**
 * Abstract class for EMF Model handlers
 */
public abstract class EMFFeatureModelHandler implements IEMFModelHandler {

	/** name of the feature to edit */
	private final String featureName;

	/** factory used by EMF objects */
	protected AdapterFactory factory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

	/** value of unset new value index */
	public static final int NEW_VALUE_NOT_SET_INDEX = -2;

	/** value of single value property */
	public static final int SINGLE_VALUE_PROPERTY_INDEX = -1;

	/**
	 * Creates a new EMFFeatureModelHandler.
	 * 
	 * @param featureName
	 *        the name of the feature to edit
	 */
	public EMFFeatureModelHandler(String featureName) {
		this.featureName = featureName;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getValueToEdit(EObject objectToEdit) {
		EStructuralFeature featureToEdit = getFeatureByName(objectToEdit);
		if(featureToEdit == null) {
			return null;
		}
		return objectToEdit.eGet(featureToEdit);
	}

	/**
	 * {@inheritDoc}
	 */
	public abstract void setValueInModel(EObject objectToEdit, Object newValue);

	/**
	 * {@inheritDoc}
	 */
	public abstract void completeEditorDescriptor(IPropertyEditorDescriptor descriptor, List<? extends EObject> objectToEdit);

	/**
	 * Returns the name of the feature to edit
	 * 
	 * @return the name of the feature to edit
	 */
	public String getFeatureName() {
		return featureName;
	}

	/**
	 * Retrieve the main {@link EStructuralFeature} of this model handler
	 * 
	 * @param objectToEdit
	 *        the object being edited
	 * @return the feature found <code>null</code> if not found
	 */
	public EStructuralFeature getFeatureByName(EObject objectToEdit) {
		return EMFUtils.getFeatureByName(objectToEdit, featureName);
	}

	/**
	 * checks if the feature is changeable
	 * 
	 * @param objectsToEdit
	 *        the list of objects to edit
	 * @return <code>true</code> if the feature is changeable
	 */
	public boolean isChangeable(List<? extends EObject> objectsToEdit) {
		if(objectsToEdit.size() < 1) {
			return false;
		}
		// retrieve the feature
		EStructuralFeature feature = getFeatureByName(objectsToEdit.get(0));
		return (feature != null) ? feature.isChangeable() : false;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return "EMF Handler \"" + getId() + "\" -> " + getFeatureName(); //$NON-NLS-1$ //$NON-NLS-2$
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
	public IEMFModelHandlerState createState(boolean readOnly) {
		return new EMFFeatureModelHandlerState(this, readOnly);
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getAvailableValues(EObject eObject) {
		EClass eClass = eObject.eClass();
		if(eClass == null) {
			Activator.log.debug("problems during initialization, looking for availables values"); //$NON-NLS-1$
			return null;
		}
		EStructuralFeature feature = getFeatureByName(eObject);
		if(!(feature instanceof EReference)) {
			Activator.log.debug("feature is not a reference, looking for availables values: " + feature); //$NON-NLS-1$
			return null;
		}

		IItemPropertySource itemPropertySource = (IItemPropertySource)factory.adapt(eObject, IItemPropertySource.class);
		if(itemPropertySource == null) {
			Activator.log.debug("impossible to find item Property source for " + eObject); //$NON-NLS-1$
			return null;
		}
		IItemPropertyDescriptor itemPropertyDescriptor = itemPropertySource.getPropertyDescriptor(eObject, feature);
		if(itemPropertyDescriptor == null) {
			Activator.log.debug("impossible to find item Property descriptor for " + eObject + " and " + feature); //$NON-NLS-1$ //$NON-NLS-2$
			return null;
		}
		return itemPropertyDescriptor.getChoiceOfValues(eObject);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public void handleNotifyChange(Notification notification, List<? extends EObject> objects, EMFPropertyEditorController adapter) {
		// if one element is added to the feature, should also add this as a listener
		// if one element is removed from the feature, should also remove this as a listener
		// in other case, except removing adapters, should refresh
		Object notificationFeature = notification.getFeature();
		switch(notification.getEventType()) {
		case Notification.ADD:
			// check which feature has been modified
			for(EObject eObject : objects) {
				EStructuralFeature feature = getFeatureByName(eObject);
				if(notificationFeature.equals(feature)) {
					Object newValue = notification.getNewValue();
					if(newValue instanceof EObject) {
						((EObject)newValue).eAdapters().add(adapter);
					}
					// refresh the editors
					adapter.refreshDisplay();
				}
			}
			break;
		case Notification.ADD_MANY:
			// check which feature has been modified
			for(EObject eObject : objects) {
				EStructuralFeature feature = getFeatureByName(eObject);
				if(notificationFeature.equals(feature)) {
					for(Object newValue : ((List<Object>)notification.getNewValue())) {
						if(newValue instanceof EObject) {
							((EObject)newValue).eAdapters().add(adapter);
						}
					}
					// refresh the editors
					adapter.refreshDisplay();
				}
			}
			break;

		case Notification.REMOVE:
			// check which feature has been modified
			for(EObject eObject : objects) {
				EStructuralFeature feature = getFeatureByName(eObject);
				if(notificationFeature.equals(feature)) {
					Object oldValue = notification.getOldValue();
					if(oldValue instanceof EObject) {
						((EObject)oldValue).eAdapters().remove(this);
					}

					// refresh the editors
					adapter.refreshDisplay();
				}
			}
			break;

		case Notification.REMOVE_MANY:
			for(EObject eObject : objects) {
				EStructuralFeature feature = getFeatureByName(eObject);
				if(notificationFeature.equals(feature)) {
					for(Object oldValue : ((List<Object>)notification.getOldValue())) {
						if(oldValue instanceof EObject) {
							((EObject)oldValue).eAdapters().add(adapter);
						}
					}
					// refresh the editors
					adapter.refreshDisplay();
				}
			}
			break;
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
	public abstract List<IUndoableOperation> getCreateValueOperations(List<? extends EObject> objectsToEdit, Composite parent);

	/**
	 * {@inheritDoc}
	 */
	public boolean canCreateValueOperations(List<? extends EObject> objectsToEdit) {
		for(EObject objectToEdit : objectsToEdit) {
			EStructuralFeature featureToEdit = getFeatureByName(objectToEdit);
			if(featureToEdit == null) {
				return false;
			}

			if(!featureToEdit.isChangeable()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public IUndoableOperation getDeleteValueOperation(List<? extends EObject> objectsToEdit, Composite parent, List<Integer> indexes) {
		TransactionalEditingDomain editingDomain = EMFUtils.getTransactionalEditingDomain(objectsToEdit);
		if(editingDomain == null) {
			Activator.log.error("Impossible during creation operation to find the editing domain for objects: " + objectsToEdit, null); //$NON-NLS-1$
			return null;
		}
		CompositeTransactionalCommand command = new CompositeTransactionalCommand(editingDomain, "Edit Value"); //$NON-NLS-1$
		for(EObject objectToEdit : objectsToEdit) {
			EStructuralFeature featureToEdit = getFeatureByName(objectToEdit);
			if(featureToEdit == null) {
				return null;
			}
			//			DeleteStringValueOperation operation = new DeleteStringValueOperation(editingDomain, "Edit Value", objectToEdit, indexes, parent);
			IUndoableOperation operation = getDeleteStringValueOperation(editingDomain, "Edit Value", objectToEdit, indexes, parent); //$NON-NLS-1$
			if(operation != null) {
				command.add(operation);
			}
		}
		return command.reduce();
	}

	/**
	 * Returns the command to remove String values
	 * 
	 * @param editingDomain
	 *        the editing domain
	 * @param string
	 *        the name of the command
	 * @param objectToEdit
	 *        the object to edit
	 * @param indexes
	 *        the index of the element to remove
	 * @param parent
	 *        the composite parent
	 * @return
	 *         the command to remove String values
	 */
	protected IUndoableOperation getDeleteStringValueOperation(TransactionalEditingDomain editingDomain, String string, EObject objectToEdit, List<Integer> indexes, Composite parent) {
		CompositeTransactionalCommand command = new CompositeTransactionalCommand(editingDomain, string);
		// get the feature to modify
		EStructuralFeature featureToEdit = getFeatureByName(objectToEdit);
		if(featureToEdit == null) {
			return null;
		}
		Object newValue;
		if(featureToEdit.getUpperBound() == 1) {
			newValue = featureToEdit.getDefaultValue();
		} else {
			@SuppressWarnings("unchecked")
			List<Object> values = new ArrayList<Object>((List<Object>)getValueToEdit(objectToEdit));
			for(int index : indexes) {
				values.remove(index);
			}
			newValue = values;
		}
		SetRequest[] requests = getSetRequest(editingDomain, objectToEdit, newValue);
		org.eclipse.papyrus.infra.services.edit.service.IElementEditService provider = org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils.getCommandProvider(objectToEdit);
		if(provider != null) {

			ICommand editCommand = null;
			for(SetRequest current : requests) {
				editCommand = provider.getEditCommand(current);

				if(editCommand != null && editCommand.canExecute()) {
					command.add(editCommand);
				}
			}
		}
		return command;
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
		TransactionalEditingDomain editingDomain = EMFUtils.getTransactionalEditingDomain(objectsToEdit);
		if(editingDomain == null) {
			Activator.log.error("Impossible during creation operation to find the editing domain for objects: " + objectsToEdit, null); //$NON-NLS-1$
			return null;
		}
		CompositeTransactionalCommand command = new CompositeTransactionalCommand(editingDomain, "Edit Value"); //$NON-NLS-1$
		for(EObject objectToEdit : objectsToEdit) {
			EStructuralFeature featureToEdit = getFeatureByName(objectToEdit);
			if(featureToEdit == null) {
				return null;
			}
			//			EditStringValueOperation operation = new EditStringValueOperation(editingDomain, "Edit Value", objectToEdit, index, parent, value);
			IUndoableOperation operation = getEditStringValueOperation(editingDomain, "Edit Value", objectToEdit, index, parent, value); //$NON-NLS-1$
			if(operation != null) {
				command.add(operation);
			}
		}
		return command.reduce();
	}

	/**
	 * Returns the Operation to edit the String value
	 * 
	 * @param editingDomain
	 *        the editing domain
	 * @param string
	 *        the name of the command
	 * @param objectToEdit
	 *        the object to edit
	 * @param index
	 *        the index of the String to edit
	 * @param parent
	 *        the composite parent
	 * @param value
	 *        the value to set
	 * @return
	 *         the Operation to edit the String value
	 */
	protected IUndoableOperation getEditStringValueOperation(TransactionalEditingDomain editingDomain, String string, EObject objectToEdit, int index, Composite parent, Object value) {
		CompositeTransactionalCommand command = new CompositeTransactionalCommand(editingDomain, string);
		// get the feature to modify
		EStructuralFeature featureToEdit = getFeatureByName(objectToEdit);
		if(featureToEdit == null) {
			return null;
		}
		Object newValue;
		if(featureToEdit.getUpperBound() == 1) {
			newValue = value;
		} else {
			@SuppressWarnings("unchecked")
			List<Object> values = new ArrayList<Object>((List<Object>)getValueToEdit(objectToEdit));
			values.set(index, value);
			newValue = values;
		}
		SetRequest[] requests = getSetRequest(editingDomain, objectToEdit, newValue);
		org.eclipse.papyrus.infra.services.edit.service.IElementEditService provider = org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils.getCommandProvider(objectToEdit);
		if(provider != null) {

			ICommand editCommand = null;
			for(SetRequest current : requests) {
				editCommand = provider.getEditCommand(current);

				if(editCommand != null && editCommand.canExecute()) {
					command.add(editCommand);
				}
			}
		}
		return command;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean canCreateEditValueOperation(List<? extends EObject> objectsToEdit) {
		// try to retrieve editor for this property
		// if one exists, return yes
		// or try to open an inline-editor for simple values
		return true;
	}

	/**
	 * Returns the feature ID
	 * 
	 * @param feature
	 *        the feature
	 * @param elementToEdit
	 *        the element to edit
	 * @return
	 *         the feature ID
	 */
	protected int getFeatureID(EStructuralFeature feature, BasicEObjectImpl elementToEdit) {
		return (elementToEdit).eDerivedStructuralFeatureID(feature);
	}

	/**
	 * Returns the structural feature of elementToEdit corresponding to this ID
	 * 
	 * @param ID
	 *        the ID of the feature
	 * @param elementToEdit
	 *        the element to edit
	 * @return
	 *         the structural feature of elementToEdit corresponding to this ID
	 */
	protected EStructuralFeature getStructuralFeature(int ID, EObject elementToEdit) {
		if(elementToEdit instanceof BasicEObjectImpl) {
			EClass eClass = elementToEdit.eClass();
			return eClass.getEStructuralFeature(ID);
		}
		return null;
	}

	//	/**
	//	 * Operation to edit a String value for the controlled property
	//	 */
	//	protected class EditStringValueOperation extends AbstractTransactionalCommand {
	//
	//		/** object to edit */
	//		protected final EObject objectToEdit;
	//
	//		/** index of the value to edit */
	//		protected final int index;
	//
	//		/** composite parent for the editor */
	//		protected final Composite parent;
	//
	//		/** value to set */
	//		protected final Object value;
	//
	//		/**
	//		 * Initializes me with the editing domain, a label, transaction options, and
	//		 * a list of {@link IFile}s that anticipate modifying when I am executed,
	//		 * undone or redone.
	//		 * 
	//		 * @param domain
	//		 *        the editing domain used to modify the model
	//		 * @param label
	//		 *        my user-readable label, should never be <code>null</code>.
	//		 * @param objectToEdit
	//		 *        object to edit
	//		 * @param index
	//		 *        the index of the value to edit
	//		 * @param parent
	//		 *        the graphical composite element
	//		 * @param value
	//		 */
	//		public EditStringValueOperation(TransactionalEditingDomain domain, String label, EObject objectToEdit, int index, Composite parent, Object value) {
	//			super(domain, (label == null) ? "" : label, null);
	//			this.objectToEdit = objectToEdit;
	//			this.index = index;
	//			this.parent = parent;
	//			this.value = value;
	//		}
	//
	//		/**
	//		 * {@inheritDoc}
	//		 */
	//		@Override
	//		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
	//			// get the feature to modify
	//			EStructuralFeature featureToEdit = getFeatureByName(objectToEdit);
	//			if(featureToEdit == null) {
	//				return CommandResult.newErrorCommandResult("Impossible to find the feature " + getFeatureName());
	//			}
	//			Object newValue;
	//			if(featureToEdit.getUpperBound() == 1) {
	//				newValue = value;
	//			} else {
	//				@SuppressWarnings("unchecked")
	//				List<Object> values = new ArrayList<Object>((List<Object>)getValueToEdit(objectToEdit));
	//				values.set(index, value);
	//				newValue = values;
	//			}
	//			setValueInModel(objectToEdit, newValue);
	//			return CommandResult.newOKCommandResult();
	//		}
	//	}

	//	/**
	//	 * Operation to edit a String value for the controlled property
	//	 */
	//	protected class DeleteStringValueOperation extends AbstractTransactionalCommand {
	//
	//		/** object to edit */
	//		protected final EObject objectToEdit;
	//
	//		/** indexes of the value to delete */
	//		protected final List<Integer> indexes;
	//
	//		/** composite parent for the editor */
	//		protected final Composite parent;
	//
	//		/**
	//		 * Initializes me with the editing domain, a label, transaction options, and
	//		 * a list of {@link IFile}s that anticipate modifying when I am executed,
	//		 * undone or redone.
	//		 * 
	//		 * @param domain
	//		 *        the editing domain used to modify the model
	//		 * @param label
	//		 *        my user-readable label, should never be <code>null</code>.
	//		 * @param objectToEdit
	//		 *        object to edit
	//		 * @param indexes
	//		 *        the indexes of the values to remove
	//		 * @param parent
	//		 *        the graphical composite element
	//		 */
	//		public DeleteStringValueOperation(TransactionalEditingDomain domain, String label, EObject objectToEdit, List<Integer> indexes, Composite parent) {
	//			super(domain, (label == null) ? "" : label, null);
	//			this.objectToEdit = objectToEdit;
	//			this.indexes = indexes;
	//			this.parent = parent;
	//		}
	//
	//		/**
	//		 * {@inheritDoc}
	//		 */
	//		@Override
	//		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
	//			// get the feature to modify
	//			EStructuralFeature featureToEdit = getFeatureByName(objectToEdit);
	//			if(featureToEdit == null) {
	//				return CommandResult.newErrorCommandResult("Impossible to find the feature " + getFeatureName());
	//			}
	//			Object newValue;
	//			if(featureToEdit.getUpperBound() == 1) {
	//				objectToEdit.eUnset(featureToEdit);
	//			} else {
	//				@SuppressWarnings("unchecked")
	//				List<Object> values = new ArrayList<Object>((List<Object>)getValueToEdit(objectToEdit));
	//				for(int index : indexes) {
	//					values.remove(index);
	//				}
	//				newValue = values;
	//				setValueInModel(objectToEdit, newValue);
	//			}
	//			return CommandResult.newOKCommandResult();
	//		}
	//	}

	/**
	 * {@inheritDoc}
	 */
	public IUndoableOperation getMoveValueOperation(List<? extends EObject> objectsToEdit, List<Integer> indexes, Composite parent, int delta) {
		TransactionalEditingDomain editingDomain = EMFUtils.getTransactionalEditingDomain(objectsToEdit);
		if(editingDomain == null) {
			Activator.log.error("Impossible during move operation to find the editing domain for objects: " + objectsToEdit, null); //$NON-NLS-1$
			return null;
		}
		CompositeTransactionalCommand command = new CompositeTransactionalCommand(editingDomain, "Move Values"); //$NON-NLS-1$
		for(EObject objectToEdit : objectsToEdit) {
			EStructuralFeature featureToEdit = getFeatureByName(objectToEdit);
			if(featureToEdit == null) {
				return null;
			}
			//			MoveStringValueOperation operation = new MoveStringValueOperation(editingDomain, "Move Value", objectToEdit, indexes, parent, delta);
			IUndoableOperation operation = getMoveStringValueOperation(editingDomain, "Move Value", objectToEdit, indexes, parent, delta); //$NON-NLS-1$
			if(operation != null) {
				command.add(operation);
			}
		}
		return command.reduce();
	}

	/**
	 * Returns the command to move String values
	 * 
	 * @param editingDomain
	 *        the editing domain
	 * @param string
	 *        the name of the command
	 * @param objectToEdit
	 *        the object to edit
	 * @param indexes
	 *        the index of the elements to move
	 * @param parent
	 *        the composite parent
	 * @param delta
	 *        the delta
	 * @return
	 *         the command to move String values
	 */
	protected IUndoableOperation getMoveStringValueOperation(TransactionalEditingDomain editingDomain, String string, EObject objectToEdit, List<Integer> indexes, Composite parent, int delta) {
		CompositeTransactionalCommand command = new CompositeTransactionalCommand(editingDomain, string);
		if(canMoveStringValue(objectToEdit, indexes, delta)) {

			EClass eClass = objectToEdit.eClass();
			if(eClass == null) {
				return null;
			}
			// retrieve the current value (should be a list)
			EStructuralFeature feature = getFeatureByName(objectToEdit);
			Object currentValue = objectToEdit.eGet(feature);
			if(currentValue instanceof List<?>) {
				@SuppressWarnings("unchecked")
				List<Object> values = (List<Object>)currentValue;
				List<Object> copy = new ArrayList<Object>(values);
				// make modification in copy list
				// check indices
				int min = copy.size();
				int max = 0;

				for(int index : indexes) {
					if(index < min) {
						min = index;
					}
					if(index > max) {
						max = index;
					}
				}

				// check that min and max are in the bounds of the list, with the
				// delta applied
				min += delta;
				max += delta;
				// check the bounds of the list
				if(min < 0) {
					Activator.log.debug("Trying to move up the elements, with a move which will cause an IndexOutOfBound exception"); //$NON-NLS-1$
					return null;
				} else if(max >= copy.size()) {
					Activator.log.debug("Trying to move down the elements, with a move which will cause an IndexOutOfBound exception"); //$NON-NLS-1$
					return null;
				}

				// now, do the move in the copy
				if(delta < 0) {
					moveUpElementsInCollection(copy, indexes, delta);
				} else {
					moveDownElementsOperation(copy, indexes, delta);
				}

				//			setValueInModel(objectToEdit, copy);
				SetRequest[] requests = getSetRequest(editingDomain, objectToEdit, copy);
				if(requests != null) {

					org.eclipse.papyrus.infra.services.edit.service.IElementEditService provider = org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils.getCommandProvider(objectToEdit);
					if(provider != null) {

						ICommand editCommand = null;
						for(SetRequest current : requests) {
							editCommand = provider.getEditCommand(current);

							if(editCommand != null && editCommand.canExecute()) {
								command.add(editCommand);
							}
						}
					}
				}
			}
		}
		return command;
	}

	/**
	 * Tests if we can move values
	 * 
	 * @param objectToEdit
	 *        the object to edit
	 * @param indexes
	 *        the indexes
	 * @param delta
	 *        the delta
	 * @return
	 *         <code>true</code> if we can move the values <code>false</code> if not
	 */
	protected boolean canMoveStringValue(EObject objectToEdit, List<Integer> indexes, int delta) {
		EClass eClass = objectToEdit.eClass();
		if(eClass == null) {
			return false;
		}
		// retrieve the current value (should be a list)
		EStructuralFeature feature = getFeatureByName(objectToEdit);
		Object currentValue = objectToEdit.eGet(feature);
		if(currentValue instanceof List<?>) {
			@SuppressWarnings("unchecked")
			List<Object> values = (List<Object>)currentValue;
			List<Object> copy = new ArrayList<Object>(values);
			// make modification in copy list
			// check indices
			int min = copy.size();
			int max = 0;

			for(int index : indexes) {
				if(index < min) {
					min = index;
				}
				if(index > max) {
					max = index;
				}
			}

			// check that min and max are in the bounds of the list, with the
			// delta applied
			min += delta;
			max += delta;
			// check the bounds of the list
			if(min < 0) {
				return false;
			} else if(max >= copy.size()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean canCreateMoveValueOperation(List<? extends EObject> objectsToEdit, List<Integer> indexes, Composite parent, int delta) {
		TransactionalEditingDomain editingDomain = EMFUtils.getTransactionalEditingDomain(objectsToEdit);
		if(editingDomain == null) {
			Activator.log.error("Impossible during move operation to find the editing domain for objects: " + objectsToEdit, null); //$NON-NLS-1$
			return false;
		}
		CompositeTransactionalCommand command = new CompositeTransactionalCommand(editingDomain, "Move Values"); //$NON-NLS-1$
		for(EObject objectToEdit : objectsToEdit) {
			EStructuralFeature featureToEdit = getFeatureByName(objectToEdit);
			if(featureToEdit == null) {
				return false;
			}
			//MoveStringValueOperation operation = new MoveStringValueOperation(editingDomain, "Move Value", objectToEdit, indexes, parent, delta);
			IUndoableOperation operation = getMoveStringValueOperation(editingDomain, "Move Value", objectToEdit, indexes, parent, delta); //$NON-NLS-1$
			if(operation != null) {
				command.add(operation);
			}
		}
		return command.canExecute();
	}

	/**
	 * Moves the element in the specified list, when the elements are moved down
	 * in the list
	 * 
	 * @param modifiedElements
	 *        list of elements modified
	 * @param indexes
	 *        list of indexes of objects to move
	 * @param move
	 *        delta for the move. should be positive integer
	 */
	protected void moveDownElementsOperation(List<Object> modifiedElements, List<Integer> indexes, int move) {
		// if moving down, starting from the end to move elements, assuming they
		// are in the increasing order by default
		Collections.sort(indexes);
		Collections.reverse(indexes);
		for(int index : indexes) {
			Object objectToMove = modifiedElements.get(index);
			// remove element
			modifiedElements.remove(index);
			// change index
			if(index == -1) {
				return;
			}
			index += move;
			// add the element to the new index
			modifiedElements.add(index, objectToMove);
		}
	}

	/**
	 * Moves the element in the specified list, when the elements are moved up
	 * in the list
	 * 
	 * @param modifiedElements
	 *        list of elements modified
	 * @param indexes
	 *        list of indexes of objects to move
	 * @param move
	 *        delta for the move. should be positive integer
	 */
	protected void moveUpElementsInCollection(List<Object> modifiedElements, List<Integer> indexes, int move) {
		Collections.sort(indexes);
		for(int index : indexes) {
			// retrieve index
			Object objectToMove = modifiedElements.get(index);
			// remove element
			modifiedElements.remove(index);
			// change index
			if(index == -1) {
				return;
			}
			index += move;
			// add the element to the new index
			modifiedElements.add(index, objectToMove);
		}
	}

	//	/**
	//	 * Operation to edit a String value for the controlled property
	//	 */
	//	protected class MoveStringValueOperation extends AbstractTransactionalCommand {
	//
	//		/** object to edit */
	//		protected final EObject objectToEdit;
	//
	//		/** indexes of the value to delete */
	//		protected final List<Integer> indexes;
	//
	//		/** composite parent for the editor */
	//		protected final Composite parent;
	//
	//		/** delta applied to all indexes */
	//		protected final int delta;
	//
	//		/**
	//		 * Initializes me with the editing domain, a label, transaction options, and
	//		 * a list of {@link IFile}s that anticipate modifying when I am executed,
	//		 * undone or redone.
	//		 * 
	//		 * @param domain
	//		 *        the editing domain used to modify the model
	//		 * @param label
	//		 *        my user-readable label, should never be <code>null</code>.
	//		 * @param objectToEdit
	//		 *        object to edit
	//		 * @param indexes
	//		 *        the indexes of the values to remove
	//		 * @param parent
	//		 *        the graphical composite element
	//		 * @param delta
	//		 *        the delta applied to all indexes
	//		 */
	//		public MoveStringValueOperation(TransactionalEditingDomain domain, String label, EObject objectToEdit, List<Integer> indexes, Composite parent, int delta) {
	//			super(domain, (label == null) ? "" : label, null);
	//			this.objectToEdit = objectToEdit;
	//			this.indexes = indexes;
	//			this.parent = parent;
	//			this.delta = delta;
	//		}
	//
	//		@Override
	//		public boolean canExecute() {
	//			EClass eClass = objectToEdit.eClass();
	//			if(eClass == null) {
	//				return false;
	//			}
	//			// retrieve the current value (should be a list)
	//			EStructuralFeature feature = getFeatureByName(objectToEdit);
	//			Object currentValue = objectToEdit.eGet(feature);
	//			if(currentValue instanceof List<?>) {
	//				@SuppressWarnings("unchecked")
	//				List<Object> values = (List<Object>)currentValue;
	//				List<Object> copy = new ArrayList<Object>(values);
	//				// make modification in copy list
	//				// check indices
	//				int min = copy.size();
	//				int max = 0;
	//
	//				for(int index : indexes) {
	//					if(index < min) {
	//						min = index;
	//					}
	//					if(index > max) {
	//						max = index;
	//					}
	//				}
	//
	//				// check that min and max are in the bounds of the list, with the
	//				// delta applied
	//				min += delta;
	//				max += delta;
	//				// check the bounds of the list
	//				if(min < 0) {
	//					return false;
	//				} else if(max >= copy.size()) {
	//					return false;
	//				}
	//			}
	//			return true;
	//		}
	//
	//		/**
	//		 * {@inheritDoc}
	//		 */
	//		@Override
	//		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
	//			EClass eClass = objectToEdit.eClass();
	//			if(eClass == null) {
	//				return CommandResult.newErrorCommandResult("Impossible to find the EClass for object: " + objectToEdit);
	//			}
	//			// retrieve the current value (should be a list)
	//			EStructuralFeature feature = getFeatureByName(objectToEdit);
	//			Object currentValue = objectToEdit.eGet(feature);
	//			if(currentValue instanceof List<?>) {
	//				@SuppressWarnings("unchecked")
	//				List<Object> values = (List<Object>)currentValue;
	//				List<Object> copy = new ArrayList<Object>(values);
	//				// make modification in copy list
	//				// check indices
	//				int min = copy.size();
	//				int max = 0;
	//
	//				for(int index : indexes) {
	//					if(index < min) {
	//						min = index;
	//					}
	//					if(index > max) {
	//						max = index;
	//					}
	//				}
	//
	//				// check that min and max are in the bounds of the list, with the
	//				// delta applied
	//				min += delta;
	//				max += delta;
	//				// check the bounds of the list
	//				if(min < 0) {
	//					Activator.log.debug("Trying to move up the elements, with a move which will cause an IndexOutOfBound exception");
	//					return CommandResult.newErrorCommandResult("Trying to move up the elements, with a move which will cause an IndexOutOfBound exception");
	//				} else if(max >= copy.size()) {
	//					Activator.log.debug("Trying to move down the elements, with a move which will cause an IndexOutOfBound exception");
	//					return CommandResult.newErrorCommandResult("Trying to move down the elements, with a move which will cause an IndexOutOfBound exception");
	//				}
	//
	//				// now, do the move in the copy
	//				if(delta < 0) {
	//					moveUpElementsInCollection(copy, indexes, delta);
	//				} else {
	//					moveDownElementsOperation(copy, indexes, delta);
	//				}
	//
	//				setValueInModel(objectToEdit, copy);
	//			}
	//
	//			return CommandResult.newOKCommandResult();
	//		}
	//	}
}
