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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;


// TODO: Auto-generated Javadoc
/**
 * The Class Decoration.
 */
public class Decoration implements IDecoration {

	/**
	 * The Enum PreferedPosition.
	 */
	public static enum PreferedPosition {

		/** The NORT h_ west. */
		NORTH_WEST,
		/** The NORTH. */
		NORTH,
		/** The NORT h_ east. */
		NORTH_EAST,
		/** The EAST. */
		EAST,
		/** The SOUT h_ east. */
		SOUTH_EAST,
		/** The SOUTH. */
		SOUTH,
		/** The SOUT h_ west. */
		SOUTH_WEST,
		/** The WEST. */
		WEST,
		/** The CENTER. */
		CENTER,
		/** The DEFAULT POSITION. */
		DEFAULT
	}

	/** The id. */
	private final String id;

	/** The severity. */
	private int severity;

	/** The message. */
	private String message;

	/** The element. */
	private EObject element;

	/** The decoration image. */
	private ImageDescriptor decorationImage;

	/** The position. */
	private PreferedPosition position;

	/**
	 * Instantiates a new decoration.
	 * 
	 * @param id
	 *        the id
	 * @param severity
	 *        the severity
	 * @param message
	 *        the message
	 * @param element
	 *        the element
	 */
	public Decoration(String id, int severity, String message, EObject element) {
		this.id = id;
		this.severity = severity;
		this.message = message;
		this.element = element;
		this.position = PreferedPosition.DEFAULT;
	}


	/**
	 * Instantiates a new decoration.
	 * 
	 * @param id
	 *        the id
	 * @param decorationImage
	 *        the decoration image
	 * @param message
	 *        the message
	 * @param element
	 *        the element
	 */
	public Decoration(String id, ImageDescriptor decorationImage, String message, EObject element) {

		this.id = id;
		this.severity = Integer.MAX_VALUE;
		this.decorationImage = decorationImage;
		this.message = message;
		this.element = element;
	}


	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	/**
	 * Gets the severity.
	 *
	 * @return the severity
	 * @see org.eclipse.papyrus.decoration.util.IDecoration#getSeverity()
	 */

	public int getSeverity() {
		return severity;
	}


	/**
	 * Sets the severity.
	 *
	 * @param severity the new severity
	 * @see org.eclipse.papyrus.decoration.util.IDecoration#setSeverity(int)
	 */

	public void setSeverity(int severity) {
		this.severity = severity;
	}


	/**
	 * Gets the message.
	 *
	 * @return the message
	 * @see org.eclipse.papyrus.decoration.util.IDecoration#getMessage()
	 */

	public String getMessage() {
		return message;
	}


	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 * @see org.eclipse.papyrus.decoration.util.IDecoration#setMessage(java.lang.String)
	 */

	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * Gets the element.
	 * 
	 * @return the element
	 */
	public EObject getElement() {
		return element;
	}


	/**
	 * Sets the element.
	 * 
	 * @param element
	 *        the new element
	 */
	public void setElement(EObject element) {
		this.element = element;
	}

	/**
	 * Gets the decoration image.
	 *
	 * @return the decoration image
	 * @see org.eclipse.papyrus.decoration.util.IDecoration#getDecorationImage()
	 */

	public ImageDescriptor getDecorationImage() {
		return decorationImage;
	}

	/**
	 * Sets the decoration image.
	 *
	 * @param decorationImage the new decoration image
	 * @see org.eclipse.papyrus.decoration.util.IDecoration#setDecorationImage(org.eclipse.jface.resource.ImageDescriptor)
	 */

	public void setDecorationImage(ImageDescriptor decorationImage) {
		this.decorationImage = decorationImage;
	}



	/**
	 * Gets the position.
	 *
	 * @return the position
	 * @see org.eclipse.papyrus.decoration.util.IDecoration#getPosition()
	 */

	public PreferedPosition getPosition() {
		return position;
	}



	/**
	 * Sets the position.
	 *
	 * @param position the new position
	 * @see org.eclipse.papyrus.decoration.util.IDecoration#setPosition(org.eclipse.papyrus.decoration.util.Decoration.PreferedPosition)
	 */

	public void setPosition(PreferedPosition position) {
		this.position = position;
	}



}
