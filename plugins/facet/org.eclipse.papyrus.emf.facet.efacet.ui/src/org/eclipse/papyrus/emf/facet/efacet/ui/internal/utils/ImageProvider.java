/**
 * Copyright (c) 2011 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Nicolas Guyomar (Mia-Software) - Bug 349546 - EMF Facet facetSet editor
 *  Vincent Lorenzo (CEA-LIST) - Bug 357621 - Improve the label displayed for Customization and Facets
 */
package org.eclipse.papyrus.emf.facet.efacet.ui.internal.utils;

import java.net.URL;

import org.eclipse.papyrus.emf.facet.efacet.ui.internal.Activator;
import org.eclipse.papyrus.emf.facet.util.core.Logger;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Image;

public class ImageProvider {

	private static ImageProvider instance;

	public static ImageProvider getInstance() {
		if (ImageProvider.instance == null) {
			ImageProvider.instance = new ImageProvider();
		}
		return ImageProvider.instance;
	}

	private static final String QUERY_SET_ICON_PATH = "/icons/querySet.gif"; //$NON-NLS-1$
	private static final String FACET_ICON_PATH = "/icons/facet.gif"; //$NON-NLS-1$
	private static final String FLAT_VIEW_ICON_PATH = "/icons/flatView.gif"; //$NON-NLS-1$
	private static final String TREE_VIEW_ICON_PATH = "/icons/treeView.gif"; //$NON-NLS-1$

	private Image facetIcon;
	private Image queryIcon;
	private Image flatViewIcon;
	private Image treeViewIcon;

	/**
	 * Create an image descriptor from a resource
	 * 
	 * @param resourcePath
	 *            the path of the resource (in the bundle)
	 * @return the image descriptor
	 */
	private static ImageDescriptor createImageDescriptor(final String resourcePath) {
		final URL url = Activator.getDefault().getBundle().getResource(resourcePath);
		if (url == null) {
			Logger.logError(NLS.bind("Resource not found: {0}", //$NON-NLS-1$
					resourcePath), Activator.getDefault());
			return ImageDescriptor.getMissingImageDescriptor();
		}
		return ImageDescriptor.createFromURL(url);
	}

	/** Return the icon representing a query */
	public Image getFacetIcon() {
		if (this.facetIcon == null) {
			this.facetIcon = createImageDescriptor(ImageProvider.FACET_ICON_PATH).createImage();
		}
		return this.facetIcon;
	}

	/** Return the descriptor representing a query */
	public static ImageDescriptor getFacetIconDescriptor() {
		return createImageDescriptor(ImageProvider.FACET_ICON_PATH);
	}

	/** Return the icon representing a querySet */
	public Image getQuerySetIcon() {
		if (this.queryIcon == null) {
			this.queryIcon = createImageDescriptor(ImageProvider.QUERY_SET_ICON_PATH).createImage();
		}
		return this.queryIcon;
	}
	
	public Image getFlatViewIcon(){
		if (this.flatViewIcon == null) {
			this.flatViewIcon = createImageDescriptor(ImageProvider.FLAT_VIEW_ICON_PATH).createImage();
		}
		return this.flatViewIcon;
	}
	public Image getTreeViewIcon(){
		if (this.treeViewIcon == null) {
			this.treeViewIcon = createImageDescriptor(ImageProvider.TREE_VIEW_ICON_PATH).createImage();
		}
		return this.treeViewIcon;
	}

}
