/*****************************************************************************
 * Copyright (c) 2011, 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *	 CEA LIST - Initial API and implementation
 *   Christian W. Damus (CEA) - bug 392301
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.statemachine.custom.figures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.graphics.ColorRegistry;
import org.eclipse.gmf.runtime.notation.GradientStyle;
import org.eclipse.papyrus.uml.diagram.common.figure.node.AutomaticCompartmentLayoutManager;
import org.eclipse.papyrus.uml.diagram.common.figure.node.CompartmentFigure;

/**
 * Represents a classifier.
 */
public class StateMachineFigure extends CompartmentFigure {

	int arcwidth = 20;

	/** The StateMachine Compartment */
	private final static String STATEMACHINE_COMPARTMENT = "stateMachineCompartment";

	/** The List of Compartment */
	private final static List<String> COMPARTMENT = new ArrayList<String>() {

		private static final long serialVersionUID = 1L;
		{
			add(STATEMACHINE_COMPARTMENT);
		}
	};

	/**
	 * Default Constructor
	 */
	public StateMachineFigure() {
		this(null);
	}

	/**
	 * Create a new StateMachine figure with the given tag
	 * 
	 * @param tagLabel
	 *        a String that will be displayed at the top of the figure
	 */
	public StateMachineFigure(String tagLabel) {
		super(COMPARTMENT, tagLabel);
		shadowborder = new RoundedShadowBorder(getForegroundColor());
		setBorder(shadowborder);
		((AutomaticCompartmentLayoutManager)getLayoutManager()).setAddExtraHeight(false);
	}

	/**
	 * Get the statemachine compartment figure
	 * 
	 * @return
	 */
	public RectangleFigure getStateMachineCompartmentFigure() {
		return getCompartment(STATEMACHINE_COMPARTMENT);
	}

	@Override
	protected void paintBackground(Graphics graphics, Rectangle rectangle) {
		if(isUsingGradient()) {
			applyTransparency(graphics);
			boolean isVertical = (getGradientStyle() == GradientStyle.VERTICAL) ? true : false;
			if(isVertical && rectangle.height > ((3 * arcwidth) / 2)) {
				Rectangle rect1 = new Rectangle(rectangle.getLocation(), new Dimension(rectangle.width, arcwidth));
				Rectangle rect2 = new Rectangle(rectangle.x, rectangle.y + rectangle.height - arcwidth, rectangle.width, arcwidth);;
				graphics.setBackgroundColor(ColorRegistry.getInstance().getColor(getGradientColor2()));
				graphics.fillRoundRectangle(rect1, arcwidth, arcwidth);
				graphics.setBackgroundColor(ColorRegistry.getInstance().getColor(getGradientColor1()));
				graphics.fillRoundRectangle(rect2, arcwidth, arcwidth);


				graphics.setBackgroundColor(ColorRegistry.getInstance().getColor(getGradientColor1()));
				graphics.setForegroundColor(ColorRegistry.getInstance().getColor(getGradientColor2()));
				Rectangle rect = new Rectangle(rectangle.x, rectangle.y + arcwidth / 2, rectangle.width, rectangle.height - arcwidth);
				graphics.fillGradient(rect, true);
			} else if(!isVertical && rectangle.width > ((3 * arcwidth) / 2)) {
				Rectangle rect1 = new Rectangle(rectangle.getLocation(), new Dimension(arcwidth, rectangle.height));
				Rectangle rect2 = new Rectangle(rectangle.x + rectangle.width - arcwidth, rectangle.y, arcwidth, rectangle.height);
				graphics.setBackgroundColor(ColorRegistry.getInstance().getColor(getGradientColor2()));
				graphics.fillRoundRectangle(rect1, arcwidth, arcwidth);
				graphics.setBackgroundColor(ColorRegistry.getInstance().getColor(getGradientColor1()));
				graphics.fillRoundRectangle(rect2, arcwidth, arcwidth);


				graphics.setBackgroundColor(ColorRegistry.getInstance().getColor(getGradientColor1()));
				graphics.setForegroundColor(ColorRegistry.getInstance().getColor(getGradientColor2()));
				Rectangle rect = new Rectangle(rectangle.x + arcwidth / 2, rectangle.y, rectangle.width - arcwidth, rectangle.height);
				graphics.fillGradient(rect, false);
			} else {
				graphics.setBackgroundColor(ColorRegistry.getInstance().getColor(getGradientColor1()));
				graphics.setForegroundColor(ColorRegistry.getInstance().getColor(getGradientColor2()));
				graphics.fillRoundRectangle(rectangle, arcwidth, arcwidth);
			}
		} else {
			graphics.setBackgroundColor(getBackgroundColor());
			graphics.setForegroundColor(getForegroundColor());
			graphics.fillRoundRectangle(rectangle, arcwidth, arcwidth);
		}
	}

	@Override
	public void paintFigure(Graphics graphics) {
		paintBackground(graphics, getBounds());

		shadowborder.setColor(getForegroundColor());
	}

	@Override
	public void setShadow(boolean shadow) {
		super.setShadow(shadow);
		if(!shadow) {
			RoundedBorder bord = new RoundedBorder(arcwidth, arcwidth);
			this.setBorder(bord);
		}
	}
}
