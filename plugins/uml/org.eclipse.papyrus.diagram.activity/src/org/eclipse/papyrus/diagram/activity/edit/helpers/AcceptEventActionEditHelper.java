/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.edit.helpers;

import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.TimeEvent;
import org.eclipse.uml2.uml.Trigger;

/**
 * @generated
 */
public class AcceptEventActionEditHelper extends UMLBaseEditHelper {

	/**
	 * Test whether the action may be considered as a time event action
	 * 
	 * @param action
	 *        the action to test
	 * @return true if action is a time event action
	 * @generated NOT
	 */
	public static boolean isAcceptTimeEventAction(AcceptEventAction action) {
		if(action.getTriggers() != null) {
			boolean hasTimeEvent = false;
			for(Trigger trigger : action.getTriggers()) {
				if(trigger != null) {
					Event event = trigger.getEvent();
					if(event instanceof TimeEvent) {
						hasTimeEvent = true;
					} else {
						return false;
					}
				}
			}
			// only time events have been encountered, but maybe no event at all.
			return hasTimeEvent;
		}
		return false;
	}
}
