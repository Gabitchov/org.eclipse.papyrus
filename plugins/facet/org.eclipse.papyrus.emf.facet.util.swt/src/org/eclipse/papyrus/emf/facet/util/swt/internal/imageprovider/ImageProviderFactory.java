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
 ******************************************************************************/
package org.eclipse.emf.facet.util.swt.internal.imageprovider;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.facet.util.swt.imageprovider.IImageProvider;
import org.eclipse.emf.facet.util.swt.imageprovider.IImageProviderFactory;

public class ImageProviderFactory implements IImageProviderFactory {

	private final Map<Plugin, IImageProvider> map = new HashMap<Plugin, IImageProvider>();
	
	public IImageProvider createIImageProvider(final Plugin plugin) {
		IImageProvider result = this.map.get(plugin);
		if (result == null) {
			result = new ImageProvider(plugin);
			this.map.put(plugin, result);
		}
		return result;
	}

}
