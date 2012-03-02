package org.eclipse.papyrus.infra.gmfdiag.css.model.queries;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheet;

public class GetStyleSheets implements
		IJavaModelQuery<EObject, Collection<EObject>> {

	public Collection<EObject> evaluate(EObject context,
			ParameterValueList args) throws ModelQueryExecutionException {
		ResourceSet resourceSet = context.eResource().getResourceSet();
		if (resourceSet == null) {
			return findStyleSheets(context.eResource());
		}

		List<EObject> result = new LinkedList<EObject>();
		for (Resource resource : context.eResource().getResourceSet()
				.getResources()) {
			result.addAll(findStyleSheets(resource));
		}

		return result;
	}

	private Collection<EObject> findStyleSheets(Resource eResource) {
		List<EObject> result = new LinkedList<EObject>();
		for (EObject rootElement : eResource.getContents()){
			if (rootElement instanceof StyleSheet){
				result.add(rootElement);
			}
		}
		return result;
	}

}
