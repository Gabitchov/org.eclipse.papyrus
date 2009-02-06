/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi SCHNEKENBURGER (CEA LIST) Remi.schnekenburger@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.umlutils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;

/**
 * This class encapsulates an <code>org.eclipse.uml2.uml.StateMachine</code><BR>
 * 
 */
public class StateMachine extends Behavior {

	/**
     * 
     */
	private org.eclipse.uml2.uml.StateMachine uml2StateMachine;

	/**
	 * 
	 * 
	 * @param sm
	 */
	public StateMachine(org.eclipse.uml2.uml.StateMachine sm) {
		super(sm);
		this.uml2StateMachine = sm;
	}

	/**
	 * Get the encapsulated <code>StateMachine</code>.
	 * 
	 * @return Returns the uml2StateMachine.
	 */
	public org.eclipse.uml2.uml.StateMachine getUml2StateMachine() {
		return uml2StateMachine;
	}

	/**
	 * 
	 * 
	 * @return Simple states of current stateMachine
	 */
	public List<State> getSimpleStates() {
		List<State> states = new LinkedList<State>();

		// Parse owned regions
		Iterator i = uml2StateMachine.getRegions().iterator();
		while (i.hasNext()) {
			org.eclipse.papyrus.umlutils.Region currentRegion = new org.eclipse.papyrus.umlutils.Region((org.eclipse.uml2.uml.Region) i.next());
			states.addAll(currentRegion.getSimpleStates());
		}

		return states;
	}

	/**
	 * Gets all the states of the state machine.
	 * 
	 * @return all the states
	 */
	public List<org.eclipse.uml2.uml.State> getAllStates() {
		List<org.eclipse.uml2.uml.State> states = new ArrayList<org.eclipse.uml2.uml.State>();

		// Parse owned regions
		Iterator i = uml2StateMachine.getRegions().iterator();
		while (i.hasNext()) {
			org.eclipse.uml2.uml.Region currentRegion = (org.eclipse.uml2.uml.Region) i.next();

			Iterator iElt = currentRegion.getOwnedElements().iterator();
			while (iElt.hasNext()) {
				org.eclipse.uml2.uml.Element currentElt = (org.eclipse.uml2.uml.Element) iElt.next();
				if (currentElt instanceof org.eclipse.uml2.uml.State) {
					states.add((org.eclipse.uml2.uml.State) currentElt);
				}
			}
		}
		return states;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public org.eclipse.papyrus.umlutils.State getInitialState() {
		org.eclipse.papyrus.umlutils.State initState = null;

		// We suppose that only one region exists
		org.eclipse.uml2.uml.Region currentRegion = (org.eclipse.uml2.uml.Region) uml2StateMachine.getRegions().get(0);

		initState = (new org.eclipse.papyrus.umlutils.Region(currentRegion)).getInitialState();

		return initState;
	}

	/**
	 * Gets *all* state machine transitions</code> Beware: only deals with Accord|UML state machines (i.e. single region)
	 * 
	 * @return Returns all state machine transitions (org.eclipse.uml2.uml.Transition)
	 */
	public List<org.eclipse.uml2.uml.Transition> getTransitions() {
		List<org.eclipse.uml2.uml.Transition> transList = new LinkedList<org.eclipse.uml2.uml.Transition>();
		EList regions = (this.getUml2StateMachine()).getRegions();
		if (regions.size() >= 2) {
			// TODO error management
		} else {
			org.eclipse.uml2.uml.Region theRegion = (org.eclipse.uml2.uml.Region) (regions.get(0));
			// Getting first region transitions
			transList.addAll(theRegion.getTransitions());
			// Then, finding composite states and adding recursively contained transitions
			EList regionVertices = theRegion.getSubvertices();
			Iterator verticesIterator = regionVertices.iterator();
			while (verticesIterator.hasNext()) {
				org.eclipse.uml2.uml.Vertex theVertex = (org.eclipse.uml2.uml.Vertex) verticesIterator.next();
				if ((theVertex instanceof org.eclipse.uml2.uml.State) && ((org.eclipse.uml2.uml.State) theVertex).isComposite()) {
					org.eclipse.uml2.uml.State theCompState = (org.eclipse.uml2.uml.State) theVertex;
					List<org.eclipse.uml2.uml.State> compStatesList = new LinkedList<org.eclipse.uml2.uml.State>();
					compStatesList.add(theCompState);
					while (compStatesList.isEmpty() != true) {
						org.eclipse.uml2.uml.State currentState = compStatesList.get(compStatesList.size() - 1);
						theRegion = (org.eclipse.uml2.uml.Region) (currentState.getRegions()).get(0);
						// Adding current state transitions
						transList.addAll(theRegion.getTransitions());
						Iterator nextVerticesIterator = (theRegion.getSubvertices()).iterator();
						while (nextVerticesIterator.hasNext()) {
							theVertex = (org.eclipse.uml2.uml.Vertex) nextVerticesIterator.next();
							if ((theVertex instanceof org.eclipse.uml2.uml.State) && ((org.eclipse.uml2.uml.State) theVertex).isComposite()) {
								compStatesList.add((org.eclipse.uml2.uml.State) theVertex);
							}
						}
						compStatesList.remove(currentState);
					}
				}
			}
		}
		return transList;
	}
}