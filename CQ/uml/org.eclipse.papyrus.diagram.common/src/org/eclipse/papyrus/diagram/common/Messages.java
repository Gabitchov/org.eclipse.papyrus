/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "messages"; //$NON-NLS-1$

	public static String ElementImportParser_undefined_value;

	public static String IconStylePreferencePage_cheerful_style;

	public static String IconStylePreferencePage_eclipse_style;

	public static String IconStylePreferencePage_icon_style_group;

	public static String ModelElementSelectionPageMessage;

	public static String UMLNewDiagramFileWizard_RootSelectionPageSelectionTitle;

	public static String UMLNewDiagramFileWizard_RootSelectionPageNoSelectionMessage;

	public static String UMLNewDiagramFileWizard_RootSelectionPageInvalidSelectionMessage;

	public static String UMLNewDiagramFileWizard_CreationPageName;

	public static String UMLNewDiagramFileWizard_CreationPageTitle;

	public static String UMLNewDiagramFileWizard_CreationPageDescription;

	public static String UMLNewDiagramFileWizard_RootSelectionPageName;

	public static String UMLNewDiagramFileWizard_RootSelectionPageTitle;

	public static String UMLNewDiagramFileWizard_RootSelectionPageDescription;

	public static String UMLNewDiagramFileWizard_InitDiagramCommand;

	public static String UMLDiagramEditorUtil_CreateDiagramProgressTask;

	public static String UMLDiagramEditorUtil_CreateDiagramCommandLabel;

	public static String UMLInitDiagramFileAction_InitDiagramFileResourceErrorDialogTitle;

	public static String UMLInitDiagramFileAction_InitDiagramFileResourceErrorDialogMessage;

	public static String UMLInitDiagramFileAction_InitDiagramFileWizardTitle;

	public static String UMLNewDiagramFileWizard_DiagramKindTitle;

	public static String UMLNewDiagramFileWizard_DiagramKindDescription;

	public static String RotateAction_rotate_command;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
