/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Sara TUCCI (CEA LIST) sara.tucci@cea.fr - Initial API and implementation
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *  David SERVAT (CEA LIST) david.servat@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl.timing.events;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPort;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPrototype;
import org.eclipse.papyrus.eastadl.timing.Event;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Function Flow Port</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * Event that refers to the triggering of the Function at a flow port, i.e., when data is sent or received.
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.timing.events.EventFunctionFlowPort#getPort <em>Port</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.timing.events.EventFunctionFlowPort#getPort_path <em>Port path</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.timing.events.EventsPackage#getEventFunctionFlowPort()
 * @model
 * @generated
 */
public interface EventFunctionFlowPort extends Event {

	/**
	 * Returns the value of the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Port</em>' reference.
	 * @see #setPort(FunctionPort)
	 * @see org.eclipse.papyrus.eastadl.timing.events.EventsPackage#getEventFunctionFlowPort_Port()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	FunctionPort getPort();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.timing.events.EventFunctionFlowPort#getPort <em>Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Port</em>' reference.
	 * @see #getPort()
	 * @generated
	 */
	void setPort(FunctionPort value);

	/**
	 * Returns the value of the '<em><b>Port path</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPrototype}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port path</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Port path</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.timing.events.EventsPackage#getEventFunctionFlowPort_Port_path()
	 * @model
	 * @generated
	 */
	EList<FunctionPrototype> getPort_path();

} // EventFunctionFlowPort
