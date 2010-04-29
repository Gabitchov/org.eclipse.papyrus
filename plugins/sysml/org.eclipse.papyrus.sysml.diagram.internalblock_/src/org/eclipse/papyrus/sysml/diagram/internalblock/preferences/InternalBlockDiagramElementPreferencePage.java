/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.preferences;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.gmf.runtime.notation.GradientStyle;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.preferences.pages.AbstractPapyrusNodePreferencePage;
import org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.sysml.diagram.internalblock.Activator;
import org.eclipse.swt.graphics.RGB;

public class InternalBlockDiagramElementPreferencePage extends AbstractPapyrusNodePreferencePage {

	public static void initDefaults(IPreferenceStore store, String elementName) {

		// Retrieve preference constants
		String COLOR_FILL = PreferenceConstantHelper.getElementConstant(elementName, PreferenceConstantHelper.COLOR_FILL);
		String COLOR_LINE = PreferenceConstantHelper.getElementConstant(elementName, PreferenceConstantHelper.COLOR_LINE);
		String GRADIENT_POLICY = PreferenceConstantHelper.getElementConstant(elementName, PreferenceConstantHelper.GRADIENT_POLICY);
		String COLOR_GRADIENT = PreferenceConstantHelper.getElementConstant(elementName, PreferenceConstantHelper.COLOR_GRADIENT);

		// Retrieve some basic color constants
		RGB RGB_WHITE = ColorConstants.white.getRGB();
		RGB RGB_BLACK = ColorConstants.black.getRGB();

		PreferenceConverter.setDefault(store, COLOR_FILL, RGB_WHITE);
		PreferenceConverter.setDefault(store, COLOR_LINE, RGB_BLACK);

		// Set the default for the gradient
		store.setDefault(GRADIENT_POLICY, false);

		int DEFAULT_TRANSPARENCY = 0;
		GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(RGB_BLACK, RGB_WHITE, GradientStyle.VERTICAL, DEFAULT_TRANSPARENCY);
		store.setDefault(COLOR_GRADIENT, gradientPreferenceConverter.getPreferenceValue());

	}

	@Override
	protected String getBundleId() {
		return Activator.PLUGIN_ID;
	}
}
