/*
 * 
 */
package org.eclipse.papyrus.uml.modelexplorer.queries;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.uml2.uml.NamedElement;

/** get the name + the list of stereotypes from a named Element */
public class GetName implements IJavaQuery2<NamedElement, String> {

	public String evaluate(NamedElement source, IParameterValueList2 parameterValues, IFacetManager facetManager) throws DerivedTypedElementException {
		return source.getName();
	}
}
