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
package org.eclipse.papyrus.moka.communication.request;

/**
 * Abstract class representing communication of a request
 * 
 */
public abstract class RequestMessage {

	/**
	 * Marshal this Request message, so that it can be communicated between
	 * the debug target and the actual execution engine
	 * 
	 * @return A String encoding of this request message
	 */
	public abstract String marshall() ;
	
}
