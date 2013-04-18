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
 * An event message representing a Resume event.
 * This message is emitted by the AbstractExecution engine,
 * in response to a Resume_Request.
 *
 */
public class Resume_Event extends EventMessage {

	/**
	 * The details about the reason for this resume event (e.g., step_over, step_into, etc.)
	 */
	protected int resumeDetail ;
	
	/**
	 * The threads available at the execution engine when this message was sent
	 */
	protected MokaThread[] threads ;
	
	/**
	 * Constructs a Resume_Event from the given source and details.
	 * Source is supposed to be same element as in the Resume_Request 
	 * which preceded the creation of this Resume_Event. 
	 * (e.g., if the Resume_Request was for a specific IThread, then the source
	 * of the created Resume_Event should be the same IThread).
	 * resumeDetail provides additional details about the reason of this
	 * resume event. The value of resumeDetail should be the same as in the
	 * Resume_Request which preceded the creation of this Resume_Event.
	 * 
	 * @param source The source for this Resume_Event
	 * @param resumeDetail The reason/detail of this Resume_Event
	 * @param threads The threads available at the execution engine when this message was sent
	 */
	public Resume_Event(IDebugElement source, int resumeDetail, MokaThread[] threads) {
		this.source = source;
		this.resumeDetail = resumeDetail;
		this.eventKind = DebugEvent.RESUME ;
		this.threads = threads ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.communication.event.EventMessage#marshal()
	 */
	public String marshal() {
		return Marshaller.getInstance().resume_event_marshal(this);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.communication.event.EventMessage#getDebugEvent()
	 */
	public DebugEvent getDebugEvent() {
		if (this.debugEvent == null)
			this.debugEvent = new DebugEvent(source, eventKind, resumeDetail) ;
		return this.debugEvent;
	}
	
	/**
	 * Returns the threads available at the execution engine when this message was sent
	 * 
	 * @return The threads available at the execution engine when this message was sent
	 */
	public MokaThread[] getThreads() {
		return this.threads ;
	}

}
