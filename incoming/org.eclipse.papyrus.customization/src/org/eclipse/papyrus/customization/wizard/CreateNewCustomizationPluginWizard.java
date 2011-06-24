/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.wizard;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.papyrus.customization.Activator;
import org.eclipse.papyrus.customization.generator.PluginGenerator;
import org.eclipse.papyrus.customization.messages.Messages;
import org.eclipse.papyrus.customization.model.customization.CustomizationConfiguration;
import org.eclipse.pde.internal.ui.wizards.plugin.NewPluginProjectWizard;


public class CreateNewCustomizationPluginWizard extends NewPluginProjectWizard {

	protected CustomizationPage customizationPage;

	public CreateNewCustomizationPluginWizard() {
		super();
		setWindowTitle(Messages.CreateNewCustomizationPluginWizard_CustomizationPlugin);
	}

	@Override
	public void addPages() {
		super.addPages();
		addPage(customizationPage = new CustomizationPage());
	}

	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		if(page == fContentPage) { //Remove the template page
			return customizationPage;
		}
		return super.getNextPage(page);
	}

	@Override
	public boolean performFinish() {
		boolean result = super.performFinish();
		if(result) {
			IProject project = this.fMainPage.getProjectHandle();
			CustomizationConfiguration configuration = this.customizationPage.getConfiguration();
			configuration.setPlugin(project.getName());
			PluginGenerator.instance.generate(project, configuration);
			try {
				project.refreshLocal(IProject.DEPTH_INFINITE, null);
			} catch (CoreException ex) {
				Activator.log.error(ex);
			}
		}

		return result;
	}

}
