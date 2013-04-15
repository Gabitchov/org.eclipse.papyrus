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
package org.eclipse.papyrus.moka.communication.event.isuspendresume;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.papyrus.moka.communication.Marshaller;
import org.eclipse.papyrus.moka.communication.event.EventMessage;
import org.eclipse.papyrus.moka.debug.MokaThread;

/**
 * An event message representing a Suspend event.
 * This message is emitted by the AbstractExecution engine,
 * either in response to a Suspend_Request, or when the actual
 * execution engine encountered a reason for suspending 
 * (e.g., a breakpoint has been encountered, a step has ended)
 *
 */
public class Suspend_Event extends EventMessage {

	/**
	 * The reason/detail of this Suspend_Event
	 */
	protected int suspendDetail ;
	
	/**
	 * The threads available at the execution engine when it emitted this Suspend_Event message
	 */
	protected MokaThread[] threads ;
	
	/**
	 * Constructs a Suspend_Event from the given source, suspendDetail an array of threads.
	 * Source is supposed to be same element as in the Resume_Request 
	 * which preceded the creation of this Resume_Event, if any. Otherwise, it can be any debug element
	 * on which the actual execution element may find a reason to suspend (e.g., the debug target, a thread).
	 * resumeDetail provides additional details about the reason of this
	 * resume event. The value of resumeDetail should be the same as in the
	 * Resume_Request which preceded the creation of this Resume_Event, if any. Otherwise, it will typically
	 * correspond to the fact that the execution engine encountered a breakpoint, or ended a step.
	 * threads represent the threads available at the execution engine when
	 * it suspended and emitted this event message.
	 * 
	 * @param source The source for this Suspend_Event
	 * @param suspendDetail The reason/detail of this Suspend_Event
	 * @param threads The threads available at the execution engine when it emitted this Suspend_Event message
	 */
	public Suspend_Event(IDebugElement source, int suspendDetail, MokaThread[] threads) {
		this.source = source;
		this.suspendDetail = suspendDetail;
		this.threads = threads ;
		this.eventKind = DebugEvent.SUSPEND ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.communication.event.EventMessage#marshal()
	 */
	public String marshal() {
		return Marshaller.getInstance().suspend_event_marshal(this);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.communication.event.EventMessage#getDebugEvent()
	 */
	public DebugEvent getDebugEvent() {
		if (this.debugEvent == null)
			this.debugEvent = new DebugEvent(source, eventKind, suspendDetail) ;
		return this.debugEvent;
	}
	
	/**
	 * Returns the threads available at the execution engine when it emitted this Suspend_Event message
	 * 
	 * @return The threads available at the execution engine when it emitted this Suspend_Event message
	 */
	public MokaThread[] getThreads() {
		return this.threads ;
	}

}
