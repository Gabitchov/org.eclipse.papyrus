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
package org.eclipse.papyrus.moka.debug;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.papyrus.moka.Activator;
import org.eclipse.papyrus.moka.MokaConstants;

/**
 * An implementation of IDebugElement factorizing methods and properties for
 * other debug classes provided by Moka.
 *
 */
public abstract class MokaDebugElement extends PlatformObject implements IDebugElement {

	/**
	 *  The moka debug target associated with this debug element 
	 */
	protected MokaDebugTarget debugTarget;

	/**
	 * Constructs a new debug element contained in the given moka debug target.
	 * 
	 * @param target Moka debug target
	 */
	public MokaDebugElement(MokaDebugTarget target) {
		this.debugTarget = target;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDebugElement#getModelIdentifier()
	 */
	public String getModelIdentifier() {
		return MokaConstants.MOKA_DEBUG_MODEL_ID;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDebugElement#getDebugTarget()
	 */
	public IDebugTarget getDebugTarget() {
		return this.debugTarget;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDebugElement#getLaunch()
	 */
	public ILaunch getLaunch() {
		return this.debugTarget.getLaunch();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if (adapter == IDebugElement.class) {
			return this;
		}
		return super.getAdapter(adapter);
	}
	
	/**
	 * Convenience method for the setting the debug target of this debug element
	 * 
	 * @param debugTarget The debug target for this debug element
	 */
	public void setDebugTarget(MokaDebugTarget debugTarget) {
		this.debugTarget = debugTarget ;
	}
	
	/**
	 * Convenience method for aborting execution
	 * 
	 * @param message
	 * @param e
	 * @throws DebugException
	 */
	protected void abort(String message, Throwable e) throws DebugException {
		throw new DebugException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, DebugPlugin.INTERNAL_ERROR, message, e));
	}

	/**
	 * Convenience method for firing a debug event to the debug plugin
	 * 
	 * @param event the event to be fired
	 */
	protected void fireEvent(DebugEvent event) {
		DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[] {event});
	}

}
