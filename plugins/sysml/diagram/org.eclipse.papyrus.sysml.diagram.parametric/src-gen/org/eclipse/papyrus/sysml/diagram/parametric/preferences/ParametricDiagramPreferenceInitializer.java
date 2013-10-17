/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Régis CHEVREL: chevrel.regis <at> gmail.com
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.sysml.diagram.parametric.Activator;

public class ParametricDiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	protected IPreferenceStore getPreferenceStore() {
		return Activator.getInstance().getPreferenceStore();
	}

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();
		
		org.eclipse.papyrus.sysml.diagram.parametric.preferences.ConstraintPreferencePage.initDefaults(store);			
		org.eclipse.papyrus.sysml.diagram.parametric.preferences.CommentPreferencePage.initDefaults(store);			
		org.eclipse.papyrus.sysml.diagram.parametric.preferences.CommentAnnotatedElementPreferencePage.initDefaults(store);
		BlockCompositePreferencePage.initDefaults(store);
		BlockPropertyCompositePreferencePage.initDefaults(store);
		ConnectorPreferencePage.initDefaults(store);
		DependencyPreferencePage.initDefaults(store);
		
	}
}
