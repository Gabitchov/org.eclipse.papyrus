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
package org.eclipse.papyrus.eastadl.dependability.errormodel;

import org.eclipse.uml2.uml.Event;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process Fault Prototype</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * The ProcessFaultPrototype metaclass represents the anomalies that the target component/system can have due to design or implementation flaws (e.g.,
 * incorrect requirements, buffer size configuration, scheduling, etc.).
 * 
 * Semantics:
 * The ProcessFaultPrototype metaclass represents the anomalies that the target component/system can have due to design or implementation flaws (e.g.,
 * incorrect requirements, buffer size configuration, scheduling, etc.).
 * 
 * Extension:
 * UML::Part / UML::Event
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ProcessFaultPrototype#getBase_Event <em>Base Event</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getProcessFaultPrototype()
 * @model
 * @generated
 */
public interface ProcessFaultPrototype extends Anomaly {

	/**
	 * Returns the value of the '<em><b>Base Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Event</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Event</em>' reference.
	 * @see #setBase_Event(Event)
	 * @see org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage#getProcessFaultPrototype_Base_Event()
	 * @model ordered="false"
	 * @generated
	 */
	Event getBase_Event();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.dependability.errormodel.ProcessFaultPrototype#getBase_Event <em>Base Event</em>}'
	 * reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Event</em>' reference.
	 * @see #getBase_Event()
	 * @generated
	 */
	void setBase_Event(Event value);

} // ProcessFaultPrototype
