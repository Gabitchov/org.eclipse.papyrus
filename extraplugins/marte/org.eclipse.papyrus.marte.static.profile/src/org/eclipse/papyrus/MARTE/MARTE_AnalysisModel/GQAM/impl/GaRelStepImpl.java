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
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaRelStep;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ga Rel Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaRelStepImpl#getRelRes <em>Rel Res</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaRelStepImpl#getResUnits <em>Res Units</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GaRelStepImpl extends GaStepImpl implements GaRelStep {
	/**
	 * The cached value of the '{@link #getRelRes() <em>Rel Res</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelRes()
	 * @generated
	 * @ordered
	 */
	protected Resource relRes;

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
	protected GaRelStepImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GQAMPackage.Literals.GA_REL_STEP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource getRelRes() {
		if (relRes != null && relRes.eIsProxy()) {
			InternalEObject oldRelRes = (InternalEObject)relRes;
			relRes = (Resource)eResolveProxy(oldRelRes);
			if (relRes != oldRelRes) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GQAMPackage.GA_REL_STEP__REL_RES, oldRelRes, relRes));
			}
		}
		return relRes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource basicGetRelRes() {
		return relRes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelRes(Resource newRelRes) {
		Resource oldRelRes = relRes;
		relRes = newRelRes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GQAMPackage.GA_REL_STEP__REL_RES, oldRelRes, relRes));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GQAMPackage.GA_REL_STEP__RES_UNITS, oldResUnits, resUnits));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GQAMPackage.GA_REL_STEP__REL_RES:
				if (resolve) return getRelRes();
				return basicGetRelRes();
			case GQAMPackage.GA_REL_STEP__RES_UNITS:
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
			case GQAMPackage.GA_REL_STEP__REL_RES:
				setRelRes((Resource)newValue);
				return;
			case GQAMPackage.GA_REL_STEP__RES_UNITS:
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
			case GQAMPackage.GA_REL_STEP__REL_RES:
				setRelRes((Resource)null);
				return;
			case GQAMPackage.GA_REL_STEP__RES_UNITS:
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
			case GQAMPackage.GA_REL_STEP__REL_RES:
				return relRes != null;
			case GQAMPackage.GA_REL_STEP__RES_UNITS:
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

} //GaRelStepImpl
