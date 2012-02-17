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
package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style;


public interface CSSFillStyle {

	public String GRADIENT_VERTICAL = "vertical";

	public String GRADIENT_HORIZONTAL = "horizontal";


	public int getCSSFillColor();


	public int getCSSTransparency();


	public org.eclipse.gmf.runtime.notation.datatype.GradientData getCSSGradient();

}