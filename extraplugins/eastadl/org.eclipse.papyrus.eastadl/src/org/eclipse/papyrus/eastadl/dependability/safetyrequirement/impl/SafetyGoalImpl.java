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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.behavior.Mode;
import org.eclipse.papyrus.eastadl.dependability.HazardousEvent;
import org.eclipse.papyrus.eastadl.dependability.safetyconstraints.ASILKind;
import org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyGoal;
import org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyrequirementPackage;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.EAElementImpl;
import org.eclipse.papyrus.eastadl.requirements.Requirement;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Safety Goal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.impl.SafetyGoalImpl#getDerivedFrom <em>Derived From</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.impl.SafetyGoalImpl#getSafeStates <em>Safe States</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.impl.SafetyGoalImpl#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.impl.SafetyGoalImpl#getRequirement <em>Requirement</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.impl.SafetyGoalImpl#getHazardClassification <em>Hazard Classification</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetyrequirement.impl.SafetyGoalImpl#getSafeModes <em>Safe Modes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SafetyGoalImpl extends EAElementImpl implements SafetyGoal {
	/**
	 * The cached value of the '{@link #getDerivedFrom() <em>Derived From</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDerivedFrom()
	 * @generated
	 * @ordered
	 */
	protected EList<HazardousEvent> derivedFrom;

	/**
	 * The default value of the '{@link #getSafeStates() <em>Safe States</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSafeStates()
	 * @generated
	 * @ordered
	 */
	protected static final String SAFE_STATES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSafeStates() <em>Safe States</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSafeStates()
	 * @generated
	 * @ordered
	 */
	protected String safeStates = SAFE_STATES_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_Class() <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_Class;

	/**
	 * The cached value of the '{@link #getRequirement() <em>Requirement</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirement()
	 * @generated
	 * @ordered
	 */
	protected EList<Requirement> requirement;

	/**
	 * The default value of the '{@link #getHazardClassification() <em>Hazard Classification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHazardClassification()
	 * @generated
	 * @ordered
	 */
	protected static final ASILKind HAZARD_CLASSIFICATION_EDEFAULT = ASILKind.ASIL_A;

	/**
	 * The cached value of the '{@link #getHazardClassification() <em>Hazard Classification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHazardClassification()
	 * @generated
	 * @ordered
	 */
	protected ASILKind hazardClassification = HAZARD_CLASSIFICATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSafeModes() <em>Safe Modes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSafeModes()
	 * @generated
	 * @ordered
	 */
	protected EList<Mode> safeModes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SafetyGoalImpl() {
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
			case SafetyrequirementPackage.SAFETY_GOAL__DERIVED_FROM:
				return getDerivedFrom();
			case SafetyrequirementPackage.SAFETY_GOAL__SAFE_STATES:
				return getSafeStates();
			case SafetyrequirementPackage.SAFETY_GOAL__BASE_CLASS:
				if (resolve) return getBase_Class();
				return basicGetBase_Class();
			case SafetyrequirementPackage.SAFETY_GOAL__REQUIREMENT:
				return getRequirement();
			case SafetyrequirementPackage.SAFETY_GOAL__HAZARD_CLASSIFICATION:
				return getHazardClassification();
			case SafetyrequirementPackage.SAFETY_GOAL__SAFE_MODES:
				return getSafeModes();
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
			case SafetyrequirementPackage.SAFETY_GOAL__DERIVED_FROM:
				return derivedFrom != null && !derivedFrom.isEmpty();
			case SafetyrequirementPackage.SAFETY_GOAL__SAFE_STATES:
				return SAFE_STATES_EDEFAULT == null ? safeStates != null : !SAFE_STATES_EDEFAULT.equals(safeStates);
			case SafetyrequirementPackage.SAFETY_GOAL__BASE_CLASS:
				return base_Class != null;
			case SafetyrequirementPackage.SAFETY_GOAL__REQUIREMENT:
				return requirement != null && !requirement.isEmpty();
			case SafetyrequirementPackage.SAFETY_GOAL__HAZARD_CLASSIFICATION:
				return hazardClassification != HAZARD_CLASSIFICATION_EDEFAULT;
			case SafetyrequirementPackage.SAFETY_GOAL__SAFE_MODES:
				return safeModes != null && !safeModes.isEmpty();
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
			case SafetyrequirementPackage.SAFETY_GOAL__DERIVED_FROM:
				getDerivedFrom().clear();
				getDerivedFrom().addAll((Collection<? extends HazardousEvent>)newValue);
				return;
			case SafetyrequirementPackage.SAFETY_GOAL__SAFE_STATES:
				setSafeStates((String)newValue);
				return;
			case SafetyrequirementPackage.SAFETY_GOAL__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)newValue);
				return;
			case SafetyrequirementPackage.SAFETY_GOAL__REQUIREMENT:
				getRequirement().clear();
				getRequirement().addAll((Collection<? extends Requirement>)newValue);
				return;
			case SafetyrequirementPackage.SAFETY_GOAL__HAZARD_CLASSIFICATION:
				setHazardClassification((ASILKind)newValue);
				return;
			case SafetyrequirementPackage.SAFETY_GOAL__SAFE_MODES:
				getSafeModes().clear();
				getSafeModes().addAll((Collection<? extends Mode>)newValue);
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
		return SafetyrequirementPackage.Literals.SAFETY_GOAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SafetyrequirementPackage.SAFETY_GOAL__DERIVED_FROM:
				getDerivedFrom().clear();
				return;
			case SafetyrequirementPackage.SAFETY_GOAL__SAFE_STATES:
				setSafeStates(SAFE_STATES_EDEFAULT);
				return;
			case SafetyrequirementPackage.SAFETY_GOAL__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)null);
				return;
			case SafetyrequirementPackage.SAFETY_GOAL__REQUIREMENT:
				getRequirement().clear();
				return;
			case SafetyrequirementPackage.SAFETY_GOAL__HAZARD_CLASSIFICATION:
				setHazardClassification(HAZARD_CLASSIFICATION_EDEFAULT);
				return;
			case SafetyrequirementPackage.SAFETY_GOAL__SAFE_MODES:
				getSafeModes().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HazardousEvent> getDerivedFrom() {
		if (derivedFrom == null) {
			derivedFrom = new EObjectResolvingEList<HazardousEvent>(HazardousEvent.class, this, SafetyrequirementPackage.SAFETY_GOAL__DERIVED_FROM);
		}
		return derivedFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ASILKind getHazardClassification() {
		return hazardClassification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHazardClassification(ASILKind newHazardClassification) {
		ASILKind oldHazardClassification = hazardClassification;
		hazardClassification = newHazardClassification == null ? HAZARD_CLASSIFICATION_EDEFAULT : newHazardClassification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SafetyrequirementPackage.SAFETY_GOAL__HAZARD_CLASSIFICATION, oldHazardClassification, hazardClassification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Requirement> getRequirement() {
		if (requirement == null) {
			requirement = new EObjectResolvingEList<Requirement>(Requirement.class, this, SafetyrequirementPackage.SAFETY_GOAL__REQUIREMENT);
		}
		return requirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mode> getSafeModes() {
		if (safeModes == null) {
			safeModes = new EObjectResolvingEList<Mode>(Mode.class, this, SafetyrequirementPackage.SAFETY_GOAL__SAFE_MODES);
		}
		return safeModes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSafeStates() {
		return safeStates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSafeStates(String newSafeStates) {
		String oldSafeStates = safeStates;
		safeStates = newSafeStates;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SafetyrequirementPackage.SAFETY_GOAL__SAFE_STATES, oldSafeStates, safeStates));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if (base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject)base_Class;
			base_Class = (org.eclipse.uml2.uml.Class)eResolveProxy(oldBase_Class);
			if (base_Class != oldBase_Class) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SafetyrequirementPackage.SAFETY_GOAL__BASE_CLASS, oldBase_Class, base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_Class() {
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SafetyrequirementPackage.SAFETY_GOAL__BASE_CLASS, oldBase_Class, base_Class));
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
		result.append(" (safeStates: ");
		result.append(safeStates);
		result.append(", hazardClassification: ");
		result.append(hazardClassification);
		result.append(')');
		return result.toString();
	}

} //SafetyGoalImpl
