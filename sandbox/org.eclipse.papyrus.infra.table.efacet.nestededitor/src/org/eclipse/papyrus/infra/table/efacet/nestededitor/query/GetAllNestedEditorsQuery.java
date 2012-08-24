package org.eclipse.papyrus.infra.table.efacet.nestededitor.query;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.efacet.core.IFacetManager;
import org.eclipse.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr;

public class GetAllNestedEditorsQuery extends AbstractNestedEditorQuery<Object> {

	public List<Object> evaluate(EObject source, IParameterValueList2 parameterValues, IFacetManager facetManager) throws DerivedTypedElementException {
		IPageMngr pageMngr = getPageMngr(source);
		if(pageMngr != null) {
			return pageMngr.allPages();
		}
		return Collections.emptyList();
	}

}
