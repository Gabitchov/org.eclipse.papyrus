/*
 * 
 */
package org.eclipse.papyrus.uml.modelexplorer.queries;

import java.util.List;

import org.eclipse.emf.facet.efacet.core.IFacetManager;
import org.eclipse.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;

/** get the name + the list of applied stereotypes */
public class GetComplexName implements IJavaQuery2<NamedElement, String> {
	/** left Stereotype delimiters ('Guillemets francais'). */
	public static String ST_LEFT = String.valueOf("\u00AB"); //$NON-NLS-1$

	/** Right Stereotype delimiters ('Guillemets francais'). */
	public static String ST_RIGHT = String.valueOf("\u00BB"); //$NON-NLS-1$


	public String evaluate(NamedElement source, IParameterValueList2 parameterValues, IFacetManager facetManager) throws DerivedTypedElementException {
		String txt = ""; //$NON-NLS-1$
		List<Stereotype> stereoList = source.getAppliedStereotypes();
		if (stereoList.size() == 0) {
			return source.getName();
		} else {
			for (int i = 0; i < stereoList.size(); i++) {
				txt = txt + stereoList.get(i).getName();
				if (i < stereoList.size() - 1) {
					txt = txt + ", "; //$NON-NLS-1$
				}
			}
			txt = ST_LEFT + txt + ST_RIGHT + " " + source.getName(); //$NON-NLS-1$
			return txt;
		}
	}
}
