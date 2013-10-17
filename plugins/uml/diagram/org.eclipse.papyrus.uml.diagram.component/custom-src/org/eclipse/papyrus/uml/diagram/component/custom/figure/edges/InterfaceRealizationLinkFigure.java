/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.custom.figure.edges;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.papyrus.uml.diagram.common.figure.edge.InterfaceRealizationFigure;

/**
 * this class has to option to display it:
 * normal with the UML view or as a link to display lollipop 
 *
 */
public class InterfaceRealizationLinkFigure extends InterfaceRealizationFigure  {
	
	/**
	 * display the link as line
	 */
	public void displayAsAlink(){
		setTargetDecoration(null);
		this.setLineStyle(Graphics.LINE_SOLID); // line drawing style
		
	}
	
	/**
	 * display it as the UML representation with tis decoration
	 */
	public void displayAsUMLShape(){
		PolygonDecoration dec = new PolygonDecoration();
		dec.setScale(15, 5);
		dec.setBackgroundColor(ColorConstants.white);
		dec.setLineWidth(1);
		setTargetDecoration(dec); // arrow at target endpoint

		setForegroundColor(ColorConstants.black);

		this.setLineStyle(Graphics.LINE_CUSTOM); // line drawing style
		
	}
}
