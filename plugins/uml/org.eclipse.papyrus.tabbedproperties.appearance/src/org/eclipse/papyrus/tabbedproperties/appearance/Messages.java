/****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 ****************************************************************************/
package org.eclipse.papyrus.tabbedproperties.appearance;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.papyrus.tabbedproperties.appearance.messages"; //$NON-NLS-1$
	public static String GradientSection_Button_IsGradientUsed;
	public static String GradientSection_Command_Change_Gradient;
	public static String GradientSection_Command_Change_Transparency;
	public static String GradientSection_GradientColor_FirstColor;
	public static String GradientSection_GradientColor_SecondColor;
	public static String GradientSection_Group_Colors;
	public static String GradientSection_Group_Gradient;
	public static String GradientSection_Group_Style;
	public static String GradientSection_Group_Transparency;
	public static String GradientSection_Style_Horizontal;
	public static String GradientSection_Style_Vertical;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
