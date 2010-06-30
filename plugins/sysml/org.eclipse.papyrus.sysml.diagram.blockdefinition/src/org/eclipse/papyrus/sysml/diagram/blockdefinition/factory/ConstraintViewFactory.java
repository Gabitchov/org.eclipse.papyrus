package org.eclipse.papyrus.sysml.diagram.blockdefinition.factory;

import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.common.helper.PreferenceInitializerForElementHelper;


public class ConstraintViewFactory extends AbstractShapeViewFactory {
	
	/**
	 * Should be moved in a common abstract class...
	 */
	@Override
	protected void initializeFromPreferences(View view) {

		IPreferenceStore store = (IPreferenceStore)getPreferencesHint().getPreferenceStore();
		if(store == null) {
			return;
		}

		String elementName = view.getType();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(view, store, elementName);
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(view, store, elementName);
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(view, store, elementName);

	}
}
