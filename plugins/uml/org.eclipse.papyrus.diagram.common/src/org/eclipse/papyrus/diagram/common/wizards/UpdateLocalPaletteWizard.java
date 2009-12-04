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

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.papyrus.diagram.common.part.PapyrusPalettePreferences;
import org.eclipse.papyrus.diagram.common.service.PapyrusPaletteService;
import org.eclipse.ui.IEditorPart;

/**
 * Wizard to update an existing Local Palette Definition
 */
public class UpdateLocalPaletteWizard extends Wizard {

	/** Editor part in which the palette is displayed */
	protected IEditorPart editorPart;

	/** content page */
	protected LocalPaletteContentPage contentPage;

	/** info page */
	protected LocalPaletteInformationPage infoPage;

	/** palette configuration to update */
	protected PapyrusPaletteService.LocalProviderDescriptor descriptor;

	/**
	 * Creates a NewLocalPaletteWizard.
	 * 
	 * @param part
	 *        the editor part where the palette is available
	 * @param descriptor
	 *        the descriptor to edit
	 */
	public UpdateLocalPaletteWizard(IEditorPart part, PapyrusPaletteService.LocalProviderDescriptor descriptor) {
		this.editorPart = part;
		this.descriptor = descriptor;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addPages() {
		super.addPages();

		// first paeg: name, id, etc.
		infoPage = new LocalPaletteInformationPage(editorPart);
		infoPage.intializeValues(descriptor);

		// second page: describe the paletteContent
		contentPage = new LocalPaletteContentPage(editorPart);
		contentPage.initializeContent(descriptor);

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

		PapyrusPalettePreferences.deleteLocalPalette(infoPage.getPaletteID());
		// generate the preference for local palette
		PapyrusPalettePreferences.addLocalPalette(infoPage.getPaletteID(), infoPage.getPaletteName(), infoPage
				.getPalettePriority(), infoPage.getEditorID(), contentPage.getRequiredProfiles());
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
