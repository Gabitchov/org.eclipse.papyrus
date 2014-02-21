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

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.efacet.EFacetFactory;
import org.eclipse.emf.facet.efacet.Facet;
import org.eclipse.emf.facet.efacet.FacetSet;
import org.eclipse.emf.facet.efacet.Query;
import org.eclipse.emf.facet.efacet.core.IFacetAction;
import org.eclipse.emf.facet.efacet.ui.internal.IQueryCreationPagePartRegistry;
import org.eclipse.emf.facet.efacet.ui.internal.Messages;
import org.eclipse.emf.facet.efacet.ui.internal.exported.wizard.ICreateFacetInFacetSetWizard;
import org.eclipse.emf.facet.efacet.ui.internal.exported.wizard.IQueryCreationPagePart;
import org.eclipse.emf.facet.efacet.ui.internal.wizards.pages.CreateFacetInFacetSetWizardPage;
import org.eclipse.emf.facet.efacet.ui.internal.wizards.pages.CreateQueryWizardPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;

@Deprecated
//TODO @Deprecated must be removed after a refactoring planed by https://bugs.eclipse.org/bugs/show_bug.cgi?id=364601
public class CreateFacetInFacetSetWizardImpl extends Wizard implements ICreateFacetInFacetSetWizard {

	private WizardDialog dialog = null;
	private final CreateFacetInFacetSetWizardPage facetCreationPage;
	private final CreateQueryWizardPage queryCreationPage;

	private final ISelection selection;
	private final EditingDomain editingDomain;

	private FacetSet facetSet;
	private boolean canChangeFacetSet;

	private final Facet facet;

	private boolean canChangeExtendedMetaClass = true;

	private final Map<String, IQueryCreationPagePart> queryTypeNameToQueryCreationPage;

	public CreateFacetInFacetSetWizardImpl(final ISelection selection2, final EditingDomain editingDomain2) {
		super();
		this.facet = EFacetFactory.eINSTANCE.createFacet();
		setWindowTitle(Messages.Create_facet_in_facetSet);
		this.selection = selection2;
		initializeSelection();
		this.editingDomain = editingDomain2;

		this.queryTypeNameToQueryCreationPage = IQueryCreationPagePartRegistry.INSTANCE.getRegisteredWizardPageParts();

		this.dialog = new WizardDialog(getShell(), this);

		this.facetCreationPage = new CreateFacetInFacetSetWizardPage(this.facet, this.selection, this.editingDomain,
				this.queryTypeNameToQueryCreationPage);

		this.queryCreationPage = new CreateQueryWizardPage(this.queryTypeNameToQueryCreationPage, this.facetSet, this.facet);

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
			}
		}
	}

	@Override
	public void addPages() {
		this.facetCreationPage.setFacetSet(this.facetSet);
		this.facetCreationPage.canChangeParentName(this.canChangeFacetSet);
		this.facetCreationPage.setExtendedMetaClass(this.facet.getExtendedMetaclass());
		this.facetCreationPage.canChangeExtendedMetaClass(this.canChangeExtendedMetaClass);
		addPage(this.facetCreationPage);

		this.queryCreationPage.canChangeCanBeCached(false);
		this.queryCreationPage.canChangeHasSideEffect(false);
		this.queryCreationPage.canChangeLowerBound(false);
		this.queryCreationPage.canChangeUpperBound(false);
		this.queryCreationPage.canChangeQueryName(false);
		this.queryCreationPage.setFacetSet(this.facetSet);
		addPage(this.queryCreationPage);
	}

	@Override
	public boolean canFinish() {
		if (getContainer().getCurrentPage() == this.facetCreationPage && !this.facetCreationPage.isSubTypingFacet()
				&& this.facetCreationPage.isPageComplete()) {
			return true;
		}
		return getContainer().getCurrentPage() == this.queryCreationPage && getContainer().getCurrentPage().isPageComplete();
	}

	public int open() {
		if (this.dialog != null) {
			return this.dialog.open();
		}
		return Window.CANCEL;
	}

	@Override
	public boolean performFinish() {
		final String facetName = this.facetCreationPage.getChildrenName();
		Query conformanceQuery = null;
		if (this.facetCreationPage.isSubTypingFacet()) {
			IQueryCreationPagePart iQueryPage = this.queryCreationPage.getQueryCreationPage();
			iQueryPage.setCanBeCached(this.queryCreationPage.getCanBeCached());
			iQueryPage.setHasSideEffect(this.queryCreationPage.getHasSideEffect());
			iQueryPage.setQueryName(this.queryCreationPage.getQueryName());
			iQueryPage.setLowerBound(this.queryCreationPage.getLowerBound());
			iQueryPage.setUpperBound(this.queryCreationPage.getUpperBound());
			iQueryPage.setQueryScope(this.facetCreationPage.getExtendedMetaclass());
			iQueryPage.setQueryType(EcorePackage.eINSTANCE.getEBoolean());
			conformanceQuery = iQueryPage.performFinish();
		}

		this.facet.setName(facetName);
		this.facet.setExtendedMetaclass(this.facetCreationPage.getExtendedMetaclass());
		this.facet.setConformanceQuery(conformanceQuery);

		IFacetAction.INSTANCE.createFacetInFacetSet(this.facetCreationPage.getFacetSet(), this.facet, this.editingDomain);
		return true;
	}

	public void setFacetSet(final FacetSet facetSet2) {
		this.facetSet = facetSet2;
		this.queryCreationPage.setFacetSet(facetSet2);
	}

	public void canChangeFacetSet(final boolean canChange) {
		this.canChangeFacetSet = canChange;

	}

	public void setExtendedMetaClass(final EClass extendedMetaClass) {
		this.facet.setExtendedMetaclass(extendedMetaClass);

	}

	public void canChangeExtendedMetaClass(final boolean canChange) {
		this.canChangeExtendedMetaClass = canChange;
	}
}
