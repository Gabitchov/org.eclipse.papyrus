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

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;


/**
 * An implementation of IThread
 *
 */
public class MokaThread extends MokaDebugElement implements IThread {
	
	public MokaThread(MokaDebugTarget debugTarget) {
		super(debugTarget) ;
	}
	
	////////////////////////////
	// Implementation of IThread
	////////////////////////////

	/**
	 * The stack frames contained in this thread.
	 */
	protected IStackFrame[] stackFrames ;
	
	/**
	 * The breakpoints this thread is suspended on.
	 * This can be empty if the thread is not suspended, or it is not suspended on a breakpoint (e.g., suspended due to a step end)
	 */
	protected MokaBreakpoint[] breakpoints = new MokaBreakpoint[]{};
	
	/**
	 * The priority of this thread
	 */
	protected int priority = 0 ;

	/**
	 * The name of this thread
	 */
	protected String name = null ;
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IThread#getStackFrames()
	 */
	public IStackFrame[] getStackFrames() throws DebugException {
		if (stackFrames != null) {
			return this.stackFrames ;
		}
		// Delegates retrieval of stack frames to the owning debug target
		this.stackFrames = this.debugTarget.getStackFrames(this) ;
		return this.stackFrames ;
	}
	
	/**
	 * A convenience method for setting the stack frames of a MokaThread
	 * 
	 * @param stackFrames The stack frames for this thread
	 */
	public void setStackFrames(IStackFrame[] stackFrames) {
		this.stackFrames = stackFrames ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IThread#hasStackFrames()
	 */
	public boolean hasStackFrames() throws DebugException {
		return this.getStackFrames().length > 0;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IThread#getPriority()
	 */
	public int getPriority() throws DebugException {
		return this.priority ;
	}
	
	/**
	 * Convenience method for setting the priority of a MokaThread
	 * 
	 * @param priority The priority of the thread
	 */
	public void setPriority(int priority) {
		this.priority = priority ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IThread#getTopStackFrame()
	 */
	public IStackFrame getTopStackFrame() throws DebugException {
		if (this.hasStackFrames())
			return this.stackFrames[0] ;
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IThread#getName()
	 */
	public String getName() throws DebugException {
		if (this.name != null)
			return this.name  ;
		return "" ;
	}
	
	/**
	 * Convenience method for setting the name of a thread
	 * 
	 * @param name The new name for this thread
	 */
	public void setName(String name) {
		this.name = name ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IThread#getBreakpoints()
	 */
	public IBreakpoint[] getBreakpoints() {
		if (! this.isSuspended)
			return new IBreakpoint[] {} ;
		return this.breakpoints ;
	}

	/**
	 * Convenience method for setting the breakpoints where a thread is suspended
	 * 
	 * @param breakpoints The breakpoints on which the thread is suspended
	 */
	public void setBreakpoints(MokaBreakpoint[] breakpoints) {
		if (breakpoints != null)
			this.breakpoints = breakpoints ;
		else
			this.breakpoints = new MokaBreakpoint[]{} ;
	}
	
	///////////////////////////////
	// Implementation of ITerminate
	///////////////////////////////

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ITerminate#canTerminate()
	 */
	public boolean canTerminate() {
		// A thread can be terminated if its debug target can be terminated
		return this.debugTarget.canTerminate() ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ITerminate#isTerminated()
	 */
	public boolean isTerminated() {
		// A thread is terminated if its debug target is terminated
		return this.debugTarget.isTerminated() ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ITerminate#terminate()
	 */
	public void terminate() throws DebugException {
		this.isStepping = false ;
		// Delegates termination to the owning debug target
		this.debugTarget.terminate(this) ;
	}

	///////////////////////////////////
	// Implementation of ISuspendResume
	///////////////////////////////////

	/**
	 * Determines whether this element is currently suspended.
	 */
	protected boolean isSuspended = false ;

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ISuspendResume#canResume()
	 */
	public boolean canResume() {
		// A thread can resume if it is suspended
		return this.isSuspended() ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ISuspendResume#canSuspend()
	 */
	public boolean canSuspend() {
		// A thread can suspend if it is not already suspended
		return !this.isSuspended() ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ISuspendResume#isSuspended()
	 */
	public boolean isSuspended() {
		return this.isSuspended ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ISuspendResume#resume()
	 */
	public void resume() throws DebugException {
		this.isSuspended = false ;
		// Delegates resume to the owning debugTarget
		this.debugTarget.resume(this, DebugEvent.CLIENT_REQUEST) ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ISuspendResume#suspend()
	 */
	public void suspend() throws DebugException {
		this.isSuspended = true ;
		// delegates suspend to the owning debugTarget
		this.debugTarget.suspend(this, DebugEvent.CLIENT_REQUEST) ;
	}

	/**
	 * Convenience method for setting the value of the isSuspended attribute
	 * 
	 * @param isSuspended
	 */
	public void setSuspended(boolean isSuspended) {
		this.isSuspended = isSuspended ;
	}
	
	//////////////////////////
	// Implementation of IStep
	//////////////////////////

	/**
	 * A thread is considered to be stepping after the step is entered (resume event is emitted) and until the step is completed (suspend event is emitted) 
	 */
	protected boolean isStepping = false ;

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IStep#canStepInto()
	 */
	public boolean canStepInto() {
		// Step into is possible if the thread is suspended.
		return this.isSuspended ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IStep#canStepOver()
	 */
	public boolean canStepOver() {
		// Step over is possible if the thread is suspended.
		return this.isSuspended ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IStep#canStepReturn()
	 */
	public boolean canStepReturn() {
		// Step return is possible if the thread is suspended.
		return this.isSuspended ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IStep#isStepping()
	 */
	public boolean isStepping() {
		return this.isStepping ;
	}

	/**
	 * Convenience method to enable the MokaDebugTarget to state that a MokaThread is no more stepping.
	 * This is called by the debug target when suspend event occurs, with one of the following SUSPEND details:
	 * - DebugEvent.STEP_END
	 * - DebugEvent.BREAKPOINT
	 * 
	 * @param isStepping
	 */
	public void stepEnded() {
		this.isStepping = false ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IStep#stepInto()
	 */
	public void stepInto() throws DebugException {
		// This thread enters stepping state
		this.isStepping = true ;
		// Resuming is delegated to the owning debug target, with appropriate RESUME event details
		// This will trigger a RESUME event for the target program.
		// Stepping state will be exit when the target program generates a suspend event corresponding to a STEP_END or BREAKPOINT
		// Exiting the stepping state is handled by the moka debug target, in reaction to the suspend event.
		this.debugTarget.resume(this, DebugEvent.STEP_INTO) ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IStep#stepOver()
	 */
	public void stepOver() throws DebugException {
		// This thread enters stepping state. 
		this.isStepping = true ;
		// Resuming is delegated to the owning debug target, with appropriate RESUME event details
		// This will trigger a RESUME event for the target program.
		// Stepping state will be exit when the target program generates a suspend event corresponding to a STEP_END or BREAKPOINT
		// Exiting the stepping state is handled by the moka debug target, in reaction to the suspend event.
		this.debugTarget.resume(this, DebugEvent.STEP_OVER) ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IStep#stepReturn()
	 */
	public void stepReturn() throws DebugException {
		// This thread enters stepping state
		this.isStepping = true ;
		// Resuming is delegated to the owning debug target, with appropriate RESUME event details
		// This will trigger a RESUME event for the target program.
		// Stepping state will be exit when the target program generates a suspend event corresponding to a STEP_END or BREAKPOINT
		// Exiting the stepping state is handled by the moka debug target, in reaction to the suspend event.
		this.debugTarget.resume(this, DebugEvent.STEP_RETURN) ;
	}

}
