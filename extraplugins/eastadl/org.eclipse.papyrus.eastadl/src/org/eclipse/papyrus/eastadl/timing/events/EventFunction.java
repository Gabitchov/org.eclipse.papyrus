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
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPrototype;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionType;
import org.eclipse.papyrus.eastadl.timing.Event;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An event of a Function refers to the triggering of the Function, i.e., when the input data is consumed, data transformation is performed on that input data by the function, and output data is produced. It is used in conjunction with FunctionTrigger (see that concept) to define a time-driven triggering for a function. In this case the FunctionTrigger points to the EventFunction of the function and defines a triggerPolicy set to TIME. The timing constraint associated to the EventFunction provides information about the period. 
 * 
 * Compare categories of AUTOSAR runnables:
 * 
 * 1a triggering only on start and finish (this type of event)
 * 
 * 1b triggering allowed anytime during the execution (events on ports, see EventInFlowPort)
 * 
 * 
 * Constraints:
 * [1] An EventFunction either identifies a FunctionType or a FunctionPrototype as its target function.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.events.EventFunction#getFunction <em>Function</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.events.EventFunction#getFunctionType <em>Function Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.events.EventFunction#getFunction_path <em>Function path</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.timing.events.EventsPackage#getEventFunction()
 * @model
 * @generated
 */
public interface EventFunction extends Event {
	/**
	 * Returns the value of the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function</em>' reference.
	 * @see #setFunction(FunctionPrototype)
	 * @see org.eclipse.papyrus.eastadl.timing.events.EventsPackage#getEventFunction_Function()
	 * @model ordered="false"
	 * @generated
	 */
	FunctionPrototype getFunction();

	/**
	 * Returns the value of the '<em><b>Function Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function Type</em>' reference.
	 * @see #setFunctionType(FunctionType)
	 * @see org.eclipse.papyrus.eastadl.timing.events.EventsPackage#getEventFunction_FunctionType()
	 * @model ordered="false"
	 * @generated
	 */
	FunctionType getFunctionType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.timing.events.EventFunction#getFunction <em>Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function</em>' reference.
	 * @see #getFunction()
	 * @generated
	 */
	void setFunction(FunctionPrototype value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.timing.events.EventFunction#getFunctionType <em>Function Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function Type</em>' reference.
	 * @see #getFunctionType()
	 * @generated
	 */
	void setFunctionType(FunctionType value);

	/**
	 * Returns the value of the '<em><b>Function path</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPrototype}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function path</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function path</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.timing.events.EventsPackage#getEventFunction_Function_path()
	 * @model
	 * @generated
	 */
	EList<FunctionPrototype> getFunction_path();

} // EventFunction
