/**
 *  Copyright (c) 2011 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 * 	Gregoire Dupe (Mia-Software) - Design
 * 	Nicolas Guyomar (Mia-Software) - Implementation
 * 	Emmanuelle RouillÃ© (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values. 
 * 	Nicolas Bros (Mia-Software) - Bug 361823 - [Restructuring] eFacet2 meta-model
 */
package org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.AbstractAttributeInstance;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SerializationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Attribute Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.AbstractAttributeInstanceImpl#getEAttribute <em>EAttribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AbstractAttributeInstanceImpl extends EObjectImpl implements AbstractAttributeInstance {
	/**
	 * The cached value of the '{@link #getEAttribute() <em>EAttribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEAttribute()
	 * @generated
	 * @ordered
	 */
	protected EAttribute eAttribute;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractAttributeInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SerializationPackage.Literals.ABSTRACT_ATTRIBUTE_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAttribute() {
		if (eAttribute != null && eAttribute.eIsProxy()) {
			InternalEObject oldEAttribute = (InternalEObject)eAttribute;
			eAttribute = (EAttribute)eResolveProxy(oldEAttribute);
			if (eAttribute != oldEAttribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SerializationPackage.ABSTRACT_ATTRIBUTE_INSTANCE__EATTRIBUTE, oldEAttribute, eAttribute));
			}
		}
		return eAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute basicGetEAttribute() {
		return eAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEAttribute(EAttribute newEAttribute) {
		EAttribute oldEAttribute = eAttribute;
		eAttribute = newEAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SerializationPackage.ABSTRACT_ATTRIBUTE_INSTANCE__EATTRIBUTE, oldEAttribute, eAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SerializationPackage.ABSTRACT_ATTRIBUTE_INSTANCE__EATTRIBUTE:
				if (resolve) return getEAttribute();
				return basicGetEAttribute();
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
			case SerializationPackage.ABSTRACT_ATTRIBUTE_INSTANCE__EATTRIBUTE:
				setEAttribute((EAttribute)newValue);
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
			case SerializationPackage.ABSTRACT_ATTRIBUTE_INSTANCE__EATTRIBUTE:
				setEAttribute((EAttribute)null);
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
			case SerializationPackage.ABSTRACT_ATTRIBUTE_INSTANCE__EATTRIBUTE:
				return eAttribute != null;
		}
		return super.eIsSet(featureID);
	}

} //AbstractAttributeInstanceImpl
