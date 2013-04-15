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
package org.eclipse.papyrus.moka.communication.reply.ivariable;

import org.eclipse.papyrus.moka.communication.Marshaller;
import org.eclipse.papyrus.moka.communication.reply.ReplyMessage;
import org.eclipse.papyrus.moka.debug.MokaValue;

/**
 * A reply message, emitted by the execution engine in response
 * to a GetValue_Request
 *
 */
public class GetValue_Reply extends ReplyMessage {

	/**
	 * The value associated with this reply message
	 */
	protected MokaValue value ;
		
	/**
	 * Constructs a GetValue_Reply from the given value
	 * 
	 * @param value The value associated with this reply message
	 */
	public GetValue_Reply(MokaValue value) {
		super();
		this.value = value ;
	}

	/**
	 * Returns the value associated with this reply message
	 * 
	 * @return The value associated with this reply message
	 */
	public MokaValue getValue() {
		return value;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.communication.reply.ReplyMessage#marshal()
	 */
	public String marshal() {
		return Marshaller.getInstance().getValue_reply_marshal(this);
	}

}
