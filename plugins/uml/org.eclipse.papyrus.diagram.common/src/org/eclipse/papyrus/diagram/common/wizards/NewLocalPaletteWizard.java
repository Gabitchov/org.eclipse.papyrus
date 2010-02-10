/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.diagram.common.wizards;

import org.eclipse.gef.ui.palette.PaletteCustomizer;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.papyrus.diagram.common.part.PapyrusPalettePreferences;
import org.eclipse.ui.IEditorPart;

/**
 * Wizard to create a new Local Palette Definition from scratch
 */
public class NewLocalPaletteWizard extends Wizard {

	/** Editor part in which the new palette will be created */
	protected IEditorPart editorPart;

	/** palette customizer */
	protected PaletteCustomizer customizer;

	/** content page */
	protected LocalPaletteContentPage contentPage;

	/** info page */
	protected LocalPaletteInformationPage infoPage;

	/**
	 * Creates a NewLocalPaletteWizard.
	 * 
	 * @param part
	 *        the editor part where the palette will be available
	 */
	public NewLocalPaletteWizard(IEditorPart part, PaletteCustomizer customizer) {
		this.editorPart = part;
		this.customizer = customizer;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addPages() {
		super.addPages();

		// first paeg: name, id, etc.
		infoPage = new LocalPaletteInformationPage(editorPart);
		// initialize values
		infoPage.intializeValues();

		// second page: describe the paletteContent
		contentPage = new LocalPaletteContentPage(editorPart, customizer);
		contentPage.initializeContent();

		addPage(infoPage);
		addPage(contentPage);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean performFinish() {
		// contentPage.restorePreferences();
		// file has been created or updated
		contentPage.performFinish(PapyrusPalettePreferences.getPalettePathFromID(infoPage.getPaletteID()));

		// generate the preference for local palette
		PapyrusPalettePreferences.addLocalPalette(infoPage.getPaletteID(), infoPage.getPaletteName(), infoPage.getPalettePriority(), infoPage.getEditorID(), contentPage.getRequiredProfiles());
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean performCancel() {
		// contentPage.restorePreferences();
		return super.performCancel();
	}

}
