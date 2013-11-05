/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.service.shape;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.gmfdiag.common.Activator;
import org.w3c.dom.svg.SVGDocument;

/**
 * A Post-Processor for SVG Documents
 * 
 * Can be used to apply transformations before the SVGDocument is displayed on the diagram
 * 
 * @author Camille Letavernier
 * 
 */
public interface SVGPostProcessor {

	public static final String EXTENSION_POINT = Activator.ID + ".svgPostProcessors";

	public static final String EXTENSION_CLASS_NAME_ATTRIBUTE = "implementation";

	/**
	 * Singleton instance of the composite SVGPostProcessor. It aggregates all post-processors
	 * declared via the {@link #EXTENSION_POINT} extension point
	 */
	public SVGPostProcessor instance = new SVGPostProcessorImpl();

	/**
	 * Apply a transformation on the given SVGDocument before it is rendered
	 * The view can be used as the context of the transformation
	 * 
	 * @param view
	 * @param document
	 */
	public void postProcess(EObject view, SVGDocument document);

}
