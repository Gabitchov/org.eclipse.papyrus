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
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IBoundedValuesPropertyEditorDescriptor;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.swt.widgets.Composite;

/**
 * Model Handler for enumeration
 */
public class EnumerationEMFModelHandler extends EMFFeatureModelHandler {

	/**
	 * Creates a new EnumerationEMFModelHandler.
	 * 
	 * @param featureName
	 *        the name of the feature to edit
	 */
	public EnumerationEMFModelHandler(String featureName) {
		super(featureName);
	}


	/** id of this model handler */
	public static final String ID = "Enumeration"; //$NON-NLS-1$

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getValueToEdit(EObject objectToEdit) {
		EStructuralFeature featureToEdit = getFeatureByName(objectToEdit);
		if(featureToEdit == null) {
			return null;
		}
		Object value = objectToEdit.eGet(featureToEdit);
		return (value instanceof Enumerator) ? ((Enumerator)value).getLiteral() : value;
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
		// remove value if result of the editor is empty
		if(newValue == null || newValue.equals("")) { //$NON-NLS-1$
			objectToEdit.eUnset(featureToEdit);
		} else {
			// retrieve the real value for the enumeration
			if(newValue instanceof String) {
				EEnum type = (EEnum)featureToEdit.getEType();
				EEnumLiteral literal = type.getEEnumLiteral((String)newValue);
				Enumerator instance = literal.getInstance();
				objectToEdit.eSet(featureToEdit, instance);
			}
		}
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void completeEditorDescriptor(IPropertyEditorDescriptor descriptor, List<? extends EObject> objectToEdit) {
		if(objectToEdit.size() < 1) {
			return;
		}
		EStructuralFeature featureToEdit = getFeatureByName(objectToEdit.get(0));
		if(featureToEdit == null) {
			return;
		}


		// test enumeration, reference, etc.
		List<String> values = new ArrayList<String>();

		// check if there is an empty string at the beginning. there is one if the lower bound of the feature to edit equal 0 
		if(featureToEdit.getLowerBound() == 0) {
			values.add(""); //$NON-NLS-1$
		}

		if(featureToEdit.getEType() instanceof EEnum) {
			EEnum type = ((EEnum)featureToEdit.getEType());
			for(EEnumLiteral literal : type.getELiterals()) {
				values.add(literal.getLiteral());
			}
		}
		if(descriptor instanceof IBoundedValuesPropertyEditorDescriptor) {
			((IBoundedValuesPropertyEditorDescriptor)descriptor).setAvailableValues(values);
		} else {
			Activator.log.warn("Warning: " + descriptor + "could not be completed."); //$NON-NLS-1$ //$NON-NLS-2$
		}
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
		int indexOfNewValue = NEW_VALUE_NOT_SET_INDEX;
		CompositeTransactionalCommand command = new CompositeTransactionalCommand(editingDomain, "Create new Enumeration Value"); //$NON-NLS-1$
		for(EObject objectToEdit : objectsToEdit) {
			EStructuralFeature featureToEdit = getFeatureByName(objectToEdit);
			if(featureToEdit == null) {
				return null;
			}
			//			CreateEnumerationValueOperation operation = new CreateEnumerationValueOperation(editingDomain, "Create new Enumeration Value", objectToEdit);
			IUndoableOperation operation = getCreateEnumerationValueOperation(editingDomain, "Create new Enumeration Value", objectToEdit); //$NON-NLS-1$
			if(operation != null) {
				command.add(operation);
			}
			if(indexOfNewValue == NEW_VALUE_NOT_SET_INDEX) { // try to update
			}
		}

		operations.add(command.reduce());

		return operations;
	}

	/**
	 * Returns the command to edit the object
	 * 
	 * @param editingDomain
	 *        the editing domain
	 * @param string
	 *        the name of the command
	 * @param objectToEdit
	 *        the object to edit
	 * @return
	 *         the command to edit the object
	 */
	protected IUndoableOperation getCreateEnumerationValueOperation(TransactionalEditingDomain editingDomain, String string, EObject objectToEdit) {
		CompositeTransactionalCommand command = new CompositeTransactionalCommand(editingDomain, string);
		EStructuralFeature featureToEdit = getFeatureByName(objectToEdit);
		if(featureToEdit == null) {
			Activator.log.error("Impossible to find the feature " + getFeatureName(), null); //$NON-NLS-1$
			return command;
		}

		// create the value and add it to the feature
		// if feature = simple valued => set
		// if feature = multi valued => add at the end

		Object newValue;
		if(featureToEdit.getUpperBound() == 1) {
			newValue = getInitialValue(objectToEdit);
		} else {
			@SuppressWarnings("unchecked")
			List<Object> values = new ArrayList<Object>((List<Object>)getValueToEdit(objectToEdit));
			values.add(values.size(), getInitialValue(objectToEdit));
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
	//	 * Operation to create a Enumeration value for the controlled property
	//	 */
	//	protected class CreateEnumerationValueOperation extends AbstractTransactionalCommand {
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
	//		public CreateEnumerationValueOperation(TransactionalEditingDomain domain, String label, EObject objectToEdit) {
	//			super(domain, (label == null) ? "" : label, null);
	//			this.objectToEdit = objectToEdit;
	//
	//			EStructuralFeature featureToEdit = getFeatureByName(objectToEdit);
	//			if(featureToEdit.getUpperBound() == 1) {
	//				indexOfNewValue = -1;
	//			} else {
	//				@SuppressWarnings("unchecked")
	//				List<Object> values = new ArrayList<Object>((List<Object>)getValueToEdit(objectToEdit));
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
	//				List<Object> values = new ArrayList<Object>((List<Object>)getValueToEdit(objectToEdit));
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
			EClassifier eClassifier = featureToEdit.getEType();
			if(eClassifier instanceof EEnum) {
				return ((EEnum)eClassifier).getDefaultValue();
			} else if(Boolean.TYPE.isAssignableFrom(eClassifier.getInstanceClass())) {
				return Boolean.TRUE;
			}
			Activator.log.error("Impossible to find a default value", null); //$NON-NLS-1$
			return null;
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
		// remove value if result of the editor is empty
		if(newValue == null || newValue.equals("")) { //$NON-NLS-1$
			return new SetRequest[]{ new SetRequest(domain, objectToEdit, featureToEdit, featureToEdit.getDefaultValue()) };
		} else {
			// retrieve the real value for the enumeration
			if(newValue instanceof String) {
				EEnum type = (EEnum)featureToEdit.getEType();
				EEnumLiteral literal = type.getEEnumLiteral((String)newValue);
				Enumerator instance = literal.getInstance();
				return new SetRequest[]{ new SetRequest(domain, objectToEdit, featureToEdit, instance) };
			}
		}
		return null;
	}
}
