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
package org.eclipse.papyrus.RobotML;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sensor System</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotML.SensorSystem#getFrequency <em>Frequency</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.SensorSystem#getIdentifier <em>Identifier</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSensorSystem()
 * @model
 * @generated
 */
public interface SensorSystem extends RoboticSystem {

	/**
	 * Returns the value of the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Frequency</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Frequency</em>' attribute.
	 * @see #setFrequency(float)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSensorSystem_Frequency()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true"
	 *        ordered="false"
	 * @generated
	 */
	float getFrequency();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.SensorSystem#getFrequency <em>Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Frequency</em>' attribute.
	 * @see #getFrequency()
	 * @generated
	 */
	void setFrequency(float value);

	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Identifier</em>' attribute.
	 * @see #setIdentifier(String)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSensorSystem_Identifier()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.String" required="true"
	 *        ordered="false"
	 * @generated
	 */
	String getIdentifier();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.SensorSystem#getIdentifier <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Identifier</em>' attribute.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(String value);

} // SensorSystem
