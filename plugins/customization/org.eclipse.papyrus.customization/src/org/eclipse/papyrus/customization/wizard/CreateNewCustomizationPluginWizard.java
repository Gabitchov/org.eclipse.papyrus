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
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.papyrus.customization.Activator;
import org.eclipse.papyrus.customization.generator.PluginGenerator;
import org.eclipse.papyrus.customization.messages.Messages;
import org.eclipse.papyrus.customization.model.customizationplugin.CustomizationConfiguration;
import org.eclipse.pde.internal.ui.wizards.plugin.NewPluginProjectWizard;
import org.eclipse.swt.graphics.Image;


public class CreateNewCustomizationPluginWizard extends NewPluginProjectWizard {

	protected CustomizationPage customizationPage;

	//TODO : Use eclipse contexts when switching to E4
	public static CreateNewCustomizationPluginWizard current;

	private Image defaultImage;

	public CreateNewCustomizationPluginWizard() {
		super();
		setDefaultPageImageDescriptor(org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImageDescriptor(Activator.PLUGIN_ID, "/icons/wizban-config.png"));
		setWindowTitle(Messages.CreateNewCustomizationPluginWizard_CustomizationPlugin);
		current = this;
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

	public String getProvider() {
		return this.fContentPage.getData().getProvider();
	}

	@Override
	public boolean performFinish() {
		boolean result = super.performFinish();
		if(result) {
			IProject project = this.fMainPage.getProjectHandle();
			CustomizationConfiguration configuration = this.customizationPage.getConfiguration();
			//configuration.setPlugin(project.getName());
			try {
				PluginGenerator.instance.generate(project, configuration);
				project.refreshLocal(IProject.DEPTH_INFINITE, null);
			} catch (Exception ex) {
				Activator.log.error(ex);
				String errorMessage = "An error occured while generating the customization plug-in: " + ex.getClass().getName() + ": " + ex.getLocalizedMessage(); //$NON-NLS-1$
				for(IWizardPage page : getPages()) {
					if(page instanceof DialogPage) {
						((DialogPage)page).setErrorMessage(errorMessage);
					}

				}
				return false;
			}
		}

		return result;
	}

}
