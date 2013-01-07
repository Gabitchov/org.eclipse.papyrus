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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.services.tracepoints.preferences.TPPreferenceConstants;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.State;

/**
 * Set of enumerations that indicates what we want to trace.
 * 
 * @author ansgar
 * 
 */
public class TraceActions {

	public enum TraceScope {
		clazz,
		operation,
		state,
		activity,
	};

	/**
	 * Options for tracing a class. Note that some options need additional information, e.g. "all operations"
	 * needs additional information how operations are traced
	 */
	public enum TAClass {
		Creation,
		Destruction,
		AllOperations,
		AllPorts,
		AllStates
		// +(?) all properties/all operations
		// +(all ports?)
		// +all state changes? (hierarchical propagation?)

	};

	/**
	 * Different ways to trace operations: put only the call itself or the values of the parameters into
	 * a trace event.
	 */
	public enum TAOperation {
		OnlyCall,
		ParameterValues, // here exclusive (parameter values and OnlyCall may not be selected at the same time)
	};

	/**
	 * Not used for the moment
	 */
	public enum TAAttribute {
		PropertyRead,
		PropertyWrite; // write old and new value
	};

	/**
	 * Options to trace state
	 */
	public enum TAState {
		StateEnter, // add incoming transition to trace?
		StateLeave, // add outgoing transition to trace?
		Transition // nothing (?) (triggers are known? - no, could be one out of many triggers)
	};

	/**
	 * Not used for the moment
	 */
	public enum TAActivity {
		activity // (i.e. call operation action) explicit choice of (named attribute?)
	};

	public static String[][] getStringFields(Enum<?>[] enumValues) {
		int i = 0;
		String[][] taOptions = new String[enumValues.length][2];
		for(Enum<?> tLiteral : enumValues) {
			taOptions[i][1] = tLiteral.name();
			taOptions[i][0] = tLiteral.name();
			i++;
		}
		return taOptions;
	}

	public enum TraceFeature {
		Class,
		Port,
		State,
		Operation
	};

	/**
	 * Obtain the definition of a trace option in case of traces on classes
	 * 
	 * @param traceAction
	 * @param subFeature
	 *        the trace feature which we want to obtain, i.e. class, state or operation
	 *        from a composite action string in case of class trace points
	 * @return
	 */
	public static String getOptions(String traceAction, TraceFeature subFeature) {
		String prefix = getStringPrefix(subFeature);
		int pos = traceAction.indexOf(prefix);
		if(pos == -1)
			return null;
		else {
			// comma is used as separation character.
			int endPos = traceAction.indexOf(',', pos + 1);
			if(endPos == -1) {
				return traceAction.substring(pos);
			}
			return traceAction.substring(pos, endPos);
		}
	}

	/**
	 * Get the prefix that is used in each case of a class action to distinguish class, state and operation actions.
	 * 
	 * @param feature
	 *        The trace feature for which we set an action
	 * @return
	 */
	public static String getStringPrefix(TraceFeature feature) {
		if(feature == TraceFeature.Class) {
			return "C:";
		}
		if(feature == TraceFeature.Port) {
			return "P:";
		}
		else if(feature == TraceFeature.State) {
			return "S:";
		}
		else if(feature == TraceFeature.Operation) {
			return "O:";
		}
		return null;
	}

	/**
	 * Initialize an action string that will be stored in the trace marker from the default actions in the
	 * preferences. In case of a class, the value is a combination of different options
	 * that are prefixed to enable a unique classification
	 * 
	 * @param feature
	 *        The trace feature for which we set an action
	 * @return
	 */
	public static String defaultAction(TraceFeature feature) {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		if(feature == TraceFeature.Class) {
			return getStringPrefix(TraceFeature.Class) + store.getDefaultInt(TPPreferenceConstants.P_TRACE_OPTION_CLASS) + "," +
				getStringPrefix(TraceFeature.State) + store.getDefaultInt(TPPreferenceConstants.P_TRACE_OPTION_STATE) + "," +
				getStringPrefix(TraceFeature.Operation) + store.getDefaultInt(TPPreferenceConstants.P_TRACE_OPTION_OP);
		}
		else if(feature == TraceFeature.State) {
			return store.getDefaultString(TPPreferenceConstants.P_TRACE_OPTION_STATE);
		}
		else if(feature == TraceFeature.Operation) {
			return store.getDefaultString(TPPreferenceConstants.P_TRACE_OPTION_OP);
		}
		return "";
	}

	/**
	 * Convenience function, return the default action in function of the model element
	 * 
	 * @param element
	 * @return
	 */
	public static String defaultAction(EObject element) {
		return defaultAction(getTraceFeature(element));
	}


	public static TraceFeature getTraceFeature(EObject element) {
		if(element instanceof State) {
			return TraceFeature.State;
		}
		else if(element instanceof Operation) {
			return TraceFeature.Operation;
		}
		else if(element instanceof org.eclipse.uml2.uml.Class) {
			return TraceFeature.Class;
		}
		return null;
	}
}
