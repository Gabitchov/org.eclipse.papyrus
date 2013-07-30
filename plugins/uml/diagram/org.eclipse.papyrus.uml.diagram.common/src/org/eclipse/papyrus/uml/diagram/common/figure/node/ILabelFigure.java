/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.figure.node;

import org.eclipse.swt.graphics.Image;

/**
 * Standard interface for custom figures displaying text and icon
 */
public interface ILabelFigure {

	/**
	 * Sets the text for this figure
	 * 
	 * @param text
	 *        the text to display
	 * @return the text to display
	 */
	public void setText(String text);

	/**
	 * Returns the text of this figure
	 * 
	 * @return the text displayed by this figure
	 */
	public String getText();

	/**
	 * Sets the icon for this figure
	 * 
	 * @param icon
	 *        the image to display
	 * @return the image to display
	 */
	public void setIcon(Image icon);

	/**
	 * Returns the image of this figure
	 * 
	 * @return the image displayed by this figure
	 */
	public Image getIcon();
}
