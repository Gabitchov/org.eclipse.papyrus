package org.eclipse.papyrus.customization.paletteconfiguration.queries;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.Configuration;

/** Returns <code>true</code> if the element has a specific icon to display */
public class HasIconQuery implements IJavaModelQuery<Configuration, Boolean> {
	public Boolean evaluate(final Configuration context, final ParameterValueList parameterValues)
		throws ModelQueryExecutionException {

		IJavaModelQuery<Configuration, String> getImageQuery = new GetIconQuery();
		String imagePath = getImageQuery.evaluate(context, parameterValues);

		if(imagePath!=null && imagePath.length() > 0) {
			return true;
		}
		return false;
	}
}
