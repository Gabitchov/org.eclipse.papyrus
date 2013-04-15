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
package org.eclipse.papyrus.moka.engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.MokaConstants;
import org.eclipse.papyrus.moka.communication.Marshaller;
import org.eclipse.papyrus.moka.communication.event.EventMessage;
import org.eclipse.papyrus.moka.communication.event.Start_Event;
import org.eclipse.papyrus.moka.communication.event.isuspendresume.Resume_Event;
import org.eclipse.papyrus.moka.communication.event.isuspendresume.Suspend_Event;
import org.eclipse.papyrus.moka.communication.event.iterminate.Terminate_Event;
import org.eclipse.papyrus.moka.communication.reply.Ack;
import org.eclipse.papyrus.moka.communication.reply.ReplyMessage;
import org.eclipse.papyrus.moka.communication.reply.istackframe.GetVariables_Reply;
import org.eclipse.papyrus.moka.communication.reply.ithread.GetStackFrames_Reply;
import org.eclipse.papyrus.moka.communication.reply.ivalue.GetValueString_Reply;
import org.eclipse.papyrus.moka.communication.reply.ivariable.GetReferenceTypeName_Reply;
import org.eclipse.papyrus.moka.communication.reply.ivariable.GetValue_Reply;
import org.eclipse.papyrus.moka.communication.request.ibreakpointlistener.AddBreakpoint_Request;
import org.eclipse.papyrus.moka.communication.request.ibreakpointlistener.RemoveBreakpoint_Request;
import org.eclipse.papyrus.moka.communication.request.istackframe.GetVariables_Request;
import org.eclipse.papyrus.moka.communication.request.isuspendresume.Resume_Request;
import org.eclipse.papyrus.moka.communication.request.isuspendresume.Suspend_Request;
import org.eclipse.papyrus.moka.communication.request.iterminate.Terminate_Request;
import org.eclipse.papyrus.moka.communication.request.ithread.GetStackFrames_Request;
import org.eclipse.papyrus.moka.communication.request.ivalue.GetValueString_Request;
import org.eclipse.papyrus.moka.communication.request.ivariable.GetReferenceTypeName_Request;
import org.eclipse.papyrus.moka.communication.request.ivariable.GetValue_Request;
import org.eclipse.papyrus.moka.debug.MokaBreakpoint;
import org.eclipse.papyrus.moka.debug.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.MokaValue;
import org.eclipse.papyrus.moka.debug.MokaVariable;

/**
 * An abstract implementation of IExecutionEngine, consistent with the communication 
 * protocol implemented by MokaDebugTarget.
 * This implementation encapsulates a request dispatch loop. This abstract class can 
 * be extended and used with the generic implementation of the Eclipse Debug Model 
 * provided by Moka. The proposed debug model is included in package debug. 
 * In particular, it includes class MokaDebugTarget, an implementation of IDebugTarget 
 * which encapsulates an event dispatch loop.
 *
 */
public abstract class AbstractExecutionEngine implements IExecutionEngine {

	/**
	 * The eObject being executed by this execution engine
	 */
	protected EObject eObjectToExecute ;

	/**
	 * The mode in which this execution is running. Values can be ILaunchManager.DEBUG_MODE or ILaunchManager.RUN_MODE
	 */
	protected String mode = ILaunchManager.RUN_MODE ;

	/**
	 * The debug target associated with this execution engine
	 */
	protected MokaDebugTarget debugTarget ;

	/**
	 * The server socket used to accept connection from the requestSocket (connection is done in Moka debug target) 
	 */
	protected ServerSocket requestServer ;
	
	/**
	 * The server socket used to accept connection from the replySocket (connection is done in Moka debug target) 
	 */
	protected ServerSocket replyServer ;
	
	/**
	 * The socket used to reply to request emitted by the debug target
	 */
	protected Socket replySocket;

	/**
	 * The server socket used to accept connection from the eventSocket (connection is done in Moka debug target) 
	 */
	protected ServerSocket eventServer ;

	/**
	 * The socket used to receive request from the debug target
	 */
	protected Socket requestSocket;

	/**
	 * Writer for the request socket
	 */
	protected PrintWriter replyWriter;

	/**
	 * Reader for the request socket
	 */
	protected BufferedReader requestReader;

	/**
	 *  This socket is used to raise events for the debug target
	 */
	protected Socket eventSocket;

	/**
	 * Writer for the event socket
	 */
	protected PrintWriter eventWriter ;

	/**
	 * Determines if the execution is terminated
	 */
	protected boolean isTerminated = false ;

	/**
	 * Inits the execution engine in Run mode
	 */
	public void initRun(EObject eObjectToExecute, String[] args) {
		this.eObjectToExecute = eObjectToExecute ;
		this.initializeArguments(args) ;
	}

	/**
	 * Inits the execution engine in Debug mode.
	 * This includes the creation of server sockets, to enable connection of sockets in the moka debug target. 
	 * 
	 */
	public void initDebug(EObject eObjectToExecute, String[] args, MokaDebugTarget debugTarget, int requestPort, int replyPort, int eventPort) throws UnknownHostException, IOException {
		this.debugTarget = debugTarget ;
		this.requestServer = new ServerSocket(requestPort) ;
		this.replyServer = new ServerSocket(replyPort) ;
		this.eventServer = new ServerSocket(eventPort) ;
		this.mode = ILaunchManager.DEBUG_MODE ;
		this.initRun(eObjectToExecute, args) ;
	}

	/**
	 * Returns the debug target associated with this execution engine
	 * 
	 * @return the debug target associated with this execution engine
	 */
	public MokaDebugTarget getDebugTarget() {
		return this.debugTarget ;
	}
	
	
	/**
	 * Returns true if the execution is terminated, false otherwise
	 * 
	 * @return true if the execution is terminated, false otherwise
	 */
	public boolean isTerminated() {
		return this.isTerminated ;
	}
	
	/**
	 * Initializes the execution engine with given arguments
	 */
	public abstract void initializeArguments(String[] args) ;

	/** 
	 * Starts the execution and the request dispatch loop. 
	 */
	public void start() throws IOException {
		if (eObjectToExecute != null) {
			if (this.mode.equals(ILaunchManager.DEBUG_MODE)) {
				String request = "";
				// First accepts connection of the request socket (from the moka debug target) and initializes reader/writer 
				requestSocket = requestServer.accept() ;
				requestReader = new BufferedReader(new InputStreamReader(requestSocket.getInputStream()));
				// Then accepts connection of the reply socket
				replySocket = replyServer.accept() ;
				replyWriter = new PrintWriter(replySocket.getOutputStream());
				// Then accepts connection of the event socket
				eventSocket = eventServer.accept() ;
				eventWriter = new PrintWriter(eventSocket.getOutputStream()) ;
				// Communication protocol starts by notifying the moka debug target that execution has started
				this.sendEvent(new Start_Event(this.debugTarget, this.getThreads())) ;
				while (!this.isTerminated && request != null) {
					try {
						request = requestReader.readLine();
						if (request != null) {
							if (request.startsWith(MokaConstants.request_addBreakpoint)) {
								// Add breakpoint request
								this.addBreakpoint_reply(request);
							}
							else if (request.startsWith(MokaConstants.request_removeBreakpoint)) {
								// Remove breakpoint request
								this.removeBreakpoint_reply(request) ;
							}
							else if (request.startsWith(MokaConstants.request_disconnect)) {
								// Disconnection requested
								this.disconnect_reply() ;
							}
							else if (request.startsWith(MokaConstants.request_resume)) {
								// Resume requested
								this.resume_reply(request) ;
							}
							else if (request.startsWith(MokaConstants.request_suspend)) {
								// Suspend requested
								this.suspend_reply(request) ;
							}
							else if (request.startsWith(MokaConstants.request_terminate)) {
								// Terminate requested
								this.terminate_reply(request) ;
							}
							else if (request.startsWith(MokaConstants.request_getStackFrames)) {
								// Stack frames requested
								this.getStackFrames_reply(request) ;
							}
							else if (request.startsWith(MokaConstants.request_getVariables)) {
								// Variables requested
								this.getVariables_reply(request) ;
							}
							else if (request.startsWith(MokaConstants.request_getValue)) {
								// Variable value requested
								this.getValue_reply(request) ;
							}
							else if (request.startsWith(MokaConstants.request_getReferenceTypeName)) {
								// Reference type name of a variable requested
								this.getReferenceTypeName_reply(request) ;
							}
							else if (request.startsWith(MokaConstants.request_getValueString)) {
								// String representation of a value requested
								this.getValueString_reply(request) ;
							}
						}
					} catch (IOException e) {
						this.isTerminated = true ;
					}
				}
				// Communication protocol ends by notifying the moka debug target that execution has terminated
				this.sendEvent(new Terminate_Event(this.debugTarget)) ;
			}
			else {
				// In Run mode, simply resumes the execution once.
				this.resume() ;
			}
		}
	}

	// **************************************
	// Management of a addBreakpoint request emitted from the debug target.
	// @see IBreakpointListener.breakpointAdded() and IBreakpointListener.breakpointChanged() 
	// ***************************************
	/**
	 * Manages reply to an addBreakpoint request emitted from the debug target
	 */
	protected void addBreakpoint_reply(String request) {
		AddBreakpoint_Request breakpointRequest = Marshaller.getInstance().addBreakpoint_request_unmarshal(request) ;
		this.addBreakpoint(breakpointRequest.getBreakpoint()) ;
		Ack reply = new Ack() ;
		this.reply(reply) ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.engine.IExecutionEngine#addBreakpoint()
	 */
	public abstract void addBreakpoint(MokaBreakpoint breakpoint) ;

	// **************************************
	// Management of a removeBreakpoint request emitted from the debug target.
	// @see IBreakpointListener.breakpointRemoved() and IBreakpointListener.breakpointChanged() 
	// ***************************************
	/**
	 * Manages reply to an addBreakpoint request emitted from the debug target
	 */
	protected void removeBreakpoint_reply(String request) {
		RemoveBreakpoint_Request breakpointRequest = Marshaller.getInstance().removeBreakpoint_request_unmarshal(request) ;
		this.removeBreakpoint(breakpointRequest.getBreakpoint()) ;
		Ack reply = new Ack() ;
		this.reply(reply) ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.engine.IExecutionEngine#removeBreakpoint()
	 */
	public abstract void removeBreakpoint(MokaBreakpoint breakpoint) ;

	// **************************************
	// Management of a disconnect request emitted from the debug target.
	// @see IDisconnect.disconnect() 
	// ***************************************
	/**
	 * Manages reply to an addBreakpoint request emitted from the debug target
	 */
	protected void disconnect_reply() {
		this.disconnect() ;
		Ack reply = new Ack() ;
		this.reply(reply) ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.engine.IExecutionEngine#removeBreakpoint()
	 */
	public abstract void disconnect() ;

	// **************************************
	// Management of a getMemoryBlock() request emitted from the debug target.
	// @see IMemoryBlockRetrieval.getMemoryBlock() 
	// ***************************************

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.engine.IExecutionEngine#removeBreakpoint()
	 */
	public IMemoryBlock getMemoryBlock(long startAddress, long length) {
		// Not supported
		return null ;
	}

	// **************************************
	// Management of a resume() request emitted from the debug target.
	// @see ISuspendResume.resume() 
	// ***************************************
	/**
	 * Manages reply to a resume() request emitted from the debug target
	 */
	protected void resume_reply(String message) {
		Resume_Request request = Marshaller.getInstance().resume_request_unmarshal(message) ;
		Resume_Event event = new Resume_Event(request.getDebugElement(), request.getResumeDetail()) ;
		this.sendEvent(event) ;
		this.resume(request) ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.engine.IExecutionEngine#resume(Resume_Request request)
	 */
	public abstract void resume(Resume_Request request) ;
	
	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.engine.IExecutionEngine#resume()
	 */
	public abstract void resume() ;

	// **************************************
	// Management of a suspend() request emitted from the debug target.
	// @see ISuspendResume.suspend() 
	// ***************************************
	/**
	 * Manages reply to a suspend() request emitted from the debug target
	 */
	protected void suspend_reply(String message) {
		Suspend_Request request = Marshaller.getInstance().suspend_request_unmarshal(message) ;
		this.suspend(request) ;
		Suspend_Event event = new Suspend_Event(request.getDebugElement(), request.getSuspendDetail(), this.getThreads()) ;
		this.sendEvent(event) ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.engine.IExecutionEngine#suspend(Suspend_Request request)
	 */
	public abstract void suspend(Suspend_Request request) ;

	// **************************************
	// Management of a suspend() request emitted from the debug target.
	// @see ISuspendResume.suspend() 
	// ***************************************
	/**
	 * Manages reply to a suspend() request emitted from the debug target
	 */
	protected void terminate_reply(String message) {
		Terminate_Request request = Marshaller.getInstance().terminate_request_unmarshal(message) ;
		this.terminate(request) ;
	}

	/**
	 * Implementation of this operation should at least do the following: this.isTerminated = true ;
	 * Note that implementation should not fire a Terminate_Event, since this is managed at the exit of the request dispatch loop implemented by start()
	 * 
	 *  (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.engine.IExecutionEngine#terminate(org.eclipse.papyrus.moka.communication.request.iterminate.Terminate_Request)
	 */
	public abstract void terminate(Terminate_Request request) ;
	
	// **************************************
	// Management of a getStackFrames() request emitted from the debug target.
	// @see IThread.getStackFrames() 
	// ***************************************
	/**
	 * Manages reply to a getStackFrames() request emitted from the debug target
	 */
	protected void getStackFrames_reply(String message) {
		GetStackFrames_Request request = Marshaller.getInstance().getStackFrames_request_unmarshal(message) ;
		GetStackFrames_Reply reply = new GetStackFrames_Reply(this.getStackFrames(request.getThread())) ;
		this.reply(reply) ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.engine.IExecutionEngine#getStackFrames(IThread thread)
	 */
	public abstract IStackFrame[] getStackFrames(IThread thread) ;

	// **************************************
	// Management of a getVariables() request emitted from the debug target.
	// @see IStackFrame.getVariables() 
	// ***************************************
	/**
	 * Manages reply to a getStackFrames() request emitted from the debug target
	 */
	protected void getVariables_reply(String message) {
		GetVariables_Request request = Marshaller.getInstance().getVariables_request_unmarshal(message) ;
		GetVariables_Reply reply = new GetVariables_Reply((MokaVariable[])this.getVariables(request.getStackFrameOrValue())) ;
		this.reply(reply) ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.engine.IExecutionEngine#getVariables(IStackFrame stackFrame)
	 */
	public IVariable[] getVariables(IDebugElement stackFrameOrValue) {
		// By default, returns an empty array of variables
		return new IVariable[]{} ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.engine.IExecutionEngine#getRegisterGroups(IStackFrame stackFrame)
	 */
	public IRegisterGroup[] getRegisterGroups(IStackFrame stackFrame) {
		// Not supported
		return new IRegisterGroup[]{} ;
	}

	// **************************************
	// Management of a getRegisterGroups() request emitted from the debug target.
	// @see IVariable.getValue() 
	// ***************************************
	/**
	 * Manages reply to a getRegisterGroups() request emitted from the debug target
	 */
	protected void getValue_reply(String message) {
		GetValue_Request request = Marshaller.getInstance().getValue_request_unmarshal(message) ;
		GetValue_Reply reply = new GetValue_Reply((MokaValue)this.getValue(request.getVariable())) ;
		this.reply(reply) ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.engine.IExecutionEngine#getValue(IVariable variable)
	 */
	public IValue getValue(IVariable variable) {
		// The default implementation returns null
		// It makes the hypothesis that when the debug target
		// asks for variables, the IVariables which are returned
		// embed corresponding values.
		// It means that, by default, this method is never called.
		return null ;
	}

	// **************************************
	// Management of a getRegisterGroups() request emitted from the debug target.
	// @see IVariable.getReferenceTypeName() 
	// ***************************************
	/**
	 * Manages reply to a getRegisterGroups() request emitted from the debug target
	 */
	protected void getReferenceTypeName_reply(String message) {
		GetReferenceTypeName_Request request = Marshaller.getInstance().getReferenceTypeName_request_unmarshal(message) ;
		GetReferenceTypeName_Reply reply = new GetReferenceTypeName_Reply(this.getReferenceTypeName(request.getVariableOrValue())) ;
		this.reply(reply) ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.engine.IExecutionEngine#getReferenceTypeName(IDebugElement debugElement)
	 */
	public String getReferenceTypeName(IDebugElement debugElement) {
		// By default, returns an empty string
		return "" ;
	}

	// **************************************
	// Management of a getValueString() request emitted from the debug target.
	// @see IValue.getValueString() 
	// ***************************************
	/**
	 * Manages reply to a getRegisterGroups() request emitted from the debug target
	 */
	protected void getValueString_reply(String message) {
		GetValueString_Request request = Marshaller.getInstance().getValueString_request_unmarshal(message) ;
		GetValueString_Reply reply = new GetValueString_Reply(this.getValueString(request.getValue())) ;
		this.reply(reply) ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.engine.IExecutionEngine#getValueString(IValue value)
	 */
	public String getValueString(IValue value) {
		// By default, returns an empty string
		return "" ;
	}

	/**
	 * Convenience method for marshalling a Reply, and writing it on the replySocket so that it can be accessed by the debug target
	 * 
	 * @param reply The Reply object to be marshalled and written on the replySocket
	 */
	protected void reply(ReplyMessage reply) {
		synchronized (replySocket) {
			replyWriter.println(reply.marshal());
			replyWriter.flush();
		}
	}

	/**
	 * Convenience method for marshalling an Event, and writing it on the eventSocket so that it can be accessed by the debug target
	 * 
	 * @param reply The Event object to be marshalled and written on the eventSocket
	 */
	public void sendEvent(EventMessage event) {
		synchronized (eventSocket) {
			eventWriter.println(event.marshal());
			eventWriter.flush();
		}
	}
}
