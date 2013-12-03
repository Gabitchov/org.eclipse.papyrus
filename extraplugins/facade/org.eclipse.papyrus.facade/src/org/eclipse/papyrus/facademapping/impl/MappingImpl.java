/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.facademapping.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.facademapping.FacademappingPackage;
import org.eclipse.papyrus.facademapping.Mapping;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.facademapping.impl.MappingImpl#getUmlElement <em>Uml Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facademapping.impl.MappingImpl#getSpecificDomainElement <em>Specific Domain Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingImpl extends MinimalEObjectImpl.Container implements Mapping {
	/**
	 * The cached value of the '{@link #getUmlElement() <em>Uml Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUmlElement()
	 * @generated
	 * @ordered
	 */
	protected EObject umlElement;

	/**
	 * The cached value of the '{@link #getSpecificDomainElement() <em>Specific Domain Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecificDomainElement()
	 * @generated
	 * @ordered
	 */
	protected EObject specificDomainElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FacademappingPackage.Literals.MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getUmlElement() {
		if (umlElement != null && umlElement.eIsProxy()) {
			InternalEObject oldUmlElement = (InternalEObject)umlElement;
			umlElement = eResolveProxy(oldUmlElement);
			if (umlElement != oldUmlElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FacademappingPackage.MAPPING__UML_ELEMENT, oldUmlElement, umlElement));
			}
		}
		return umlElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetUmlElement() {
		return umlElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUmlElement(EObject newUmlElement) {
		EObject oldUmlElement = umlElement;
		umlElement = newUmlElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FacademappingPackage.MAPPING__UML_ELEMENT, oldUmlElement, umlElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getSpecificDomainElement() {
		if (specificDomainElement != null && specificDomainElement.eIsProxy()) {
			InternalEObject oldSpecificDomainElement = (InternalEObject)specificDomainElement;
			specificDomainElement = eResolveProxy(oldSpecificDomainElement);
			if (specificDomainElement != oldSpecificDomainElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FacademappingPackage.MAPPING__SPECIFIC_DOMAIN_ELEMENT, oldSpecificDomainElement, specificDomainElement));
			}
		}
		return specificDomainElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetSpecificDomainElement() {
		return specificDomainElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecificDomainElement(EObject newSpecificDomainElement) {
		EObject oldSpecificDomainElement = specificDomainElement;
		specificDomainElement = newSpecificDomainElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FacademappingPackage.MAPPING__SPECIFIC_DOMAIN_ELEMENT, oldSpecificDomainElement, specificDomainElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FacademappingPackage.MAPPING__UML_ELEMENT:
				if (resolve) return getUmlElement();
				return basicGetUmlElement();
			case FacademappingPackage.MAPPING__SPECIFIC_DOMAIN_ELEMENT:
				if (resolve) return getSpecificDomainElement();
				return basicGetSpecificDomainElement();
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
			case FacademappingPackage.MAPPING__UML_ELEMENT:
				setUmlElement((EObject)newValue);
				return;
			case FacademappingPackage.MAPPING__SPECIFIC_DOMAIN_ELEMENT:
				setSpecificDomainElement((EObject)newValue);
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
			case FacademappingPackage.MAPPING__UML_ELEMENT:
				setUmlElement((EObject)null);
				return;
			case FacademappingPackage.MAPPING__SPECIFIC_DOMAIN_ELEMENT:
				setSpecificDomainElement((EObject)null);
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
			case FacademappingPackage.MAPPING__UML_ELEMENT:
				return umlElement != null;
			case FacademappingPackage.MAPPING__SPECIFIC_DOMAIN_ELEMENT:
				return specificDomainElement != null;
		}
		return super.eIsSet(featureID);
	}

} //MappingImpl
