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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.papyrus.moka.MokaConstants;
import org.eclipse.papyrus.moka.communication.Marshaller;
import org.eclipse.papyrus.moka.communication.event.Start_Event;
import org.eclipse.papyrus.moka.communication.event.isuspendresume.Resume_Event;
import org.eclipse.papyrus.moka.communication.event.isuspendresume.Suspend_Event;
import org.eclipse.papyrus.moka.communication.event.iterminate.Terminate_Event;
import org.eclipse.papyrus.moka.communication.request.RequestMessage;
import org.eclipse.papyrus.moka.communication.request.ibreakpointlistener.AddBreakpoint_Request;
import org.eclipse.papyrus.moka.communication.request.ibreakpointlistener.RemoveBreakpoint_Request;
import org.eclipse.papyrus.moka.communication.request.idisconnect.Disconnect_Request;
import org.eclipse.papyrus.moka.communication.request.istackframe.GetVariables_Request;
import org.eclipse.papyrus.moka.communication.request.isuspendresume.Resume_Request;
import org.eclipse.papyrus.moka.communication.request.isuspendresume.Suspend_Request;
import org.eclipse.papyrus.moka.communication.request.iterminate.Terminate_Request;
import org.eclipse.papyrus.moka.communication.request.ithread.GetStackFrames_Request;
import org.eclipse.papyrus.moka.communication.request.ivalue.GetValueString_Request;
import org.eclipse.papyrus.moka.communication.request.ivariable.GetReferenceTypeName_Request;
import org.eclipse.papyrus.moka.communication.request.ivariable.GetValue_Request;

/**
 * An implementation of IDebugTarget.
 * More specifically, it implements a communication protocol which complies with AbstractExecutionEngine.
 * Communication rely on sockets. The EventDispatchJob associated with this MokaDebugTarget listens to events 
 * emitted by the target program (i.e., through the eventSocket), and fires corresponding debug events to 
 * the Debug plugin.
 * The requestSocket is used to emit requests to the execution engine.
 * The replySocket is used to receive replies from the execution engine.
 *
 */
public class MokaDebugTarget extends MokaDebugElement implements IDebugTarget {

	/**
	 * The launch object containing this debug target
	 */
	protected ILaunch launch;

	// sockets to communicate with Execution engine
	protected Socket requestSocket;
	protected PrintWriter requestWriter;
	protected Socket replySocket;
	protected BufferedReader replyReader;
	protected Socket eventSocket;
	protected BufferedReader eventReader;

	// event dispatch job
	protected EventDispatchJob eventDispatchJob;

	protected boolean isStarted = false ;

	/**
	 * Constructs a new moka debug target in the given launch for the associated Execution Engine process.
	 * 
	 * @param launch containing launch
	 * @param process The execution engine process
	 * @param requestPort port to send requests to the process
	 * @param eventPort port to read events from
	 * @exception CoreException if unable to connect to host
	 */
	public MokaDebugTarget(ILaunch launch, IProcess process) throws CoreException {
		super(null);
		this.launch = launch;
		this.debugTarget = this;
		this.executionEngineProcess = process ;
		DebugPlugin.getDefault().getBreakpointManager().addBreakpointListener(this);
	}

	/**
	 * Connects this debug target to the execution engine, and starts the event dispatch job.
	 * 
	 * @param requestPort The port for the request socket
	 * @param replyPort The port for the reply socket
	 * @param eventPort The port for the event socket
	 * @throws DebugException
	 */
	public void connect(int requestPort, int replyPort, int eventPort) throws DebugException {
		try {
			this.requestSocket = new Socket("localhost", requestPort);
			this.requestWriter = new PrintWriter(this.requestSocket.getOutputStream());
			this.replySocket = new Socket("localhost", replyPort);
			this.replyReader = new BufferedReader(new InputStreamReader(this.replySocket.getInputStream()));
			this.eventSocket = new Socket("localhost", eventPort);
			this.eventReader = new BufferedReader(new InputStreamReader(this.eventSocket.getInputStream()));
		} catch (UnknownHostException e) {
			abort("Unable to connect to Execution Engine", e);
		} catch (IOException e) {
			abort("Unable to connect to Execution Engine", e);
		}
		this.eventDispatchJob = new EventDispatchJob();
		this.eventDispatchJob.schedule();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.debug.MokaDebugElement#getLaunch()
	 */
	public ILaunch getLaunch() {
		return this.launch ;
	}

	///////////////////////////////////////////
	// Implementation of interface IDebugTarget
	///////////////////////////////////////////

	/**
	 * The name of this debug target.
	 */
	protected String name = null ;

	/**
	 * The threads for this debug target. 
	 * This collection of threads is initialized with the first Start_Event received in the event dispatch loop
	 * This collection of threads is updated with reception of a Suspend_Event in the event dispatch loop
	 *  
	 */
	protected MokaThread[] threads = new MokaThread[]{} ;

	/** 
	 * The process associated with this debug target. Hosts the target program, i.e., the actual execution engine
	 */
	protected IProcess executionEngineProcess;

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDebugTarget#getProcess()
	 */
	public IProcess getProcess() {
		return this.executionEngineProcess;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDebugTarget#getThreads()
	 */
	public IThread[] getThreads() throws DebugException {
		return threads ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDebugTarget#hasThreads()
	 */
	public boolean hasThreads() throws DebugException {
		return this.isStarted && !this.isTerminated() && this.getThreads() != null && this.getThreads().length > 0 ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDebugTarget#getName()
	 */
	public String getName() throws DebugException {
		if (this.name != null) {
			return this.name ;
		}
		return "" ;
	}

	/**
	 * Convenience method for setting the new name for this MokaDebugTarget
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDebugTarget#supportsBreakpoint(org.eclipse.debug.core.model.IBreakpoint)
	 */
	public boolean supportsBreakpoint(IBreakpoint breakpoint) {
		// By default, a breakpoint is supported if it has MokaConstants.ID_MOKA_DEBUG_MODEL as a debug model identifier 
		if (breakpoint.getModelIdentifier().equals(MokaConstants.MOKA_DEBUG_MODEL_ID)) {			
			return true ;
		}
		return false;
	}

	//////////////////////////////////////////////////
	// Implementation of interface IBreakpointListener
	//////////////////////////////////////////////////

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.IBreakpointListener#breakpointAdded(org.eclipse.debug.core.model.IBreakpoint)
	 */
	public void breakpointAdded(IBreakpoint breakpoint) {
		if (this.supportsBreakpoint(breakpoint)) {
			try {
				if (breakpoint.isEnabled()) {
					try {
						// If the breakpoint is supported, this is a MokaBreakpoint
						MokaBreakpoint mokaBreakpoint = (MokaBreakpoint)breakpoint ;
						AddBreakpoint_Request request = new AddBreakpoint_Request(mokaBreakpoint) ;
						this.sendRequest(request) ;
						// Waits for an acknowledge from the execution engine
						@SuppressWarnings("unused")
						String ack = replyReader.readLine() ;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} catch (CoreException e) {
				e.printStackTrace() ;
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.IBreakpointListener#breakpointRemoved(org.eclipse.debug.core.model.IBreakpoint, org.eclipse.core.resources.IMarkerDelta)
	 */
	public void breakpointRemoved(IBreakpoint breakpoint, IMarkerDelta delta) {
		if (supportsBreakpoint(breakpoint)) {
			try {
				// If the breakpoint is supported, this is a MokaBreakpoint
				MokaBreakpoint mokaBreakpoint = (MokaBreakpoint)breakpoint ;
				RemoveBreakpoint_Request request = new RemoveBreakpoint_Request(mokaBreakpoint) ;
				this.sendRequest(request) ;
				// Waits for an acknowledge from the execution engine
				@SuppressWarnings("unused")
				String ack = replyReader.readLine() ;
			} catch (CoreException e) {
				e.printStackTrace() ;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.IBreakpointListener#breakpointChanged(org.eclipse.debug.core.model.IBreakpoint, org.eclipse.core.resources.IMarkerDelta)
	 */
	public void breakpointChanged(IBreakpoint breakpoint, IMarkerDelta delta) {
		if (this.supportsBreakpoint(breakpoint)) {
			try {
				if (breakpoint.isEnabled() && DebugPlugin.getDefault().getBreakpointManager().isEnabled()) {
					this.breakpointAdded(breakpoint);
				} else {
					this.breakpointRemoved(breakpoint, delta);
				}
			} catch (CoreException e) {
				e.printStackTrace() ;
			}
		}
	}

	//////////////////////////////////////////
	// Implementation of interface IDisconnect
	//////////////////////////////////////////

	/**
	 * Determines whether the target program is disconnected or not from this debug target.
	 */
	protected boolean isDisconnected = false ;

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDisconnect#canDisconnect()
	 */
	public boolean canDisconnect() {
		// In this default implementation, disconnection can never occur. This can be overloaded by clients.
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDisconnect#disconnect()
	 */
	public void disconnect() throws DebugException {
		try {
			Disconnect_Request request = new Disconnect_Request() ;
			this.sendRequest(request) ;
			// Waits for an acknowledge from the execution engine
			@SuppressWarnings("unused")
			String ack = replyReader.readLine() ;
			this.isDisconnected = true ;
		} catch (CoreException e) {
			e.printStackTrace() ;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IDisconnect#isDisconnected()
	 */
	public boolean isDisconnected() {
		return this.isDisconnected ;
	}

	////////////////////////////////////////////////////
	// Implementation of interface IMemoryBlockRetrieval
	////////////////////////////////////////////////////

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockRetrieval#supportsStorageRetrieval()
	 */
	public boolean supportsStorageRetrieval() {
		// By default, this default implementation does not support memory block retrieval. This can be overloaded by clients
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IMemoryBlockRetrieval#getMemoryBlock(long, long)
	 */
	public IMemoryBlock getMemoryBlock(long startAddress, long length) throws DebugException {
		return null ;
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
		// The debug target can be resumed if it is currently suspended
		return this.isSuspended ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ISuspendResume#canSuspend()
	 */
	public boolean canSuspend() {
		// The debug target can be suspended if it is not already suspended and if it is not terminated
		return this.launch.getLaunchMode().equals(ILaunchManager.DEBUG_MODE) && !this.isSuspended && !this.isTerminated() ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ISuspendResume#isSuspended()
	 */
	public boolean isSuspended() {
		return this.isSuspended;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ISuspendResume#resume()
	 */
	public void resume() throws DebugException {
		// A call to resume() has no effect on an element that is not suspended.
		//		if (this.isSuspended)
		this.resume(this, DebugEvent.CLIENT_REQUEST) ;
	}

	/**
	 * Handles occurrence of a resume event. The event is represented by the String message, and has been emitted by the target program.
	 * This method is called by the event dispatch job. 
	 * 
	 * @param message The String representation of the event
	 */
	protected void handle_Resume_Event(String message) {
		Resume_Event event = Marshaller.getInstance().resume_event_unmarshal(message) ;
		this.isSuspended = false ;
		this.fireEvent(event.getDebugEvent()) ;
	}

	/**
	 * Sends a request to the target program for resuming the given debugElement (which can be an IDebugTarget or an IThread) for the reason hold by resumeDetail.
	 * resumeDetail can be one of the following values: 
	 * - DebugEvent.CLIENT_REQUEST: Execution is resumed due to a resume client request
	 * - DebugEvent.STEP_INTO: Execution is resumed due to a step into client request 
	 * - DebugEvent.STEP_OVER: Execution is resumed due to a step over client request
	 * - DebugEvent.STEP_RETURN: Execution is resumed due to a step return client request
	 * In reply to this request, the target program will emit a Resume_Event. 
	 * This Resume_Event is handled by the event dispatch job, so that the appropriate RESUME DebugEvent is emitted to the DebugPlugin.
	 * 
	 * @param debugElement The debug element being resumed
	 * @param resumeDetail Details about the reason for resuming
	 */
	public void resume(IDebugElement debugElement, int resumeDetail) throws DebugException{
		Resume_Request request = new Resume_Request(debugElement, resumeDetail) ;
		try {
			this.sendRequest(request) ;
		} catch (DebugException e) {
			this.abort("Failed to resume execution of the given debug element", e) ;
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ISuspendResume#suspend()
	 */
	public void suspend() throws DebugException {
		// A call to suspend() has no effect on an element that is already suspended.
		if (!this.isSuspended)
			this.suspend(this, DebugEvent.CLIENT_REQUEST) ;
	}

	/**
	 * Sends a request to the target program for suspending the given debugElement (which can be an IDebugTarget or an IThread) for the reason hold by suspendDetail.
	 * resumeDetail can be one of the following values: 
	 * - DebugEvent.CLIENT_REQUEST: Execution was suspended due to a suspend client request
	 * - DebugEvent.STEP_END: Execution was suspended due to the completion of a step action
	 * - DebugEvent.BREAKPOINT: Execution was suspended due to a breakpoint
	 * In reply to this request, the target program will emit a Suspend_Event. 
	 * This Suspend_Event is handled by the event dispatch job, so that the appropriate SUSPEND DebugEvent is emitted to the DebugPlugin.
	 * 
	 * @param debugElement The debug element being resumed
	 * @param suspendDetail Details about the reason for resuming
	 */
	public void suspend(IDebugElement debugElement, int suspendDetail) throws DebugException {
		Suspend_Request request = new Suspend_Request(debugElement, suspendDetail) ;
		try {
			this.sendRequest(request) ;
		} catch (DebugException e) {
			this.abort("Failed to suspend execution of the given debug element", e) ;
		}
	}

	/**
	 * Handles occurrence of a suspend event. The event is represented by the String message, and has been emitted by the target program.
	 * This method is called by the event dispatch job. 
	 * 
	 * @param message The String representation of the event
	 */
	protected void handle_Suspend_Event(String message) {
		Suspend_Event event = Marshaller.getInstance().suspend_event_unmarshal(message) ;
		this.isSuspended = true ;
		this.threads = event.getThreads() ;
		int suspendEventDetail = event.getDebugEvent().getDetail() ;
		// In the case where the suspend event occured due to a step end, the corresponding IThread must be explicitly stated that it is not stepping anymore.
		// @see MokaThrea.stepEnded()
		if (suspendEventDetail == DebugEvent.STEP_END || suspendEventDetail == DebugEvent.BREAKPOINT) {
			// By construction, the source element associated with this debug event is a MokaThread
			MokaThread thread = (MokaThread)event.getDebugEvent().getSource() ;
			thread.stepEnded() ;
		}
		this.fireEvent(event.getDebugEvent()) ;
	}

	///////////////////////////////
	// Implementation of ITerminate
	///////////////////////////////

	/**
	 *  Determines whether this element is terminated
	 */
	protected boolean isTerminated = false;

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ITerminate#canTerminate()
	 */
	public boolean canTerminate() {
		// An element can terminate if it is not already terminated
		return ! this.isTerminated ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ITerminate#isTerminated()
	 */
	public boolean isTerminated() {
		return this.isTerminated ;
	}

	/**
	 * Terminates execution by firing a terminate event for the debug plugin
	 */
	protected void terminated() {
		this.isTerminated = true;
		this.isSuspended = false ;
		DebugPlugin.getDefault().getBreakpointManager().removeBreakpointListener(this) ;
		this.fireEvent(new Terminate_Event(this).getDebugEvent()) ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ITerminate#terminate()
	 */
	public void terminate() throws DebugException {
		this.terminate(this) ;
	}

	/**
	 * Sends a request to the target program for terminating the given debugElement (which can be an IDebugTarget or an IThread).
	 * In reply to this request, the target program will emit a Terminate_Event. 
	 * This Terminate_Event is handled by the event dispatch job, so that the appropriate TERMINATE DebugEvent is emitted to the DebugPlugin.
	 * 
	 * @param debugElement The debug element being terminated
	 */
	public void terminate(IDebugElement debugElement) throws DebugException {
		Terminate_Request request = new Terminate_Request(debugElement) ;
		try {
			this.sendRequest(request) ;
		} catch (DebugException e) {
			this.abort("Failed to terminate execution of the given debug element", e) ;
		}
	}

	/**
	 * Handles occurrence of a terminate event, emitted by the target program.
	 * This method is called by the event dispatch job. 
	 * 
	 */
	protected void handle_Terminate_Event() {
		this.isTerminated = true ;
	}

	/**
	 * Listens to events from the Execution engine and fires corresponding debug events to the debug plugin
	 */
	class EventDispatchJob extends Job {

		public EventDispatchJob() {
			super("Moka Event Dispatch");
			setSystem(true);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.IProgressMonitor)
		 */
		protected IStatus run(IProgressMonitor monitor) {
			String event = "";

			while (!isTerminated() && event != null) {
				try {
					event = eventReader.readLine();
					if (event != null) {
						isSuspended = false ;
						if (event.startsWith(MokaConstants.event_start)) {
							handle_Start_Event(event);
						}
						else if (event.startsWith(MokaConstants.event_resume)) {
							handle_Resume_Event(event);
						}
						else if (event.startsWith(MokaConstants.event_suspend)) {
							handle_Suspend_Event(event);
						}
						else if (event.startsWith(MokaConstants.event_terminate)) {
							handle_Terminate_Event() ;
						}
					}
				} catch (IOException e) {
					terminated();
				}
			}
			terminated() ;
			return Status.OK_STATUS;
		}
	}

	//////////////////////
	// Convenience methods
	//////////////////////

	/**
	 * Handles occurrence of a start event, which means that the target program is ready to receive requests.
	 * This method is called by the event dispatch job. 
	 * 
	 */
	protected void handle_Start_Event(String message) {
		Start_Event event = Marshaller.getInstance().start_event_unmarshal(message) ;
		this.threads = event.getThreads() ;
		this.fireEvent(event.getDebugEvent());
		// Installs deferred breakpoints only if the breakpoint manager is enabled
		//if (DebugPlugin.getDefault().getBreakpointManager().isEnabled())
		this.installDeferredBreakpoints();
		try {
			resume();
			this.isStarted = true ;
		} catch (DebugException e) {
			e.printStackTrace() ;
		}
	}

	/**
	 * Install breakpoints that are already registered with the breakpoint manager
	 */
	protected void installDeferredBreakpoints() {
		IBreakpoint[] breakpoints = DebugPlugin.getDefault().getBreakpointManager().getBreakpoints(MokaConstants.MOKA_DEBUG_MODEL_ID) ;
		for (int i = 0; i < breakpoints.length; i++) {
			this.breakpointAdded(breakpoints[i]);
		}
	}

	/**
	 * Convenience methods for marshaling and sending a request to the target program, through the request socket
	 * 
	 * @param request The Request object to be marshaled and sent to the target program
	 * @throws DebugException
	 */
	protected void sendRequest(RequestMessage request) throws DebugException {
		synchronized (requestSocket) {
			requestWriter.println(request.marshall());
			requestWriter.flush();
		}
	}

	/**
	 * Emits a request to the target program to retrieve stack frames associated with a thread.
	 * The returned array is empty (but not null) if no stack frames are available, or if the thread is not suspended.
	 * This method is provided as a convenience for MokaThread, so that all requests (respectively replies) are emitted (respectively received) from (by) the debug target 
	 * 
	 * @param thread The thread for which stack frames have to be retrieved
	 * @return The (possibly empty) collection of stack frames associated with the given thread
	 * @throws DebugException
	 */
	public IStackFrame[] getStackFrames(IThread thread) throws DebugException {
		IStackFrame[] stackFrames = new IStackFrame[]{} ; 
		if (!thread.isSuspended())
			return stackFrames ;
		this.sendRequest(new GetStackFrames_Request(thread)) ;
		try {
			String reply = replyReader.readLine() ;
			stackFrames = Marshaller.getInstance().getStackFrames_reply_unmarshal(reply).getStackFrames() ;
		} catch (IOException e) {
			this.abort("Failed to retrieve stack frames", e) ;
		}
		return stackFrames ;
	}

	/**
	 * Emits a request to the target program to retrieve variables associated with a stack frame or value.
	 * The returned array is empty (but not null) if no variables are visible.
	 * This method is provided as a convenience for MokaStackFrame and MokaValue, so that all requests (respectively replies) are emitted (respectively received) from (by) the debug target
	 * stackFrameOrValue must be an IStackFrame or an IValue 
	 * 
	 * @param stackFrameOrValue The stack frame or value for which variables have to be retrieved
	 * @return The (possibly empty) collection of variables associated with this stack frame or value
	 * @throws DebugException
	 */
	public MokaVariable[] getVariables(IDebugElement stackFrameOrValue) throws DebugException {
		MokaVariable[] variables = new MokaVariable[]{} ; 
		this.sendRequest(new GetVariables_Request(stackFrameOrValue)) ;
		try {
			String reply = replyReader.readLine() ;
			variables = Marshaller.getInstance().getVariables_reply_unmarshal(reply).getVariables() ;
		} catch (IOException e) {
			this.abort("Failed to retrieve variables", e) ;
		}
		return variables ;
	}

	/**
	 * Not supported by this default implementation 
	 * 
	 * @param stackFrame The stack frame for which register groups have to be retrieved
	 * @return The (possibly empty) collection of register groups associated with this stack frame
	 * @throws DebugException
	 */
	public IRegisterGroup[] getRegisterGroups(IStackFrame stackFrame) throws DebugException {
		return new IRegisterGroup[]{} ;
	}

	/**
	 * Emits a request to the target program to retrieve the value associated with a variable.
	 * The returned value may be null.
	 * This method is provided as a convenience for MokaVariable, so that all requests (respectively replies) are emitted (respectively received) from (by) the debug target 
	 * 
	 * @param variable The variable for which value has to be retrieved
	 * @return The value of this variable, if any
	 * @throws DebugException
	 */
	public MokaValue getValue(MokaVariable variable) throws DebugException {
		MokaValue value = null ; 
		this.sendRequest(new GetValue_Request(variable)) ;
		try {
			String reply = replyReader.readLine() ;
			value = Marshaller.getInstance().getValue_reply_unmarshal(reply).getValue() ;
		} catch (IOException e) {
			this.abort("Failed to retrieve variable value", e) ;
		}
		return value ;
	}

	/**
	 * Emits a request to the target program to retrieve the reference type name of a variable or value.
	 * The returned value may be null.
	 * This method is provided as a convenience for MokaVariable, so that all requests (respectively replies) are emitted (respectively received) from (by) the debug target 
	 * 
	 * @param debugElement The variable or value for which the reference type name has to be retrieved
	 * @return The reference type name of this variable or value, if any
	 * @throws DebugException
	 */
	public String getReferenceTypeName(IDebugElement debugElement) throws DebugException {
		String referenceTypeName = null ; 
		this.sendRequest(new GetReferenceTypeName_Request(debugElement)) ;
		try {
			String reply = replyReader.readLine() ;
			referenceTypeName = Marshaller.getInstance().getReferenceTypeName_reply_unmarshal(reply).getReferenceTypeName() ;
		} catch (IOException e) {
			this.abort("Failed to retrieve variable value", e) ;
		}
		return referenceTypeName ;
	}

	/**
	 * Emits a request to the target program to retrieve the string representation of a value.
	 * The returned value may be null.
	 * This method is provided as a convenience for MokaVariable, so that all requests (respectively replies) are emitted (respectively received) from (by) the debug target 
	 * 
	 * @param value The value for which the string representation has to be retrieved
	 * @return The string representation of this value
	 * @throws DebugException
	 */
	public String getValueString(IValue value) throws DebugException {
		String textualRepresentation = null ; 
		this.sendRequest(new GetValueString_Request(value)) ;
		try {
			String reply = replyReader.readLine() ;
			textualRepresentation = Marshaller.getInstance().getValueString_reply_unmarshal(reply).getValueString() ;
		} catch (IOException e) {
			this.abort("Failed to retrieve textual representation of value", e) ;
		}
		return textualRepresentation ;
	}
}
