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

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Event</b></em>'. <!--
 * end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An Event (E) is supposed to denote a distinct form of state change in a running system, taking place at distinct points in time called occurrences of the event. An event may also report a [current] state. In that case, the event occurs periodically. For example, the "driver door has been opened" is an event indicating a state change; whereas the "driver door is open" is an event reporting a state.
 * 
 * A running system can be observed by identifying certain forms of state changes to watch for, and for each such observation point, noting the times when changes occur. This notion of observation also applies to a hypothetical predicted run of a system or a system model from a timing perspective, the only information that needs to be in the output of such a prediction is a sequence of times for each observation point, indicating the times that each event is predicted to occur.
 * 
 * The occurrence of an event either stimulates an execution, or is caused by an execution [as a response to another event that occurred before]. In the first case the event is called Stimulus (S) and in the latter case it is called Response (R). Stimuli always precede responses; and responses in turn always succeed stimuli.
 * 
 * An event occurs instantaneously, which means that an event occurs at a time instant without any duration. In addition, an event can appear any number of times and the subsequent occurrences may follow a specific pattern, like periodic, sporadic, or in sudden bursts. Each of these occurrences has a unique time instant. 
 * 
 * The distinction between an event and its occurrence is usually obvious from the considered context (causal and temporal). The event is not defined by its occurrences, but rather by a description expressing its purpose.
 * 
 * 
 * Constraints:
 * [1] In the case that the event reports a [current] state (isStateChange is FALSE), the event must have a periodic event model [or a pattern model]. Rationale: The [current] state shall be reported consistently and periodically.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.Event#isIsStateChanged <em>Is State Changed</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.timing.TimingPackage#getEvent()
 * @model abstract="true"
 * @generated
 */
public interface Event extends TimingDescription {

	/**
	 * Returns the value of the '<em><b>Is State Changed</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This attribute indicates whether the event reports a state change or a [current] state. If the boolean value is TRUE, then the event reports a state change (no over-undersampling). 
	 * If the boolean value is FALSE, then the event reports a [current] state. 
	 * By default, the value of this attribute is TRUE.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is State Changed</em>' attribute.
	 * @see #setIsStateChanged(boolean)
	 * @see org.eclipse.papyrus.eastadl.timing.TimingPackage#getEvent_IsStateChanged()
	 * @model default="true" unique="false" dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsStateChanged();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.timing.Event#isIsStateChanged <em>Is State Changed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is State Changed</em>' attribute.
	 * @see #isIsStateChanged()
	 * @generated
	 */
	void setIsStateChanged(boolean value);

} // Event
