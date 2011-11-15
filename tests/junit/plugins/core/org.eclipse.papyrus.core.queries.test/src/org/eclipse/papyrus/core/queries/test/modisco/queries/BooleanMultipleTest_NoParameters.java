/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.core.queries.test.modisco.queries;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.uml2.uml.Element;

/** test - boolean return multiple values - no parameters */
public class BooleanMultipleTest_NoParameters implements IJavaModelQuery<Element, Collection<Boolean>> {

	/**
	 * {@inheritDoc}
	 */
	public Collection<Boolean> evaluate(final Element context, final ParameterValueList parameterValues)
			throws ModelQueryExecutionException {
		return Arrays.asList(true, false, true);
	}
}
