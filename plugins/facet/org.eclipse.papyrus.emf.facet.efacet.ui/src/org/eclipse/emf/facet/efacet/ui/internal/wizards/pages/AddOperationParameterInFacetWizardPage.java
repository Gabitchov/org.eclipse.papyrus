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

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.efacet.FacetOperation;
import org.eclipse.emf.facet.efacet.ui.internal.Messages;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

@Deprecated
//TODO @Deprecated must be removed after a refactoring planed by https://bugs.eclipse.org/bugs/show_bug.cgi?id=364601
public class AddOperationParameterInFacetWizardPage extends AbstractFacetWizardPage {

	public AddOperationParameterInFacetWizardPage(final ISelection selection, final EditingDomain editingDomain) {
		super(selection, editingDomain);
		setTitle(Messages.Add_an_Operation_Parameter);
		setDescription(Messages.Add_an_Operation_Parameter_desc);
	}

	@Override
	protected void initializeWithSelection() {
		if (getSelection() != null && !getSelection().isEmpty() && getSelection() instanceof IStructuredSelection) {
			IStructuredSelection ssel = (IStructuredSelection) getSelection();
			if (ssel.size() > 1) {
				return;
			}
			Object obj = ssel.getFirstElement();
			if (obj instanceof FacetOperation) {
				FacetOperation facetOperation = (FacetOperation) obj;
				setQueryFacetElement(facetOperation);
				setFacet(facetOperation.getFacet());
				setFacetSet(facetOperation.getFacet().getFacetSet());
				if (facetOperation.getName() != null) {
					setParentName(facetOperation.getName(), true);
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

		setWizardNeedsQuery(false);

		createControlParts(container);
		initializeTextContent(Messages.Operation, Messages.Parameter_name);

		setControl(container);
	}

}
