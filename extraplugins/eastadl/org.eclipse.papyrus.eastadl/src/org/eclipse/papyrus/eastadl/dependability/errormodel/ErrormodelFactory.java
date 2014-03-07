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
package org.eclipse.papyrus.eastadl.dependability.errormodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage
 * @generated
 */
public interface ErrormodelFactory extends EFactory {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	ErrormodelFactory eINSTANCE = org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrormodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Anomaly</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Anomaly</em>'.
	 * @generated
	 */
	Anomaly createAnomaly();

	/**
	 * Returns a new object of class '<em>Error Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Error Behavior</em>'.
	 * @generated
	 */
	ErrorBehavior createErrorBehavior();

	/**
	 * Returns a new object of class '<em>Error Model Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Error Model Prototype</em>'.
	 * @generated
	 */
	ErrorModelPrototype createErrorModelPrototype();

	/**
	 * Returns a new object of class '<em>Error Model Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Error Model Type</em>'.
	 * @generated
	 */
	ErrorModelType createErrorModelType();

	/**
	 * Returns a new object of class '<em>Failure Out Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Failure Out Port</em>'.
	 * @generated
	 */
	FailureOutPort createFailureOutPort();

	/**
	 * Returns a new object of class '<em>Fault Failure Propagation Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Fault Failure Propagation Link</em>'.
	 * @generated
	 */
	FaultFailurePropagationLink createFaultFailurePropagationLink();

	/**
	 * Returns a new object of class '<em>Fault In Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Fault In Port</em>'.
	 * @generated
	 */
	FaultInPort createFaultInPort();

	/**
	 * Returns a new object of class '<em>Internal Fault Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Internal Fault Prototype</em>'.
	 * @generated
	 */
	InternalFaultPrototype createInternalFaultPrototype();

	/**
	 * Returns a new object of class '<em>Process Fault Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Process Fault Prototype</em>'.
	 * @generated
	 */
	ProcessFaultPrototype createProcessFaultPrototype();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	ErrormodelPackage getErrormodelPackage();

} //ErrormodelFactory
