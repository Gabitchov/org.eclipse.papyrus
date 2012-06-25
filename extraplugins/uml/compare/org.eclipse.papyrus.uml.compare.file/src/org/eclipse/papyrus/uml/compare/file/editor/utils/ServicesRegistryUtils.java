package org.eclipse.papyrus.uml.compare.file.editor.utils;



import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ExtensionServicesRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.uml.compare.file.Activator;


public class ServicesRegistryUtils {


	private ServicesRegistryUtils() {
		//to prevent instanciation
	}

	public static ServicesRegistry createAndInitServiceRegistryForUMLCompareFile() {
		ServicesRegistry servicesRegistry = null;
		// Create Services Registry
		try {
			servicesRegistry = new ExtensionServicesRegistry(org.eclipse.papyrus.infra.core.Activator.PLUGIN_ID);
			// Start the ModelSet first, and load if from the specified File
			List<Class<?>> servicesToStart = new ArrayList<Class<?>>(1);
			servicesToStart.add(ModelSet.class);
			servicesRegistry.startServicesByClassKeys(servicesToStart);
		} catch (ServiceException e) {
			// Show log and error
			Activator.log.error(e.getMessage(), e);
		}
		return servicesRegistry;
	}
}
