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
 *  Gregoire Dupe (Mia-Software) - Bug 361617 - Deprecation of APIs for the old Facet metamodels
 */
package org.eclipse.papyrus.emf.facet.efacet.ui.internal;

import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetAttribute;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetReference;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.exported.wizard.ICreateFacetInFacetSetWizard2;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.exported.wizard.ICreateFacetSetWizard;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.exported.wizard.IFacetChildrenWizard2;
import org.eclipse.jface.viewers.ISelection;

/**
 * This interface provides methods used to create wizards that create {@link Facet}s and Facet elements.
 * 
 * TODO: This interface has to be renamed to IFacetUIFactory before the release of 0.2
 * 
 * @since 0.2
 */
//TODO: This interface has to be renamed to IFacetUIFactory before the release of 0.2
public interface IFacetUIFactory2 {

	/**
	 * Returns an instance of a {@link FacetUIFactoryImpl}
	 */
	IFacetUIFactory2 INSTANCE = null; //TODO cf. https://bugs.eclipse.org/bugs/show_bug.cgi?id=364601

	/**
	 * Create a wizard dialog dedicated to the addition of a {@link Facet} in a {@link FacetSet}
	 * 
	 * @param selection
	 *            the current selection, should be a FacetSet
	 * @param editingDomain
	 *            the editing domain used to perform the EMF command
	 * @return the newly created wizard
	 */
	public ICreateFacetInFacetSetWizard2 createCreateFacetInFacetSetWizardDialog(ISelection selection, EditingDomain editingDomain);

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
	public IFacetChildrenWizard2 createAddFacetAttributeWizardDialog(ISelection selection, EditingDomain editingDomain);

	/**
	 * Create a wizard dialog dedicated to the addition of a {@link FacetOperation} in a {@link Facet}
	 * 
	 * @param selection
	 *            the current selection, should be a Facet
	 * @param editingDomain
	 *            the editing domain used to perform the EMF command
	 * @return the newly created wizard
	 */
	public IFacetChildrenWizard2 createAddFacetOperationWizardDialog(ISelection selection, EditingDomain editingDomain);

	/**
	 * Create a wizard dialog dedicated to the addition of a {@link EParameter} to a {@link FacetOperation}
	 * 
	 * @param selection
	 *            the current selection, should be a FacetOperation
	 * @param editingDomain
	 *            the editing domain used to perform the EMF command
	 * @return the newly created wizard
	 */
	public IFacetChildrenWizard2 createAddFacetOperationParameterWizardDialog(ISelection selection, EditingDomain editingDomain);

	/**
	 * Create a wizard dialog dedicated to the addition of a {@link FacetReference} in a {@link Facet}
	 * 
	 * @param selection
	 *            the current selection, should be a Facet Reference
	 * @param editingDomain
	 *            the editing domain used to perform the EMF command
	 * @return the newly created wizard
	 */
	public IFacetChildrenWizard2 createAddFacetReferenceWizardDialog(ISelection selection, EditingDomain editingDomain);

}
