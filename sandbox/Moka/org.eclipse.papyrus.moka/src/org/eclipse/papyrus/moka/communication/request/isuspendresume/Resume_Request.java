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
package org.eclipse.papyrus.moka.communication.request.isuspendresume;

import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.papyrus.moka.communication.Marshaller;
import org.eclipse.papyrus.moka.communication.request.RequestMessage;

/**
 * A message representing a request for resuming execution.
 * This is emitted from the debug target, to the execution engine.
 *
 */
public class Resume_Request extends RequestMessage {

	/**
	 * The element from which the execution engine shall resume execution
	 */
	protected IDebugElement debugElement; 
	
	/**
	 * The reason for resuming (e.g. Resume, step over, step into, etc.)
	 */
	protected int resumeDetail ;
	
	/**
	 * Constructs a request message from the given debug element and resume details.
	 * debugElement represents the element from which the execution engine shall resume execution
	 * resumeDetail provides information about the reason for resuming (e.g. Resume, step over, step into, etc.)
	 * 
	 * @param debugElement The element from which the execution engine shall resume execution
	 * @param resumeDetail The reason for resuming (e.g. Resume, step over, step into, etc.)
	 */
	public Resume_Request(IDebugElement debugElement, int resumeDetail) {
		this.debugElement = debugElement;
		this.resumeDetail = resumeDetail;
	}

	/**
	 * Returns the element from which the execution engine shall resume execution
	 * 
	 * @return The element from which the execution engine shall resume execution
	 */
	public IDebugElement getDebugElement() {
		return debugElement;
	}

	/**
	 * Returns the reason for resuming (e.g. Resume, step over, step into, etc.)
	 * 
	 * @return The reason for resuming (e.g. Resume, step over, step into, etc.)
	 */
	public int getResumeDetail() {
		return resumeDetail;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.communication.request.RequestMessage#marshall()
	 */
	public String marshall() {
		return Marshaller.getInstance().resume_request_marshal(this);
	}

}
