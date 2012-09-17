package org.eclipse.papyrus.infra.gmfdiag.css.model.queries;

import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.uml2.uml.Element;

public class IsStyleSheetContainer implements IJavaModelQuery<Element, Boolean> {

	public Boolean evaluate(Element context, ParameterValueList args)
			throws ModelQueryExecutionException {
		if (context.eResource() == null){
			return false;
		}

		//Only the first root element is a StyleSheet container
		return context.eResource().getContents().get(0) == context;
	}

}
