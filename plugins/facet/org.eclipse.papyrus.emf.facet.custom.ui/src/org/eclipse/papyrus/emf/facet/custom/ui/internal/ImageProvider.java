/*******************************************************************************
 * Copyright (c) 2008, 2010 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 *    Vincent Lorenzo (CEA-LIST) - bug 341238 - We need to be able to specify which column have to be hidden/visible using the customization mechanism
 *    Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *    Nicolas Bros (Mia-Software) - Bug 379683 - customizable Tree content provider
 *******************************************************************************/

package org.eclipse.emf.facet.custom.ui.internal;

import java.net.URL;

import org.eclipse.emf.facet.util.core.Logger;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

/** A singleton image provider, which caches image descriptors */
public final class ImageProvider {

	private ImageProvider() {
		// This class must only be instantiated by getInstance().
	}

	private static ImageProvider instance;

	public static ImageProvider getInstance() {
		if (ImageProvider.instance == null) {
			ImageProvider.instance = new ImageProvider();
		}
		return ImageProvider.instance;
	}

	private Image uiCustomIcon = null;
	private Image grayedUiCustomIcon;

	private Image linkIcon = null;
	private Image linkUniDirIcon = null;
	private Image linkFacetIcon = null;
	private Image aggregIcon = null;
	private Image aggregUniDirIcon = null;
	private Image invAggregIcon = null;

	private Image attributeIcon = null;
	private Image attribFacetIcon = null;
	private Image featureIcon = null;

	private static final String UI_CUSTOM = "icons/uiCustom.gif"; //$NON-NLS-1$

	private static final String AGGREG_UNIDIR = "icons/aggreg_unidir.gif"; //$NON-NLS-1$
	private static final String AGGREG_ICON_PATH = "icons/aggreg.gif"; //$NON-NLS-1$
	private static final String ATTRIBUTE_FACET = "icons/attribute_facet"; //$NON-NLS-1$
	private static final String ATTRIBUTE = "icons/attributes.gif"; //$NON-NLS-1$
	private static final String INV_AGGREG = "icons/inv_aggreg.gif"; //$NON-NLS-1$
	private static final String LINK_FACET = "icons/link_unidir_facet.gif"; //$NON-NLS-1$
	private static final String LINK_UNIDIR = "icons/link_unidir.gif"; //$NON-NLS-1$
	private static final String LINK_ICON_PATH = "icons/link.gif"; //$NON-NLS-1$
	private static final String FEATURE_ICON_PATH = "icons/feature.gif"; //$NON-NLS-1$

	/**
	 * Create an image descriptor from a resource
	 * 
	 * @param resourcePath
	 *            the path of the resource (in the bundle)
	 * @return the image descriptor
	 */
	private static ImageDescriptor createImageDescriptor(final String resourcePath) {
		final URL url = Activator.getDefault().getBundle().getResource(resourcePath);
		ImageDescriptor result;
		if (url == null) {
			Logger.logError(NLS.bind("Resource not found: {0}", //$NON-NLS-1$
					resourcePath), Activator.getDefault());
			result = ImageDescriptor.getMissingImageDescriptor();
		} else {
			result = ImageDescriptor.createFromURL(url);
		}
		return result;
	}

	/** Return an icon for "uiCustom" */
	public Image getUiCustomIcon() {
		if (this.uiCustomIcon == null) {
			this.uiCustomIcon = createImageDescriptor(ImageProvider.UI_CUSTOM)
					.createImage();
		}
		return this.uiCustomIcon;
	}

	public Image getGrayedUiCustomIcon() {
		if (this.grayedUiCustomIcon == null) {
			this.grayedUiCustomIcon = new Image(Display.getCurrent(), getUiCustomIcon(), SWT.IMAGE_GRAY);
		}
		return this.grayedUiCustomIcon;
	}

	/** Return the icon representing a bidirectional link */
	public Image getLinkIcon() {
		if (this.linkIcon == null) {
			this.linkIcon = createImageDescriptor(ImageProvider.LINK_ICON_PATH).createImage();
		}
		return this.linkIcon;
	}

	/** Return the icon representing an unidirectional link */
	public Image getUnidirectionalLinkIcon() {
		if (this.linkUniDirIcon == null) {
			this.linkUniDirIcon = createImageDescriptor(ImageProvider.LINK_UNIDIR)
					.createImage();
		}
		return this.linkUniDirIcon;
	}

	/** Return the icon representing a facet reference */
	public Image getFacetLinkIcon() {
		if (this.linkFacetIcon == null) {
			this.linkFacetIcon = createImageDescriptor(ImageProvider.LINK_FACET)
					.createImage();
		}
		return this.linkFacetIcon;
	}

	/** Return the icon representing a composition link */
	public Image getAggregIcon() {
		if (this.aggregIcon == null) {
			this.aggregIcon = createImageDescriptor(ImageProvider.AGGREG_ICON_PATH).createImage();
		}
		return this.aggregIcon;
	}

	/** Return the icon representing an unidirectional composition link */
	public Image getUnidirectionalAggregIcon() {
		if (this.aggregUniDirIcon == null) {
			this.aggregUniDirIcon = createImageDescriptor(ImageProvider.AGGREG_UNIDIR)
					.createImage();
		}
		return this.aggregUniDirIcon;
	}

	/** Return the icon representing a reverse composition link */
	public Image getInvAggregIcon() {
		if (this.invAggregIcon == null) {
			this.invAggregIcon = createImageDescriptor(ImageProvider.INV_AGGREG)
					.createImage();
		}
		return this.invAggregIcon;
	}

	/** Return the "attribute" icon */
	public Image getAttributeIcon() {
		if (this.attributeIcon == null) {
			this.attributeIcon = createImageDescriptor(ImageProvider.ATTRIBUTE)
					.createImage();
		}
		return this.attributeIcon;
	}

	/** Return the "facet attribute" icon */
	public Image getFacetAttributeIcon() {
		if (this.attribFacetIcon == null) {
			this.attribFacetIcon = createImageDescriptor(ImageProvider.ATTRIBUTE_FACET)
					.createImage();
		}
		return this.attribFacetIcon;
	}

	/** Return the "feature" icon */
	public Image getFeatureIcon() {
		if (this.featureIcon == null) {
			this.featureIcon = createImageDescriptor(ImageProvider.FEATURE_ICON_PATH).createImage();
		}
		return this.featureIcon;
	}
}
