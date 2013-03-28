/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.figures;

import org.eclipse.draw2d.PolylineShape;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;


/**
 * figure of a pin
 */
public class PinFigure extends RectangleFigure {

	private PolylineShape fOptionalArrowFigure;

	public PinFigure() {
		this.setPreferredSize(new Dimension(16, 16));
		createContents();
	}

	private void createContents() {
		fOptionalArrowFigure = new PolylineShape();
		this.add(fOptionalArrowFigure);
	}

	public PolylineShape getOptionalArrowFigure() {
		return fOptionalArrowFigure;
	}
}
