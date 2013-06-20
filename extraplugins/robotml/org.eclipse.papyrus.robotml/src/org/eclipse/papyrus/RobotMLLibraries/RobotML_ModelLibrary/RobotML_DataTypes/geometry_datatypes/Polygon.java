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
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Polygon</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Polygon#getPoint <em>Point</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Geometry_datatypesPackage#getPolygon()
 * @model
 * @generated
 */
public interface Polygon extends EObject {

	/**
	 * Returns the value of the '<em><b>Point</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Point32}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Point</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Point</em>' containment reference list.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Geometry_datatypesPackage#getPolygon_Point()
	 * @model containment="true" lower="3" ordered="false"
	 * @generated
	 */
	EList<Point32> getPoint();

} // Polygon
