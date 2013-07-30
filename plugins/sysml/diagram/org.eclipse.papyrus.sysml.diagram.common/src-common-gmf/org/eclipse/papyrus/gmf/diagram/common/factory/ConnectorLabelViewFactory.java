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

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;

/**
 * Default view Factory for Papyrus custom affixed labels.
 */
public class ConnectorLabelViewFactory extends AbstractLabelViewFactory {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected LayoutConstraint createLayoutConstraint() {
		return NotationFactory.eINSTANCE.createLocation();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initializeFromPreferences(View view) {

		super.initializeFromPreferences(view);

		IPreferenceStore store = (IPreferenceStore)getPreferencesHint().getPreferenceStore();
		if(store == null) {
			return;
		}

		String preferenceKey = ViewUtil.getViewContainer(view).getType() + "-" + view.getType();
		PreferenceInitializerForElementHelper.initLabelLocationFromPrefs(view, store, preferenceKey);
	}
}
