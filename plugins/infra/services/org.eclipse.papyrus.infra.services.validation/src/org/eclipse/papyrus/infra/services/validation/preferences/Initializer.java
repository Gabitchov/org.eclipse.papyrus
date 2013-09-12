package org.eclipse.papyrus.infra.services.validation.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.services.validation.Activator;

public class Initializer extends AbstractPreferenceInitializer {

	public Initializer() {
	}

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		store.setDefault(PreferenceConstants.HIERARCHICAL_MARKERS, "ALL"); //$NON-NLS-1$
		
		store.setDefault(PreferenceConstants.AUTO_SHOW_VALIDATION_VIEW, true);
	}
}
