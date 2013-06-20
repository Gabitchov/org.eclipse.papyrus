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
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Point;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Header;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Grid Cells</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.GridCells#getHeader <em>Header</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.GridCells#getCell_width <em>Cell width</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.GridCells#getCell_height <em>Cell height</em>}
 * </li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.GridCells#getCells <em>Cells</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Nav_datatypesPackage#getGridCells()
 * @model
 * @generated
 */
public interface GridCells extends EObject {

	/**
	 * Returns the value of the '<em><b>Header</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Header</em>' containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Header</em>' containment reference.
	 * @see #setHeader(Header)
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Nav_datatypesPackage#getGridCells_Header()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Header getHeader();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.GridCells#getHeader
	 * <em>Header</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Header</em>' containment reference.
	 * @see #getHeader()
	 * @generated
	 */
	void setHeader(Header value);

	/**
	 * Returns the value of the '<em><b>Cell width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cell width</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Cell width</em>' attribute.
	 * @see #setCell_width(float)
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Nav_datatypesPackage#getGridCells_Cell_width()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true"
	 *        ordered="false"
	 * @generated
	 */
	float getCell_width();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.GridCells#getCell_width <em>Cell width</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Cell width</em>' attribute.
	 * @see #getCell_width()
	 * @generated
	 */
	void setCell_width(float value);

	/**
	 * Returns the value of the '<em><b>Cell height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cell height</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Cell height</em>' attribute.
	 * @see #setCell_height(float)
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Nav_datatypesPackage#getGridCells_Cell_height()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true"
	 *        ordered="false"
	 * @generated
	 */
	float getCell_height();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.GridCells#getCell_height <em>Cell height</em>}
	 * ' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Cell height</em>' attribute.
	 * @see #getCell_height()
	 * @generated
	 */
	void setCell_height(float value);

	/**
	 * Returns the value of the '<em><b>Cells</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Point}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cells</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Cells</em>' containment reference list.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Nav_datatypesPackage#getGridCells_Cells()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Point> getCells();

} // GridCells
