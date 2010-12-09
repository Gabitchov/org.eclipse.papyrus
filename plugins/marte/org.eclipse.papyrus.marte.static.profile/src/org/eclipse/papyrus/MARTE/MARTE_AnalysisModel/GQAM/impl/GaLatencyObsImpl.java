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
package org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaLatencyObs;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ga Latency Obs</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaLatencyObsImpl#getLatency <em>Latency</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaLatencyObsImpl#getMiss <em>Miss</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaLatencyObsImpl#getUtility <em>Utility</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaLatencyObsImpl#getMaxJitter <em>Max Jitter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GaLatencyObsImpl extends GaTimedObsImpl implements GaLatencyObs {
	/**
	 * The cached value of the '{@link #getLatency() <em>Latency</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLatency()
	 * @generated
	 * @ordered
	 */
	protected EList<String> latency;

	/**
	 * The cached value of the '{@link #getMiss() <em>Miss</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMiss()
	 * @generated
	 * @ordered
	 */
	protected EList<String> miss;

	/**
	 * The cached value of the '{@link #getUtility() <em>Utility</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtility()
	 * @generated
	 * @ordered
	 */
	protected EList<String> utility;

	/**
	 * The cached value of the '{@link #getMaxJitter() <em>Max Jitter</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxJitter()
	 * @generated
	 * @ordered
	 */
	protected EList<String> maxJitter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GaLatencyObsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GQAMPackage.Literals.GA_LATENCY_OBS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getLatency() {
		if (latency == null) {
			latency = new EDataTypeUniqueEList<String>(String.class, this, GQAMPackage.GA_LATENCY_OBS__LATENCY);
		}
		return latency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getMiss() {
		if (miss == null) {
			miss = new EDataTypeUniqueEList<String>(String.class, this, GQAMPackage.GA_LATENCY_OBS__MISS);
		}
		return miss;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getUtility() {
		if (utility == null) {
			utility = new EDataTypeUniqueEList<String>(String.class, this, GQAMPackage.GA_LATENCY_OBS__UTILITY);
		}
		return utility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getMaxJitter() {
		if (maxJitter == null) {
			maxJitter = new EDataTypeUniqueEList<String>(String.class, this, GQAMPackage.GA_LATENCY_OBS__MAX_JITTER);
		}
		return maxJitter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GQAMPackage.GA_LATENCY_OBS__LATENCY:
				return getLatency();
			case GQAMPackage.GA_LATENCY_OBS__MISS:
				return getMiss();
			case GQAMPackage.GA_LATENCY_OBS__UTILITY:
				return getUtility();
			case GQAMPackage.GA_LATENCY_OBS__MAX_JITTER:
				return getMaxJitter();
		}
		return super.eGet(featureID, resolve, coreType);
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
			case GQAMPackage.GA_LATENCY_OBS__LATENCY:
				getLatency().clear();
				getLatency().addAll((Collection<? extends String>)newValue);
				return;
			case GQAMPackage.GA_LATENCY_OBS__MISS:
				getMiss().clear();
				getMiss().addAll((Collection<? extends String>)newValue);
				return;
			case GQAMPackage.GA_LATENCY_OBS__UTILITY:
				getUtility().clear();
				getUtility().addAll((Collection<? extends String>)newValue);
				return;
			case GQAMPackage.GA_LATENCY_OBS__MAX_JITTER:
				getMaxJitter().clear();
				getMaxJitter().addAll((Collection<? extends String>)newValue);
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
			case GQAMPackage.GA_LATENCY_OBS__LATENCY:
				getLatency().clear();
				return;
			case GQAMPackage.GA_LATENCY_OBS__MISS:
				getMiss().clear();
				return;
			case GQAMPackage.GA_LATENCY_OBS__UTILITY:
				getUtility().clear();
				return;
			case GQAMPackage.GA_LATENCY_OBS__MAX_JITTER:
				getMaxJitter().clear();
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
			case GQAMPackage.GA_LATENCY_OBS__LATENCY:
				return latency != null && !latency.isEmpty();
			case GQAMPackage.GA_LATENCY_OBS__MISS:
				return miss != null && !miss.isEmpty();
			case GQAMPackage.GA_LATENCY_OBS__UTILITY:
				return utility != null && !utility.isEmpty();
			case GQAMPackage.GA_LATENCY_OBS__MAX_JITTER:
				return maxJitter != null && !maxJitter.isEmpty();
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
		result.append(" (latency: ");
		result.append(latency);
		result.append(", miss: ");
		result.append(miss);
		result.append(", utility: ");
		result.append(utility);
		result.append(", maxJitter: ");
		result.append(maxJitter);
		result.append(')');
		return result.toString();
	}

} //GaLatencyObsImpl
