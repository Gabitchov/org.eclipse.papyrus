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
package org.eclipse.papyrus.views.properties.runtime.modelhandler.emf;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IBoundedValuesPropertyEditorDescriptor;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.StructuralFeature;


/**
 * Model Handler for enumeration-typed stereotype properties
 */
public class EnumerationStereotypeModelHandler extends EMFStereotypeFeatureModelHandler {

	/** identifier fot this model handler */
	public static final String ID = "EnumerationStereotype";

	/**
	 * Creates a new EnumerationStereotypeModelHandler.
	 * 
	 * @param stereotypeName
	 *        name of the stereotype to edit
	 * @param featureName
	 *        name of the feature to edit
	 */
	public EnumerationStereotypeModelHandler(String stereotypeName, String featureName) {
		super(stereotypeName, featureName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void setValueForElement(Element elementToEdit, Stereotype stereotype, Object newValue) {
		// remove value if result of the editor is empty
		if(newValue == null || newValue.equals("")) {
			// no unset for values ?!
			elementToEdit.setValue(stereotype, getFeatureName(), null);
		} else {
			// retrieve the real value for the enumeration
			if(newValue instanceof String) {
				StructuralFeature featureToEdit = retrieveStructuralFeature(elementToEdit, stereotype);
				Enumeration type = (Enumeration)featureToEdit.getType();
				EnumerationLiteral literal = type.getOwnedLiteral((String)newValue);
				elementToEdit.setValue(stereotype, getFeatureName(), literal);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getValueToEdit(EObject objectToEdit) {
		if(!(objectToEdit instanceof Element)) {
			Activator.log.warn("the element selected is not a UML element: " + objectToEdit);
			return null;
		}
		Element elementToEdit = (Element)objectToEdit;
		Stereotype stereotype = retrieveStereotype(elementToEdit);
		if(stereotype == null) {
			Activator.log.warn("Impossible to find the stereotype " + getStereotypeName() + " for the given element" + elementToEdit);
			return null;
		}
		Object value = elementToEdit.getValue(stereotype, getFeatureName());
		if(value instanceof EnumerationLiteral) {
			return ((EnumerationLiteral)value).getName();
		} else if(value instanceof Enumerator) {
			return ((Enumerator)value).getLiteral();
		}
		return value;
	}

	/**
	 * {@inheritDoc}
	 */
	public void completeEditorDescriptor(IPropertyEditorDescriptor descriptor, List<? extends EObject> objectToEdit) {
		Element elementToEdit = retrieveElement(objectToEdit);
		if(elementToEdit == null) {
			return;
		}
		Stereotype stereotype = retrieveStereotype(elementToEdit);

		if(stereotype == null) {
			Activator.log.warn("Impossible to find stereotype: " + getStereotypeName() + " for element: " + elementToEdit);
			return;
		}

		StructuralFeature featureToEdit = retrieveStructuralFeature(elementToEdit, stereotype);

		// test enumeration, reference, etc.
		List<String> values = new ArrayList<String>();

		// check if there is an empty string at the beginning. there is one if the lower bound of the feature to edit equal 0 
		if(featureToEdit.getLower() == 0) {
			values.add("");
		}

		if(featureToEdit.getType() instanceof Enumeration) {
			Enumeration type = ((Enumeration)featureToEdit.getType());
			for(EnumerationLiteral literal : type.getOwnedLiterals()) {
				values.add(literal.getName());
			}
		}
		if(descriptor instanceof IBoundedValuesPropertyEditorDescriptor) {
			((IBoundedValuesPropertyEditorDescriptor)descriptor).setAvailableValues(values);
		} else {
			Activator.log.warn("Warning: " + descriptor + "could not be completed.");
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
			Activator.log.error("Impossible during creation operation to find the editing domain for objects: " + objectsToEdit, null);
			return null;
		}
		int indexOfNewValue = NEW_VALUE_NOT_SET_INDEX;
		CompositeTransactionalCommand command = new CompositeTransactionalCommand(editingDomain, "Create new Enumeration Value");
		for(EObject objectToEdit : objectsToEdit) {
			EStructuralFeature featureToEdit = getFeatureByName(objectToEdit);
			if(featureToEdit == null) {
				return null;
			}
			CreateEnumerationStereotypeValueOperation operation = new CreateEnumerationStereotypeValueOperation(editingDomain, "Create new Enumeration Value", objectToEdit);
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
	 * Operation to create a Enumeration value for the controlled property of a stererotype
	 */
	protected class CreateEnumerationStereotypeValueOperation extends AbstractTransactionalCommand {

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
		public CreateEnumerationStereotypeValueOperation(TransactionalEditingDomain domain, String label, EObject objectToEdit) {
			super(domain, (label == null) ? "" : label, null);
			this.objectToEdit = objectToEdit;

			EStructuralFeature featureToEdit = getFeatureByName(objectToEdit);
			if(featureToEdit.getUpperBound() == 1) {
				indexOfNewValue = -1;
			} else {
				@SuppressWarnings("unchecked")
				List<Object> values = new ArrayList<Object>((List<Object>)getValueToEdit(objectToEdit));
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
				List<Object> values = new ArrayList<Object>((List<Object>)getValueToEdit(objectToEdit));
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
				EClassifier eClassifier = featureToEdit.getEType();
				if(eClassifier instanceof EEnum) {
					return ((EEnum)eClassifier).getDefaultValue();
				}
			}
			Activator.log.error("Impossible to find a default value", null);
			return null;
		}
	}
}
