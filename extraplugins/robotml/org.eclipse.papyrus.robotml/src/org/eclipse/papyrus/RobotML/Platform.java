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

import org.eclipse.uml2.uml.Node;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Platform</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotML.Platform#getBase_Node <em>Base Node</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getPlatform()
 * @model
 * @generated
 */
public interface Platform extends org.eclipse.papyrus.RobotML.System {

	/**
	 * Returns the value of the '<em><b>Base Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Node</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Node</em>' reference.
	 * @see #setBase_Node(Node)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getPlatform_Base_Node()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Node getBase_Node();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.Platform#getBase_Node <em>Base Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Node</em>' reference.
	 * @see #getBase_Node()
	 * @generated
	 */
	void setBase_Node(Node value);

} // Platform
