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
package org.eclipse.papyrus.eastadl.structure.functionmodeling;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Local Device Manager</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The LocalDeviceManager represents a DesignFunction that act as a manager or functional interface to Sensors, Actuators and other devices. It is responsible fort translating between the electrical/logical interface of the device, as provided by a BasicSoftwareFunction, and the physical interface of the device. For example, consider a temperature sensor with voltage output. The HardwareFunctionType defines the transfer from temperature to voltage. A BasicSoftwareFunction relays the voltage from the microcontroller’s I/O. The role of the LocalDeviceManager is now to translate from voltage to temperature value, taking into account the sensor’s characteristics such as nonlinearities, calibration, etc. The resulting temperature is available to the other DesignFunctions. By separating the device specific part from the middleware and ECU specific parts, it is possible to systematically change interface function together with the device. 
 * 
 * 
 * Semantics:
 * The LocalDeviceManager encapsulates the device-specific or functional parts of a Sensor or, Actuator, device, etc. interface.
 * 
 * 
 * Constraints:
 * [1] A DesignFunctionPrototype typed by a LocalDeviceManager shall be allocated to the same ECU node as the device that it manages is connected to.
 * 
 * [2] A LocalDeviceManager may only interface either Sensors or Actuators.
 * 
 * [3] A LocalDeviceManager shall interface BSWFunctions and DesignFunctions. 
 * 
 * 
 * Extension: Class, specialization of SysML::Block
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage#getLocalDeviceManager()
 * @model
 * @generated
 */
public interface LocalDeviceManager extends DesignFunctionType {
} // LocalDeviceManager
