/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.properties.modelelement;

import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.ValueDiff;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * An observable value for manipulating reflective properties
 * (Based on a key/value pair). The modifications are based on EMF
 * commands.
 * 
 * @see GenericAttributeModelElement
 * 
 * @author Camille Letavernier
 */
public class GenericAttributeObservable extends AbstractObservableValue {

	private EObject source;

	private EditingDomain domain;

	private EStructuralFeature createIn;

	private EFactory createFrom;

	private EClass createAsValue;

	private EClass createAsReference;

	private String propertyPath;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param source
	 *        The EObject being edited
	 * @param domain
	 *        The Editing domain on which the commands will be executed
	 * @param createIn
	 *        The Feature in which the value will be set
	 * @param createFrom
	 *        The Factory used to instantiate the new value
	 * @param createAsValue
	 *        The EClass that will be instantiated for the new value, if it is an attribute
	 * @param createAsReference
	 *        The EClass that will be instantiated for the new value, if it is a reference
	 * @param propertyPath
	 *        The value of the "name" attribute (Which is the "key" of the property)
	 */
	public GenericAttributeObservable(EObject source, EditingDomain domain, EStructuralFeature createIn, EFactory createFrom, EClass createAsValue, EClass createAsReference, String propertyPath) {
		this.source = source;
		this.domain = domain;
		this.createIn = createIn;
		this.createFrom = createFrom;
		this.createAsValue = createAsValue;
		this.createAsReference = createAsReference;
		this.propertyPath = propertyPath;
	}

	public Object getValueType() {
		return Object.class;
	}

	@Override
	protected Object doGetValue() {
		EObject attribute = findAttribute();
		if(attribute == null) {
			return null;
		}
		Object result = attribute.eGet(attribute.eClass().getEStructuralFeature("value")); //$NON-NLS-1$
		return result;
	}

	/**
	 * Browse the existing attributes in the given feature, and returns the
	 * one with the same name, if it exists, or null otherwise.
	 * 
	 * @return The attribute being edited, if it already exists, or null otherwise
	 */
	@SuppressWarnings("unchecked")
	protected EObject findAttribute() {
		EList<? extends EObject> allAttributes = (EList<? extends EObject>)source.eGet(createIn);
		for(EObject attribute : allAttributes) {
			if(createAsValue.isInstance(attribute) || createAsReference.isInstance(attribute)) {
				if(attribute.eGet(attribute.eClass().getEStructuralFeature("name")).equals(propertyPath)) { //$NON-NLS-1$
					return attribute;
				}
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void doSetValue(final Object value) {
		final Object oldValue = doGetValue();

		if(value != null && value.equals(oldValue)) {
			return;
		}

		EObject attribute = findAttribute();
		EList<? extends EObject> collection = (EList<? extends EObject>)source.eGet(createIn);

		CompoundCommand command = new CompoundCommand(String.format("Set %s value", propertyPath)) {

			@Override
			public boolean prepare() {
				//Only test the first command's canExecute(), as the following ones depend on the execution of the first one
				//Can we use a StrictCompoundCommand here ? 
				if(commandList.isEmpty()) {
					return true;
				}
				return commandList.get(0).canExecute();
			}
		};

		if(value == null || value.equals("")) { //$NON-NLS-1$
			if(attribute != null) {
				RemoveCommand rCommand = new RemoveCommand(domain, collection, attribute);
				command.append(rCommand);
			}
		} else {
			if(attribute == null) {
				if(value instanceof String) {
					attribute = createFrom.create(createAsValue);
				} else {
					attribute = createFrom.create(createAsReference);
				}

				CreateChildCommand crCommand = new CreateChildCommand(domain, source, createIn, attribute, null);
				command.append(crCommand);

				EStructuralFeature feature = attribute.eClass().getEStructuralFeature("name"); //$NON-NLS-1$

				SetCommand setCommand = new SetCommand(domain, attribute, feature, propertyPath);

				command.append(setCommand);
			}

			EStructuralFeature feature = attribute.eClass().getEStructuralFeature("value"); //$NON-NLS-1$

			SetCommand setCommand = new SetCommand(domain, attribute, feature, value);
			command.append(setCommand);
		}

		domain.getCommandStack().execute(command);

		ValueDiff diff = new ValueDiff() {

			@Override
			public Object getOldValue() {
				return oldValue;
			}

			@Override
			public Object getNewValue() {
				return value;
			}
		};

		fireValueChange(diff);
	}

	@Override
	protected void fireValueChange(ValueDiff diff) {
		super.fireValueChange(diff);
	}

	@Override
	protected void fireChange() {
		super.fireChange();
	}

}
