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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Type</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotML.DataType#getBase_DataType <em>Base Data Type</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.DataType#isNative <em>Native</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.DataType#getLibraryPath <em>Library Path</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getDataType()
 * @model
 * @generated
 */
public interface DataType extends EObject {

	/**
	 * Returns the value of the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Data Type</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Data Type</em>' reference.
	 * @see #setBase_DataType(org.eclipse.uml2.uml.DataType)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getDataType_Base_DataType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.DataType getBase_DataType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.DataType#getBase_DataType <em>Base Data Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Data Type</em>' reference.
	 * @see #getBase_DataType()
	 * @generated
	 */
	void setBase_DataType(org.eclipse.uml2.uml.DataType value);

	/**
	 * Returns the value of the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Native</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Native</em>' attribute.
	 * @see #setNative(boolean)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getDataType_Native()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isNative();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.DataType#isNative <em>Native</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Native</em>' attribute.
	 * @see #isNative()
	 * @generated
	 */
	void setNative(boolean value);

	/**
	 * Returns the value of the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Library Path</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Library Path</em>' attribute.
	 * @see #setLibraryPath(String)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getDataType_LibraryPath()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getLibraryPath();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.DataType#getLibraryPath <em>Library Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Library Path</em>' attribute.
	 * @see #getLibraryPath()
	 * @generated
	 */
	void setLibraryPath(String value);

} // DataType
