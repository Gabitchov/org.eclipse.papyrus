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

import org.eclipse.uml2.uml.Transition;

/**
 * This class encapsulates an <code>org.eclipse.uml2.uml.State</code><BR>
 * 
 * @author Remi SCHNEKENBURGER
 */
public class State extends NamedElement {

	/**
     * 
     */
	private org.eclipse.uml2.uml.State uml2State;

	/**
	 * 
	 * 
	 * @param state
	 */
	public State(org.eclipse.uml2.uml.State state) {
		super(state);
		this.uml2State = state;
	}

	/**
	 * Get the encapsulated <code>State</code>.
	 * 
	 * @return Returns the uml2State.
	 */
	public org.eclipse.uml2.uml.State getUml2State() {
		return uml2State;
	}

	/**
	 * 
	 * 
	 * @return Returns the uml2State.
	 */
	public List<org.eclipse.uml2.uml.State> getContainers() {
		List<org.eclipse.uml2.uml.State> theList = new LinkedList<org.eclipse.uml2.uml.State>();
		boolean notended = true;
		org.eclipse.uml2.uml.Region theRegion = (this.getUml2State()).getContainer();
		while (notended) {
			if (theRegion.getStateMachine() != null) {
				notended = false;
			} else if (theRegion.getState() != null) {
				theList.add(theRegion.getState());
				theRegion = (theRegion.getState()).getContainer();
			}
		}
		return theList;
	}

	/**
	 * kind is either "ignoredEvent" or "rejectedEvent" Gets ignored events for this state.
	 * 
	 * @param kind
	 * 
	 * @return Returns a List containing every ignored events
	 */
	public List<String> getEvents(String kind) {

		List<String> iEvents = new LinkedList<String>();
		List currentIEvents = (List) getTaggedValueAsObject("EventManagement", kind);
		if (currentIEvents != null) {
			// Treat these events
			Iterator cIEventsIt = currentIEvents.iterator();
			while (cIEventsIt.hasNext()) {
				String ieName = (String) cIEventsIt.next();
				iEvents.add(ieName);
			}

			// Treat OwnerState iEvents
			org.eclipse.uml2.uml.Element stateOwner = getUml2State().getContainer().getOwner();
			if (stateOwner instanceof org.eclipse.uml2.uml.State) {
				org.eclipse.papyrus.umlutils.State father = new org.eclipse.papyrus.umlutils.State((org.eclipse.uml2.uml.State) stateOwner);
				iEvents.addAll(father.getEvents(kind));
			}
		}
		return iEvents;
	}

	/**
	 * Gets the list of this state acceptable transitions.
	 * 
	 * @return Returns the list of acceptable transitions
	 */
	public List<Transition> getAcceptableTransitions() {
		List<Transition> theList = new LinkedList<Transition>();
		// Transitions owned directly by the state
		org.eclipse.uml2.uml.Region containingRegion = (this.getUml2State()).getContainer();
		Iterator transIt = containingRegion.getTransitions().iterator();
		while (transIt.hasNext()) {
			Transition theTrans = (Transition) (transIt.next());
			if (theTrans.getSource() == this.getUml2State()) {
				theList.add(theTrans);
			}
		}
		// Getting list of successive containers and adding for each of them acceptable transitions
		List<org.eclipse.uml2.uml.State> containersList = this.getContainers();
		Iterator containersIt = containersList.iterator();
		while (containersIt.hasNext()) {
			org.eclipse.uml2.uml.State theState = (org.eclipse.uml2.uml.State) containersIt.next();
			containingRegion = theState.getContainer();
			transIt = containingRegion.getTransitions().iterator();
			while (transIt.hasNext()) {
				Transition theTrans = (Transition) (transIt.next());
				if (theTrans.getSource() == theState) {
					theList.add(theTrans);
				}

			}
		}
		return theList;
	}

	/**
	 * Gets the "Accord|UML compliant" qualified name, i.e. all containers' names concatenated
	 * 
	 * @return Returns the state full name
	 */
	@Override
	public String getFullName() {
		String fullName = this.getUml2State().getName();
		List<org.eclipse.uml2.uml.State> containersList = this.getContainers();
		Iterator containersIt = containersList.iterator();
		while (containersIt.hasNext()) {
			org.eclipse.uml2.uml.State theState = (org.eclipse.uml2.uml.State) containersIt.next();
			fullName = theState.getName() + "_" + fullName;
		}
		return fullName;
	}
}
