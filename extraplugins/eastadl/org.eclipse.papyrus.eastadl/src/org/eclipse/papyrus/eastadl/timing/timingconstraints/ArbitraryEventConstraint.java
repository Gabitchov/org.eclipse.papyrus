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

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.eastadl.timing.TimeDuration;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Arbitrary Event Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The Arbitrary Event Model describes that an event occurs occasionally, singly, irregular or randomly. The primary purpose of this event model is to abstract event occurrences captured by data acquisition tools (background debugger, trace analyzer, etc.) during the operation of a system.
 * 
 * Constraints:
 * [1] The number of elements in the sets minimum inter-arrival time and maximum inter-arrival time must be the same. Rationale: Consistent specification of arrival times.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.ArbitraryEventConstraint#getMinimumInterArrivalTime <em>Minimum Inter Arrival Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.ArbitraryEventConstraint#getMaximumInterArrivalTime <em>Maximum Inter Arrival Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.TimingconstraintsPackage#getArbitraryEventConstraint()
 * @model
 * @generated
 */
public interface ArbitraryEventConstraint extends EventConstraint {
	/**
	 * Returns the value of the '<em><b>Maximum Inter Arrival Time</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.timing.TimeDuration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of maximum inter-arrival times specifies the maximum inter-arrival time between two and more subsequent occurrences of the event. The first element in the set specifies the maximum inter-arrival time between two subsequent occurrences of the event among the given occurrences. The second element in the set specifies the maximum inter-arrival time between three subsequent occurrences of the event among the given occurrences; and so forth.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Maximum Inter Arrival Time</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.TimingconstraintsPackage#getArbitraryEventConstraint_MaximumInterArrivalTime()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<TimeDuration> getMaximumInterArrivalTime();

	/**
	 * Returns the value of the '<em><b>Minimum Inter Arrival Time</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.timing.TimeDuration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of minimum inter-arrival times specifies the minimum inter-arrival time between two and more subsequent occurrences of the event. The first element in the set specifies the minimum inter-arrival time between two subsequent occurrences of the event among the given occurrences. The second element in the set specifies the minimum inter-arrival time between three subsequent occurrences of the event among the given occurrences; and so forth.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Minimum Inter Arrival Time</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.TimingconstraintsPackage#getArbitraryEventConstraint_MinimumInterArrivalTime()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<TimeDuration> getMinimumInterArrivalTime();

} // ArbitraryEventConstraint
