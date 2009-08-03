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
package org.eclipse.papyrus.diagram.common;

import org.eclipse.jface.resource.CompositeImageDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;

/**
 * This class is used to add UML visibility decoration over stereotype icons
 * 
 */
public class OverlayVisibilityIcon extends CompositeImageDescriptor {

	/**
	 * Initial image
	 */
	private Image initialImage;

	/**
	 * Initial image
	 */
	private ImageDescriptor visDesc;

	/**
	 * Size of the initial image
	 */
	private Point size;

	/**
	 * Main constructor
	 */
	public OverlayVisibilityIcon(Image initialImage, ImageDescriptor visibilityDescriptor) {
		this.initialImage = initialImage;
		this.visDesc = visibilityDescriptor;
		this.size = new Point(initialImage.getBounds().width, initialImage.getBounds().height);
	}

	@Override
	protected void drawCompositeImage(int arg0, int arg1) {
		// Draw the base image
		drawImage(initialImage.getImageData(), 0, 0);
		ImageData imageData = visDesc.getImageData();
		drawImage(imageData, size.x - imageData.width, size.y - imageData.height);
	}

	@Override
	protected Point getSize() {
		return size;
	}

	/**
	 * Get the image formed by overlaying different images on the base image
	 * 
	 * @return composite image
	 */
	public Image getImage() {
		return createImage();
	}
}
