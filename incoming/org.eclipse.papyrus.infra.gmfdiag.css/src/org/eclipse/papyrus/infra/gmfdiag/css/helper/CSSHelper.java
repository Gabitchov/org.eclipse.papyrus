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


public class CSSHelper {

	public static void installCSSSupport(ResourceSet resourceSet) {
		CSSNotationResourceFactory factory = new CSSNotationResourceFactory();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("notation", factory); //$NON-NLS-1$
	}
}
