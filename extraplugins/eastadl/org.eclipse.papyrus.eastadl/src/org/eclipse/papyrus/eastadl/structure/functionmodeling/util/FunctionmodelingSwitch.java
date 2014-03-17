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
package org.eclipse.papyrus.eastadl.structure.functionmodeling.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.papyrus.eastadl.infrastructure.elements.Context;
import org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.*;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.AllocateableElement;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.Allocation;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.AnalysisFunctionPrototype;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.AnalysisFunctionType;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.BasicSoftwareFunctionType;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.DesignFunctionPrototype;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.DesignFunctionType;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionAllocation;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionClientServerInterface;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionClientServerPort;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionConnector;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionFlowPort;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPort;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPowerPort;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPrototype;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionType;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionalDevice;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.HardwareFunctionType;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.LocalDeviceManager;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.Operation;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.PortGroup;
import org.eclipse.papyrus.sysml.blocks.Block;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;


/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage
 * @generated
 */
public class FunctionmodelingSwitch<T> extends Switch<T> {

	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static FunctionmodelingPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FunctionmodelingSwitch() {
		if(modelPackage == null) {
			modelPackage = FunctionmodelingPackage.eINSTANCE;
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
	 * Returns the result of interpreting the object as an instance of '<em>Allocateable Element</em>'.
	 * <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Allocateable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAllocateableElement(AllocateableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Allocation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Allocation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAllocation(Allocation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Analysis Function Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Analysis Function Prototype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnalysisFunctionPrototype(AnalysisFunctionPrototype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Analysis Function Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Analysis Function Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnalysisFunctionType(AnalysisFunctionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Basic Software Function Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Basic Software Function Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBasicSoftwareFunctionType(BasicSoftwareFunctionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlock(Block object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Design Function Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Design Function Prototype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDesignFunctionPrototype(DesignFunctionPrototype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Design Function Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Design Function Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDesignFunctionType(DesignFunctionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow Port</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFlowPort(FlowPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Functional Device</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Functional Device</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionalDevice(FunctionalDevice object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Allocation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Allocation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionAllocation(FunctionAllocation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Client Server Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Client Server Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionClientServerInterface(FunctionClientServerInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Client Server Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Client Server Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionClientServerPort(FunctionClientServerPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionConnector(FunctionConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Flow Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Flow Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionFlowPort(FunctionFlowPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionPort(FunctionPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Power Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Power Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionPowerPort(FunctionPowerPort object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Function Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Prototype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionPrototype(FunctionPrototype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionType(FunctionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hardware Function Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hardware Function Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHardwareFunctionType(HardwareFunctionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local Device Manager</em>'.
	 * <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local Device Manager</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocalDeviceManager(LocalDeviceManager object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperation(Operation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePortGroup(PortGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch, but this is the last case anyway. <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch(classifierID) {
		case FunctionmodelingPackage.LOCAL_DEVICE_MANAGER:
		{
			LocalDeviceManager localDeviceManager = (LocalDeviceManager)theEObject;
			T result = caseLocalDeviceManager(localDeviceManager);
			if(result == null)
				result = caseDesignFunctionType(localDeviceManager);
			if(result == null)
				result = caseFunctionType(localDeviceManager);
			if(result == null)
				result = caseContext(localDeviceManager);
			if(result == null)
				result = caseBlock(localDeviceManager);
			if(result == null)
				result = caseEAElement(localDeviceManager);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case FunctionmodelingPackage.DESIGN_FUNCTION_TYPE:
		{
			DesignFunctionType designFunctionType = (DesignFunctionType)theEObject;
			T result = caseDesignFunctionType(designFunctionType);
			if(result == null)
				result = caseFunctionType(designFunctionType);
			if(result == null)
				result = caseContext(designFunctionType);
			if(result == null)
				result = caseBlock(designFunctionType);
			if(result == null)
				result = caseEAElement(designFunctionType);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case FunctionmodelingPackage.FUNCTION_TYPE:
		{
			FunctionType functionType = (FunctionType)theEObject;
			T result = caseFunctionType(functionType);
			if(result == null)
				result = caseContext(functionType);
			if(result == null)
				result = caseBlock(functionType);
			if(result == null)
				result = caseEAElement(functionType);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case FunctionmodelingPackage.FUNCTION_PORT:
		{
			FunctionPort functionPort = (FunctionPort)theEObject;
			T result = caseFunctionPort(functionPort);
			if(result == null)
				result = caseEAElement(functionPort);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case FunctionmodelingPackage.PORT_GROUP:
		{
			PortGroup portGroup = (PortGroup)theEObject;
			T result = casePortGroup(portGroup);
			if(result == null)
				result = caseEAElement(portGroup);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case FunctionmodelingPackage.FUNCTION_CONNECTOR:
		{
			FunctionConnector functionConnector = (FunctionConnector)theEObject;
			T result = caseFunctionConnector(functionConnector);
			if(result == null)
				result = caseEAElement(functionConnector);
			if(result == null)
				result = caseAllocateableElement(functionConnector);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case FunctionmodelingPackage.ALLOCATEABLE_ELEMENT:
		{
			AllocateableElement allocateableElement = (AllocateableElement)theEObject;
			T result = caseAllocateableElement(allocateableElement);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case FunctionmodelingPackage.FUNCTION_PROTOTYPE:
		{
			FunctionPrototype functionPrototype = (FunctionPrototype)theEObject;
			T result = caseFunctionPrototype(functionPrototype);
			if(result == null)
				result = caseEAElement(functionPrototype);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case FunctionmodelingPackage.DESIGN_FUNCTION_PROTOTYPE:
		{
			DesignFunctionPrototype designFunctionPrototype = (DesignFunctionPrototype)theEObject;
			T result = caseDesignFunctionPrototype(designFunctionPrototype);
			if(result == null)
				result = caseFunctionPrototype(designFunctionPrototype);
			if(result == null)
				result = caseAllocateableElement(designFunctionPrototype);
			if(result == null)
				result = caseEAElement(designFunctionPrototype);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case FunctionmodelingPackage.FUNCTIONAL_DEVICE:
		{
			FunctionalDevice functionalDevice = (FunctionalDevice)theEObject;
			T result = caseFunctionalDevice(functionalDevice);
			if(result == null)
				result = caseAnalysisFunctionType(functionalDevice);
			if(result == null)
				result = caseFunctionType(functionalDevice);
			if(result == null)
				result = caseContext(functionalDevice);
			if(result == null)
				result = caseBlock(functionalDevice);
			if(result == null)
				result = caseEAElement(functionalDevice);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case FunctionmodelingPackage.ANALYSIS_FUNCTION_TYPE:
		{
			AnalysisFunctionType analysisFunctionType = (AnalysisFunctionType)theEObject;
			T result = caseAnalysisFunctionType(analysisFunctionType);
			if(result == null)
				result = caseFunctionType(analysisFunctionType);
			if(result == null)
				result = caseContext(analysisFunctionType);
			if(result == null)
				result = caseBlock(analysisFunctionType);
			if(result == null)
				result = caseEAElement(analysisFunctionType);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case FunctionmodelingPackage.ANALYSIS_FUNCTION_PROTOTYPE:
		{
			AnalysisFunctionPrototype analysisFunctionPrototype = (AnalysisFunctionPrototype)theEObject;
			T result = caseAnalysisFunctionPrototype(analysisFunctionPrototype);
			if(result == null)
				result = caseFunctionPrototype(analysisFunctionPrototype);
			if(result == null)
				result = caseEAElement(analysisFunctionPrototype);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case FunctionmodelingPackage.FUNCTION_FLOW_PORT:
		{
			FunctionFlowPort functionFlowPort = (FunctionFlowPort)theEObject;
			T result = caseFunctionFlowPort(functionFlowPort);
			if(result == null)
				result = caseFlowPort(functionFlowPort);
			if(result == null)
				result = caseFunctionPort(functionFlowPort);
			if(result == null)
				result = caseEAElement(functionFlowPort);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case FunctionmodelingPackage.FUNCTION_CLIENT_SERVER_PORT:
		{
			FunctionClientServerPort functionClientServerPort = (FunctionClientServerPort)theEObject;
			T result = caseFunctionClientServerPort(functionClientServerPort);
			if(result == null)
				result = caseFunctionPort(functionClientServerPort);
			if(result == null)
				result = caseEAElement(functionClientServerPort);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case FunctionmodelingPackage.FUNCTION_CLIENT_SERVER_INTERFACE:
		{
			FunctionClientServerInterface functionClientServerInterface = (FunctionClientServerInterface)theEObject;
			T result = caseFunctionClientServerInterface(functionClientServerInterface);
			if(result == null)
				result = caseEAElement(functionClientServerInterface);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case FunctionmodelingPackage.OPERATION:
		{
			Operation operation = (Operation)theEObject;
			T result = caseOperation(operation);
			if(result == null)
				result = caseEAElement(operation);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case FunctionmodelingPackage.BASIC_SOFTWARE_FUNCTION_TYPE:
		{
			BasicSoftwareFunctionType basicSoftwareFunctionType = (BasicSoftwareFunctionType)theEObject;
			T result = caseBasicSoftwareFunctionType(basicSoftwareFunctionType);
			if(result == null)
				result = caseDesignFunctionType(basicSoftwareFunctionType);
			if(result == null)
				result = caseFunctionType(basicSoftwareFunctionType);
			if(result == null)
				result = caseContext(basicSoftwareFunctionType);
			if(result == null)
				result = caseBlock(basicSoftwareFunctionType);
			if(result == null)
				result = caseEAElement(basicSoftwareFunctionType);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case FunctionmodelingPackage.HARDWARE_FUNCTION_TYPE:
		{
			HardwareFunctionType hardwareFunctionType = (HardwareFunctionType)theEObject;
			T result = caseHardwareFunctionType(hardwareFunctionType);
			if(result == null)
				result = caseDesignFunctionType(hardwareFunctionType);
			if(result == null)
				result = caseFunctionType(hardwareFunctionType);
			if(result == null)
				result = caseContext(hardwareFunctionType);
			if(result == null)
				result = caseBlock(hardwareFunctionType);
			if(result == null)
				result = caseEAElement(hardwareFunctionType);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case FunctionmodelingPackage.FUNCTION_ALLOCATION:
		{
			FunctionAllocation functionAllocation = (FunctionAllocation)theEObject;
			T result = caseFunctionAllocation(functionAllocation);
			if(result == null)
				result = caseEAElement(functionAllocation);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case FunctionmodelingPackage.ALLOCATION:
		{
			Allocation allocation = (Allocation)theEObject;
			T result = caseAllocation(allocation);
			if(result == null)
				result = caseEAElement(allocation);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case FunctionmodelingPackage.FUNCTION_POWER_PORT:
		{
			FunctionPowerPort functionPowerPort = (FunctionPowerPort)theEObject;
			T result = caseFunctionPowerPort(functionPowerPort);
			if(result == null)
				result = caseFunctionPort(functionPowerPort);
			if(result == null)
				result = caseEAElement(functionPowerPort);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

} // FunctionmodelingSwitch
