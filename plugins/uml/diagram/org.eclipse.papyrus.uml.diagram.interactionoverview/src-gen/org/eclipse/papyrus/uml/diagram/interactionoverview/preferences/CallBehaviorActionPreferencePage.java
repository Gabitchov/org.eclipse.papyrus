/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.interactionoverview.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.uml.diagram.interactionoverview.provider.ElementTypes;

public class CallBehaviorActionPreferencePage extends InteractionOverviewDiagramNodePreferencePage {

	/** Constant key to access preferences */
	protected static String prefKey = ElementTypes.DIAGRAM_ID + "_CallBehaviorAction"; //$NON-NLS-1$

	/** Default constructor */
	public CallBehaviorActionPreferencePage() {
		super();
		setPreferenceKey(ElementTypes.DIAGRAM_ID + "_CallBehaviorAction"); //$NON-NLS-1$
	}

	/**
	 * Initialize defaults using a specified {@link IPreferenceStore}
	 * 
	 * @param store
	 *        the preference store.
	 */
	public static void initDefaults(final IPreferenceStore store) {
		// Start of user code custom default initializations
		// End of user code

	}

}
