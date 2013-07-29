/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.draw2d;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.AbstractHintLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * All children are placed on top of each other. Gap may be set between
 * children.
 * 
 * @author dstadnik
 */
public class PileLayout extends AbstractHintLayout {

	/**
	 * Vertical gap between figures.
	 */
	public final int getGap() {
		return myGap;
	}

	public void setGap(int gap) {
		myGap = gap > 0 ? gap : 0;
	}

	public void setNegativeGap(int gap) {
		myGap = gap;
	}

	/**
	 * The last (bottom) figure should be stretched to cover the rest of the
	 * container client area.
	 */
	public final boolean isStretchBottom() {
		return myStretchBottom;
	}

	public void setStretchBottom(boolean stretchBottom) {
		myStretchBottom = stretchBottom;
	}

	public void remove(IFigure figure) {
		myConstraints.remove(figure);
	}

	public void setConstraint(IFigure figure, Object constraint) {
		if(constraint == null) {
			remove(figure);
		} else {
			myConstraints.put(figure, constraint);
		}
	}

	public Object getConstraint(IFigure figure) {
		return myConstraints.get(figure);
	}

	/**
	 * Returns list constraint for specified figure. If constraint is null or
	 * not list constraint returns FILL list constraint by default.
	 */
	protected PileConstraint getPileConstraint(IFigure figure) {
		Object constraint = getConstraint(figure);
		return constraint instanceof PileConstraint ? (PileConstraint)constraint : FILL;
	}

	protected Dimension calculateSize(IFigure container, int wHint, int hHint, SizeExtractor sizeExtractor) {
		int totalWidth = 0; // Width of all components
		int totalHeight = 0; // Height of all components

		List<?> children = container.getChildren();
		for(int i = 0; i < children.size(); i++) {
			IFigure child = (IFigure)children.get(i);
			Dimension size = sizeExtractor.getSize(child, wHint, hHint);
			if(totalWidth < size.width) {
				totalWidth = size.width;
			}
			totalHeight += size.height + getGap();
		}
		// Subtract extra gap
		totalHeight -= getGap();

		// Add insets to preferred size (include border)
		Insets insets = container.getInsets();
		totalWidth += insets.getWidth();
		totalHeight += insets.getHeight();

		return new Dimension(totalWidth, totalHeight);
	}

	protected Dimension calculateMinimumSize(IFigure container, int wHint, int hHint) {
		return calculateSize(container, wHint, hHint, MIN_SIZE_EXTRACTOR);
	}

	protected Dimension calculatePreferredSize(IFigure container, int wHint, int hHint) {
		return calculateSize(container, wHint, hHint, PREF_SIZE_EXTRACTOR);
	}

	public void layout(IFigure container) {
		Rectangle clientArea = container.getClientArea();
		int y = clientArea.y;
		final int maxY = clientArea.y + clientArea.height;
		List<?> children = container.getChildren();
		for(int i = 0; i < children.size(); i++) {
			IFigure child = (IFigure)children.get(i);
			Dimension preferred = child.getPreferredSize(clientArea.width, clientArea.height);
			int height = preferred.height;
			if(y >= maxY) {
				Rectangle bounds = new Rectangle(clientArea.x, maxY, clientArea.width, 0);
				child.setBounds(bounds);
				continue;
			} else if(y + height > maxY || (isStretchBottom() && i == children.size() - 1)) {
				height = maxY - y;
			}
			Rectangle bounds = new Rectangle(clientArea.x, y, clientArea.width, height);
			getPileConstraint(child).setChildBounds(preferred, bounds);
			child.setBounds(bounds);
			y += bounds.height + getGap();
		}
	}

	private int myGap;

	private Map<IFigure, Object> myConstraints = new HashMap<IFigure, Object>(2);

	private boolean myStretchBottom;

	private static final SizeExtractor MIN_SIZE_EXTRACTOR = new SizeExtractor() {

		public Dimension getSize(IFigure figure, int wHint, int hHint) {
			return figure.getMinimumSize(wHint, hHint);
		}
	};

	private static final SizeExtractor PREF_SIZE_EXTRACTOR = new SizeExtractor() {

		public Dimension getSize(IFigure figure, int wHint, int hHint) {
			return figure.getPreferredSize(wHint, hHint);
		}
	};

	private interface SizeExtractor {

		public Dimension getSize(IFigure figure, int wHint, int hHint);
	}

	/**
	 * Constraint that is recognizable by this layout.
	 */
	public interface PileConstraint {

		/**
		 * Changes bounds of child with specified preferred size. New bounds
		 * should fit in specified bounds.
		 * 
		 * @param preferred
		 *        Prefferred size of a child.
		 * @param bounds
		 *        Max child bounds.
		 */
		public void setChildBounds(Dimension preferred, Rectangle bounds);
	}

	/**
	 * Default constraint.
	 */
	public static final PileConstraint FILL = new PileConstraint() {

		public void setChildBounds(Dimension preferred, Rectangle bounds) {
		}
	};

	public static final PileConstraint ALIGN_LEFT = new PileConstraint() {

		public void setChildBounds(Dimension preferred, Rectangle bounds) {
			bounds.width = Math.min(preferred.width, bounds.width);
		}
	};

	public static final PileConstraint ALIGN_CENTER = new PileConstraint() {

		public void setChildBounds(Dimension preferred, Rectangle bounds) {
			if(bounds.width > preferred.width) {
				final int offset = (bounds.width - preferred.width) / 2;
				bounds.x += offset;
				bounds.width = preferred.width;
			}
		}
	};

	public static final PileConstraint ALIGN_RIGHT = new PileConstraint() {

		public void setChildBounds(Dimension preferred, Rectangle bounds) {
			if(bounds.width > preferred.width) {
				bounds.x += bounds.width - preferred.width;
				bounds.width = preferred.width;
			}
		}
	};
}
