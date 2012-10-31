/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.profileefacet.queries.registry;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.facet.efacet.core.IFacetSetCatalogManager;
import org.eclipse.emf.facet.efacet.core.IFacetSetCatalogManagerFactory;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.uml.profileefacet.Activator;
import org.eclipse.papyrus.uml.profileefacet.messages.Messages;


public class FacetOperationRegistry {

	/** the keys to get the FacetOperation */
	public static final String STRING_SINGLE_VALUE_OPERATION_ID = "getStringSingleValue"; //$NON-NLS-1$

	public static final String STRING_MULTI_VALUE_OPERATION_ID = "getStringMultiValue"; //$NON-NLS-1$

	public static final String EOBJECT_SINGLE_REFERENCE_OPERATION_ID = "getEObjectSingleReferenceValue"; //$NON-NLS-1$

	public static final String EOBJECT_MULTI_REFERENCE_OPERATION_ID = "getEObjectMultiReferenceValue"; //$NON-NLS-1$

	public static final String BOOLEAN_SINGLE_VALUE_OPERATION_ID = "getBooleanSingleValue"; //$NON-NLS-1$

	public static final String BOOLEAN_MULTI_VALUE_OPERATION_ID = "getBooleanMultiValue"; //$NON-NLS-1$

	public static final String INTEGER_SINGLE_VALUE_OPERATION_ID = "getIntegerSingleValue"; //$NON-NLS-1$

	public static final String INTEGER_MULTI_VALUE_OPERATION_ID = "getIntegerMultiValue"; //$NON-NLS-1$

	public static final String REAL_SINGLE_VALUE_OPERATION_ID = "getRealSingleValue"; //$NON-NLS-1$

	public static final String REAL_MULTI_VALUE_OPERATION_ID = "getRealMultiValue"; //$NON-NLS-1$

	public static final String UNLIMITED_NATURAL_SINGLE_VALUE_OPERATION_ID = "getUnlimitedNaturalSingleValue"; //$NON-NLS-1$

	public static final String UNLIMITED_NATURAL_MULTI_VALUE_OPERATION_ID = "getUnlimitedNaturalMultiValue"; //$NON-NLS-1$

	public static final String UML_ENUMERATION_SINGLE_VALUE_OPERATION_ID = "getUMLEnumerationSingleValue"; //$NON-NLS-1$

	public static final String UML_ENUMERATION_MULTI_VALUE_OPERATION_ID = "getUMLEnumerationMultiValue"; //$NON-NLS-1$

	/** this map register the FacetOperation : key = id of the operation, value = the operation itself */
	private final Map<String, FacetOperation> registry;

	/** The facet which provides the facetOperation */
	private final Facet stereotyped_element_facet;

	/** the NS_URI of the facetSet which contains the FacetOperation */
	private static final String STEREOTYPE_FACET_SET_URI = "org.eclipse.papyrus.uml.profileefacet/0.9/uml_stereotype"; //$NON-NLS-1$

	/** the name of the facet which contains the FacetOperation */
	private static final String STEREOTYPED_ELEMENT_FACET_NAME = "stereotyped_element"; //$NON-NLS-1$

	/**
	 * 
	 * Constructor.
	 * 
	 * @param resourceSet
	 *        the resourceset used by this registry to found the FacetElement
	 */
	public FacetOperationRegistry(final ResourceSet resourceSet) {
		// to rpevent instanciation
		this.registry = new HashMap<String, FacetOperation>();
		this.stereotyped_element_facet = getStereotypedElementFacet(resourceSet, STEREOTYPE_FACET_SET_URI, STEREOTYPED_ELEMENT_FACET_NAME);
		if(this.stereotyped_element_facet == null) {
			Activator.log.error(NLS.bind(Messages.FacetOperationRegistry_RequiredFacetNotFound, STEREOTYPED_ELEMENT_FACET_NAME), new NullPointerException());
		}
	}

	/**
	 * 
	 * @param id
	 *        the id of the looked operation for
	 * @return
	 */
	public FacetOperation getFacetOperation(final String id) {
		FacetOperation op = this.registry.get(id);
		if(op == null) {
			op = findFacetOperation(id);
			if(op == null) {
				Activator.log.error(NLS.bind(Messages.FacetOperationRegistry_RequiredFacetOperationNotFound, id), new NullPointerException());
			}
			this.registry.put(id, op);
		}
		return op;
	}

	/**
	 * 
	 * @param id
	 *        the id of the looked operation for
	 * @return
	 *         the wanted operation or <code>null</code> if not found
	 */
	private FacetOperation findFacetOperation(final String id) {
		for(final FacetOperation op : this.stereotyped_element_facet.getFacetOperations()) {
			if(id.equals(op.getName())) {
				return op;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param resourceSet
	 *        a resourceset
	 * @param facetSetURI
	 *        the uri of the facetset
	 * @param facetName
	 *        the name of the wanted facet
	 * @return
	 */
	private static final Facet getStereotypedElementFacet(final ResourceSet resourceSet, final String facetSetURI, final String facetName) {
		final IFacetSetCatalogManager manager = IFacetSetCatalogManagerFactory.DEFAULT.getOrCreateFacetSetCatalogManager(resourceSet);
		for(final FacetSet set : manager.getRegisteredFacetSets()) {
			if(STEREOTYPE_FACET_SET_URI.equals(set.getNsURI())) {
				final Facet facet = (Facet)set.getEClassifier(STEREOTYPED_ELEMENT_FACET_NAME);
				if(facet != null) {
					return facet;
				}
			}
		}
		return null;
	}

}
