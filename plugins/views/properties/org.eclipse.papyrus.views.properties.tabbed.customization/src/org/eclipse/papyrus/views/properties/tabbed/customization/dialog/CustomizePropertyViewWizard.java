/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.tabbed.customization.dialog;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.papyrus.views.properties.tabbed.customization.Activator;


/**
 * Wizard for Property View Customization
 */
public class CustomizePropertyViewWizard extends Wizard {

	/** page to select the xml file to edit */
	protected SelectConfigurationFileWizardPage selectXmlFilePage = new SelectConfigurationFileWizardPage();

	/** Customize the content of the page */
	protected CustomizeContentWizardPage customizeContentPage = new CustomizeContentWizardPage();

	/**
	 * Creates a new CustomizePropertyViewWizard.
	 * 
	 */
	public CustomizePropertyViewWizard() {
		setDialogSettings(Activator.getDefault().getDialogSettings());
		setNeedsProgressMonitor(true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addPages() {
		addPage(selectXmlFilePage);
		addPage(customizeContentPage);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean performFinish() {
		boolean returnCode = customizeContentPage.serializeContent();
		selectXmlFilePage.performPostSerializationAction();
		return returnCode;
	}

}
