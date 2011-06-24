/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.customization.messages.messages"; //$NON-NLS-1$

	public static String UICustomExtensionFactory_UICustom;

	public static String ModelTemplateExtensionFactory_ModelTemplate;

	public static String PluginGenerator_factoryNotFound;

	public static String ProfileExtensionFactory_Profile;

	public static String PropertyViewExtensionFactory_Copying;

	public static String PropertyViewExtensionFactory_InitializingCopy;

	public static String PropertyViewExtensionFactory_PropertyView;

	public static String PropertyViewExtensionFactory_To;

	public static String PropertyViewExtensionFactory_WaitMessage;

	public static String UMLModelExtensionFactory_UMLModel;

	public static String CreateNewCustomizationPluginWizard_CustomizationPlugin;

	public static String CustomizationPage_Customization;

	public static String EnvironmentExtensionFactory_PropertyViewEnvironment;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
