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
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multi Layer Lidar Scan</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.MultiLayerLidarScan#getLayers
 * <em>Layers</em>}</li>
 * <li>
 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.MultiLayerLidarScan#getNbLayer
 * <em>Nb Layer</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.Oarp1_datatypesPackage#getMultiLayerLidarScan()
 * @model
 * @generated
 */
public interface MultiLayerLidarScan extends EObject {

	/**
	 * Returns the value of the '<em><b>Layers</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layers</em>' containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Layers</em>' containment reference.
	 * @see #setLayers(ExtentedLidarScan)
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.Oarp1_datatypesPackage#getMultiLayerLidarScan_Layers()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ExtentedLidarScan getLayers();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.MultiLayerLidarScan#getLayers
	 * <em>Layers</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Layers</em>' containment reference.
	 * @see #getLayers()
	 * @generated
	 */
	void setLayers(ExtentedLidarScan value);

	/**
	 * Returns the value of the '<em><b>Nb Layer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nb Layer</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Nb Layer</em>' attribute.
	 * @see #setNbLayer(char)
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.Oarp1_datatypesPackage#getMultiLayerLidarScan_NbLayer()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt8" required="true"
	 *        ordered="false"
	 * @generated
	 */
	char getNbLayer();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.MultiLayerLidarScan#getNbLayer
	 * <em>Nb Layer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Nb Layer</em>' attribute.
	 * @see #getNbLayer()
	 * @generated
	 */
	void setNbLayer(char value);

} // MultiLayerLidarScan
