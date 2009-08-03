/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Sergey Gribovsky (Borland) - initial API and implementation
 */
package org.eclipse.papyrus.diagram.common.draw2d;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;

public class BorderItemNameLocator extends BorderItemLocator {

	public BorderItemNameLocator(IFigure parentFigure) {
		super(parentFigure);
	}

	public BorderItemNameLocator(IFigure parentFigure, int preferredSide) {
		super(parentFigure, preferredSide);
	}

	@Override
	public Rectangle getConstraint() {
		return super.getConstraint();
	}
}
