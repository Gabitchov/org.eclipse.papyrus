package org.eclipse.papyrus.infra.gmfdiag.css.model.queries;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;

public class IsStyleSheetContainer implements IJavaModelQuery<EObject, Boolean> {

	public Boolean evaluate(EObject context, ParameterValueList args)
			throws ModelQueryExecutionException {
		if (context.eResource() == null){
			return false;
		}

		//Only the first root element is a StyleSheet container
		return context.eResource().getContents().get(0) == context;
	}

}
