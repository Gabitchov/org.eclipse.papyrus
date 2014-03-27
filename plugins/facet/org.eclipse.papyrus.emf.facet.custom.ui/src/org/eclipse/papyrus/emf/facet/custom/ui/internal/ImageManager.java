/*******************************************************************************
 * Copyright (c) 2013 Soft-Maint.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Couvrand (Soft-Maint) - Bug 418418 - [Customization] Overlay icons not implemented
 *    Thomas Cicognani (Soft-Maint) - Bug 424414 - ImageManager doesn't cache images 
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.custom.ui.internal;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.custompt.ImageWrapper;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.custompt.URIImage;
import org.eclipse.papyrus.emf.facet.util.core.Logger;
import org.eclipse.papyrus.emf.facet.util.swt.imageprovider.IImageProvider;
import org.eclipse.papyrus.emf.facet.util.swt.imageprovider.IImageProviderFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.emf.facet.custom.metamodel.custompt.IImage;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;

public class ImageManager {

	private final Map<String, ImageDescriptor> uriImageCache = new HashMap<String, ImageDescriptor>();

	private Image getImage(final URIImage uriImage) {
		Image result;
		final String uriStr = uriImage.getUri();
		ImageDescriptor imageDescriptor;
		if (this.uriImageCache.keySet().contains(uriStr)) {
			imageDescriptor = this.uriImageCache.get(uriStr);
		} else {
			imageDescriptor = createImageDescriptor(uriStr);
			this.uriImageCache.put(uriStr, imageDescriptor);
		}
		final IImageProvider imageProvider = IImageProviderFactory.DEFAULT
				.createIImageProvider(Activator.getDefault());
		result = imageProvider.getImage(imageDescriptor);
		return result;
	}


	private ImageDescriptor createImageDescriptor(final String uriStr) {
		ImageDescriptor imgDecriptor;
		final URI uri = URI.createURI(uriStr);
		final String bundleId = uri.segment(1);
		final Bundle bundle = Platform.getBundle(bundleId);
		final URI baseURI = URI.createPlatformPluginURI(bundleId + '/',
				false);
		final String resourcePath = uri.deresolve(baseURI).toString();
		final URL url = bundle.getResource(resourcePath);

		if (url == null) {
			Logger.logError(NLS.bind("Resource not found: {0}", //$NON-NLS-1$
					resourcePath), Activator.getDefault());
			imgDecriptor = ImageDescriptor.getMissingImageDescriptor();
		} else {
			imgDecriptor = ImageDescriptor.createFromURL(url);
		}
		return imgDecriptor;
	}


	public Image getImage(final IImage image) {
		Image result = null;
		final Device device = PlatformUI.getWorkbench().getDisplay();
		if (image instanceof ImageWrapper) {
			final ImageWrapper wrapper = (ImageWrapper) image;
			result = wrapper.getImage();
		} else if (image instanceof URIImage) {
			final URIImage uriImage = (URIImage) image;
			result = getImage(uriImage);
		} else if (image != null) {
			result = new Image(device, image.getInputStream());
		}
		return result;
	}

	public ImageDescriptor getImageDescriptor(final IImage image) {
		ImageDescriptor result = null;
		if (image instanceof URIImage) {
			final URIImage uriImage = (URIImage) image;
			result = createImageDescriptor(uriImage.getUri());
		}
		return result;
	}
}
