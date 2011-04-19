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

import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.common.helper.PreferenceInitializerForElementHelper;

/**
 * Default Shape view Factory for Papyrus custom nodes.
 */
public class ShapeViewFactory extends org.eclipse.gmf.runtime.diagram.ui.view.factories.optimal.ShapeViewFactory {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Shape createNode() {
		return NotationFactory.eINSTANCE.createShape();
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

		String elementName = view.getType();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(view, store, elementName);
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(view, store, elementName);
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(view, store, elementName);

		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(view, store, elementName);
	}
}
