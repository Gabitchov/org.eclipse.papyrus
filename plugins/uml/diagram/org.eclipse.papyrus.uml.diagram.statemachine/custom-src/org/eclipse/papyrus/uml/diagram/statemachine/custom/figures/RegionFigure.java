/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.statemachine.custom.figures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.papyrus.uml.diagram.common.figure.node.CompartmentFigure;
import org.eclipse.swt.SWT;

public class RegionFigure extends CompartmentFigure {

	/** The Region Compartment */
	private final static String REGION_COMPARTMENT = "regionCompartment";

	/** The List of Compartment */
	private final static List<String> COMPARTMENT = new ArrayList<String>() {

		private static final long serialVersionUID = 1L;
		{
			add(REGION_COMPARTMENT);
		}
	};

	/**
	 * Specific flags to turn on/off dashed border on the BOTTOM side.
	 */
	private boolean displayBottomBorder = false;

	/**
	 * Specific flag to turn on/off dashed border on the RIGHT side.
	 */
	private boolean displayRightBorder = false;

	/**
	 * Default Constructor
	 */
	public RegionFigure() {
		this(null);
	}

	/**
	 * Create a new Region figure with the given tag
	 * 
	 * @param tagLabel
	 *        a String that will be displayed at the top of the figure
	 */
	public RegionFigure(String tagLabel) {
		super(COMPARTMENT, tagLabel);
		nameLabel.setVisible(false);
		setLayoutManager(new NoExtraHeightLayoutManager());
		setBorder(null);
	}

	/**
	 * Get the region compartment figure
	 * 
	 * @return
	 */
	public RectangleFigure getRegionCompartmentFigure() {
		return getCompartment(REGION_COMPARTMENT);
	}

	@Override
	protected void paintBorder(Graphics graphics) {
	}

	@Override
	public void paintFigure(Graphics graphics) {
		// TODO Auto-generated method stub
		super.paintFigure(graphics);
		graphics.setForegroundColor(getForegroundColor());
		Rectangle rect = getBounds();
		// the specific drawing of borders
		if(displayRightBorder) {
			graphics.setLineStyle(SWT.BORDER_DASH);
			graphics.setLineWidth(SWT.BOLD);

			graphics.drawLine(rect.x + rect.width - 1, rect.y - 2, rect.x + rect.width - 1, rect.y - 2 + rect.height);
		}
		if(displayBottomBorder) {
			graphics.setLineStyle(SWT.BORDER_DASH);
			graphics.setLineWidth(SWT.BOLD);

			graphics.drawLine(rect.x - 2, rect.y + rect.height - 1, rect.x - 2 + rect.width, rect.y + rect.height - 1);
		}
	}

	/**
	 * Specific flags to turn on/off of a dashed border on the BOTTOM side.
	 * 
	 * @param b
	 */
	public void setDisplayBottomBorder(boolean b) {
		displayBottomBorder = b;
	}

	/**
	 * Specific flags to turn on/off of a dashed border on the RIGHT side.
	 * 
	 * @param b
	 */
	public void setDisplayRightBorder(boolean b) {
		displayRightBorder = b;
	}

}
