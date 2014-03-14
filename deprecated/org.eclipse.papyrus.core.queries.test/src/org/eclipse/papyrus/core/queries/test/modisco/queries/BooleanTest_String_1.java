package org.eclipse.papyrus.core.queries.test.modisco.queries;

import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.papyrus.core.queries.test.modisco.IQueryNames;
import org.eclipse.uml2.uml.Element;

/** test - boolean return value - String[1] */
public class BooleanTest_String_1 implements IJavaModelQuery<Element, Boolean> {

	/**
	 * {@inheritDoc}
	 */
	public Boolean evaluate(final Element context, final ParameterValueList parameterValues)
			throws ModelQueryExecutionException {
		return (parameterValues.getValueByParameterName(IQueryNames.BooleanTest_String_1_StringParamName) instanceof String);
	}
}
