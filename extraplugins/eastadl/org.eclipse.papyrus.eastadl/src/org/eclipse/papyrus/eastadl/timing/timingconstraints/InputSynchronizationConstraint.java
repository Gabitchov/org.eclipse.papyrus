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
package org.eclipse.papyrus.eastadl.timing.timingconstraints;

import org.eclipse.papyrus.eastadl.timing.TimeDuration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Synchronization Constraint</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * InputSynchronizationConstraint is a language entity that expresses a timing constraint on the input synchronization among the set of stimulus
 * events.
 * 
 * Semantics:
 * The parameters of InputSynchronizationConstraint, see TimingConstraint, constrain the time from the first stimulus until last stimulus (i.e.,
 * maximum skew between these stimuli). A join point is identified by the response event in the scope EventChain.
 * 
 * Constraints:
 * [1] The set of FunctionFlowPorts referenced by the events should contain only FlowPorts with direction = in. The rationale for this is that the
 * events shall relate to data on FunctionFlowPorts which is considered (or shall be) temporally consistent.
 * 
 * [2] The scope EventChain shall contain exactly one response Event.
 * 
 * [3] The semantics of this constraint requires that there is more than one stimulus Event in the scope EventChain (each refering to a different
 * FlowPort with direction = in).
 * 
 * Extension: Class
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.InputSynchronizationConstraint#getWidth <em>Width</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.TimingconstraintsPackage#getInputSynchronizationConstraint()
 * @model
 * @generated
 */
public interface InputSynchronizationConstraint extends AgeTimingConstraint {

	/**
	 * Returns the value of the '<em><b>Width</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The width of the sliding window.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Width</em>' reference.
	 * @see #setWidth(TimeDuration)
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.TimingconstraintsPackage#getInputSynchronizationConstraint_Width()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	TimeDuration getWidth();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.InputSynchronizationConstraint#getWidth <em>Width</em>}'
	 * reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Width</em>' reference.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(TimeDuration value);

} // InputSynchronizationConstraint
