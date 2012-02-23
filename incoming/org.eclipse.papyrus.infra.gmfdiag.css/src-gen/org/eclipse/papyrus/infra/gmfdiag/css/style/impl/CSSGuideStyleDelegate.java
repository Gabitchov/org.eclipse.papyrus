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

import org.eclipse.gmf.runtime.notation.GuideStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSGuideStyle;
import org.w3c.dom.Element;

@SuppressWarnings("restriction")
public class CSSGuideStyleDelegate implements CSSGuideStyle{
	
	private GuideStyle guideStyle;

	private ExtendedCSSEngine engine;

	private Element element;

	public CSSGuideStyleDelegate(GuideStyle guideStyle, ExtendedCSSEngine engine){
		this.guideStyle = guideStyle;
 		this.engine = engine;
		this.element = engine.getElement(this.guideStyle);
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

}
