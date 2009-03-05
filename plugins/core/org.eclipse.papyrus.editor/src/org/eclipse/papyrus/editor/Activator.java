package org.eclipse.papyrus.editor;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.papyrus.editor.utils.ColorManager;
import org.eclipse.papyrus.editor.utils.FontManager;
import org.eclipse.papyrus.editor.utils.OverlayVisibilityIcon;
import org.eclipse.papyrus.umlutils.ElementUtil;
import org.eclipse.papyrus.umlutils.ImageUtil;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.VisibilityKind;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.papyrus.editor";

	// The shared instance
	private static Activator plugin;

	/** The Constant UML_VIS_ICONS_16x16. */
	public static final String UML_VIS_ICONS_16x16 = "icons/uml/ovr16/";

	/** Default image. */
	public static final String DEFAULT_IMAGE = "icons/papyrus/Papyrus.gif";

	/** Color manager. */
	public static ColorManager colorManager = new ColorManager();

	/** Font manager. */
	public static FontManager fontManager = new FontManager();

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
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
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
	 * Returns an image descriptor for the image file at the given plug-in relative path.
	 * 
	 * @param path
	 *            the path for the image file
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	public static Image getImage(String key) {
		return getImage(key, "");
	}

	/**
	 * Returns an <code>org.eclipse.swt.graphics.Image</code> identified by its key.<BR>
	 * By default, it returns a default image. This image is the image placed in the directory <em>resources/icons/default.gif</em>
	 * 
	 * @param key
	 *            the key of the image
	 * @param visKey
	 *            must not be null : "" || "public" || "private" ...
	 * @return the Image
	 */
	public static Image getImage(String key, String visKey) {

		String image_id = key;
		if (!"".equals(visKey)) {
			image_id = image_id + "::" + visKey;
		}

		ImageRegistry registry = getDefault().getImageRegistry();
		Image image = registry.get(image_id);

		if (image == null) { // Image not yet in registry

			// Get the descriptor of the image without visibility
			ImageDescriptor desc = AbstractUIPlugin.imageDescriptorFromPlugin(getDefault().PLUGIN_ID, key);

			if (!"".equals(visKey)) { // Add visibility overlay

				Image initialImage = desc.createImage();
				ImageDescriptor visDesc = getDefault().getImageDescriptor(getDefault().UML_VIS_ICONS_16x16 + "VisibilityKind_" + visKey + ".gif");

				// Overlay custom image over base image
				OverlayVisibilityIcon overlayIcon = new OverlayVisibilityIcon(initialImage, visDesc);
				image = overlayIcon.getImage();

				registry.put(image_id, image);

			} else {
				registry.put(key, desc);
			}

			image = registry.get(image_id);

		}

		if ((image == null) && !image_id.equals(DEFAULT_IMAGE)) {
			image = getImage(DEFAULT_IMAGE);
		}

		return image;
	}

	/**
	 * This method returns an <code>org.eclipse.swt.graphics.Image</code> identified by its pluginId and iconPath.<BR>
	 * 
	 * By default, it returns a default image. This image is the image placed in the directory <em>resources/icons/default.gif</em>
	 * 
	 * @param pluginId
	 *            id of plugin
	 * @param iconpPath
	 *            the path of the icon image relative to the plugin
	 * @return the Image
	 */
	public static Image getPluginIconImage(String pluginId, String iconPath) {
		String key = pluginId + iconPath;
		ImageRegistry registry = getDefault().getImageRegistry();
		Image image = registry.get(key);

		if (image == null) {

			ImageDescriptor desc = AbstractUIPlugin.imageDescriptorFromPlugin(pluginId, iconPath);

			registry.put(key, desc);
			image = registry.get(key);

		}
		if ((image == null) && !iconPath.equals(DEFAULT_IMAGE)) {
			image = getImage(DEFAULT_IMAGE);
		}

		return image;
	}

	/**
	 * this method returns the shape image that represents the first applied stereotype.
	 * 
	 * @param elt
	 *            the stereotyped element
	 * @return {@link image} of the shape
	 */
	public static Image getShapeElement(Element elt) {
		// getStereotypeImage can return null
		org.eclipse.uml2.uml.Image shape = ElementUtil.getStereotypeImage(elt, "shape");
		if (shape != null) {
			return getImageInRegistry(shape, null);
		} else {
			return null;
		}
	}

	public static Image getIconElement(Element elt) {
		return getIconElement(elt, false);
	}

	/**
	 * this method returns the icon image that represents the first applied stereotype.
	 * 
	 * @param elt
	 *            the stereotyped element
	 * @return {@link image} of the icon
	 */
	public static Image getIconElement(Element elt, boolean withVisibilityDecorator) {

		VisibilityKind vis = null;
		if ((elt instanceof NamedElement) && (withVisibilityDecorator)) {

			vis = ((NamedElement) elt).getVisibility();
		}

		// getStereotypeImage can return null
		org.eclipse.uml2.uml.Image icon = ElementUtil.getStereotypeImage(elt, "icon");
		if (icon != null) {
			return getImageInRegistry(icon, vis);
		} else {
			return null;
		}
	}

	/**
	 * Find the image (SWT) in registry Store image in registry if it is not found
	 * 
	 * @param umlImage
	 *            to retrieve as SWT Image in registry
	 * @return the stored SWT image
	 */
	public static Image getImageInRegistry(org.eclipse.uml2.uml.Image umlImage, VisibilityKind visibility) {
		// Retrieve registry
		ImageRegistry papyrusRegistry = getDefault().getImageRegistry();

		// Get image id for registry
		String image_id = ImageUtil.getImageId(umlImage);
		if (visibility != null) {
			image_id = image_id + "_" + visibility.getLiteral();
		}

		// Get SWT image for shape in the registry
		Image image = papyrusRegistry.get(image_id);

		// If image was not found in registry,
		// try to find an image and to update registry
		if (image == null) {

			// Try to retrieve image from UML Image content property
			image = ImageUtil.getContent(umlImage);

			// If no image was found in Content
			// Try to retrieve image from UML Image location property
			if (image == null) {
				image = ImageUtil.getImageFromLocation(umlImage);
			}

			// Add visibility decorator
			if (visibility != null) {

				ImageDescriptor visDesc = getDefault().getImageDescriptor(getDefault().UML_VIS_ICONS_16x16 + "VisibilityKind_" + visibility.getLiteral() + ".gif");

				// Overlay custom image over base image
				OverlayVisibilityIcon overlayIcon = new OverlayVisibilityIcon(image, visDesc);
				image = overlayIcon.getImage();
			}

			if (image != null) {
				// Store image in registry
				ImageData imdata = image.getImageData();
				papyrusRegistry.put(image_id, ImageDescriptor.createFromImageData(imdata));
				image = papyrusRegistry.get(image_id);
			}
		}

		return image;
	}

}
