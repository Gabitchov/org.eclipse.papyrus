package org.eclipse.papyrus.infra.table.efacet.nestededitor.query;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.efacet.core.IFacetManager;
import org.eclipse.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr;

//TOD0 currently this class is not used, we should complete the tableconfiguration (can be presented in the table)
public class IsAllowedInNestedEditortableQuery extends AbstractNestedEditorQuery<Boolean> {

	public Boolean evaluate(EObject source, IParameterValueList2 parameterValues, IFacetManager facetManager) throws DerivedTypedElementException {
		final IPageMngr pageManager = getPageMngr(source);
		if(pageManager != null) {
			return pageManager.allPages().contains(source);
		}
		return false;
	}

}
