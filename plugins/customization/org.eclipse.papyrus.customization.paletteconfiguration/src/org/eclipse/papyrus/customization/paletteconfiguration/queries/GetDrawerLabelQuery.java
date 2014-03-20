package org.eclipse.papyrus.customization.paletteconfiguration.queries;

import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.DrawerConfiguration;

/** Returns the label for a drawer */
public class GetDrawerLabelQuery implements IJavaQuery2<DrawerConfiguration, String> {

	public String evaluate(DrawerConfiguration source, IParameterValueList2 parameterValues, IFacetManager facetManager) throws DerivedTypedElementException {
		return (source.getLabel() !=null ? source.getLabel() : "<>");
	}
}
