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
package org.eclipse.emf.facet.efacet.ui.internal.wizards.pages;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.efacet.ui.internal.Messages;
import org.eclipse.emf.facet.efacet.ui.internal.widget.MetamodelSelectionControl;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.FilteredList;

public class SelectEPackageWizardPage extends WizardPage {

	private MetamodelSelectionControl metamodelSelectionControl;
	private final EditingDomain editingDomain;

	public SelectEPackageWizardPage(final EditingDomain editingDomain) {
		super("Whatever"); //$NON-NLS-1$
		setTitle(Messages.Select_EPackage);
		this.editingDomain = editingDomain;
	}

	@Override
	public void setVisible(final boolean visible) {
		super.setVisible(visible);
		if (visible) {
			this.metamodelSelectionControl.getFilterText().setFocus();
			setPageComplete(true);
		}
	}

	public void createControl(final Composite parent) {
		this.metamodelSelectionControl = new MetamodelSelectionControl(parent);
		this.metamodelSelectionControl.setLayoutData(new GridData(GridData.FILL_BOTH));
		final FilteredList filteredList = this.metamodelSelectionControl.getFilteredList();

		filteredList.addSelectionListener(new SelectionListener() {
			public void widgetSelected(final SelectionEvent e) {
				if (e.item != null) {
					setPageComplete(filteredList.getSelection().length == 1);
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

		// prevent the page from being "complete" when still on a previous page
		filteredList.setSelection(new int[0]);
		setPageComplete(false);

		setControl(this.metamodelSelectionControl);
	}

	protected void goToNextPage() {
		getContainer().showPage(getNextPage());
	}

	public EPackage getFirstSelectedEPackage() {
		// Only one result
		if (this.metamodelSelectionControl.getSelectedElements() != null) {
			Object result = this.metamodelSelectionControl.getSelectedElements()[0];
			if (EPackage.Registry.INSTANCE.containsKey(result.toString())) {
				return EPackage.Registry.INSTANCE.getEPackage(result.toString());
			}
		}
		return null;
	}

	public void loadSelectedMetamodel() {
		Object[] results = this.metamodelSelectionControl.getSelectedElements();
		// if user cancel the selection of meta models, results = null
		if (results != null) {
			ResourceSet resourceSet = this.editingDomain.getResourceSet();
			for (Object result : results) {
				URI uri = URI.createURI(result.toString());
				Resource r = resourceSet.getResource(uri, true);
				if (!resourceSet.getResources().contains(r)) {
					Registry packageRegistry = resourceSet.getPackageRegistry();
					for (EObject eObject : r.getContents()) {
						if (eObject instanceof EPackage) {
							EPackage ePackage = (EPackage) eObject;
							packageRegistry.put(ePackage.getNsURI(), ePackage);
						}
					}
					resourceSet.getResources().add(r);
				}
			}
		}
	}
}
