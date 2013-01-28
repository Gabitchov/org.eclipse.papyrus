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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.services.tracepoints.TraceActions.TraceFeature;
import org.eclipse.papyrus.infra.services.tracepoints.preferences.TPPreferenceConstants;


/**
 * Support for multiple trace mechanisms via the Eclipse extension mechanism
 */

public class TraceMechanism {

	public static final String ITRACE_MECHANISM_ID = Activator.PLUGIN_ID + ".traceMechanism";

	public static EList<ITraceMechanism> getTraceMechanisms()
	{
		EList<ITraceMechanism> mechanisms = new BasicEList<ITraceMechanism>();
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		IConfigurationElement[] configElements = reg.getConfigurationElementsFor(ITRACE_MECHANISM_ID);
		for(IConfigurationElement configElement : configElements) {
			try {
				// TODO: cache returned instance (avoid creating a new instance each time => more efficient, no need for static attributes)
				final Object obj = configElement.createExecutableExtension("class");
				if(obj instanceof ITraceMechanism) {
					mechanisms.add((ITraceMechanism)obj);
				}
			} catch (CoreException exception) {
				exception.printStackTrace();
			}
		}
		return mechanisms;
	}

	/**
	 * get the ID of the default realization mechanism. In case of classes, need to store multiple mechanisms (how to trace states, how to trace
	 * operations)
	 * 
	 * @return
	 */
	public static String getMechanismFromPreferences(TraceFeature feature) {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		if(store != null) {
			if(feature == TraceFeature.Class) {
				return TraceActions.getStringPrefix(TraceFeature.Port) + store.getInt(TPPreferenceConstants.P_TRACE_IMPLEMENTATION_PORT) + "," +
					TraceActions.getStringPrefix(TraceFeature.State) + store.getInt(TPPreferenceConstants.P_TRACE_IMPLEMENTATION_SM) + "," +
					TraceActions.getStringPrefix(TraceFeature.Operation) + store.getInt(TPPreferenceConstants.P_TRACE_IMPLEMENTATION_OP);
			}
			else if(feature == TraceFeature.State) {
				return store.getString(TPPreferenceConstants.P_TRACE_IMPLEMENTATION_SM);
			}
			else if(feature == TraceFeature.Operation) {
				return store.getString(TPPreferenceConstants.P_TRACE_IMPLEMENTATION_OP);
			}
		}
		return "";
	}

	/**
	 * Convenience function. Return defaultTraceMechanisms in function of the element being traced.
	 * 
	 * @param element
	 * @return
	 */
	public static String getDefaultMechanism(EObject element) {
		return getMechanismFromPreferences(TraceActions.getTraceFeature(element));
	}
}
