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
package org.eclipse.papyrus.moka.communication.reply.istackframe;

import org.eclipse.papyrus.moka.communication.Marshaller;
import org.eclipse.papyrus.moka.communication.reply.ReplyMessage;
import org.eclipse.papyrus.moka.debug.MokaVariable;

/**
 * A reply message, emitted by the execution engine in response
 * to a GetVariable_Request
 *
 */
public class GetVariables_Reply extends ReplyMessage {

	/**
	 * The variables associated with this reply message
	 */
	protected MokaVariable[] variables ;
		
	/**
	 * Constructs a reply message from an array of Variables
	 * 
	 * @param variables The variables associated with this reply message
	 */
	public GetVariables_Reply(MokaVariable[] variables) {
		super();
		this.variables = variables;
	}

	/**
	 * Returns the variables associated with this reply message
	 * 
	 * @return The variables associated with this reply message
	 */
	public MokaVariable[] getVariables() {
		return variables;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.communication.reply.ReplyMessage#marshal()
	 */
	public String marshal() {
		return Marshaller.getInstance().getVariables_reply_marshal(this);
	}

}
