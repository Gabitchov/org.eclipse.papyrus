/*******************************************************************************
 * Copyright (c) 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Guyomar (Mia-Software) - Bug 333652 Extension point offering the possibility to declare an EPackage browser
 *    Gregoire Dupe (Mia-Software) - Bug 406578 - Generic Label Provider for EMF objects
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.util.emf.ui.internal.utils;

import org.eclipse.papyrus.emf.facet.util.emf.ui.internal.Activator;
import org.eclipse.papyrus.emf.facet.util.swt.imageprovider.IImageProvider;
import org.eclipse.papyrus.emf.facet.util.swt.imageprovider.IImageProviderFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

/**
 * Provides icons for EMF Facet, and caches them.
 */
public final class ImageProvider {
	public static final String EMFFACET_LOGO = "icons/logoEmfFacetMini.gif"; //$NON-NLS-1$
	public static final String CATALOG = "icons/catalog.png"; //$NON-NLS-1$
	public static final String MODEL = "icons/ModelIcon.gif"; //$NON-NLS-1$

	private static final ImageProvider SINGLETON = new ImageProvider();
	public static final IImageProvider DEFAULT = IImageProviderFactory.DEFAULT
			.createIImageProvider(Activator.getDefault());
	
	private ImageProvider() {
		// Must not be used
	}

	@Deprecated
	public static ImageProvider getInstance() {
		return ImageProvider.SINGLETON;
	}

	@SuppressWarnings("static-method")
	// @SuppressWarnings("static-method") This warning is caused by the
	// redirection code associated to the deprecation of this method.
	@Deprecated
	public Image getEmfFacetLogo() {
		return DEFAULT.getImage(EMFFACET_LOGO);
	}

	@Deprecated
	public static ImageDescriptor getEmfFacetLogoDescriptor() {
		return DEFAULT.createImageDescriptor(ImageProvider.EMFFACET_LOGO);
	}

	/** Return the icon representing a bidirectional link */
	@SuppressWarnings("static-method")
	// @SuppressWarnings("static-method") This warning is caused by the
	// redirection code associated to the deprecation of this method.
	@Deprecated
	public Image getCatalogIcon() {
		return DEFAULT.getImage(CATALOG);
	}
}
