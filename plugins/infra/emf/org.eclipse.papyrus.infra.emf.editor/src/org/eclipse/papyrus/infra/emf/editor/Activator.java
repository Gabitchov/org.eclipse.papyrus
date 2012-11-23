package org.eclipse.papyrus.infra.emf.editor;

import org.eclipse.emf.facet.infra.browser.uicore.CustomizationManager;
import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.papyrus.infra.emf.editor"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	private CustomizationManager fCustomizationManager;

	public static LogHelper log;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		log = new LogHelper(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
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
		return org.eclipse.papyrus.infra.emf.Activator.getDefault().getCustomizationManager();
		//		if(this.fCustomizationManager == null) {
		//			this.fCustomizationManager = new CustomizationManager();
		//			init(this.fCustomizationManager);
		//		}
		//		return this.fCustomizationManager;
	}

	//	private void init(final CustomizationManager customizationManager) {
	//		customizationManager.setShowContainer(false);
	//		customizationManager.setShowDerivedLinks(false);
	//		customizationManager.setShowEmptyLinks(false);
	//
	//		try {
	//			List<MetamodelView> registryDefaultCustomizations = CustomizationsCatalog.getInstance().getRegistryDefaultCustomizations();
	//			for(MetamodelView metamodelView : registryDefaultCustomizations) {
	//				customizationManager.registerCustomization(metamodelView);
	//			}
	//
	//			customizationManager.loadCustomizations();
	//		} catch (Throwable e) {
	//			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error initializing customizations", e)); //$NON-NLS-1$
	//		}
	//	}

}
