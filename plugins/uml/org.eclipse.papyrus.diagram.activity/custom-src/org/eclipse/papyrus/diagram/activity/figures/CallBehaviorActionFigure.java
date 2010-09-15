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
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.figure.node.PapyrusRoundedNodeFigure;
import org.eclipse.swt.graphics.Image;

/**
 * this is a specific figure to display the rake of this action
 *
 */
public class CallBehaviorActionFigure extends PapyrusRoundedNodeFigure {

	protected static final String IMAGE_PATH = "/icons/obj16/rake.gif";
	protected static final int margin=5;
	protected boolean isDisplayedRake=false;
	/**
	 * set true to display the rake
	 * @param displayRake true to display the rake
	 */
	public void displayRake(boolean displayRake) {
		this.isDisplayedRake=displayRake;
	}

	@Override
	public void paint(Graphics graphics) {
		// TODO Auto-generated method stub
		super.paint(graphics);
		if(isDisplayedRake){
			Image image=Activator.getDefault().getPluginIconImage(UMLDiagramEditorPlugin.ID, IMAGE_PATH);
			org.eclipse.draw2d.geometry.Rectangle rect=getBounds();
			Point pt=rect.getBottomRight();
			pt.x=pt.x-image.getBounds().width-margin;
			pt.y=pt.y-image.getBounds().height-margin;
			graphics.drawImage(image, pt);
		}
	}
}
