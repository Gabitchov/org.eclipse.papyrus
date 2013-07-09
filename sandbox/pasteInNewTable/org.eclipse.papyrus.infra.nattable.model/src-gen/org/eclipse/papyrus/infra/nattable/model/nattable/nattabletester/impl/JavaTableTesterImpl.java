/**
 * Copyright (c) 2013 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.nattable.model.nattable.nattabletester.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattabletester.JavaTableTester;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattabletester.NattabletesterPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Java Table Tester</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattabletester.impl.JavaTableTesterImpl#getTester <em>Tester</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JavaTableTesterImpl extends AbstractTableTesterImpl implements JavaTableTester {

	/**
	 * The default value of the '{@link #getTester() <em>Tester</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTester()
	 * @generated
	 * @ordered
	 */
	protected static final String TESTER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTester() <em>Tester</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTester()
	 * @generated
	 * @ordered
	 */
	protected String tester = TESTER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JavaTableTesterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NattabletesterPackage.Literals.JAVA_TABLE_TESTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTester() {
		return tester;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTester(String newTester) {
		String oldTester = tester;
		tester = newTester;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattabletesterPackage.JAVA_TABLE_TESTER__TESTER, oldTester, tester));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NattabletesterPackage.JAVA_TABLE_TESTER__TESTER:
				return getTester();
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
			case NattabletesterPackage.JAVA_TABLE_TESTER__TESTER:
				setTester((String)newValue);
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
			case NattabletesterPackage.JAVA_TABLE_TESTER__TESTER:
				setTester(TESTER_EDEFAULT);
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
			case NattabletesterPackage.JAVA_TABLE_TESTER__TESTER:
				return TESTER_EDEFAULT == null ? tester != null : !TESTER_EDEFAULT.equals(tester);
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
		result.append(" (tester: "); //$NON-NLS-1$
		result.append(tester);
		result.append(')');
		return result.toString();
	}

} //JavaTableTesterImpl
