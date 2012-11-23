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
package org.eclipse.papyrus.uml.perspective;

import org.eclipse.papyrus.uml.diagram.wizards.CreateModelWizard;
import org.eclipse.papyrus.uml.diagram.wizards.NewPapyrusProjectWizard;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * Perspective for the Papyrus tool.
 */
public class PapyrusPerspective implements IPerspectiveFactory {

	/** constant for the definition of papyrus model explorer **/
	protected static final String ID_MODELEXPLORER = "org.eclipse.papyrus.views.modelexplorer.modelexplorer";

	public static final String ID_BOTTOM_FOLDER = "org.eclipse.papyrus.perspective.folder.bottom";

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
		layout.addNewWizardShortcut(NewPapyrusProjectWizard.WIZARD_ID);
		layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.folder");
		layout.addNewWizardShortcut(CreateModelWizard.WIZARD_ID);
		// Add "show views".
		layout.addShowViewShortcut(IPageLayout.ID_PROJECT_EXPLORER);
		layout.addShowViewShortcut(IPageLayout.ID_OUTLINE);
		layout.addShowViewShortcut(IPageLayout.ID_PROP_SHEET);
		layout.addShowViewShortcut(ID_MODELEXPLORER);
		layout.addShowViewShortcut(IPageLayout.ID_PROBLEM_VIEW);
		layout.addShowViewShortcut("org.eclipse.pde.runtime.LogView"); //Error log. //A constant doesn't seem to exist for this ID

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

		// Place the the Resource Navigator to the top left of editor area.
		layout.addView(IPageLayout.ID_PROJECT_EXPLORER, IPageLayout.LEFT, 0.2f, editorArea);

		// Place the ModelExplorer under the Navigator
		layout.addView(ID_MODELEXPLORER, IPageLayout.BOTTOM, 0.33f, IPageLayout.ID_PROJECT_EXPLORER);

		// place outline under the model explorer
		layout.addView(IPageLayout.ID_OUTLINE, IPageLayout.BOTTOM, 0.5f, ID_MODELEXPLORER);

		// place properties and problem views under the editor
		IFolderLayout bottomFolder = layout.createFolder(ID_BOTTOM_FOLDER, IPageLayout.BOTTOM, 0.70f, editorArea);

		bottomFolder.addView(IPageLayout.ID_PROP_SHEET);
		bottomFolder.addView(IPageLayout.ID_PROBLEM_VIEW);

		// bottom.addView("org.eclipse.pde.runtime.LogView");
	}
}
