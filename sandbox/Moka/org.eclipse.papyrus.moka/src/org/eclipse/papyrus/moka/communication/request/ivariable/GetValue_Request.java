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

import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.moka.communication.Marshaller;
import org.eclipse.papyrus.moka.communication.request.RequestMessage;

/**
 * A message representing a request for retrieving the value associated with a variable.
 * This is emitted from the debug target, to the execution engine.
 *
 */
public class GetValue_Request extends RequestMessage {

	/**
	 * The variable for which associated value is requested
	 */
	protected IVariable variable ;
	
	/**
	 * Constructs a request message from the given variable.
	 * 
	 * @param variable The variable for which associated value is requested
	 */
	public GetValue_Request(IVariable variable) {
		this.variable = variable ;
	}
	
	/**
	 * Returns the variable for which associated value is requested
	 * 
	 * @return The variable for which associated value is requested
	 */
	public IVariable getVariable() {
		return variable;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.communication.request.RequestMessage#marshall()
	 */
	public String marshall() {
		return Marshaller.getInstance().getValue_request_marshal(this);
	}

}
