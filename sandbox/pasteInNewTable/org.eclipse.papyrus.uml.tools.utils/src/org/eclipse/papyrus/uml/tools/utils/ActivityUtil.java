/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi SCHNEKENBURGER (CEA LIST) Remi.schnekenburger@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.utils;

import java.util.Iterator;

import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ControlFlow;
import org.eclipse.uml2.uml.InitialNode;

/**
 * This class encapsulates an <code>org.eclipse.uml2.uml.Activity</code><BR>
 */

public class ActivityUtil {

	/**
	 * Returns the uml2Activity's initial node. We consider that there is at most one initial node
	 * in an activity.
	 * 
	 * @param uml2Activity
	 *        investigated
	 * @return the initial node of uml2Activity, null otherwise.
	 */
	// @unused
	public static InitialNode getInitialNode(Activity uml2Activity) {
		Iterator<ActivityNode> nodesIter = uml2Activity.getNodes().iterator();
		while(nodesIter.hasNext()) {
			ActivityNode currentNode = nodesIter.next();
			if(currentNode instanceof InitialNode)
				return (InitialNode)currentNode;
		}
		return null;
	}

	/**
	 * Returns the activity node that is connected to uml2ActivityNode by a control flow. We
	 * consider that there is at most one outgoing control flow from an activity node (first one
	 * found is returned).
	 * 
	 * @param uml2ActivityNode
	 *        origin node
	 * @return next node of uml2ActivityNode, null otherwise.
	 */
	// @unused
	public static ActivityNode getNextNode(ActivityNode uml2ActivityNode) {
		Iterator<ActivityEdge> edgeIter = uml2ActivityNode.getOutgoings().iterator();
		while(edgeIter.hasNext()) {
			ActivityEdge currentEdge = edgeIter.next();
			if(currentEdge instanceof ControlFlow)
				return currentEdge.getTarget();
		}
		return null;
	}

}
