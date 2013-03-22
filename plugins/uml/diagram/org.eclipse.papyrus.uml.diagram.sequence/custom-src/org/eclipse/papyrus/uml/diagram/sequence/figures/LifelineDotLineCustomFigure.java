/*****************************************************************************
 * Copyright (c) 2009 CEA
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
package org.eclipse.papyrus.uml.diagram.sequence.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.papyrus.uml.diagram.common.draw2d.LifelineDotLineFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.NodeNamedElementFigure;

/**
 * The figure of the LifelineDotLine
 */
public class LifelineDotLineCustomFigure extends LifelineDotLineFigure {

	/**
	 * Layout manager for the inline mode
	 */
	private LayoutManager inlineModeManager;

	/**
	 * Layout manager for the inline mode
	 */
	private LayoutManager normalModeManager;

	/**
	 * True if the lifeline is in inline mode
	 */
	private boolean inlineMode;

	/**
	 * Number of inner ConnectableElements
	 */
	private int innerConnectableElementsNumber;

	/**
	 * Default constructor
	 */
	public LifelineDotLineCustomFigure() {
		super();
		normalModeManager = new XYLayout();

		/*
		 * inlineModeManager = new FlowLayout(true) {
		 * 
		 * {
		 * majorSpacing = 10;
		 * minorSpacing = 10;
		 * fill = true;
		 * }
		 * 
		 * @Override
		 * protected Dimension getChildSize(IFigure child, int wHint, int hHint) {
		 * wHint = getParent().getBounds().width;
		 * hHint = getParent().getBounds().height;
		 * if(innerConnectableElementsNumber > 0) {
		 * wHint /= innerConnectableElementsNumber;
		 * }
		 * if(!child.getParent().getChildren().get(innerConnectableElementsNumber - 1).equals(child)) {
		 * wHint = wHint - majorSpacing;
		 * }
		 * 
		 * ((Figure)child).setPreferredSize(wHint, hHint);
		 * Dimension childSize = super.getChildSize(child, wHint, hHint);
		 * return childSize;
		 * }
		 * 
		 * @Override
		 * protected Dimension calculatePreferredSize(IFigure container, int wHint, int hHint) {
		 * Dimension calculatePreferredSize = super.calculatePreferredSize(container, wHint, hHint);
		 * calculatePreferredSize.width = wHint;
		 * calculatePreferredSize.height = hHint;
		 * return calculatePreferredSize;
		 * }
		 * };
		 */
		inlineModeManager = new XYLayout();
		setLayoutManager(normalModeManager);
	}

	/**
	 * Configure the lifeline figure
	 * 
	 * @param inlineMode
	 *        true if inline mode enabled
	 * @param innerConnectableElementsNumber
	 *        Number of children
	 */
	public void configure(boolean inlineMode, int innerConnectableElementsNumber) {
		if(inlineMode) {
			this.innerConnectableElementsNumber = innerConnectableElementsNumber;
		}
		if(this.inlineMode != inlineMode) {
			this.inlineMode = inlineMode;
			if(inlineMode) {
				setLayoutManager(inlineModeManager);
			} else {
				setLayoutManager(normalModeManager);
			}
		}
	}

	/**
	 * Print lifeline if the edit part is not in inline mode
	 */
	@Override
	protected void outlineShape(Graphics graphics) {
		if(!inlineMode) {
			paintDashLineBackground(graphics);
			super.outlineShape(graphics);
		}
	}

	protected void paintDashLineBackground(Graphics graphics) {
		NodeFigure dashLineRectangle = getDashLineRectangle();
		if(!dashLineRectangle.isOpaque()) {
			return;
		}

		Rectangle r = getBounds().getCopy();
		r.x = r.x + r.width / 2;
		r.width = 1;
		Rectangle lineBounds = r.expand(4, 0);

		graphics.pushState();
		try {
			graphics.setBackgroundColor(dashLineRectangle.getBackgroundColor());
			graphics.setForegroundColor(dashLineRectangle.getForegroundColor());
			graphics.fillRectangle(lineBounds);
		} finally {
			graphics.popState();
		}
	}

	@Override
	public boolean containsPoint(int x, int y) {
		if(!super.containsPoint(x, y)) {
			return false;
		}
		NodeFigure dashLineRectangle = getDashLineRectangle();
		if(dashLineRectangle.containsPoint(x, y)) {
			return true;
		}
		return false;
	}

	// fix bug https://bugs.eclipse.org/bugs/show_bug.cgi?id=384616
	public static class DefaultSizeNodeFigureEx extends DefaultSizeNodeFigure {

		public DefaultSizeNodeFigureEx(int width, int height) {
			super(width, height);
		}

		@Override
		public IFigure findMouseEventTargetAt(int x, int y) {
			// check children first instead of self
			IFigure f = findMouseEventTargetInDescendantsAt(x, y);
			if(f != null) {
				return f;
			}
			if(!containsPoint(x, y)) {
				return null;
			}
			if(isMouseEventTarget()) {
				return this;
			}
			return null;
		}

		@Override
		public IFigure findFigureAt(int x, int y, TreeSearch search) {
			if(search.prune(this)) {
				return null;
			}
			IFigure child = findDescendantAtExcluding(x, y, search);
			if(child != null) {
				return child;
			}
			if(!containsPoint(x, y)) {
				return null;
			}
			if(search.accept(this)) {
				return this;
			}
			return null;
		}
	}

	public static class NodeNamedElementFigureEx extends NodeNamedElementFigure {

		@Override
		public IFigure findMouseEventTargetAt(int x, int y) {
			// check children first instead of self
			IFigure f = findMouseEventTargetInDescendantsAt(x, y);
			if(f != null) {
				return f;
			}
			if(!containsPoint(x, y)) {
				return null;
			}
			if(isMouseEventTarget()) {
				return this;
			}
			return null;
		}

		@Override
		public IFigure findFigureAt(int x, int y, TreeSearch search) {
			if(search.prune(this)) {
				return null;
			}
			IFigure child = findDescendantAtExcluding(x, y, search);
			if(child != null) {
				return child;
			}
			if(!containsPoint(x, y)) {
				return null;
			}
			if(search.accept(this)) {
				return this;
			}
			return null;
		}
	}
}
