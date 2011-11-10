/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Florian Noyrit (CEA LIST) florian.noyrit@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.tabbed.customization.dialog;

import org.eclipse.swt.graphics.Image;

/**
 * Abstract class used to be specialized for the various errors and warnings found by the validator in a configuration
 */
public abstract class AbstractValidationProblem {

	/** The message to display as introduction of the problem */
	protected String message;

	/**
	 * Returns the full text description of the problem
	 * 
	 * @return the text description of the problem
	 */
	public abstract String getText();

	/**
	 * Returns the image of the problem
	 * 
	 * @return the image of the problem
	 */
	public abstract Image getImage();

	/**
	 * Getter for the message
	 * 
	 * @return
	 *         the message displayed as introduction of the problem
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Setter for the message
	 * 
	 * @param message
	 *        the message to display as introduction of the problem
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
