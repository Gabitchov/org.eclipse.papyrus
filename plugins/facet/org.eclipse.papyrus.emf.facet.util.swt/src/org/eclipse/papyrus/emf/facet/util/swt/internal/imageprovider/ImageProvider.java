/*******************************************************************************
 * Copyright (c) 2013 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Gregoire Dupe (Mia-Software) - Bug 406569 - Image provider factory
 *    Gregoire Dupe (Mia-Software) - Bug 423611 - ImageProvider doesn't use singleton instance
 *    Gregoire Dupe (Mia-Software) - Bug 424122 - [Table] Images, fonts and colors are not shared between the instances of table
 ******************************************************************************/

package org.eclipse.papyrus.emf.facet.util.swt.internal.imageprovider;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.papyrus.emf.facet.util.core.DebugUtils;
import org.eclipse.papyrus.emf.facet.util.core.Logger;
import org.eclipse.papyrus.emf.facet.util.swt.imageprovider.IImageProvider;
import org.eclipse.papyrus.emf.facet.util.swt.internal.Activator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;

public final class ImageProvider implements IImageProvider {

	private static final boolean DEBUG = DebugUtils.getDebugStatus(Activator.getDefault());
	private final Map<Object, Image> map = new HashMap<Object, Image>();
	private final Plugin activator;

	ImageProvider(final Plugin activator) {
		this.activator = activator;
	}

	public ImageDescriptor createImageDescriptor(final String resourcePath) {
		ImageDescriptor result;
		final URL url = this.activator.getBundle().getResource(resourcePath);
		if (url == null) {
			Logger.logError(NLS.bind("Resource not found: {0}", //$NON-NLS-1$
					resourcePath), this.activator);
			result = ImageDescriptor.getMissingImageDescriptor();
		} else {
			result = ImageDescriptor.createFromURL(url);
		}
		return result;
	}

	public Image getImage(final String path) {
		Image result = this.map.get(path);
		if (result == null) {
			result = createImageDescriptor(path).createImage();
			this.map.put(path, result);
			if (DEBUG) {
				final Bundle bundle = this.activator.getBundle();
				final String bundleId = bundle.getSymbolicName();
				final String message = String.format("New image loaded: %s:%s", //$NON-NLS-1$
						bundleId, path);
				DebugUtils.debug(message);
			}
		}
		return result;
	}

	public Image getImage(final ImageDescriptor imgDescriptor) {
		Image result = this.map.get(imgDescriptor);
		if (result == null) {
			result = imgDescriptor.createImage();
			this.map.put(imgDescriptor, result);
			if (DEBUG) {
				final Bundle bundle = this.activator.getBundle();
				final String bundleId = bundle.getSymbolicName();
				final String message = String.format("New image loaded from an image descriptor (bundle=%s)", //$NON-NLS-1$
						bundleId);
				DebugUtils.debug(message);
			}
		}
		return result;
	}

}
