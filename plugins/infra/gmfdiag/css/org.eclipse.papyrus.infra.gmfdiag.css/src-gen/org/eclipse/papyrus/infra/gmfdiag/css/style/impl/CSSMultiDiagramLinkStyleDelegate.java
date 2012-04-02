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

import org.eclipse.gmf.runtime.notation.MultiDiagramLinkStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSMultiDiagramLinkStyle;

public class CSSMultiDiagramLinkStyleDelegate implements CSSMultiDiagramLinkStyle {

	private MultiDiagramLinkStyle multiDiagramLinkStyle;

	private ExtendedCSSEngine engine;

	public CSSMultiDiagramLinkStyleDelegate(MultiDiagramLinkStyle multiDiagramLinkStyle, ExtendedCSSEngine engine) {
		this.multiDiagramLinkStyle = multiDiagramLinkStyle;
		this.engine = engine;
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

}
