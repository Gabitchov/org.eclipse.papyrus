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
package org.eclipse.papyrus.eastadl.dependability.safetyconstraints.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.eastadl.dependability.errormodel.Anomaly;
import org.eclipse.papyrus.eastadl.dependability.safetyconstraints.FaultFailure;
import org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyconstraintsPackage;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.TraceableSpecificationImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fault Failure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.impl.FaultFailureImpl#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.impl.FaultFailureImpl#getFaultFailureValue <em>Fault Failure Value</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.impl.FaultFailureImpl#getAnomaly <em>Anomaly</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class FaultFailureImpl extends TraceableSpecificationImpl implements FaultFailure {

	/**
	 * The cached value of the '{@link #getBase_Class() <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBase_Class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_Class;

	/**
	 * The default value of the '{@link #getFaultFailureValue() <em>Fault Failure Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getFaultFailureValue()
	 * @generated
	 * @ordered
	 */
	protected static final String FAULT_FAILURE_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFaultFailureValue() <em>Fault Failure Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getFaultFailureValue()
	 * @generated
	 * @ordered
	 */
	protected String faultFailureValue = FAULT_FAILURE_VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAnomaly() <em>Anomaly</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getAnomaly()
	 * @generated
	 * @ordered
	 */
	protected Anomaly anomaly;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected FaultFailureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Anomaly basicGetAnomaly() {
		return anomaly;
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
		case SafetyconstraintsPackage.FAULT_FAILURE__BASE_CLASS:
			if(resolve)
				return getBase_Class();
			return basicGetBase_Class();
		case SafetyconstraintsPackage.FAULT_FAILURE__FAULT_FAILURE_VALUE:
			return getFaultFailureValue();
		case SafetyconstraintsPackage.FAULT_FAILURE__ANOMALY:
			if(resolve)
				return getAnomaly();
			return basicGetAnomaly();
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
		case SafetyconstraintsPackage.FAULT_FAILURE__BASE_CLASS:
			return base_Class != null;
		case SafetyconstraintsPackage.FAULT_FAILURE__FAULT_FAILURE_VALUE:
			return FAULT_FAILURE_VALUE_EDEFAULT == null ? faultFailureValue != null : !FAULT_FAILURE_VALUE_EDEFAULT.equals(faultFailureValue);
		case SafetyconstraintsPackage.FAULT_FAILURE__ANOMALY:
			return anomaly != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case SafetyconstraintsPackage.FAULT_FAILURE__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)newValue);
			return;
		case SafetyconstraintsPackage.FAULT_FAILURE__FAULT_FAILURE_VALUE:
			setFaultFailureValue((String)newValue);
			return;
		case SafetyconstraintsPackage.FAULT_FAILURE__ANOMALY:
			setAnomaly((Anomaly)newValue);
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
		return SafetyconstraintsPackage.Literals.FAULT_FAILURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if(base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject)base_Class;
			base_Class = (org.eclipse.uml2.uml.Class)eResolveProxy(oldBase_Class);
			if(base_Class != oldBase_Class) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SafetyconstraintsPackage.FAULT_FAILURE__BASE_CLASS, oldBase_Class, base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_Class() {
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SafetyconstraintsPackage.FAULT_FAILURE__BASE_CLASS, oldBase_Class, base_Class));
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
		case SafetyconstraintsPackage.FAULT_FAILURE__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)null);
			return;
		case SafetyconstraintsPackage.FAULT_FAILURE__FAULT_FAILURE_VALUE:
			setFaultFailureValue(FAULT_FAILURE_VALUE_EDEFAULT);
			return;
		case SafetyconstraintsPackage.FAULT_FAILURE__ANOMALY:
			setAnomaly((Anomaly)null);
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
	public Anomaly getAnomaly() {
		if(anomaly != null && anomaly.eIsProxy()) {
			InternalEObject oldAnomaly = (InternalEObject)anomaly;
			anomaly = (Anomaly)eResolveProxy(oldAnomaly);
			if(anomaly != oldAnomaly) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SafetyconstraintsPackage.FAULT_FAILURE__ANOMALY, oldAnomaly, anomaly));
			}
		}
		return anomaly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getFaultFailureValue() {
		return faultFailureValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAnomaly(Anomaly newAnomaly) {
		Anomaly oldAnomaly = anomaly;
		anomaly = newAnomaly;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SafetyconstraintsPackage.FAULT_FAILURE__ANOMALY, oldAnomaly, anomaly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setFaultFailureValue(String newFaultFailureValue) {
		String oldFaultFailureValue = faultFailureValue;
		faultFailureValue = newFaultFailureValue;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SafetyconstraintsPackage.FAULT_FAILURE__FAULT_FAILURE_VALUE, oldFaultFailureValue, faultFailureValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if(eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (faultFailureValue: ");
		result.append(faultFailureValue);
		result.append(')');
		return result.toString();
	}

} //FaultFailureImpl
