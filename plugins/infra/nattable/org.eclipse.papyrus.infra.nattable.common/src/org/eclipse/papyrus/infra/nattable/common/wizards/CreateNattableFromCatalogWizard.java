/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.common.wizards;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.papyrus.infra.nattable.common.messages.Messages;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration;

/**
 * Wizard declaration to display and choose existing Nattable configurations
 */
public class CreateNattableFromCatalogWizard extends Wizard {

	private ChooseNattableConfigWizardPage page;

	private Map<TableConfiguration, Integer> selectedConfigs;

	private Map<TableConfiguration, String> tableNames;

	private EObject context;

	public CreateNattableFromCatalogWizard(EObject context) {
		this.context = context;
	}

	/**
	 * Getter for selected configurations.
	 * 
	 * @return
	 */
	public Map<TableConfiguration, Integer> getSelectedConfig() {
		return selectedConfigs;
	}

	/**
	 * Enables the finish button when there's at least one selected configuration
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 * 
	 * @return
	 */
	public boolean performFinish() {
		this.selectedConfigs = page.getSelectedConfigs();
		this.tableNames = page.getTableNames();
		if(this.selectedConfigs != null && this.tableNames != null) {
			if(this.selectedConfigs.size() > 0) {

				return true;
			}
		}
		return false;
	}


	public Map<TableConfiguration, String> getTableNames() {
		return tableNames;
	}

	/**
	 * Create and add the unique page to the wizard
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 * 
	 */
	public void addPages() {
		String description = Messages.CreateNattableFromCatalogWizard_0;
		page = new ChooseNattableConfigWizardPage(description, context);
		page.setTitle(Messages.CreateNattableFromCatalogWizard_1);
		page.setDescription(description);
		addPage(page);
	}

	/**
	 * Declare wizard title
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#getWindowTitle()
	 * 
	 * @return
	 */
	public String getWindowTitle() {
		return Messages.CreateNattableFromCatalogWizard_2;
	}



}
