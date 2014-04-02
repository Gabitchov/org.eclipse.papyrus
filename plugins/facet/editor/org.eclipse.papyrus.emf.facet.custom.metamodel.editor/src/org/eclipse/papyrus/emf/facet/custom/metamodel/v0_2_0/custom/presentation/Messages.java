/*******************************************************************************
 * Copyright (c) 2009, 2010 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Bros (Mia-Software) - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.presentation;

import org.eclipse.osgi.util.NLS;

public final class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.papyrus.emf.facet.custom.metamodel.editor.messages"; //$NON-NLS-1$

	public static String CustomizationEditor_add;
	public static String CustomizationEditor_appliesToSubInstances;
	public static String CustomizationEditor_bold;
	public static String CustomizationEditor_btnOpenElementSelectionDialogText;
	public static String CustomizationEditor_btnOpenFontDialogText;
	public static String CustomizationEditor_btnProperties;
	public static String CustomizationEditor_btnTooltipViewErrors;
	public static String CustomizationEditor_cannotFindMetamodel;

	public static String CustomizationEditor_changeProperties;
	public static String CustomizationEditor_collapseLink;

	public static String CustomizationEditor_conditions;

	public static String CustomizationEditor_conflictingUnsavedChanges;
	public static String CustomizationEditor_customizationsWillBeDeleted;

	public static String CustomizationEditor_customViewFor;
	public static String CustomizationEditor_down;
	public static String CustomizationEditor_edit;
	public static String CustomizationEditor_editFeatureValue;
	public static String CustomizationEditor_error;
	public static String CustomizationEditor_errorLoadingResource;

	public static String CustomizationEditor_fileConflict;
	public static String CustomizationEditor_hideMetaclassName;
	public static String CustomizationEditor_iconSelection;
	public static String CustomizationEditor_invalidSelection;
	public static String CustomizationEditor_italic;
	public static String CustomizationEditor_missingQuery;
	public static String CustomizationEditor_missingQuerySet;
	public static String CustomizationEditor_nonExistingQuery;
	public static String CustomizationEditor_nonExistingQuerySet;
	public static String CustomizationEditor_notFileSelected;
	public static String CustomizationEditor_promptCleanCustomizations;
	public static String CustomizationEditor_readonly;
	public static String CustomizationEditor_remove;

	public static String CustomizationEditor_removeIrrelevantCustomizations;

	public static String CustomizationEditor_resetDefaults;
	public static String CustomizationEditor_sectionName_customizations;
	public static String CustomizationEditor_sectionName_types;
	public static String CustomizationEditor_selectAnIcon;
	public static String CustomizationEditor_strikethrough;
	public static String CustomizationEditor_text;
	public static String CustomizationEditor_Title_cleanCustomization;
	public static String CustomizationEditor_underlined;
	public static String CustomizationEditor_unknown;
	public static String CustomizationEditor_up;
	public static String CustomizationEditor_visible;
	public static String CustomizationEditor_metaclassVisible;
	public static String CustomizationEditor_youChangedMetamodel;
	public static String CustomizationPropertiesDialog_customizationProperties;
	public static String CustomizationPropertiesDialog_metamodel;
	public static String CustomizationPropertiesDialog_metamodelMustBeSelected;
	public static String CustomizationPropertiesDialog_noMetamodelSelected;
	public static String CustomizationPropertiesDialog_querySets;
	public static String CustomizationViewer_backgroundColor;

	public static String CustomizationViewer_collapseLink;
	public static String CustomizationViewer_defaultValue;
	public static String CustomizationViewer_feature;
	public static String CustomizationViewer_hideMetaclassName;
	public static String CustomizationViewer_typeIcon;
	public static String CustomizationViewer_isBold;
	public static String CustomizationViewer_isItalic;
	public static String CustomizationViewer_isStruckthrough;
	public static String CustomizationViewer_isUnderlined;
	public static String CustomizationViewer_isVisible;
	public static String CustomizationViewer_label;
	public static String CustomizationViewer_instanceIcon;
	public static String CustomizationViewer_overlayIcon;
	public static String CustomizationViewer_textColor;
	public static String CustomizationViewer_textFontName;
	public static String CustomizationViewer_value;
	public static String CustomizationViewer_metaclassVisible;
	public static String ErrorsDialog_diagnosticMessage;
	public static String ErrorsDialog_errors;
	public static String MetaclassViewToolBar_showDerivedLinks;
	public static String MetaclassViewToolBar_showFullQualifiedNames;
	public static String MetaclassViewToolBar_showMultiplicity;
	public static String MetaclassViewToolBar_sortLinks;
	public static String MetaclassViewToolBar_sortLinksByType;
	public static String EditFeatureValueDialog_conditionQueryMustBeSelected;
	public static String EditFeatureValueDialog_defaultValue;
	public static String EditFeatureValueDialog_editFeatureValue;
	public static String EditFeatureValueDialog_featureValue;
	public static String EditFeatureValueDialog_noConditionQuerySelected;
	public static String EditFeatureValueDialog_noQuerySelected;
	public static String EditFeatureValueDialog_queryForCondition;
	public static String EditFeatureValueDialog_queryMustBeSelected;
	public static String EditFeatureValueDialog_queryValue;
	public static String EditFeatureValueDialog_staticValue;
	public static String EditFeatureValueDialog_type;

	static {
		// initialize resource bundle
		NLS.initializeMessages(Messages.BUNDLE_NAME, Messages.class);
	}

	private Messages() {
		// not instantiable
	}
}
