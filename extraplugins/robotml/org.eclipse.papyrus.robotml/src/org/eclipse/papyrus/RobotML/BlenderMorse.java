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
 * A representation of the model object '<em><b>Blender Morse</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotML.BlenderMorse#isDebugMode <em>Debug Mode</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.BlenderMorse#isDebugDisplay <em>Debug Display</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.BlenderMorse#getGravity <em>Gravity</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.BlenderMorse#get_viewport_shade <em>viewport shade</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getBlenderMorse()
 * @model
 * @generated
 */
public interface BlenderMorse extends RoboticSimulator {

	/**
	 * Returns the value of the '<em><b>Debug Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Debug Mode</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Debug Mode</em>' attribute.
	 * @see #setDebugMode(boolean)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getBlenderMorse_DebugMode()
	 * @model dataType="org.eclipse.uml2.types.Boolean" ordered="false"
	 * @generated
	 */
	boolean isDebugMode();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.BlenderMorse#isDebugMode <em>Debug Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Debug Mode</em>' attribute.
	 * @see #isDebugMode()
	 * @generated
	 */
	void setDebugMode(boolean value);

	/**
	 * Returns the value of the '<em><b>Debug Display</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Debug Display</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Debug Display</em>' attribute.
	 * @see #setDebugDisplay(boolean)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getBlenderMorse_DebugDisplay()
	 * @model dataType="org.eclipse.uml2.types.Boolean" ordered="false"
	 * @generated
	 */
	boolean isDebugDisplay();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.BlenderMorse#isDebugDisplay <em>Debug Display</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Debug Display</em>' attribute.
	 * @see #isDebugDisplay()
	 * @generated
	 */
	void setDebugDisplay(boolean value);

	/**
	 * Returns the value of the '<em><b>Gravity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gravity</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Gravity</em>' attribute.
	 * @see #setGravity(float)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getBlenderMorse_Gravity()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" ordered="false"
	 * @generated
	 */
	float getGravity();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.BlenderMorse#getGravity <em>Gravity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Gravity</em>' attribute.
	 * @see #getGravity()
	 * @generated
	 */
	void setGravity(float value);

	/**
	 * Returns the value of the '<em><b>viewport shade</b></em>' attribute.
	 * The default value is <code>"WIREFRAME"</code>.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.RobotML.Shade}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>viewport shade</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>viewport shade</em>' attribute.
	 * @see org.eclipse.papyrus.RobotML.Shade
	 * @see #set_viewport_shade(Shade)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getBlenderMorse__viewport_shade()
	 * @model default="WIREFRAME" ordered="false"
	 * @generated
	 */
	Shade get_viewport_shade();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.BlenderMorse#get_viewport_shade <em>viewport shade</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>viewport shade</em>' attribute.
	 * @see org.eclipse.papyrus.RobotML.Shade
	 * @see #get_viewport_shade()
	 * @generated
	 */
	void set_viewport_shade(Shade value);

} // BlenderMorse
