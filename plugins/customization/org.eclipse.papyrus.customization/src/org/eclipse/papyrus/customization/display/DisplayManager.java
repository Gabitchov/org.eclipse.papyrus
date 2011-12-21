package org.eclipse.papyrus.customization.display;

import org.eclipse.papyrus.views.properties.runtime.ConfigurationManager;
import org.eclipse.papyrus.views.properties.runtime.ViewConstraintEngine;


public class DisplayManager {

	private DisplayManager() {
		//TODO : Use a local constraint engine, and remove the context declaration in plugin.xml
		constraintEngine = ConfigurationManager.instance.constraintEngine;

		//TODO : Add support for local constraint engines in the creation factories
		//		constraintEngine = new DefaultViewConstraintEngine();
		//		ResourceSet resourceSet = new ResourceSetImpl();
		//		URI uri = URI.createPlatformPluginURI(Activator.PLUGIN_ID + "/Model/Customization/Customization.ctx", true); //$NON-NLS-1$
		//		try {
		//			EObject eObject = EMFHelper.loadEMFModel(resourceSet, uri);
		//
		//			if(eObject instanceof Context) {
		//				constraintEngine.addContext((Context)eObject);
		//			} else {
		//				Activator.log.warn("Cannot load the plug-in creation wizard UI");
		//			}
		//		} catch (Exception ex) {
		//			Activator.log.error("Cannot load the plug-in creation wizard UI", ex);
		//		}
	}

	public static DisplayManager instance = new DisplayManager();

	public ViewConstraintEngine constraintEngine;
}
