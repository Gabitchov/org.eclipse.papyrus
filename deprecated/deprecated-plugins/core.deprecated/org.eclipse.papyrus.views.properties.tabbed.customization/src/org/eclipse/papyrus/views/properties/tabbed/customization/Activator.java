package org.eclipse.papyrus.views.properties.tabbed.customization;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.facet.infra.browser.custom.MetamodelView;
import org.eclipse.emf.facet.infra.browser.custom.core.CustomizationsCatalog;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizationManager;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
@SuppressWarnings("restriction")
public class Activator extends AbstractUIPlugin {

	/** plugin ID */
	public static final String ID = "org.eclipse.papyrus.views.properties.tabbed.customization"; //$NON-NLS-1$

	/** singleton instance */
	private static Activator plugin;

	/** Logging helper */
	public static LogHelper log;

	/** customization manager for modisco label and content provider */
	private CustomizationManager fCustomizationManager;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		log = new LogHelper(plugin);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		log = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * 
	 * @return the customization manager in charge to adapt element in modisco
	 */
	public CustomizationManager getCustomizationManager() {
		if(this.fCustomizationManager == null) {
			this.fCustomizationManager = new CustomizationManager();
			init(this.fCustomizationManager);
		}
		return this.fCustomizationManager;
	}

	/**
	 * Initializes the customization manager for this plugin.
	 * 
	 * @param customizationManager
	 *        the customization manager to initialize
	 */
	private void init(final CustomizationManager customizationManager) {
		// the appearance can be customized here:
		try {
			// load customizations defined as default through the customization
			// extension
			List<MetamodelView> registryDefaultCustomizations = CustomizationsCatalog.getInstance().getRegistryDefaultCustomizations();
			for(MetamodelView metamodelView : registryDefaultCustomizations) {
				customizationManager.registerCustomization(metamodelView);
			}
			customizationManager.loadCustomizations();
		} catch (Throwable e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.ID, "Error initializing customizations", e)); //$NON-NLS-1$
		}
	}

	/**
	 * Returns the image from the given image descriptor
	 * 
	 * @param descriptor
	 *        the descriptor of the image to be displayed
	 * @return the image found
	 */
	public static Image getImage(String path) {
		final ImageRegistry registry = getDefault().getImageRegistry();
		Image image = registry.get(path);
		if(image == null) {
			registry.put(path, Activator.imageDescriptorFromPlugin(ID, path));
			image = registry.get(path);
		}
		return image;

	}

}
