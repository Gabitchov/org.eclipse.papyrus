package org.eclipse.papyrus.uml.modelexplorer.queries;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.gmt.modisco.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.gmt.modisco.infra.query.core.java.IJavaModelQuery;
import org.eclipse.gmt.modisco.infra.query.core.java.ParameterValueList;

/** get the name + the list of stereotypes from a named Element */
public class GetName implements IJavaModelQuery<NamedElement, String> {
	public String evaluate(final NamedElement context, final ParameterValueList parameterValues)
			throws ModelQueryExecutionException {
		// TODO Auto-generated method stub
		return context.getName();
	}
}
