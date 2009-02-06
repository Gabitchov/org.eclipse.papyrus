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

/**
 * This class encapsulates an <code>org.eclipse.uml2.uml.State</code><BR>
 * 
 * @author Remi SCHNEKENBURGER
 */
public class Region extends NamedElement {

	/**
     * 
     */
	private org.eclipse.uml2.uml.Region uml2Region;

	/**
	 * 
	 * 
	 * @param region
	 */
	public Region(org.eclipse.uml2.uml.Region region) {
		super(region);
		this.uml2Region = region;
	}

	/**
	 * Get the encapsulated <code>State</code>.
	 * 
	 * @return Returns the uml2State.
	 */
	public org.eclipse.uml2.uml.Region getUml2Region() {
		return uml2Region;
	}

	/**
	 * Retrieve the initial state.
	 * 
	 * @return
	 */
	public org.eclipse.papyrus.umlutils.State getInitialState() {

		org.eclipse.papyrus.umlutils.State initState = null;
		org.eclipse.uml2.uml.Pseudostate currentPS = null;
		boolean found = false;

		Iterator vertexIt = getUml2Region().getSubvertices().iterator();

		// Try to find the initial pseudostate
		while (vertexIt.hasNext() && !found) {
			org.eclipse.uml2.uml.Vertex currentVertex = (org.eclipse.uml2.uml.Vertex) vertexIt.next();

			if (currentVertex instanceof org.eclipse.uml2.uml.Pseudostate) {
				currentPS = (org.eclipse.uml2.uml.Pseudostate) currentVertex;

				if (currentPS.getKind() == org.eclipse.uml2.uml.PseudostateKind.INITIAL_LITERAL) {
					found = true;
				}
			}
		}

		// get targetted state -- should have one outgoing transition only
		org.eclipse.uml2.uml.Transition tr = (org.eclipse.uml2.uml.Transition) currentPS.getOutgoings().get(0);
		org.eclipse.papyrus.umlutils.State targetState = new org.eclipse.papyrus.umlutils.State((org.eclipse.uml2.uml.State) tr.getTarget());

		if (targetState.getUml2State().isComposite()) {
			org.eclipse.papyrus.umlutils.Region cRegion = new org.eclipse.papyrus.umlutils.Region((org.eclipse.uml2.uml.Region) targetState.getUml2State().getRegions().get(0));
			initState = cRegion.getInitialState();
		} else {
			initState = targetState;
		}

		return initState;
	}

	/**
	 * 
	 * 
	 * @return Simple states of current stateMachine
	 */
	public List<State> getSimpleStates() {
		List<State> states = new LinkedList<State>();

		Iterator iElt = getUml2Region().getOwnedElements().iterator();
		while (iElt.hasNext()) {
			org.eclipse.uml2.uml.Element currentElt = (org.eclipse.uml2.uml.Element) iElt.next();

			if (currentElt instanceof org.eclipse.uml2.uml.State) {
				org.eclipse.papyrus.umlutils.State currentState = new org.eclipse.papyrus.umlutils.State((org.eclipse.uml2.uml.State) currentElt);

				if (currentState.getUml2State().isSimple()) {
					states.add(currentState);
				} else {
					// Check owned regions for other simple states
					Iterator regionsIt = currentState.getUml2State().getRegions().iterator();
					while (regionsIt.hasNext()) {
						org.eclipse.papyrus.umlutils.Region region = new org.eclipse.papyrus.umlutils.Region((org.eclipse.uml2.uml.Region) regionsIt.next());

						// Recursive call
						states.addAll(region.getSimpleStates());
					}
				}

			}
		}

		return states;
	}
}
