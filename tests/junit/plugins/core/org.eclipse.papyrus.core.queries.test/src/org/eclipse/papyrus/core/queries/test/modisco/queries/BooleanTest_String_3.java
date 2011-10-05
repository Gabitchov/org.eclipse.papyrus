package org.eclipse.papyrus.core.queries.test.modisco.queries;
import org.eclipse.uml2.uml.Element;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;

/** test - boolean return value - String[3] */
public class BooleanTest_String_3 implements IJavaModelQuery<Element, Boolean> {

	/**
	 * {@inheritDoc}
	 */
	public Boolean evaluate(final Element context, final ParameterValueList parameterValues)
			throws ModelQueryExecutionException {
		return true;
	}
}
