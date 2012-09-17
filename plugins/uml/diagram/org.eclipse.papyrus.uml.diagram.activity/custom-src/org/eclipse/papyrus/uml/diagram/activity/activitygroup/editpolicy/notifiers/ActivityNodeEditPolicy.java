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
package org.eclipse.papyrus.uml.diagram.activity.activitygroup.editpolicy.notifiers;

import org.eclipse.papyrus.uml.diagram.activity.activitygroup.IContainerNodeDescriptor;

/**
 * Implementation of {@link GroupNotifyingOnMoveEditPolicy} for {@link ActivityNode}
 * 
 * @author arthur daussy
 * 
 */
public class ActivityNodeEditPolicy extends GroupNotifyingOnMoveEditPolicy {

	/**
	 * 
	 * @param groupDescriptor
	 */
	public ActivityNodeEditPolicy(IContainerNodeDescriptor groupDescriptor) {
		super(groupDescriptor);
	}
}
