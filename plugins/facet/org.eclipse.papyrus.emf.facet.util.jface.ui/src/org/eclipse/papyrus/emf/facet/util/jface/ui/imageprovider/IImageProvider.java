/*******************************************************************************
 * Copyright (c) 2013 Soft-Maint.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Thomas Cicognani (Soft-Maint) - Bug 424416 - Plug-in for JFace Utilities
 ******************************************************************************/

package org.eclipse.emf.facet.util.jface.ui.imageprovider;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.swt.graphics.Image;

/**
 * JFace Image Provider
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * @since 0.4.0
 */
public interface IImageProvider {

	/**
	 * Return an image from an Overlay Icon description.
	 * 
	 * @param imgDescriptor
	 *            Overlay Icon description
	 * @return A new image
	 */
	Image getImage(DecorationOverlayIcon imgDescriptor);

	/**
	 * Return an image from its path
	 * 
	 * @param path
	 *            The path of the image
	 * @return A new image
	 */
	Image getImage(String path);

	/**
	 * Return an image descriptor from its path
	 * 
	 * @param resourcePath
	 *            The path from which to create the descriptor
	 * @return The new image descriptor
	 */
	ImageDescriptor createImageDescriptor(String resourcePath);

	/**
	 * Return an image from an image descriptor
	 * 
	 * @param imgDescriptor
	 *            An image descriptor to create the image
	 * @return A new image
	 */
	Image getImage(ImageDescriptor imgDescriptor);

}
