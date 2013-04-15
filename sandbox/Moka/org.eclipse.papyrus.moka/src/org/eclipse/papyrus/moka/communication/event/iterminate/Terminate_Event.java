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
package org.eclipse.papyrus.moka.communication.event.iterminate;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.papyrus.moka.communication.Marshaller;
import org.eclipse.papyrus.moka.communication.event.EventMessage;

/**
 * An event message representing a Terminate event.
 * This message is emitted by the AbstractExecution engine,
 * to inform the debug target that it has properly terminated 
 * to execute.
 *
 */
public class Terminate_Event extends EventMessage {
	
	/**
	 * Construct a terminate event from the given source.
	 * The source is usually the debug target. See Start_Event for the rationale.
	 * 
	 * @param source The source for the terminate event
	 */
	public Terminate_Event(IDebugElement source) {
		this.source = source;
		this.eventKind = DebugEvent.TERMINATE ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.communication.event.Event#marshal()
	 */
	public String marshal() {
		return Marshaller.getInstance().terminate_event_marshal(this);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.communication.event.Event#getDebugEvent()
	 */
	public DebugEvent getDebugEvent() {
		if (this.debugEvent == null)
			this.debugEvent = new DebugEvent(source, eventKind) ;
		return this.debugEvent;
	}

}
