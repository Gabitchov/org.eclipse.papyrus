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

import org.eclipse.papyrus.eastadl.timing.EventChain;
import org.eclipse.papyrus.eastadl.timing.TimeDuration;
import org.eclipse.papyrus.eastadl.timing.TimingConstraint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delay Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * DelayConstraints give bounds on system timing attributes, i.e. end-to-end delays, periods, etc.
 * 
 * A DelayConstraint can specify one or several of an upper bound, a lower bound or a nominal value and jitter. The jitter is evenly distributed around the nominal (nominal - jitter/2 .. nominal + jitter/2). The bound will be measured in a given unit.
 * 
 * Constraints:
 * [1] At least Upper or Nominal must be specified. Rationale: At least one value is needed to work with.
 * 
 * Semantics:
 * Lower (from TimingConstraint) denotes the minimum value of the given bound.
 * Upper (from TimingConstraint) denotes the maximum value of the given bound.
 * Variation around the nominal value can be expressed by means of an upper and lower bound, or by means of a jitter value.
 * For example, [lower=10, upper=20, nominal=15] is equal to [nominal=15, jitter=10].
 * 
 * 
 * Extension:
 * abstract, no extension
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.DelayConstraint#getJitter <em>Jitter</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.DelayConstraint#getNominal <em>Nominal</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.DelayConstraint#getScope <em>Scope</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.TimingconstraintsPackage#getDelayConstraint()
 * @model abstract="true"
 * @generated
 */
public interface DelayConstraint extends TimingConstraint {
	/**
	 * Returns the value of the '<em><b>Jitter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Jitter is the range within which a value varies.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Jitter</em>' reference.
	 * @see #setJitter(TimeDuration)
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.TimingconstraintsPackage#getDelayConstraint_Jitter()
	 * @model ordered="false"
	 * @generated
	 */
	TimeDuration getJitter();

	/**
	 * Returns the value of the '<em><b>Nominal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The recurring distance between each occurrence.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Nominal</em>' reference.
	 * @see #setNominal(TimeDuration)
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.TimingconstraintsPackage#getDelayConstraint_Nominal()
	 * @model ordered="false"
	 * @generated
	 */
	TimeDuration getNominal();

	/**
	 * Returns the value of the '<em><b>Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scope</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scope</em>' reference.
	 * @see #setScope(EventChain)
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.TimingconstraintsPackage#getDelayConstraint_Scope()
	 * @model ordered="false"
	 * @generated
	 */
	EventChain getScope();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.DelayConstraint#getJitter <em>Jitter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jitter</em>' reference.
	 * @see #getJitter()
	 * @generated
	 */
	void setJitter(TimeDuration value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.DelayConstraint#getNominal <em>Nominal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nominal</em>' reference.
	 * @see #getNominal()
	 * @generated
	 */
	void setNominal(TimeDuration value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.DelayConstraint#getScope <em>Scope</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scope</em>' reference.
	 * @see #getScope()
	 * @generated
	 */
	void setScope(EventChain value);

} // DelayConstraint
