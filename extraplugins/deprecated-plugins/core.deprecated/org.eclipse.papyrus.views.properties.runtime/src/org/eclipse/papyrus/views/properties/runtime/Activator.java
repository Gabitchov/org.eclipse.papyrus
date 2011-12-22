package org.eclipse.papyrus.views.properties.runtime;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	/** plugin ID */
	public static final String ID = "org.eclipse.papyrus.views.properties.runtime";

	/** shared instance */
	private static Activator plugin;

	/** Logging helper */
	public static LogHelper log;

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
	 * This method returns an <code>org.eclipse.swt.graphics.Image</code> identified by its pluginId and image Descriptor.<BR>
	 * 
	 * By default, it returns a default image. This image is the image placed in
	 * the directory <em>resources/icons/default.gif</em>
	 * 
	 * @param descriptor
	 *        the image descriptor of the image
	 * @return the Image
	 */
	public static Image getImageFromDescriptor(ImageDescriptor descriptor) {
		String key = descriptor.toString();
		ImageRegistry registry = getDefault().getImageRegistry();
		Image image = registry.get(key);

		if(image == null) {

			registry.put(key, descriptor);
			image = registry.get(key);

		}
		return image;
	}

	/**
	 * Returns the image from the given path
	 * 
	 * @param path
	 *        the path the image to be displayed
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
