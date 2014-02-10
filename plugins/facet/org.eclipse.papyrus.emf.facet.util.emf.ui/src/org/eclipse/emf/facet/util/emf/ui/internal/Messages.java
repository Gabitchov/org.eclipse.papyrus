/**
 * Copyright (c) 2011, 2012 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Nicolas Guyomar (Mia-Software) - Bug 333652 Extension point offering the possibility to declare an EPackage browser
 *  Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *  Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *  Gregoire Dupe (Mia-Software) - Bug 406570 - Handlers to Save and SaveAs EMF resources
 */
package org.eclipse.emf.facet.util.emf.ui.internal;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.emf.facet.util.emf.ui.internal.messages"; //$NON-NLS-1$
	public static String CreateInstanceDialog_selectNewInstanceEClass;
	public static String PackageRegistryView_initializing;
	public static String PackageRegistryView_copyNsURI;
	public static String PackageRegistryView_RefreshingPackageRegistryView;
	public static String PackageRegistryView_nsURI;
	public static String PackageRegistryView_Location;
	public static String PackageRegistryView_Name;
	public static String DialogUriSelection_RegisteredEPackages;
	public static String DialogUriSelection_title_OpenModelFromEMFRegistry;
	public static String EmfFacetRootPreferencePage_default_epackage_browser;
	public static String EPackageBrowserPreferencePage_defaultEObjectViewer;
	public static String EPackageBrowserPreferencePage_defaultResourceViewer;

	public static String Select_EClass;
	public static String Select_EDataType;
	public static String Select_EClassifier;
	public static String Select_ETypedElement;
	public static String Select_EPackage;

	public static String ResourceUiUtils_SavingFailed;
	public static String ResourceUiUtils_TheResourceSavingFailed;
	public static String SaveAsDialog_ResourceURI;
	public static String SaveAsDialog_SaveAs;
	public static String SaveAsDialog_YouHaveToProvideAValidEMFURI;

	public static String No_result_found;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
