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
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.helper;

import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.OpaqueAction;
import org.eclipse.uml2.uml.OutputPin;

/**
 * this edit helper contains util method in order to manage ObjectFlow
 */
public class CustomObjectFlowEditHelper  {

	/**
	 * Return whether we can create a new object flow starting from this action by adding an intermediate output pin at it.
	 * 
	 * @param action
	 *        the action to start from
	 * @return whether action accept new output pin
	 */
	public static boolean canStartNewObjectFlow(Action action) {
		// CallOperationAction and CallBehaviorAction have pre-defined pins which are all represented.
		// SendObjectAction have only two input pins which are all represented.
		// SendSignalAction has only pre-defined input pins which are all represented.
		return (action instanceof OpaqueAction) || (action instanceof AcceptEventAction);
	}

	/**
	 * Return whether we can create a new object flow ending to this action by adding an intermediate input pin at it.
	 * 
	 * @param action
	 *        the action to end to
	 * @return whether action accept new input pin
	 */
	public static boolean canEndNewObjectFlow(Action action) {
		// CallOperationAction and CallBehaviorAction have pre-defined pins which are all represented.
		// SendObjectAction have only two input pins which are all represented.
		// SendSignalAction has only pre-defined input pins which are all represented.
		// AcceptEventAction has no input pin
		return action instanceof OpaqueAction;
	}

	/**
	 * Return whether a pin must be inserted to create a new object flow starting from this activity node.
	 * 
	 * @param node
	 *        the activity node to start from
	 * @return whether a pin must can inserted to create an object flow from this node
	 */
	public static boolean insertPinForStartingNewObjectFlow(ActivityNode node) {
		if(node instanceof Action) {
			return canStartNewObjectFlow((Action)node);
		}
		return false;
	}

	/**
	 * Return whether a pin must be inserted to create a new object flow ending to this activity node.
	 * 
	 * @param node
	 *        the activity node to end to
	 * @return whether a pin must can inserted to create an object flow to this node
	 */
	public static boolean insertPinForEndingNewObjectFlow(ActivityNode node) {
		if(node instanceof Action) {
			return canEndNewObjectFlow((Action)node);
		}
		return false;
	}

	/**
	 * Insert the created output pin in the parent action
	 * 
	 * @param parentAction
	 *        action to insert pin in
	 * @param outputPin
	 *        output pin to insert
	 */
	public static void insertOutputPin(Action parentAction, OutputPin outputPin) {
		if(parentAction instanceof OpaqueAction) {
			((OpaqueAction)parentAction).getOutputValues().add(outputPin);
		} else if(parentAction instanceof AcceptEventAction) {
			((AcceptEventAction)parentAction).getResults().add(outputPin);
		}
	}

	/**
	 * Insert the created input pin in the parent action
	 * 
	 * @param parentAction
	 *        action to insert pin in
	 * @param inputPin
	 *        input pin to insert
	 */
	public static void insertInputPin(Action parentAction, InputPin inputPin) {
		if(parentAction instanceof OpaqueAction) {
			((OpaqueAction)parentAction).getInputValues().add(inputPin);
		}
	}
}
