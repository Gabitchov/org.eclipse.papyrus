package org.eclipse.papyrus.infra.emf.facet.queries.factory;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.facet.infra.query.ModelQuery;
import org.eclipse.emf.facet.infra.query.core.AbstractModelQuery;
import org.eclipse.emf.facet.infra.query.core.IModelQueryFactory;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryException;
import org.eclipse.papyrus.infra.emf.facet.queries.parametric.FacetParametricQuery;
import org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.ParametricQuery;
import org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.ParametricqueryPackage;
import org.osgi.framework.Bundle;


public class ParametricQueryFactory implements IModelQueryFactory {

	public ParametricQueryFactory() {

	}

	public AbstractModelQuery create(ModelQuery modelQuery, Bundle bundle) throws ModelQueryException {
		Assert.isTrue(modelQuery instanceof ParametricQuery);
		return new FacetParametricQuery((ParametricQuery)modelQuery);
	}

	public EClass getManagedModelQueryType() {
		return ParametricqueryPackage.eINSTANCE.getParametricQuery();
	}

}
