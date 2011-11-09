/**
 * 
 */
package org.eclipse.papyrus.infra.core.sasheditor.internal.preferences;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.core.sasheditor.Activator;
import org.eclipse.ui.preferences.ScopedPreferenceStore;


/**
 * An implementation retrieving values from Eclipse preferences
 * @author cedric dumoulin
 *
 */
public class TabTooltipPreferences implements ITabTooltipPreferences {

	/**
	 * Store used to access preferences.
	 */
	protected IPreferenceStore store;
	
	public TabTooltipPreferences() {
		IPreferenceStore store = createPreferenceStore();
		setPreferenceStore(store);
	}

	/**
	 * Subclasses may implements this method in order to provide the requested preferenceStore.
	 * @return
	 */
	protected IPreferenceStore createPreferenceStore() {
		IPreferenceStore store = new ScopedPreferenceStore(InstanceScope.INSTANCE, Activator.getDefault().getBundle().getSymbolicName());
		
		return store;
	}
	
	
	/**
	 * @return the store
	 */
	public IPreferenceStore getPreferenceStore() {
		return store;
	}

	
	/**
	 * @param store the store to set
	 */
	public void setPreferenceStore(IPreferenceStore store) {
		this.store = store;
	}

	/**
	 * @see org.eclipse.papyrus.examples.preferences.wsprefs.ITabTooltipPreferences#isTooltipEnable()
	 *
	 * @return
	 */
	public boolean isTooltipEnable() {
		
		return store.getBoolean(ITabTooltipPreferences.isTooltipEnable);
	}

	/**
	 * @see org.eclipse.papyrus.examples.preferences.wsprefs.ITabTooltipPreferences#isTooltipForCurrentTabShown()
	 *
	 * @return
	 */
	public boolean isTooltipForCurrentTabShown() {
		return store.getBoolean(ITabTooltipPreferences.isTooltipForCurrentTabShown);
	}

	/**
	 * @see org.eclipse.papyrus.examples.preferences.wsprefs.ITabTooltipPreferences#getScaledFactor()
	 *
	 * @return
	 */
	public float getScaledFactor() {
		return (store.getInt(ITabTooltipPreferences.scaledFactor)/100.0f);

	}

	/**
	 * @see org.eclipse.papyrus.examples.preferences.wsprefs.ITabTooltipPreferences#getScaledFactor()
	 *
	 * @return
	 */
	public int getIntScaledFactor() {
		return store.getInt(ITabTooltipPreferences.scaledFactor);

	}

	/**
	 * @see org.eclipse.papyrus.examples.preferences.wsprefs.ITabTooltipPreferences#getTooltipAutoCloseDelay()
	 *
	 * @return
	 */
	public int getTooltipAutoCloseDelay() {
		return store.getInt(ITabTooltipPreferences.tooltipAutoCloseDelay);
	}

}
