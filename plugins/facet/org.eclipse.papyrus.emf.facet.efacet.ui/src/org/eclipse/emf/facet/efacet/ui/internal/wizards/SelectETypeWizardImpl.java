/**
 * Copyright (c) 2011 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Nicolas Guyomar (Mia-Software) - Bug 349546 - EMF Facet facetSet editor
 */
package org.eclipse.emf.facet.efacet.ui.internal.wizards;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.efacet.ui.internal.Messages;
import org.eclipse.emf.facet.efacet.ui.internal.composites.SelectETypeComposite.ETypeSelectionOptions;
import org.eclipse.emf.facet.efacet.ui.internal.exported.wizard.ISelectETypeWizard;
import org.eclipse.emf.facet.efacet.ui.internal.wizards.pages.SelectEClassifierWizardPage;
import org.eclipse.emf.facet.efacet.ui.internal.wizards.pages.SelectEPackageWizardPage;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.PlatformUI;

public class SelectETypeWizardImpl extends Wizard implements ISelectETypeWizard {

	private final WizardDialog dialog;

	private final SelectEPackageWizardPage selectEPackagePage;
	private final SelectEClassifierWizardPage selectETypePage;

	private final EditingDomain editingDomain;

	private EClassifier selectedEType;

	private boolean canChangeEPackage = true;

	public SelectETypeWizardImpl(final EditingDomain editingDomain, final ETypeSelectionOptions eTypeSelectionOption,
			final boolean canChangeEPackage, final EPackage ePackage) {
		super();
		this.editingDomain = editingDomain;
		this.canChangeEPackage = canChangeEPackage;
		this.dialog = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), this);
		this.selectEPackagePage = new SelectEPackageWizardPage(this.editingDomain);
		this.selectETypePage = new SelectEClassifierWizardPage(eTypeSelectionOption, ePackage);
		if (eTypeSelectionOption == ETypeSelectionOptions.ECLASS) {
			setWindowTitle(Messages.Select_EClass);
		} else if (eTypeSelectionOption == ETypeSelectionOptions.EDATATYPE) {
			setWindowTitle(Messages.Select_EDataType);
		} else {
			setWindowTitle(Messages.Select_EClassifier);
		}
	}

	@Override
	public void addPages() {
		if (this.canChangeEPackage) {
			addPage(this.selectEPackagePage);
		}
		addPage(this.selectETypePage);
	}

	public int open() {
		if (this.dialog != null) {
			return this.dialog.open();
		}
		return Window.CANCEL;
	}

	@Override
	public boolean performFinish() {
		this.selectedEType = this.selectETypePage.getSelectedEclassifier();
		return true;
	}

	public EClassifier getSelectedEType() {
		return this.selectedEType;
	}

}
