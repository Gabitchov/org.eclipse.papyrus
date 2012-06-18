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
package org.eclipse.papyrus.infra.gmfdiag.css.notation;

import java.util.List;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheet;

/**
 * A GMF Diagram with CSS Support
 * 
 * @author Camille Letavernier
 * 
 */
public interface CSSDiagram extends Diagram {

	/**
	 * Returns the list of stylesheets directly owned by this diagram
	 * 
	 * @return
	 */
	public List<StyleSheet> getStyleSheets();

	/**
	 * Returns the CSS Engine associated to this diagram
	 * 
	 * @return
	 */
	public ExtendedCSSEngine getEngine();

}
