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

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.papyrus.sysml.requirements.Requirement;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.util.UMLUtil;

/** Query to get the text of the requirement */
public class GetRequirementDerivedQuery implements IJavaModelQuery<Class, Collection<Class>> {

	public Collection<Class> evaluate(final Class context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {
		Collection<Class> result = new ArrayList<Class>();

		Requirement requirement = UMLUtil.getStereotypeApplication(context, Requirement.class);
		if(requirement != null) {
			for(Requirement current : requirement.getDerived()) {
				result.add(current.getBase_Class());
			}
		}
		return result;
	}
}
