package org.eclipse.papyrus.customization.paletteconfiguration.queries;

import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.Configuration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.IconDescriptor;

/** Gets the icon for a configuration element in the palette configuration model */
public class GetIconQuery implements IJavaModelQuery<Configuration, String> {

	/**
	 * {@inheritDoc}
	 */
	public String evaluate(final Configuration context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {


		// retrieves icon descriptor
		IconDescriptor descriptor = context.getIcon();
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
