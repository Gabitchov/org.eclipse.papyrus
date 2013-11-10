/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin - cedric.dumoulin@lifl.fr
 ******************************************************************************/
/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.layers.stackmodel.NotFoundException;
import org.eclipse.papyrus.layers.stackmodel.layers.AbstractLayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.DefaultPropertyOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptor;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.Property;
import org.eclipse.papyrus.layers.stackmodel.layers.PropertyOperator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Layer Operator Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerOperatorDescriptorImpl#getPropertyOperators <em>Property Operators</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerOperatorDescriptorImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LayerOperatorDescriptorImpl extends MinimalEObjectImpl.Container implements LayerOperatorDescriptor {

	/**
	 * The cached value of the '{@link #getPropertyOperators() <em>Property Operators</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyOperators()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertyOperator> propertyOperators;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LayerOperatorDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.LAYER_OPERATOR_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<PropertyOperator> getPropertyOperators() {
		if (propertyOperators == null) {
			propertyOperators = new EObjectResolvingEList<PropertyOperator>(PropertyOperator.class, this, LayersPackage.LAYER_OPERATOR_DESCRIPTOR__PROPERTY_OPERATORS) {
				// Allows double
				@Override
				protected boolean isUnique() {
					return false;
				}

			};
		}
		return propertyOperators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.LAYER_OPERATOR_DESCRIPTOR__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PropertyOperator getPropertyOperator(Property property) throws NotFoundException {
		try {
			return getPropertyOperators().get(property.getIndex());
		} catch (IndexOutOfBoundsException e) {
			throw new NotFoundException("Can't find operator for property '" + property.getName()+ "' at index " + property.getIndex());
		}
	}

	/**
	 * Set the operator at the property's index.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setPropertyOperator(Property property, PropertyOperator operator) {

		// Set the operator at the property's index.
		getPropertyOperators().set(property.getIndex(), operator);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractLayerOperator createLayerOperator() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * Initialize all list indexed by Properties'index.
	 * Increase the actual list in order that they can contains the specified number of properties.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setPropertyCollectionSize(int size, DefaultPropertyOperator defaultPropertyOperator) {

		List<PropertyOperator> operators = getPropertyOperators();
		int actualSize = operators.size();
		// Check if we need to increase the size.
		if( actualSize>=size) {
			// do nothing
			return;
		}

		// Add missing elements
		for (int i=actualSize; i<size; i++) {
			operators.add(defaultPropertyOperator);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR__PROPERTY_OPERATORS:
				return getPropertyOperators();
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR__NAME:
				return getName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR__PROPERTY_OPERATORS:
				getPropertyOperators().clear();
				getPropertyOperators().addAll((Collection<? extends PropertyOperator>)newValue);
				return;
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR__NAME:
				setName((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR__PROPERTY_OPERATORS:
				getPropertyOperators().clear();
				return;
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR__NAME:
				setName(NAME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR__PROPERTY_OPERATORS:
				return propertyOperators != null && !propertyOperators.isEmpty();
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR___GET_PROPERTY_OPERATOR__PROPERTY:
				try {
					return getPropertyOperator((Property)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR___SET_PROPERTY_OPERATOR__PROPERTY_PROPERTYOPERATOR:
				setPropertyOperator((Property)arguments.get(0), (PropertyOperator)arguments.get(1));
				return null;
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR___CREATE_LAYER_OPERATOR:
				return createLayerOperator();
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR___SET_PROPERTY_COLLECTION_SIZE__INT_DEFAULTPROPERTYOPERATOR:
				setPropertyCollectionSize((Integer)arguments.get(0), (DefaultPropertyOperator)arguments.get(1));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //LayerOperatorDescriptorImpl
