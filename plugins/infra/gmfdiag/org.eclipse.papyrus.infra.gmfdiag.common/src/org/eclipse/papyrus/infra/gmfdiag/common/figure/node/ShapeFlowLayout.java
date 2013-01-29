/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.figure.node;

import java.util.Iterator;

import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * Flow Layout customized for the shapes figure (to be sure they get the maximum size and they are centered.
 */
public class ShapeFlowLayout extends FlowLayout {

	/**
	 * Creates a new ShapeFlowLayout, by default horizontal.
	 */
	public ShapeFlowLayout() {
		super(true);
		setStretchMinorAxis(true);
		setMajorAlignment(ALIGN_CENTER);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void layout(IFigure parent) {
		data = new WorkingData() {
		};
		Rectangle relativeArea = parent.getClientArea();
		data.area = transposer.t(relativeArea);
		Iterator iterator = parent.getChildren().iterator();
		int totalPrefWidth = 0;
		int maxPrefHeight = 0;
		int dx;
		// Calculate the hints to be passed to children
		int wHint = -1;
		int hHint = -1;
		wHint = parent.getClientArea().width;
		hHint = parent.getClientArea().height;
		initVariables(parent);
		initRow();
		// compute max height and sum of width
		while(iterator.hasNext()) {
			IFigure f = (IFigure)iterator.next();
			Dimension pref = transposer.t(getChildSize(f, wHint, hHint));
			totalPrefWidth += pref.width;
			maxPrefHeight = Math.max(maxPrefHeight, pref.height);
		}
		// compute ratio to get the max width (i.e. the multiplier to be sure that figures would take all the width of the compartment
		double ratioWidth = 1;
		if(totalPrefWidth > 0) {
			ratioWidth = wHint / totalPrefWidth;
		}
		// compute the ration so the heighest figure would fit the height of the compartment
		double ratioHeight = 1;
		if(maxPrefHeight > 0) {
			ratioHeight = hHint / maxPrefHeight;
		}
		// get the smallest ratio => multiplier to get all the maximum size of the figure
		double ratio = Math.min(ratioHeight, ratioWidth);
		// reset iterator and run computation
		iterator = parent.getChildren().iterator();
		while(iterator.hasNext()) {
			IFigure f = (IFigure)iterator.next();
			Dimension pref = transposer.t(getChildSize(f, wHint, hHint));
			// scale using the ratio
			Rectangle r = new Rectangle(0, 0, (int)(pref.width * ratio), (int)(pref.height * ratio));
			if(data.rowCount > 0) {
				if(data.rowWidth + pref.width > data.maxWidth)
					layoutRow(parent);
			}
			r.x = data.rowX;
			r.y = data.rowY;
			dx = r.width + getMinorSpacing();
			data.rowX += dx;
			data.rowWidth += dx;
			data.rowHeight = Math.max(data.rowHeight, r.height);
			data.row[data.rowCount] = f;
			data.bounds[data.rowCount] = r;
			data.rowCount++;
		}
		if(data.rowCount != 0)
			layoutRow(parent);
		data = null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void layoutRow(IFigure parent) {
		int majorAdjustment = 0;
		int minorAdjustment = 0;
		int correctMajorAlignment = getMajorAlignment();
		int correctMinorAlignment = getMinorAlignment();
		majorAdjustment = data.area.width - data.rowWidth + getMinorSpacing();
		switch(correctMajorAlignment) {
		case ALIGN_TOPLEFT:
			majorAdjustment = 0;
			break;
		case ALIGN_CENTER:
			majorAdjustment /= 2;
			break;
		case ALIGN_BOTTOMRIGHT:
			break;
		}
		for(int j = 0; j < data.rowCount; j++) {
			if(isStretchMinorAxis()) {
				data.bounds[j].height = data.rowHeight;
			} else {
				minorAdjustment = data.rowHeight - data.bounds[j].height;
				switch(correctMinorAlignment) {
				case ALIGN_TOPLEFT:
					minorAdjustment = 0;
					break;
				case ALIGN_CENTER:
					minorAdjustment /= 2;
					break;
				case ALIGN_BOTTOMRIGHT:
					break;
				}
				data.bounds[j].y += minorAdjustment;
			}
			data.bounds[j].x += majorAdjustment;
			setBoundsOfChild(parent, data.row[j], transposer.t(data.bounds[j]));
		}
		data.rowY += getMajorSpacing() + data.rowHeight;
		initRow();
	}
	//	/**
	//	 * {@inheritDoc}
	//	 */
	//	@Override
	//	public void layout(IFigure parent) {
	//		if(!parent.isVisible())
	//			return;
	//		List children = getChildren(parent);
	//		int numChildren = children.size();
	//		Rectangle clientArea = transposer.t(parent.getClientArea());
	//		int x = clientArea.x;
	//		int y = clientArea.y;
	//		int availableHeight = clientArea.height;
	//
	//		Dimension prefSizes[] = new Dimension[numChildren];
	//		Dimension minSizes[] = new Dimension[numChildren];
	//		Dimension maxSizes[] = new Dimension[numChildren];
	//
	//		// Calculate the width and height hints.  If it's a vertical ToolBarLayout,
	//		// then ignore the height hint (set it to -1); otherwise, ignore the 
	//		// width hint.  These hints will be passed to the children of the parent
	//		// figure when getting their preferred size. 
	//		int wHint = -1;
	//		int hHint = -1;
	//		if(isHorizontal()) {
	//			hHint = parent.getClientArea(Rectangle.SINGLETON).height;
	//		} else {
	//			wHint = parent.getClientArea(Rectangle.SINGLETON).width;
	//		}
	//
	//		/*
	//		 * Calculate sum of preferred heights of all children(totalHeight).
	//		 * Calculate sum of minimum heights of all children(minHeight).
	//		 * Cache Preferred Sizes and Minimum Sizes of all children.
	//		 * 
	//		 * totalHeight is the sum of the preferred heights of all children
	//		 * totalMinHeight is the sum of the minimum heights of all children
	//		 * prefMinSumHeight is the sum of the difference between all children's
	//		 * preferred heights and minimum heights. (This is used as a ratio to
	//		 * calculate how much each child will shrink).
	//		 */
	//		IFigure child;
	//		int totalHeight = 0;
	//		int totalMinHeight = 0;
	//		double totalMaxHeight = 0;
	//		int prefMinSumHeight = 0;
	//		double prefMaxSumHeight = 0;
	//
	//		for(int i = 0; i < numChildren; i++) {
	//			child = (IFigure)children.get(i);
	//
	//			prefSizes[i] = transposer.t(child.getPreferredSize(wHint, hHint));
	//			minSizes[i] = transposer.t(child.getMinimumSize(wHint, hHint));
	//			maxSizes[i] = transposer.t(child.getMaximumSize());
	//
	//			if(getConstraint(child) != null) {
	//				double ratio = ((Double)getConstraint(child)).doubleValue();
	//				int prefHeight = (int)(ratio * availableHeight);
	//				prefHeight = Math.max(prefHeight, minSizes[i].height);
	//				prefHeight = Math.min(prefHeight, maxSizes[i].height);
	//				prefSizes[i].height = prefHeight;
	//			}
	//
	//			totalHeight += prefSizes[i].height;
	//			totalMinHeight += minSizes[i].height;
	//			totalMaxHeight += maxSizes[i].height;
	//		}
	//		totalHeight += (numChildren - 1) * spacing;
	//		totalMinHeight += (numChildren - 1) * spacing;
	//		totalMaxHeight += (numChildren - 1) * spacing;
	//		prefMinSumHeight = totalHeight - totalMinHeight;
	//		prefMaxSumHeight = totalMaxHeight - totalHeight;
	//
	//		/*
	//		 * The total amount that the children must be shrunk is the
	//		 * sum of the preferred Heights of the children minus
	//		 * Max(the available area and the sum of the minimum heights of the children).
	//		 * 
	//		 * amntShrinkHeight is the combined amount that the children must shrink
	//		 * amntShrinkCurrentHeight is the amount each child will shrink respectively
	//		 */
	//		int amntShrinkHeight = totalHeight - Math.max(availableHeight, totalMinHeight);
	//
	//		for(int i = 0; i < numChildren; i++) {
	//			int amntShrinkCurrentHeight = 0;
	//			int prefHeight = prefSizes[i].height;
	//			int minHeight = minSizes[i].height;
	//			int maxHeight = maxSizes[i].height;
	//			int prefWidth = prefSizes[i].width;
	//			int minWidth = minSizes[i].width;
	//			int maxWidth = maxSizes[i].width;
	//			Rectangle newBounds = new Rectangle(x, y, prefWidth, prefHeight);
	//
	//			child = (IFigure)children.get(i);
	//			if(getStretchMajorAxis()) {
	//				if(amntShrinkHeight > 0 && prefMinSumHeight != 0)
	//					amntShrinkCurrentHeight = (int)((long)(prefHeight - minHeight) * amntShrinkHeight / (prefMinSumHeight));
	//				else if(amntShrinkHeight < 0 && totalHeight != 0)
	//					amntShrinkCurrentHeight = (int)(((maxHeight - prefHeight) / prefMaxSumHeight) * amntShrinkHeight);
	//			}
	//
	//			if(newBounds.height - amntShrinkCurrentHeight > maxHeight)
	//				amntShrinkCurrentHeight = newBounds.height - maxHeight;
	//			newBounds.height -= amntShrinkCurrentHeight;
	//			
	//			int width = Math.min(prefWidth, maxWidth);
	//			if(matchWidth)
	//				width = maxWidth;
	//			width = Math.max(minWidth, Math.min(clientArea.width, width));
	//			
	//			// compute the width by taking into account the shrink ratio
	//			if(prefHeight !=0) {
	//				int shrinkWidth = newBounds.height * prefWidth/prefHeight;
	//				width = Math.min(width, shrinkWidth);
	//			}
	//			
	//			newBounds.width = width;
	//
	//			int adjust = clientArea.width - width;
	//			switch(minorAlignment) {
	//			case ALIGN_TOPLEFT:
	//				adjust = 0;
	//				break;
	//			case ALIGN_CENTER:
	//				adjust /= 2;
	//				break;
	//			case ALIGN_BOTTOMRIGHT:
	//				break;
	//			}
	//			newBounds.x += adjust;
	//			child.setBounds(transposer.t(newBounds));
	//
	//			amntShrinkHeight -= amntShrinkCurrentHeight;
	//			prefMinSumHeight -= (prefHeight - minHeight);
	//			prefMaxSumHeight -= (maxHeight - prefHeight);
	//			totalHeight -= prefHeight;
	//			y += newBounds.height + spacing;
	//		}
	//	}
	//	/**
	//	 * Calculates either the preferred or minimum children size
	//	 */
	//	private Dimension calculateChildrenSize(
	//		List children,
	//		int wHint,
	//		int hHint,
	//		boolean preferred) {
	//		Dimension childSize;
	//		IFigure child;
	//		int height = 0, width = 0;
	//		for (int i = 0; i < children.size(); i++) {
	//			child = (IFigure) children.get(i);
	//			childSize =
	//				transposer.t(
	//					preferred
	//						? child.getPreferredSize(wHint, hHint)
	//						: child.getMinimumSize(wHint, hHint));
	//			height += childSize.height;
	//			width = Math.max(width, childSize.width);
	//		}
	//		return new Dimension(width, height);
	//	}
	//	/**
	//	 * Gets the list of children after applying the layout options of
	//	 * ignore invisible children & reverse children
	//	 */
	//	private List getChildren(IFigure container) {
	//		List children = new ArrayList(container.getChildren());
	//		if(getIgnoreInvisibleChildren()) {
	//			Iterator iter = children.iterator();
	//			while(iter.hasNext()) {
	//				IFigure f = (IFigure)iter.next();
	//				if(!f.isVisible())
	//					iter.remove();
	//			}
	//		}
	//		if(isReversed())
	//			Collections.reverse(children);
	//		return children;
	//	}
}
