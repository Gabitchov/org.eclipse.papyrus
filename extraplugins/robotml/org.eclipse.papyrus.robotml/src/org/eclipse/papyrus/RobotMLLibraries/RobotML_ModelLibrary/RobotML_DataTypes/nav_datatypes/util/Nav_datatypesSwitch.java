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
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.GridCells;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.MapMetaData;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Nav_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.OccupancyGrid;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Odometry;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Path;

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
 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Nav_datatypesPackage
 * @generated
 */
public class Nav_datatypesSwitch<T> extends Switch<T> {

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static Nav_datatypesPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Nav_datatypesSwitch() {
		if(modelPackage == null) {
			modelPackage = Nav_datatypesPackage.eINSTANCE;
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
		case Nav_datatypesPackage.PATH:
		{
			Path path = (Path)theEObject;
			T result = casePath(path);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Nav_datatypesPackage.ODOMETRY:
		{
			Odometry odometry = (Odometry)theEObject;
			T result = caseOdometry(odometry);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Nav_datatypesPackage.MAP_META_DATA:
		{
			MapMetaData mapMetaData = (MapMetaData)theEObject;
			T result = caseMapMetaData(mapMetaData);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Nav_datatypesPackage.OCCUPANCY_GRID:
		{
			OccupancyGrid occupancyGrid = (OccupancyGrid)theEObject;
			T result = caseOccupancyGrid(occupancyGrid);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Nav_datatypesPackage.GRID_CELLS:
		{
			GridCells gridCells = (GridCells)theEObject;
			T result = caseGridCells(gridCells);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Path</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Path</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePath(Path object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Odometry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Odometry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOdometry(Odometry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Map Meta Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Map Meta Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMapMetaData(MapMetaData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Occupancy Grid</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Occupancy Grid</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOccupancyGrid(OccupancyGrid object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Grid Cells</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Grid Cells</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGridCells(GridCells object) {
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

} //Nav_datatypesSwitch
