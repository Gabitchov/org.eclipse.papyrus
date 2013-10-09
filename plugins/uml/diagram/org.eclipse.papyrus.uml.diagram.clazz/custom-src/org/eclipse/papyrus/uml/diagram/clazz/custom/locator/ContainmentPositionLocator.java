/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.locator;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;

/**
 * This class is used to constrain the position of Containment circle when they are added on a class element
 */
public class ContainmentPositionLocator extends BorderItemLocator {

	/** Constructor **/
	public ContainmentPositionLocator(IFigure parentFigure) {
		super(parentFigure);
	}

	/** Constructor **/
	public ContainmentPositionLocator(IFigure borderItem, IFigure parentFigure, Rectangle constraint) {
		super(borderItem, parentFigure, constraint);
	}

	/** Constructor **/
	public ContainmentPositionLocator(IFigure parentFigure, int preferredSide) {
		super(parentFigure, preferredSide);
	}
}
