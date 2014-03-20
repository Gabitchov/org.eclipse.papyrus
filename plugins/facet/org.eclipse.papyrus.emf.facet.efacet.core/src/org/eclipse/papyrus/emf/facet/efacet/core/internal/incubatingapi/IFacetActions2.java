/**
 * Copyright (c) 2011 Mia-Software.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Nicolas Guyomar (Mia-Software) - Bug 338813 - [EMF Facet Framework] basic Facet actions
 *  Nicolas Bros (Mia-Software) - Bug 361612 - New core for new version of the Facet metamodel
 *  Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 */
package org.eclipse.papyrus.emf.facet.efacet.core.internal.incubatingapi;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.efacet.core.internal.FacetActions2Impl;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetAttribute;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetReference;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.papyrus.emf.facet.util.emf.core.exception.InvalidFacetSetException;

/**
 * This interface contains methods to create {@link Facet}s.
 *
 * @since 0.2
 */
public interface IFacetActions2 {

	IFacetActions2 INSTANCE = new FacetActions2Impl();

	/**
	 * Add the given facetSet to the given facetSet model file, which will be created
	 *
	 * @param facetSet
	 *            the facetSet to be created. Cannot be <code>null</code>
	 * @param project
	 *            the new file in which the facetSet has to be created. Cannot be <code>null</code>,
	 *            and cannot already exist
	 */
	void saveFacetSet(FacetSet facetSet, IFile file) throws IOException,
			InvalidFacetSetException;

	/**
	 * Add the given {@link Facet} to the given {@link FacetSet}
	 *
	 * @param facetSet
	 *            the parent facetSet, cannot be null
	 * @param facet
	 *            the {@link Facet}, cannot be null, or contained by a resource
	 * @param editingDomain
	 *            the editing domain needed to perform the Add EMF command, cannot be null
	 */
	Facet createFacetInFacetSet(FacetSet facetSet, Facet facet,
			EditingDomain editingDomain);

	/**
	 * Create a command to add the given {@link Facet} to the given {@link FacetSet}
	 *
	 * @param facetSet
	 *            the parent facetSet, cannot be null
	 * @param facet
	 *            the {@link Facet}, cannot be null, or contained by a resource
	 * @param editingDomain
	 *            the editing domain needed to perform the Add EMF command, cannot be null
	 */
	Command createCreateFacetInFacetSetCommand(FacetSet facetSet, Facet facet,
			EditingDomain editingDomain);

	/**
	 * Add the given {@link FacetAttribute} to the given {@link Facet}
	 *
	 * @param facet
	 *            the parent {@link Facet}, cannot be null
	 * @param facetAttribute
	 *            the {@link FacetAttribute}, cannot be null, or contained by a resource
	 * @param editingDomain
	 *            the editing domain needed to perform the Add Emf command, cannot be null
	 */
	void addAttributeInFacet(Facet facet, FacetAttribute facetAttribute,
			EditingDomain editingDomain);

	/**
	 * Create a command to add the given {@link FacetAttribute} to the given {@link Facet}
	 *
	 * @param facet
	 *            the parent {@link Facet}, cannot be null
	 * @param facetAttribute
	 *            the {@link FacetAttribute}, cannot be null, or contained by a resource
	 * @param editingDomain
	 *            the editing domain needed to perform the Add Emf command, cannot be null
	 */
	Command createAddAttributeInFacetCommand(Facet facet, FacetAttribute facetAttribute,
			EditingDomain editingDomain);

	/**
	 * Add the given {@link FacetReference} to the given {@link Facet}
	 *
	 * @param facet
	 *            the parent {@link Facet}, cannot be null
	 * @param facetReference
	 *            the {@link FacetReference}, cannot be null, or contained by a resource
	 * @param editingDomain
	 *            the editing domain needed to perform the Add Emf command, cannot be null
	 */
	void addReferenceInFacet(Facet facet, FacetReference facetReference,
			EditingDomain editingDomain);

	/**
	 * Create a command to add the given {@link FacetReference} to the given {@link Facet}
	 *
	 * @param facet
	 *            the parent {@link Facet}, cannot be null
	 * @param facetReference
	 *            the {@link FacetReference}, cannot be null, or contained by a resource
	 * @param editingDomain
	 *            the editing domain needed to perform the Add Emf command, cannot be null
	 */
	Command createAddReferenceInFacetCommand(Facet facet,
			FacetReference facetReference, EditingDomain editingDomain);

	/**
	 * Add a new {@link FacetOperation} to the given {@link Facet}
	 *
	 * @param facet
	 *            the parent {@link Facet}, cannot be null
	 * @param facetOperation
	 *            the new {@link FacetOperation}, cannot be null, or contained by a resource
	 * @param editingDomain
	 *            the editing domain needed to perform the Add Emf command, cannot be null
	 */
	void addOperationInFacet(Facet facet, FacetOperation facetOperation,
			EditingDomain editingDomain);

	/**
	 * Add a new {@link FacetOperation} to the given {@link Facet}
	 *
	 * @param facet
	 *            the parent {@link Facet}, cannot be null
	 * @param facetOperation
	 *            the new {@link FacetOperation}, cannot be null, or contained by a resource
	 * @param editingDomain
	 *            the editing domain needed to perform the Add Emf command, cannot be null
	 */
	Command createAddOperationInFacetCommand(Facet facet,
			FacetOperation facetOperation, EditingDomain editingDomain);

	/**
	 * Add a new {@link EParameter} to the given {@link FacetOperation}
	 *
	 * @param operation
	 *            the parent {@link EOperation}
	 * @param parameter
	 *            the new {@link EParameter}
	 * @param editingDomain
	 *            the editing domain needed to perform the Add Emf command, cannot be null
	 */
	void addParameterInOperation(FacetOperation operation,
			EParameter parameter, EditingDomain editingDomain);

	/**
	 * Add a new {@link EParameter} to the given {@link FacetOperation}
	 *
	 * @param operation
	 *            the parent {@link EOperation}
	 * @param parameter
	 *            the new {@link EParameter}
	 * @param editingDomain
	 *            the editing domain needed to perform the Add Emf command, cannot be null
	 */
	Command createAddParameterInOperationCommand(FacetOperation operation,
			EParameter parameter, EditingDomain editingDomain);

	/**
	 * Set the given URI to the given {@link FacetSet}
	 *
	 * @param facetSet
	 *            the {@link FacetSet} to be modified
	 * @param nsUri
	 *            the Uri
	 * @param editingDomain
	 *            the editing domain needed to perform the Set Emf command, cannot be null
	 */
	void setFacetSetNsUri(FacetSet facetSet, String nsUri,
			EditingDomain editingDomain);

	/**
	 * Set the given URI to the given {@link FacetSet}
	 *
	 * @param facetSet
	 *            the {@link FacetSet} to be modified
	 * @param nsUri
	 *            the Uri
	 * @param editingDomain
	 *            the editing domain needed to perform the Set Emf command, cannot be null
	 */
	Command createSetFacetSetNsUriCommand(FacetSet facetSet, String nsUri,
			EditingDomain editingDomain);

}
