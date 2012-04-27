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
	 */
	public static void installCSSSupport(ResourceSet resourceSet) {
		CSSNotationResourceFactory factory = new CSSNotationResourceFactory();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("notation", factory); //$NON-NLS-1$
	}
}
