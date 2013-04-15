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

/**
 * A reply message, emitted by the execution engine in response
 * to a GetReferenceTypeName_Request
 *
 */
public class GetReferenceTypeName_Reply extends ReplyMessage {

	/**
	 * The string representing the reference type name
	 */
	protected String referenceTypeName ;
	
	/**
	 * Constructs a reply message from a string
	 * 
	 * @param referenceTypeName a string representing the reference type name
	 */
	public GetReferenceTypeName_Reply(String referenceTypeName) {
		super();
		this.referenceTypeName = referenceTypeName ;
	}

	/**
	 * Returns the string representing the reference type name associated with this message
	 * 
	 * @return the string representing the reference type name associated with this message
	 */
	public String getReferenceTypeName() {
		return this.referenceTypeName ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.communication.reply.ReplyMessage#marshal()
	 */
	public String marshal() {
		return Marshaller.getInstance().getReferenceTypeName_reply_marshal(this);
	}

}
