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
 * This class encapsulates an <code>org.eclipse.uml2.uml.Message</code><BR>
 * 
 * @author Remi SCHNEKENBURGER
 */
public class Message extends NamedElement {

	/**
     * 
     */
	private org.eclipse.uml2.uml.Message uml2Message;

	/**
	 * 
	 * 
	 * @param message
	 */
	public Message(org.eclipse.uml2.uml.Message message) {
		super(message);
		this.uml2Message = message;
	}

	/**
	 * Get the encapsulated <code>Message</code>.
	 * 
	 * @return Returns the uml2Message.
	 */
	public org.eclipse.uml2.uml.Message getUml2Message() {
		return uml2Message;
	}
}
