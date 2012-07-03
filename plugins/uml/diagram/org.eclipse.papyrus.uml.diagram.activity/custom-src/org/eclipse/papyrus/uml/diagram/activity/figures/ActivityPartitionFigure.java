/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *	 Arthur Daussy - 372745: [ActivityDiagram] Major refactoring group framework
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.figures;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.uml.diagram.common.figure.node.CompartmentFigure;

/**
 * Figure an activity partition
 */
public class ActivityPartitionFigure extends CompartmentFigure {

	/**
	 * TODO set those to constants into preference store
	 */
	private static final int TRANSPARENCY = 50;

	private static final int APLPHA = 50;

	private static final String ACTIVITY_CONTENT_COMPARTMENT = "ActivityContentCompartment";

	public ActivityPartitionFigure(List<String> compartmentFigure) {
		super(compartmentFigure);
	}

	public ActivityPartitionFigure() {
		super(Collections.singletonList(ACTIVITY_CONTENT_COMPARTMENT));
		this.setOpaque(false);
		getActivityPartitionCompartment().setOpaque(false);
		getActivityPartitionCompartment().setBorder(new LineBorder());
	}

	@Override
	public void paintFigure(Graphics graphics) {
		setTransparency(TRANSPARENCY);
		graphics.setAlpha(APLPHA);
		super.paintFigure(graphics);
	}

	public RectangleFigure getActivityPartitionCompartment() {
		return getCompartment(ACTIVITY_CONTENT_COMPARTMENT);
	}

	public WrappingLabel getPartitionLabel() {
		return getNameLabel();
	}
}
