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
package org.eclipse.papyrus.eastadl.behavior;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.eastadl.behavior.BehaviorPackage
 * @generated
 */
public interface BehaviorFactory extends EFactory {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	BehaviorFactory eINSTANCE = org.eclipse.papyrus.eastadl.behavior.impl.BehaviorFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Behavior</em>'.
	 * @generated
	 */
	Behavior createBehavior();

	/**
	 * Returns a new object of class '<em>Function Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Function Behavior</em>'.
	 * @generated
	 */
	FunctionBehavior createFunctionBehavior();

	/**
	 * Returns a new object of class '<em>Function Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Function Trigger</em>'.
	 * @generated
	 */
	FunctionTrigger createFunctionTrigger();

	/**
	 * Returns a new object of class '<em>Mode</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Mode</em>'.
	 * @generated
	 */
	Mode createMode();

	/**
	 * Returns a new object of class '<em>Mode Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Mode Group</em>'.
	 * @generated
	 */
	ModeGroup createModeGroup();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	BehaviorPackage getBehaviorPackage();

} // BehaviorFactory
