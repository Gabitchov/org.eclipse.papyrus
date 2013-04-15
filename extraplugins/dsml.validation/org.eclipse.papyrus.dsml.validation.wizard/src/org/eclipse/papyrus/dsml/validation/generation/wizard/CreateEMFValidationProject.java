/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ernest Wozniak (CEA LIST) ernest.wozniak@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - modification
 *****************************************************************************/
package org.eclipse.papyrus.dsml.validation.generation.wizard;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.papyrus.dsml.validation.model.elements.interfaces.IConstraintProvider;
import org.eclipse.papyrus.dsml.validation.model.elements.interfaces.IConstraintsCategory;
import org.eclipse.papyrus.dsml.validation.model.elements.interfaces.IConstraintsManager;
import org.eclipse.papyrus.dsml.validation.model.elements.interfaces.IValidationRule;
import org.eclipse.papyrus.dsml.validation.model.profilenames.Utils;
import org.eclipse.pde.internal.ui.wizards.plugin.NewPluginProjectWizard;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Profile;

/**
 * This class represents the plugin project wizard and triggers creation of an
 * EMF Validation plugin when user clicks finish button on a plugin creation
 * wizard.
 * 
 * 
 */
public class CreateEMFValidationProject extends NewPluginProjectWizard {

	private static final String GENERATION_MESSAGE = "Generation of EMF Validation Plugin";

	private IConstraintsManager constraintsManager;

	private JavaContentGenerator generateAllJava;


	private Profile selectedProfile;
	private EPackage definition=null;

	/**
	 * 
	 * Constructor.
	 *
	 * @param selectedProfile
	 * @param constraintsExtractor
	 */
	public CreateEMFValidationProject(Profile selectedProfile,
		IConstraintsManager constraintsExtractor, EPackage definition) {
		super();
		setWindowTitle(GENERATION_MESSAGE);
		this.constraintsManager = constraintsExtractor;
		this.selectedProfile = selectedProfile;
		this.definition=definition;
	}

	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		if(page == fContentPage) { //Remove the template page
			return null;
		}
		return super.getNextPage(page);
	}

	@Override
	public void addPages() {
		super.addPages();
	}

	/**
	 * run the dialog
	 */
	public void openDialog() {
		Shell frame = new Shell(SWT.SHELL_TRIM);
		WizardDialog dialog = new WizardDialog(frame, (IWizard) this);
		dialog.open();
	}

	@Override
	public boolean performFinish() {
		boolean result = super.performFinish();
		if (result) {
			IProject project = this.fMainPage.getProjectHandle();
			try {

				//generate java code
				generateAllJava = new JavaContentGenerator(project, selectedProfile);
				generateAllJava.run();
				//generate plugin + extension point
				ValidationPluginGenerator.instance.generate(project, this,constraintsManager,  definition);


				project.refreshLocal(IProject.DEPTH_INFINITE, null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

}
