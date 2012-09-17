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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaTimedObs;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.LaxityKind;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.NfpConstraintImpl;
import org.eclipse.uml2.uml.TimeObservation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ga Timed Obs</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaTimedObsImpl#getLaxity <em>Laxity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaTimedObsImpl#getStartObs <em>Start Obs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaTimedObsImpl#getEndObs <em>End Obs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GaTimedObsImpl extends NfpConstraintImpl implements GaTimedObs {
	/**
	 * The default value of the '{@link #getLaxity() <em>Laxity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLaxity()
	 * @generated
	 * @ordered
	 */
	protected static final LaxityKind LAXITY_EDEFAULT = LaxityKind.HARD;

	/**
	 * The cached value of the '{@link #getLaxity() <em>Laxity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLaxity()
	 * @generated
	 * @ordered
	 */
	protected LaxityKind laxity = LAXITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStartObs() <em>Start Obs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartObs()
	 * @generated
	 * @ordered
	 */
	protected EList<TimeObservation> startObs;

	/**
	 * The cached value of the '{@link #getEndObs() <em>End Obs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndObs()
	 * @generated
	 * @ordered
	 */
	protected EList<TimeObservation> endObs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GaTimedObsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GQAMPackage.Literals.GA_TIMED_OBS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LaxityKind getLaxity() {
		return laxity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLaxity(LaxityKind newLaxity) {
		LaxityKind oldLaxity = laxity;
		laxity = newLaxity == null ? LAXITY_EDEFAULT : newLaxity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GQAMPackage.GA_TIMED_OBS__LAXITY, oldLaxity, laxity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TimeObservation> getStartObs() {
		if (startObs == null) {
			startObs = new EObjectResolvingEList<TimeObservation>(TimeObservation.class, this, GQAMPackage.GA_TIMED_OBS__START_OBS);
		}
		return startObs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TimeObservation> getEndObs() {
		if (endObs == null) {
			endObs = new EObjectResolvingEList<TimeObservation>(TimeObservation.class, this, GQAMPackage.GA_TIMED_OBS__END_OBS);
		}
		return endObs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GQAMPackage.GA_TIMED_OBS__LAXITY:
				return getLaxity();
			case GQAMPackage.GA_TIMED_OBS__START_OBS:
				return getStartObs();
			case GQAMPackage.GA_TIMED_OBS__END_OBS:
				return getEndObs();
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
			case GQAMPackage.GA_TIMED_OBS__LAXITY:
				setLaxity((LaxityKind)newValue);
				return;
			case GQAMPackage.GA_TIMED_OBS__START_OBS:
				getStartObs().clear();
				getStartObs().addAll((Collection<? extends TimeObservation>)newValue);
				return;
			case GQAMPackage.GA_TIMED_OBS__END_OBS:
				getEndObs().clear();
				getEndObs().addAll((Collection<? extends TimeObservation>)newValue);
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
			case GQAMPackage.GA_TIMED_OBS__LAXITY:
				setLaxity(LAXITY_EDEFAULT);
				return;
			case GQAMPackage.GA_TIMED_OBS__START_OBS:
				getStartObs().clear();
				return;
			case GQAMPackage.GA_TIMED_OBS__END_OBS:
				getEndObs().clear();
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
			case GQAMPackage.GA_TIMED_OBS__LAXITY:
				return laxity != LAXITY_EDEFAULT;
			case GQAMPackage.GA_TIMED_OBS__START_OBS:
				return startObs != null && !startObs.isEmpty();
			case GQAMPackage.GA_TIMED_OBS__END_OBS:
				return endObs != null && !endObs.isEmpty();
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
		result.append(" (laxity: ");
		result.append(laxity);
		result.append(')');
		return result.toString();
	}

} //GaTimedObsImpl
