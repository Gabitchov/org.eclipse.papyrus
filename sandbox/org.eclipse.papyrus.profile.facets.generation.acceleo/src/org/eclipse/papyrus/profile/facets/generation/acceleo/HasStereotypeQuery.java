/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.profile.facets.generation.acceleo;

import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * 
 * This class allows to test if a FacetSet can be used for an UML Element
 * 
 */
public class HasStereotypeQuery implements IJavaModelQuery<Element, Boolean> {

	/** the id of the stereotype */
	private final String stereotypeID;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param stereotypeID
	 */
	public HasStereotypeQuery(final String stereotypeID) {
		this.stereotypeID = stereotypeID;
	}

	/**
	 * 
	 * @see org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery#evaluate(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.facet.infra.query.core.java.ParameterValueList)
	 * 
	 * @param context
	 * @param parameterValues
	 * @return
	 * @throws ModelQueryExecutionException
	 */
	public Boolean evaluate(final Element context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {
		Stereotype ste = context.getAppliedStereotype(stereotypeID);
		if(ste != null) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
}
