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
 *  Grégoire Dupe (Mia-Software) - Bug 373248 - Clean PMD errors 
 */
package org.eclipse.emf.facet.efacet.ui.internal.wizards;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.efacet.Facet;
import org.eclipse.emf.facet.efacet.FacetSet;
import org.eclipse.emf.facet.efacet.ui.internal.IQueryCreationPagePartRegistry;
import org.eclipse.emf.facet.efacet.ui.internal.exported.wizard.IFacetChildrenWizard;
import org.eclipse.emf.facet.efacet.ui.internal.exported.wizard.IQueryCreationPagePart;
import org.eclipse.emf.facet.efacet.ui.internal.wizards.pages.AbstractFacetWizardPage;
import org.eclipse.emf.facet.efacet.ui.internal.wizards.pages.CreateQueryWizardPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;

@SuppressWarnings("PMD.ConstructorCallsOverridableMethod")
//@SuppressWarnings("PMD.ConstructorCallsOverridableMethod") This class is
//deprecated, we won't then spend to many time to conforms to PMD rules.
@Deprecated
//TODO @Deprecated must be removed after a refactoring planed by https://bugs.eclipse.org/bugs/show_bug.cgi?id=364601
public abstract class AbstractAddFacetChildrenWizard extends Wizard implements IFacetChildrenWizard {

	private final ISelection selection;
	private final EditingDomain editingDomain;
	private final WizardDialog dialog;
	private FacetSet facetSet;
	private Facet facet;
	private final Map<String, IQueryCreationPagePart> queryTypeNameToQueryCreationPage;

	private AbstractFacetWizardPage facetCreationPage;
	private CreateQueryWizardPage queryCreationPage;

	public AbstractAddFacetChildrenWizard(final ISelection selection, final EditingDomain editingDomain) {
		this.selection = selection;
		this.editingDomain = editingDomain;
		initializeSelection();
		this.queryTypeNameToQueryCreationPage = IQueryCreationPagePartRegistry.INSTANCE.getRegisteredWizardPageParts();
		this.dialog = new WizardDialog(getShell(), this);
		addQueryCreationPage();
	}

	protected void addQueryCreationPage() {
		this.queryCreationPage = new CreateQueryWizardPage(this.queryTypeNameToQueryCreationPage, getFacetSet(), this.facet);
	}

	private void initializeSelection() {
		if (this.selection != null && !this.selection.isEmpty() && this.selection instanceof IStructuredSelection) {
			IStructuredSelection ssel = (IStructuredSelection) this.selection;
			if (ssel.size() > 1) {
				return;
			}
			Object obj = ssel.getFirstElement();
			if (obj instanceof FacetSet) {
				this.facetSet = (FacetSet) obj;
			} else {
				if (obj instanceof Facet) {
					this.facetSet = ((Facet) obj).getFacetSet();
					this.facet = (Facet) obj;
				}
			}
		}
	}

	@Override
	public void addPages() {
		if (this.facetCreationPage != null) {
			addPage(this.facetCreationPage);
		}
		if (this.queryCreationPage != null) {
			this.queryCreationPage.canChangeCanBeCached(false);
			this.queryCreationPage.canChangeHasSideEffect(false);
			this.queryCreationPage.canChangeLowerBound(false);
			this.queryCreationPage.canChangeUpperBound(false);
			this.queryCreationPage.canChangeQueryName(false);
			this.queryCreationPage.setFacetSet(getFacetSet());
			addPage(this.queryCreationPage);
		}
	}

	@Override
	public boolean canFinish() {
		return getContainer().getCurrentPage() == this.queryCreationPage && this.queryCreationPage.isPageComplete();
	}

	public int open() {
		if (this.dialog != null) {
			return this.dialog.open();
		}
		return Window.CANCEL;
	}

	public void setFacet(final Facet facet) {
		this.facetCreationPage.setFacet(facet);
	}

	public void setChildrenName(final String referenceName) {
		this.facetCreationPage.setChildrenName(referenceName);
	}

	public void setUpperBound(final int upperBound) {
		this.facetCreationPage.setUpperBound(upperBound);
	}

	public void setLowerBound(final int lowerBound) {
		this.facetCreationPage.setLowerBound(lowerBound);
	}

	public void setType(final EClass type) {
		this.facetCreationPage.setType(type);
	}

	public void canChangeFacet(final boolean canChange) {
		this.facetCreationPage.canChangeParentName(canChange);
	}

	public void canChangeChildrenName(final boolean canChange) {
		this.facetCreationPage.canChangeChildrenName(canChange);
	}

	public void canChangeUpperBound(final boolean canChange) {
		this.facetCreationPage.canChangeUpperBound(canChange);
	}

	public void canChangeLowerBound(final boolean canChange) {
		this.facetCreationPage.canChangeLowerBound(canChange);
	}

	public void canChangeType(final boolean canChange) {
		this.facetCreationPage.canChangeType(canChange);
	}

	public EditingDomain getEditingDomain() {
		return this.editingDomain;
	}

	protected final FacetSet getFacetSet() {
		return this.facetSet;
	}

	protected final CreateQueryWizardPage getQueryCreationPage() {
		return this.queryCreationPage;
	}

	protected void setFacetCreationPage(final AbstractFacetWizardPage facetCreationPage) {
		this.facetCreationPage = facetCreationPage;
	}

	protected ISelection getSelection() {
		return this.selection;
	}

	protected Map<String, IQueryCreationPagePart> getQueryTypeNameToQueryCreationPage() {
		return this.queryTypeNameToQueryCreationPage;
	}

	protected AbstractFacetWizardPage getFacetCreationPage() {
		return this.facetCreationPage;
	}
}
