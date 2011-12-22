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
import java.util.List;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.swt.widgets.Composite;


/**
 * Extract or inject values for a string-typed feature.
 */
public class StringEMFModelHandler extends EMFFeatureModelHandler {

	/** ID of this model handler */
	public static final String ID = "String"; //$NON-NLS-1$

	/**
	 * Creates a new StringEMFModelHandler.
	 * 
	 * @param featureName
	 *        the name of the feature to edit
	 */
	public StringEMFModelHandler(String featureName) {
		super(featureName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setValueInModel(EObject objectToEdit, Object newValue) {
		EStructuralFeature featureToEdit = getFeatureByName(objectToEdit);
		if(featureToEdit == null) {
			return;
		}

		// check the type of the feature to set
		EClassifier type = featureToEdit.getEType();
		if(type == null) {
			Activator.log.debug("Impossible to find the type of the feature: " + getFeatureName()); //$NON-NLS-1$
		} else {
			if(String.class.isAssignableFrom(type.getInstanceClass())) {
				objectToEdit.eSet(featureToEdit, newValue);
			} else if(Integer.TYPE.isAssignableFrom(type.getInstanceClass())) {
				try {
					int value = Integer.parseInt(newValue.toString());
					objectToEdit.eSet(featureToEdit, value);
				} catch (NumberFormatException e) {
					Activator.log.debug(newValue + " can not be parsed as an integer"); //$NON-NLS-1$
				}
			} else {
				Activator.log.error("Feature: " + getFeatureName() + ". Impossible to understand the value for the type: " + featureToEdit.getEType().getInstanceClass(), null); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void completeEditorDescriptor(IPropertyEditorDescriptor descriptor, List<? extends EObject> objectToEdit) {
		// nothing to do here
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
	@Override
	public List<IUndoableOperation> getCreateValueOperations(List<? extends EObject> objectsToEdit, Composite parent) {
		List<IUndoableOperation> operations = new ArrayList<IUndoableOperation>(1);
		TransactionalEditingDomain editingDomain = EMFUtils.getTransactionalEditingDomain(objectsToEdit);
		if(editingDomain == null) {
			Activator.log.error("Impossible during creation operation to find the editing domain for objects: " + objectsToEdit, null); //$NON-NLS-1$
			return null;
		}
		//		int indexOfNewValue = NEW_VALUE_NOT_SET_INDEX;
		CompositeTransactionalCommand command = new CompositeTransactionalCommand(editingDomain, "Create new String Values"); //$NON-NLS-1$
		for(EObject objectToEdit : objectsToEdit) {
			EStructuralFeature featureToEdit = getFeatureByName(objectToEdit);
			if(featureToEdit == null) {
				return null;
			}
			//CreateStringValueOperation operation = new CreateStringValueOperation(editingDomain, "Create new String Value", objectToEdit);
			IUndoableOperation operation = getCreateStringValueCommand(editingDomain, "Create new String Value", objectToEdit); //$NON-NLS-1$
			if(operation != null) {
				command.add(operation);
			}
			//			if(indexOfNewValue == NEW_VALUE_NOT_SET_INDEX) { // try to update
			//				indexOfNewValue = operation.getIndexOfNewValue();
			//			}
		}

		operations.add(command.reduce());

		return operations;
	}

	/**
	 * Returns the command to create a string value
	 * 
	 * @param editingDomain
	 *        the editing domain
	 * @param string
	 *        the command's name
	 * @param objectToEdit
	 *        the object to edit
	 * @return
	 *         The command to create a string value
	 */
	protected IUndoableOperation getCreateStringValueCommand(TransactionalEditingDomain editingDomain, String string, EObject objectToEdit) {
		CompositeTransactionalCommand command = new CompositeTransactionalCommand(editingDomain, string);
		int indexOfNewValue = -2;
		EStructuralFeature featureToEdit = getFeatureByName(objectToEdit);
		if(featureToEdit == null) {
			return command;
		}
		if(featureToEdit.getUpperBound() == 1) {
			indexOfNewValue = -1;
		} else {
			@SuppressWarnings("unchecked")
			List<Object> values = new ArrayList<Object>((List<Object>)objectToEdit.eGet(featureToEdit));
			indexOfNewValue = values.size();
		}

		// create the value and add it to the feature
		// if feature = simple valued => set
		// if feature = multi valued => add at the end
		Object newValue;
		if(featureToEdit.getUpperBound() == 1) {
			newValue = getInitialValue(objectToEdit);
		} else {
			@SuppressWarnings("unchecked")
			List<Object> values = new ArrayList<Object>((List<Object>)objectToEdit.eGet(featureToEdit));
			values.add(indexOfNewValue, getInitialValue(objectToEdit));
			newValue = values;
		}
		SetRequest[] requests = getSetRequest(editingDomain, objectToEdit, newValue);
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
		return command;
	}

	//	/**
	//	 * Operation to create a String value for the controlled property
	//	 */
	//	protected class CreateStringValueOperation extends AbstractTransactionalCommand {
	//
	//		/** object to edit */
	//		protected final EObject objectToEdit;
	//
	//		/** index of the value to add (-1 in case of single valued property) */
	//		private int indexOfNewValue = -2;
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
	//		 *        the {@link EObject} to edit
	//		 */
	//		public CreateStringValueOperation(TransactionalEditingDomain domain, String label, EObject objectToEdit) {
	//			super(domain, (label == null) ? "" : label, null);
	//			this.objectToEdit = objectToEdit;
	//
	//			EStructuralFeature featureToEdit = getFeatureByName(objectToEdit);
	//			if(featureToEdit.getUpperBound() == 1) {
	//				indexOfNewValue = -1;
	//			} else {
	//				@SuppressWarnings("unchecked")
	//				List<Object> values = new ArrayList<Object>((List<Object>)objectToEdit.eGet(featureToEdit));
	//				indexOfNewValue = values.size();
	//			}
	//		}
	//
	//		/**
	//		 * Returns the index at which the value will be added
	//		 * 
	//		 * @return the index at which the value will be added
	//		 */
	//		public int getIndexOfNewValue() {
	//			return indexOfNewValue;
	//		}
	//
	//		/**
	//		 * {@inheritDoc}
	//		 */
	//		@Override
	//		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
	//			// create the value and add it to the feature
	//			// if feature = simple valued => set
	//			// if feature = multi valued => add at the end
	//			EStructuralFeature featureToEdit = getFeatureByName(objectToEdit);
	//			if(featureToEdit == null) {
	//				return CommandResult.newErrorCommandResult("Impossible to find the feature " + getFeatureName());
	//			}
	//			Object newValue;
	//			if(featureToEdit.getUpperBound() == 1) {
	//				newValue = getInitialValue(objectToEdit);
	//			} else {
	//				@SuppressWarnings("unchecked")
	//				List<Object> values = new ArrayList<Object>((List<Object>)objectToEdit.eGet(featureToEdit));
	//				values.add(indexOfNewValue, getInitialValue(objectToEdit));
	//				newValue = values;
	//			}
	//			setValueInModel(objectToEdit, newValue);
	//			return CommandResult.newOKCommandResult();
	//		}
	//	}

	/**
	 * Returns the initial value for a new value of the feature
	 * 
	 * @param objectToEdit
	 *        the object to edit
	 * 
	 * @return the initial value, not <code>null</code>
	 */
	public Object getInitialValue(EObject objectToEdit) {
		String featureName = getFeatureName();
		EStructuralFeature featureToEdit = getFeatureByName(objectToEdit);
		if(featureToEdit.getUpperBound() == 1) {
			return featureName;
		} else {
			for(int suffix = 0; suffix < 1000; suffix++) {
				String tmpName = featureName + suffix;
				boolean found = false;
				@SuppressWarnings("unchecked")
				List<Object> values = new ArrayList<Object>((List<Object>)objectToEdit.eGet(featureToEdit));
				for(Object value : values) {
					if(tmpName.equals(value)) {
						found = true;
					}
				}
				if(!found) {
					return tmpName;
				}
			}
			return featureName;
		}
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
		EStructuralFeature featureToEdit = getFeatureByName(objectToEdit);
		if(featureToEdit == null) {
			return null;
		}

		// check the type of the feature to set
		EClassifier type = featureToEdit.getEType();
		if(type == null) {
			Activator.log.debug("Impossible to find the type of the feature: " + getFeatureName()); //$NON-NLS-1$
			return null;
		} else {
			if(String.class.isAssignableFrom(type.getInstanceClass())) {
				return new SetRequest[]{ new SetRequest(domain, objectToEdit, featureToEdit, newValue) };
			} else if(Integer.TYPE.isAssignableFrom(type.getInstanceClass())) {
				try {
					int value = Integer.parseInt(newValue.toString());
					return new SetRequest[]{ new SetRequest(domain, objectToEdit, featureToEdit, value) };
				} catch (NumberFormatException e) {
					Activator.log.debug(newValue + " can not be parsed as an integer"); //$NON-NLS-1$
				}
			} else {
				Activator.log.error("Feature: " + getFeatureName() + ". Impossible to understand the value for the type: " + featureToEdit.getEType().getInstanceClass(), null); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		return null;
	}
}
