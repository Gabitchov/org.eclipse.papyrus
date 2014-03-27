/**
 * Copyright (c) 2011, 2012 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	  Nicolas Guyomar (Mia-Software) - Bug 349546 - EMF Facet facetSet editor
 *    Nicolas Bros (Mia-Software) - Bug 370442 - rewrite the Facet loading dialog for v0.2
 *    Grégoire Dupé (Mia-Software) - copied from org.eclipse.papyrus.emf.facet.infra.query.ui.Messages
 *    Nicolas Bros (Mia-Software) - copied from org.eclipse.papyrus.emf.facet.infra.query.ui.Messages
 *    Gregoire Dupe (Mia-Software) - Bug 364325 - [Restructuring] The user must be able to navigate into a model using the Facet.
 *    Nicolas Bros (Mia-Software) - Bug 372732 - [Facet] Rewrite the catalog views for 0.2
 *    Nicolas Bros (Mia-Software) - Bug 372865 - FacetSet selection dialog
 *    Vincent Lorenzo (CEA-LIST) - Bug 357621 - Improve the label displayed for Customization and Facets
 *    Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *    Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.messages"; //$NON-NLS-1$

	public static String New;

	public static String Enter_a_nsUri;
	public static String Please_enter_nsUri;

	public static String Enter_a_prefix;
	public static String ETypedElementSelectionControl_ClassicView;

	public static String ETypedElementSelectionControl_invalidSelectionAtLeastOneElement;
	public static String ETypedElementSelectionControl_invalidSelection;
	public static String ETypedElementSelectionControl_invalidSelectionAtMostXElements;
	public static String ETypedElementSelectionControl_invalidSelectionETypedElementsOnly;
	public static String ETypedElementSelectionDialog_dialogTitle;
	public static String ETypedElementSelectionDialog_dialogTitleMultiSelection;
	public static String ETypedElementSelectionDialog_radioButtonMultiSelection;
	public static String ETypedElementSelectionDialog_radioButtonNoSelection;
	public static String ETypedElementSelectionDialog_radioButtonSingleSelection;

	public static String ETypedElementSelectionSortedControl_metamodelView;

	public static String ETypedElementSelectionSortedControl_toolTip;

	public static String Please_enter_prefix;

	public static String Please_select_EPackage;
	public static String Select_EPackage;
	
	public static String Select_ETypedElement;
	
	public static String Select_query_type;

	public static String Operation;
	public static String Parameter_name;
	public static String Operation_name;
	public static String Reference_name;
	public static String Attribute_name;

	public static String Add_an_Attribute;
	public static String Add_an_Attribute_desc;
	public static String Add_a_Reference;
	public static String Add_a_Reference_desc;
	public static String Add_an_Operation;
	public static String Add_an_Operation_desc;
	public static String Add_an_Operation_Parameter;
	public static String Add_an_Operation_Parameter_desc;

	public static String FacetSet;
	public static String FacetSet_mustSelectFacetSet;
	public static String FacetSet_mustGiveFacetSetName;
	public static String FacetSetsCatalogView_categoriesColumn;
	public static String FacetSetsCatalogView_documentationColumn;
	public static String FacetSetsCatalogView_extendsColumn;
	public static String FacetSetsCatalogView_nameColumn;
	public static String FacetSetsCatalogView_viewTitle;
	public static String FacetSetSelectionControl_mustSelectAtLeastOneElement;
	public static String FacetSetSelectionControl_mustSelectAtMostNElements;
	public static String FacetSetSelectionControl_onlyFacetSetsAllowedInSelection;
	public static String FacetSetSelectionControl_selectionContainsInvalidElements;
	public static String FacetSetSelectionDialog_deselectAll;
	public static String FacetSetSelectionDialog_selectAll;
	public static String FacetSetSelectionDialog_titleSelectFacetSet;
	public static String FacetSetSelectionDialog_titleSelectFacetSets;
	public static String Facet;
	public static String Facet_mustGiveFacetName;
	public static String Facet_mustGiveReferenceName;
	public static String Facet_mustGiveOperationName;
	public static String Facet_mustGivePrameterName;
	public static String Facet_mustSelectQuery;
	public static String Facet_mustSelectConformanceType;

	public static String GetOrCreate_FacetSet_message;
	public static String GetOrCreate_Facet_message;
	public static String Select_FacetSet;
	public static String Select_Facet;
	public static String GetOrCreate_Operation_message;
	public static String Select_Operation;
	public static String Facet_mustSelectFacet;
	public static String Facet_mustGiveAttributeName;
	public static String Type_mustSelectType;
	public static String Operation_mustSelectOperation;

	public static String Changeable;
	public static String Derived;
	public static String Ordered;
	public static String Transient;
	public static String Unique;
	public static String Volatile;

	public static String Lower_bound;
	public static String Upper_bound;

	public static String Select_EClass;
	public static String Select_EClassifier;
	public static String Select_EDataType;

	public static String No_result_found;

	public static String Select;
	public static String Type;

	public static String Create_FacetSet_Model;

	public static String CreateFacetInFacetSetWidget_FacetSetName;

	public static String CreateFacetInFacetSetWizardPage_could_not_find_wizard_page;
	public static String Please_enter_value_for;
	public static String Create_facet_in_facetSet;
	public static String Create_facetSet_in_facetSet;

	public static String Create;
	public static String CreateFacetInFacetSetWizardPage_Please_fill_extendedMetaClass;
	public static String CreateFacetInFacetSetWizardPage_Sub_Typing_Facet;
	public static String CreateFacetInFacetSetWizardPage_wizard_description;
	public static String CreateFacetSetWizardImpl_Create_new_facet_Set;
	public static String CreateFacetSetWizardImpl_FacetModel;
	public static String CreateFacetSetWizardImpl_File_extension_restriction;

	public static String CreateFacetSetWizardPage_Not_a_Plugin_project;
	public static String Create_Query;
	public static String FilteredElementSelectionControl_type_filter_text;
	public static String Load_MetaModel_Resource;
	public static String FacetSetSelectionDialog_selectFacetSetsMessage;
	public static String FacetSetSelectionDialog_selectFacetSetsTitle;
	public static String Package_Selection;
	public static String Select_Registered_URI;

	public static String SelectQueryTypeWizardPage_No_wizard_found;
	public static String SelectQueryTypeWizardPage_Query_Type;
	public static String JavaQueryWizardPage_Can_be_cached;
	public static String JavaQueryWizardPage_has_side_effect;
	public static String JavaQueryWizardPage_Query_name;
	public static String Query_Select_Name_And_Type;
	
	//Begin copied from org.eclipse.papyrus.emf.facet.infra.query.ui.Messages
	public static String Query_name;
	public static String QueryExecutionView_0;
	public static String QueryExecutionView_1;
	public static String QueryExecutionView_classpathWarning;
	public static String QueryExecutionView_errorInBundleClasspath;
	public static String QueryExecutionView_execEnvNotAvailable;
	public static String QueryExecutionView_execEnvError;
	public static String QueryExecutionView_Context;
	public static String QueryExecutionView_DisplayResultIn;
	public static String QueryExecutionView_dragAndDropHint;
	public static String QueryExecutionView_ErrorExecutingQuery;

	public static String QueryExecutionView_ETypeElementsGroup;
	public static String QueryExecutionView_ExecuteButton;
	public static String QueryExecutionView_ExecuteGroup;
	public static String QueryExecutionView_NoQueryDisplayer;
	public static String QueryExecutionView_NoQuerySelected;
	public static String QueryExecutionView_NullQueryResult;
	public static String QueryExecutionView_notImplementedYet;
	public static String QueryExecutionView_Parameters;
	public static String QueryExecutionView_Query;
	public static String QueryExecutionView_QueryException;
	public static String QueryExecutionView_QueryReturnedNull;
	public static String QueryExecutionView_SelectQueryToExecute;
	public static String QuerySelectionDialog_createQuery;
	public static String QuerySelectionDialog_enableQuery;
	public static String QuerySelectionDialog_refreshQuerySetsJob;
	public static String QuerySelectionDialog_selectQuery;
	
	public static String Query_Query_Name;
	public static String Query_has_side_effect;
	public static String Query_Can_be_cached;

	public static String Metaclass_mustSelectMetaclass;
	public static String ExtendedMetaClass;

	//End copied from org.eclipse.papyrus.emf.facet.infra.query.ui.Messages

	// Edition
	public static String Edit_FacetSet;
	public static String Edit_Facet;
	public static String Edit_FacetAttribute;
	public static String Edit_FacetReference;
	public static String Edit_FacetOperation;
	public static String Edit_FacetOperationParameter;

	public static String EditFacetSetWidget_FacetSetName;

	public static String EditFacetWidget_FacetName;

	public static String GetSubTypingType_message;
	public static String GetSubTypingType_title;

	public static String FacetSetPropertyWizardPage_facet_properties;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(Messages.BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
