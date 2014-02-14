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

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.MultiValuedContainmentReferenceInstance;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SerializationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multi Valued Containment Reference Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.MultiValuedContainmentReferenceInstanceImpl#getOwnedElements <em>Owned Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MultiValuedContainmentReferenceInstanceImpl extends AbstractReferenceInstanceImpl implements MultiValuedContainmentReferenceInstance {
	/**
	 * The cached value of the '{@link #getOwnedElements() <em>Owned Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedElements()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> ownedElements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiValuedContainmentReferenceInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SerializationPackage.Literals.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getOwnedElements() {
		if (ownedElements == null) {
			ownedElements = new EObjectContainmentEList<EObject>(EObject.class, this, SerializationPackage.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS);
		}
		return ownedElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SerializationPackage.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS:
				return ((InternalEList<?>)getOwnedElements()).basicRemove(otherEnd, msgs);
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
			case SerializationPackage.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS:
				return getOwnedElements();
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
			case SerializationPackage.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS:
				getOwnedElements().clear();
				getOwnedElements().addAll((Collection<? extends EObject>)newValue);
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
			case SerializationPackage.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS:
				getOwnedElements().clear();
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
			case SerializationPackage.MULTI_VALUED_CONTAINMENT_REFERENCE_INSTANCE__OWNED_ELEMENTS:
				return ownedElements != null && !ownedElements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MultiValuedContainmentReferenceInstanceImpl
