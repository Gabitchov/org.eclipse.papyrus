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
package org.eclipse.papyrus.views.modelexplorer.core.ui.pagebookview;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.papyrus.infra.services.decoration.util.Decoration.PreferedPosition;
import org.eclipse.papyrus.views.modelexplorer.Activator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;


// TODO: Auto-generated Javadoc
/**
 * The Class ModelExplorerDecorationAdapter.
 */
public class ModelExplorerDecorationAdapter {

	/** The decorator target. */
	protected Image decoratorTarget;

	/** The decoration. */
	protected ImageDescriptor decoration;

	/** The decoration position. */
	protected int decorationPosition;

	/** point corresponding to the size 16x16. */
	private final Point size16 = new Point(16, 16);


	/**
	 * Instantiates a new model explorer decoration adapter.
	 *
	 * @param baseImage the base image
	 */
	public ModelExplorerDecorationAdapter(Image baseImage) {
		this.decoratorTarget = baseImage;
	}

	/**
	 * Gets the decorated image.
	 *
	 * @return the decorated image
	 */
	public Image getDecoratedImage() {

		if(getDecoration() == null && getDecoratorTarget() != null) {
			return getDecoratorTarget();
		}

		if(getDecoration() == null && getDecoratorTarget() == null) {
			return null;
		}

		return getDecoratedImage(getDecoratorTarget(), getDecoration(), getDecorationPosition());
	}

	/**
	 * Gets the decoration.
	 *
	 * @return the decoration
	 */
	public ImageDescriptor getDecoration() {
		return this.decoration;
	}

	/**
	 * Gets the decorator target.
	 *
	 * @return the decorator target
	 */
	public Image getDecoratorTarget() {
		return this.decoratorTarget;
	}

	/**
	 * Sets the decoration.
	 *
	 * @param decoration the decoration
	 * @param decorationPosition the decoration position
	 */
	public void setDecoration(ImageDescriptor decoration, int decorationPosition) {
		setDecoratedImage(getDecoratorTarget(), decoration, decorationPosition);
		this.decoration = decoration;
		this.decorationPosition = decorationPosition;

	}

	/**
	 * Sets the decoration.
	 *
	 * @param decoration the new decoration
	 */
	public void setDecoration(ImageDescriptor decoration) {
		setDecoratedImage(getDecoratorTarget(), decoration, getDecorationPosition());
		this.decoration = decoration;
	}

	/**
	 * Sets the decorator target.
	 *
	 * @param decoratorTarget the new decorator target
	 */
	public void setDecoratorTarget(Image decoratorTarget) {
		this.decoratorTarget = decoratorTarget;
	}


	/**
	 * Gets the decoration position.
	 *
	 * @return the decoration position
	 */
	public int getDecorationPosition() {
		//0 for TOP_LEFT, 1 for TOP_RIGHT, 2 for BOTTOM_LEFT, 3 for BOTTOM_RIGHT (Default), 4 for an UNDERLAY
		return decorationPosition;
	}


	/**
	 * Sets the decoration position.
	 *
	 * @param decorationPosition the new decoration position
	 */
	public void setDecorationPosition(int decorationPosition) {
		this.decorationPosition = decorationPosition;
	}

	/**
	 * Sets the decorated image.
	 *
	 * @param baseImage the base image
	 * @param decoration the decoration
	 * @param decorationPosition the decoration position
	 */
	public void setDecoratedImage(Image baseImage, ImageDescriptor decoration, int decorationPosition) {

		if(decoration == null || baseImage == null) {
			return;
		}

		DecorationOverlayIcon decoratedImage = null;

		// Construct a new image identifier
		String decoratedImageId = baseImage.toString().concat(decoration.toString() + decorationPosition);

		// Return the stored image if we have one
		if(Activator.getDefault().getImageRegistry().get(decoratedImageId) == null) {
			// Otherwise create a new image and store it
			switch(decorationPosition) {

			case IDecoration.TOP_LEFT:
				decoratedImage = new DecorationOverlayIcon(baseImage, new ImageDescriptor[]{ decoration, null, null, null, null }, size16);
				break;
			case IDecoration.TOP_RIGHT:
				decoratedImage = new DecorationOverlayIcon(baseImage, new ImageDescriptor[]{ null, decoration, null, null, null }, size16);
				break;
			case IDecoration.BOTTOM_LEFT:
				decoratedImage = new DecorationOverlayIcon(baseImage, new ImageDescriptor[]{ null, null, decoration, null, null }, size16);
				break;
			case IDecoration.BOTTOM_RIGHT:
				decoratedImage = new DecorationOverlayIcon(baseImage, new ImageDescriptor[]{ null, null, null, decoration, null }, size16);
				break;
			case IDecoration.UNDERLAY:
				decoratedImage = new DecorationOverlayIcon(baseImage, new ImageDescriptor[]{ null, null, null, null, decoration }, size16);
				break;
			default:
				decoratedImage = new DecorationOverlayIcon(baseImage, new ImageDescriptor[]{ null, null, decoration, null, null }, size16);
				break;
			}
			Activator.getDefault().getImageRegistry().put(decoratedImageId, decoratedImage);
		}

	}

	/**
	 * Gets the decorated image.
	 *
	 * @param baseImage the base image
	 * @param decoration the decoration
	 * @param decorationPosition the decoration position
	 * @return the decorated image
	 */
	public Image getDecoratedImage(Image baseImage, ImageDescriptor decoration, int decorationPosition) {
		// Construct a new image identifier
		String decoratedImageId = baseImage.toString().concat(decoration.toString() + decorationPosition);

		// Return the stored image if we have one
		if(Activator.getDefault().getImageRegistry().get(decoratedImageId) == null) {
			setDecoratedImage(baseImage, decoration, decorationPosition);
		}
		return Activator.getDefault().getImageRegistry().get(decoratedImageId);
	}

	/**
	 * Sets the decorated image.
	 *
	 * @param baseImage the base image
	 * @param decorationArray the decoration array
	 * @param imageSize the image size
	 */
	public void setDecoratedImage(Image baseImage, ImageDescriptor[] decorationArray, Point imageSize) {
		DecorationOverlayIcon decoratedImage = null;

		// Construct a new image identifier
		String decoratedImageId = baseImage.toString().concat(decorationArray.toString());

		// Return the stored image if we have one
		if(Activator.getDefault().getImageRegistry().get(decoratedImageId) == null) {
			// Otherwise create a new image and store it
			decoratedImage = new DecorationOverlayIcon(baseImage, decorationArray, imageSize);

			Activator.getDefault().getImageRegistry().put(decoratedImageId, decoratedImage);
		}
	}

	/**
	 * Sets the decoration.
	 *
	 * @param decoration the decoration
	 * @param position the position
	 */
	public void setDecoration(ImageDescriptor decoration, PreferedPosition position) {
		switch(position) {

		case NORTH_WEST:
			setDecoration(decoration, IDecoration.TOP_LEFT);
			break;
		case NORTH:
			setDecoration(decoration, IDecoration.TOP_RIGHT);
			break;
		case NORTH_EAST:
			setDecoration(decoration, IDecoration.TOP_RIGHT);
			break;
		case EAST:
			setDecoration(decoration, IDecoration.BOTTOM_RIGHT);
			break;
		case SOUTH_EAST:
			setDecoration(decoration, IDecoration.BOTTOM_RIGHT);
			break;
		case SOUTH:
			setDecoration(decoration, IDecoration.BOTTOM_LEFT);
			break;
		case SOUTH_WEST:
			setDecoration(decoration, IDecoration.BOTTOM_LEFT);
			break;
		case WEST:
			setDecoration(decoration, IDecoration.TOP_LEFT);
			break;
		case CENTER:
			setDecoration(decoration, IDecoration.UNDERLAY);
			break;
		default:
			setDecoration(decoration, IDecoration.BOTTOM_LEFT);
			break;

		}
	}
}
