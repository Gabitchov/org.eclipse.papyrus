/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.interactionoverview.figures;

import java.util.List;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.uml.diagram.interactionoverview.utils.CreateDiagramImage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;


public class InteractionWithSnapshotFigure extends InteractionUseFigure {

	protected static String HEADER_NAME = "SD";

	protected ImageFigure imageFigure;

	protected Image originalSnapshot;

	protected Image currentSnapshot;

	public InteractionWithSnapshotFigure() {
		this.corner = 0;
		originalSnapshot = null;
		currentSnapshot = null;
	}

	@Override
	protected void createContents() {
		add(createInteractionFigureHeader());
		add(createImagePane());
		setLayoutManager(new InteractionLayoutManager());
		interactionHeader.setText(HEADER_NAME);
	}

	protected class InteractionLayoutManager extends AbstractLayout {

		public void layout(final IFigure container) {
			final List childrenList = container.getChildren();
			for(int i = 0; i < container.getChildren().size(); i++) {
				final IFigure currentFigure = (IFigure)childrenList.get(i);
				if(currentFigure.equals(interactionLabelContainer) || currentFigure.equals(imageFigure)) {
					final Rectangle bound = new Rectangle(((IFigure)childrenList.get(i)).getBounds());
					bound.setSize(((IFigure)childrenList.get(i)).getPreferredSize());
					if(i > 0) {
						bound.y = ((IFigure)childrenList.get(i - 1)).getBounds().getBottomLeft().y + 1;
					} else {
						bound.y = getBounds().y;
					}
					((IFigure)childrenList.get(i)).setBounds(bound);

				}
			}

		}

		@Override
		protected Dimension calculatePreferredSize(final IFigure container, final int wHint, final int hHint) {
			return new Dimension(-1, -1);
		}

	}

	@Override
	public WrappingLabel getNameLabel() {
		return interactionHeader;
	}

	protected IFigure createImagePane() {
		return imageFigure = new ImageFigure();
	}


	public void setSnapshot(final Image image) {
		if(image != null) {
			originalSnapshot = image;
			currentSnapshot = new Image(Display.getDefault(), image, SWT.IMAGE_COPY);
			imageFigure.setImage(image);
		}
	}

	public void updateSnapshot(final Rectangle newBounds) {
		if(originalSnapshot != null) {
			final Image newImage = CreateDiagramImage.resize(originalSnapshot, newBounds.width, newBounds.height);
			imageFigure.setImage(newImage);
			currentSnapshot.dispose();
			currentSnapshot = newImage;
		}
	}

	public ImageFigure getImageFigure() {
		return imageFigure;
	}

	public boolean isImageSizeFitsImageFigure() {
		return (isImageFigureHasBound() && getBounds().width == imageFigure.getBounds().height);
	}

	private boolean isImageFigureHasBound() {
		return imageFigure.getBounds().height != 0 && imageFigure.getBounds().width != 0;
	}

}
