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
package org.eclipse.papyrus.uml.profilefacet.queries.getter;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQueryWithEditingDomain;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypeFacet;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyElement;
import org.eclipse.papyrus.uml.profilefacet.utils.ArgumentUtils;
import org.eclipse.papyrus.uml.profilefacet.utils.StereotypePropertyUtils;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;


public class GetGenericSingleValue<R> implements IJavaModelQueryWithEditingDomain<Element, R> {


	/**
	 * 
	 * @see org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery#evaluate(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.facet.infra.query.core.java.ParameterValueList)
	 * 
	 * @param source
	 * @param parameterValues
	 * @return
	 * @throws ModelQueryExecutionException
	 */
	public R evaluate(final Element source, final ParameterValueList parameterValues) throws ModelQueryExecutionException {
		final StereotypePropertyElement element = (StereotypePropertyElement)parameterValues.getParameterValueByName(ArgumentUtils.EDITED_FEATURE).getValue();
		if(element != null) {
			final String propertyQN = element.getPropertyQualifiedName();
			final String propertyName = NamedElementUtil.getNameFromQualifiedName(propertyQN);
			final Stereotype appliedSte = StereotypePropertyUtils.getAppliedStereotype(source, element);
			return (R)source.getValue(appliedSte, propertyName);
		}

		return null;
	}

	/**
	 * 
	 * @see org.eclipse.emf.facet.infra.query.core.java.IJavaModelQueryWithEditingDomain#evaluate(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.facet.infra.query.core.java.ParameterValueList, org.eclipse.emf.edit.domain.EditingDomain)
	 * 
	 * @param context
	 * @param parameterValues
	 * @param editingDomain
	 * @return
	 * @throws ModelQueryExecutionException
	 */
	public R evaluate(final Element context, final ParameterValueList parameterValues, EditingDomain editingDomain) throws ModelQueryExecutionException {
		return evaluate(context, parameterValues);
	}

}
