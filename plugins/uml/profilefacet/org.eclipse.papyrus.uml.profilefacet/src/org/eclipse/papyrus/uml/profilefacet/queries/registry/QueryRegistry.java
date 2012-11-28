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
	public static final String GET_STRING_SINGLE_VALUE_OPERATION_ID = "getStringSingleValue"; //$NON-NLS-1$

	public static final String GET_STRING_MULTI_VALUE_OPERATION_ID = "getStringMultiValue"; //$NON-NLS-1$

	public static final String GET_EOBJECT_SINGLE_REFERENCE_OPERATION_ID = "getEObjectSingleReferenceValue"; //$NON-NLS-1$

	public static final String GET_EOBJECT_MULTI_REFERENCE_OPERATION_ID = "getEObjectMultiReferenceValue"; //$NON-NLS-1$

	public static final String GET_BOOLEAN_SINGLE_VALUE_OPERATION_ID = "getBooleanSingleValue"; //$NON-NLS-1$

	public static final String GET_BOOLEAN_MULTI_VALUE_OPERATION_ID = "getBooleanMultiValue"; //$NON-NLS-1$

	public static final String GET_INTEGER_SINGLE_VALUE_OPERATION_ID = "getIntegerSingleValue"; //$NON-NLS-1$

	public static final String GET_INTEGER_MULTI_VALUE_OPERATION_ID = "getIntegerMultiValue"; //$NON-NLS-1$

	public static final String GET_REAL_SINGLE_VALUE_OPERATION_ID = "getRealSingleValue"; //$NON-NLS-1$

	public static final String GET_REAL_MULTI_VALUE_OPERATION_ID = "getRealMultiValue"; //$NON-NLS-1$

	public static final String GET_UNLIMITED_NATURAL_SINGLE_VALUE_OPERATION_ID = "getUnlimitedNaturalSingleValue"; //$NON-NLS-1$

	public static final String GET_UNLIMITED_NATURAL_MULTI_VALUE_OPERATION_ID = "getUnlimitedNaturalMultiValue"; //$NON-NLS-1$

	public static final String GET_UML_ENUMERATION_SINGLE_VALUE_OPERATION_ID = "getUMLEnumerationSingleValue"; //$NON-NLS-1$

	public static final String GET_UML_ENUMERATION_MULTI_VALUE_OPERATION_ID = "getUMLEnumerationMultiValue"; //$NON-NLS-1$

	public static final String GET_DATATYPE_MULTI_VALUE_OPERATION_ID = "getDatatypeMultiValue";//$NON-NLS-1$

	public static final String GET_DATATYPE_SINGLE_VALUE_OPERATION_ID = "getDatatypeSingleValue";//$NON-NLS-1$

	public static final String GET_PRIMITIVE_TYPE_MULTI_VALUE_OPERATION_ID = "getPrimitiveTypeMultiValue";//$NON-NLS-1$

	public static final String GET_PRIMITIVE_TYPE_SINGLE_VALUE_OPERATION_ID = "getPrimitiveTypeSingleValue";//$NON-NLS-1$


	public static final String SET_STRING_SINGLE_VALUE_OPERATION_ID = "setStringSingleValue"; //$NON-NLS-1$

	public static final String SET_STRING_MULTI_VALUE_OPERATION_ID = "setStringMultiValue"; //$NON-NLS-1$

	public static final String SET_EOBJECT_SINGLE_REFERENCE_OPERATION_ID = "setEObjectSingleReferenceValue"; //$NON-NLS-1$

	public static final String SET_EOBJECT_MULTI_REFERENCE_OPERATION_ID = "setEObjectMultiReferenceValue"; //$NON-NLS-1$

	public static final String SET_BOOLEAN_SINGLE_VALUE_OPERATION_ID = "setBooleanSingleValue"; //$NON-NLS-1$

	public static final String SET_BOOLEAN_MULTI_VALUE_OPERATION_ID = "setBooleanMultiValue"; //$NON-NLS-1$

	public static final String SET_INTEGER_SINGLE_VALUE_OPERATION_ID = "setIntegerSingleValue"; //$NON-NLS-1$

	public static final String SET_INTEGER_MULTI_VALUE_OPERATION_ID = "setIntegerMultiValue"; //$NON-NLS-1$

	public static final String SET_REAL_SINGLE_VALUE_OPERATION_ID = "setRealSingleValue"; //$NON-NLS-1$

	public static final String SET_REAL_MULTI_VALUE_OPERATION_ID = "setRealMultiValue"; //$NON-NLS-1$

	public static final String SET_UNLIMITED_NATURAL_SINGLE_VALUE_OPERATION_ID = "setUnlimitedNaturalSingleValue"; //$NON-NLS-1$

	public static final String SET_UNLIMITED_NATURAL_MULTI_VALUE_OPERATION_ID = "setUnlimitedNaturalMultiValue"; //$NON-NLS-1$

	public static final String SET_UML_ENUMERATION_SINGLE_VALUE_OPERATION_ID = "setUMLEnumerationSingleValue"; //$NON-NLS-1$

	public static final String SET_UML_ENUMERATION_MULTI_VALUE_OPERATION_ID = "setUMLEnumerationMultiValue"; //$NON-NLS-1$

	public static final String SET_DATATYPE_MULTI_VALUE_OPERATION_ID = "setDatatypeMultiValue";//$NON-NLS-1$

	public static final String SET_DATATYPE_SINGLE_VALUE_OPERATION_ID = "setDatatypeSingleValue";//$NON-NLS-1$

	public static final String SET_PRIMITIVE_TYPE_MULTI_VALUE_OPERATION_ID = "setPrimitiveTypeMultiValue";//$NON-NLS-1$

	public static final String SET_PRIMITIVE_TYPE_SINGLE_VALUE_OPERATION_ID = "setPrimitiveTypeSingleValue";//$NON-NLS-1$

	public static final String IS_APPLIED_REQUIRED_STEREOTYPE = "isAppliedRequiredStereotype";


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
	public ModelQuery getModelQuery(final String id) {
		ModelQuery op = this.registry.get(id);
		assert op != null;
		return op;
	}



	private static final ModelQuerySet getQuerySet(final String facetName) {
		return ModelQuerySetCatalog.getSingleton().getModelQuerySet(facetName);
	}

}
