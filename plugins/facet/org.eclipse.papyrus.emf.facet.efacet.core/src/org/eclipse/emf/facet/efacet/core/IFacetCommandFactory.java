/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.emf.facet.efacet.core;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetAttribute;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetReference;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;

/**
 * This interface provide a command factory. A command modify the editingDomain.
 * 
 * @since 0.3
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface IFacetCommandFactory {

	/**
	 * Create the command to add a FacetSet (facetSet) to an existing FacetSet
	 * (parent).
	 * 
	 * @param parent
	 *            the parent of the facetSet to add.
	 * @param facetSet
	 *            the facetSet to add.
	 * @return the command.
	 */
	Command createFacetSetInFacetSetCommand(FacetSet parent, FacetSet facetSet);

	/**
	 * Create the command to add a Facet (facet) to an existing FacetSet
	 * (parent).
	 * 
	 * @param parent
	 *            the parent of the facet to add.
	 * @param facet
	 *            the facet to add.
	 * @return the command.
	 */
	Command createFacetInFacetSetCommand(FacetSet parent, Facet facet);

	/**
	 * Create the command to add an Attribute (facetAttrbute) to an existing
	 * Facet (parent).
	 * 
	 * @param parent
	 *            the parent of the attribute to add.
	 * @param facetAttrbute
	 *            the attribute to add.
	 * @return the command.
	 */
	Command createEditFacetStructuralFeatureCommand(
			final DerivedTypedElement feature, final Facet container,
			final String name, final int lowerBd, final int upperBd,
			final EClassifier type, final boolean ordered,
			final boolean unique, final Query query, final boolean volatilee,
			final boolean change, final boolean derived,
			final boolean transientt);

	/**
	 * Create the command to add a Reference (facetReference) to an existing
	 * Facet (parent).
	 * 
	 * @param parent
	 *            the parent of the reference to add.
	 * @param facetReference
	 *            the reference to add.
	 * @return the command.
	 */
	Command createAddReferenceInFacetCommand(Facet parent,
			FacetReference facetReference);

	/**
	 * Create the command to add an Operation (FacetOperation) to an existing
	 * Facet (parent).
	 * 
	 * @param parent
	 *            the parent of the operation to add.
	 * @param facetOperation
	 *            the operation to add.
	 * @return the command.
	 */
	Command createAddOperationInFacetCommand(Facet parent,
			FacetOperation facetOperation);

	/**
	 * Create the command to add a Parameter (operationParameter) to an existing
	 * Operation (parent).
	 * 
	 * @param parent
	 *            the parent of the operation to add.
	 * @param facetOperation
	 *            the operation to add.
	 * @return the command.
	 */
	Command createAddParameterInOperationCommand(FacetOperation parent,
			EParameter opeParameter);

	/**
	 * Create the command to change the owner of an element.
	 * 
	 * @param element
	 * @param newOwner
	 * @return
	 */
	Command createChangeOwnerCommand(Object element, Object newOwner);

	/**
	 * Create the command to change the attributes of a FacetSet.
	 * 
	 * @param initialElement
	 * @param newElement
	 * @param newElement
	 * @return
	 */
	Command createEditFacetSetCommand(final FacetSet editedFacetSet,
			final FacetSet container, final String name);

	/**
	 * Create the command to change the attributes of a Facet.
	 * 
	 * @param initialElement
	 * @param newElement
	 * @return
	 */
	Command createEditFacetCommand(Facet facet, FacetSet container,
			String name, ETypedElement conformance, EClass extendEClass,
			FacetSet extendedFacetSet);

	/**
	 * Create the command to change the attributes of a FacetAttribute.
	 * 
	 * @param initialElement
	 * @param newElement
	 * @return
	 */
	Command createSetFacetAttributeCommand(final Facet initialContainer,
			final FacetAttribute initialElement,
			final FacetAttribute newElement);

	/**
	 * Create the command to change the attributes of a FacetReference.
	 * 
	 * @param initialElement
	 * @param newElement
	 * @return
	 */
	Command createSetFacetReferenceCommand(final Facet initialContainer,
			final FacetReference initialElement,
			final FacetReference newElement);

	/**
	 * Create the command to change the attributes of a FacetOperation.
	 * 
	 * @param initialElement
	 * @param newElement
	 * @return
	 */
	Command createEditFacetOperationCommand(DerivedTypedElement dte,
			Facet facetContainer, String name, int lowerBound, int upperBound,
			EClassifier type, boolean ordered, boolean unique, Query query);

	/**
	 * Create the command to change the attributes of a FacetAttribute.
	 * 
	 * @param initialElement
	 * @param newElement
	 * @return
	 */
	Command createEditOperationParameterCommand(EParameter parameter,
			FacetOperation container, String name, int lowerBound,
			int upperBound, EClassifier type, boolean ordered, boolean unique);

}
