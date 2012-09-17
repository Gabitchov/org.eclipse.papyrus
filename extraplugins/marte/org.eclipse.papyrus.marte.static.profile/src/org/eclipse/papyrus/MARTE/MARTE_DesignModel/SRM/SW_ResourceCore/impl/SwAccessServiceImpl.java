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
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_ResourceCore.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_ResourceCore.SW_ResourceCorePackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_ResourceCore.SwAccessService;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GrServiceImpl;
import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sw Access Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_ResourceCore.impl.SwAccessServiceImpl#isIsModifier <em>Is Modifier</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_ResourceCore.impl.SwAccessServiceImpl#getAccessedElement <em>Accessed Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SwAccessServiceImpl extends GrServiceImpl implements SwAccessService {
	/**
	 * The default value of the '{@link #isIsModifier() <em>Is Modifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsModifier()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_MODIFIER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsModifier() <em>Is Modifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsModifier()
	 * @generated
	 * @ordered
	 */
	protected boolean isModifier = IS_MODIFIER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAccessedElement() <em>Accessed Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessedElement()
	 * @generated
	 * @ordered
	 */
	protected Property accessedElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SwAccessServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SW_ResourceCorePackage.Literals.SW_ACCESS_SERVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsModifier() {
		return isModifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsModifier(boolean newIsModifier) {
		boolean oldIsModifier = isModifier;
		isModifier = newIsModifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SW_ResourceCorePackage.SW_ACCESS_SERVICE__IS_MODIFIER, oldIsModifier, isModifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getAccessedElement() {
		if (accessedElement != null && accessedElement.eIsProxy()) {
			InternalEObject oldAccessedElement = (InternalEObject)accessedElement;
			accessedElement = (Property)eResolveProxy(oldAccessedElement);
			if (accessedElement != oldAccessedElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SW_ResourceCorePackage.SW_ACCESS_SERVICE__ACCESSED_ELEMENT, oldAccessedElement, accessedElement));
			}
		}
		return accessedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetAccessedElement() {
		return accessedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccessedElement(Property newAccessedElement) {
		Property oldAccessedElement = accessedElement;
		accessedElement = newAccessedElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SW_ResourceCorePackage.SW_ACCESS_SERVICE__ACCESSED_ELEMENT, oldAccessedElement, accessedElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SW_ResourceCorePackage.SW_ACCESS_SERVICE__IS_MODIFIER:
				return isIsModifier();
			case SW_ResourceCorePackage.SW_ACCESS_SERVICE__ACCESSED_ELEMENT:
				if (resolve) return getAccessedElement();
				return basicGetAccessedElement();
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
			case SW_ResourceCorePackage.SW_ACCESS_SERVICE__IS_MODIFIER:
				setIsModifier((Boolean)newValue);
				return;
			case SW_ResourceCorePackage.SW_ACCESS_SERVICE__ACCESSED_ELEMENT:
				setAccessedElement((Property)newValue);
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
			case SW_ResourceCorePackage.SW_ACCESS_SERVICE__IS_MODIFIER:
				setIsModifier(IS_MODIFIER_EDEFAULT);
				return;
			case SW_ResourceCorePackage.SW_ACCESS_SERVICE__ACCESSED_ELEMENT:
				setAccessedElement((Property)null);
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
			case SW_ResourceCorePackage.SW_ACCESS_SERVICE__IS_MODIFIER:
				return isModifier != IS_MODIFIER_EDEFAULT;
			case SW_ResourceCorePackage.SW_ACCESS_SERVICE__ACCESSED_ELEMENT:
				return accessedElement != null;
		}
		return super.eIsSet(featureID);
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
		result.append(" (isModifier: ");
		result.append(isModifier);
		result.append(')');
		return result.toString();
	}

} //SwAccessServiceImpl
