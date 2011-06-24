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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwDevice.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwDevice.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HwDeviceFactoryImpl extends EFactoryImpl implements HwDeviceFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static HwDeviceFactory init() {
		try {
			HwDeviceFactory theHwDeviceFactory = (HwDeviceFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/HwDevice/1"); 
			if (theHwDeviceFactory != null) {
				return theHwDeviceFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new HwDeviceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HwDeviceFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case HwDevicePackage.HW_DEVICE: return createHwDevice();
			case HwDevicePackage.HW_IO: return createHwI_O();
			case HwDevicePackage.HW_SUPPORT: return createHwSupport();
			case HwDevicePackage.HW_ACTUATOR: return createHWActuator();
			case HwDevicePackage.HW_SENSOR: return createHWSensor();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HwDevice createHwDevice() {
		HwDeviceImpl hwDevice = new HwDeviceImpl();
		return hwDevice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HwI_O createHwI_O() {
		HwI_OImpl hwI_O = new HwI_OImpl();
		return hwI_O;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HwSupport createHwSupport() {
		HwSupportImpl hwSupport = new HwSupportImpl();
		return hwSupport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HWActuator createHWActuator() {
		HWActuatorImpl hwActuator = new HWActuatorImpl();
		return hwActuator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HWSensor createHWSensor() {
		HWSensorImpl hwSensor = new HWSensorImpl();
		return hwSensor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HwDevicePackage getHwDevicePackage() {
		return (HwDevicePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static HwDevicePackage getPackage() {
		return HwDevicePackage.eINSTANCE;
	}

} //HwDeviceFactoryImpl
