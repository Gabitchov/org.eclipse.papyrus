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
package org.eclipse.papyrus.moka.communication.request.ivariable;

import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.papyrus.moka.communication.Marshaller;
import org.eclipse.papyrus.moka.communication.request.RequestMessage;

/**
 * A message representing a request for the reference type name of a given debug element.
 * This is emitted from the debug target, to the execution engine.
 *
 */
public class GetReferenceTypeName_Request extends RequestMessage {

	/**
	 * The debug element from which the reference type name is requested.
	 * This can be a variable or a value.
	 */
	protected IDebugElement debugElement ;
	
	/**
	 * Constructs a request message from the given debug element.
	 * This debug element can be a variable or a value
	 * 
	 * @param debugElement The debug element from which the reference type name is requested
	 */
	public GetReferenceTypeName_Request(IDebugElement debugElement) {
		this.debugElement = debugElement ;
	}
	
	/**
	 * Returns the debug element from which the reference type name is requested
	 * 
	 * @return The debug element from which the reference type name is requested
	 */
	public IDebugElement getVariableOrValue() {
		return debugElement;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.communication.request.RequestMessage#marshall()
	 */
	public String marshall() {
		return Marshaller.getInstance().getReferenceTypeName_request_marshal(this);
	}

}
