package org.eclipse.papyrus.infra.emf.facet.queries.parametric;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.facet.infra.query.ModelQuery;
import org.eclipse.emf.facet.infra.query.ModelQueryParameter;
import org.eclipse.emf.facet.infra.query.core.AbstractModelQuery;
import org.eclipse.emf.facet.infra.query.core.ModelQuerySetCatalog;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryException;
import org.eclipse.emf.facet.infra.query.runtime.ModelQueryContext;
import org.eclipse.emf.facet.infra.query.runtime.ModelQueryParameterValue;
import org.eclipse.emf.facet.infra.query.runtime.ModelQueryResult;
import org.eclipse.emf.facet.infra.query.runtime.RuntimeFactory;
import org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.Argument;
import org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.EStructuralFeatureArgument;
import org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.ParametricQuery;
import org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.StringArgument;


public class FacetParametricQuery extends AbstractModelQuery {

	protected ParametricQuery parametricModelQuery;

	public FacetParametricQuery(ParametricQuery modelQuery) {
		super(modelQuery);
		this.parametricModelQuery = modelQuery;
	}

	@Override
	public Object basicEvaluate(EObject context, List<ModelQueryParameterValue> parameterValues) throws ModelQueryException {
		ModelQuery calledQuery = parametricModelQuery.getCalledQuery();
		List<Argument> arguments = parametricModelQuery.getArguments();

		final ModelQuerySetCatalog querySetCatalog = ModelQuerySetCatalog.getSingleton();
		if(calledQuery != null) {
			final AbstractModelQuery modelQueryImpl = querySetCatalog.getModelQueryImpl(calledQuery);
			ModelQueryContext modelQueryContext = RuntimeFactory.eINSTANCE.createModelQueryContext();
			modelQueryContext.getSelectedModelElements().add(context);

			List<ModelQueryParameterValue> calledParameterValues = getParameterValues(calledQuery, arguments);

			List<ModelQueryResult> result = modelQueryImpl.evaluate(modelQueryContext, calledParameterValues);
			return result;
		}

		return Collections.emptyList();
	}

	private List<ModelQueryParameterValue> getParameterValues(ModelQuery calledQuery, List<Argument> arguments) {
		List<ModelQueryParameterValue> result = new LinkedList<ModelQueryParameterValue>();
		int i = 0;

		for(Argument argument : arguments) {
			ModelQueryParameter parameter = calledQuery.getParameters().get(i);
			ModelQueryParameterValue parameterValue = RuntimeFactory.eINSTANCE.createModelQueryParameterValue();
			parameterValue.setParameter(parameter);

			if(argument instanceof StringArgument) {
				//TODO: Check type conformance with the parameter
				parameterValue.setValue(((StringArgument)argument).getValue());
			} else if(argument instanceof EStructuralFeatureArgument) {
				parameterValue.setValue(((EStructuralFeatureArgument)argument).getValue());
			}

			result.add(parameterValue);
			i++;
		}
		return result;
	}
}
