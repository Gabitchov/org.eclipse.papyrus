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
package org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaScenario;

import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaStepImpl;

import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.PAMPackage;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.PaStep;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pa Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.impl.PaStepImpl#getNoSync <em>No Sync</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.impl.PaStepImpl#getExtOpDemand <em>Ext Op Demand</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.impl.PaStepImpl#getExtOpCount <em>Ext Op Count</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.impl.PaStepImpl#getBehavDemand <em>Behav Demand</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.impl.PaStepImpl#getBehavCount <em>Behav Count</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PaStepImpl extends GaStepImpl implements PaStep {
	/**
	 * The default value of the '{@link #getNoSync() <em>No Sync</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNoSync()
	 * @generated
	 * @ordered
	 */
	protected static final String NO_SYNC_EDEFAULT = "false";

	/**
	 * The cached value of the '{@link #getNoSync() <em>No Sync</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNoSync()
	 * @generated
	 * @ordered
	 */
	protected String noSync = NO_SYNC_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExtOpDemand() <em>Ext Op Demand</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtOpDemand()
	 * @generated
	 * @ordered
	 */
	protected EList<String> extOpDemand;

	/**
	 * The cached value of the '{@link #getExtOpCount() <em>Ext Op Count</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtOpCount()
	 * @generated
	 * @ordered
	 */
	protected EList<String> extOpCount;

	/**
	 * The cached value of the '{@link #getBehavDemand() <em>Behav Demand</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehavDemand()
	 * @generated
	 * @ordered
	 */
	protected EList<GaScenario> behavDemand;

	/**
	 * The cached value of the '{@link #getBehavCount() <em>Behav Count</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehavCount()
	 * @generated
	 * @ordered
	 */
	protected EList<String> behavCount;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PaStepImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PAMPackage.Literals.PA_STEP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNoSync() {
		return noSync;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNoSync(String newNoSync) {
		String oldNoSync = noSync;
		noSync = newNoSync;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PAMPackage.PA_STEP__NO_SYNC, oldNoSync, noSync));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getExtOpDemand() {
		if (extOpDemand == null) {
			extOpDemand = new EDataTypeUniqueEList<String>(String.class, this, PAMPackage.PA_STEP__EXT_OP_DEMAND);
		}
		return extOpDemand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getExtOpCount() {
		if (extOpCount == null) {
			extOpCount = new EDataTypeUniqueEList<String>(String.class, this, PAMPackage.PA_STEP__EXT_OP_COUNT);
		}
		return extOpCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GaScenario> getBehavDemand() {
		if (behavDemand == null) {
			behavDemand = new EObjectResolvingEList<GaScenario>(GaScenario.class, this, PAMPackage.PA_STEP__BEHAV_DEMAND);
		}
		return behavDemand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getBehavCount() {
		if (behavCount == null) {
			behavCount = new EDataTypeUniqueEList<String>(String.class, this, PAMPackage.PA_STEP__BEHAV_COUNT);
		}
		return behavCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PAMPackage.PA_STEP__NO_SYNC:
				return getNoSync();
			case PAMPackage.PA_STEP__EXT_OP_DEMAND:
				return getExtOpDemand();
			case PAMPackage.PA_STEP__EXT_OP_COUNT:
				return getExtOpCount();
			case PAMPackage.PA_STEP__BEHAV_DEMAND:
				return getBehavDemand();
			case PAMPackage.PA_STEP__BEHAV_COUNT:
				return getBehavCount();
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
			case PAMPackage.PA_STEP__NO_SYNC:
				setNoSync((String)newValue);
				return;
			case PAMPackage.PA_STEP__EXT_OP_DEMAND:
				getExtOpDemand().clear();
				getExtOpDemand().addAll((Collection<? extends String>)newValue);
				return;
			case PAMPackage.PA_STEP__EXT_OP_COUNT:
				getExtOpCount().clear();
				getExtOpCount().addAll((Collection<? extends String>)newValue);
				return;
			case PAMPackage.PA_STEP__BEHAV_DEMAND:
				getBehavDemand().clear();
				getBehavDemand().addAll((Collection<? extends GaScenario>)newValue);
				return;
			case PAMPackage.PA_STEP__BEHAV_COUNT:
				getBehavCount().clear();
				getBehavCount().addAll((Collection<? extends String>)newValue);
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
			case PAMPackage.PA_STEP__NO_SYNC:
				setNoSync(NO_SYNC_EDEFAULT);
				return;
			case PAMPackage.PA_STEP__EXT_OP_DEMAND:
				getExtOpDemand().clear();
				return;
			case PAMPackage.PA_STEP__EXT_OP_COUNT:
				getExtOpCount().clear();
				return;
			case PAMPackage.PA_STEP__BEHAV_DEMAND:
				getBehavDemand().clear();
				return;
			case PAMPackage.PA_STEP__BEHAV_COUNT:
				getBehavCount().clear();
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
			case PAMPackage.PA_STEP__NO_SYNC:
				return NO_SYNC_EDEFAULT == null ? noSync != null : !NO_SYNC_EDEFAULT.equals(noSync);
			case PAMPackage.PA_STEP__EXT_OP_DEMAND:
				return extOpDemand != null && !extOpDemand.isEmpty();
			case PAMPackage.PA_STEP__EXT_OP_COUNT:
				return extOpCount != null && !extOpCount.isEmpty();
			case PAMPackage.PA_STEP__BEHAV_DEMAND:
				return behavDemand != null && !behavDemand.isEmpty();
			case PAMPackage.PA_STEP__BEHAV_COUNT:
				return behavCount != null && !behavCount.isEmpty();
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
		result.append(" (noSync: ");
		result.append(noSync);
		result.append(", extOpDemand: ");
		result.append(extOpDemand);
		result.append(", extOpCount: ");
		result.append(extOpCount);
		result.append(", behavCount: ");
		result.append(behavCount);
		result.append(')');
		return result.toString();
	}

} //PaStepImpl
