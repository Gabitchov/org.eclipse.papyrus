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
package org.eclipse.papyrus.sysml.facets.query.value.getter;

import java.util.Collection;

import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Stereotype;

/** Query to get the text of the requirement */

public class GetRequirementVerifiedByQuery implements IJavaModelQuery<Class, Collection<Operation>> {

	public Collection<Operation> evaluate(final Class context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {
		Stereotype ste = context.getAppliedStereotype(SysmlResource.REQUIREMENT_ID);
		if(ste != null) {
			Object value = context.getValue(ste, SysmlResource.REQUIREMENT_VERIFIED_BY_ID);
			return (Collection<Operation>)value;
		}
		return null;
	}
}
