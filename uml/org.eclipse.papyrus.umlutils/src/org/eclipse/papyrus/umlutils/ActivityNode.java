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
public class ActivityNode extends NamedElement {

	/**
     * 
     */
	private org.eclipse.uml2.uml.ActivityNode uml2ActivityNode;

	/**
	 * 
	 * 
	 * @param activityNode
	 */
	public ActivityNode(org.eclipse.uml2.uml.ActivityNode activityNode) {
		super(activityNode);
		this.uml2ActivityNode = activityNode;
	}

	/**
	 * Get the encapsulated <code>ActivityNode</code>.
	 * 
	 * @return Returns the uml2ActivityNode.
	 */
	public org.eclipse.uml2.uml.ActivityNode getUml2ActivityNode() {
		return uml2ActivityNode;
	}

}
