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
package org.eclipse.papyrus.moka.communication;

import org.eclipse.papyrus.moka.communication.event.Start_Event;
import org.eclipse.papyrus.moka.communication.event.isuspendresume.Resume_Event;
import org.eclipse.papyrus.moka.communication.event.isuspendresume.Suspend_Event;
import org.eclipse.papyrus.moka.communication.event.iterminate.Terminate_Event;
import org.eclipse.papyrus.moka.communication.reply.istackframe.GetVariables_Reply;
import org.eclipse.papyrus.moka.communication.reply.ithread.GetStackFrames_Reply;
import org.eclipse.papyrus.moka.communication.reply.ivalue.GetValueString_Reply;
import org.eclipse.papyrus.moka.communication.reply.ivariable.GetReferenceTypeName_Reply;
import org.eclipse.papyrus.moka.communication.reply.ivariable.GetValue_Reply;
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
 * Interface used to establish communications between the debug target
 * and the actual execution engine. For the different kind of communications 
 * that may occur (events, requests, replies), this interface defines a set 
 * of methods corresponding to marshaling / unmarshaling of corresponding
 * messages.
 * The idea is to separate the logic of request, reply and event creation/handling 
 * from the logic of communication realization. The communication package introduces 
 * a hierarchy of message classes, representing the different kind of requests, 
 * replies and events that can be exchanged between the actual execution engine and 
 * the debug model implementation.
 *
 */
public interface IMarshaler {
	
	//******************
	// Marshalling / Unmarshalling of a CREATE DebugEvent (emitted when the target program is ready to receive requests)
	//
	// ******************/
	public String start_event_marshal(Start_Event event) ;
	public Start_Event start_event_unmarshal(String request) ;

	//******************
	// Marshalling / Unmarshalling of Request related to IBreakpointListener.breakpointAdded() and IBreakpointListener.breakpointChanged() 
	//
	// ******************/
	public String addBreakpoint_request_marshal(AddBreakpoint_Request request) ;
	public AddBreakpoint_Request addBreakpoint_request_unmarshal(String request) ;

	//******************
	// Marshalling / Unmarshalling of Request related to IBreakpointListener.breakpointRemoved() and IBreakpointListener.breakpointChanged() 
	//
	// ******************/
	public String removeBreakpoint_request_marshal(RemoveBreakpoint_Request request) ;
	public RemoveBreakpoint_Request removeBreakpoint_request_unmarshal(String request) ;

	//******************
	// Marshalling / Unmarshalling of Request related to IDisconnect.disconnect() 
	//
	// ******************/
	public String disconnect_request_marshal(Disconnect_Request request) ;
	public Disconnect_Request disconnect_request_unmarshal(String request) ;

	//******************
	// Marshalling / Unmarshalling of Request/Event related to ISuspendResume.resume()
	//
	// ******************/
	public String resume_request_marshal(Resume_Request request) ;
	public Resume_Request resume_request_unmarshal(String request) ;
	public String resume_event_marshal(Resume_Event event) ;
	public Resume_Event resume_event_unmarshal(String event) ;

	//******************
	// Marshalling / Unmarshalling of Request/Event related to ISuspendResume.suspend()
	//
	// ******************/
	public String suspend_request_marshal(Suspend_Request request) ;
	public Suspend_Request suspend_request_unmarshal(String request) ;
	public String suspend_event_marshal(Suspend_Event event) ;
	public Suspend_Event suspend_event_unmarshal(String event) ;

	//******************
	// Marshalling / Unmarshalling of Request/Event related to ITerminate.terminate()
	//
	// ******************/
	public String terminate_request_marshal(Terminate_Request request) ;
	public Terminate_Request terminate_request_unmarshal(String request) ;
	public String terminate_event_marshal(Terminate_Event event) ;
	public Terminate_Event terminate_event_unmarshal(String event) ;

	//******************
	// Marshalling / Unmarshalling of Request/Reply related to IThread.getStackFrames()
	//
	// ******************/
	public String getStackFrames_request_marshal(GetStackFrames_Request request) ;
	public GetStackFrames_Request getStackFrames_request_unmarshal(String request) ;
	public String getStackFrames_reply_marshal(GetStackFrames_Reply reply) ;
	public GetStackFrames_Reply getStackFrames_reply_unmarshal(String reply) ;

	//******************
	// Marshalling / Unmarshalling of Request/Reply related to IStackFrame.getVariables()
	//
	// ******************/
	public String getVariables_request_marshal(GetVariables_Request request) ;
	public GetVariables_Request getVariables_request_unmarshal(String request) ;
	public String getVariables_reply_marshal(GetVariables_Reply reply) ;
	public GetVariables_Reply getVariables_reply_unmarshal(String reply) ;


	//******************
	// Marshalling / Unmarshalling of Request/Reply related to IVariable.getValue()
	//
	// ******************/
	public String getValue_request_marshal(GetValue_Request request) ;
	public GetValue_Request getValue_request_unmarshal(String request) ;
	public String getValue_reply_marshal(GetValue_Reply reply) ;
	public GetValue_Reply getValue_reply_unmarshal(String reply) ;

	//******************
	// Marshalling / Unmarshalling of Request/Reply related to IVariable.getReferenceTypeName()
	//
	// ******************/
	public String getReferenceTypeName_request_marshal(GetReferenceTypeName_Request request) ;
	public GetReferenceTypeName_Request getReferenceTypeName_request_unmarshal(String request) ;
	public String getReferenceTypeName_reply_marshal(GetReferenceTypeName_Reply reply) ;
	public GetReferenceTypeName_Reply getReferenceTypeName_reply_unmarshal(String reply) ;

	//******************
	// Marshalling / Unmarshalling of Request/Reply related to IValue.getValueString()
	//
	// ******************/
	public String getValueString_request_marshal(GetValueString_Request request) ;
	public GetValueString_Request getValueString_request_unmarshal(String request) ;
	public String getValueString_reply_marshal(GetValueString_Reply reply) ;
	public GetValueString_Reply getValueString_reply_unmarshal(String reply) ;
}
