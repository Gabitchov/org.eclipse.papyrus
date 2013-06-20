/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.Actionlib_datatypesPackage
 * @generated
 */
public interface Actionlib_datatypesFactory extends EFactory {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	Actionlib_datatypesFactory eINSTANCE = org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.impl.Actionlib_datatypesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Goal ID</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Goal ID</em>'.
	 * @generated
	 */
	GoalID createGoalID();

	/**
	 * Returns a new object of class '<em>Goal Status</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Goal Status</em>'.
	 * @generated
	 */
	GoalStatus createGoalStatus();

	/**
	 * Returns a new object of class '<em>Goal Status Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Goal Status Array</em>'.
	 * @generated
	 */
	GoalStatusArray createGoalStatusArray();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	Actionlib_datatypesPackage getActionlib_datatypesPackage();

} //Actionlib_datatypesFactory
