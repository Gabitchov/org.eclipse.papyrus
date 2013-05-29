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
package org.eclipse.papyrus.eastadl.dependability.safetycase.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.dependability.safetycase.Claim;
import org.eclipse.papyrus.eastadl.dependability.safetycase.Ground;
import org.eclipse.papyrus.eastadl.dependability.safetycase.SafetycasePackage;
import org.eclipse.papyrus.eastadl.dependability.safetycase.Warrant;
import org.eclipse.papyrus.eastadl.infrastructure.elements.TraceableSpecification;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.TraceableSpecificationImpl;
import org.eclipse.uml2.uml.Comment;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Claim</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.impl.ClaimImpl#getSafetyRequirement <em>Safety Requirement</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.impl.ClaimImpl#getSupportedArgument <em>Supported Argument</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.impl.ClaimImpl#getGoalDecompositionStrategy <em>Goal Decomposition Strategy</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.impl.ClaimImpl#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.impl.ClaimImpl#getJustification <em>Justification</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.impl.ClaimImpl#getEvidence <em>Evidence</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClaimImpl extends TraceableSpecificationImpl implements Claim {
	/**
	 * The cached value of the '{@link #getSafetyRequirement() <em>Safety Requirement</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSafetyRequirement()
	 * @generated
	 * @ordered
	 */
	protected EList<TraceableSpecification> safetyRequirement;

	/**
	 * The cached value of the '{@link #getSupportedArgument() <em>Supported Argument</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupportedArgument()
	 * @generated
	 * @ordered
	 */
	protected EList<Warrant> supportedArgument;

	/**
	 * The cached value of the '{@link #getGoalDecompositionStrategy() <em>Goal Decomposition Strategy</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoalDecompositionStrategy()
	 * @generated
	 * @ordered
	 */
	protected EList<Warrant> goalDecompositionStrategy;

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
	 * The cached value of the '{@link #getJustification() <em>Justification</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJustification()
	 * @generated
	 * @ordered
	 */
	protected EList<Comment> justification;

	/**
	 * The cached value of the '{@link #getEvidence() <em>Evidence</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvidence()
	 * @generated
	 * @ordered
	 */
	protected EList<Ground> evidence;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClaimImpl() {
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
			case SafetycasePackage.CLAIM__SAFETY_REQUIREMENT:
				return getSafetyRequirement();
			case SafetycasePackage.CLAIM__SUPPORTED_ARGUMENT:
				return getSupportedArgument();
			case SafetycasePackage.CLAIM__GOAL_DECOMPOSITION_STRATEGY:
				return getGoalDecompositionStrategy();
			case SafetycasePackage.CLAIM__BASE_CLASS:
				if (resolve) return getBase_Class();
				return basicGetBase_Class();
			case SafetycasePackage.CLAIM__JUSTIFICATION:
				return getJustification();
			case SafetycasePackage.CLAIM__EVIDENCE:
				return getEvidence();
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
			case SafetycasePackage.CLAIM__SAFETY_REQUIREMENT:
				return safetyRequirement != null && !safetyRequirement.isEmpty();
			case SafetycasePackage.CLAIM__SUPPORTED_ARGUMENT:
				return supportedArgument != null && !supportedArgument.isEmpty();
			case SafetycasePackage.CLAIM__GOAL_DECOMPOSITION_STRATEGY:
				return goalDecompositionStrategy != null && !goalDecompositionStrategy.isEmpty();
			case SafetycasePackage.CLAIM__BASE_CLASS:
				return base_Class != null;
			case SafetycasePackage.CLAIM__JUSTIFICATION:
				return justification != null && !justification.isEmpty();
			case SafetycasePackage.CLAIM__EVIDENCE:
				return evidence != null && !evidence.isEmpty();
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
			case SafetycasePackage.CLAIM__SAFETY_REQUIREMENT:
				getSafetyRequirement().clear();
				getSafetyRequirement().addAll((Collection<? extends TraceableSpecification>)newValue);
				return;
			case SafetycasePackage.CLAIM__SUPPORTED_ARGUMENT:
				getSupportedArgument().clear();
				getSupportedArgument().addAll((Collection<? extends Warrant>)newValue);
				return;
			case SafetycasePackage.CLAIM__GOAL_DECOMPOSITION_STRATEGY:
				getGoalDecompositionStrategy().clear();
				getGoalDecompositionStrategy().addAll((Collection<? extends Warrant>)newValue);
				return;
			case SafetycasePackage.CLAIM__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)newValue);
				return;
			case SafetycasePackage.CLAIM__JUSTIFICATION:
				getJustification().clear();
				getJustification().addAll((Collection<? extends Comment>)newValue);
				return;
			case SafetycasePackage.CLAIM__EVIDENCE:
				getEvidence().clear();
				getEvidence().addAll((Collection<? extends Ground>)newValue);
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
		return SafetycasePackage.Literals.CLAIM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SafetycasePackage.CLAIM__SAFETY_REQUIREMENT:
				getSafetyRequirement().clear();
				return;
			case SafetycasePackage.CLAIM__SUPPORTED_ARGUMENT:
				getSupportedArgument().clear();
				return;
			case SafetycasePackage.CLAIM__GOAL_DECOMPOSITION_STRATEGY:
				getGoalDecompositionStrategy().clear();
				return;
			case SafetycasePackage.CLAIM__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)null);
				return;
			case SafetycasePackage.CLAIM__JUSTIFICATION:
				getJustification().clear();
				return;
			case SafetycasePackage.CLAIM__EVIDENCE:
				getEvidence().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Ground> getEvidence() {
		if (evidence == null) {
			evidence = new EObjectResolvingEList<Ground>(Ground.class, this, SafetycasePackage.CLAIM__EVIDENCE);
		}
		return evidence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Warrant> getGoalDecompositionStrategy() {
		if (goalDecompositionStrategy == null) {
			goalDecompositionStrategy = new EObjectResolvingEList<Warrant>(Warrant.class, this, SafetycasePackage.CLAIM__GOAL_DECOMPOSITION_STRATEGY);
		}
		return goalDecompositionStrategy;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SafetycasePackage.CLAIM__BASE_CLASS, oldBase_Class, base_Class));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SafetycasePackage.CLAIM__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Comment> getJustification() {
		if (justification == null) {
			justification = new EObjectResolvingEList<Comment>(Comment.class, this, SafetycasePackage.CLAIM__JUSTIFICATION);
		}
		return justification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TraceableSpecification> getSafetyRequirement() {
		if (safetyRequirement == null) {
			safetyRequirement = new EObjectResolvingEList<TraceableSpecification>(TraceableSpecification.class, this, SafetycasePackage.CLAIM__SAFETY_REQUIREMENT);
		}
		return safetyRequirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Warrant> getSupportedArgument() {
		if (supportedArgument == null) {
			supportedArgument = new EObjectResolvingEList<Warrant>(Warrant.class, this, SafetycasePackage.CLAIM__SUPPORTED_ARGUMENT);
		}
		return supportedArgument;
	}

} //ClaimImpl
