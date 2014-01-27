/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.helper;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.infra.gmfdiag.css.resource.CSSNotationResourceFactory;

/**
 * A Helper for CSS features
 * 
 * @author Camille Letavernier
 */
public class CSSHelper {

	/**
	 * Makes the given resourceSet compatible with the ExtendedCSSEngines.
	 * 
	 * This method should be called before loading resources from this resource set.
	 * 
	 * @param resourceSet
	 *        The resource set on which the CSS Support will be installed
	 */
	public static void installCSSSupport(ResourceSet resourceSet) {
		CSSNotationResourceFactory factory = new CSSNotationResourceFactory();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(NotationModel.NOTATION_FILE_EXTENSION, factory);
	}

	/**
	 * Tests whether the given resourceSet supports the CSS Styling
	 * 
	 * @param resourceSet
	 * @return
	 * 
	 * @see #installCSSSupport(ResourceSet)
	 */
	public static boolean isCSSSupported(ResourceSet resourceSet) {
		if(resourceSet == null) {
			return false;
		}
		return resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().get(NotationModel.NOTATION_FILE_EXTENSION) instanceof CSSNotationResourceFactory;
	}
}
