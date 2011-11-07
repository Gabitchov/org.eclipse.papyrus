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
package org.eclipse.papyrus.uml.diagram.common.groups.utils;

/**
 * This class contains constants used by requests concerned by groups
 * 
 * @author vhemery
 */
public class GroupRequestConstants {

	/**
	 * The constant to recover the list of all available elements which can contain (from a model point of view) the created element.
	 * Used as Parameter key in semantic requests.
	 */
	public static final String MODEL_CONTAINERS = "GROUP_MODEL_CONTAINERS";

	/**
	 * The constant to recover the list of all available elements which can graphically contain the created element.
	 * Used as key for graphical request extended data
	 */
	public static final String GRAPHICAL_CONTAINERS = "GROUP_GRAPHICAL_CONTAINERS";

	/**
	 * Used to notify the user that the notification to choose the parent failed
	 */
	public static final String CHOOSE_PARENT_ERROR_NOTIFICATION = "The notification failed to run because no list of avaiable parent was set up";

	/**
	 * The constant to recover the list of all graphical graphical children after group creation
	 */
	public static final String GRAPHICAL_CHILDREN = "ALL_AUTOMATIC_GRAPHICAL_CHILDREN";

	/**
	 * Constant set in the extended data of a request. It used to know if the edit part handling the request should launch a refrech to all group it
	 * intersect
	 */
	public static final String SEND_UPDATE_REFERENCE_TO_CHILDREN = "HAS_TO_SEND_UPDATE_REFERENCE_TO_CHILDREN";

	/**
	 * Initial constrain of the element targeted by a request
	 */
	public static final String CONSTRAINT_AFTER_MOVING = "CONSTRAINT_AFTER_MOVING";
}
