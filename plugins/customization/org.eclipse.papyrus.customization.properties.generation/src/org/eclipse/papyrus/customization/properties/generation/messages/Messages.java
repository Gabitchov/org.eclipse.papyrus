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
package org.eclipse.papyrus.customization.properties.generation.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.customization.properties.generation.messages.messages"; //$NON-NLS-1$

	public static String EcoreGenerator_ecoreGeneratorDescription;

	public static String EcoreGenerator_ecoreGeneratorName;

	public static String EcoreGenerator_source;

	public static String EditContextGenerator_generateNewContext;

	public static String EditContextGenerator_importExistingContext;

	public static String ProfileGenerator_description;

	public static String ProfileGenerator_name;

	public static String ProfileGenerator_source;

	public static String StandardLayoutGenerator_name;

	public static String CreateContextMainPage_description;

	public static String CreateContextMainPage_title;

	public static String CreateContextWizard_pageTitle;

	public static String CreateContextWizard_propertyViewGenerationError;

	public static String CreateContextWizard_propertyViewGenerationJobName;

	public static String GeneratorPage_layoutGenerator;

	public static String GeneratorPage_target;

	public static String GeneratorPage_title;

	public static String SelectFieldsPage_availableFields;

	public static String SelectFieldsPage_description;

	public static String SelectFieldsPage_descriptionNotAvailable;

	public static String SelectFieldsPage_displayMultiple;

	public static String SelectFieldsPage_displaySingle;

	public static String SelectFieldsPage_field;

	public static String SelectFieldsPage_selectFields;

	public static String SelectFieldsPage_title;

	public static String SelectOutputPage_0;

	public static String SelectOutputPage_1;

	public static String SelectOutputPage_2;

	public static String SelectOutputPage_3;

	public static String SelectOutputPage_4;

	public static String SourceValidator_2;

	public static String SourceValidator_4;

	public static String SourceValidator_5;

	public static String SourceValidator_6;

	public static String SourceValidator_7;

	public static String FileChooser_browseWorkspace;

	public static String TargetValidator_2;

	public static String TargetValidator_3;

	public static String TernaryButton_defaultFalse;

	public static String TernaryButton_defaultTrue;

	public static String TernaryButton_false;

	public static String TernaryButton_true;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
