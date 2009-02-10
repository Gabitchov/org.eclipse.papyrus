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
public class ControlFlow extends NamedElement {

	/**
     * 
     */
	private org.eclipse.uml2.uml.ControlFlow uml2ControlFlow;

	/**
	 * 
	 * 
	 * @param controlFlow
	 */
	public ControlFlow(org.eclipse.uml2.uml.ControlFlow controlFlow) {
		super(controlFlow);
		this.uml2ControlFlow = controlFlow;
	}

	/**
	 * Get the encapsulated <code>Activity</code>.
	 * 
	 * @return Returns the uml2Activity.
	 */
	public org.eclipse.uml2.uml.ControlFlow getUml2ControlFlow() {
		return uml2ControlFlow;
	}

}
