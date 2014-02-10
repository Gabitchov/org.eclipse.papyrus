/*******************************************************************************
 * Copyright (c) 2009 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Gregoire Dupe (Mia-Software)
 *******************************************************************************/
package org.eclipse.emf.facet.util.emf.ui.internal.utils;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.swt.graphics.Image;

/**
 * Utility class for handling {@link Image}s.
 * 
 * @author Gregoire Dupe
 */
public final class ImageUtils {
	private static AdapterFactory composedAdapterFactory = new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

	private ImageUtils() {
		// Nothing to do
	}

	/**
	 * Returns an image for the given model element from the EMF global
	 * registry.
	 * 
	 * @param object
	 *            an {@link EObject} for which an {@link Image} is required
	 * @return an image or <code>null</code> if none was found for the given
	 *         element, or the element is not an {@link EObject}
	 */
	public static Image getImage(final Object object) {
		Image result = null;
		if (object instanceof EObject) {
			EObject eObject = (EObject) object;
			IItemLabelProvider itemLabelProvider = (IItemLabelProvider) ImageUtils.composedAdapterFactory
					.adapt(eObject, IItemLabelProvider.class);
			if (itemLabelProvider != null) {
				Object image = itemLabelProvider.getImage(eObject);
				result = ExtendedImageRegistry.getInstance().getImage(image);
			}
		}
		return result;
	}
}
