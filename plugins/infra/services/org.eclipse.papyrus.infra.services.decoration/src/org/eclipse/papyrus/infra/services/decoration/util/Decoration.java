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

import java.util.List;

import org.apache.commons.lang.WordUtils;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.papyrus.infra.services.decoration.DecorationService;


// TODO: Auto-generated Javadoc
/**
 * The Class Decoration.
 */
public class Decoration implements IPapyrusDecoration {

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

	/** The message. */
	private String message;

	/** The element. */
	private EObject element;

	/** The decoration image for the graphical editor */
	private ImageDescriptor decorationImageForGE;

	/** The decoration image for the model explorer */
	private ImageDescriptor decorationImageForME;

	/** The decoration type, currently corresponding to marker name */
	private String type;

	/** The position. */
	private PreferedPosition position;

	/** The priority. */
	private int priority;

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
	 * @param priority
	 *        the priority
	 */
	public Decoration(String id, String type, ImageDescriptor decorationImageForGE, ImageDescriptor decorationImageForME, String message, EObject element, int priority) {

		this.id = id;
		this.decorationImageForGE = decorationImageForGE;
		this.decorationImageForME = decorationImageForME;
		this.message = message;
		this.element = element;
		this.type = type;
		this.position = PreferedPosition.SOUTH_EAST;
		this.priority = priority;
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
	 * @return the type (corresponding to marker type)
	 */
	public String getType() {
		return type;
	}

	/**
	 * Gets the message.
	 * 
	 * @return the message
	 * @see org.eclipse.papyrus.infra.services.decoration.util.IPapyrusDecoration#getMessage()
	 */

	public String getMessage() {
		return message;
	}


	/**
	 * Sets the message.
	 * 
	 * @param message
	 *        the new message
	 * @see org.eclipse.papyrus.infra.services.decoration.util.IPapyrusDecoration#setMessage(java.lang.String)
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
	 * Gets the decoration image for a graphical editor.
	 * 
	 * @return the decoration image
	 * @see org.eclipse.papyrus.infra.services.decoration.util.IPapyrusDecoration#getDecorationImage()
	 */
	public ImageDescriptor getDecorationImageForGE() {
		return decorationImageForGE;
	}

	/**
	 * Sets the decoration image for a graphical editor.
	 * 
	 * @param decorationImage
	 *        the new decoration image
	 * @see org.eclipse.papyrus.infra.services.decoration.util.IPapyrusDecoration#setDecorationImageForGE(org.eclipse.jface.resource.ImageDescriptor)
	 */
	public void setDecorationImageForGE(ImageDescriptor decorationImageForGE) {
		this.decorationImageForGE = decorationImageForGE;
	}

	/**
	 * Gets the decoration image for the model explorer.
	 * 
	 * @return the decoration image
	 * @see org.eclipse.papyrus.infra.services.decoration.util.IPapyrusDecoration#getDecorationImage()
	 */
	public ImageDescriptor getDecorationImageForME() {
		return decorationImageForME;
	}

	/**
	 * Sets the decoration image for the model explorer.
	 * 
	 * @param decorationImage
	 *        the new decoration image
	 * @see org.eclipse.papyrus.infra.services.decoration.util.IPapyrusDecoration#setDecorationImageForGE(org.eclipse.jface.resource.ImageDescriptor)
	 */
	public void setDecorationImageForME(ImageDescriptor decorationImageForME) {
		this.decorationImageForME = decorationImageForME;
	}


	/**
	 * Gets the position. Only used for display within model explorer
	 * 
	 * @return the position
	 * @see org.eclipse.papyrus.infra.services.decoration.util.IPapyrusDecoration#getPosition()
	 */
	public PreferedPosition getPosition() {
		return position;
	}


	/**
	 * Sets the position.
	 * 
	 * @param position
	 *        the new position
	 * @see org.eclipse.papyrus.infra.services.decoration.util.IPapyrusDecoration#setPosition(org.eclipse.papyrus.infra.services.decoration.util.Decoration.PreferedPosition)
	 */

	public void setPosition(PreferedPosition position) {
		this.position = position;
	}

	/**
	 * @return the decoration position as enumerated by constants in IDecoration from JFace
	 *         (TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT, UNDERLAY
	 */
	public int getPositionForJFace() {
		switch(position) {
		case NORTH_WEST:
		case NORTH:
			return IDecoration.TOP_LEFT;

		case NORTH_EAST:
			return IDecoration.TOP_RIGHT;
		case WEST:
		case SOUTH_WEST:
			return IDecoration.BOTTOM_LEFT;
		case EAST:
		case SOUTH_EAST:
		case DEFAULT:
		default:
			return IDecoration.BOTTOM_RIGHT;
		case SOUTH:
		case CENTER:
			return IDecoration.UNDERLAY;
		}
	}

	/**
	 * @param element the element for which we want to get the message. This must be an eObject or an object
	 *        that can be adapted to an eObject (which is the case for elements of the model explorer)
	 * @return the decoration message. This might be a multi-line message
	 */
	public static String getMessageFromDecorations(DecorationService decorationService, Object element) {

		if (decorationService == null) {
			return null;
		}

		List<IPapyrusDecoration> decorations = decorationService.getDecorations(element, true);

		EObject eObject = (EObject)Platform.getAdapterManager().getAdapter(element, EObject.class);
		String message = decorationService.initialMessage(eObject);
		if(decorations != null) {
			for(IPapyrusDecoration decoration : decorations) {
				if(message.length() > 0) {
					message += "\n"; //$NON-NLS-1$
               	}
				if (decoration.getMessage() != null) {
					message += WordUtils.wrap(decoration.getMessage(), 100, "\n  ", true); //$NON-NLS-1$
				}
			}
		}
		if (message.length() > 0) {
			return message;
		}
		else {
			return null;
		}
    }
 
	
	/**
	 * Gets the priority.
	 * 
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * Sets the priority.
	 * 
	 * @param priority
	 * 		  the new priority
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
}
