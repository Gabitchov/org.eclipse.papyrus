/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Sara TUCCI (CEA LIST) sara.tucci@cea.fr - Initial API and implementation
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *  David SERVAT (CEA LIST) david.servat@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl.infrastructure.elements.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.eastadl.infrastructure.elements.EAPackageableElement;
import org.eclipse.papyrus.eastadl.infrastructure.elements.ElementsPackage;
import org.eclipse.uml2.uml.PackageableElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EA Packageable Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.infrastructure.elements.impl.EAPackageableElementImpl#getBase_PackageableElement <em>Base Packageable Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class EAPackageableElementImpl extends EAElementImpl implements EAPackageableElement {
	/**
	 * The cached value of the '{@link #getBase_PackageableElement() <em>Base Packageable Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_PackageableElement()
	 * @generated
	 * @ordered
	 */
	protected PackageableElement base_PackageableElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EAPackageableElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ElementsPackage.Literals.EA_PACKAGEABLE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageableElement getBase_PackageableElement() {
		if (base_PackageableElement != null && base_PackageableElement.eIsProxy()) {
			InternalEObject oldBase_PackageableElement = (InternalEObject)base_PackageableElement;
			base_PackageableElement = (PackageableElement)eResolveProxy(oldBase_PackageableElement);
			if (base_PackageableElement != oldBase_PackageableElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ElementsPackage.EA_PACKAGEABLE_ELEMENT__BASE_PACKAGEABLE_ELEMENT, oldBase_PackageableElement, base_PackageableElement));
			}
		}
		return base_PackageableElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageableElement basicGetBase_PackageableElement() {
		return base_PackageableElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_PackageableElement(PackageableElement newBase_PackageableElement) {
		PackageableElement oldBase_PackageableElement = base_PackageableElement;
		base_PackageableElement = newBase_PackageableElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementsPackage.EA_PACKAGEABLE_ELEMENT__BASE_PACKAGEABLE_ELEMENT, oldBase_PackageableElement, base_PackageableElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ElementsPackage.EA_PACKAGEABLE_ELEMENT__BASE_PACKAGEABLE_ELEMENT:
				if (resolve) return getBase_PackageableElement();
				return basicGetBase_PackageableElement();
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
			case ElementsPackage.EA_PACKAGEABLE_ELEMENT__BASE_PACKAGEABLE_ELEMENT:
				setBase_PackageableElement((PackageableElement)newValue);
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
			case ElementsPackage.EA_PACKAGEABLE_ELEMENT__BASE_PACKAGEABLE_ELEMENT:
				setBase_PackageableElement((PackageableElement)null);
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
			case ElementsPackage.EA_PACKAGEABLE_ELEMENT__BASE_PACKAGEABLE_ELEMENT:
				return base_PackageableElement != null;
		}
		return super.eIsSet(featureID);
	}

} //EAPackageableElementImpl
