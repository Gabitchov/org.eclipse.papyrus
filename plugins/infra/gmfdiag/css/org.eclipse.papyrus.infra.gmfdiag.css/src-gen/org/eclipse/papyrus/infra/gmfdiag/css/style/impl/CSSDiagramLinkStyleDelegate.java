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
package org.eclipse.papyrus.infra.gmfdiag.css.style.impl;

import org.eclipse.gmf.runtime.notation.DiagramLinkStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSDiagramLinkStyle;

public class CSSDiagramLinkStyleDelegate implements CSSDiagramLinkStyle {

	private DiagramLinkStyle diagramLinkStyle;

	private ExtendedCSSEngine engine;

	public CSSDiagramLinkStyleDelegate(DiagramLinkStyle diagramLinkStyle, ExtendedCSSEngine engine) {
		this.diagramLinkStyle = diagramLinkStyle;
		this.engine = engine;
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

}
