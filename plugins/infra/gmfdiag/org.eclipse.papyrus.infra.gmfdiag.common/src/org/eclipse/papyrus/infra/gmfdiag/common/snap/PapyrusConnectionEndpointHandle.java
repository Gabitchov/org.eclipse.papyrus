/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.common.snap;

import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.handles.ConnectionEndpointHandle;


/**
 * 
 * This class allows us to provide our own
 * 
 */
public class PapyrusConnectionEndpointHandle extends ConnectionEndpointHandle {

	/**
	 * Creates a new ConnectionStartHandle, sets its owner to <code>owner</code> , and sets its locator to a {@link ConnectionLocator}.
	 * 
	 * @param owner
	 *        the ConnectionEditPart owner
	 * @param endPoint
	 *        one of {@link ConnectionLocator#SOURCE} or {@link ConnectionLocator#TARGET}.
	 */
	public PapyrusConnectionEndpointHandle(ConnectionEditPart owner, int endPoint) {
		super(owner, endPoint);
	}

	/**
	 * Creates a new ConnectionStartHandle and sets its owner to <code>owner</code>. If the handle is fixed, it cannot be dragged.
	 * 
	 * @param owner
	 *        the ConnectionEditPart owner
	 * @param fixed
	 *        if true, handle cannot be dragged.
	 * @param endPoint
	 *        one of {@link ConnectionLocator#SOURCE} or {@link ConnectionLocator#TARGET}.
	 */
	public PapyrusConnectionEndpointHandle(ConnectionEditPart owner, boolean fixed, int endPoint) {
		super(owner, fixed, endPoint);
	}

	/**
	 * Creates a new ConnectionStartHandle.
	 * 
	 * @param endPoint
	 *        one of {@link ConnectionLocator#SOURCE} or {@link ConnectionLocator#TARGET}.
	 */
	public PapyrusConnectionEndpointHandle(int endPoint) {
		super(endPoint);
	}

	/**
	 * Creates and returns a new {@link PapyrusConnectionEndpointTracker}.
	 * 
	 * @return the new ConnectionEndpointTracker
	 */
	protected DragTracker createDragTracker() {
		if(isFixed()) {
			return null;
		}
		PapyrusConnectionEndpointTracker tracker = new PapyrusConnectionEndpointTracker((ConnectionEditPart)getOwner());
		if(getEndPoint() == ConnectionLocator.SOURCE) {
			tracker.setCommandName(RequestConstants.REQ_RECONNECT_SOURCE);
		} else {
			tracker.setCommandName(RequestConstants.REQ_RECONNECT_TARGET);
		}
		tracker.setDefaultCursor(getCursor());
		return tracker;
	}

}
