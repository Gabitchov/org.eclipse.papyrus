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

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.services.tracepoints.Activator;
import org.eclipse.papyrus.infra.services.tracepoints.ITraceMechanism;
import org.eclipse.papyrus.infra.services.tracepoints.TraceMechanism;

/**
 * Class used to initialize default preference values.
 */
public class TPPreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		EList<ITraceMechanism> mechanisms = TraceMechanism.getTraceMechanisms();
		String mechanismID = "";
		if(mechanisms.size() > 0) {
			ITraceMechanism mechanism = mechanisms.get(0);
			// TODO: function need to support null object
			EList<String> mechanismIDs = mechanism.getTraceMechanismIDs(null);
			if(mechanismIDs.size() > 0) {
				mechanismID = mechanismIDs.get(0);
			}
		}
		store.setDefault(TPPreferenceConstants.P_TRACE_IMPLEMENTATION_PORT, mechanismID);
		store.setDefault(TPPreferenceConstants.P_TRACE_IMPLEMENTATION_OP, mechanismID);
		store.setDefault(TPPreferenceConstants.P_TRACE_IMPLEMENTATION_SM, mechanismID);

		store.setDefault(TPPreferenceConstants.P_TRACE_OPTION_CLASS, 0);
		store.setDefault(TPPreferenceConstants.P_TRACE_OPTION_STATE, 0);
		store.setDefault(TPPreferenceConstants.P_TRACE_OPTION_OP, 0);
	}
}
