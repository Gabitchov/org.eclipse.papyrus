/*******************************************************************************
 * Copyright (c) 2009 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 *    Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *    Nicolas Bros (Mia-Software) - Bug 372732 - [Facet] Rewrite the catalog views for 0.2
 *    Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *    Vincent Lorenzo (CEA-LIST) - Bug 373255 - Add tooltips providing a documentation for the selected elements in the Select ETypedElement Dialog
 *******************************************************************************/
package org.eclipse.emf.facet.custom.ui.internal;

import org.eclipse.osgi.util.NLS;

public final class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.emf.facet.custom.ui.internal.messages"; //$NON-NLS-1$
	public static String CustomizationsCatalogView_title;
	public static String CustomizationsView_allQuerySets;
	public static String CustomizationsView_jobName_RefreshCustomizationsView;
	public static String CustomizationsView_extendsColumn;
	public static String CustomizationsView_nameColumn;
	public static String CustomizationsView_documentationColumn;
	public static String CustomizedLabelProvider_null;
	public static String NewCustomizationFilePage_browserCustomization;
	public static String NewCustomizationFilePage_createsBrowserCustomization;
	public static String NewCustomizationFilePage_customizationInNonEmfFacetProject;
	public static String NewCustomizationWizard_newBrowserCustomization;
	public static String QuerySetsSelectionControl_allExistingQuerySets;
	public static String QuerySetsSelectionControl_availableQuerySets;
	public static String QuerySetsSelectionControl_deselectAll;
	public static String QuerySetsSelectionControl_querySetsSelectedBelowOnly;
	public static String QuerySetsSelectionControl_selectAll;
	public static String SelectMetamodelsPage_selectMetamodel;
	public static String SelectMetamodelsPage_selectMetamodelToCustomize;
	public static String SelectQuerySetsPage_selectAvailableQuerySets;
	public static String SelectQuerySetsPage_selectAvailableQuerySetsInCustomization;
	public static String LoadCustomizationsDialog_Add;
	public static String LoadCustomizationsDialog_Add2;
	public static String LoadCustomizationsDialog_AddAll;
	public static String LoadCustomizationsDialog_AddAll2;
	public static String LoadCustomizationsDialog_AvailiableCustom;
	public static String LoadCustomizationsDialog_Can_not_be_unload;
	public static String LoadCustomizationsDialog_Down;
	public static String LoadCustomizationsDialog_LoadedCustomizations;
	public static String LoadCustomizationsDialog_LoadCustomizationWarning;
	public static String LoadCustomizationsDialog_Loading;
	public static String LoadCustomizationsDialog_loadReferencedFacetsCheckbox;
	public static String LoadCustomizationsDialog_OK;
	public static String LoadCustomizationsDialog_Remove;
	public static String LoadCustomizationsDialog_Remove2;
	public static String LoadCustomizationsDialog_RemoveAll;
	public static String LoadCustomizationsDialog_RemoveAll2;
	public static String LoadCustomizationsDialog_title_LoadCustomizations;
	public static String LoadCustomizationsDialog_type_filter_test;
	public static String LoadCustomizationsDialog_Up;
	public static String ToolTipTextQuery_Documentation;
	public static String ToolTipTextQuery_NoDocumentation;
	static {
		// initialize resource bundle
		NLS.initializeMessages(Messages.BUNDLE_NAME, Messages.class);
	}

	private Messages() {
		// cannot be instantiated
	}
}
