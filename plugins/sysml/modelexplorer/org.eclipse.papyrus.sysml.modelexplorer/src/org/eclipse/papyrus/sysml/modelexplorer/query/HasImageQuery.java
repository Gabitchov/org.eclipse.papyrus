package org.eclipse.papyrus.sysml.modelexplorer.query;

import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.uml2.uml.Element;

/** Check is the element has a stereotype icon that can be used */
public class HasImageQuery implements IJavaQuery2<Element, Boolean> {


	@Override
	public Boolean evaluate(Element source, IParameterValueList2 parameterValues, IFacetManager facetManager) throws DerivedTypedElementException {
		IJavaQuery2<Element, String> ImgageGetter = new GetImageQuery();
		String temp_img_path = ImgageGetter.evaluate(source, parameterValues,facetManager);
		if(!"".equals(temp_img_path)) {
			return true;
		}

		return false;
	}
}
