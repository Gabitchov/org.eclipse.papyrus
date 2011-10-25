/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Amine EL KOUHEN (CEA LIST/LIFL) - Amine.Elkouhen@cea.fr 
 *****************************************************************************/
package org.eclipse.papyrus.decoration.util;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.decoration.util.Decoration.PreferedPosition;


// TODO: Auto-generated Javadoc
/**
 * The Interface IDecoration.
 */
public interface IDecoration {

	/**
	 * Sets the severity.
	 *
	 * @param severity the new severity
	 */
	void setSeverity(int severity);

	/**
	 * Gets the severity.
	 *
	 * @return the severity
	 */
	int getSeverity();

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	void setMessage(String message);

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	String getMessage();

	/**
	 * Sets the decoration image.
	 *
	 * @param imageDescriptor the new decoration image
	 */
	void setDecorationImage(ImageDescriptor imageDescriptor);

	/**
	 * Gets the decoration image.
	 *
	 * @return the decoration image
	 */
	ImageDescriptor getDecorationImage();

	/**
	 * Sets the position.
	 *
	 * @param position the new position
	 */
	void setPosition(PreferedPosition position);

	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	PreferedPosition getPosition();

}
