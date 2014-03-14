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
package org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwaremodelingPackage;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.Node;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.NodeImpl#getExecutionRate <em>Execution Rate</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.NodeImpl#getNonVolatileMemory <em>Non Volatile Memory</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.NodeImpl#getVolatileMemory <em>Volatile Memory</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class NodeImpl extends HardwareComponentTypeImpl implements Node {

	/**
	 * The default value of the '{@link #getExecutionRate() <em>Execution Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getExecutionRate()
	 * @generated
	 * @ordered
	 */
	protected static final Float EXECUTION_RATE_EDEFAULT = new Float(1.0F);

	/**
	 * The cached value of the '{@link #getExecutionRate() <em>Execution Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getExecutionRate()
	 * @generated
	 * @ordered
	 */
	protected Float executionRate = EXECUTION_RATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getNonVolatileMemory() <em>Non Volatile Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getNonVolatileMemory()
	 * @generated
	 * @ordered
	 */
	protected static final int NON_VOLATILE_MEMORY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNonVolatileMemory() <em>Non Volatile Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getNonVolatileMemory()
	 * @generated
	 * @ordered
	 */
	protected int nonVolatileMemory = NON_VOLATILE_MEMORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getVolatileMemory() <em>Volatile Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getVolatileMemory()
	 * @generated
	 * @ordered
	 */
	protected static final int VOLATILE_MEMORY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getVolatileMemory() <em>Volatile Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getVolatileMemory()
	 * @generated
	 * @ordered
	 */
	protected int volatileMemory = VOLATILE_MEMORY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected NodeImpl() {
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
		case HardwaremodelingPackage.NODE__EXECUTION_RATE:
			return getExecutionRate();
		case HardwaremodelingPackage.NODE__NON_VOLATILE_MEMORY:
			return getNonVolatileMemory();
		case HardwaremodelingPackage.NODE__VOLATILE_MEMORY:
			return getVolatileMemory();
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
		case HardwaremodelingPackage.NODE__EXECUTION_RATE:
			return EXECUTION_RATE_EDEFAULT == null ? executionRate != null : !EXECUTION_RATE_EDEFAULT.equals(executionRate);
		case HardwaremodelingPackage.NODE__NON_VOLATILE_MEMORY:
			return nonVolatileMemory != NON_VOLATILE_MEMORY_EDEFAULT;
		case HardwaremodelingPackage.NODE__VOLATILE_MEMORY:
			return volatileMemory != VOLATILE_MEMORY_EDEFAULT;
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
		case HardwaremodelingPackage.NODE__EXECUTION_RATE:
			setExecutionRate((Float)newValue);
			return;
		case HardwaremodelingPackage.NODE__NON_VOLATILE_MEMORY:
			setNonVolatileMemory((Integer)newValue);
			return;
		case HardwaremodelingPackage.NODE__VOLATILE_MEMORY:
			setVolatileMemory((Integer)newValue);
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
		return HardwaremodelingPackage.Literals.NODE;
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
		case HardwaremodelingPackage.NODE__EXECUTION_RATE:
			setExecutionRate(EXECUTION_RATE_EDEFAULT);
			return;
		case HardwaremodelingPackage.NODE__NON_VOLATILE_MEMORY:
			setNonVolatileMemory(NON_VOLATILE_MEMORY_EDEFAULT);
			return;
		case HardwaremodelingPackage.NODE__VOLATILE_MEMORY:
			setVolatileMemory(VOLATILE_MEMORY_EDEFAULT);
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
	public Float getExecutionRate() {
		return executionRate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getNonVolatileMemory() {
		return nonVolatileMemory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getVolatileMemory() {
		return volatileMemory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setExecutionRate(Float newExecutionRate) {
		Float oldExecutionRate = executionRate;
		executionRate = newExecutionRate;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HardwaremodelingPackage.NODE__EXECUTION_RATE, oldExecutionRate, executionRate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setNonVolatileMemory(int newNonVolatileMemory) {
		int oldNonVolatileMemory = nonVolatileMemory;
		nonVolatileMemory = newNonVolatileMemory;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HardwaremodelingPackage.NODE__NON_VOLATILE_MEMORY, oldNonVolatileMemory, nonVolatileMemory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setVolatileMemory(int newVolatileMemory) {
		int oldVolatileMemory = volatileMemory;
		volatileMemory = newVolatileMemory;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HardwaremodelingPackage.NODE__VOLATILE_MEMORY, oldVolatileMemory, volatileMemory));
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
		result.append(" (executionRate: ");
		result.append(executionRate);
		result.append(", nonVolatileMemory: ");
		result.append(nonVolatileMemory);
		result.append(", volatileMemory: ");
		result.append(volatileMemory);
		result.append(')');
		return result.toString();
	}

} //NodeImpl
