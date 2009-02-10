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

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;

;

/**
 * This class encapsulates an <code>org.eclipse.uml2.uml.Transition</code><BR>
 * 
 * @author Remi SCHNEKENBURGER
 */
public class Transition extends Element {

	/**
     * 
     */
	private org.eclipse.uml2.uml.Transition uml2Transition;

	/**
	 * 
	 * 
	 * @param transition
	 */
	public Transition(org.eclipse.uml2.uml.Transition transition) {
		super(transition);
		this.uml2Transition = transition;
	}

	/**
	 * Get the encapsulated <code>Transition</code>.
	 * 
	 * @return Returns the uml2Transition.
	 */
	public org.eclipse.uml2.uml.Transition getUml2Transition() {
		return uml2Transition;
	}

	/**
	 * Get the state machine containing the transition (works for all kind of SM, i.e. even with multiple regions)
	 * 
	 * @return Returns the State Machine.
	 */
	public StateMachine getStateMachine() {
		StateMachine theSM = null;
		org.eclipse.uml2.uml.StateMachine theUml2SM = null;
		boolean ok = false;
		org.eclipse.uml2.uml.Region theRegion = (this.getUml2Transition()).getContainer();
		while (ok == false) {
			if (theRegion.getStateMachine() != null) {
				theUml2SM = theRegion.getStateMachine();
				ok = true;
			} else if (theRegion.getState() != null) {
				org.eclipse.uml2.uml.State theState = theRegion.getState();
				theRegion = theState.getContainer();
			}
		}
		theSM = new StateMachine(theUml2SM);
		return theSM;
	}

	/**
	 * Get the transition number within the state machine BEWARE: this method works only with Accord|UML compliant State Machines, with no parallel processing, i.e. a single region
	 * 
	 * @return Returns the transition number, returns 0 if pb
	 */
	public int getNumber() {
		int nb = 0;
		StateMachine theSM = this.getStateMachine();
		org.eclipse.uml2.uml.StateMachine theUml2SM = theSM.getUml2StateMachine();
		EList SMRegions = theUml2SM.getRegions();
		if (SMRegions.size() >= 2) {
			// TODO error message
		} else {
			boolean notended = true;
			org.eclipse.uml2.uml.Region theRegion = (org.eclipse.uml2.uml.Region) (SMRegions.get(0));
			while (notended == true) {
				// Checking the transitions owned by the region
				Iterator transIterator = (theRegion.getTransitions()).iterator();
				while (transIterator.hasNext() && notended) {
					nb = nb + 1;
					org.eclipse.uml2.uml.Transition theTrans = (org.eclipse.uml2.uml.Transition) transIterator.next();
					if (theTrans == this.getUml2Transition()) {
						notended = false;
					}
				}
				// Now looking for composite states in the region, and processing them
				Iterator verticesIterator = (theRegion.getSubvertices()).iterator();
				while (verticesIterator.hasNext() && notended) {
					org.eclipse.uml2.uml.State theCompState = null;
					org.eclipse.uml2.uml.Vertex theVertex = (org.eclipse.uml2.uml.Vertex) verticesIterator.next();
					if ((theVertex instanceof org.eclipse.uml2.uml.State) && ((org.eclipse.uml2.uml.State) theVertex).isComposite()) {
						theCompState = (org.eclipse.uml2.uml.State) theVertex;
						List<org.eclipse.uml2.uml.State> compStatesList = new LinkedList<org.eclipse.uml2.uml.State>();
						compStatesList.add(theCompState);
						while (compStatesList.isEmpty() != true) {
							org.eclipse.uml2.uml.State currentState = compStatesList.get(compStatesList.size() - 1);
							theRegion = (org.eclipse.uml2.uml.Region) (currentState.getRegions()).get(0);
							transIterator = (theRegion.getTransitions()).iterator();
							while (transIterator.hasNext() && notended) {
								nb = nb + 1;
								org.eclipse.uml2.uml.Transition theTrans = (org.eclipse.uml2.uml.Transition) transIterator.next();
								if (theTrans == this.getUml2Transition()) {
									notended = false;
								}
							}
							compStatesList.remove(currentState);
							// Looking for children in the current state and adding them to the list
							Iterator nextVerticesIterator = (theRegion.getSubvertices()).iterator();
							while (nextVerticesIterator.hasNext()) {
								theVertex = (org.eclipse.uml2.uml.Vertex) nextVerticesIterator.next();
								if ((theVertex instanceof org.eclipse.uml2.uml.State) && ((org.eclipse.uml2.uml.State) theVertex).isComposite()) {
									compStatesList.add((org.eclipse.uml2.uml.State) theVertex);
								}
							}
						}
					} else {
						// TODO error management: ("in getNumber(): it is not a composite state") ;
					}
				}
			}
		}
		return nb;
	}
}
