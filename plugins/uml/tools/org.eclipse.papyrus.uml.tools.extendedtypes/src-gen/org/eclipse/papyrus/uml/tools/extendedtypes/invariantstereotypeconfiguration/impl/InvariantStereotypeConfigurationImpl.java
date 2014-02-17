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
package org.eclipse.papyrus.uml.tools.extendedtypes.invariantstereotypeconfiguration.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl.InvariantRuleConfigurationImpl;
import org.eclipse.papyrus.uml.tools.extendedtypes.invariantstereotypeconfiguration.InvariantStereotypeConfiguration;
import org.eclipse.papyrus.uml.tools.extendedtypes.invariantstereotypeconfiguration.InvariantStereotypeConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invariant Stereotype Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.tools.extendedtypes.invariantstereotypeconfiguration.impl.InvariantStereotypeConfigurationImpl#getStereotypeQualifiedName <em>Stereotype Qualified Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.tools.extendedtypes.invariantstereotypeconfiguration.impl.InvariantStereotypeConfigurationImpl#getRequiredProfile <em>Required Profile</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InvariantStereotypeConfigurationImpl extends InvariantRuleConfigurationImpl implements InvariantStereotypeConfiguration {

	/**
	 * The default value of the '{@link #getStereotypeQualifiedName() <em>Stereotype Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotypeQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected static final String STEREOTYPE_QUALIFIED_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStereotypeQualifiedName() <em>Stereotype Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotypeQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected String stereotypeQualifiedName = STEREOTYPE_QUALIFIED_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getRequiredProfile() <em>Required Profile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredProfile()
	 * @generated
	 * @ordered
	 */
	protected static final String REQUIRED_PROFILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRequiredProfile() <em>Required Profile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredProfile()
	 * @generated
	 * @ordered
	 */
	protected String requiredProfile = REQUIRED_PROFILE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InvariantStereotypeConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InvariantStereotypeConfigurationPackage.Literals.INVARIANT_STEREOTYPE_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStereotypeQualifiedName() {
		return stereotypeQualifiedName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStereotypeQualifiedName(String newStereotypeQualifiedName) {
		String oldStereotypeQualifiedName = stereotypeQualifiedName;
		stereotypeQualifiedName = newStereotypeQualifiedName;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InvariantStereotypeConfigurationPackage.INVARIANT_STEREOTYPE_CONFIGURATION__STEREOTYPE_QUALIFIED_NAME, oldStereotypeQualifiedName, stereotypeQualifiedName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRequiredProfile() {
		return requiredProfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiredProfile(String newRequiredProfile) {
		String oldRequiredProfile = requiredProfile;
		requiredProfile = newRequiredProfile;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InvariantStereotypeConfigurationPackage.INVARIANT_STEREOTYPE_CONFIGURATION__REQUIRED_PROFILE, oldRequiredProfile, requiredProfile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case InvariantStereotypeConfigurationPackage.INVARIANT_STEREOTYPE_CONFIGURATION__STEREOTYPE_QUALIFIED_NAME:
			return getStereotypeQualifiedName();
		case InvariantStereotypeConfigurationPackage.INVARIANT_STEREOTYPE_CONFIGURATION__REQUIRED_PROFILE:
			return getRequiredProfile();
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
		switch(featureID) {
		case InvariantStereotypeConfigurationPackage.INVARIANT_STEREOTYPE_CONFIGURATION__STEREOTYPE_QUALIFIED_NAME:
			setStereotypeQualifiedName((String)newValue);
			return;
		case InvariantStereotypeConfigurationPackage.INVARIANT_STEREOTYPE_CONFIGURATION__REQUIRED_PROFILE:
			setRequiredProfile((String)newValue);
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
		switch(featureID) {
		case InvariantStereotypeConfigurationPackage.INVARIANT_STEREOTYPE_CONFIGURATION__STEREOTYPE_QUALIFIED_NAME:
			setStereotypeQualifiedName(STEREOTYPE_QUALIFIED_NAME_EDEFAULT);
			return;
		case InvariantStereotypeConfigurationPackage.INVARIANT_STEREOTYPE_CONFIGURATION__REQUIRED_PROFILE:
			setRequiredProfile(REQUIRED_PROFILE_EDEFAULT);
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
		switch(featureID) {
		case InvariantStereotypeConfigurationPackage.INVARIANT_STEREOTYPE_CONFIGURATION__STEREOTYPE_QUALIFIED_NAME:
			return STEREOTYPE_QUALIFIED_NAME_EDEFAULT == null ? stereotypeQualifiedName != null : !STEREOTYPE_QUALIFIED_NAME_EDEFAULT.equals(stereotypeQualifiedName);
		case InvariantStereotypeConfigurationPackage.INVARIANT_STEREOTYPE_CONFIGURATION__REQUIRED_PROFILE:
			return REQUIRED_PROFILE_EDEFAULT == null ? requiredProfile != null : !REQUIRED_PROFILE_EDEFAULT.equals(requiredProfile);
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
		if(eIsProxy())
			return super.toString();
		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (stereotypeQualifiedName: ");
		result.append(stereotypeQualifiedName);
		result.append(", requiredProfile: ");
		result.append(requiredProfile);
		result.append(')');
		return result.toString();
	}
} //InvariantStereotypeConfigurationImpl
