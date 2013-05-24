/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.celleditor;

import org.eclipse.swt.graphics.Image;

/**
 * This class allows to store required information to customize
 * a Button and define the action done when it is pressed.
 */
public class ButtonConfiguration {

	/** The text to use for the button. */
	private String text;

	/** The tooltip to use for the button. */
	private String tooltipText;

	/** the action done by the button. */
	private AbstractComboAction action;

	/** the image to set on the button. */
	private Image image;


	/**
	 * Gets the image.
	 * 
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}


	/**
	 * Sets the image.
	 * 
	 * @param image
	 *        the new image
	 */
	public void setImage(Image image) {
		this.image = image;
	}


	/**
	 * Gets the text.
	 * 
	 * @return the text
	 */
	public String getText() {
		return text;
	}


	/**
	 * Sets the text.
	 * 
	 * @param text
	 *        the new text
	 */
	public void setText(String text) {
		this.text = text;
	}


	/**
	 * Gets the tooltip text.
	 * 
	 * @return the tooltip text
	 */
	public String getTooltipText() {
		return tooltipText;
	}


	/**
	 * Sets the tooltip text.
	 * 
	 * @param tooltipText
	 *        the new tooltip text
	 */
	public void setTooltipText(String tooltipText) {
		this.tooltipText = tooltipText;
	}


	/**
	 * Gets the action.
	 * 
	 * @return the action
	 */
	public AbstractComboAction getAction() {
		return action;
	}


	/**
	 * Sets the action.
	 * 
	 * @param action
	 *        the new action
	 */
	public void setAction(AbstractComboAction action) {
		this.action = action;
	}

}
