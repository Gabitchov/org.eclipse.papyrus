package org.eclipse.papyrus.views.validation.internal;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator
		extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.papyrus.views.validation"; //$NON-NLS-1$

	public static final String ICON_GOTO_MARKER = "goto_marker"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	/** Logging helper */
	public static LogHelper log = new LogHelper();

	/**
	 * The constructor
	 */
	public Activator() {
		super();
	}

	public void start(BundleContext context)
			throws Exception {

		super.start(context);
		plugin = this;

		// register the log helper
		log.setPlugin(plugin);
	}

	public void stop(BundleContext context)
			throws Exception {

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

	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		super.initializeImageRegistry(reg);

		reg.put(ICON_GOTO_MARKER,
			getImageDescriptor("full/elcl16/goto_marker.gif")); //$NON-NLS-1$
	}

	protected ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, "$nl$/icons/" + path); //$NON-NLS-1$
	}
}
