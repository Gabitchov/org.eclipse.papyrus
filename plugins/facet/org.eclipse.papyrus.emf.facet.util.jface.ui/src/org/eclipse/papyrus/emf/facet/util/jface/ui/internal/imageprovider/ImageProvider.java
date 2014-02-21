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

package org.eclipse.papyrus.emf.facet.util.jface.ui.internal.imageprovider;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.papyrus.emf.facet.util.core.DebugUtils;
import org.eclipse.papyrus.emf.facet.util.jface.ui.imageprovider.IImageProvider;
import org.eclipse.papyrus.emf.facet.util.jface.ui.internal.Activator;
import org.eclipse.papyrus.emf.facet.util.swt.imageprovider.IImageProviderFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;

public final class ImageProvider implements IImageProvider {

	private static final boolean DEBUG = DebugUtils.getDebugStatus(Activator
			.getDefault());
	private final Map<Object, Image> map = new HashMap<Object, Image>();
	private final Plugin plugin;
	private final org.eclipse.papyrus.emf.facet.util.swt.imageprovider.IImageProvider delegate;

	ImageProvider(final Plugin plugin) {
		this.plugin = plugin;
		this.delegate = IImageProviderFactory.DEFAULT
				.createIImageProvider(plugin);
	}

	public Image getImage(final DecorationOverlayIcon imgDescriptor) {
		Image result = this.map.get(imgDescriptor);
		if (result == null) {
			result = imgDescriptor.createImage();
			this.map.put(imgDescriptor, result);
			if (DEBUG) {
				final Bundle bundle = this.plugin.getBundle();
				final String bundleId = bundle.getSymbolicName();
				final String message = String.format(
						"New image loaded from an overlay icon (bundle=%s)", //$NON-NLS-1$
						bundleId);
				DebugUtils.debug(message);
			}
		}
		return result;
	}

	public Image getImage(final String path) {
		return this.delegate.getImage(path);
	}

	public ImageDescriptor createImageDescriptor(final String resourcePath) {
		return this.delegate.createImageDescriptor(resourcePath);
	}

	public Image getImage(final ImageDescriptor imgDescriptor) {
		return this.delegate.getImage(imgDescriptor);
	}
}
