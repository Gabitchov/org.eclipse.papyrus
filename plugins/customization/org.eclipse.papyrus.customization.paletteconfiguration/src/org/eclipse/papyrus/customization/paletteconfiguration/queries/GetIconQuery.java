package org.eclipse.papyrus.customization.paletteconfiguration.queries;

import org.eclipse.emf.facet.efacet.core.IFacetManager;
import org.eclipse.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.Configuration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.IconDescriptor;

/** Gets the icon for a configuration element in the palette configuration model */
public class GetIconQuery implements IJavaQuery2<Configuration, String> {


	public String evaluate(Configuration source, IParameterValueList2 parameterValues, IFacetManager facetManager) throws DerivedTypedElementException {
		// retrieves icon descriptor
		IconDescriptor descriptor = source.getIcon();
		if(descriptor == null) {
			return "";
		}

		String bundleID = descriptor.getPluginID();
		String iconPath = descriptor.getIconPath();

		if(bundleID == null || iconPath == null) {
			return "";
		}

		return "/" + bundleID + iconPath;
	}

}
