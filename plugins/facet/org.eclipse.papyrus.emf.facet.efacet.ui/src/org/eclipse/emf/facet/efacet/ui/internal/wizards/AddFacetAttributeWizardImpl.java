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
import org.eclipse.emf.facet.efacet.FacetAttribute;
import org.eclipse.emf.facet.efacet.Query;
import org.eclipse.emf.facet.efacet.core.IFacetAction;
import org.eclipse.emf.facet.efacet.ui.internal.Messages;
import org.eclipse.emf.facet.efacet.ui.internal.exported.wizard.IQueryCreationPagePart;
import org.eclipse.emf.facet.efacet.ui.internal.wizards.pages.AbstractFacetWizardPage;
import org.eclipse.emf.facet.efacet.ui.internal.wizards.pages.AddAttributeInFacetWizardPage;
import org.eclipse.emf.facet.efacet.ui.internal.wizards.pages.CreateQueryWizardPage;
import org.eclipse.jface.viewers.ISelection;

@Deprecated
//TODO @Deprecated must be removed after a refactoring planed by https://bugs.eclipse.org/bugs/show_bug.cgi?id=364601
public class AddFacetAttributeWizardImpl extends AbstractAddFacetChildrenWizard {

	public AddFacetAttributeWizardImpl(final ISelection selection, final EditingDomain editingDomain) {
		super(selection, editingDomain);
		setWindowTitle(Messages.Add_an_Attribute);
		setFacetCreationPage(new AddAttributeInFacetWizardPage(getSelection(), getEditingDomain(), getQueryTypeNameToQueryCreationPage()));
	}

	@Override
	public boolean performFinish() {
		Query query = null;
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

			query = iQueryPage.performFinish();
		}

		FacetAttribute facetAttribute = EFacetFactory.eINSTANCE.createFacetAttribute();
		facetAttribute.setName(facetPage.getChildrenName());
		facetAttribute.setEType(facetPage.getType());
		facetAttribute.setQuery(query);
		facetAttribute.setLowerBound(facetPage.getLowerBound());
		facetAttribute.setUpperBound(facetPage.getUpperBound());

		facetAttribute.setUnique(facetPage.isUnique());
		facetAttribute.setOrdered(facetPage.isOrdered());
		facetAttribute.setTransient(facetPage.isTransient());
		facetAttribute.setChangeable(facetPage.isChangeable());
		facetAttribute.setDerived(facetPage.isDerived());
		facetAttribute.setVolatile(facetPage.isVolatile());

		IFacetAction.INSTANCE.addAttributeInFacet(facetPage.getFacet(), facetAttribute, getEditingDomain());
		return true;
	}
}
