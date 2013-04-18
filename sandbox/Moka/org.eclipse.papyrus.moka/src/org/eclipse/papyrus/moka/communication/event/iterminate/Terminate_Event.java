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
import org.eclipse.debug.core.model.IThread;
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
	 * The threads available at the execution engine when it emitted 
	 * this Terminate_Event message
	 */
	protected IThread[] threads ;
	
	/**
	 * Construct a terminate event from the given source.
	 * The source is usually the debug target. See Start_Event for the rationale.
	 * 
	 * @param source The source for the terminate event
	 */
	public Terminate_Event(IDebugElement source, IThread[] threads) {
		this.source = source;
		this.eventKind = DebugEvent.TERMINATE ;
		this.threads = threads ;
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
	
	/**
	 * Returns the source of this terminate event
	 * 
	 * @return the source of this terminate event
	 */
	public IDebugElement getSource() {
		return this.source ;
	}

	/**
	 * Returns the threads available at the execution engine when it emitted this Terminate_Event message
	 * 
	 * @return The threads available at the execution engine when it emitted this Terminate_Event message
	 */
	public IThread[] getThreads() {
		return this.threads ;
	}
	
}
