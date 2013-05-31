package org.eclipse.papyrus.sysml.modelexplorer.query;

import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.uml2.uml.NamedElement;

/** Create a basic label based on element name */
public class GetLabelQuery implements IJavaModelQuery<NamedElement, String> {

	public static final String UNNAMED = "";

	public String evaluate(final NamedElement context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {

		String label = UNNAMED;
		if(context.isSetName() && (!"".equals(context.getName()))) {
			label = context.getName();
		}
		return label;
	}
}
