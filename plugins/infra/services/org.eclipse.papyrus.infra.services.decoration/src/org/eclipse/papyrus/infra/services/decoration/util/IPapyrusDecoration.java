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
 *  Ansgar Radermacher (CEA LIST) - ansgar.radermacher@cea.fr
 * 
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.decoration.util;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.services.decoration.util.Decoration.PreferedPosition;


/**
 * The Interface IPapyrusDecoration use to capture decoration icons (big/small), their position and the
 * associated message.
 * We explicitly prefix the interface with IPapyrus to avoid confusion with the IDecoration
 * interface in JFace.
 * A priority can be associated to a decoration. In the case where multiple decoration icons have the same positon, 
 * the priority allows to choose the which decoration icon will be shown. 
 */
public interface IPapyrusDecoration {
	
	/**
	 * Gets the priority.
	 * 
	 * @return the priority
	 */
	int getPriority();
	
	/**
	 * Sets the priority.
	 * 
	 * @param priority
	 * 		  the new priority
	 */
	void setPriority(int priority);

	/**
	 * Sets the message.
	 * 
	 * @param message
	 *        the new message
	 */
	void setMessage(String message);

	/**
	 * Gets the message.
	 * 
	 * @return the message
	 */
	String getMessage();

	/**
	 * @return the type (corresponding to marker type)
	 */
	public String getType();

	/**
	 * Sets the decoration image for a graphical editor.
	 * 
	 * @param imageDescriptor
	 *        the new decoration image
	 */
	void setDecorationImageForGE(ImageDescriptor imageDescriptor);

	/**
	 * Gets the decoration image for a graphical editor
	 * 
	 * @return the decoration image
	 */
	ImageDescriptor getDecorationImageForGE();

	/**
	 * Sets the decoration image for the model explorer.
	 * 
	 * @param imageDescriptor
	 *        the new decoration image
	 */
	void setDecorationImageForME(ImageDescriptor imageDescriptor);

	/**
	 * Gets the decoration image for the model explorer
	 * 
	 * @return the decoration image
	 */
	ImageDescriptor getDecorationImageForME();


	/**
	 * Sets the position.
	 * 
	 * @param position
	 *        the new position
	 */
	void setPosition(PreferedPosition position);

	/**
	 * Gets the position.
	 * 
	 * @return the position
	 */
	PreferedPosition getPosition();

	/**
	 * @return the decoration position as enumerated by constants in IDecoration from JFace
	 *         (TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT, UNDERLAY
	 */
	int getPositionForJFace();

}
