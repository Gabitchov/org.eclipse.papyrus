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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaAcqStep;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ga Acq Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaAcqStepImpl#getAcqRes <em>Acq Res</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaAcqStepImpl#getResUnits <em>Res Units</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GaAcqStepImpl extends GaStepImpl implements GaAcqStep {
	/**
	 * The cached value of the '{@link #getAcqRes() <em>Acq Res</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAcqRes()
	 * @generated
	 * @ordered
	 */
	protected Resource acqRes;

	/**
	 * The default value of the '{@link #getResUnits() <em>Res Units</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResUnits()
	 * @generated
	 * @ordered
	 */
	protected static final String RES_UNITS_EDEFAULT = "1";

	/**
	 * The cached value of the '{@link #getResUnits() <em>Res Units</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResUnits()
	 * @generated
	 * @ordered
	 */
	protected String resUnits = RES_UNITS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GaAcqStepImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GQAMPackage.Literals.GA_ACQ_STEP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource getAcqRes() {
		if (acqRes != null && acqRes.eIsProxy()) {
			InternalEObject oldAcqRes = (InternalEObject)acqRes;
			acqRes = (Resource)eResolveProxy(oldAcqRes);
			if (acqRes != oldAcqRes) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GQAMPackage.GA_ACQ_STEP__ACQ_RES, oldAcqRes, acqRes));
			}
		}
		return acqRes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource basicGetAcqRes() {
		return acqRes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAcqRes(Resource newAcqRes) {
		Resource oldAcqRes = acqRes;
		acqRes = newAcqRes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GQAMPackage.GA_ACQ_STEP__ACQ_RES, oldAcqRes, acqRes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResUnits() {
		return resUnits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResUnits(String newResUnits) {
		String oldResUnits = resUnits;
		resUnits = newResUnits;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GQAMPackage.GA_ACQ_STEP__RES_UNITS, oldResUnits, resUnits));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GQAMPackage.GA_ACQ_STEP__ACQ_RES:
				if (resolve) return getAcqRes();
				return basicGetAcqRes();
			case GQAMPackage.GA_ACQ_STEP__RES_UNITS:
				return getResUnits();
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
			case GQAMPackage.GA_ACQ_STEP__ACQ_RES:
				setAcqRes((Resource)newValue);
				return;
			case GQAMPackage.GA_ACQ_STEP__RES_UNITS:
				setResUnits((String)newValue);
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
			case GQAMPackage.GA_ACQ_STEP__ACQ_RES:
				setAcqRes((Resource)null);
				return;
			case GQAMPackage.GA_ACQ_STEP__RES_UNITS:
				setResUnits(RES_UNITS_EDEFAULT);
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
			case GQAMPackage.GA_ACQ_STEP__ACQ_RES:
				return acqRes != null;
			case GQAMPackage.GA_ACQ_STEP__RES_UNITS:
				return RES_UNITS_EDEFAULT == null ? resUnits != null : !RES_UNITS_EDEFAULT.equals(resUnits);
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
		result.append(" (resUnits: ");
		result.append(resUnits);
		result.append(')');
		return result.toString();
	}

} //GaAcqStepImpl
