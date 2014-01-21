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

import org.eclipse.draw2d.Graphics;
import org.eclipse.papyrus.uml.diagram.common.figure.edge.DashedEdgeFigure;

/**this class has to option to display it:
* normal with the UML view or as a link to display lollipop 
**/
public class UsageLinkFigure extends DashedEdgeFigure{
	
	private boolean asLink = true;
	
	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.edge.DashedEdgeFigure#resetStyle()
	 */
	@Override
	public void resetStyle() {
		this.arrow = !asLink;
		setupDefaultStyle();
		if (asLink) {
			this.setLineStyle(Graphics.LINE_SOLID);
		} else {
			this.setLineStyle(Graphics.LINE_CUSTOM);
		}
	}

	/**
	 * display it as a line
	 */
	public void displayAsAlink(){
		asLink = true;
	}

	/**
	 * display it as the UML representation with its decoration
	 */
	public void displayAsUMLShape(){
		asLink = false;
	}
}
