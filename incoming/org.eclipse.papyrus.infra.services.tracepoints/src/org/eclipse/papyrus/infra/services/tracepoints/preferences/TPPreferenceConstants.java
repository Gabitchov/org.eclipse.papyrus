/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.tracepoints.preferences;

/**
 * Constant definitions for plug-in preferences
 */
public class TPPreferenceConstants {

	/**
	 * The trace mechanism that should be used by default
	 */
	public static final String P_TRACE_IMPLEMENTATION_PORT = "papyrus.trace.implementation.port";

	/**
	 * The trace mechanism that should be used by default
	 */
	public static final String P_TRACE_IMPLEMENTATION_OP = "papyrus.trace.implementation.op";

	/**
	 * The trace mechanism that should be used by default
	 */
	public static final String P_TRACE_IMPLEMENTATION_SM = "papyrus.trace.implementation.sm";


	/**
	 * Options for trace implementation via state machines
	 */
	public static final String P_TRACE_OPTION_CLASS = "papyrus.trace.option.class";

	/**
	 * Options for trace implementation for operations
	 */
	public static final String P_TRACE_OPTION_STATE = "papyrus.trace.option.state";

	/**
	 * Options for trace implementation via state machines
	 */
	public static final String P_TRACE_OPTION_OP = "papyrus.trace.option.op";
}
