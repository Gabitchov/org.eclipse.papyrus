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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage
 * @generated
 */
public interface FunctionmodelingFactory extends EFactory {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	FunctionmodelingFactory eINSTANCE = org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Allocation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Allocation</em>'.
	 * @generated
	 */
	Allocation createAllocation();

	/**
	 * Returns a new object of class '<em>Analysis Function Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Analysis Function Prototype</em>'.
	 * @generated
	 */
	AnalysisFunctionPrototype createAnalysisFunctionPrototype();

	/**
	 * Returns a new object of class '<em>Analysis Function Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Analysis Function Type</em>'.
	 * @generated
	 */
	AnalysisFunctionType createAnalysisFunctionType();

	/**
	 * Returns a new object of class '<em>Basic Software Function Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Basic Software Function Type</em>'.
	 * @generated
	 */
	BasicSoftwareFunctionType createBasicSoftwareFunctionType();

	/**
	 * Returns a new object of class '<em>Design Function Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Design Function Prototype</em>'.
	 * @generated
	 */
	DesignFunctionPrototype createDesignFunctionPrototype();

	/**
	 * Returns a new object of class '<em>Design Function Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Design Function Type</em>'.
	 * @generated
	 */
	DesignFunctionType createDesignFunctionType();

	/**
	 * Returns a new object of class '<em>Functional Device</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Functional Device</em>'.
	 * @generated
	 */
	FunctionalDevice createFunctionalDevice();

	/**
	 * Returns a new object of class '<em>Function Allocation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Function Allocation</em>'.
	 * @generated
	 */
	FunctionAllocation createFunctionAllocation();

	/**
	 * Returns a new object of class '<em>Function Client Server Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Function Client Server Interface</em>'.
	 * @generated
	 */
	FunctionClientServerInterface createFunctionClientServerInterface();

	/**
	 * Returns a new object of class '<em>Function Client Server Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Function Client Server Port</em>'.
	 * @generated
	 */
	FunctionClientServerPort createFunctionClientServerPort();

	/**
	 * Returns a new object of class '<em>Function Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Function Connector</em>'.
	 * @generated
	 */
	FunctionConnector createFunctionConnector();

	/**
	 * Returns a new object of class '<em>Function Flow Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Function Flow Port</em>'.
	 * @generated
	 */
	FunctionFlowPort createFunctionFlowPort();

	/**
	 * Returns a new object of class '<em>Function Power Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Function Power Port</em>'.
	 * @generated
	 */
	FunctionPowerPort createFunctionPowerPort();

	/**
	 * Returns a new object of class '<em>Hardware Function Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Hardware Function Type</em>'.
	 * @generated
	 */
	HardwareFunctionType createHardwareFunctionType();

	/**
	 * Returns a new object of class '<em>Local Device Manager</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Local Device Manager</em>'.
	 * @generated
	 */
	LocalDeviceManager createLocalDeviceManager();

	/**
	 * Returns a new object of class '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Operation</em>'.
	 * @generated
	 */
	Operation createOperation();

	/**
	 * Returns a new object of class '<em>Port Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Port Group</em>'.
	 * @generated
	 */
	PortGroup createPortGroup();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	FunctionmodelingPackage getFunctionmodelingPackage();

} // FunctionmodelingFactory
