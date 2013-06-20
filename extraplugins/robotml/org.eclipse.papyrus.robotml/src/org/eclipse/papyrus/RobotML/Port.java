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
 * A representation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotML.Port#getBase_Port <em>Base Port</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.Port#getSynchronizationPolicy <em>Synchronization Policy</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getPort()
 * @model abstract="true"
 * @generated
 */
public interface Port extends EObject {

	/**
	 * Returns the value of the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Port</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Port</em>' reference.
	 * @see #setBase_Port(org.eclipse.uml2.uml.Port)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getPort_Base_Port()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Port getBase_Port();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.Port#getBase_Port <em>Base Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Port</em>' reference.
	 * @see #getBase_Port()
	 * @generated
	 */
	void setBase_Port(org.eclipse.uml2.uml.Port value);

	/**
	 * Returns the value of the '<em><b>Synchronization Policy</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.RobotML.SynchronizationKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Synchronization Policy</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Synchronization Policy</em>' attribute.
	 * @see org.eclipse.papyrus.RobotML.SynchronizationKind
	 * @see #setSynchronizationPolicy(SynchronizationKind)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getPort_SynchronizationPolicy()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SynchronizationKind getSynchronizationPolicy();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.Port#getSynchronizationPolicy <em>Synchronization Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Synchronization Policy</em>' attribute.
	 * @see org.eclipse.papyrus.RobotML.SynchronizationKind
	 * @see #getSynchronizationPolicy()
	 * @generated
	 */
	void setSynchronizationPolicy(SynchronizationKind value);

} // Port
