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
package org.eclipse.papyrus.moka;

public class MokaConstants {

	public final static String PAPYRUS_EDITOR_ID = "org.eclipse.papyrus.infra.core.papyrusEditor" ;

	/**
	 * The ID of the "moka debug model". All moka debug elements use/return this ID.
	 */
	public final static String MOKA_DEBUG_MODEL_ID = "org.eclipse.papyrus.moka" ;

	/**
	 * ID of the moka breakpoint marker type
	 */
	public final static String MOKA_BREAKPOINT_MARKER_ID = "org.eclipse.papyrus.moka.breakpointmarker" ;
	
	/**
	 * ID of the moka suspended marker type
	 */
	public final static String MOKA_SUSPENDED_MARKER_ID = "org.eclipse.papyrus.moka.ui.suspendedmarker" ;
	
	/**
	 * ID of the moka animation marker type
	 */
	public final static String MOKA_ANIMATION_MARKER_ID ="org.eclipse.papyrus.moka.ui.animationmarker" ;

	/**
	 * ID of the moka 'engine' extension point
	 */
	public final static String MOKA_ENGINE_EXTENSION_POINT_ID = "org.eclipse.papyrus.moka.engine" ;

	/**
	 * ID of the moka 'Default execution engine'
	 */
	public final static String MOKA_DEFAULT_EXECUTION_ENGINE_PREF = "Default execution engine" ;

	/**
	 * To be used by clients providing 'auto-steps' execution.
	 */
	public static boolean MOKA_AUTOMATIC_ANIMATION = true ;
	
	/**
	 * To be used by clients providing 'auto-steps' execution.
	 */
	public static boolean MOKA_OPEN_DIAGRAM_IN_AUTOMATIC_ANIMATION = true ;
	
	/**
	 * Default delay between two animation steps.
	 * To be used by clients providing automatic animation.
	 */
	public static int MOKA_ANIMATION_DELAY = 50 ;

	
	/**
	 * Constants underlying the communication protocol between the debug target and the actual execution engine
	 */

	//////////
	// Generic
	//////////
	/**
	 * Prefix for generic acknowledgment sent by the target program
	 */
	public final static String ack = "ack" ;	
	/**
	 * Prefix for a start event
	 */
	public final static String event_start = "event_start" ;

	//////////////////////////
	// IDebugTarget
	//////////////////////////
	/**
	 * Prefix for a getThreads request
	 */
	public final static String request_getThreads = "request_getThreads" ;
	/**
	 * Prefix for a getName request
	 */
	public final static String request_getName = "request_getName" ;

	//////////////////////////
	// IBreakpointListener
	//////////////////////////
	/**
	 *  Prefix for an addBreakpoint request (called in the MokaDebugTarget realization of IBreakpointListener.breakpointAdded and IBreakpointListener.breakpointChanged)
	 */
	public final static String request_addBreakpoint = "request_addBreakpoint" ;
	/**
	 *  Prefix for a removeBreakpoint request (called in the MokaDebugTarget realization of IBreakpointListener.breakpointRemoved and IBreakpointListener.breakpointChanged)
	 */
	public final static String request_removeBreakpoint = "request_removeBreakpoint" ;

	//////////////////////////
	// IDisconnect
	//////////////////////////
	/**
	 * Prefix for a disconnect request
	 */
	public final static String request_disconnect = "request_disconnect" ;

	//////////////////////////
	// IMemoryBlockRetrieval
	//////////////////////////
	/**
	 * Prefix for a getMemoryBlock request
	 */
	public final static String request_getMemoryBlock = "request_getMemoryBlock" ;

	//////////////////////////
	// ISuspendResume
	//////////////////////////
	/**
	 * Prefix for a resume request
	 */
	public final static String request_resume = "request_resume" ;
	/**
	 * Prefix for a resume event
	 */
	public final static String event_resume = "event_resume" ;
	/**
	 * Prefix for a suspend request
	 */
	public final static String request_suspend = "request_suspend" ;
	/**
	 * Prefix for a suspend event
	 */
	public final static String event_suspend = "event_suspend" ;

	//////////////////////////
	// ITerminate
	//////////////////////////
	/**
	 * Prefix for a terminate request
	 */
	public final static String request_terminate = "request_terminate" ;
	/**
	 * Prefix for a terminate event
	 */
	public final static String event_terminate = "event_terminate" ;

	//////////////////////////
	// IThread
	//////////////////////////
	/**
	 * Prefix for a getStackFrames request
	 */
	public final static String request_getStackFrames = "request_getStackFrames" ;

	//////////////////////////
	// IStackFrame
	//////////////////////////
	/**
	 * Prefix for a getVariables request
	 */
	public final static String request_getVariables = "request_getVariables" ;
	/**
	 * Prefix for a getRegisterGroups request
	 */
	public final static String request_getRegisterGroups = "request_getRegisterGroups" ;

	//////////////////////////
	// IVariable
	//////////////////////////
	/**
	 * Prefix for a getValue request
	 */
	public final static String request_getValue = "request_getValue" ;
	/**
	 * Prefix for a getReferenceTypeName request
	 */
	public final static String request_getReferenceTypeName = "request_getReferenceTypeName" ;

	//////////////////////////
	// IValue
	//////////////////////////
	/**
	 * Prefix for a getValueString request
	 */
	public final static String request_getValueString = "request_getValueString" ;

}
