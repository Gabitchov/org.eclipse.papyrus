package org.eclipse.papyrus.infra.emf.compare.ui.queries;

import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.impl.DiffGroupImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;

public class GetDiffElementLabel implements IJavaModelQuery<EObject, String> {

	public String evaluate(final EObject context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {
		// TODO Auto-generated method stub
		String text = null;
		text = context.toString();
		if(context instanceof DiffGroupImpl) {

		}
		int i = 0;
		i++;
		return null;
	}
}
