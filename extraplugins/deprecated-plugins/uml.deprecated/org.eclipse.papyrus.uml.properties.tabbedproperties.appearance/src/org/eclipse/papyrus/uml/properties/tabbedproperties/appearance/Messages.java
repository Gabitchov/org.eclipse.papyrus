/****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 ****************************************************************************/
package org.eclipse.papyrus.uml.properties.tabbedproperties.appearance;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = Activator.PLUGIN_ID + ".messages"; //$NON-NLS-1$

	public static String GradientSection_Button_ActivateGradient;

	public static String GradientSection_Label_FirstColor;

	public static String GradientSection_Group_Gradient;

	public static String GradientSection_Label_Style;

	public static String GradientSection_Label_Transparency;

	public static String GradientSection_Style_Horizontal;

	public static String GradientSection_Style_Vertical;

	/** label of the set default button in the MaskManagedLabelSection */
	// @unused
	public static String MaskManagedLabelSection_Button_SetDefault;

	/** label of the view preferences button in the MaskManagedLabelSection */
	// @unused
	public static String MaskManagedLabelSection_Button_ViewPreference;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
