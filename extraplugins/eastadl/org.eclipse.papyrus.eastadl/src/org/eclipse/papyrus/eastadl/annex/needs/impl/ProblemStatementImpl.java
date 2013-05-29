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
package org.eclipse.papyrus.eastadl.annex.needs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage;
import org.eclipse.papyrus.eastadl.annex.needs.ProblemStatement;
import org.eclipse.papyrus.eastadl.annex.needs.Stakeholder;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.TraceableSpecificationImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Problem Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.impl.ProblemStatementImpl#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.impl.ProblemStatementImpl#getAffects <em>Affects</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.impl.ProblemStatementImpl#getImpact <em>Impact</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.impl.ProblemStatementImpl#getProblem <em>Problem</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.impl.ProblemStatementImpl#getSolutionBenefits <em>Solution Benefits</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProblemStatementImpl extends TraceableSpecificationImpl implements ProblemStatement {
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
	 * The cached value of the '{@link #getAffects() <em>Affects</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAffects()
	 * @generated
	 * @ordered
	 */
	protected EList<Stakeholder> affects;

	/**
	 * The default value of the '{@link #getImpact() <em>Impact</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImpact()
	 * @generated
	 * @ordered
	 */
	protected static final String IMPACT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImpact() <em>Impact</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImpact()
	 * @generated
	 * @ordered
	 */
	protected String impact = IMPACT_EDEFAULT;

	/**
	 * The default value of the '{@link #getProblem() <em>Problem</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProblem()
	 * @generated
	 * @ordered
	 */
	protected static final String PROBLEM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProblem() <em>Problem</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProblem()
	 * @generated
	 * @ordered
	 */
	protected String problem = PROBLEM_EDEFAULT;

	/**
	 * The default value of the '{@link #getSolutionBenefits() <em>Solution Benefits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolutionBenefits()
	 * @generated
	 * @ordered
	 */
	protected static final String SOLUTION_BENEFITS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSolutionBenefits() <em>Solution Benefits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolutionBenefits()
	 * @generated
	 * @ordered
	 */
	protected String solutionBenefits = SOLUTION_BENEFITS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProblemStatementImpl() {
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
			case NeedsPackage.PROBLEM_STATEMENT__BASE_CLASS:
				if (resolve) return getBase_Class();
				return basicGetBase_Class();
			case NeedsPackage.PROBLEM_STATEMENT__AFFECTS:
				return getAffects();
			case NeedsPackage.PROBLEM_STATEMENT__IMPACT:
				return getImpact();
			case NeedsPackage.PROBLEM_STATEMENT__PROBLEM:
				return getProblem();
			case NeedsPackage.PROBLEM_STATEMENT__SOLUTION_BENEFITS:
				return getSolutionBenefits();
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
			case NeedsPackage.PROBLEM_STATEMENT__BASE_CLASS:
				return base_Class != null;
			case NeedsPackage.PROBLEM_STATEMENT__AFFECTS:
				return affects != null && !affects.isEmpty();
			case NeedsPackage.PROBLEM_STATEMENT__IMPACT:
				return IMPACT_EDEFAULT == null ? impact != null : !IMPACT_EDEFAULT.equals(impact);
			case NeedsPackage.PROBLEM_STATEMENT__PROBLEM:
				return PROBLEM_EDEFAULT == null ? problem != null : !PROBLEM_EDEFAULT.equals(problem);
			case NeedsPackage.PROBLEM_STATEMENT__SOLUTION_BENEFITS:
				return SOLUTION_BENEFITS_EDEFAULT == null ? solutionBenefits != null : !SOLUTION_BENEFITS_EDEFAULT.equals(solutionBenefits);
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
			case NeedsPackage.PROBLEM_STATEMENT__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)newValue);
				return;
			case NeedsPackage.PROBLEM_STATEMENT__AFFECTS:
				getAffects().clear();
				getAffects().addAll((Collection<? extends Stakeholder>)newValue);
				return;
			case NeedsPackage.PROBLEM_STATEMENT__IMPACT:
				setImpact((String)newValue);
				return;
			case NeedsPackage.PROBLEM_STATEMENT__PROBLEM:
				setProblem((String)newValue);
				return;
			case NeedsPackage.PROBLEM_STATEMENT__SOLUTION_BENEFITS:
				setSolutionBenefits((String)newValue);
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
		return NeedsPackage.Literals.PROBLEM_STATEMENT;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NeedsPackage.PROBLEM_STATEMENT__BASE_CLASS, oldBase_Class, base_Class));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NeedsPackage.PROBLEM_STATEMENT__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case NeedsPackage.PROBLEM_STATEMENT__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)null);
				return;
			case NeedsPackage.PROBLEM_STATEMENT__AFFECTS:
				getAffects().clear();
				return;
			case NeedsPackage.PROBLEM_STATEMENT__IMPACT:
				setImpact(IMPACT_EDEFAULT);
				return;
			case NeedsPackage.PROBLEM_STATEMENT__PROBLEM:
				setProblem(PROBLEM_EDEFAULT);
				return;
			case NeedsPackage.PROBLEM_STATEMENT__SOLUTION_BENEFITS:
				setSolutionBenefits(SOLUTION_BENEFITS_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Stakeholder> getAffects() {
		if (affects == null) {
			affects = new EObjectResolvingEList<Stakeholder>(Stakeholder.class, this, NeedsPackage.PROBLEM_STATEMENT__AFFECTS);
		}
		return affects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImpact() {
		return impact;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProblem() {
		return problem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSolutionBenefits() {
		return solutionBenefits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImpact(String newImpact) {
		String oldImpact = impact;
		impact = newImpact;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NeedsPackage.PROBLEM_STATEMENT__IMPACT, oldImpact, impact));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProblem(String newProblem) {
		String oldProblem = problem;
		problem = newProblem;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NeedsPackage.PROBLEM_STATEMENT__PROBLEM, oldProblem, problem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSolutionBenefits(String newSolutionBenefits) {
		String oldSolutionBenefits = solutionBenefits;
		solutionBenefits = newSolutionBenefits;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NeedsPackage.PROBLEM_STATEMENT__SOLUTION_BENEFITS, oldSolutionBenefits, solutionBenefits));
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
		result.append(" (impact: ");
		result.append(impact);
		result.append(", problem: ");
		result.append(problem);
		result.append(", solutionBenefits: ");
		result.append(solutionBenefits);
		result.append(')');
		return result.toString();
	}

} //ProblemStatementImpl
