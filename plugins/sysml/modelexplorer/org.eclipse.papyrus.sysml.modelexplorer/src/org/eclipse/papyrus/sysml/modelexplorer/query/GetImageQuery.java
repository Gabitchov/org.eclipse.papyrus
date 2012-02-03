package org.eclipse.papyrus.sysml.modelexplorer.query;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.papyrus.uml.tools.utils.ElementUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/** Create a basic label based on element name */
public class GetImageQuery implements IJavaModelQuery<Element, String> {

	public static final String sysml_plugin_path = "/org.eclipse.papyrus.sysml/";

	public String evaluate(final Element context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {

		String iconPath = "";
		if(!context.getAppliedStereotypes().isEmpty()) {
			Stereotype first_stereotype = context.getAppliedStereotypes().get(0);

			if(!first_stereotype.getIcons().isEmpty()) {
				org.eclipse.uml2.uml.Image icon = ElementUtil.getStereotypeImage(context, first_stereotype, "icon");
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
