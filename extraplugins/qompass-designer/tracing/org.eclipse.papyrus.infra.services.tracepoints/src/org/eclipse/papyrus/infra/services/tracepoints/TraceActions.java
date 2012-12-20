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
package org.eclipse.papyrus.infra.services.tracepoints;


public class TraceActions {

	public enum TraceScope {
		clazz,
		operation,
		state,
		activity,
	};

	// Trace actions for a class. Note that multiple elements may be selected for
	// a given model element (tool takes care on computing a 2^index value that allows
	// bitwise or
	public enum TAClass {
		Creation,
		Destruction,
		AllOperations,
		AllPorts,
		AllStates
		//        +(?) all properties/all operations
		//        +(all ports?)
		//        +all state changes? (hierarchical propagation?)

	};

	public enum TAOperation {
		OnlyCall,
		ParameterValues, // here exclusive (parameter values and OnlyCall may not be selected at the same time)
	};

	public enum TAAttribute {
		PropertyRead,
		PropertyWrite; // write old and new value
	};

	public enum TAState {
		StateEnter, // add incoming transition to trace?
		StateLeave, // add outgoing transition to trace?
		Transition // nothing (?) (triggers are known? - no, could be one out of many triggers)
	};

	public enum TAActivity {
		activity // (i.e. call operation action) explicit choice of (named attribute?)
	};
}
