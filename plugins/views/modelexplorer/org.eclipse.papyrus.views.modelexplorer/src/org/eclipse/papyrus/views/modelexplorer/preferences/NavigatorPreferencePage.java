/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.preferences.pages.AbstractPapyrusNodePreferencePage;
import org.eclipse.papyrus.views.modelexplorer.Activator;
import org.eclipse.swt.widgets.Composite;

public class NavigatorPreferencePage extends AbstractPapyrusNodePreferencePage {

	/**
	 * @generated
	 */
	@Override
	protected String getBundleId() {
		return Activator.PLUGIN_ID;
	}

	/**
	 * @generated
	 */
	public static void initDefaults(IPreferenceStore store) {

		// String elementName = "Model Explorer";
		// PreferenceConverter.setDefault(store,
		// PreferencesConstantsHelper.getElementConstant(elementName,
		// PreferencesConstantsHelper.COLOR_FILL), new
		// org.eclipse.swt.graphics.RGB(255, 255, 255));
		// PreferenceConverter.setDefault(store,
		// PreferencesConstantsHelper.getElementConstant(elementName,
		// PreferencesConstantsHelper.COLOR_LINE), new
		// org.eclipse.swt.graphics.RGB(0, 0, 0));
		//
		// // Set the default for the gradient
		// store.setDefault(PreferencesConstantsHelper.getElementConstant(elementName,
		// PreferencesConstantsHelper.GRADIENT_POLICY), false);
		// GradientPreferenceConverter gradientPreferenceConverter = new
		// GradientPreferenceConverter(new org.eclipse.swt.graphics.RGB(255,
		// 255, 255), new org.eclipse.swt.graphics.RGB(0, 0, 0), 0, 0);
		// store.setDefault(PreferencesConstantsHelper.getElementConstant(elementName,
		// PreferencesConstantsHelper.COLOR_GRADIENT),
		// gradientPreferenceConverter.getPreferenceValue());

	}

	@Override
	protected void createPageContents(Composite parent) {
		// super.createPageContents(parent);

		// show popup dialog
		TransformCommandShowPopupDialogGroup groupComposite = new TransformCommandShowPopupDialogGroup(
				parent, getTitle(), this);
		addAbstractGroup(groupComposite);
	}

}
