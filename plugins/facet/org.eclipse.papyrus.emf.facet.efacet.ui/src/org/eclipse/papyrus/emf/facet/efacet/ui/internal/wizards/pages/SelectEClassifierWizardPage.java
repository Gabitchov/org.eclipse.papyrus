/*******************************************************************************
 * Copyright (c) 2009, 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.efacet.ui.internal.wizards.pages;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.composites.SelectETypeComposite.ETypeSelectionOptions;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.widget.EClassifierSelectionControl;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.FilteredList;

public class SelectEClassifierWizardPage extends WizardPage {

	private EClassifierSelectionControl eClassSelectionControl;
	private final ETypeSelectionOptions eTypeSelectionOption;
	private String metamodelNsUri;

	public SelectEClassifierWizardPage(final ETypeSelectionOptions eTypeSelectionOption, final EPackage ePackage) {
		super("Whatever"); //$NON-NLS-1$
		if (eTypeSelectionOption == ETypeSelectionOptions.ECLASS) {
			setTitle(Messages.Select_EClass);
		} else if (eTypeSelectionOption == ETypeSelectionOptions.EDATATYPE) {
			setTitle(Messages.Select_EDataType);
		} else {
			setTitle(Messages.Select_EClassifier);
		}
		if (ePackage != null) {
			this.metamodelNsUri = ePackage.getNsURI();
		}
		this.eTypeSelectionOption = eTypeSelectionOption;
	}

	@Override
	public boolean isPageComplete() {
		return this.eClassSelectionControl.getSelectedEClassifier() != null;
	}

	@Override
	public void setVisible(final boolean visible) {
		super.setVisible(visible);
		if (getPreviousPage() instanceof SelectEPackageWizardPage) {
			SelectEPackageWizardPage selectEPackageWizardPage = (SelectEPackageWizardPage) getPreviousPage();
			this.metamodelNsUri = selectEPackageWizardPage.getFirstSelectedEPackage().getNsURI();
			if (this.metamodelNsUri != null) {
				setDescription(selectEPackageWizardPage.getFirstSelectedEPackage().getNsURI());
			}
		}
		this.eClassSelectionControl.updateList(this.metamodelNsUri);
	}

	public void createControl(final Composite parent) {
		this.eClassSelectionControl = new EClassifierSelectionControl(parent, this.metamodelNsUri, this.eTypeSelectionOption);
		final FilteredList filteredList = this.eClassSelectionControl.getFilteredList();

		filteredList.addSelectionListener(new SelectionListener() {
			public void widgetSelected(final SelectionEvent e) {
				if (e.item != null) {
					updateButton();
					// setPageComplete(filteredList.getSelection().length == 1);
				}
			}

			public void widgetDefaultSelected(final SelectionEvent e) {
				if (getWizard().canFinish()) {
					getWizard().performFinish();
				}
				if (getNextPage() != null) {
					goToNextPage();
				}
			}
		});

		this.eClassSelectionControl.getFilterText().addModifyListener(new ModifyListener() {

			public void modifyText(final ModifyEvent e) {
				updateButton();
			}
		});

		// avoid the page being "complete" when still on a previous page
		filteredList.setSelection(new int[0]);
		setPageComplete(false);

		setControl(this.eClassSelectionControl);
	}

	protected void goToNextPage() {
		getContainer().showPage(getNextPage());
	}

	protected void updateButton() {
		if (getContainer() != null && getContainer().getCurrentPage() != null) {
			getContainer().updateButtons();
		}
	}

	public EClassifier getSelectedEclassifier() {
		return this.eClassSelectionControl.getSelectedEClassifier();
	}
}