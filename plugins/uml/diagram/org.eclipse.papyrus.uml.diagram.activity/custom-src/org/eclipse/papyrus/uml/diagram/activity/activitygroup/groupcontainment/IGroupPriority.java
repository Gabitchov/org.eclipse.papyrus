/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Arthur Daussy (Atos) - Initial API and implementation
 *   Arthur Daussy - 371712 : 372745: [ActivityDiagram] Major refactoring group framework
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.activitygroup.groupcontainment;

/**
 * Define the priority of groups to be a graphicla parent of a child
 * 
 * @author adaussy
 * 
 */
public interface IGroupPriority {

	public static int STRUCTURED_ACTIVITY_NODE_PRIORITY = 100;

	public static int ACTIVITY_PARTITION_PRIORITY = 90;

	public static int INTERRUPTIBLE_REGION_PRIORITY = 80;

	public static int ACTIVITY_PRIORITY = 50;

	public static int ACTIVITY_NODE_PRIORITY = -1;
}
