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
package org.eclipse.papyrus.eastadl.structure.hardwaremodeling;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwaremodelingPackage
 * @generated
 */
public interface HardwaremodelingFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	HardwaremodelingFactory eINSTANCE = org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwaremodelingFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Actuator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Actuator</em>'.
	 * @generated
	 */
	Actuator createActuator();

	/**
	 * Returns a new object of class '<em>Communication Hardware Pin</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Communication Hardware Pin</em>'.
	 * @generated
	 */
	CommunicationHardwarePin createCommunicationHardwarePin();

	/**
	 * Returns a new object of class '<em>Hardware Component Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hardware Component Prototype</em>'.
	 * @generated
	 */
	HardwareComponentPrototype createHardwareComponentPrototype();

	/**
	 * Returns a new object of class '<em>IO Hardware Pin</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IO Hardware Pin</em>'.
	 * @generated
	 */
	IOHardwarePin createIOHardwarePin();

	/**
	 * Returns a new object of class '<em>Hardware Component Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hardware Component Type</em>'.
	 * @generated
	 */
	HardwareComponentType createHardwareComponentType();

	/**
	 * Returns a new object of class '<em>Hardware Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hardware Connector</em>'.
	 * @generated
	 */
	HardwareConnector createHardwareConnector();

	/**
	 * Returns a new object of class '<em>Hardware Pin Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hardware Pin Group</em>'.
	 * @generated
	 */
	HardwarePinGroup createHardwarePinGroup();

	/**
	 * Returns a new object of class '<em>Logical Bus</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Logical Bus</em>'.
	 * @generated
	 */
	LogicalBus createLogicalBus();

	/**
	 * Returns a new object of class '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Node</em>'.
	 * @generated
	 */
	Node createNode();

	/**
	 * Returns a new object of class '<em>Power Hardware Pin</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Power Hardware Pin</em>'.
	 * @generated
	 */
	PowerHardwarePin createPowerHardwarePin();

	/**
	 * Returns a new object of class '<em>Power Supply</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Power Supply</em>'.
	 * @generated
	 */
	PowerSupply createPowerSupply();

	/**
	 * Returns a new object of class '<em>Sensor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sensor</em>'.
	 * @generated
	 */
	Sensor createSensor();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	HardwaremodelingPackage getHardwaremodelingPackage();

} //HardwaremodelingFactory
