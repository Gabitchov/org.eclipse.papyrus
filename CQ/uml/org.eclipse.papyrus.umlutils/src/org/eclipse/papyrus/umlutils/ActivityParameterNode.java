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

public class ActivityParameterNode extends ActivityNode {

	/**
     * 
     */
	private org.eclipse.uml2.uml.ActivityParameterNode uml2ActivityParameterNode;

	/**
	 * 
	 * 
	 * @param activityParameterNode
	 */
	public ActivityParameterNode(org.eclipse.uml2.uml.ActivityParameterNode activityParameterNode) {
		super(activityParameterNode);
		this.uml2ActivityParameterNode = activityParameterNode;
	}

	/**
	 * Get the encapsulated <code>ActivityParameterNode</code>.
	 * 
	 * @return Returns the uml2ActivityParameterNode.
	 */
	public org.eclipse.uml2.uml.ActivityParameterNode getUml2ActivityParameterNode() {
		return uml2ActivityParameterNode;
	}

}
