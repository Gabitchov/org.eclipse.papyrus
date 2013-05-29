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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Event Chain</b></em>'. <!--
 * end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The purpose of event chains is to describe the temporal behavior of a number of steps to be taken to respond to one or more events accordingly. [An event chain is also used to express that a temporal requirement/constraint is imposed on a number of steps to respond to one or more events accordingly (-> requirement).] Such events could be observed in a given system and are categorized into stimuli and responses.
 * 
 * Event chains can refer to other event chains which are then called event chain segments or strands. Segments are sequential event chains refining an EventChain, while strands define parallel event chains that refine an EventChain. An EventChain can be both a segment and a strand at the same time. An event chain respectively event chain segment can be atomic which means it is not refined to other event chains.
 * 
 * Constraints:
 * [1] The cardinality of strand shall be either 0 or greater than 1. Rationale: Only values > 1 express true parallelism.
 * 
 * Semantics:
 * An EventChain references two groups of events: stimulus and response. The semantics is that each event in the stimulus group somehow causes, or at least affects the value of all events in the response group. However, since questions about causality and value influence clearly involve the semantics of the underlying structural model, this aspect of an EventChain is semantically outside its scope. Instead, delay constraint semantics are defined solely in terms of the times at which the stimulus and response events occur, independently of whether there actually exists a causal connection between these events in the structural model.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.EventChain#getSegment <em>Segment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.EventChain#getStrand <em>Strand</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.EventChain#getResponse <em>Response</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.EventChain#getStimulus <em>Stimulus</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.timing.TimingPackage#getEventChain()
 * @model
 * @generated
 */
public interface EventChain extends TimingDescription {

	/**
	 * Returns the value of the '<em><b>Response</b></em>' reference list. The list contents are of
	 * type {@link org.eclipse.papyrus.eastadl.timing.Event}. <!-- begin-user-doc --> <!--
	 * end-user-doc --> <!-- begin-model-doc --> The Response element is the entity to describe an
	 * event that is a response to a stimulus that occurred before. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Response</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.timing.TimingPackage#getEventChain_Response()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<Event> getResponse();

	/**
	 * Returns the value of the '<em><b>Segment</b></em>' reference list. The list contents are of
	 * type {@link org.eclipse.papyrus.eastadl.timing.EventChain}. <!-- begin-user-doc -->
	 * <!-- end-user-doc --> <!-- begin-model-doc --> Referred EventChains that are not parallel and
	 * in sequence refines this EventChain. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Segment</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.timing.TimingPackage#getEventChain_Segment()
	 * @model
	 * @generated
	 */
	EList<EventChain> getSegment();

	/**
	 * Returns the value of the '<em><b>Stimulus</b></em>' reference list. The list contents are of
	 * type {@link org.eclipse.papyrus.eastadl.timing.Event}. <!-- begin-user-doc --> <!--
	 * end-user-doc --> <!-- begin-model-doc --> The Stimulus element is the entity to describe an
	 * event that stimulates the steps to be taken to respond to this event. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Stimulus</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.timing.TimingPackage#getEventChain_Stimulus()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<Event> getStimulus();

	/**
	 * Returns the value of the '<em><b>Strand</b></em>' reference list. The list contents are of
	 * type {@link org.eclipse.papyrus.eastadl.timing.EventChain}. <!-- begin-user-doc -->
	 * <!-- end-user-doc --> <!-- begin-model-doc --> Parallel EventChains refining this EventChain.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Strand</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.timing.TimingPackage#getEventChain_Strand()
	 * @model ordered="false"
	 * @generated
	 */
	EList<EventChain> getStrand();

} // EventChain
