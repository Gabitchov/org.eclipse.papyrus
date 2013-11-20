/**
 * Copyright (c) 2013 CEA LIST
 * 
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    CEA LIST - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.C_Cpp.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.papyrus.C_Cpp.C_CppPackage;
import org.eclipse.papyrus.C_Cpp.CppInit;

import org.eclipse.uml2.uml.EnumerationLiteral;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cpp Init</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.impl.CppInitImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.impl.CppInitImpl#getBase_enumerationliteral <em>Base enumerationliteral</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CppInitImpl extends EObjectImpl implements CppInit {
	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final int VALUE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected int value = VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_enumerationliteral() <em>Base enumerationliteral</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_enumerationliteral()
	 * @generated
	 * @ordered
	 */
	protected EnumerationLiteral base_enumerationliteral;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CppInitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return C_CppPackage.Literals.CPP_INIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(int newValue) {
		int oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, C_CppPackage.CPP_INIT__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationLiteral getBase_enumerationliteral() {
		if (base_enumerationliteral != null && base_enumerationliteral.eIsProxy()) {
			InternalEObject oldBase_enumerationliteral = (InternalEObject)base_enumerationliteral;
			base_enumerationliteral = (EnumerationLiteral)eResolveProxy(oldBase_enumerationliteral);
			if (base_enumerationliteral != oldBase_enumerationliteral) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, C_CppPackage.CPP_INIT__BASE_ENUMERATIONLITERAL, oldBase_enumerationliteral, base_enumerationliteral));
			}
		}
		return base_enumerationliteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationLiteral basicGetBase_enumerationliteral() {
		return base_enumerationliteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_enumerationliteral(EnumerationLiteral newBase_enumerationliteral) {
		EnumerationLiteral oldBase_enumerationliteral = base_enumerationliteral;
		base_enumerationliteral = newBase_enumerationliteral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, C_CppPackage.CPP_INIT__BASE_ENUMERATIONLITERAL, oldBase_enumerationliteral, base_enumerationliteral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case C_CppPackage.CPP_INIT__VALUE:
				return getValue();
			case C_CppPackage.CPP_INIT__BASE_ENUMERATIONLITERAL:
				if (resolve) return getBase_enumerationliteral();
				return basicGetBase_enumerationliteral();
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
			case C_CppPackage.CPP_INIT__VALUE:
				setValue((Integer)newValue);
				return;
			case C_CppPackage.CPP_INIT__BASE_ENUMERATIONLITERAL:
				setBase_enumerationliteral((EnumerationLiteral)newValue);
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
			case C_CppPackage.CPP_INIT__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case C_CppPackage.CPP_INIT__BASE_ENUMERATIONLITERAL:
				setBase_enumerationliteral((EnumerationLiteral)null);
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
			case C_CppPackage.CPP_INIT__VALUE:
				return value != VALUE_EDEFAULT;
			case C_CppPackage.CPP_INIT__BASE_ENUMERATIONLITERAL:
				return base_enumerationliteral != null;
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
		result.append(" (value: "); //$NON-NLS-1$
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //CppInitImpl
