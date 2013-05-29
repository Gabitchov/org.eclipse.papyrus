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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentPrototype;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareConnector;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwaremodelingPackage;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.LogicalBus;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.LogicalBusKind;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Logical Bus</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.LogicalBusImpl#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.LogicalBusImpl#getBusSpeed <em>Bus Speed</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.LogicalBusImpl#getBusType <em>Bus Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.LogicalBusImpl#getWire <em>Wire</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.LogicalBusImpl#getWire_path <em>Wire path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LogicalBusImpl extends AllocationTargetImpl implements LogicalBus {
	/**
	 * The cached value of the '{@link #getBase_Class() <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_Class;

	/**
	 * The default value of the '{@link #getBusSpeed() <em>Bus Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBusSpeed()
	 * @generated
	 * @ordered
	 */
	protected static final Float BUS_SPEED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBusSpeed() <em>Bus Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBusSpeed()
	 * @generated
	 * @ordered
	 */
	protected Float busSpeed = BUS_SPEED_EDEFAULT;

	/**
	 * The default value of the '{@link #getBusType() <em>Bus Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBusType()
	 * @generated
	 * @ordered
	 */
	protected static final LogicalBusKind BUS_TYPE_EDEFAULT = LogicalBusKind.TIME_TRIGGERED;

	/**
	 * The cached value of the '{@link #getBusType() <em>Bus Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBusType()
	 * @generated
	 * @ordered
	 */
	protected LogicalBusKind busType = BUS_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getWire() <em>Wire</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWire()
	 * @generated
	 * @ordered
	 */
	protected EList<HardwareConnector> wire;

	/**
	 * The cached value of the '{@link #getWire_path() <em>Wire path</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWire_path()
	 * @generated
	 * @ordered
	 */
	protected EList<HardwareComponentPrototype> wire_path;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LogicalBusImpl() {
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
			case HardwaremodelingPackage.LOGICAL_BUS__BASE_CLASS:
				if (resolve) return getBase_Class();
				return basicGetBase_Class();
			case HardwaremodelingPackage.LOGICAL_BUS__BUS_SPEED:
				return getBusSpeed();
			case HardwaremodelingPackage.LOGICAL_BUS__BUS_TYPE:
				return getBusType();
			case HardwaremodelingPackage.LOGICAL_BUS__WIRE:
				return getWire();
			case HardwaremodelingPackage.LOGICAL_BUS__WIRE_PATH:
				return getWire_path();
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
			case HardwaremodelingPackage.LOGICAL_BUS__BASE_CLASS:
				return base_Class != null;
			case HardwaremodelingPackage.LOGICAL_BUS__BUS_SPEED:
				return BUS_SPEED_EDEFAULT == null ? busSpeed != null : !BUS_SPEED_EDEFAULT.equals(busSpeed);
			case HardwaremodelingPackage.LOGICAL_BUS__BUS_TYPE:
				return busType != BUS_TYPE_EDEFAULT;
			case HardwaremodelingPackage.LOGICAL_BUS__WIRE:
				return wire != null && !wire.isEmpty();
			case HardwaremodelingPackage.LOGICAL_BUS__WIRE_PATH:
				return wire_path != null && !wire_path.isEmpty();
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
			case HardwaremodelingPackage.LOGICAL_BUS__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)newValue);
				return;
			case HardwaremodelingPackage.LOGICAL_BUS__BUS_SPEED:
				setBusSpeed((Float)newValue);
				return;
			case HardwaremodelingPackage.LOGICAL_BUS__BUS_TYPE:
				setBusType((LogicalBusKind)newValue);
				return;
			case HardwaremodelingPackage.LOGICAL_BUS__WIRE:
				getWire().clear();
				getWire().addAll((Collection<? extends HardwareConnector>)newValue);
				return;
			case HardwaremodelingPackage.LOGICAL_BUS__WIRE_PATH:
				getWire_path().clear();
				getWire_path().addAll((Collection<? extends HardwareComponentPrototype>)newValue);
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
		return HardwaremodelingPackage.Literals.LOGICAL_BUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if (base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject)base_Class;
			base_Class = (org.eclipse.uml2.uml.Class)eResolveProxy(oldBase_Class);
			if (base_Class != oldBase_Class) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HardwaremodelingPackage.LOGICAL_BUS__BASE_CLASS, oldBase_Class, base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_Class() {
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HardwaremodelingPackage.LOGICAL_BUS__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case HardwaremodelingPackage.LOGICAL_BUS__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)null);
				return;
			case HardwaremodelingPackage.LOGICAL_BUS__BUS_SPEED:
				setBusSpeed(BUS_SPEED_EDEFAULT);
				return;
			case HardwaremodelingPackage.LOGICAL_BUS__BUS_TYPE:
				setBusType(BUS_TYPE_EDEFAULT);
				return;
			case HardwaremodelingPackage.LOGICAL_BUS__WIRE:
				getWire().clear();
				return;
			case HardwaremodelingPackage.LOGICAL_BUS__WIRE_PATH:
				getWire_path().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getBusSpeed() {
		return busSpeed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicalBusKind getBusType() {
		return busType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HardwareConnector> getWire() {
		if (wire == null) {
			wire = new EObjectResolvingEList<HardwareConnector>(HardwareConnector.class, this, HardwaremodelingPackage.LOGICAL_BUS__WIRE);
		}
		return wire;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HardwareComponentPrototype> getWire_path() {
		if (wire_path == null) {
			wire_path = new EObjectResolvingEList<HardwareComponentPrototype>(HardwareComponentPrototype.class, this, HardwaremodelingPackage.LOGICAL_BUS__WIRE_PATH);
		}
		return wire_path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBusSpeed(Float newBusSpeed) {
		Float oldBusSpeed = busSpeed;
		busSpeed = newBusSpeed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HardwaremodelingPackage.LOGICAL_BUS__BUS_SPEED, oldBusSpeed, busSpeed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBusType(LogicalBusKind newBusType) {
		LogicalBusKind oldBusType = busType;
		busType = newBusType == null ? BUS_TYPE_EDEFAULT : newBusType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HardwaremodelingPackage.LOGICAL_BUS__BUS_TYPE, oldBusType, busType));
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
		result.append(" (busSpeed: ");
		result.append(busSpeed);
		result.append(", busType: ");
		result.append(busType);
		result.append(')');
		return result.toString();
	}

} //LogicalBusImpl
