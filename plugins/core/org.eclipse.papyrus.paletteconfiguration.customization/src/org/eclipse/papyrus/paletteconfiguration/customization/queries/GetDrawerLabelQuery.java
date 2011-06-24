package org.eclipse.papyrus.paletteconfiguration.customization.queries;
import org.eclipse.papyrus.paletteconfiguration.DrawerConfiguration;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;

/** Returns the label for a drawer */
public class GetDrawerLabelQuery implements IJavaModelQuery<DrawerConfiguration, String> {
	public String evaluate(final DrawerConfiguration context, final ParameterValueList parameterValues)
			throws ModelQueryExecutionException {
		
		return (context.getLabel() !=null ? context.getLabel() : "<>");
	}
}
