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
package org.eclipse.papyrus.moka.communication.event;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.model.IDebugElement;

/**
 * Abstract class representing communication of an event (e.g., suspend, resume, etc.)
 * 
 */
public abstract class EventMessage {
	
	/**
	 * the debug element from which this event originated
	 */
	protected IDebugElement source ;
	
	/**
	 * the kind of event
	 */
	protected int eventKind ;
		
	/**
	 * the actual debug event
	 */
	protected DebugEvent debugEvent ;
	
	/**
	 * Marshal this Event message, so that it can be communicated between
	 * the debug target and the actual execution engine
	 * 
	 * @return A String encoding of this event message
	 */
	public abstract String marshal() ;
	
	/**
	 * Returns the actual debug event associated with this message
	 * 
	 * @return the actual debug event associated with this message
	 */
	public abstract DebugEvent getDebugEvent() ;
	
}
