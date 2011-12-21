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
 *   Atos - Initial API and implementation
 *   Arhur Daussy - Bug 315356 - [Common] Provide a common framework in order to manage groups 
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.groups.request;

import org.eclipse.gef.Request;
/**
 * This a abstract request will be used as based request for Group Framework Request
 * @author arthur daussy
 *
 */
public abstract class GroupFrameworkRequest extends Request {
	/**
	 * Type of request for node that has change of group
	 */
	public static String REFERENCED_GROUP_REQUEST = "ReferencedGroupRequest";
	/**
	 * Type of request for edge that has change of group
	 */
	public static String EDGE_GROUP_REQUEST = "EdgeGroupRequest";

	public GroupFrameworkRequest(Object type) {
		super(type);
	}
}
