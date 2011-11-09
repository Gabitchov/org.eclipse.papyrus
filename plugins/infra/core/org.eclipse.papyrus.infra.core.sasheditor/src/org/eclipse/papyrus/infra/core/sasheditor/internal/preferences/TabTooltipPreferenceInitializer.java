package org.eclipse.papyrus.infra.core.sasheditor.internal.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.core.sasheditor.Activator;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

/**
 * Class used to initialize default preference values.
 */
public class TabTooltipPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * 
	 * 
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = createPreferenceStore();
		store.setDefault(ITabTooltipPreferences.isTooltipEnable, true);
		store.setDefault(ITabTooltipPreferences.isTooltipForCurrentTabShown, false);
		store.setDefault(ITabTooltipPreferences.scaledFactor, 50);
		store.setDefault(ITabTooltipPreferences.tooltipAutoCloseDelay, 5000);
		

	}

	/**
	 * Subclasses may implements this method in order to provide the requested preferenceStore.
	 * @return
	 */
	protected IPreferenceStore createPreferenceStore() {
		IPreferenceStore store = new ScopedPreferenceStore(DefaultScope.INSTANCE, Activator.getDefault().getBundle().getSymbolicName());
		
		return store;
	}
	
}
