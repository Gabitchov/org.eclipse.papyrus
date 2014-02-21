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
package org.eclipse.emf.facet.efacet.ui.internal;

import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.efacet.ui.internal.exported.wizard.ICreateFacetInFacetSetWizard;
import org.eclipse.emf.facet.efacet.ui.internal.exported.wizard.ICreateFacetSetWizard;
import org.eclipse.emf.facet.efacet.ui.internal.exported.wizard.IFacetChildrenWizard;
import org.eclipse.jface.viewers.ISelection;

/**
 * This interface provides methods used to create wizards that create {@link Facet}s and Facet elements.
 * @since 0.2
 * @deprecated This interface has been replaced by {@link IFacetUIFactory2}. No tracking bug needed because this API has not been released yet.
 */
@Deprecated
public interface IFacetUIFactory {

	/**
	 * Returns an instance of a {@link FacetUIFactoryImpl}
	 */
	IFacetUIFactory INSTANCE = new FacetUIFactoryImpl();

	/**
	 * Create a wizard dialog dedicated to the addition of a {@link Facet} in a {@link FacetSet}
	 * 
	 * @param selection
	 *            the current selection, should be a FacetSet
	 * @param editingDomain
	 *            the editing domain used to perform the EMF command
	 * @return the newly created wizard
	 */
	public ICreateFacetInFacetSetWizard createCreateFacetInFacetSetWizardDialog(ISelection selection, EditingDomain editingDomain);

	/**
	 * Create a wizard dialog dedicated to the creation of a {@link FacetSet}
	 * 
	 * @param selection
	 *            the current selection
	 * @return the newly created wizard
	 */
	public ICreateFacetSetWizard createCreateFacetSetWizardDialog(ISelection selection);

	/**
	 * Create a wizard dialog dedicated to the creation of a {@link FacetSet}
	 * 
	 * @param selection
	 *            the current selection
	 * @param openCreatedFacetSetInEditor
	 * @return the newly created wizard
	 */
	public ICreateFacetSetWizard createCreateFacetSetWizardDialog(ISelection selection, boolean openCreatedFacetSetInEditor);

	/**
	 * Create a wizard dialog dedicated to the addition of a {@link FacetAttribute} in a {@link Facet}
	 * 
	 * @param selection
	 *            the current selection, should be a Facet
	 * @param editingDomain
	 *            the editing domain used to perform the EMF command
	 * @return the newly created wizard
	 */
	public IFacetChildrenWizard createAddFacetAttributeWizardDialog(ISelection selection, EditingDomain editingDomain);

	/**
	 * Create a wizard dialog dedicated to the addition of a {@link FacetOperation} in a {@link Facet}
	 * 
	 * @param selection
	 *            the current selection, should be a Facet
	 * @param editingDomain
	 *            the editing domain used to perform the EMF command
	 * @return the newly created wizard
	 */
	public IFacetChildrenWizard createAddFacetOperationWizardDialog(ISelection selection, EditingDomain editingDomain);

	/**
	 * Create a wizard dialog dedicated to the addition of a {@link EParameter} to a {@link FacetOperation}
	 * 
	 * @param selection
	 *            the current selection, should be a FacetOperation
	 * @param editingDomain
	 *            the editing domain used to perform the EMF command
	 * @return the newly created wizard
	 */
	public IFacetChildrenWizard createAddFacetOperationParameterWizardDialog(ISelection selection, EditingDomain editingDomain);

	/**
	 * Create a wizard dialog dedicated to the addition of a {@link FacetReference} in a {@link Facet}
	 * 
	 * @param selection
	 *            the current selection, should be a Facet Reference
	 * @param editingDomain
	 *            the editing domain used to perform the EMF command
	 * @return the newly created wizard
	 */
	public IFacetChildrenWizard createAddFacetReferenceWizardDialog(ISelection selection, EditingDomain editingDomain);

}
