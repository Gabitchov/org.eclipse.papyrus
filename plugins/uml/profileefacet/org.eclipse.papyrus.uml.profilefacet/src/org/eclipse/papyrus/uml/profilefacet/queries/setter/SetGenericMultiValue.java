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
package org.eclipse.papyrus.uml.profilefacet.queries.setter;

import java.util.List;

import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.uml2.uml.Element;

public abstract class SetGenericMultiValue<R> extends
		SetGenericSingleValue<List<R>> {

	@Override
	public List<R> evaluate(Element source, ParameterValueList parameterValues)
			throws ModelQueryExecutionException {
		// FIXME
		return super.evaluate(source, parameterValues);
	}
	// public List<R> evaluate(final Element source, final IParameterValueList2
	// parameterValues, final IFacetManager facetManager) throws
	// DerivedTypedElementException {
	// final List<R> value = super.evaluate(source, parameterValues,
	// facetManager);
	// if(value == null) {
	// return Collections.emptyList();
	// } else {
	// return value;
	// }
	// }

}
