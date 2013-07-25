/*****************************************************************************
 * Copyright (c) 2013 PROTEUS Project consortium.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Sebastien BONNET (EFFIDENCE) - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.robotml.generators.common.mmqueries;

import java.util.LinkedList;
import java.util.List;


import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.util.UMLUtil;

public class FSMQueries {
	/**
	 * Find all states in a state machine.
	 * @param sm a state machine
	 * @return a list of states
     * @todo a valider par Nicolas 
	 */
	public List<org.eclipse.uml2.uml.Vertex> getStates(StateMachine sm)
	{
		LinkedList<org.eclipse.uml2.uml.Vertex> res = new LinkedList<org.eclipse.uml2.uml.Vertex>();
		for (org.eclipse.uml2.uml.Region region : sm.getRegions())	
			for(org.eclipse.uml2.uml.Vertex vertex : region.getSubvertices())
				res.add((org.eclipse.uml2.uml.Vertex)vertex);
		
		return res;
	}
	
	/**
	 * Find all transitions in a state machine.
	 * @param sm a state machine
	 * @return a list of transitions
     * @todo a valider par Nicolas 
	 */
	public List<org.eclipse.papyrus.RobotML.Transition> getTransitions(StateMachine sm)
	{
		LinkedList<org.eclipse.papyrus.RobotML.Transition> res = new LinkedList<org.eclipse.papyrus.RobotML.Transition>();
		for (org.eclipse.uml2.uml.Region region : sm.getRegions())
		{
			for(org.eclipse.uml2.uml.Transition transition : region.getTransitions())
			{
				org.eclipse.papyrus.RobotML.Transition robotml_transition = UMLUtil.getStereotypeApplication(transition, org.eclipse.papyrus.RobotML.Transition.class); 
				if(robotml_transition != null)
				{
					res.add(robotml_transition);
				}
			}
		}
		return res;
	}
	
	/**
	 * Find all state machines in a component.
	 * @param elt
	 * @return a list of state machines
	 * @todo a valider par Nicolas
	 */
	public List<StateMachine> getStateMachines(Element elt)
	{
		LinkedList<StateMachine> res = new LinkedList<StateMachine>();
 
		for (Element child : elt.getOwnedElements())
			if (child instanceof StateMachine)
				res.add((StateMachine)child);
		
		return res;
	}
	
	/**
	 * Generate the state operation
	 * @param vertex
	 * @return
	 */
	public String generateOperationStateString(org.eclipse.uml2.uml.Vertex vertex)
	{
		String result = "";
		if(vertex instanceof State)
		{
			org.eclipse.papyrus.RobotML.State state = UMLUtil.getStereotypeApplication(vertex, org.eclipse.papyrus.RobotML.State.class);
			if(state != null)
			{
				if(state.getOperation() != null)
				{
					String operation = state.getOperation().getBase_Operation().getName();
					result = operation;
				}
			}
		}
		return result;
	}
}
