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
package org.eclipse.emf.facet.efacet.ui.internal.wizards.pages;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.efacet.Facet;
import org.eclipse.emf.facet.efacet.FacetSet;
import org.eclipse.emf.facet.efacet.ui.internal.Messages;
import org.eclipse.emf.facet.efacet.ui.internal.composites.BrowseComposite;
import org.eclipse.emf.facet.efacet.ui.internal.composites.SelectETypeComposite.ETypeSelectionOptions;
import org.eclipse.emf.facet.efacet.ui.internal.exported.wizard.IQueryCreationPagePart;
import org.eclipse.emf.facet.efacet.ui.internal.wizards.SelectETypeWizardImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

@Deprecated
//TODO @Deprecated must be removed after a refactoring planed by https://bugs.eclipse.org/bugs/show_bug.cgi?id=364601
public class CreateFacetInFacetSetWizardPage extends AbstractFacetWizardPage {

	private boolean canChangeExtendedMetaClass;
	private final Facet facet;

	public CreateFacetInFacetSetWizardPage(final Facet facet, final ISelection selection, final EditingDomain editingDomain2,
			final Map<String, IQueryCreationPagePart> queryTypeNameToWizardPage) {
		super(selection, editingDomain2, queryTypeNameToWizardPage, ETypeSelectionOptions.ECLASS);
		this.facet = facet;
		setTitle(Messages.Create_facet_in_facetSet);
		setDescription(Messages.CreateFacetInFacetSetWizardPage_wizard_description);
	}

	@Override
	public boolean canFlipToNextPage() {
		return isPageComplete() && isSubTypingFacet();
	}

	@Override
	public boolean isPageComplete() {
		if (super.isPageComplete()) {
			if (getExtendedMetaclass() == null) {
				setErrorMessage(Messages.CreateFacetInFacetSetWizardPage_Please_fill_extendedMetaClass);
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	protected void initializeWithSelection() {
		if (getSelection() != null && !getSelection().isEmpty() && getSelection() instanceof IStructuredSelection) {
			IStructuredSelection ssel = (IStructuredSelection) getSelection();
			if (ssel.size() > 1) {
				return;
			}
			Object obj = ssel.getFirstElement();
			if (obj instanceof FacetSet) {
				FacetSet facetSet = (FacetSet) obj;
				setFacetSet(facetSet);
				if (facetSet.getName() != null) {
					setParentName(facetSet.getName(), true);
				}
			}
		}
	}

	public void createControl(final Composite parent) {
		final Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 1;
		layout.verticalSpacing = AbstractFacetWizardPage.VERTICAL_SPACING;
		showLowerBound(false);
		showUpperBound(false);
		showEType(false);
		showVolatile(false);
		showOrdered(false);
		showChangeable(false);
		showUnique(false);
		showTransient(false);
		showDerived(false);

		Composite container2 = createControlParts(container);

		Label label = new Label(container2, SWT.NONE);
		label.setText(Messages.ExtendedMetaClass);
		@SuppressWarnings("unused")
		// this composite is never read because it only takes care of the UI
		BrowseComposite browseComposite = new BrowseComposite(container2, SWT.BORDER, null, this.canChangeExtendedMetaClass) {
			@Override
			protected void handleBrowse() {
				SelectETypeWizardImpl dialog = new SelectETypeWizardImpl(getEditingDomain(), ETypeSelectionOptions.ECLASS, false, getFacetSet()
						.getExtendedEPackage());
				if (dialog.open() != Window.CANCEL) {
					EClass eClass = (EClass) dialog.getSelectedEType();
					setExtendedMetaClass(eClass);
					if (eClass.getInstanceClassName() != null) {
						updateTextFieldContent(eClass.getInstanceClassName());
					} else {
						updateTextFieldContent(eClass.getName());
					}
					updatePageButtons();
				}
			}
		};

		initializeTextContent(Messages.FacetSet, Messages.Facet);

		setControl(container);
	}

	public void setExtendedMetaClass(final EClass extendedMetaClass) {
		this.facet.setExtendedMetaclass(extendedMetaClass);
	}

	public void canChangeExtendedMetaClass(final boolean canChange2) {
		this.canChangeExtendedMetaClass = canChange2;
	}

	public EClass getExtendedMetaclass() {
		return this.facet.getExtendedMetaclass();
	}
}