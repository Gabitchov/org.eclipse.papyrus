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
package org.eclipse.papyrus.eastadl.dependability.errormodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage;
import org.eclipse.papyrus.eastadl.dependability.errormodel.FaultFailurePort;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPort;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPrototype;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentPrototype;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePin;
import org.eclipse.uml2.uml.Port;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fault Failure Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.FaultFailurePortImpl#getBase_Port <em>Base Port</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.FaultFailurePortImpl#getFunctionTarget <em>Function Target</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.FaultFailurePortImpl#getHwTarget <em>Hw Target</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.FaultFailurePortImpl#getFunctionTarget_path <em>Function Target path</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.FaultFailurePortImpl#getHwTarget_path <em>Hw Target path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FaultFailurePortImpl extends AnomalyImpl implements FaultFailurePort {
	/**
	 * The cached value of the '{@link #getBase_Port() <em>Base Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Port()
	 * @generated
	 * @ordered
	 */
	protected Port base_Port;

	/**
	 * The cached value of the '{@link #getFunctionTarget() <em>Function Target</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionTarget()
	 * @generated
	 * @ordered
	 */
	protected EList<FunctionPort> functionTarget;

	/**
	 * The cached value of the '{@link #getHwTarget() <em>Hw Target</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHwTarget()
	 * @generated
	 * @ordered
	 */
	protected EList<HardwarePin> hwTarget;

	/**
	 * The cached value of the '{@link #getFunctionTarget_path() <em>Function Target path</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionTarget_path()
	 * @generated
	 * @ordered
	 */
	protected EList<FunctionPrototype> functionTarget_path;

	/**
	 * The cached value of the '{@link #getHwTarget_path() <em>Hw Target path</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHwTarget_path()
	 * @generated
	 * @ordered
	 */
	protected EList<HardwareComponentPrototype> hwTarget_path;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FaultFailurePortImpl() {
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
			case ErrormodelPackage.FAULT_FAILURE_PORT__BASE_PORT:
				if (resolve) return getBase_Port();
				return basicGetBase_Port();
			case ErrormodelPackage.FAULT_FAILURE_PORT__FUNCTION_TARGET:
				return getFunctionTarget();
			case ErrormodelPackage.FAULT_FAILURE_PORT__HW_TARGET:
				return getHwTarget();
			case ErrormodelPackage.FAULT_FAILURE_PORT__FUNCTION_TARGET_PATH:
				return getFunctionTarget_path();
			case ErrormodelPackage.FAULT_FAILURE_PORT__HW_TARGET_PATH:
				return getHwTarget_path();
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
			case ErrormodelPackage.FAULT_FAILURE_PORT__BASE_PORT:
				return base_Port != null;
			case ErrormodelPackage.FAULT_FAILURE_PORT__FUNCTION_TARGET:
				return functionTarget != null && !functionTarget.isEmpty();
			case ErrormodelPackage.FAULT_FAILURE_PORT__HW_TARGET:
				return hwTarget != null && !hwTarget.isEmpty();
			case ErrormodelPackage.FAULT_FAILURE_PORT__FUNCTION_TARGET_PATH:
				return functionTarget_path != null && !functionTarget_path.isEmpty();
			case ErrormodelPackage.FAULT_FAILURE_PORT__HW_TARGET_PATH:
				return hwTarget_path != null && !hwTarget_path.isEmpty();
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
			case ErrormodelPackage.FAULT_FAILURE_PORT__BASE_PORT:
				setBase_Port((Port)newValue);
				return;
			case ErrormodelPackage.FAULT_FAILURE_PORT__FUNCTION_TARGET:
				getFunctionTarget().clear();
				getFunctionTarget().addAll((Collection<? extends FunctionPort>)newValue);
				return;
			case ErrormodelPackage.FAULT_FAILURE_PORT__HW_TARGET:
				getHwTarget().clear();
				getHwTarget().addAll((Collection<? extends HardwarePin>)newValue);
				return;
			case ErrormodelPackage.FAULT_FAILURE_PORT__FUNCTION_TARGET_PATH:
				getFunctionTarget_path().clear();
				getFunctionTarget_path().addAll((Collection<? extends FunctionPrototype>)newValue);
				return;
			case ErrormodelPackage.FAULT_FAILURE_PORT__HW_TARGET_PATH:
				getHwTarget_path().clear();
				getHwTarget_path().addAll((Collection<? extends HardwareComponentPrototype>)newValue);
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
		return ErrormodelPackage.Literals.FAULT_FAILURE_PORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port getBase_Port() {
		if (base_Port != null && base_Port.eIsProxy()) {
			InternalEObject oldBase_Port = (InternalEObject)base_Port;
			base_Port = (Port)eResolveProxy(oldBase_Port);
			if (base_Port != oldBase_Port) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrormodelPackage.FAULT_FAILURE_PORT__BASE_PORT, oldBase_Port, base_Port));
			}
		}
		return base_Port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port basicGetBase_Port() {
		return base_Port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Port(Port newBase_Port) {
		Port oldBase_Port = base_Port;
		base_Port = newBase_Port;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrormodelPackage.FAULT_FAILURE_PORT__BASE_PORT, oldBase_Port, base_Port));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ErrormodelPackage.FAULT_FAILURE_PORT__BASE_PORT:
				setBase_Port((Port)null);
				return;
			case ErrormodelPackage.FAULT_FAILURE_PORT__FUNCTION_TARGET:
				getFunctionTarget().clear();
				return;
			case ErrormodelPackage.FAULT_FAILURE_PORT__HW_TARGET:
				getHwTarget().clear();
				return;
			case ErrormodelPackage.FAULT_FAILURE_PORT__FUNCTION_TARGET_PATH:
				getFunctionTarget_path().clear();
				return;
			case ErrormodelPackage.FAULT_FAILURE_PORT__HW_TARGET_PATH:
				getHwTarget_path().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FunctionPort> getFunctionTarget() {
		if (functionTarget == null) {
			functionTarget = new EObjectResolvingEList<FunctionPort>(FunctionPort.class, this, ErrormodelPackage.FAULT_FAILURE_PORT__FUNCTION_TARGET);
		}
		return functionTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HardwarePin> getHwTarget() {
		if (hwTarget == null) {
			hwTarget = new EObjectResolvingEList<HardwarePin>(HardwarePin.class, this, ErrormodelPackage.FAULT_FAILURE_PORT__HW_TARGET);
		}
		return hwTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FunctionPrototype> getFunctionTarget_path() {
		if (functionTarget_path == null) {
			functionTarget_path = new EObjectResolvingEList<FunctionPrototype>(FunctionPrototype.class, this, ErrormodelPackage.FAULT_FAILURE_PORT__FUNCTION_TARGET_PATH);
		}
		return functionTarget_path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HardwareComponentPrototype> getHwTarget_path() {
		if (hwTarget_path == null) {
			hwTarget_path = new EObjectResolvingEList<HardwareComponentPrototype>(HardwareComponentPrototype.class, this, ErrormodelPackage.FAULT_FAILURE_PORT__HW_TARGET_PATH);
		}
		return hwTarget_path;
	}

} //FaultFailurePortImpl
