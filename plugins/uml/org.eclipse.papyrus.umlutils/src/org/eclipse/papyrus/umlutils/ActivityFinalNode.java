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
package org.eclipse.papyrus.umlutils;

/**
 * 
 * 
 * @author Remi SCHNEKENBURGER
 */
public class ActivityFinalNode extends ActivityNode {

	/**
     * 
     */
	private org.eclipse.uml2.uml.ActivityFinalNode uml2ActivityFinalNode;

	/**
	 * 
	 * 
	 * @param activityFinalNode
	 */
	public ActivityFinalNode(org.eclipse.uml2.uml.ActivityFinalNode activityFinalNode) {
		super(activityFinalNode);
		this.uml2ActivityFinalNode = activityFinalNode;
	}

	/**
	 * Get the encapsulated <code>InitialNode</code>.
	 * 
	 * @return Returns the uml2InitialNode.
	 */
	public org.eclipse.uml2.uml.ActivityFinalNode getUml2ActivityFinalNode() {
		return uml2ActivityFinalNode;
	}

}
