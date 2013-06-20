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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotML.State#getBase_State <em>Base State</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.State#getOperation <em>Operation</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.State#getArguments <em>Arguments</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getState()
 * @model
 * @generated
 */
public interface State extends EObject {

	/**
	 * Returns the value of the '<em><b>Base State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base State</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base State</em>' reference.
	 * @see #setBase_State(org.eclipse.uml2.uml.State)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getState_Base_State()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.State getBase_State();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.State#getBase_State <em>Base State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base State</em>' reference.
	 * @see #getBase_State()
	 * @generated
	 */
	void setBase_State(org.eclipse.uml2.uml.State value);

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Operation</em>' reference.
	 * @see #setOperation(Algorithm)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getState_Operation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Algorithm getOperation();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.State#getOperation <em>Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Operation</em>' reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(Algorithm value);

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Arguments</em>' reference list.
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getState_Arguments()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Property> getArguments();

} // State
