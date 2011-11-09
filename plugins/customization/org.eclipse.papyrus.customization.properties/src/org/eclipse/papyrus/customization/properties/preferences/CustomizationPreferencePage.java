/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.properties.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.customization.properties.Activator;
import org.eclipse.papyrus.customization.properties.messages.Messages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * This page handles preferences for dialog boxes
 * 
 * @author Camille Letavernier
 */
public class CustomizationPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	/**
	 *
	 */
	public final static String OPEN_CUSTOMIZATION_PERSPECTIVE = "openCustomizationPerspective"; //$NON-NLS-1$

	/**
	 * 
	 */
	public final static String ASK_FOR_CONFIRMATION = "askForConfirmation"; //$NON-NLS-1$

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public CustomizationPreferencePage() {
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param style
	 */
	public CustomizationPreferencePage(int style) {
		super(style);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param title
	 * @param style
	 */
	public CustomizationPreferencePage(String title, int style) {
		super(title, style);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param title
	 * @param image
	 * @param style
	 */
	public CustomizationPreferencePage(String title, ImageDescriptor image, int style) {
		super(title, image, style);
	}

	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription(Messages.CustomizationPreferencePage_PropertyViewCustomizationPreferences);
	}

	@Override
	protected void createFieldEditors() {
		addField(new BooleanFieldEditor(OPEN_CUSTOMIZATION_PERSPECTIVE, Messages.CustomizationPreferencePage_OpenCustomizationPerspective, getFieldEditorParent()));
		addField(new BooleanFieldEditor(ASK_FOR_CONFIRMATION, Messages.CustomizationPreferencePage_AskForConfirmation, getFieldEditorParent()));
	}

	/**
	 * Indicates if the customization perspective should be opened
	 * 
	 * @return true if the customization perspective should be opened
	 */
	public static boolean openCustomizationPerspective() {
		return Activator.getDefault().getPreferenceStore().getBoolean(OPEN_CUSTOMIZATION_PERSPECTIVE);
	}

	/**
	 * Indicates if a dialog should ask the user for a confirmation before opening
	 * the customization perspective
	 * 
	 * @return true if a user confirmation is needed
	 */
	public static boolean askForConfirmation() {
		return Activator.getDefault().getPreferenceStore().getBoolean(ASK_FOR_CONFIRMATION);
	}
}
