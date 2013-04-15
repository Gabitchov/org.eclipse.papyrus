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
package org.eclipse.papyrus.moka.communication.reply.ithread;

import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.papyrus.moka.communication.Marshaller;
import org.eclipse.papyrus.moka.communication.reply.ReplyMessage;

/**
 * A reply message, emitted by the execution engine in response
 * to a GetStackFrames_Request
 *
 */
public class GetStackFrames_Reply extends ReplyMessage {

	/**
	 * The stack associated with this reply message
	 */
	protected IStackFrame[] stackFrames ;
	
	/**
	 * Constructs a reply message from an array of stack frames
	 * 
	 * @param stackFrames The stack associated with this reply message
	 */
	public GetStackFrames_Reply(IStackFrame[] stackFrames) {
		this.stackFrames = stackFrames;
		if (this.stackFrames == null)
			this.stackFrames = new IStackFrame[]{} ;
	}
	
	/**
	 * Returns the stack associated with this reply message
	 * 
	 * @return the stack associated with this reply message
	 */
	public IStackFrame[] getStackFrames() {
		return stackFrames;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.communication.reply.ReplyMessage#marshal()
	 */
	public String marshal() {
		return Marshaller.getInstance().getStackFrames_reply_marshal(this);
	}

}
