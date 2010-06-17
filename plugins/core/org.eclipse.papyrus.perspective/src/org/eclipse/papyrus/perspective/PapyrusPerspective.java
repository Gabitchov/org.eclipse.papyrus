/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.perspective;

import org.eclipse.papyrus.navigator.ModelNavigator;
import org.eclipse.papyrus.wizards.CreateModelWizard;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * Perspective for the Papyrus tool.
 * 
 */
public class PapyrusPerspective implements IPerspectiveFactory {

	/** constant for the definition of papyrus model explorer**/
	protected static final String ORG_ECLIPSE_PAPYRUS_MODELEXPLORER = "org.eclipse.papyrus.modelexplorer.modelexplorer";

	/**
	 * 
	 * this method create the layout attached to this perspective
	 * 
	 * @param layout
	 */
	public void createInitialLayout(IPageLayout layout) {
		defineActions(layout);
		defineLayout(layout);
	}

	/**
	 * Add actions into the workbench UI.
	 * 
	 * @param layout
	 *        the page layout
	 * 
	 * @see org.eclipse.ui.IPerspectiveFactory#createInitialLayout(org.eclipse.ui.IPageLayout)
	 */
	public void defineActions(IPageLayout layout) {
		// Add "new wizards".
		layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.project");
		layout.addNewWizardShortcut("org.eclipse.papyrus.wizards.createumlmodel");
		layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.folder");
		layout.addNewWizardShortcut(CreateModelWizard.WIZARD_ID);
		// Add "show views".
		layout.addShowViewShortcut(IPageLayout.ID_PROJECT_EXPLORER);
		layout.addShowViewShortcut(ModelNavigator.ID_MODELNAVIGATOR);
		layout.addShowViewShortcut(IPageLayout.ID_OUTLINE);
		layout.addShowViewShortcut(IPageLayout.ID_PROP_SHEET);

		layout.addActionSet("org.eclipse.debug.ui.launchActionSet");

		// add perspectives
		layout.addPerspectiveShortcut("org.eclipse.ui.resourcePerspective");
		layout.addPerspectiveShortcut("org.eclipse.jdt.ui.JavaPerspective");
	}

	/**
	 * Defines the layout of the perspective (where and which views are available).
	 * 
	 * @param layout
	 *        the page layout
	 * 
	 * @see org.eclipse.ui.IPerspectiveFactory#createInitialLayout(org.eclipse.ui.IPageLayout)
	 */
	public void defineLayout(IPageLayout layout) {
		// Editors are placed for free.
		String editorArea = layout.getEditorArea();

		// Place the Model Explorer and the Resource Navigator to the left of editor area.
		IFolderLayout left = layout.createFolder("left", IPageLayout.LEFT, (float)0.20, editorArea);
		left.addView(ORG_ECLIPSE_PAPYRUS_MODELEXPLORER);
		left.addView(IPageLayout.ID_PROJECT_EXPLORER);
		
		// place outline under the navigator
		IFolderLayout left_bottom = layout.createFolder("left_bottom", IPageLayout.BOTTOM, (float)0.70, "left");
		left_bottom.addView(IPageLayout.ID_OUTLINE);

		// place properties under the editor
		IFolderLayout bottom = layout.createFolder("under", IPageLayout.BOTTOM, (float)0.70, editorArea);
		bottom.addView(IPageLayout.ID_PROP_SHEET);
		// bottom.addView("org.eclipse.pde.runtime.LogView");
	}
}
