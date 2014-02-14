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

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.efacet.EFacetFactory;
import org.eclipse.emf.facet.efacet.FacetOperation;
import org.eclipse.emf.facet.efacet.Query;
import org.eclipse.emf.facet.efacet.core.IFacetAction;
import org.eclipse.emf.facet.efacet.ui.internal.Messages;
import org.eclipse.emf.facet.efacet.ui.internal.exported.wizard.IQueryCreationPagePart;
import org.eclipse.emf.facet.efacet.ui.internal.wizards.pages.AbstractFacetWizardPage;
import org.eclipse.emf.facet.efacet.ui.internal.wizards.pages.AddOperationInFacetWizardPage;
import org.eclipse.emf.facet.efacet.ui.internal.wizards.pages.CreateQueryWizardPage;
import org.eclipse.jface.viewers.ISelection;

@Deprecated
//TODO @Deprecated must be removed after a refactoring planed by https://bugs.eclipse.org/bugs/show_bug.cgi?id=364601
public class AddFacetOperationWizardImpl extends AbstractAddFacetChildrenWizard {

	public AddFacetOperationWizardImpl(final ISelection selection, final EditingDomain editingDomain) {
		super(selection, editingDomain);
		setWindowTitle(Messages.Add_an_Operation);
		setFacetCreationPage(new AddOperationInFacetWizardPage(getSelection(), getEditingDomain(), getQueryTypeNameToQueryCreationPage()));
	}

	@Override
	public boolean performFinish() {
		Query conformanceQuery = null;
		AbstractFacetWizardPage facetPage = getFacetCreationPage();

		if (facetPage.isSubTypingFacet()) {
			CreateQueryWizardPage queryPage = getQueryCreationPage();

			IQueryCreationPagePart iQueryPage = queryPage.getQueryCreationPage();
			iQueryPage.setCanBeCached(queryPage.getCanBeCached());
			iQueryPage.setHasSideEffect(queryPage.getHasSideEffect());
			iQueryPage.setQueryName(queryPage.getQueryName());
			iQueryPage.setLowerBound(queryPage.getLowerBound());
			iQueryPage.setUpperBound(queryPage.getUpperBound());
			iQueryPage.setQueryScope(facetPage.getFacet().getExtendedMetaclass());
			iQueryPage.setQueryType(facetPage.getType());

			iQueryPage.setUnique(facetPage.isUnique());
			iQueryPage.setOrdered(facetPage.isOrdered());

			conformanceQuery = iQueryPage.performFinish();
		}

		FacetOperation facetOperation = EFacetFactory.eINSTANCE.createFacetOperation();
		facetOperation.setName(facetPage.getChildrenName());
		facetOperation.setEType(facetPage.getType());
		facetOperation.setQuery(conformanceQuery);
		facetOperation.setLowerBound(facetPage.getLowerBound());
		facetOperation.setUpperBound(facetPage.getUpperBound());
		facetOperation.setUnique(facetPage.isUnique());
		facetOperation.setOrdered(facetPage.isOrdered());

		IFacetAction.INSTANCE.addOperationInFacet(facetPage.getFacet(), facetOperation, getEditingDomain());
		return true;
	}
}
