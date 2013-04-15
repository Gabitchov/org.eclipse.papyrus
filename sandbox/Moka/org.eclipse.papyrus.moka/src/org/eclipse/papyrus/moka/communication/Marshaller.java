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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.papyrus.moka.MokaConstants;
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
 * A default implementation for the IMarshaler interface.
 * 
 * This default implementation of IMarshaller simulates marshaling and 
 * unmarshaling of messages. 
 * When a marshal operation is called, the returned string is simply a 
 * key for the given Request, Reply or Event object. This key is generated 
 * using the java.Object method hashCode(). In the case of a Request or 
 * Event object, the key is prefixed with a string describing the nature 
 * of the Request or Event (prefixes are defined in class MokaConstants). 
 * This prefix is used for request and event dispatching in 
 * AbstractExecutionEngine and MokaDebugTarget respectively. 
 * The generated string is used as a key for a map entry (i.e., messages), 
 * where the given Request, Reply or Event object is the associated value. 
 * Unmarshaling then simply consists in returning the value corresponding 
 * to a key in the messages map, and removing this element from the map. 
 * In the case where the actual execution engine is implemented as an eclipse 
 * plug-in, usage of this default Marshaler should be considered by clients.
 * MokaDebugTarget and AbstractExecutionEngine implement a communication protocol, 
 * which determines the order in which request, reply and event messages may be exchanged, 
 * and hiding to contributor (in the case where they extend AbstractExecutionEngine) 
 * interactions with the marshaling / unmarshaling mechanism.

 * This class encapsulates a static instance of interface IMarshaller,
 * which can be accessed by calling stating method getInstance().
 * By default, an instance of Marshaler will be returned.
 * However, a particular execution engine has the possibility an alternative
 * implementation, by calling method setMarshalerInstance() at the beginning 
 * of the execution.
 * 
 */
public class Marshaller implements IMarshaler {
	
	protected static IMarshaler eInstance = null ;
	
	public static synchronized IMarshaler getInstance() {
		if (eInstance == null)
			eInstance = new Marshaller() ;
		return eInstance ;
	}
	
	public static void setMarshalerInstance(IMarshaler marshaller) {
		eInstance = marshaller ;
	}
	
	private Marshaller() {
		
	}

	protected Map<String, Object> messages = new HashMap<String, Object>() ;
	
	public String start_event_marshal(Start_Event event) {
		String key = MokaConstants.event_start + event.hashCode() ;
		messages.put(key, event) ;
		return key;
	}

	public Start_Event start_event_unmarshal(String request) {
		Object evt = messages.get(request) ;
		messages.remove(request) ;
		return (Start_Event) evt ;
	}

	public String addBreakpoint_request_marshal(AddBreakpoint_Request request) {
		String key = MokaConstants.request_addBreakpoint + request.hashCode() ;
		messages.put(key, request) ;
		return key;
	}

	public AddBreakpoint_Request addBreakpoint_request_unmarshal(String request) {
		Object req = messages.get(request) ;
		messages.remove(request) ;
		return (AddBreakpoint_Request) req ;
	}

	public String removeBreakpoint_request_marshal(RemoveBreakpoint_Request request) {
		String key = MokaConstants.request_removeBreakpoint + request.hashCode() ;
		messages.put(key, request) ;
		return key;
	}

	public RemoveBreakpoint_Request removeBreakpoint_request_unmarshal(String request) {
		Object req = messages.get(request) ;
		messages.remove(request) ;
		return (RemoveBreakpoint_Request) req ;
	}

	public String disconnect_request_marshal(Disconnect_Request request) {
		String key = MokaConstants.request_disconnect + request.hashCode() ;
		messages.put(key, request) ;
		return key;
	}

	public Disconnect_Request disconnect_request_unmarshal(String request) {
		Object req = messages.get(request) ;
		messages.remove(request) ;
		return (Disconnect_Request) req ;
	}


	public String resume_request_marshal(Resume_Request request) {
		String key = MokaConstants.request_resume + request.hashCode() ;
		messages.put(key, request) ;
		return key;
	}

	public Resume_Request resume_request_unmarshal(String request) {
		Object req = messages.get(request) ;
		messages.remove(request) ;
		return (Resume_Request) req ;
	}

	public String resume_event_marshal(Resume_Event event) {
		String key = MokaConstants.event_resume + event.hashCode() ;
		messages.put(key, event) ;
		return key;
	}

	public Resume_Event resume_event_unmarshal(String event) {
		Object evt = messages.get(event) ;
		messages.remove(event) ;
		return (Resume_Event) evt ;
	}

	public String suspend_request_marshal(Suspend_Request request) {
		String key = MokaConstants.request_suspend + request.hashCode() ;
		messages.put(key, request) ;
		return key;
	}

	public Suspend_Request suspend_request_unmarshal(String request) {
		Object req = messages.get(request) ;
		messages.remove(request) ;
		return (Suspend_Request) req ;
	}

	public String suspend_event_marshal(Suspend_Event event) {
		String key = MokaConstants.event_suspend + event.hashCode() ;
		messages.put(key, event) ;
		return key;
	}

	public Suspend_Event suspend_event_unmarshal(String event) {
		Object evt = messages.get(event) ;
		messages.remove(event) ;
		return (Suspend_Event) evt ;
	}

	public String terminate_request_marshal(Terminate_Request request) {
		String key = MokaConstants.request_terminate + request.hashCode() ;
		messages.put(key, request) ;
		return key;
	}

	public Terminate_Request terminate_request_unmarshal(String request) {
		Object req = messages.get(request) ;
		messages.remove(request) ;
		return (Terminate_Request) req ;
	}

	public String terminate_event_marshal(Terminate_Event event) {
		String key = MokaConstants.event_terminate + event.hashCode() ;
		messages.put(key, event) ;
		return key;
	}

	public Terminate_Event terminate_event_unmarshal(String event) {
		Object evt = messages.get(event) ;
		messages.remove(event) ;
		return (Terminate_Event) evt ;
	}

	public String getStackFrames_request_marshal(GetStackFrames_Request request) {
		String key = MokaConstants.request_getStackFrames + request.hashCode() ;
		messages.put(key, request) ;
		return key;
	}

	public GetStackFrames_Request getStackFrames_request_unmarshal(String request) {
		Object req = messages.get(request) ;
		messages.remove(request) ;
		return (GetStackFrames_Request) req ;
	}

	public String getStackFrames_reply_marshal(GetStackFrames_Reply reply) {
		String key = "" + reply.hashCode() ;
		messages.put(key, reply) ;
		return key;
	}

	public GetStackFrames_Reply getStackFrames_reply_unmarshal(String reply) {
		Object rep = messages.get(reply) ;
		messages.remove(reply) ;
		return (GetStackFrames_Reply) rep ;
	}

	public String getVariables_request_marshal(GetVariables_Request request) {
		String key = MokaConstants.request_getVariables + request.hashCode() ;
		messages.put(key, request) ;
		return key;
	}

	public GetVariables_Request getVariables_request_unmarshal(String request) {
		Object req = messages.get(request) ;
		messages.remove(request) ;
		return (GetVariables_Request) req ;
	}

	public String getVariables_reply_marshal(GetVariables_Reply reply) {
		String key = "" + reply.hashCode() ;
		messages.put(key, reply) ;
		return key;
	}

	public GetVariables_Reply getVariables_reply_unmarshal(String reply) {
		Object rep = messages.get(reply) ;
		messages.remove(reply) ;
		return (GetVariables_Reply) rep ;
	}

	public String getValue_request_marshal(GetValue_Request request) {
		String key = MokaConstants.request_getValue + request.hashCode() ;
		messages.put(key, request) ;
		return key;
	}

	public GetValue_Request getValue_request_unmarshal(String request) {
		Object req = messages.get(request) ;
		messages.remove(request) ;
		return (GetValue_Request) req ;
	}

	public String getValue_reply_marshal(GetValue_Reply reply) {
		String key = "" + reply.hashCode() ;
		messages.put(key, reply) ;
		return key;
	}

	public GetValue_Reply getValue_reply_unmarshal(String reply) {
		Object rep = messages.get(reply) ;
		messages.remove(reply) ;
		return (GetValue_Reply) rep ;
	}

	public String getReferenceTypeName_request_marshal(GetReferenceTypeName_Request request) {
		String key = MokaConstants.request_getReferenceTypeName + request.hashCode() ;
		messages.put(key, request) ;
		return key;
	}

	public GetReferenceTypeName_Request getReferenceTypeName_request_unmarshal(String request) {
		Object req = messages.get(request) ;
		messages.remove(request) ;
		return (GetReferenceTypeName_Request) req ;
	}

	public String getReferenceTypeName_reply_marshal(GetReferenceTypeName_Reply reply) {
		String key = "" + reply.hashCode() ;
		messages.put(key, reply) ;
		return key;
	}

	public GetReferenceTypeName_Reply getReferenceTypeName_reply_unmarshal(String reply) {
		Object rep = messages.get(reply) ;
		messages.remove(reply) ;
		return (GetReferenceTypeName_Reply) rep ;
	}

	public String getValueString_request_marshal(GetValueString_Request request) {
		String key = MokaConstants.request_getValueString + request.hashCode() ;
		messages.put(key, request) ;
		return key;
	}

	public GetValueString_Request getValueString_request_unmarshal(String request) {
		Object req = messages.get(request) ;
		messages.remove(request) ;
		return (GetValueString_Request) req ;
	}

	public String getValueString_reply_marshal(GetValueString_Reply reply) {
		String key = "" + reply.hashCode() ;
		messages.put(key, reply) ;
		return key;
	}

	public GetValueString_Reply getValueString_reply_unmarshal(String reply) {
		Object rep = messages.get(reply) ;
		messages.remove(reply) ;
		return (GetValueString_Reply) rep ;
	}
	
	
	
}
