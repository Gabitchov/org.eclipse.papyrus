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
public class InitialNode extends ActivityNode {

	/**
     * 
     */
	private org.eclipse.uml2.uml.InitialNode uml2InitialNode;

	/**
	 * 
	 * 
	 * @param initialNode
	 */
	public InitialNode(org.eclipse.uml2.uml.InitialNode initialNode) {
		super(initialNode);
		this.uml2InitialNode = initialNode;
	}

	/**
	 * Get the encapsulated <code>InitialNode</code>.
	 * 
	 * @return Returns the uml2InitialNode.
	 */
	public org.eclipse.uml2.uml.InitialNode getUml2InitialNode() {
		return uml2InitialNode;
	}

}
