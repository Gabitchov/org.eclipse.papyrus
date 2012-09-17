/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.figure.node;

import org.eclipse.draw2d.IFigure;
import org.eclipse.swt.graphics.Color;

/**
 * Figure associated to {@link NodeEditPart}
 */
//TODO: Move to infra.gmfdiag.common
public interface IPapyrusNodeFigure extends IFigure {

	/**
	 * get the color of the border
	 * 
	 * @return the color
	 */
	public Color getBorderColor();

	/**
	 * 
	 * @return true is the figure is in the mode shadow
	 */
	// @unused
	public boolean isShadow();

	/**
	 * set the color for the border
	 * 
	 * @param borderColor
	 *        color
	 */
	// @unused
	public void setBorderColor(Color borderColor);

	/**
	 * set the shadow
	 * 
	 * @param shadow
	 *        a boolean true if we want to display the shadow
	 */
	public void setShadow(boolean shadow);

	/**
	 * Comes from GMF
	 * <p>
	 * Returns the primary shape being the View of this edit part.
	 * </p>
	 * <b>Warning</b> It should never return <code>null</code>
	 * 
	 * @return the primary shape associated to this edit part.
	 */
	public void setTransparency(int transparency);

	/**
	 * Comes from GMF Sets values defining gradient data.
	 * 
	 * @param gradientColor1
	 * @param gradientColor2
	 * @param gradientStyle
	 * @since 1.2
	 */
	public void setGradientData(int gradientColor1, int gradientColor2, int gradientStyle);

	/**
	 * Comes from GMF Sets the value of isUsingGradient
	 * 
	 * @param b
	 *        value for isUsingGradient
	 * @since 1.2
	 */
	public void setIsUsingGradient(boolean b);

	/**
	 * Comes from GMF {@link NodeFigure#setLineStyle}
	 * 
	 * @param s
	 *        the new line style
	 * @since 1.2
	 */
	public void setLineStyle(int s);

	/**
	 * Comes from GMF {@link NodeFigure#getLineStyle}
	 * 
	 * @since 1.2
	 */
	public int getLineStyle();

	/**
	 * Comes from GMF {@link NodeFigure#setLineWidth}
	 * 
	 * @param w
	 *        the new width
	 * @since 1.2
	 */
	public void setLineWidth(int w);

	/**
	 * Comes from GMF {@link NodeFigure#getLineWidth}
	 * 
	 * @since 1.2
	 */
	public int getLineWidth();
}
