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

import org.eclipse.uml2.uml.PrimitiveType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Data</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotML.PrimitiveData#getBase_PrimitiveType <em>Base Primitive Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getPrimitiveData()
 * @model
 * @generated
 */
public interface PrimitiveData extends DataType {

	/**
	 * Returns the value of the '<em><b>Base Primitive Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Primitive Type</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Primitive Type</em>' reference.
	 * @see #setBase_PrimitiveType(PrimitiveType)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getPrimitiveData_Base_PrimitiveType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	PrimitiveType getBase_PrimitiveType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.PrimitiveData#getBase_PrimitiveType <em>Base Primitive Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Primitive Type</em>' reference.
	 * @see #getBase_PrimitiveType()
	 * @generated
	 */
	void setBase_PrimitiveType(PrimitiveType value);

} // PrimitiveData
