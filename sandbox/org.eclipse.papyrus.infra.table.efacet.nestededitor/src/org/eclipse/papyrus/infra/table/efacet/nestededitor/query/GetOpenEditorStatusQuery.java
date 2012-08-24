package org.eclipse.papyrus.infra.table.efacet.nestededitor.query;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.efacet.core.IFacetManager;
import org.eclipse.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr;


public class GetOpenEditorStatusQuery extends AbstractNestedEditorQuery<Boolean> {

	public Boolean evaluate(EObject source, IParameterValueList2 parameterValues, IFacetManager facetManager) throws DerivedTypedElementException {
		IPageMngr pageMManager = getPageMngr(source);
		return pageMManager.isOpen(source);
	}

}
