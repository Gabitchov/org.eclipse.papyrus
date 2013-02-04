/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.locator;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.papyrus.uml.diagram.common.locator.ExternalLabelPositionLocator;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.FigureUtils;

/**
 * Lets the user move a Label anywhere inside its containing compartment, but don't let the label stick out of the
 * compartment.
 */
public class LabelInCompartmentLocator extends ExternalLabelPositionLocator {

	public LabelInCompartmentLocator(final IFigure parentFigure) {
		super(parentFigure);
	}

	@Override
	public Rectangle getValidLocation(final Rectangle proposedLocation, final IFigure borderItem) {
		return FigureUtils.constrainBoundsWithinContainingCompartment(proposedLocation, borderItem);
	}
}
