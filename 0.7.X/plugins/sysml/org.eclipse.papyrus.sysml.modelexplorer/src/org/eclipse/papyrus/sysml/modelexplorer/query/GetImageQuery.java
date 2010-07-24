package org.eclipse.papyrus.sysml.modelexplorer.query;

import org.eclipse.gmt.modisco.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.gmt.modisco.infra.query.core.java.IJavaModelQuery;
import org.eclipse.gmt.modisco.infra.query.core.java.ParameterValueList;
import org.eclipse.papyrus.umlutils.ElementUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/** Create a basic label based on element name */
public class GetImageQuery implements IJavaModelQuery<Element, String> {

	public static final String sysml_plugin_path = "/org.eclipse.papyrus.sysml/";

	public String evaluate(final Element context, final ParameterValueList parameterValues)
			throws ModelQueryExecutionException {

		String icon_relative_path = "";
		if (!context.getAppliedStereotypes().isEmpty()) {
			Stereotype first_stereotype = context.getAppliedStereotypes().get(0);

			if (!first_stereotype.getIcons().isEmpty()) {
				org.eclipse.uml2.uml.Image icon = ElementUtil.getStereotypeImage(context, first_stereotype, "icon");
				icon_relative_path = icon.getLocation();
			}
		}

		String image_path = "";
		if (!"".equals(icon_relative_path)) {
			image_path = sysml_plugin_path + icon_relative_path;
		}
		return image_path;
	}
}
