package org.eclipse.papyrus.core.queries.test.modisco.queries;

import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.NamedElement;

/** test - test if the name of the element is equal to the specified name */
public class CopyOfIsNamed implements IJavaModelQuery<NamedElement, Boolean> {

	/**
	 * {@inheritDoc}
	 */
	public Boolean evaluate(final NamedElement context, final ParameterValueList parameterValues)
			throws ModelQueryExecutionException {
		// retrieve the parameter name
		Object value = parameterValues.getParameterValueByName("name");
		if(value == null) {
			throw new ModelQueryExecutionException("The parameter name has no values");
		}
		if(!(value instanceof LiteralString)) {
			throw new ModelQueryExecutionException("The parameter name does not have a String value");
		}

		if(context == null) {
			throw new ModelQueryExecutionException("The context is null, should be a NamedElement");
		}

		return ((LiteralString)value).stringValue().equalsIgnoreCase(context.getName());

	}
}
