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
package org.eclipse.papyrus.infra.emf.facet.queries.factory;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.facet.infra.query.ModelQuery;
import org.eclipse.emf.facet.infra.query.core.AbstractModelQuery;
import org.eclipse.emf.facet.infra.query.core.IModelQueryFactory;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryException;
import org.eclipse.papyrus.infra.emf.facet.queries.parametric.FacetParametricQuery;
import org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.ParametricQuery;
import org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.ParametricqueryFactory;
import org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.ParametricqueryPackage;
import org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.impl.ParametricQueryImpl;
import org.osgi.framework.Bundle;


public class ParametricQueryFactory implements IModelQueryFactory {

	public ParametricQueryFactory() {

	}

	public AbstractModelQuery create(ModelQuery modelQuery, Bundle bundle) throws ModelQueryException {
		Assert.isTrue(modelQuery instanceof ParametricQueryImpl);
		return new FacetParametricQuery((ParametricQuery)modelQuery);
	}

	public EClass getManagedModelQueryType() {
		return ParametricqueryPackage.eINSTANCE.getParametricQuery();
	}

}
