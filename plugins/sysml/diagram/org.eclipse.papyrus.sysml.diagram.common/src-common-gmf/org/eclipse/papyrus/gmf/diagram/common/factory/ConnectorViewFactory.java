/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.gmf.diagram.common.factory;

import java.util.Arrays;
import java.util.List;

import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.common.providers.ThemeInitializerManager;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;

/**
 * Default connector view Factory for Papyrus custom edges.
 */
public class ConnectorViewFactory extends org.eclipse.gmf.runtime.diagram.ui.view.factories.optimal.ConnectorViewFactory {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected List createStyles(View view) {
		return Arrays.asList(new Style[]{ NotationFactory.eINSTANCE.createFontStyle() });
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initializeFromPreferences(View view) {
		//Do not call initializeFromPreferences when the preference initializer is disabled (Typical use case: CSS are installed)
		if(ThemeInitializerManager.instance.usePreferenceInitializer(view)) {
			super.initializeFromPreferences(view);
		}

		IPreferenceStore store = (IPreferenceStore)getPreferencesHint().getPreferenceStore();
		if(store == null) {
			return;
		}

		//The PreferenceInitializerForElementHelper already checks for usePreferenceInitializer() (When required)
		String elementName = view.getType();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(view, store, elementName);
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(view, store, elementName);
		PreferenceInitializerForElementHelper.initRoutingFromPrefs(view, store, elementName);
		PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(view, store, elementName);
	}

}
