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
package org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaAnalysisContextImpl;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.OptimallityCriterionKind;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaAnalysisContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sa Analysis Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaAnalysisContextImpl#getIsSched <em>Is Sched</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaAnalysisContextImpl#getOptCriterion <em>Opt Criterion</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SaAnalysisContextImpl extends GaAnalysisContextImpl implements SaAnalysisContext {
	/**
	 * The default value of the '{@link #getIsSched() <em>Is Sched</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsSched()
	 * @generated
	 * @ordered
	 */
	protected static final String IS_SCHED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIsSched() <em>Is Sched</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsSched()
	 * @generated
	 * @ordered
	 */
	protected String isSched = IS_SCHED_EDEFAULT;

	/**
	 * The default value of the '{@link #getOptCriterion() <em>Opt Criterion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptCriterion()
	 * @generated
	 * @ordered
	 */
	protected static final OptimallityCriterionKind OPT_CRITERION_EDEFAULT = OptimallityCriterionKind.MEET_HARD_DEADLINES;

	/**
	 * The cached value of the '{@link #getOptCriterion() <em>Opt Criterion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptCriterion()
	 * @generated
	 * @ordered
	 */
	protected OptimallityCriterionKind optCriterion = OPT_CRITERION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SaAnalysisContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SAMPackage.Literals.SA_ANALYSIS_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIsSched() {
		return isSched;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsSched(String newIsSched) {
		String oldIsSched = isSched;
		isSched = newIsSched;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SAMPackage.SA_ANALYSIS_CONTEXT__IS_SCHED, oldIsSched, isSched));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptimallityCriterionKind getOptCriterion() {
		return optCriterion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptCriterion(OptimallityCriterionKind newOptCriterion) {
		OptimallityCriterionKind oldOptCriterion = optCriterion;
		optCriterion = newOptCriterion == null ? OPT_CRITERION_EDEFAULT : newOptCriterion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SAMPackage.SA_ANALYSIS_CONTEXT__OPT_CRITERION, oldOptCriterion, optCriterion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SAMPackage.SA_ANALYSIS_CONTEXT__IS_SCHED:
				return getIsSched();
			case SAMPackage.SA_ANALYSIS_CONTEXT__OPT_CRITERION:
				return getOptCriterion();
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
			case SAMPackage.SA_ANALYSIS_CONTEXT__IS_SCHED:
				setIsSched((String)newValue);
				return;
			case SAMPackage.SA_ANALYSIS_CONTEXT__OPT_CRITERION:
				setOptCriterion((OptimallityCriterionKind)newValue);
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
			case SAMPackage.SA_ANALYSIS_CONTEXT__IS_SCHED:
				setIsSched(IS_SCHED_EDEFAULT);
				return;
			case SAMPackage.SA_ANALYSIS_CONTEXT__OPT_CRITERION:
				setOptCriterion(OPT_CRITERION_EDEFAULT);
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
			case SAMPackage.SA_ANALYSIS_CONTEXT__IS_SCHED:
				return IS_SCHED_EDEFAULT == null ? isSched != null : !IS_SCHED_EDEFAULT.equals(isSched);
			case SAMPackage.SA_ANALYSIS_CONTEXT__OPT_CRITERION:
				return optCriterion != OPT_CRITERION_EDEFAULT;
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
		result.append(" (isSched: ");
		result.append(isSched);
		result.append(", optCriterion: ");
		result.append(optCriterion);
		result.append(')');
		return result.toString();
	}

} //SaAnalysisContextImpl
