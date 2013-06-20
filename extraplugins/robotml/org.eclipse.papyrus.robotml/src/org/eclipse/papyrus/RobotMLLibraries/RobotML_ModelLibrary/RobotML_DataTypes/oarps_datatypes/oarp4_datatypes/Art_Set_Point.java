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
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Art Set Point</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Art_Set_Point#getOmega_left
 * <em>Omega left</em>}</li>
 * <li>
 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Art_Set_Point#getOmega_right
 * <em>Omega right</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Oarp4_datatypesPackage#getArt_Set_Point()
 * @model
 * @generated
 */
public interface Art_Set_Point extends EObject {

	/**
	 * Returns the value of the '<em><b>Omega left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Omega left</em>' containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Omega left</em>' containment reference.
	 * @see #setOmega_left(Velocity_Angular)
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Oarp4_datatypesPackage#getArt_Set_Point_Omega_left()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Velocity_Angular getOmega_left();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Art_Set_Point#getOmega_left
	 * <em>Omega left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Omega left</em>' containment reference.
	 * @see #getOmega_left()
	 * @generated
	 */
	void setOmega_left(Velocity_Angular value);

	/**
	 * Returns the value of the '<em><b>Omega right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Omega right</em>' containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Omega right</em>' containment reference.
	 * @see #setOmega_right(Velocity_Angular)
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Oarp4_datatypesPackage#getArt_Set_Point_Omega_right()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Velocity_Angular getOmega_right();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Art_Set_Point#getOmega_right
	 * <em>Omega right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Omega right</em>' containment reference.
	 * @see #getOmega_right()
	 * @generated
	 */
	void setOmega_right(Velocity_Angular value);

} // Art_Set_Point
