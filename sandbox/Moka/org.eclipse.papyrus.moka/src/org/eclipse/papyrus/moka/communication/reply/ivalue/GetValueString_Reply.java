/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.communication.reply.ivalue;

import org.eclipse.papyrus.moka.communication.Marshaller;
import org.eclipse.papyrus.moka.communication.reply.ReplyMessage;

/**
 * A reply message, emitted by the execution engine in response
 * to a GetValueString_Request
 *
 */
public class GetValueString_Reply extends ReplyMessage {

	/**
	 * The textual value representation associated with this reply message
	 */
	protected String textualRepresentation ;
	
	/**
	 * Constructs a reply message from a string
	 * 
	 * @param textualRepresentation The textual value representation associated with this reply message
	 */
	public GetValueString_Reply(String textualRepresentation) {
		super();
		this.textualRepresentation = textualRepresentation ;
	}

	/**
	 * Returns The textual value representation associated with this reply message
	 * 
	 * @return The textual value representation associated with this reply message
	 */
	public String getValueString() {
		return this.textualRepresentation ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.communication.reply.ReplyMessage#marshal()
	 */
	public String marshal() {
		return Marshaller.getInstance().getValueString_reply_marshal(this);
	}

}
