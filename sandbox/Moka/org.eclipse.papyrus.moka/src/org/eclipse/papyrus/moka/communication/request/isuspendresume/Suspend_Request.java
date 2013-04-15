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
package org.eclipse.papyrus.moka.communication.request.isuspendresume;

import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.papyrus.moka.communication.Marshaller;
import org.eclipse.papyrus.moka.communication.request.RequestMessage;

/**
 * A message representing a request for suspending execution.
 * This is emitted from the debug target, to the execution engine.
 *
 */
public class Suspend_Request extends RequestMessage {

	/**
	 * The element from which the execution engine shall suspend execution
	 */
	protected IDebugElement debugElement; 
	
	/**
	 * The reason for suspending. This is typically a Client Request
	 */
	protected int suspendDetail ;
	
	/**
	 * Constructs a request message from the given debug element and suspend details.
	 * debugElement represents the element from which the execution engine shall suspend execution
	 * resumeDetail provides information about the reason for suspending. This is typically a Client Request.
	 * 
	 * @param debugElement The element from which the execution engine shall suspend execution
	 * @param resumeDetail The reason for suspending
	 */
	public Suspend_Request(IDebugElement debugElement, int suspendDetail) {
		this.debugElement = debugElement;
		this.suspendDetail = suspendDetail;
	}

	/**
	 * Returns the element from which the execution engine shall suspend execution
	 * 
	 * @return The element from which the execution engine shall suspend execution
	 */
	public IDebugElement getDebugElement() {
		return debugElement;
	}

	/**
	 * Returns the reason for suspending. This is typically a Client Request.
	 * 
	 * @return The reason for suspending
	 */
	public int getSuspendDetail() {
		return suspendDetail;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.communication.request.RequestMessage#marshall()
	 */
	public String marshall() {
		return Marshaller.getInstance().suspend_request_marshal(this);
	}

}
