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
 *   Bug 366159 - [ActivityDiagram] Activity Diagram should be able to handle correctly Interruptible Edge
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.request;

import org.eclipse.gef.Request;
/**
 * @author arthur daussy
 */
public class InterruptibleEdgeRequest extends Request {

	/**
	 * Request type to set an activity edge as an interruptible edge
	 */
	public static String SET_INTERRUPTIBLE_EDGE = "set_interruptible_edge";

	/**
	 * Request type to unset an activity edge as an interruptible edge
	 */
	public static String UNSET_INTERRUPTIBLE_EDGE = "unset_interruptible_edge";

	@Override
	public void setType(Object type) {
		if(!SET_INTERRUPTIBLE_EDGE.equals(type) && !UNSET_INTERRUPTIBLE_EDGE.equals(type)) {
			setType(UNSET_INTERRUPTIBLE_EDGE);
		}
		super.setType(type);
	}
}
