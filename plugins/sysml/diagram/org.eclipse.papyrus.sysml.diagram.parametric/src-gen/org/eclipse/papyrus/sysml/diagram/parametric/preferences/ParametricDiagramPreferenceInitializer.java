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
		FlowPortPreferencePage.initDefaults(store);
		PortPreferencePage.initDefaults(store);
		ConnectorPreferencePage.initDefaults(store);
		DependencyPreferencePage.initDefaults(store);
		
	}
}
