/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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

package org.eclipse.papyrus.uml.diagram.common.figure.node;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

/**
 * This is the interface that all figures of Papyrus have to implement.
 * 
 * @author Patrick Tessier
 * @since 12 september 2006
 * @deprecated tlandre : not used anymore. Use GMF mechanism directly instead
 */
@Deprecated
// @unused
public interface IAbstractElementFigure extends IFigure {

	/**
	 * in order to obtain the background colord of the figure.
	 * 
	 * @return the background color of the figure
	 */
	public Color getBackgroundColor();

	/**
	 * set the backgound color of the figure.
	 * 
	 * @param backgroundColor
	 *        the color in the background
	 */
	public void setBackgroundColor(Color backgroundColor);

	/**
	 * in order to set the border color of the figure.
	 * 
	 * @return the border color of the figure
	 */
	public Color getBorderColor();

	/**
	 * set the border coler of the figure.
	 * 
	 * @param borderColor
	 *        the color of the border of the figure
	 */
	public void setBorderColor(Color borderColor);

	/**
	 * in order to set the icon in the figure this method is used in the case
	 * where the stereotype has got an image (icon).
	 * 
	 * @param img
	 *        the icon that we want to display
	 */
	public void setAppliedStereotypeIcon(Image img);

	/**
	 * get the font of the figure.
	 * 
	 * @return return the font of the figure
	 */
	// @unused
	public String getfigureFont();

	/**
	 * set the font of the figure.
	 * 
	 * @param font
	 *        the font of the figure that we want to see. For instance,
	 *        "Arial"
	 */
	public void setfigureFont(String font);

	/**
	 * get the font size of the figure.
	 * 
	 * @return int the font size
	 */
	public int getFontSize();

	/**
	 * set the text fontsize of the figure.
	 * 
	 * @param fontSize
	 *        that we want to see
	 */
	public void setFontSize(int fontSize);

	/**
	 * get the foreground color of the figure.
	 * 
	 * @return Color the ForeGround color of the figure
	 */
	public Color getForeGroundColor();

	/**
	 * set the Foreground of the figure.
	 * 
	 * @param foreGroundColor
	 *        the color that we want ot see
	 */
	public void setForeGroundColor(Color foreGroundColor);

	/**
	 * get the font color of the text in the figure.
	 * 
	 * @return the font Color of the text in the figure
	 */
	public Color getFontColor();

	/**
	 * set the fontColor of the text in the figure.
	 * 
	 * @param fontColor
	 *        of the text in the figure
	 */
	public void setFontColor(Color fontColor);

	/**
	 * Refresh list of stereotypes of current EditPart if required either with
	 * or without the first stereotype.
	 * 
	 * @param presentation
	 *        type of presentation
	 * @param hasIcon
	 *        the has icon
	 * @param hasShape
	 *        the has shape
	 * @param stereotypes
	 *        String thaht contains Stereotype name
	 */
	public void refreshStereotypes(String stereotypes, String presentation, boolean hasIcon, boolean hasShape);

	/**
	 * set the name of the figure.
	 * 
	 * @param name
	 *        na me of the figure
	 */
	public void setName(String name);

	/**
	 * get the label that contains name of the figure.
	 * 
	 * @return label the name Label.
	 */
	public WrappingLabel getNameLabel();

	/**
	 * get the label that contains stereotype name.
	 * 
	 * @return Label that contains all stereotype names
	 */
	public Label getStereotypesLabel();

	/**
	 * set the qaulified name of the figure.
	 * 
	 * @param qualifiedName
	 *        qulified name of the figure
	 */
	public void setQualifiedName(String qualifiedName);

	/**
	 * get the label that contains the qualified name.
	 * 
	 * @return Label that contains the qualifed name of the figure
	 */
	public Label getQualifiedNameLabel();

	/**
	 * 
	 * @return the minimum witdh of the figure to see all containment
	 */
	public Dimension getMinimumDimension();

	/**
	 * Set the stereotype value. If param is null, remove the label.
	 * 
	 * @param stereotypes
	 *        String that contains list of stereotypes
	 */
	public void setStereotypes(String stereotypes);
}
