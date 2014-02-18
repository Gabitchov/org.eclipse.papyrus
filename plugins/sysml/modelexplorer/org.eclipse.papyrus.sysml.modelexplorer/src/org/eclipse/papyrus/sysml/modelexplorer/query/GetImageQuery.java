package org.eclipse.papyrus.sysml.modelexplorer.query;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.facet.efacet.core.IFacetManager;
import org.eclipse.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.papyrus.uml.tools.utils.ElementUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/** Create a basic label based on element name */
public class GetImageQuery implements IJavaQuery2<Element, String> {

	public static final String sysml_plugin_path = "/org.eclipse.papyrus.sysml/";


	@Override
	public String evaluate(Element source, IParameterValueList2 parameterValues, IFacetManager facetManager) throws DerivedTypedElementException {
		String iconPath = "";
		if(!source.getAppliedStereotypes().isEmpty()) {
			Stereotype first_stereotype = source.getAppliedStereotypes().get(0);

			if(!first_stereotype.getIcons().isEmpty()) {
				org.eclipse.uml2.uml.Image icon = ElementUtil.getStereotypeImage(source, first_stereotype, "icon");
				if(icon != null) {
					iconPath = icon.getLocation();
				}
			}
		}

		String imagePath = "";

		if(iconPath != null && !"".equals(iconPath)) {
			URI iconURI = URI.createURI(iconPath);
			if(iconURI.isRelative()) {
				imagePath = sysml_plugin_path + iconPath;
			} else {
				imagePath = iconURI.toPlatformString(true);
			}
		}

		return imagePath;
	}
}
