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
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.infra.extendedtypes.impl.MatcherConfigurationImpl;

import org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration.StereotypedElementMatcherConfiguration;
import org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration.StereotypedElementMatcherConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stereotyped Element Matcher Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration.impl.StereotypedElementMatcherConfigurationImpl#getStereotypedQualifiedName <em>Stereotyped Qualified Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StereotypedElementMatcherConfigurationImpl extends MatcherConfigurationImpl implements StereotypedElementMatcherConfiguration {
	/**
	 * The default value of the '{@link #getStereotypedQualifiedName() <em>Stereotyped Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotypedQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected static final String STEREOTYPED_QUALIFIED_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStereotypedQualifiedName() <em>Stereotyped Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotypedQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected String stereotypedQualifiedName = STEREOTYPED_QUALIFIED_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StereotypedElementMatcherConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StereotypedElementMatcherConfigurationPackage.Literals.STEREOTYPED_ELEMENT_MATCHER_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStereotypedQualifiedName() {
		return stereotypedQualifiedName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStereotypedQualifiedName(String newStereotypedQualifiedName) {
		String oldStereotypedQualifiedName = stereotypedQualifiedName;
		stereotypedQualifiedName = newStereotypedQualifiedName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StereotypedElementMatcherConfigurationPackage.STEREOTYPED_ELEMENT_MATCHER_CONFIGURATION__STEREOTYPED_QUALIFIED_NAME, oldStereotypedQualifiedName, stereotypedQualifiedName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StereotypedElementMatcherConfigurationPackage.STEREOTYPED_ELEMENT_MATCHER_CONFIGURATION__STEREOTYPED_QUALIFIED_NAME:
				return getStereotypedQualifiedName();
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
			case StereotypedElementMatcherConfigurationPackage.STEREOTYPED_ELEMENT_MATCHER_CONFIGURATION__STEREOTYPED_QUALIFIED_NAME:
				setStereotypedQualifiedName((String)newValue);
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
			case StereotypedElementMatcherConfigurationPackage.STEREOTYPED_ELEMENT_MATCHER_CONFIGURATION__STEREOTYPED_QUALIFIED_NAME:
				setStereotypedQualifiedName(STEREOTYPED_QUALIFIED_NAME_EDEFAULT);
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
			case StereotypedElementMatcherConfigurationPackage.STEREOTYPED_ELEMENT_MATCHER_CONFIGURATION__STEREOTYPED_QUALIFIED_NAME:
				return STEREOTYPED_QUALIFIED_NAME_EDEFAULT == null ? stereotypedQualifiedName != null : !STEREOTYPED_QUALIFIED_NAME_EDEFAULT.equals(stereotypedQualifiedName);
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
		result.append(" (stereotypedQualifiedName: ");
		result.append(stereotypedQualifiedName);
		result.append(')');
		return result.toString();
	}

} //StereotypedElementMatcherConfigurationImpl
