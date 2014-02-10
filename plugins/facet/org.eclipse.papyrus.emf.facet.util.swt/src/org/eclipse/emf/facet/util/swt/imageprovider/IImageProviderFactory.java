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
 ******************************************************************************/
package org.eclipse.emf.facet.util.swt.imageprovider;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.facet.util.swt.internal.imageprovider.ImageProviderFactory;

public interface IImageProviderFactory {

	IImageProviderFactory DEFAULT = new ImageProviderFactory();
	
	IImageProvider createIImageProvider(Plugin plugin);
}
