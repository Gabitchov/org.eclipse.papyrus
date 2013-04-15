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
package org.eclipse.papyrus.moka.communication.request.ibreakpointlistener;

import org.eclipse.papyrus.moka.communication.Marshaller;
import org.eclipse.papyrus.moka.communication.request.RequestMessage;
import org.eclipse.papyrus.moka.debug.MokaBreakpoint;

/**
 * A message representing a request for adding a breakpoint.
 * This is emitted from the debug target, to the execution engine.
 *
 */
public class AddBreakpoint_Request extends RequestMessage {

	/**
	 * The breakpoint associated with this request message
	 */
	protected MokaBreakpoint breakpoint ;
	
	/**
	 * Constructs a request message from the given breakpoint
	 * 
	 * @param breakpoint The breakpoint associated with this request message
	 */
	public AddBreakpoint_Request(MokaBreakpoint breakpoint) {
		this.breakpoint = breakpoint ;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.communication.request.RequestMessage#marshall()
	 */
	public String marshall() {
		return Marshaller.getInstance().addBreakpoint_request_marshal(this); 
	}

	/**
	 * Returns the breakpoint associated with this request message
	 * 
	 * @return The breakpoint associated with this request message
	 */
	public MokaBreakpoint getBreakpoint() {
		return this.breakpoint ;
	}
}
