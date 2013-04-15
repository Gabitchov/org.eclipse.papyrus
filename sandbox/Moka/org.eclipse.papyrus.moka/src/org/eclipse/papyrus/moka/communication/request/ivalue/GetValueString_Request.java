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
package org.eclipse.papyrus.moka.communication.request.ivalue;

import org.eclipse.debug.core.model.IValue;
import org.eclipse.papyrus.moka.communication.Marshaller;
import org.eclipse.papyrus.moka.communication.request.RequestMessage;

/**
 * A message representing a request for the string representation of a given value
 * This is emitted from the debug target, to the execution engine.
 *
 */
public class GetValueString_Request extends RequestMessage {

	/**
	 * The value for which a string representation is requested
	 */
	protected IValue value ;
	
	/**
	 * Constructs a request message from the given value.
	 * 
	 * @param value The value for which a string representation is requested
	 */
	public GetValueString_Request(IValue value) {
		this.value = value ;
	}
	
	/**
	 * Returns the value for which a string representation is requested
	 * 
	 * @return The value for which a string representation is requested
	 */
	public IValue getValue() {
		return value;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.communication.request.RequestMessage#marshall()
	 */
	public String marshall() {
		return Marshaller.getInstance().getValueString_request_marshal(this);
	}

}
