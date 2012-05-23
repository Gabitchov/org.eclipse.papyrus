package org.eclipse.papyrus.uml.efacet.queries;

import java.util.List;

import org.eclipse.emf.facet.efacet.core.IFacetManager;
import org.eclipse.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;

/**
 * 
 * Duplicate code from org.eclipse.papyrus.uml.modelexplorer. This code moved
 * when we rewrite the customization for uml.
 */
//TODO : we should write the customization for unamed UML element in order to display stertype and : body for comment, class for generalization?, ...
//TODO : move the implementation of the query in an upper plugin
public class GetStereotypedLabelForNamedElementQuery implements IJavaQuery2<NamedElement, String> {

	/** left Stereotype delimiters ('Guillemets francais'). */
	public static String ST_LEFT = String.valueOf("\u00AB"); //$NON-NLS-1$

	/** Right Stereotype delimiters ('Guillemets francais'). */
	public static String ST_RIGHT = String.valueOf("\u00BB"); //$NON-NLS-1$

	public String evaluate(final NamedElement context, IParameterValueList2 parameterValues, IFacetManager facetManager) throws DerivedTypedElementException {
		//TODO : move this part of the code in an upper plugin
		String txt = ""; //$NON-NLS-1$
		List<Stereotype> stereoList = context.getAppliedStereotypes();
		if(stereoList.size() == 0) {
			return context.getName();
		} else {
			for(int i = 0; i < stereoList.size(); i++) {
				txt = txt + stereoList.get(i).getName();
				if(i < stereoList.size() - 1) {
					txt = txt + ", "; //$NON-NLS-1$
				}
			}
			txt = ST_LEFT + txt + ST_RIGHT + " " + context.getName(); //$NON-NLS-1$
			return txt;
		}
	}
}
