/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin Cedric.dumoulin@lifl.fr
 ******************************************************************************/
/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.Type;
import org.eclipse.papyrus.layers.stackmodel.layers.TypeRegistry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Registry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.TypeRegistryImpl#getTypes <em>Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeRegistryImpl extends MinimalEObjectImpl.Container implements TypeRegistry {
	/**
	 * The cached value of the '{@link #getTypes() <em>Types</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypes()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, Type> types;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected TypeRegistryImpl() {
		super();
		init();
	}

	/**
	 * Init the Registry.
	 * Register standard types.
	 */
	protected void init() {
		
		Type type = LayersFactory.eINSTANCE.createBooleanType();
		getTypes().put(type.getName(), type);
		
		type = LayersFactory.eINSTANCE.createIntType();
		getTypes().put(type.getName(), type);
		
		type = LayersFactory.eINSTANCE.createStringType();
		getTypes().put(type.getName(), type);
		
		addType(LayersFactory.eINSTANCE.createColor());
		addType(LayersFactory.eINSTANCE.createFill());
		addType(LayersFactory.eINSTANCE.createLineType());
		addType(LayersFactory.eINSTANCE.createFontType());
	}
	
	/**
	 * Add the type in the registry
	 * @param type
	 */
	public void addType(Type type) {
		String typeName = type.getName();
		
		getTypes().put(typeName, type);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.TYPE_REGISTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, Type> getTypes() {
		if (types == null) {
			types = new EcoreEMap<String,Type>(LayersPackage.Literals.STRING_TO_TYPE_MAP, StringToTypeMapImpl.class, this, LayersPackage.TYPE_REGISTRY__TYPES);
		}
		return types;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LayersPackage.TYPE_REGISTRY__TYPES:
				return ((InternalEList<?>)getTypes()).basicRemove(otherEnd, msgs);
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
			case LayersPackage.TYPE_REGISTRY__TYPES:
				if (coreType) return getTypes();
				else return getTypes().map();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LayersPackage.TYPE_REGISTRY__TYPES:
				((EStructuralFeature.Setting)getTypes()).set(newValue);
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
			case LayersPackage.TYPE_REGISTRY__TYPES:
				getTypes().clear();
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
			case LayersPackage.TYPE_REGISTRY__TYPES:
				return types != null && !types.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TypeRegistryImpl
