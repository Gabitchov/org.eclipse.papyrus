package org.eclipse.papyrus.infra.gmfdiag.css.model.queries;

//TODO: EMF-FACET update query
public class GetStyleSheets {/**implements
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
	}**/

}
