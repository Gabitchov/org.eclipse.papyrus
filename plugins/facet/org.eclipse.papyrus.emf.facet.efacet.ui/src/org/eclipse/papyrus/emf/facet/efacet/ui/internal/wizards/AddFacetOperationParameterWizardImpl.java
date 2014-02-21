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

import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.efacet.FacetOperation;
import org.eclipse.emf.facet.efacet.core.IFacetAction;
import org.eclipse.emf.facet.efacet.ui.internal.Messages;
import org.eclipse.emf.facet.efacet.ui.internal.wizards.pages.AbstractFacetWizardPage;
import org.eclipse.emf.facet.efacet.ui.internal.wizards.pages.AddOperationParameterInFacetWizardPage;
import org.eclipse.jface.viewers.ISelection;

@Deprecated
//TODO @Deprecated must be removed after a refactoring planed by https://bugs.eclipse.org/bugs/show_bug.cgi?id=364601
public class AddFacetOperationParameterWizardImpl extends AbstractAddFacetChildrenWizard {

	public AddFacetOperationParameterWizardImpl(final ISelection selection, final EditingDomain editingDomain) {
		super(selection, editingDomain);
		setFacetCreationPage(new AddOperationParameterInFacetWizardPage(getSelection(), getEditingDomain()));
		setWindowTitle(Messages.Add_an_Operation_Parameter);
	}

	@Override
	protected void addQueryCreationPage() {
		// We do not want to create a query for the operation's parameter
	}

	@Override
	public boolean canFinish() {
		return getFacetCreationPage().isPageComplete();
	}

	@Override
	public boolean performFinish() {
		AbstractFacetWizardPage page = getFacetCreationPage();
		FacetOperation facetOperation = (FacetOperation) page.getQueryFacetElement();

		EParameter parameter = EcoreFactory.eINSTANCE.createEParameter();
		parameter.setName(page.getChildrenName());
		parameter.setEType(page.getType());
		parameter.setLowerBound(page.getLowerBound());
		parameter.setUpperBound(page.getUpperBound());
		parameter.setUnique(page.isUnique());
		parameter.setOrdered(page.isOrdered());

		IFacetAction.INSTANCE.addParameterInOperation(facetOperation, parameter, getEditingDomain());
		return true;
	}
}
