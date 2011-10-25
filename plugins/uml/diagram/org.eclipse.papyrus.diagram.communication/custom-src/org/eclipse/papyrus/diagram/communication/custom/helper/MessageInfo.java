/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib saadia.dhouib@cea.fr  
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.communication.custom.helper;

import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;


// TODO: Auto-generated Javadoc
/**
 * The Class MessageInfo is intended to store information about a message such as the source and target lifelines.
 */
public class MessageInfo {

	/** The message. */
	private Message message;



	/** The source lifeline of the message. */
	private Lifeline source;

	/** The target lifeline of the message. */
	private Lifeline target;

	/**
	 * Instantiates a new message info.
	 * 
	 * @param message
	 *        the message
	 * @param source
	 *        the source
	 * @param target
	 *        the target
	 */
	public MessageInfo(Message message, Lifeline source, Lifeline target) {
		super();
		this.message = message;

		this.source = source;
		this.target = target;
	}


	/**
	 * Gets the source.
	 * 
	 * @return the source
	 */
	public Lifeline getSource() {
		return source;
	}


	/**
	 * Sets the source.
	 * 
	 * @param source
	 *        the new source
	 */
	public void setSource(Lifeline source) {
		this.source = source;
	}


	/**
	 * Gets the target.
	 * 
	 * @return the target
	 */
	public Lifeline getTarget() {
		return target;
	}


	/**
	 * Sets the target.
	 * 
	 * @param target
	 *        the new target
	 */
	public void setTarget(Lifeline target) {
		this.target = target;
	}

	/**
	 * Gets the message.
	 * 
	 * @return the message
	 */
	public Message getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 * 
	 * @param message
	 *        the new message
	 */
	public void setMessage(Message message) {
		this.message = message;
	}


}
