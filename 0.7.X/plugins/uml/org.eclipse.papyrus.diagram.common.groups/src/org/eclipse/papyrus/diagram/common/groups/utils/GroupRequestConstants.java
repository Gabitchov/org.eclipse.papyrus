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
package org.eclipse.papyrus.diagram.common.groups.utils;

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


}
