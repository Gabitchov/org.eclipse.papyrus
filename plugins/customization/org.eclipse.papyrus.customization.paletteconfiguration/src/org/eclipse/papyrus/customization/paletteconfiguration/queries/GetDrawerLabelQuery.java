package org.eclipse.papyrus.customization.paletteconfiguration.queries;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.DrawerConfiguration;

/** Returns the label for a drawer */
public class GetDrawerLabelQuery implements IJavaModelQuery<DrawerConfiguration, String> {
	public String evaluate(final DrawerConfiguration context, final ParameterValueList parameterValues)
			throws ModelQueryExecutionException {
		
		return (context.getLabel() !=null ? context.getLabel() : "<>");
	}
}
