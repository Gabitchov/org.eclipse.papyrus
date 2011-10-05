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
import org.eclipse.papyrus.sysml.requirements.Requirement;
import org.eclipse.papyrus.sysml.util.ElementUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.NamedElement;

/** Query to get the text of the requirement */
public class GetRequirementRefinedByQuery implements IJavaModelQuery<Class, Collection<NamedElement>> {

	public Collection<NamedElement> evaluate(final Class context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {
		Requirement requirement = ElementUtil.getStereotypeApplication(context, Requirement.class);
		return (requirement != null) ? requirement.getRefinedBy() : null;
	}
}
