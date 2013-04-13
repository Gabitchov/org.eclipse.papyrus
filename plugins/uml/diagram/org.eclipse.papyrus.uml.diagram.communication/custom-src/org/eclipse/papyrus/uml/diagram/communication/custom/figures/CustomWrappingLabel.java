/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia DHOUIB (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.communication.custom.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.uml.diagram.communication.custom.helper.RotationHelper;
import org.eclipse.papyrus.uml.diagram.communication.part.UMLDiagramEditorPlugin;
import org.eclipse.swt.graphics.Image;

/**
 * This class extends the WrappingLabel class to permit the rotation of the
 * WrappingLabel icon
 * 
 * 
 * 
 */
public class CustomWrappingLabel extends WrappingLabel

{

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public CustomWrappingLabel() {
		super();

	}



	/**
	 * 
	 * Constructor.
	 * 
	 * @param text
	 */
	public CustomWrappingLabel(String text) {
		super(text);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param image
	 */
	public CustomWrappingLabel(Image image) {
		super(image);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param text
	 * @param image
	 */
	public CustomWrappingLabel(String text, Image image) {
		super(text, image);
	}

	/** rotation angle in degrees */
	private double rotation = 0;

	/**
	 * This method Sets the angle of the rotation.<BR>
	 * 
	 * 
	 * @param angle
	 *        angle of the rotation in radians
	 * 
	 */
	public void setRotation(double angle) {

		this.rotation = Math.toDegrees(angle);

	}

	static final String PATH = "/icons/arrow1.gif"; //$NON-NLS-1$

	/**
	 * Paints the custom icon that has been rotated
	 * 
	 * @param graphics
	 *        The graphics context
	 */
	private void CustomPaintIcons(Graphics graphics) {
		Point p = Point.SINGLETON;
		graphics.pushState();

		if(getIconLocation() != null) {
			p.setLocation(getIconLocation());

			Rectangle figBounds = getBounds();
			graphics.translate(figBounds.x, figBounds.y);

			int num = getNumberofIcons();
			for(int i = 0; i < num; i++) {
				// Image icon = getIcon(i);
				Image icon = org.eclipse.papyrus.uml.diagram.common.Activator.getPluginIconImage(UMLDiagramEditorPlugin.ID, PATH);
				if(icon != null) {
					icon.setBackground(getBackgroundColor());
					// Image image1 = new Image(PlatformUI.getWorkbench().getDisplay(), RotationHelper.rotateImage(icon, getRotation()));
					Image image1 = RotationHelper.rotateImage(icon, getRotation());

					graphics.setClip(graphics.getClip(new Rectangle()).expand(100, 100));
					graphics.drawImage(image1, p);
					// System.out.format("\n***The icon is rotated by %f \n****",
					// getRotation());
					image1.dispose();

					p.x += getIconSize(i).width;
				}
			}
			graphics.translate(-figBounds.x, -figBounds.y);
		}
		graphics.popState();


	}



	@Override
	public void paintFigure(Graphics graphics) {
		// super.paintFigure(graphics);

		if(hasIcons()) {
			CustomPaintIcons(graphics);
			//call repaint to refresh (This repaint is no more needed, it consumes a lot of CPU resource)
			//repaint();
		}
	}

	/**
	 * gets the class member rotation
	 * 
	 * @return the angle of rotation in degrees
	 */
	public double getRotation() {
		return rotation;
	}

}
