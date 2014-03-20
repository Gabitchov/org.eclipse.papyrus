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
package org.eclipse.papyrus.emf.facet.efacet.ui.internal;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.exported.wizard.ICreateFacetInFacetSetWizard;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.exported.wizard.ICreateFacetSetWizard;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.exported.wizard.IFacetChildrenWizard;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.wizards.AddFacetAttributeWizardImpl;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.wizards.AddFacetOperationParameterWizardImpl;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.wizards.AddFacetOperationWizardImpl;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.wizards.AddFacetReferenceWizardImpl;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.wizards.CreateFacetInFacetSetWizardImpl;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.wizards.CreateFacetSetWizardImpl;
import org.eclipse.jface.viewers.ISelection;

@Deprecated
//TODO @Deprecated must be removed after a refactoring planed by https://bugs.eclipse.org/bugs/show_bug.cgi?id=364601
public class FacetUIFactoryImpl implements IFacetUIFactory {

	public ICreateFacetInFacetSetWizard createCreateFacetInFacetSetWizardDialog(final ISelection selection, final EditingDomain editingDomain) {
		return new CreateFacetInFacetSetWizardImpl(selection, editingDomain);
	}

	public ICreateFacetSetWizard createCreateFacetSetWizardDialog(final ISelection selection) {
		return createCreateFacetSetWizardDialog(selection, true);
	}

	public ICreateFacetSetWizard createCreateFacetSetWizardDialog(final ISelection selection, final boolean opendCreatedFacetSetInEditor) {
		return new CreateFacetSetWizardImpl(selection, opendCreatedFacetSetInEditor);
	}

	public IFacetChildrenWizard createAddFacetAttributeWizardDialog(final ISelection selection, final EditingDomain editingDomain) {
		return new AddFacetAttributeWizardImpl(selection, editingDomain);
	}

	public IFacetChildrenWizard createAddFacetOperationWizardDialog(final ISelection selection, final EditingDomain editingDomain) {
		return new AddFacetOperationWizardImpl(selection, editingDomain);
	}

	public IFacetChildrenWizard createAddFacetOperationParameterWizardDialog(final ISelection selection, final EditingDomain editingDomain) {
		return new AddFacetOperationParameterWizardImpl(selection, editingDomain);
	}

	public IFacetChildrenWizard createAddFacetReferenceWizardDialog(final ISelection selection, final EditingDomain editingDomain) {
		return new AddFacetReferenceWizardImpl(selection, editingDomain);
	}
}
