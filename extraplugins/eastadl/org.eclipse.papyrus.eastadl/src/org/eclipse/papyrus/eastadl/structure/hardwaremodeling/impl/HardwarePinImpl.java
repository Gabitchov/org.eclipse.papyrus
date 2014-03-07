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
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.EAElementImpl;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.EADirectionKind;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePin;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwaremodelingPackage;
import org.eclipse.uml2.uml.Port;


/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Hardware Pin</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwarePinImpl#getBase_Port <em>Base Port</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwarePinImpl#isIsGround <em>Is Ground</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwarePinImpl#getVoltage <em>Voltage</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwarePinImpl#getDirection <em>Direction</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwarePinImpl#getImpedance <em>Impedance</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwarePinImpl#getPower <em>Power</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class HardwarePinImpl extends EAElementImpl implements HardwarePin {

	/**
	 * The cached value of the '{@link #getBase_Port() <em>Base Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBase_Port()
	 * @generated
	 * @ordered
	 */
	protected Port base_Port;

	/**
	 * The default value of the '{@link #isIsGround() <em>Is Ground</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isIsGround()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_GROUND_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsGround() <em>Is Ground</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isIsGround()
	 * @generated
	 * @ordered
	 */
	protected boolean isGround = IS_GROUND_EDEFAULT;

	/**
	 * The default value of the '{@link #getVoltage() <em>Voltage</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getVoltage()
	 * @generated
	 * @ordered
	 */
	protected static final Float VOLTAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVoltage() <em>Voltage</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getVoltage()
	 * @generated
	 * @ordered
	 */
	protected Float voltage = VOLTAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected static final EADirectionKind DIRECTION_EDEFAULT = EADirectionKind.IN;

	/**
	 * The cached value of the '{@link #getDirection() <em>Direction</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected EADirectionKind direction = DIRECTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getImpedance() <em>Impedance</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getImpedance()
	 * @generated
	 * @ordered
	 */
	protected static final Float IMPEDANCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImpedance() <em>Impedance</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getImpedance()
	 * @generated
	 * @ordered
	 */
	protected Float impedance = IMPEDANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPower() <em>Power</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getPower()
	 * @generated
	 * @ordered
	 */
	protected static final Float POWER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPower() <em>Power</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getPower()
	 * @generated
	 * @ordered
	 */
	protected Float power = POWER_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected HardwarePinImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case HardwaremodelingPackage.HARDWARE_PIN__BASE_PORT:
			if(resolve)
				return getBase_Port();
			return basicGetBase_Port();
		case HardwaremodelingPackage.HARDWARE_PIN__IS_GROUND:
			return isIsGround();
		case HardwaremodelingPackage.HARDWARE_PIN__VOLTAGE:
			return getVoltage();
		case HardwaremodelingPackage.HARDWARE_PIN__DIRECTION:
			return getDirection();
		case HardwaremodelingPackage.HARDWARE_PIN__IMPEDANCE:
			return getImpedance();
		case HardwaremodelingPackage.HARDWARE_PIN__POWER:
			return getPower();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case HardwaremodelingPackage.HARDWARE_PIN__BASE_PORT:
			return base_Port != null;
		case HardwaremodelingPackage.HARDWARE_PIN__IS_GROUND:
			return isGround != IS_GROUND_EDEFAULT;
		case HardwaremodelingPackage.HARDWARE_PIN__VOLTAGE:
			return VOLTAGE_EDEFAULT == null ? voltage != null : !VOLTAGE_EDEFAULT.equals(voltage);
		case HardwaremodelingPackage.HARDWARE_PIN__DIRECTION:
			return direction != DIRECTION_EDEFAULT;
		case HardwaremodelingPackage.HARDWARE_PIN__IMPEDANCE:
			return IMPEDANCE_EDEFAULT == null ? impedance != null : !IMPEDANCE_EDEFAULT.equals(impedance);
		case HardwaremodelingPackage.HARDWARE_PIN__POWER:
			return POWER_EDEFAULT == null ? power != null : !POWER_EDEFAULT.equals(power);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case HardwaremodelingPackage.HARDWARE_PIN__BASE_PORT:
			setBase_Port((Port)newValue);
			return;
		case HardwaremodelingPackage.HARDWARE_PIN__IS_GROUND:
			setIsGround((Boolean)newValue);
			return;
		case HardwaremodelingPackage.HARDWARE_PIN__VOLTAGE:
			setVoltage((Float)newValue);
			return;
		case HardwaremodelingPackage.HARDWARE_PIN__DIRECTION:
			setDirection((EADirectionKind)newValue);
			return;
		case HardwaremodelingPackage.HARDWARE_PIN__IMPEDANCE:
			setImpedance((Float)newValue);
			return;
		case HardwaremodelingPackage.HARDWARE_PIN__POWER:
			setPower((Float)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HardwaremodelingPackage.Literals.HARDWARE_PIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Port getBase_Port() {
		if(base_Port != null && base_Port.eIsProxy()) {
			InternalEObject oldBase_Port = (InternalEObject)base_Port;
			base_Port = (Port)eResolveProxy(oldBase_Port);
			if(base_Port != oldBase_Port) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HardwaremodelingPackage.HARDWARE_PIN__BASE_PORT, oldBase_Port, base_Port));
			}
		}
		return base_Port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Port basicGetBase_Port() {
		return base_Port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_Port(Port newBase_Port) {
		Port oldBase_Port = base_Port;
		base_Port = newBase_Port;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HardwaremodelingPackage.HARDWARE_PIN__BASE_PORT, oldBase_Port, base_Port));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case HardwaremodelingPackage.HARDWARE_PIN__BASE_PORT:
			setBase_Port((Port)null);
			return;
		case HardwaremodelingPackage.HARDWARE_PIN__IS_GROUND:
			setIsGround(IS_GROUND_EDEFAULT);
			return;
		case HardwaremodelingPackage.HARDWARE_PIN__VOLTAGE:
			setVoltage(VOLTAGE_EDEFAULT);
			return;
		case HardwaremodelingPackage.HARDWARE_PIN__DIRECTION:
			setDirection(DIRECTION_EDEFAULT);
			return;
		case HardwaremodelingPackage.HARDWARE_PIN__IMPEDANCE:
			setImpedance(IMPEDANCE_EDEFAULT);
			return;
		case HardwaremodelingPackage.HARDWARE_PIN__POWER:
			setPower(POWER_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EADirectionKind getDirection() {
		return direction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDirection(EADirectionKind newDirection) {
		EADirectionKind oldDirection = direction;
		direction = newDirection == null ? DIRECTION_EDEFAULT : newDirection;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HardwaremodelingPackage.HARDWARE_PIN__DIRECTION, oldDirection, direction));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Float getImpedance() {
		return impedance;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Float getPower() {
		return power;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Float getVoltage() {
		return voltage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isIsGround() {
		return isGround;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setImpedance(Float newImpedance) {
		Float oldImpedance = impedance;
		impedance = newImpedance;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HardwaremodelingPackage.HARDWARE_PIN__IMPEDANCE, oldImpedance, impedance));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setIsGround(boolean newIsGround) {
		boolean oldIsGround = isGround;
		isGround = newIsGround;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HardwaremodelingPackage.HARDWARE_PIN__IS_GROUND, oldIsGround, isGround));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setPower(Float newPower) {
		Float oldPower = power;
		power = newPower;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HardwaremodelingPackage.HARDWARE_PIN__POWER, oldPower, power));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setVoltage(Float newVoltage) {
		Float oldVoltage = voltage;
		voltage = newVoltage;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HardwaremodelingPackage.HARDWARE_PIN__VOLTAGE, oldVoltage, voltage));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if(eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isGround: ");
		result.append(isGround);
		result.append(", voltage: ");
		result.append(voltage);
		result.append(", direction: ");
		result.append(direction);
		result.append(", impedance: ");
		result.append(impedance);
		result.append(", power: ");
		result.append(power);
		result.append(')');
		return result.toString();
	}

} // HardwarePinImpl
