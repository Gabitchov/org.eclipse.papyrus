package org.eclipse.papyrus.core.queries.test.modisco.queries;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;

/** test - test if an element is strict type of given value */
public class IsStrictInstanceOf implements IJavaModelQuery<EObject, Boolean> {
	
	/**
	 * {@inheritDoc}
	 */
	public Boolean evaluate(final EObject context, final ParameterValueList parameterValues)
			throws ModelQueryExecutionException {
		
		String eObjectTypeName = context.eClass().getInstanceTypeName();
		String typeName = parameterValues.getValueByParameterName("typeName").toString();
		
		return eObjectTypeName.equals(typeName);
	}
}
