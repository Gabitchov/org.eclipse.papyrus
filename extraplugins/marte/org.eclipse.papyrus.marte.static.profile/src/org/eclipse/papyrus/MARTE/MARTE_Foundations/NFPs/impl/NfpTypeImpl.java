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
package org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.TupleTypeImpl;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NFPsPackage;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NfpType;
import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Nfp Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.NfpTypeImpl#getValueAttrib <em>Value Attrib</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.NfpTypeImpl#getUnitAttrib <em>Unit Attrib</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.NfpTypeImpl#getExprAttrib <em>Expr Attrib</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NfpTypeImpl extends TupleTypeImpl implements NfpType {
	/**
	 * The cached value of the '{@link #getValueAttrib() <em>Value Attrib</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueAttrib()
	 * @generated
	 * @ordered
	 */
	protected Property valueAttrib;

	/**
	 * The cached value of the '{@link #getUnitAttrib() <em>Unit Attrib</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitAttrib()
	 * @generated
	 * @ordered
	 */
	protected Property unitAttrib;

	/**
	 * The cached value of the '{@link #getExprAttrib() <em>Expr Attrib</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExprAttrib()
	 * @generated
	 * @ordered
	 */
	protected Property exprAttrib;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NfpTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NFPsPackage.Literals.NFP_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getValueAttrib() {
		if (valueAttrib != null && valueAttrib.eIsProxy()) {
			InternalEObject oldValueAttrib = (InternalEObject)valueAttrib;
			valueAttrib = (Property)eResolveProxy(oldValueAttrib);
			if (valueAttrib != oldValueAttrib) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NFPsPackage.NFP_TYPE__VALUE_ATTRIB, oldValueAttrib, valueAttrib));
			}
		}
		return valueAttrib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetValueAttrib() {
		return valueAttrib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueAttrib(Property newValueAttrib) {
		Property oldValueAttrib = valueAttrib;
		valueAttrib = newValueAttrib;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NFPsPackage.NFP_TYPE__VALUE_ATTRIB, oldValueAttrib, valueAttrib));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getUnitAttrib() {
		if (unitAttrib != null && unitAttrib.eIsProxy()) {
			InternalEObject oldUnitAttrib = (InternalEObject)unitAttrib;
			unitAttrib = (Property)eResolveProxy(oldUnitAttrib);
			if (unitAttrib != oldUnitAttrib) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NFPsPackage.NFP_TYPE__UNIT_ATTRIB, oldUnitAttrib, unitAttrib));
			}
		}
		return unitAttrib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetUnitAttrib() {
		return unitAttrib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitAttrib(Property newUnitAttrib) {
		Property oldUnitAttrib = unitAttrib;
		unitAttrib = newUnitAttrib;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NFPsPackage.NFP_TYPE__UNIT_ATTRIB, oldUnitAttrib, unitAttrib));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getExprAttrib() {
		if (exprAttrib != null && exprAttrib.eIsProxy()) {
			InternalEObject oldExprAttrib = (InternalEObject)exprAttrib;
			exprAttrib = (Property)eResolveProxy(oldExprAttrib);
			if (exprAttrib != oldExprAttrib) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NFPsPackage.NFP_TYPE__EXPR_ATTRIB, oldExprAttrib, exprAttrib));
			}
		}
		return exprAttrib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetExprAttrib() {
		return exprAttrib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExprAttrib(Property newExprAttrib) {
		Property oldExprAttrib = exprAttrib;
		exprAttrib = newExprAttrib;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NFPsPackage.NFP_TYPE__EXPR_ATTRIB, oldExprAttrib, exprAttrib));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NFPsPackage.NFP_TYPE__VALUE_ATTRIB:
				if (resolve) return getValueAttrib();
				return basicGetValueAttrib();
			case NFPsPackage.NFP_TYPE__UNIT_ATTRIB:
				if (resolve) return getUnitAttrib();
				return basicGetUnitAttrib();
			case NFPsPackage.NFP_TYPE__EXPR_ATTRIB:
				if (resolve) return getExprAttrib();
				return basicGetExprAttrib();
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
			case NFPsPackage.NFP_TYPE__VALUE_ATTRIB:
				setValueAttrib((Property)newValue);
				return;
			case NFPsPackage.NFP_TYPE__UNIT_ATTRIB:
				setUnitAttrib((Property)newValue);
				return;
			case NFPsPackage.NFP_TYPE__EXPR_ATTRIB:
				setExprAttrib((Property)newValue);
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
			case NFPsPackage.NFP_TYPE__VALUE_ATTRIB:
				setValueAttrib((Property)null);
				return;
			case NFPsPackage.NFP_TYPE__UNIT_ATTRIB:
				setUnitAttrib((Property)null);
				return;
			case NFPsPackage.NFP_TYPE__EXPR_ATTRIB:
				setExprAttrib((Property)null);
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
			case NFPsPackage.NFP_TYPE__VALUE_ATTRIB:
				return valueAttrib != null;
			case NFPsPackage.NFP_TYPE__UNIT_ATTRIB:
				return unitAttrib != null;
			case NFPsPackage.NFP_TYPE__EXPR_ATTRIB:
				return exprAttrib != null;
		}
		return super.eIsSet(featureID);
	}

} //NfpTypeImpl
