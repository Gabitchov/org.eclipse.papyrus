package org.eclipse.papyrus.core.queries.test.modisco.queries;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.uml2.uml.NamedElement;

/** test - AND query */
public class AND implements IJavaModelQuery<NamedElement, Boolean> {

	/**
	 * {@inheritDoc}
	 */
	public Boolean evaluate(final NamedElement context, final ParameterValueList parameterValues)
			throws ModelQueryExecutionException {
		// retrieve operand left
		boolean leftValue = (Boolean)parameterValues.getValueByParameterName("AND_leftOperand");
		// retrieve operand right
		boolean rightValue = (Boolean)parameterValues.getValueByParameterName("AND_rightOperand");
		// return value
		return (leftValue && rightValue);
	}
}
