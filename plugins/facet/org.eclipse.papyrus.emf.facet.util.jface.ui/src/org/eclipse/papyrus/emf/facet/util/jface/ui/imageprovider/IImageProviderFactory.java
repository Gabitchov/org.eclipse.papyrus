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
package org.eclipse.papyrus.emf.facet.util.jface.ui.imageprovider;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.papyrus.emf.facet.util.jface.ui.internal.imageprovider.ImageProviderFactory;

/**
 * JFace Image Provider Factory
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * @since 0.4.0
 */
public interface IImageProviderFactory {

	IImageProviderFactory DEFAULT = new ImageProviderFactory();

	/**
	 * Create a new Image Provider Factory. Factories are cached with plugin
	 * instances.
	 * 
	 * @param plugin
	 *            Current plugin which wants an image provider
	 * @return An image provider factory
	 */
	IImageProvider createIImageProvider(Plugin plugin);
}
