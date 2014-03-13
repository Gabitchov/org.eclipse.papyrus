package org.eclipse.papyrus.infra.gmfdiag.css.model.queries;
//TODO: EMF-FACET update query

public class IsStyleSheetContainer {/**implements IJavaModelQuery<Element, Boolean> {

	public Boolean evaluate(Element context, ParameterValueList args)
			throws ModelQueryExecutionException {
		if (context.eResource() == null){
			return false;
		}

		//Only the first root element is a StyleSheet container
		return context.eResource().getContents().get(0) == context;
	}*/

}
