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
import org.eclipse.papyrus.sysml.requirements.TestCase;
import org.eclipse.papyrus.sysml.util.ElementUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Operation;

/** Query to get the text of the requirement */

public class GetRequirementVerifiedByQuery implements IJavaModelQuery<Class, Collection<Operation>> {

	public Collection<Operation> evaluate(final Class context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {
		Collection<Operation> result = new ArrayList<Operation>();
		
		Requirement requirement = ElementUtil.getStereotypeApplication(context, Requirement.class);
		if (requirement != null) {
			for(TestCase current : requirement.getVerifiedBy()) {
				result.add(current.getBase_Operation());
			}	
		}
		return result;
	}
}
