package org.eclipse.papyrus.uml.modelexplorer.queries;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.uml2.uml.NamedElement;

/** get the name + the list of stereotypes from a named Element */
public class GetName implements IJavaModelQuery<NamedElement, String> {
	public String evaluate(final NamedElement context, final ParameterValueList parameterValues)
			throws ModelQueryExecutionException {
		// TODO Auto-generated method stub
		return context.getName();
	}
}
