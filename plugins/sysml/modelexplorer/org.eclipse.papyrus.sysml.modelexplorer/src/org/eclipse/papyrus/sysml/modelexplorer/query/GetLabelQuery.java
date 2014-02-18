package org.eclipse.papyrus.sysml.modelexplorer.query;

import org.eclipse.emf.facet.efacet.core.IFacetManager;
import org.eclipse.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.uml2.uml.NamedElement;

/** Create a basic label based on element name */
public class GetLabelQuery implements IJavaQuery2<NamedElement, String> {

	public static final String UNNAMED = "";


	@Override
	public String evaluate(NamedElement source, IParameterValueList2 parameterValues, IFacetManager facetManager) throws DerivedTypedElementException {
		String label = UNNAMED;
		if(source.isSetName() && (!"".equals(source.getName()))) {
			label = source.getName();
		}
		return label;
	}
}
