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
 *****************************************************************************/
package org.eclipse.papyrus.properties.runtime.modelhandler.emf;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.papyrus.properties.runtime.Activator;
import org.eclipse.papyrus.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.swt.widgets.Composite;


/**
 * Extract or inject values for a string-typed feature.
 */
public class StringEMFModelHandler extends EMFFeatureModelHandler {

	/** ID of this model handler */
	public static final String ID = "String";

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
	public void setValueInModel(EObject objectToEdit, Object newValue) {
		EStructuralFeature featureToEdit = getFeatureByName(objectToEdit);
		if(featureToEdit == null) {
			return;
		}
		
		// check the type of the feature to set
		EClassifier type = featureToEdit.getEType();
		if(type == null) {
			Activator.log.debug("Impossible to find the type of the feature: "+getFeatureName());
		} else {
			if(String.class.isAssignableFrom(type.getInstanceClass())) {
				objectToEdit.eSet(featureToEdit, newValue);
			} else if(Integer.TYPE.isAssignableFrom(type.getInstanceClass())) {
				try {
					int value = Integer.parseInt(newValue.toString());
					objectToEdit.eSet(featureToEdit, value);
				} catch (NumberFormatException e) {
					Activator.log.debug(newValue+ " can not be parsed as an integer");
				}
			} else {
				Activator.log.error("Feature: "+getFeatureName()+". Impossible to understand the value for the type: "+featureToEdit.getEType().getInstanceClass(), null);
			}
		} 
		
	}

	/**
	 * {@inheritDoc}
	 */
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
			Activator.log.error("Impossible during creation operation to find the editing domain for objects: " + objectsToEdit, null);
			return null;
		}
		int indexOfNewValue = NEW_VALUE_NOT_SET_INDEX;
		CompositeTransactionalCommand command = new CompositeTransactionalCommand(editingDomain, "Create new String Values");
		for(EObject objectToEdit : objectsToEdit) {
			EStructuralFeature featureToEdit = getFeatureByName(objectToEdit);
			if(featureToEdit == null) {
				return null;
			}
			CreateStringValueOperation operation = new CreateStringValueOperation(editingDomain, "Create new String Value", objectToEdit);
			if(operation != null) {
				command.add(operation);
			}
			if(indexOfNewValue == NEW_VALUE_NOT_SET_INDEX) { // try to update
				indexOfNewValue = operation.getIndexOfNewValue();
			}
		}

		operations.add(command.reduce());

		return operations;
	}

	/**
	 * Operation to create a String value for the controlled property
	 */
	protected class CreateStringValueOperation extends AbstractTransactionalCommand {

		/** object to edit */
		protected final EObject objectToEdit;

		/** index of the value to add (-1 in case of single valued property) */
		private int indexOfNewValue = -2;

		/**
		 * Initializes me with the editing domain, a label, transaction options, and
		 * a list of {@link IFile}s that anticipate modifying when I am executed,
		 * undone or redone.
		 * 
		 * @param domain
		 *        the editing domain used to modify the model
		 * @param label
		 *        my user-readable label, should never be <code>null</code>.
		 * @param objectToEdit
		 *        the {@link EObject} to edit
		 */
		public CreateStringValueOperation(TransactionalEditingDomain domain, String label, EObject objectToEdit) {
			super(domain, (label == null) ? "" : label, null);
			this.objectToEdit = objectToEdit;

			EStructuralFeature featureToEdit = getFeatureByName(objectToEdit);
			if(featureToEdit.getUpperBound() == 1) {
				indexOfNewValue = -1;
			} else {
				@SuppressWarnings("unchecked")
				List<Object> values = new ArrayList<Object>((List<Object>)objectToEdit.eGet(featureToEdit));
				indexOfNewValue = values.size();
			}
		}

		/**
		 * Returns the index at which the value will be added
		 * 
		 * @return the index at which the value will be added
		 */
		public int getIndexOfNewValue() {
			return indexOfNewValue;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			// create the value and add it to the feature
			// if feature = simple valued => set
			// if feature = multi valued => add at the end
			EStructuralFeature featureToEdit = getFeatureByName(objectToEdit);
			if(featureToEdit == null) {
				return CommandResult.newErrorCommandResult("Impossible to find the feature " + getFeatureName());
			}
			Object newValue;
			if(featureToEdit.getUpperBound() == 1) {
				newValue = getInitialValue(objectToEdit);
			} else {
				@SuppressWarnings("unchecked")
				List<Object> values = new ArrayList<Object>((List<Object>)objectToEdit.eGet(featureToEdit));
				values.add(indexOfNewValue, getInitialValue(objectToEdit));
				newValue = values;
			}
			setValueInModel(objectToEdit, newValue);
			return CommandResult.newOKCommandResult();
		}
	}

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
}
