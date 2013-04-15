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
package org.eclipse.papyrus.moka.communication.request.ithread;

import org.eclipse.debug.core.model.IThread;
import org.eclipse.papyrus.moka.communication.Marshaller;
import org.eclipse.papyrus.moka.communication.request.RequestMessage;

/**
 * A message representing a request for stack frames, available for a specific thread.
 * This is emitted from the debug target, to the execution engine.
 *
 */
public class GetStackFrames_Request extends RequestMessage {

	/**
	 * The thread for which available stack frames are requested
	 */
	protected IThread thread ;
	
	/**
	 * Constructs a request message from the given thread.
	 * 
	 * @param thread The thread for which available stack frames are requested
	 */
	public GetStackFrames_Request(IThread thread) {
		this.thread = thread;
	}

	/**
	 * Returns the thread for which available stack frames are requested
	 * 
	 * @return The thread for which available stack frames are requested
	 */
	public IThread getThread() {
		return thread;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.communication.request.RequestMessage#marshall()
	 */
	public String marshall() {
		return Marshaller.getInstance().getStackFrames_request_marshal(this);
	}

}
