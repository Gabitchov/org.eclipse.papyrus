package org.eclipse.papyrus.core.queries.test.modisco.queries;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.uml2.uml.NamedElement;

/** test - check if the element's name is longer than the specified number. The booelan indicates if it is tru when length is equal. */
public class IsNameLongerThan implements IJavaModelQuery<NamedElement, Boolean> {

	/**
	 * {@inheritDoc}
	 */
	public Boolean evaluate(final NamedElement context, final ParameterValueList parameterValues)
			throws ModelQueryExecutionException {
		// retrieve the 2 values for the query
		boolean isTrueWhenEqual = (Boolean)parameterValues.getValueByParameterName("isTrueWhenEqual");
		int length = (Integer)parameterValues.getValueByParameterName("length");

		if(!(context instanceof NamedElement)) {
			throw new ModelQueryExecutionException("context is null or is not a Named Element");
		}

		String name = context.getName();
		if(name == null) {
			return false;
		}

		if(name.length() == length) {
			return isTrueWhenEqual;
		} else if(name.length() > length) {
			return true;
		}
		return false;

	}
}
