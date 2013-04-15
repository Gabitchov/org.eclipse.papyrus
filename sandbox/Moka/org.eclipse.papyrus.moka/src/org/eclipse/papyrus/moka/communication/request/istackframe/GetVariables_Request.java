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
package org.eclipse.papyrus.moka.communication.request.istackframe;

import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.papyrus.moka.communication.Marshaller;
import org.eclipse.papyrus.moka.communication.request.RequestMessage;

/**
 * A message representing a request for variables.
 * This is emitted from the debug target, to the execution engine.
 *
 */
public class GetVariables_Request extends RequestMessage {

	/**
	 * The debug element from which variables have to be retrieved.
	 * It can be a stack frame or a value
	 */
	protected IDebugElement stackFrameOrValue ;
	
	/**
	 * Constructs a request message from the given debug element.
	 * This debug element can be:
	 * - A stack frame
	 * - A value
	 * 
	 * @param stackFrameOrValue The debug element from which variables have to be retrieved
	 */
	public GetVariables_Request(IDebugElement stackFrameOrValue) {
		this.stackFrameOrValue = stackFrameOrValue;
	}
	
	/**
	 * Returns the debug element from which variables have to be retrieved.
	 * 
	 * @return The debug element from which variables have to be retrieved.
	 */
	public IDebugElement getStackFrameOrValue() {
		return stackFrameOrValue;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.communication.request.RequestMessage#marshall()
	 */
	public String marshall() {
		return Marshaller.getInstance().getVariables_request_marshal(this);
	}

}
