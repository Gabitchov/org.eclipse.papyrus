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
package org.eclipse.papyrus.eastadl.dependability.safetyrequirement.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyrequirementPackage;
import org.eclipse.papyrus.eastadl.dependability.safetyrequirement.TechnicalSafetyConcept;
import org.eclipse.papyrus.eastadl.requirements.Requirement;
import org.eclipse.papyrus.eastadl.requirements.impl.RequirementsContainerImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Technical Safety Concept</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.impl.TechnicalSafetyConceptImpl#getTechnicalSafetyRequirement <em>Technical Safety Requirement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TechnicalSafetyConceptImpl extends RequirementsContainerImpl implements TechnicalSafetyConcept {
	/**
	 * The cached value of the '{@link #getTechnicalSafetyRequirement() <em>Technical Safety Requirement</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTechnicalSafetyRequirement()
	 * @generated
	 * @ordered
	 */
	protected EList<Requirement> technicalSafetyRequirement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TechnicalSafetyConceptImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SafetyrequirementPackage.TECHNICAL_SAFETY_CONCEPT__TECHNICAL_SAFETY_REQUIREMENT:
				return getTechnicalSafetyRequirement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SafetyrequirementPackage.TECHNICAL_SAFETY_CONCEPT__TECHNICAL_SAFETY_REQUIREMENT:
				return technicalSafetyRequirement != null && !technicalSafetyRequirement.isEmpty();
		}
		return super.eIsSet(featureID);
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
			case SafetyrequirementPackage.TECHNICAL_SAFETY_CONCEPT__TECHNICAL_SAFETY_REQUIREMENT:
				getTechnicalSafetyRequirement().clear();
				getTechnicalSafetyRequirement().addAll((Collection<? extends Requirement>)newValue);
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
	protected EClass eStaticClass() {
		return SafetyrequirementPackage.Literals.TECHNICAL_SAFETY_CONCEPT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SafetyrequirementPackage.TECHNICAL_SAFETY_CONCEPT__TECHNICAL_SAFETY_REQUIREMENT:
				getTechnicalSafetyRequirement().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Requirement> getTechnicalSafetyRequirement() {
		if (technicalSafetyRequirement == null) {
			technicalSafetyRequirement = new EObjectResolvingEList<Requirement>(Requirement.class, this, SafetyrequirementPackage.TECHNICAL_SAFETY_CONCEPT__TECHNICAL_SAFETY_REQUIREMENT);
		}
		return technicalSafetyRequirement;
	}

} //TechnicalSafetyConceptImpl
