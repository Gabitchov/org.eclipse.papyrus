/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *      Nicolas Bros (Mia-Software) - Bug 375388 - Cell editor for IImage
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *******************************************************************************/
package org.eclipse.emf.facet.custom.sdk.ui.internal;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.emf.facet.custom.sdk.ui.internal.messages"; //$NON-NLS-1$
	public static String ImageComposite_fullImage;
	public static String Create_Customization_Model;
	public static String CreateCustomizationWizardImpl_customization;
	public static String CreateCustomizationWizardImpl_customization_properties;
	public static String CreateCustomizationWizardImpl_Create_new_customization;
	public static String CreateCustomizationWizardImpl_File_extension_restriction;
	public static String CreateCustomizationWizardPage_Not_a_Plugin_project;

	public static String Enter_a_nsUri;
	public static String Enter_a_prefix;
	public static String Please_enter_nsUri;
	public static String Please_enter_prefix;
	public static String Please_select_EPackage;

	public static String CreateEClassCustomizationDialog_Message;
	public static String CreateEClassCustomizationDialog_Title;

	public static String CreateFacetCustomizationDialog_Message;
	public static String CreateFacetCustomizationDialog_Title;

	public static String ExtendedMetaClass;
	public static String Metaclass_mustSelectMetaclass;

	public static String Customization;
	public static String Customization_mustSelectCustomization;
	public static String Customization_mustGiveCustomizationName;

	public static String GetOrCreate_customization_message;
	public static String Select_Customization;

	public static String Facet_mustSelectFacet;
	public static String ExtendedFacet;
	public static String CustomizedFacet;
	public static String CustomizedFacet_mustSelectCustomizedFacet;

	public static String OperationFacet;
	public static String OperationFacet_mustSelectOperationFacet;

	public static String Add_Customization_title;
	public static String Add_Customization_message;

	public static String Query_case_name;
	public static String Query_case_type;

	public static String Get_customization_property_message;
	public static String Select_Customization_property;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
