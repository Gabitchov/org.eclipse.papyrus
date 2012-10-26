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

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.papyrus.infra.services.decoration.util.IPapyrusDecoration;
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
	protected EList<IPapyrusDecoration> decorations;

	/** The decoration position. */
	protected int decorationPosition;

	/** point corresponding to the size 16x16. */
	private final Point size16 = new Point(16, 16);


	/**
	 * Instantiates a new model explorer decoration adapter.
	 * 
	 * @param baseImage
	 *        the base image
	 */
	public ModelExplorerDecorationAdapter(Image baseImage) {
		this.decoratorTarget = baseImage;
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
	 * @param decoration
	 *        the decoration
	 * @param decorationPosition
	 *        the decoration position
	 */
	public void setDecorations(EList<IPapyrusDecoration> decorations) {
		this.decorations = decorations;
	}

	/**
	 * Sets the decorator target.
	 * 
	 * @param decoratorTarget
	 *        the new decorator target
	 */
	public void setDecoratorTarget(Image decoratorTarget) {
		this.decoratorTarget = decoratorTarget;
	}


	/**
	 * Sets the decoration position.
	 * 
	 * @param decorationPosition
	 *        the new decoration position
	 */
	public void setDecorationPosition(int decorationPosition) {
		this.decorationPosition = decorationPosition;
	}

	/**
	 * Sets the decorated image.
	 * 
	 * @param baseImage
	 *        the base image
	 * @param decoration
	 *        the decoration
	 * @param decorationPosition
	 *        the decoration position
	 */
	public Image getDecoratedImage() {

		if(decorations == null) {
			return decoratorTarget;
		}

		Image decoratedImage = null;

		// Construct a new image identifier
		String decoratedImageId = calcId();

		decoratedImage = Activator.getDefault().getImageRegistry().get(decoratedImageId);
		// Return the stored image if we have one
		if(decoratedImage == null) {
			// Otherwise create a new image and store it
			ImageDescriptor[] decorationImages = new ImageDescriptor[5];
			// Store the decoration by position 
			IPapyrusDecoration[] decorationByPosition = new IPapyrusDecoration[5];

			for(IPapyrusDecoration decoration : decorations) {
				IPapyrusDecoration existingDecoration = decorationByPosition[decoration.getPositionForJFace()];
				if (existingDecoration == null || existingDecoration.getPriority() < decoration.getPriority()) {
					// if no decoration exists for the current position
					// or if the existing decoration has a lower priority than the current
					// replace the existing decoration with the current one
					decorationImages[decoration.getPositionForJFace()] = decoration.getDecorationImageForME();
					decorationByPosition[decoration.getPositionForJFace()] = decoration;
				}
			}
			ImageDescriptor decoratedImageDesc = new DecorationOverlayIcon(decoratorTarget, decorationImages, size16);
			Activator.getDefault().getImageRegistry().put(decoratedImageId, decoratedImageDesc);
			return Activator.getDefault().getImageRegistry().get(decoratedImageId);
		}
		return decoratedImage;
	}

	public String calcId() {
		String decoratedImageId = decoratorTarget.toString();
		for(IPapyrusDecoration decoration : decorations) {
			decoratedImageId += decoration.getDecorationImageForME().toString() + decoration.getPosition();
		}
		return decoratedImageId;
	}
}
