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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.papyrus.uml.diagram.common.figure.node.AutomaticCompartmentLayoutManager;


/**
 * Variant of automatic compartment layout manager.
 * Main difference:
 * - additional offset for first visible compartment only if a label
 * - check for visibility flag
 * - addExtraHeight false by default
 * 
 */
public class NoExtraHeightLayoutManager extends AutomaticCompartmentLayoutManager {

	NoExtraHeightLayoutManager() {
		addExtraHeight = false;
	}

	/**
	 * Optimize the size of each compartment depending on the size of the
	 * compartments container, and the size of each compartment. If a
	 * compartment is empty, or not expanded, then a default size is applied to
	 * this compartment
	 * 
	 * @param container
	 *        The containing figure
	 * @param vOfset
	 *        an eventual vertical offset for the first non-compartment.
	 */
	protected void optimizeCompartmentSize(IFigure container, int vOffset) {
		int compartmentsHeight = 0;
		int notCompartmentsHeight = vOffset;
		for(int i = 0; i < visibleOthers.size(); i++) {
			notCompartmentsHeight += visibleOthers.get(i).getBounds().height;
		}

		for(int i = 0; i < visibleCompartments.size(); i++) {
			compartmentsHeight += visibleCompartments.get(i).getBounds().height;
		}
		int remainingspace = container.getBounds().height - notCompartmentsHeight;

		// ratio between the height of all compartments and the size of the
		// compartments container.
		double ratio = new Integer(compartmentsHeight).doubleValue() / new Integer(remainingspace).doubleValue();

		for(int i = 0; i < visibleCompartments.size(); i++) {
			Rectangle bound = new Rectangle((visibleCompartments.get(i)).getBounds());
			int value = (int)(bound.height / ratio);
			bound.height = value;
			bound.x = container.getBounds().x;
			if(i > 0) {
				bound.y = (visibleCompartments.get(i - 1)).getBounds().getBottomLeft().y;
			}
			(visibleCompartments.get(i)).setBounds(bound);
		}
	}

	@Override
	public void layout(IFigure container) {

		collectInformation(container);
		if(visibleCompartments.size() != 0) {
			// visit all compartments
			IFigure previousCompartment = null;
			int vOffset = 0;
			for(int i = 0; i < container.getChildren().size(); i++) {
				IFigure currentCompartment = (IFigure)container.getChildren().get(i);
				// is this a visible compartment?
				if(currentCompartment.isVisible()) {

					Rectangle bounds = new Rectangle(currentCompartment.getBounds());
					currentCompartment.invalidate();
					Dimension pref = currentCompartment.getPreferredSize();
					currentCompartment.invalidate();
					Dimension prefConstraint = currentCompartment.getPreferredSize(container.getBounds().width - 40, -1);
					if(pref.width < prefConstraint.width) {
						bounds.setSize(pref);
					} else {
						bounds.setSize(prefConstraint);
					}
					// bound.setSize(getPreferedSize(currentCompartment));
					if(previousCompartment != null) {
						// next visible compartment
						bounds.x = container.getBounds().x + 3;
						bounds.y = previousCompartment.getBounds().getBottomLeft().y + 1;
						bounds.width = container.getBounds().width;
					} else {
						bounds.x = container.getBounds().x + 3;
						bounds.y = container.getBounds().y;
						// difference to superclass: first visible compartment does not start with a vertical offset of 3 pixels, unless
						// a "not"-compartment, i.e. a label
						if(visibleOthers.contains(currentCompartment)) {
							vOffset = 3; // is taken into account by optimizeCompartmentSize;
							bounds.y += vOffset;
						}
						bounds.width = container.getBounds().width;
					}
					currentCompartment.setBounds(bounds);
					previousCompartment = currentCompartment;
				} else {
					// this is a non-visible compartment
					Rectangle bounds = new Rectangle(currentCompartment.getBounds());
					bounds.setSize(0, 0);
					currentCompartment.setBounds(bounds);
				}
			}
			optimizeCompartmentSize(container, vOffset);
		} else {
			layoutOthers(container.getBounds());
		}
	}
}
