/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher  ansgar.radermacher@cea.fr  
 *
 *****************************************************************************/

package org.eclipse.papyrus.qompass.modellibs.core.acceleo;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;


/**
 * This class encapsulates an <code>org.eclipse.uml2.uml.Transition</code><BR>
 * 
 * @author Remi SCHNEKENBURGER
 */
public class TransitionService {

	/**
	 * Get the transition number within the state machine
	 * BEWARE: this method works only with Accord|UML compliant State Machines,
	 * with no parallel processing, i.e. a single region
	 * 
	 * @return Returns the transition number, returns 0 if pb
	 */
	public int getNumber(Transition transition) {
		int nb = 0;
		StateMachine stateMachine = transition.containingStateMachine();
		EList<Region> SMRegions = stateMachine.getRegions();
		if(SMRegions.size() >= 2) {
			// TODO error message
		} else {
			Region theRegion = SMRegions.get(0);
			for(Transition currentTrans : theRegion.getTransitions()) {
				nb = nb + 1;
				if(currentTrans == transition) {
					break;
				}
			}
		}
		return nb;
	}
}
