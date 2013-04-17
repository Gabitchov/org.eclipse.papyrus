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

import java.io.IOException;
import java.net.UnknownHostException;

import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.communication.request.isuspendresume.Resume_Request;
import org.eclipse.papyrus.moka.communication.request.isuspendresume.Suspend_Request;
import org.eclipse.papyrus.moka.communication.request.iterminate.Terminate_Request;
import org.eclipse.papyrus.moka.debug.MokaBreakpoint;
import org.eclipse.papyrus.moka.debug.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.MokaThread;

/**
 * The interface underlying the ExecutionEngine extension point provided by Moka.
 *
 */
public interface IExecutionEngine {
	
	/**
	 * Initializes the engine.
	 * This requires to know the debugTarget which will communicate with this execution engine.
	 * Since the debugTarget and the execution engine must run asynchronously, they communicate through sockets.
	 * requestPort indicates the address of the socket through which requests emitted from the debug target flow.
	 * replyPort indicates the address of the socket through which replies emitted from the execution engine flow.
	 * eventPort indicates the address of the socket through which messages corresponding to debug events occurring in the execution engine flow.
	 * 
	 * @param eObjectToExecute The object to be executed by the engine
	 * @param args Optional arguments for the execution of the object
	 * @param debugTarget the debugTarget communicating with this execution engine
	 * @param requestPort the address of the socket through which requests emitted from the debug target flow.
	 * @param replyPort the address of the socket through which replies (emitted from the execution engine) flow.
	 * @param eventPort indicates the address of the socket through which messages corresponding to debug events occurring in the execution engine flow.
	 * @throws UnknownHostException when problems occur while establishing connection with the sockets
	 * @throws IOException when problems occur while reading/writing on sockets
	 */
	public void init(EObject eObjectToExecute, String[] args, MokaDebugTarget debugTarget, int requestPort, int replyPort, int eventPort) throws UnknownHostException, IOException ;
	
	/**
	 * Initialization of the execution engine with given arguments. This is supposed to be called in the implementation of initRun and/or initDebug methods
	 * 
	 * @param args The arguments for the initialization of the execution engine, before starting execution
	 */
	public void initializeArguments(String[] args) ;
	
	/**
	 * Starts the execution. This is supposed to be called after initialization phases.
	 * 
	 * @throws IOException
	 */
	public void start() throws IOException ;
	
	/**
	 * Returns the collection of MokaThread for this execution engine. If no threads are defined, the returned collection is empty, but not null.
	 * 
	 * @return the collection of MokaThread for this execution engine
	 */
	public MokaThread[] getThreads() ;
	
	/**
	 * Registers the given breakpoint in the execution engine
	 * 
	 * @param breakpoint the breakpoint to be registered
	 */
	public void addBreakpoint(MokaBreakpoint breakpoint) ;
	
	/**
	 * Unregister the given breakpoint in the execution engine
	 * 
	 * @param breakpoint the breakpoint to be unregistered
	 */
	public void removeBreakpoint(MokaBreakpoint breakpoint) ;
	
	/**
	 * Disconnects this execution engine from the associated debug target.
	 */
	public void disconnect() ;
	
	/**
	 * Gets the memory block at the given startAddress, for the given length
	 * 
	 * @param startAddress The startAddress for the memory block
	 * @param length The length of the memory block
	 * @return the memory block corresponding to the given startAddress and length
	 */
	public IMemoryBlock getMemoryBlock(long startAddress, long length) ;
	
	/**
	 * Resumes execution according to the given Resume_Request
	 * 
	 * @param request The Resume_Request indicating how execution has to be resumed
	 */
	public void resume(Resume_Request request) ;
	
	/**
	 * Suspends execution according to the given Suspend_Request
	 * 
	 * @param request The Suspend_Request indicating how execution has to be suspended
	 */
	public void suspend(Suspend_Request request) ;
	
	/**
	 * Terminates execution according to the given Terminate_Request
	 * 
	 * @param request The Terminate_Request indicating how execution has to be terminated
	 */
	public void terminate(Terminate_Request request) ;
	
	/**
	 * Returns the stack frames of the given thread
	 * 
	 * @param thread The thread for which stack frames have to be retrieved
	 * @return The stack frames of the given thread
	 */
	public IStackFrame[] getStackFrames(IThread thread) ;
	
	/**
	 * Return the visible variables of the given stack frame or value
	 * stackFrameOrValue must be an IStackFrame or an IValue
	 * 
	 * @param stackFrameOrValue The stack frame or value for which variables have to be retrieved
	 * @return The visible variables of the given stack frame or value
	 */
	public IVariable[] getVariables(IDebugElement stackFrameOrValue) ;
	
	/**
	 * Returns the register groups of the given stack frame
	 * 
	 * @param stackFrame The stack frame for which register groups have to be retrieved
	 * @return The register groups of the given stack frame
	 */
	public IRegisterGroup[] getRegisterGroups(IStackFrame stackFrame) ;
	
	/**
	 * Returns the value (if any) for the given variable
	 * 
	 * @param variable The variable for which value has to be retrieved
	 * @return The value (if any) for the given variable
	 */
	public IValue getValue(IVariable variable) ;
	
	/**
	 *  Returns the reference type name of the given variable
	 *  debugElement must be a IVariable or IValue
	 * 
	 * @param variable The variable or value for which the reference type name has to be retrieved
	 * @return The reference type name of the given variable or value
	 */
	public String getReferenceTypeName(IDebugElement debugElement) ;
	
	/**
	 * Returns the string representation of the given value
	 * 
	 * @param value The value for which a textual representation has to be retrieved
	 * @return The string representation of the given value
	 */
	public String getValueString(IValue value) ;
}
