package org.eclipse.papyrus.infra.gmfdiag.modelexplorer.queries;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList2;

public class NotVisibleStructuralFeatureQuery implements IJavaQuery2<Diagram, Boolean> {
	public Boolean evaluate(final Diagram context, 
			final IParameterValueList2 parameterValues,
			final IFacetManager facetManager)
			throws DerivedTypedElementException {
		return false;
	}
}
