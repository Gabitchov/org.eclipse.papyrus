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
package org.eclipse.papyrus.eastadl.timing;

import org.eclipse.papyrus.eastadl.structure.functionmodeling.DesignFunctionPrototype;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.DesignFunctionType;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution Time Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * ExecutionTimeConstraint expresses the execution time of a function under the assumption of a nominal CPU that executes 1 "function second" per second. Function allocation will decide the actual execution time by multiplication with the relative speed of the host CPU. 
 * 
 * Example:
 * The ECU is 20% faster than a standard ECU (e.g. in a certain context, execution times are given assuming a nominal speed of 100 MHz; Our CPU is then 120 MHz) 
 * 
 * The function is activated by a time trigger or a port trigger. The function starts execution some time after activation, depending on e.g. interference and blocking from other functions on the same resource
 * Immediately on start, the function reads input data on all ports. Functions write data at the latest when the execution time has elapsed (which is after the execution time plus any blocking and interference time). 
 * 
 * Constraints:
 * [1] An ExecutionTimeConstraint either identifies a FunctionType or a FunctionPrototype as its target function.
 * [2] variation shall be a value between 0 and upper-lower.
 * 
 * Semantics:
 * lower (from TimingConstraint) denotes the minimal best case execution time.
 * upper (from TimingConstraint) denotes the maximal worst case execution time.
 * variation denotes the allowed variation in execution time, i.e. maximal minimal execution time.
 * 
 * Example:
 * lower=5
 * upper=10
 * variation=2
 * best case execution time of 6 and worst case of 7 is within this constraint
 * best case execution time of 6 and worst case of 9 violates this constraint
 * 
 * If a measured value is characterized, variation is not used, as it is always upper-lower, e.g. lower=6 and upper=9 above. In this example, the ExecutionTimeConstraint would be a Realization of a VVActualOutcome.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.ExecutionTimeConstraint#getVariation <em>Variation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.ExecutionTimeConstraint#getTargetDesignFunctionType <em>Target Design Function Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.ExecutionTimeConstraint#getTargetDesignFunction <em>Target Design Function</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.ExecutionTimeConstraint#getTargetDesignFunctionPrototype <em>Target Design Function Prototype</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.timing.TimingPackage#getExecutionTimeConstraint()
 * @model
 * @generated
 */
public interface ExecutionTimeConstraint extends TimingConstraint {
	/**
	 * Returns the value of the '<em><b>Target Design Function Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Design Function Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Design Function Type</em>' reference.
	 * @see #setTargetDesignFunctionType(DesignFunctionType)
	 * @see org.eclipse.papyrus.eastadl.timing.TimingPackage#getExecutionTimeConstraint_TargetDesignFunctionType()
	 * @model ordered="false"
	 * @generated
	 */
	DesignFunctionType getTargetDesignFunctionType();

	/**
	 * Returns the value of the '<em><b>Variation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variation</em>' reference.
	 * @see #setVariation(TimeDuration)
	 * @see org.eclipse.papyrus.eastadl.timing.TimingPackage#getExecutionTimeConstraint_Variation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	TimeDuration getVariation();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.timing.ExecutionTimeConstraint#getTargetDesignFunctionType <em>Target Design Function Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Design Function Type</em>' reference.
	 * @see #getTargetDesignFunctionType()
	 * @generated
	 */
	void setTargetDesignFunctionType(DesignFunctionType value);

	/**
	 * Returns the value of the '<em><b>Target Design Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Design Function</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Design Function</em>' reference.
	 * @see #setTargetDesignFunction(DesignFunctionType)
	 * @see org.eclipse.papyrus.eastadl.timing.TimingPackage#getExecutionTimeConstraint_TargetDesignFunction()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	DesignFunctionType getTargetDesignFunction();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.timing.ExecutionTimeConstraint#getTargetDesignFunction <em>Target Design Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Design Function</em>' reference.
	 * @see #getTargetDesignFunction()
	 * @generated
	 */
	void setTargetDesignFunction(DesignFunctionType value);

	/**
	 * Returns the value of the '<em><b>Target Design Function Prototype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Design Function Prototype</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Design Function Prototype</em>' reference.
	 * @see #setTargetDesignFunctionPrototype(DesignFunctionPrototype)
	 * @see org.eclipse.papyrus.eastadl.timing.TimingPackage#getExecutionTimeConstraint_TargetDesignFunctionPrototype()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	DesignFunctionPrototype getTargetDesignFunctionPrototype();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.timing.ExecutionTimeConstraint#getTargetDesignFunctionPrototype <em>Target Design Function Prototype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Design Function Prototype</em>' reference.
	 * @see #getTargetDesignFunctionPrototype()
	 * @generated
	 */
	void setTargetDesignFunctionPrototype(DesignFunctionPrototype value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.timing.ExecutionTimeConstraint#getVariation <em>Variation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variation</em>' reference.
	 * @see #getVariation()
	 * @generated
	 */
	void setVariation(TimeDuration value);

} // ExecutionTimeConstraint
