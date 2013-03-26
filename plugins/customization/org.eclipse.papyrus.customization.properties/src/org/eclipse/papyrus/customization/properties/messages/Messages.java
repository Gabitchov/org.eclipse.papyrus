/*****************************************************************************
 * Copyright (c) 2010, 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - Factor out workspace storage for pluggable storage providers (CDO)
 *****************************************************************************/
package org.eclipse.papyrus.customization.properties.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.customization.properties.messages.messages"; //$NON-NLS-1$

	public static String CopyContextAction_Copying;

	public static String CopyContextAction_InitializingTheCopyOf;

	public static String CopyContextAction_ThisMayTakeSomeTime;

	public static String CopyContextAction_To;

	public static String CustomizationDialog_0;

	public static String CustomizationDialog_1;

	public static String CustomizationDialog_2;

	public static String CustomizationDialog_cannotDeletePluginContext;

	public static String CustomizationDialog_configurationName;

	public static String CustomizationDialog_configurationNameNotEmpty;

	public static String CustomizationDialog_configurationWithSameNameExists;

	public static String CustomizationDialog_copy;
	
	public static String CustomizationDialog_copyToWorkspace;

	public static String CustomizationDialog_copyOf;

	public static String CustomizationDialog_createNewCopyByCopy;

	public static String CustomizationDialog_customization;

	public static String CustomizationDialog_delete;

	public static String CustomizationDialog_deleteContext;

	public static String CustomizationDialog_deleteContextConfirmation1;

	public static String CustomizationDialog_deleteContextConfirmation2;

	public static String CustomizationDialog_edit;

	public static String CustomizationDialog_editSelectedContext;

	public static String CustomizationDialog_enterConfigurationName;

	public static String CustomizationDialog_plugin;

	public static String CustomizationDialog_removeSelectedContext;

	public static String CustomizationDialog_selectContextToEdit;

	public static String CustomizationPreferencePage_AskForConfirmation;

	public static String CustomizationPreferencePage_OpenCustomizationPerspective;

	public static String CustomizationPreferencePage_PropertyViewCustomizationPreferences;

	public static String InputDialog_enterConfigurationName;

	public static String Preview_disablePreview;

	public static String Preview_noSelectedView;

	public static String Preview_preview;

	public static String Preview_previewIsDisabled;

	public static String Preview_Unnamed;

	public static String UIEditor_ChangePerspective;

	public static String UIEditor_ChangePerspectiveMessage;

	public static String UIEditor_FilterViews;

	public static String WorkspaceContextDeleteAction_0;

	public static String WorkspaceContextDeleteAction_1;

	public static String WorkspaceContextEditAction_0;

	public static String WorkspaceContextEditAction_1;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
