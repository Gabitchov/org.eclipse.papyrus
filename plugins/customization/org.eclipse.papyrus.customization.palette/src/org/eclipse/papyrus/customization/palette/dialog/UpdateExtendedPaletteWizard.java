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

package org.eclipse.papyrus.customization.palette.dialog;

import org.eclipse.gef.ui.palette.PaletteCustomizer;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditorWithFlyOutPalette;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.papyrus.uml.diagram.common.part.PapyrusPalettePreferences;
import org.eclipse.papyrus.uml.diagram.common.service.PapyrusPaletteService;
import org.eclipse.ui.IEditorPart;

/**
 * Wizard to update an existing Extended Palette Definition
 */
public class UpdateExtendedPaletteWizard extends Wizard {

	/** Editor part in which the palette is displayed */
	protected IEditorPart editorPart;

	/** content page */
	protected ExtendedPaletteContentPage contentPage;

	/** info page */
	protected ExtendedPaletteInformationPage infoPage;

	/** palette configuration to update */
	protected PapyrusPaletteService.ExtendedProviderDescriptor descriptor;

	/** customizer used by the palette viewer */
	private PaletteCustomizer customizer;

	/**
	 * Creates a NewLocalPaletteWizard.
	 * 
	 * @param part
	 *        the editor part where the palette is available
	 * @param descriptor
	 *        the descriptor to edit
	 */
	public UpdateExtendedPaletteWizard(IEditorPart part, PapyrusPaletteService.ExtendedProviderDescriptor descriptor, PaletteCustomizer customizer) {
		this.editorPart = part;
		this.descriptor = descriptor;
		this.customizer = customizer;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addPages() {
		super.addPages();

		// first paeg: name, id, etc.
		infoPage = new ExtendedPaletteInformationPage(editorPart);
		infoPage.intializeValues(descriptor);

		// second page: describe the paletteContent
		contentPage = new ExtendedPaletteContentPage(editorPart, customizer);
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

		//PapyrusPalettePreferences.unregisterLocalRedefinition(infoPage.getPaletteID());
		// generate the preference for local palette
		String path = PapyrusPalettePreferences.getPaletteRedefinition(infoPage.getPaletteID());
		PapyrusPalettePreferences.registerLocalRedefinition(infoPage.getPaletteID(), path); // if already exists: removes, then add 

		// toggle visiblity to refresh the content
		if(editorPart instanceof DiagramEditorWithFlyOutPalette) {
			PapyrusPalettePreferences.changePaletteVisibility(infoPage.getPaletteID(), editorPart, false);
			PapyrusPalettePreferences.changePaletteVisibility(infoPage.getPaletteID(), editorPart, true);
		}
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
