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
import org.eclipse.uml2.uml.Element;

public class GetStyleSheets implements
		IJavaModelQuery<Element, Collection<StyleSheet>> {

	public Collection<StyleSheet> evaluate(Element context,
			ParameterValueList args) throws ModelQueryExecutionException {
		ResourceSet resourceSet = context.eResource().getResourceSet();
		if (resourceSet == null) {
			return findStyleSheets(context.eResource());
		}

		List<StyleSheet> result = new LinkedList<StyleSheet>();
		for (Resource resource : context.eResource().getResourceSet()
				.getResources()) {
			result.addAll(findStyleSheets(resource));
		}

		return result;
	}

	private Collection<StyleSheet> findStyleSheets(Resource eResource) {
		List<StyleSheet> result = new LinkedList<StyleSheet>();
		for (EObject rootElement : eResource.getContents()){
			if (rootElement instanceof StyleSheet){
				result.add((StyleSheet)rootElement);
			}
		}
		return result;
	}

}
