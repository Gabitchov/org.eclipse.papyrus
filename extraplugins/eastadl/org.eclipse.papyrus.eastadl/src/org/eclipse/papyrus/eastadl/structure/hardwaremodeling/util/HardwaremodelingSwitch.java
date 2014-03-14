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
package org.eclipse.papyrus.eastadl.structure.hardwaremodeling.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.papyrus.eastadl.infrastructure.elements.Context;
import org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.*;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.Actuator;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.AllocationTarget;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.CommunicationHardwarePin;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentPrototype;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentType;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareConnector;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePin;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwarePinGroup;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwaremodelingPackage;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.IOHardwarePin;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.LogicalBus;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.Node;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.PowerHardwarePin;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.PowerSupply;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.Sensor;


/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwaremodelingPackage
 * @generated
 */
public class HardwaremodelingSwitch<T> extends Switch<T> {

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static HardwaremodelingPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public HardwaremodelingSwitch() {
		if(modelPackage == null) {
			modelPackage = HardwaremodelingPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Actuator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Actuator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActuator(Actuator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Allocation Target</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Allocation Target</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAllocationTarget(AllocationTarget object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IO Hardware Pin</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IO Hardware Pin</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIOHardwarePin(IOHardwarePin object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Communication Hardware Pin</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Communication Hardware Pin</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommunicationHardwarePin(CommunicationHardwarePin object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContext(Context object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hardware Component Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hardware Component Prototype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHardwareComponentPrototype(HardwareComponentPrototype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hardware Component Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hardware Component Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHardwareComponentType(HardwareComponentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EA Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EA Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEAElement(EAElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hardware Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hardware Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHardwareConnector(HardwareConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hardware Pin</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hardware Pin</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHardwarePin(HardwarePin object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hardware Pin Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hardware Pin Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHardwarePinGroup(HardwarePinGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Logical Bus</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Logical Bus</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLogicalBus(LogicalBus object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNode(Node object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Power Hardware Pin</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Power Hardware Pin</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePowerHardwarePin(PowerHardwarePin object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Power Supply</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Power Supply</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePowerSupply(PowerSupply object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sensor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sensor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSensor(Sensor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch(classifierID) {
		case HardwaremodelingPackage.HARDWARE_CONNECTOR:
		{
			HardwareConnector hardwareConnector = (HardwareConnector)theEObject;
			T result = caseHardwareConnector(hardwareConnector);
			if(result == null)
				result = caseEAElement(hardwareConnector);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case HardwaremodelingPackage.HARDWARE_PIN:
		{
			HardwarePin hardwarePin = (HardwarePin)theEObject;
			T result = caseHardwarePin(hardwarePin);
			if(result == null)
				result = caseEAElement(hardwarePin);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case HardwaremodelingPackage.HARDWARE_COMPONENT_PROTOTYPE:
		{
			HardwareComponentPrototype hardwareComponentPrototype = (HardwareComponentPrototype)theEObject;
			T result = caseHardwareComponentPrototype(hardwareComponentPrototype);
			if(result == null)
				result = caseAllocationTarget(hardwareComponentPrototype);
			if(result == null)
				result = caseEAElement(hardwareComponentPrototype);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case HardwaremodelingPackage.ALLOCATION_TARGET:
		{
			AllocationTarget allocationTarget = (AllocationTarget)theEObject;
			T result = caseAllocationTarget(allocationTarget);
			if(result == null)
				result = caseEAElement(allocationTarget);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case HardwaremodelingPackage.IO_HARDWARE_PIN:
		{
			IOHardwarePin ioHardwarePin = (IOHardwarePin)theEObject;
			T result = caseIOHardwarePin(ioHardwarePin);
			if(result == null)
				result = caseHardwarePin(ioHardwarePin);
			if(result == null)
				result = caseEAElement(ioHardwarePin);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case HardwaremodelingPackage.POWER_HARDWARE_PIN:
		{
			PowerHardwarePin powerHardwarePin = (PowerHardwarePin)theEObject;
			T result = casePowerHardwarePin(powerHardwarePin);
			if(result == null)
				result = caseHardwarePin(powerHardwarePin);
			if(result == null)
				result = caseEAElement(powerHardwarePin);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case HardwaremodelingPackage.COMMUNICATION_HARDWARE_PIN:
		{
			CommunicationHardwarePin communicationHardwarePin = (CommunicationHardwarePin)theEObject;
			T result = caseCommunicationHardwarePin(communicationHardwarePin);
			if(result == null)
				result = caseHardwarePin(communicationHardwarePin);
			if(result == null)
				result = caseEAElement(communicationHardwarePin);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case HardwaremodelingPackage.NODE:
		{
			Node node = (Node)theEObject;
			T result = caseNode(node);
			if(result == null)
				result = caseHardwareComponentType(node);
			if(result == null)
				result = caseContext(node);
			if(result == null)
				result = caseEAElement(node);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case HardwaremodelingPackage.POWER_SUPPLY:
		{
			PowerSupply powerSupply = (PowerSupply)theEObject;
			T result = casePowerSupply(powerSupply);
			if(result == null)
				result = caseHardwareComponentType(powerSupply);
			if(result == null)
				result = caseContext(powerSupply);
			if(result == null)
				result = caseEAElement(powerSupply);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case HardwaremodelingPackage.SENSOR:
		{
			Sensor sensor = (Sensor)theEObject;
			T result = caseSensor(sensor);
			if(result == null)
				result = caseHardwareComponentType(sensor);
			if(result == null)
				result = caseContext(sensor);
			if(result == null)
				result = caseEAElement(sensor);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case HardwaremodelingPackage.ACTUATOR:
		{
			Actuator actuator = (Actuator)theEObject;
			T result = caseActuator(actuator);
			if(result == null)
				result = caseHardwareComponentType(actuator);
			if(result == null)
				result = caseContext(actuator);
			if(result == null)
				result = caseEAElement(actuator);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case HardwaremodelingPackage.LOGICAL_BUS:
		{
			LogicalBus logicalBus = (LogicalBus)theEObject;
			T result = caseLogicalBus(logicalBus);
			if(result == null)
				result = caseAllocationTarget(logicalBus);
			if(result == null)
				result = caseEAElement(logicalBus);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case HardwaremodelingPackage.HARDWARE_PIN_GROUP:
		{
			HardwarePinGroup hardwarePinGroup = (HardwarePinGroup)theEObject;
			T result = caseHardwarePinGroup(hardwarePinGroup);
			if(result == null)
				result = caseEAElement(hardwarePinGroup);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case HardwaremodelingPackage.HARDWARE_COMPONENT_TYPE:
		{
			HardwareComponentType hardwareComponentType = (HardwareComponentType)theEObject;
			T result = caseHardwareComponentType(hardwareComponentType);
			if(result == null)
				result = caseContext(hardwareComponentType);
			if(result == null)
				result = caseEAElement(hardwareComponentType);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

} //HardwaremodelingSwitch
