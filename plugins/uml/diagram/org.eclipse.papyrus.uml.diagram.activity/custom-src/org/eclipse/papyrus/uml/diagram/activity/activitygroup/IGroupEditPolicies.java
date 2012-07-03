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
package org.eclipse.papyrus.uml.diagram.activity.activitygroup;

/**
 * @author arthur daussy
 */
public interface IGroupEditPolicies {

	/**
	 * Role for Edit Policy which notify event to the group framework
	 */
	public static String GROUP_FRAMEWORK_NOTIFYING_ON_MOVE_EDIT_POLICY = "GroupFramework_NotifyingOnMoveEditPolicy";

	/**
	 * Role for Edit Policy which notify event to the group framework
	 */
	public static String GROUP_FRAMEWORK_NOTIFYING_ON_CREATION_EDIT_POLICY = "GroupFramework_NotifyingOnCreationEditPolicy";

	/**
	 * Role for Edit Policy which handle group framework notification
	 */
	public static String GROUP_FRAMEWORK_HANDLING_EDIT_POLICY = "GroupFramework_HandlingEditPolicy";
}
