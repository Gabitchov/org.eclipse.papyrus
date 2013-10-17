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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.clazz.custom.figure;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusNodeFigure;

/**
 * this is the figure of a template signature
 * It contains only a compartment for template paramater.
 * 
 */
public class TemplateFigure extends PapyrusNodeFigure {

	RectangleFigure templateParameterRectangle;

	@Override
	public Dimension getPreferredSize(int wHint, int hHint) {
		Dimension prefDim = new Dimension(60, 40);
		// TODO Auto-generated method stub
		Dimension contentDim = templateParameterRectangle.getPreferredSize();
		if(contentDim.width + 10 > prefDim.width) {
			prefDim.width = contentDim.width + 10;
		}
		if(contentDim.height + 10 > prefDim.height) {
			prefDim.height = contentDim.height + 10;
		}
		return prefDim;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public TemplateFigure() {
		templateParameterRectangle = new RectangleFigure();
		templateParameterRectangle.setOpaque(false);
		templateParameterRectangle.setFill(false);
		templateParameterRectangle.setOutline(false);
		templateParameterRectangle.setLineWidth(10);
		templateParameterRectangle.setBorder(null);
		templateParameterRectangle.setForegroundColor(ColorConstants.red);
		add(templateParameterRectangle);
	}

	public RectangleFigure getTemplateParameterRectangle() {
		return templateParameterRectangle;
	}
}
