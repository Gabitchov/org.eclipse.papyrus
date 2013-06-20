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
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * guard is typed with a boolean operation that have to be defined in the model before using it
 * effect is typed by an operation that is owned by the component that is behaviored by the FSM
 * 
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotML.Transition#getBase_Transition <em>Base Transition</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.Transition#getGuard <em>Guard</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.Transition#getEffect <em>Effect</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends EObject {

	/**
	 * Returns the value of the '<em><b>Base Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Transition</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Transition</em>' reference.
	 * @see #setBase_Transition(org.eclipse.uml2.uml.Transition)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getTransition_Base_Transition()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Transition getBase_Transition();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.Transition#getBase_Transition <em>Base Transition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Transition</em>' reference.
	 * @see #getBase_Transition()
	 * @generated
	 */
	void setBase_Transition(org.eclipse.uml2.uml.Transition value);

	/**
	 * Returns the value of the '<em><b>Guard</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guard</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Guard</em>' reference.
	 * @see #setGuard(Algorithm)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getTransition_Guard()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Algorithm getGuard();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.Transition#getGuard <em>Guard</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Guard</em>' reference.
	 * @see #getGuard()
	 * @generated
	 */
	void setGuard(Algorithm value);

	/**
	 * Returns the value of the '<em><b>Effect</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Effect</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Effect</em>' reference.
	 * @see #setEffect(Algorithm)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getTransition_Effect()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Algorithm getEffect();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.Transition#getEffect <em>Effect</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Effect</em>' reference.
	 * @see #getEffect()
	 * @generated
	 */
	void setEffect(Algorithm value);

} // Transition
