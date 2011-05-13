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
package org.eclipse.papyrus.sysml.table.requirement.queries;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Stereotype;

/**
 * Test if the eobject is a Requirement
 * 
 * 
 * 
 */
public class IsRequirement implements IJavaModelQuery<EObject, Boolean> {

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
	public Boolean evaluate(final EObject context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {

		if(context instanceof Classifier) {
			Classifier classifier = (Classifier)context;
			Stereotype ste = classifier.getAppliedStereotype(SysmlResource.REQUIREMENT_ID);
			return ste != null ? Boolean.TRUE : Boolean.FALSE;
		}
		return Boolean.FALSE;
	}
}
