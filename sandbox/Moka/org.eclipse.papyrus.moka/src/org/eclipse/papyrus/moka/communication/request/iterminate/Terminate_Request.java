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
package org.eclipse.papyrus.moka.communication.request.iterminate;

import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.papyrus.moka.communication.Marshaller;
import org.eclipse.papyrus.moka.communication.request.RequestMessage;

/**
 * A message representing a request for terminating execution.
 * This is emitted from the debug target, to the execution engine.
 *
 */
public class Terminate_Request extends RequestMessage {

	/**
	 * The element from which the execution engine shall terminate execution
	 */
	protected IDebugElement debugElement; 
	
	/**
	 * Constructs a request message from the given debug element.
	 * 
	 * @param debugElement The element from which the execution engine shall terminate execution
	 */
	public Terminate_Request(IDebugElement debugElement) {
		this.debugElement = debugElement;
	}

	/**
	 * Returns the element from which the execution engine shall terminate execution
	 * 
	 * @return The element from which the execution engine shall terminate execution
	 */
	public IDebugElement getDebugElement() {
		return debugElement;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.communication.request.RequestMessage#marshall()
	 */
	public String marshall() {
		return Marshaller.getInstance().terminate_request_marshal(this);
	}

}
