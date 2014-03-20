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
package org.eclipse.papyrus.eastadl.timing.timingconstraints.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.timing.TimeDuration;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.ArbitraryEventConstraint;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.TimingconstraintsPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Arbitrary Event Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.ArbitraryEventConstraintImpl#getMinimumInterArrivalTime <em>Minimum Inter
 * Arrival Time</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.ArbitraryEventConstraintImpl#getMaximumInterArrivalTime <em>Maximum Inter
 * Arrival Time</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ArbitraryEventConstraintImpl extends EventConstraintImpl implements ArbitraryEventConstraint {

	/**
	 * The cached value of the '{@link #getMinimumInterArrivalTime() <em>Minimum Inter Arrival Time</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getMinimumInterArrivalTime()
	 * @generated
	 * @ordered
	 */
	protected EList<TimeDuration> minimumInterArrivalTime;

	/**
	 * The cached value of the '{@link #getMaximumInterArrivalTime() <em>Maximum Inter Arrival Time</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getMaximumInterArrivalTime()
	 * @generated
	 * @ordered
	 */
	protected EList<TimeDuration> maximumInterArrivalTime;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ArbitraryEventConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case TimingconstraintsPackage.ARBITRARY_EVENT_CONSTRAINT__MINIMUM_INTER_ARRIVAL_TIME:
			return getMinimumInterArrivalTime();
		case TimingconstraintsPackage.ARBITRARY_EVENT_CONSTRAINT__MAXIMUM_INTER_ARRIVAL_TIME:
			return getMaximumInterArrivalTime();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case TimingconstraintsPackage.ARBITRARY_EVENT_CONSTRAINT__MINIMUM_INTER_ARRIVAL_TIME:
			return minimumInterArrivalTime != null && !minimumInterArrivalTime.isEmpty();
		case TimingconstraintsPackage.ARBITRARY_EVENT_CONSTRAINT__MAXIMUM_INTER_ARRIVAL_TIME:
			return maximumInterArrivalTime != null && !maximumInterArrivalTime.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case TimingconstraintsPackage.ARBITRARY_EVENT_CONSTRAINT__MINIMUM_INTER_ARRIVAL_TIME:
			getMinimumInterArrivalTime().clear();
			getMinimumInterArrivalTime().addAll((Collection<? extends TimeDuration>)newValue);
			return;
		case TimingconstraintsPackage.ARBITRARY_EVENT_CONSTRAINT__MAXIMUM_INTER_ARRIVAL_TIME:
			getMaximumInterArrivalTime().clear();
			getMaximumInterArrivalTime().addAll((Collection<? extends TimeDuration>)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TimingconstraintsPackage.Literals.ARBITRARY_EVENT_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case TimingconstraintsPackage.ARBITRARY_EVENT_CONSTRAINT__MINIMUM_INTER_ARRIVAL_TIME:
			getMinimumInterArrivalTime().clear();
			return;
		case TimingconstraintsPackage.ARBITRARY_EVENT_CONSTRAINT__MAXIMUM_INTER_ARRIVAL_TIME:
			getMaximumInterArrivalTime().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<TimeDuration> getMaximumInterArrivalTime() {
		if(maximumInterArrivalTime == null) {
			maximumInterArrivalTime = new EObjectResolvingEList<TimeDuration>(TimeDuration.class, this, TimingconstraintsPackage.ARBITRARY_EVENT_CONSTRAINT__MAXIMUM_INTER_ARRIVAL_TIME);
		}
		return maximumInterArrivalTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<TimeDuration> getMinimumInterArrivalTime() {
		if(minimumInterArrivalTime == null) {
			minimumInterArrivalTime = new EObjectResolvingEList<TimeDuration>(TimeDuration.class, this, TimingconstraintsPackage.ARBITRARY_EVENT_CONSTRAINT__MINIMUM_INTER_ARRIVAL_TIME);
		}
		return minimumInterArrivalTime;
	}

} //ArbitraryEventConstraintImpl
