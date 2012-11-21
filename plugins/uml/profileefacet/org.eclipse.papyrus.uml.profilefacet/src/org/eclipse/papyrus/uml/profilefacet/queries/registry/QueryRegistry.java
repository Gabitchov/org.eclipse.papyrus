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
package org.eclipse.papyrus.uml.profilefacet.queries.registry;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.facet.infra.query.ModelQuery;
import org.eclipse.emf.facet.infra.query.ModelQuerySet;
import org.eclipse.emf.facet.infra.query.core.ModelQuerySetCatalog;



public class QueryRegistry {

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

	public static final String DATATYPE_MULTI_VALUE_OPERATION_ID = "getDatatypeMultiValue";//$NON-NLS-1$

	public static final String DATATYPE_SINGLE_VALUE_OPERATION_ID = "getDatatypeSingleValue";//$NON-NLS-1$

	public static final String PRIMITIVE_TYPE_MULTI_VALUE_OPERATION_ID = "getPrimitiveTypeMultiValue";//$NON-NLS-1$

	public static final String PRIMITIVE_TYPE_SINGLE_VALUE_OPERATION_ID = "getPrimitiveTypeSingleValue";//$NON-NLS-1$

	/** this map register the Query : key = id of the operation, value = the operation itself */
	private final Map<String, ModelQuery> registry;

	private static final String UML_STEREOTYPE_QUERY_SET_NAME = "uml_stereotype_queries";


	public QueryRegistry() {
		final ModelQuerySet set = getQuerySet(UML_STEREOTYPE_QUERY_SET_NAME);
		assert set != null;
		this.registry = new HashMap<String, ModelQuery>();
		for(final ModelQuery query : set.getQueries()) {
			this.registry.put(query.getName(), query);
		}
	}

	/**
	 * 
	 * @param id
	 *        the id of the looked operation for
	 * @return
	 */
	public ModelQuery getFacetOperation(final String id) {
		ModelQuery op = this.registry.get(id);
		assert op != null;
		return op;
	}


	
	private static final ModelQuerySet getQuerySet(final String facetName) {
		return ModelQuerySetCatalog.getSingleton().getModelQuerySet(facetName);
	}

}
