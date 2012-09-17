/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.draw2d;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * This implementation is based on {@link CenterLayout}, except it avoids
 * superposing figures. Elements are centered and placed in a row. Available
 * extra place is dispatched between figures with fill constraint.
 * 
 * @see CenteredColumnConstraint
 */
public class CenteredColumnLayout extends StackLayout {

	private static final Rectangle RECTANGLE = new Rectangle();

	/** Extra margin (for avoiding cut) */
	private static final int MARGIN = 5;

	private Map<IFigure, CenteredColumnConstraint> constraints = new HashMap<IFigure, CenteredColumnConstraint>();

	@Override
	public void layout(IFigure figure) {
		Rectangle rect = figure.getClientArea();
		final int centerX = rect.x + rect.width / 2;
		int yAxe = rect.y;
		int availableExtraHeight = rect.height;
		int numberOfFillChildren = 0;
		List<IFigure> orderedFigures = new LinkedList<IFigure>();
		List<?> children = figure.getChildren();
		IFigure child;
		for(int i = 0; i < children.size(); i++) {
			child = (IFigure)children.get(i);
			Dimension prefSize = child.getPreferredSize(-1, -1);
			availableExtraHeight -= prefSize.height + MARGIN;
			if(constraints.get(child) != null && constraints.get(child).isAvailableSpaceFilled()) {
				numberOfFillChildren++;
			}
			if(!constraints.containsKey(child)) {
				constraints.put(child, null);
			}
			orderedFigures.add(i, child);
		}
		int fillExtraHeight = 0;
		if(numberOfFillChildren > 0) {
			fillExtraHeight = availableExtraHeight / numberOfFillChildren;
		}
		for(IFigure childF : orderedFigures) {
			boolean fill = constraints.get(childF).isAvailableSpaceFilled();
			Dimension prefSize = childF.getPreferredSize(-1, -1);
			RECTANGLE.x = centerX - prefSize.width / 2;
			RECTANGLE.y = yAxe;
			RECTANGLE.width = prefSize.width;
			if(!fill) {
				RECTANGLE.height = prefSize.height + MARGIN;
			} else {
				RECTANGLE.height = prefSize.height + MARGIN + fillExtraHeight;
			}
			// Workaround for 209648
			childF.setBounds(RECTANGLE);
			yAxe += RECTANGLE.height;
		}
	}

	@Override
	public void setConstraint(IFigure child, Object constraint) {
		if(constraint instanceof CenteredColumnConstraint) {
			constraints.put(child, (CenteredColumnConstraint)constraint);
		}
		super.setConstraint(child, constraint);
	}

	@Override
	public Object getConstraint(IFigure child) {
		return constraints.get(child);
	}

	@Override
	protected Dimension calculateMinimumSize(IFigure figure, int wHint, int hHint) {
		if(wHint > -1)
			wHint = Math.max(0, wHint - figure.getInsets().getWidth());
		if(hHint > -1)
			hHint = Math.max(0, hHint - figure.getInsets().getHeight());
		Dimension d = new Dimension();
		List children = figure.getChildren();
		IFigure child;
		for(int i = 0; i < children.size(); i++) {
			child = (IFigure)children.get(i);
			if(!isObservingVisibility() || child.isVisible()) {
				Dimension childSize = child.getMinimumSize(wHint, hHint);
				d.height += childSize.height;
				d.width = Math.max(d.width, childSize.width);
			}
		}
		d.expand(figure.getInsets().getWidth(), figure.getInsets().getHeight());
		d.union(getBorderPreferredSize(figure));
		return d;
	}
}
