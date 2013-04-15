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
import org.eclipse.papyrus.moka.communication.Marshaller;
import org.eclipse.papyrus.moka.debug.MokaThread;

/**
 * An event message representing a Start event.
 * This message is emitted by the AbstractExecution engine,
 * to inform the debug target that it is properly started and that it 
 * is ready to handle requests.
 *
 */
public class Start_Event extends EventMessage {
	
	/**
	 * The threads available at the execution engine when the start_event message was emitted
	 */
	protected MokaThread[] threads ;
	
	/**
	 * Constructs a Start_Event message from a source and an array of threads.
	 * source is usually the debug target. The idea is that, while this message is 
	 * emitted from the execution engine to the debug target, the debug target then
	 * notifies the debug framework that a message occurred.
	 * From the debug framework standpoint, the source of the start event is therefore
	 * the debug target itself.
	 * threads represent the threads available at the execution engine when
	 * it is ready to start.
	 * 
	 * @param source The source for the debug event
	 * @param threads The threads available when the execution is started
	 */
	public Start_Event(IDebugElement source, MokaThread[] threads) {
		this.source = source;
		this.threads = threads ;
		this.eventKind = DebugEvent.CREATE ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.communication.event.Event#marshal()
	 */
	public String marshal() {
		return Marshaller.getInstance().start_event_marshal(this);
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
	 * Returns the threads available at the execution engine when the start_event message was emitted
	 *  
	 * @return the threads available at the execution engine when the start_event message was emitted
	 */
	public MokaThread[] getThreads() {
		return this.threads ;
	}

}
