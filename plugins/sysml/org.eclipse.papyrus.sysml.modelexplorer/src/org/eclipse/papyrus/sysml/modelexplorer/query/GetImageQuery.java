package org.eclipse.papyrus.sysml.modelexplorer.query;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.papyrus.umlutils.ElementUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/** Create a basic label based on element name */
public class GetImageQuery implements IJavaModelQuery<Element, String> {

	public static final String sysml_plugin_path = "/org.eclipse.papyrus.sysml/";

	public String evaluate(final Element context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {

		String icon_path = "";
		if(!context.getAppliedStereotypes().isEmpty()) {
			Stereotype first_stereotype = context.getAppliedStereotypes().get(0);

			if(!first_stereotype.getIcons().isEmpty()) {
				org.eclipse.uml2.uml.Image icon = ElementUtil.getStereotypeImage(context, first_stereotype, "icon");
				icon_path = icon.getLocation();
			}
		}

		String image_path = "";
		URI iconURI = URI.createURI(icon_path);
		if(!"".equals(icon_path)) {
			if(iconURI.isRelative()) {
				image_path = sysml_plugin_path + icon_path;
			} else {
				image_path = iconURI.toPlatformString(true);
			}
		}

		return image_path;
	}
}
