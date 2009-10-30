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

/**
 * Wizard to create a new Drawer from scratch
 */
public class NewDrawerWizard extends Wizard {

	/** info page */
	protected DrawerInformationPage infoPage;

	/** the element where to add the new drawer */
	protected PaletteContainerProxy paletteContainerProxy;

	/**
	 * Creates a NewDrawerWizard.
	 * 
	 * @param paletteContainerProxy
	 *            the element where to add the new drawer
	 */
	public NewDrawerWizard(PaletteContainerProxy paletteContainerProxy) {
		this.paletteContainerProxy = paletteContainerProxy;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addPages() {
		super.addPages();

		infoPage = new DrawerInformationPage();
		addPage(infoPage);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean performFinish() {
		paletteContainerProxy.addChild(new PaletteLocalDrawerProxy(infoPage.getDrawerName(), infoPage.getDrawerID(),
				infoPage.getImageDescriptorPath()));
		return true;
	}
}
