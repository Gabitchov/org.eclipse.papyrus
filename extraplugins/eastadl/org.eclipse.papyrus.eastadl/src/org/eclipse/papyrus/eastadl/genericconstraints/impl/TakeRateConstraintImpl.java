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
package org.eclipse.papyrus.eastadl.genericconstraints.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.genericconstraints.GenericconstraintsPackage;
import org.eclipse.papyrus.eastadl.genericconstraints.TakeRateConstraint;
import org.eclipse.uml2.uml.NamedElement;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Take Rate Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.genericconstraints.impl.TakeRateConstraintImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.genericconstraints.impl.TakeRateConstraintImpl#getTakeRate <em>Take Rate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TakeRateConstraintImpl extends GenericConstraintImpl implements TakeRateConstraint {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected EList<NamedElement> source;

	/**
	 * The default value of the '{@link #getTakeRate() <em>Take Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTakeRate()
	 * @generated
	 * @ordered
	 */
	protected static final Float TAKE_RATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTakeRate() <em>Take Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTakeRate()
	 * @generated
	 * @ordered
	 */
	protected Float takeRate = TAKE_RATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TakeRateConstraintImpl() {
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
			case GenericconstraintsPackage.TAKE_RATE_CONSTRAINT__SOURCE:
				return getSource();
			case GenericconstraintsPackage.TAKE_RATE_CONSTRAINT__TAKE_RATE:
				return getTakeRate();
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
			case GenericconstraintsPackage.TAKE_RATE_CONSTRAINT__SOURCE:
				return source != null && !source.isEmpty();
			case GenericconstraintsPackage.TAKE_RATE_CONSTRAINT__TAKE_RATE:
				return TAKE_RATE_EDEFAULT == null ? takeRate != null : !TAKE_RATE_EDEFAULT.equals(takeRate);
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
			case GenericconstraintsPackage.TAKE_RATE_CONSTRAINT__SOURCE:
				getSource().clear();
				getSource().addAll((Collection<? extends NamedElement>)newValue);
				return;
			case GenericconstraintsPackage.TAKE_RATE_CONSTRAINT__TAKE_RATE:
				setTakeRate((Float)newValue);
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
		return GenericconstraintsPackage.Literals.TAKE_RATE_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GenericconstraintsPackage.TAKE_RATE_CONSTRAINT__SOURCE:
				getSource().clear();
				return;
			case GenericconstraintsPackage.TAKE_RATE_CONSTRAINT__TAKE_RATE:
				setTakeRate(TAKE_RATE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NamedElement> getSource() {
		if (source == null) {
			source = new EObjectResolvingEList<NamedElement>(NamedElement.class, this, GenericconstraintsPackage.TAKE_RATE_CONSTRAINT__SOURCE);
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getTakeRate() {
		return takeRate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTakeRate(Float newTakeRate) {
		Float oldTakeRate = takeRate;
		takeRate = newTakeRate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenericconstraintsPackage.TAKE_RATE_CONSTRAINT__TAKE_RATE, oldTakeRate, takeRate));
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
		result.append(" (takeRate: ");
		result.append(takeRate);
		result.append(')');
		return result.toString();
	}

} //TakeRateConstraintImpl
