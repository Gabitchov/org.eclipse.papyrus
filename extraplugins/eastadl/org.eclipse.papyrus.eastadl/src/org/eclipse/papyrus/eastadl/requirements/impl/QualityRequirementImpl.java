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
package org.eclipse.papyrus.eastadl.requirements.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.eastadl.requirements.QualityRequirement;
import org.eclipse.papyrus.eastadl.requirements.QualityRequirementKind;
import org.eclipse.papyrus.eastadl.requirements.RequirementsPackage;


/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Quality Requirement</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.requirements.impl.QualityRequirementImpl#getQualityRequirementType <em>Quality Requirement Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QualityRequirementImpl extends RequirementImpl implements QualityRequirement {

	/**
	 * The default value of the '{@link #getQualityRequirementType() <em>Quality Requirement Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getQualityRequirementType()
	 * @generated
	 * @ordered
	 */
	protected static final QualityRequirementKind QUALITY_REQUIREMENT_TYPE_EDEFAULT = QualityRequirementKind.ERGONOMY;

	/**
	 * The cached value of the '{@link #getQualityRequirementType() <em>Quality Requirement Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getQualityRequirementType()
	 * @generated
	 * @ordered
	 */
	protected QualityRequirementKind qualityRequirementType = QUALITY_REQUIREMENT_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected QualityRequirementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RequirementsPackage.QUALITY_REQUIREMENT__QUALITY_REQUIREMENT_TYPE:
				return getQualityRequirementType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case RequirementsPackage.QUALITY_REQUIREMENT__QUALITY_REQUIREMENT_TYPE:
				return qualityRequirementType != QUALITY_REQUIREMENT_TYPE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RequirementsPackage.QUALITY_REQUIREMENT__QUALITY_REQUIREMENT_TYPE:
				setQualityRequirementType((QualityRequirementKind)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementsPackage.Literals.QUALITY_REQUIREMENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case RequirementsPackage.QUALITY_REQUIREMENT__QUALITY_REQUIREMENT_TYPE:
				setQualityRequirementType(QUALITY_REQUIREMENT_TYPE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public QualityRequirementKind getQualityRequirementType() {
		return qualityRequirementType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setQualityRequirementType(QualityRequirementKind newQualityRequirementType) {
		QualityRequirementKind oldQualityRequirementType = qualityRequirementType;
		qualityRequirementType = newQualityRequirementType == null ? QUALITY_REQUIREMENT_TYPE_EDEFAULT : newQualityRequirementType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.QUALITY_REQUIREMENT__QUALITY_REQUIREMENT_TYPE, oldQualityRequirementType, qualityRequirementType));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (qualityRequirementType: ");
		result.append(qualityRequirementType);
		result.append(')');
		return result.toString();
	}

} // QualityRequirementImpl
