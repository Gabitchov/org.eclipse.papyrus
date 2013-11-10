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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.NotFoundException;
import org.eclipse.papyrus.layers.stackmodel.layers.AbstractLayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.DefaultPropertyOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptor;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptorRegistry;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.Property;
import org.eclipse.papyrus.layers.stackmodel.layers.PropertyOperator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Layer Operator Descriptor Registry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerOperatorDescriptorRegistryImpl#getDescriptors <em>Descriptors</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerOperatorDescriptorRegistryImpl#getPropertyOperators <em>Property Operators</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerOperatorDescriptorRegistryImpl#getPropertyCollectionSize <em>Property Collection Size</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerOperatorDescriptorRegistryImpl#getDefaultOperator <em>Default Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LayerOperatorDescriptorRegistryImpl extends MinimalEObjectImpl.Container implements LayerOperatorDescriptorRegistry {
	/**
	 * The cached value of the '{@link #getDescriptors() <em>Descriptors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptors()
	 * @generated
	 * @ordered
	 */
	protected EList<LayerOperatorDescriptor> descriptors;

	/**
	 * The cached value of the '{@link #getPropertyOperators() <em>Property Operators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyOperators()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertyOperator> propertyOperators;

	/**
	 * The default value of the '{@link #getPropertyCollectionSize() <em>Property Collection Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyCollectionSize()
	 * @generated
	 * @ordered
	 */
	protected static final int PROPERTY_COLLECTION_SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPropertyCollectionSize() <em>Property Collection Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyCollectionSize()
	 * @generated
	 * @ordered
	 */
	protected int propertyCollectionSize = PROPERTY_COLLECTION_SIZE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDefaultOperator() <em>Default Operator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultOperator()
	 * @generated
	 * @ordered
	 */
	protected DefaultPropertyOperator defaultOperator;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected LayerOperatorDescriptorRegistryImpl() {
		super();
		// Set the defaultOperator
		defaultOperator = LayersFactory.eINSTANCE.createDefaultPropertyOperator();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.LAYER_OPERATOR_DESCRIPTOR_REGISTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LayerOperatorDescriptor> getDescriptors() {
		if (descriptors == null) {
			descriptors = new EObjectContainmentEList<LayerOperatorDescriptor>(LayerOperatorDescriptor.class, this, LayersPackage.LAYER_OPERATOR_DESCRIPTOR_REGISTRY__DESCRIPTORS);
		}
		return descriptors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropertyOperator> getPropertyOperators() {
		if (propertyOperators == null) {
			propertyOperators = new EObjectContainmentEList<PropertyOperator>(PropertyOperator.class, this, LayersPackage.LAYER_OPERATOR_DESCRIPTOR_REGISTRY__PROPERTY_OPERATORS);
		}
		return propertyOperators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPropertyCollectionSize() {
		return propertyCollectionSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setPropertyCollectionSize(int newPropertyCollectionSize) {
		int oldPropertyCollectionSize = propertyCollectionSize;
		propertyCollectionSize = newPropertyCollectionSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.LAYER_OPERATOR_DESCRIPTOR_REGISTRY__PROPERTY_COLLECTION_SIZE, oldPropertyCollectionSize, propertyCollectionSize));
		
		// Propagate the size to registered LayerOperator
		if( newPropertyCollectionSize>oldPropertyCollectionSize) {
			for( LayerOperatorDescriptor descriptor : getDescriptors() ) {
				descriptor.setPropertyCollectionSize(newPropertyCollectionSize, getDefaultOperator());
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultPropertyOperator getDefaultOperator() {
		if (defaultOperator != null && defaultOperator.eIsProxy()) {
			InternalEObject oldDefaultOperator = (InternalEObject)defaultOperator;
			defaultOperator = (DefaultPropertyOperator)eResolveProxy(oldDefaultOperator);
			if (defaultOperator != oldDefaultOperator) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LayersPackage.LAYER_OPERATOR_DESCRIPTOR_REGISTRY__DEFAULT_OPERATOR, oldDefaultOperator, defaultOperator));
			}
		}
		return defaultOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultPropertyOperator basicGetDefaultOperator() {
		return defaultOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addLayerOperatorDescriptor(LayerOperatorDescriptor descriptor) {

		// Ensure descriptor size
		descriptor.setPropertyCollectionSize(getPropertyCollectionSize(), getDefaultOperator());
		// Add descriptor
		getDescriptors().add(descriptor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public LayerOperatorDescriptor getLayerOperatorDescriptor(String name) throws NotFoundException {
		if(name == null) {
			throw new NotFoundException("Can't find LayerOperatorDescriptor for name 'null'.");
		}
		for( LayerOperatorDescriptor descriptor : getDescriptors() ) {
			if( name.equals(descriptor.getName())) {
				return descriptor;
			}
		}
		// Not found
		throw new NotFoundException("Can't find LayerOperatorDescriptor for name '" + name + "'.");
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addPropertyOperator(PropertyOperator operator) {
		getPropertyOperators().add(operator);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PropertyOperator getPropertyOperator(String name) throws NotFoundException {
		
		if(name == null) {
			throw new NotFoundException("Can't find PropertyOperator for name 'null'.");
		}
		for( PropertyOperator op : getPropertyOperators() ) {
			if( name.equals(op.getName())) {
				return op;
			}
		}
		// Not found
		throw new NotFoundException("Can't find PropertyOperator for name '" + name + "'.");
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws NotFoundException 
	 * @generated NOT
	 */
	public void attachOperatorToDescriptor(Property property, String operatorName, String layerDescriptorName) throws NotFoundException {

		// Ensure that PropertiesCollectionSize can contain the property index.
		if( getPropertyCollectionSize() <= property.getIndex()) {
			setPropertyCollectionSize(property.getIndex());
		}

		// Attach the operator to the LayerOperator
		PropertyOperator op = getPropertyOperator(operatorName);
		LayerOperatorDescriptor layerOp = getLayerOperatorDescriptor(layerDescriptorName);
		
		layerOp.setPropertyOperator(property, op);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AbstractLayerOperator createLayerOperator(String layerOperatorID) throws LayersException {
		
		LayerOperatorDescriptor desc = getLayerOperatorDescriptor(layerOperatorID);
		
		AbstractLayerOperator newLayerOperator = desc.createLayerOperator();
	
//		newLayerOperator.setApplication();
		return newLayerOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR_REGISTRY__DESCRIPTORS:
				return ((InternalEList<?>)getDescriptors()).basicRemove(otherEnd, msgs);
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR_REGISTRY__PROPERTY_OPERATORS:
				return ((InternalEList<?>)getPropertyOperators()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR_REGISTRY__DESCRIPTORS:
				return getDescriptors();
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR_REGISTRY__PROPERTY_OPERATORS:
				return getPropertyOperators();
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR_REGISTRY__PROPERTY_COLLECTION_SIZE:
				return getPropertyCollectionSize();
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR_REGISTRY__DEFAULT_OPERATOR:
				if (resolve) return getDefaultOperator();
				return basicGetDefaultOperator();
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
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR_REGISTRY__DESCRIPTORS:
				getDescriptors().clear();
				getDescriptors().addAll((Collection<? extends LayerOperatorDescriptor>)newValue);
				return;
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR_REGISTRY__PROPERTY_OPERATORS:
				getPropertyOperators().clear();
				getPropertyOperators().addAll((Collection<? extends PropertyOperator>)newValue);
				return;
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR_REGISTRY__PROPERTY_COLLECTION_SIZE:
				setPropertyCollectionSize((Integer)newValue);
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
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR_REGISTRY__DESCRIPTORS:
				getDescriptors().clear();
				return;
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR_REGISTRY__PROPERTY_OPERATORS:
				getPropertyOperators().clear();
				return;
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR_REGISTRY__PROPERTY_COLLECTION_SIZE:
				setPropertyCollectionSize(PROPERTY_COLLECTION_SIZE_EDEFAULT);
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
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR_REGISTRY__DESCRIPTORS:
				return descriptors != null && !descriptors.isEmpty();
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR_REGISTRY__PROPERTY_OPERATORS:
				return propertyOperators != null && !propertyOperators.isEmpty();
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR_REGISTRY__PROPERTY_COLLECTION_SIZE:
				return propertyCollectionSize != PROPERTY_COLLECTION_SIZE_EDEFAULT;
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR_REGISTRY__DEFAULT_OPERATOR:
				return defaultOperator != null;
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
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR_REGISTRY___ADD_LAYER_OPERATOR_DESCRIPTOR__LAYEROPERATORDESCRIPTOR:
				addLayerOperatorDescriptor((LayerOperatorDescriptor)arguments.get(0));
				return null;
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR_REGISTRY___GET_LAYER_OPERATOR_DESCRIPTOR__STRING:
				try {
					return getLayerOperatorDescriptor((String)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR_REGISTRY___ADD_PROPERTY_OPERATOR__PROPERTYOPERATOR:
				addPropertyOperator((PropertyOperator)arguments.get(0));
				return null;
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR_REGISTRY___GET_PROPERTY_OPERATOR__STRING:
				try {
					return getPropertyOperator((String)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR_REGISTRY___ATTACH_OPERATOR_TO_DESCRIPTOR__PROPERTY_STRING_STRING:
				try {
					attachOperatorToDescriptor((Property)arguments.get(0), (String)arguments.get(1), (String)arguments.get(2));
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR_REGISTRY___CREATE_LAYER_OPERATOR__STRING:
				try {
					return createLayerOperator((String)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
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
		result.append(" (propertyCollectionSize: ");
		result.append(propertyCollectionSize);
		result.append(')');
		return result.toString();
	}

} //LayerOperatorDescriptorRegistryImpl
