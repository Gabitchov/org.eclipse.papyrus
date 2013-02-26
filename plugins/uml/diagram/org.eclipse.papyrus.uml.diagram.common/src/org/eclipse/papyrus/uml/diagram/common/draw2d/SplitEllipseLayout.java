/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.draw2d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.GravityConstrainedFlowLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.GravityDirectionType;

public class SplitEllipseLayout extends GravityConstrainedFlowLayout {

	private int myXMargin;

	private int myYMargin;

	/**
	 * Constructor. Calls super and configures this layout.
	 */
	public SplitEllipseLayout() {
		super();
		setGravity(GravityDirectionType.NORTH);
		setIgnoreInvisibleChildren(true);
		setStretchMajorAxis(false);
		setStretchMinorAxis(false);
		setObserveVisibility(true);
	}

	/**
	 * @see org.eclipse.draw2d.LayoutManager#layout(IFigure)
	 */
	@Override
	public void layout(IFigure container) {
		Rectangle r = container.getBounds();
		double a = r.width / 2;
		double b = r.height / 2;
		double sin45 = Math.sqrt(2) / 2;
		double cos45 = sin45;
		double diagx = a * sin45;
		double diagy = b * cos45;
		int newxmargin = (int)(a - diagx);
		int newymargin = (int)(b - diagy);
		if(newxmargin != myXMargin || newymargin != myYMargin) {
			myXMargin = newxmargin;
			myYMargin = newymargin;
			container.setBorder(new MarginBorder(myYMargin, myXMargin, myYMargin, myXMargin));
		}
		IFigure parent = container;
		// code from super, except for one line
		if(!parent.isVisible()) {
			return;
		}
		List<?> children = getChildren(parent);
		int numChildren = children.size();
		Rectangle clientArea = transposer.t(parent.getClientArea());
		int x = clientArea.x;
		int y = clientArea.y;
		int availableHeight = clientArea.height;

		Dimension prefSizes[] = new Dimension[numChildren];
		Dimension minSizes[] = new Dimension[numChildren];
		Dimension maxSizes[] = new Dimension[numChildren];

		// Calculate the width and height hints. If it's a vertical
		// ToolBarLayout,
		// then ignore the height hint (set it to -1); otherwise, ignore the
		// width hint. These hints will be passed to the children of the parent
		// figure when getting their preferred size.
		int wHint = -1;
		int hHint = -1;
		if(isHorizontal()) {
			hHint = parent.getClientArea(Rectangle.SINGLETON).height;
		} else {
			wHint = parent.getClientArea(Rectangle.SINGLETON).width;
		}

		/*
		 * Calculate sum of preferred heights of all children(totalHeight).
		 * Calculate sum of minimum heights of all children(minHeight). Cache
		 * Preferred Sizes and Minimum Sizes of all children.
		 * 
		 * totalHeight is the sum of the preferred heights of all children
		 * totalMinHeight is the sum of the minimum heights of all children
		 * prefMinSumHeight is the sum of the difference between all children's
		 * preferred heights and minimum heights. (This is used as a ratio to
		 * calculate how much each child will shrink).
		 */
		IFigure child;
		int totalHeight = 0;
		int totalMinHeight = 0;
		double totalMaxHeight = 0;
		int prefMinSumHeight = 0;
		double prefMaxSumHeight = 0;

		for(int i = 0; i < numChildren; i++) {
			child = (IFigure)children.get(i);

			prefSizes[i] = transposer.t(child.getPreferredSize(wHint, hHint));
			minSizes[i] = transposer.t(child.getMinimumSize(wHint, hHint));
			maxSizes[i] = transposer.t(child.getMaximumSize());

			if(getConstraint(child) != null) {
				double ratio = ((Double)getConstraint(child)).doubleValue();
				int prefHeight = (int)(ratio * availableHeight);
				prefHeight = Math.max(prefHeight, minSizes[i].height);
				prefHeight = Math.min(prefHeight, maxSizes[i].height);
				prefSizes[i].height = prefHeight;
			}

			totalHeight += prefSizes[i].height;
			totalMinHeight += minSizes[i].height;
			totalMaxHeight += maxSizes[i].height;
		}
		totalHeight += (numChildren - 1) * spacing;
		totalMinHeight += (numChildren - 1) * spacing;
		totalMaxHeight += (numChildren - 1) * spacing;
		prefMinSumHeight = totalHeight - totalMinHeight;
		prefMaxSumHeight = totalMaxHeight - totalHeight;

		/*
		 * The total amount that the children must be shrunk is the sum of the
		 * preferred Heights of the children minus Max(the available area and
		 * the sum of the minimum heights of the children).
		 * 
		 * amntShrinkHeight is the combined amount that the children must shrink
		 * amntShrinkCurrentHeight is the amount each child will shrink
		 * respectively
		 */
		int amntShrinkHeight = totalHeight - Math.max(availableHeight, totalMinHeight);

		for(int i = 0; i < numChildren; i++) {
			int amntShrinkCurrentHeight = 0;
			int prefHeight = prefSizes[i].height;
			int minHeight = minSizes[i].height;
			int maxHeight = maxSizes[i].height;
			int prefWidth = prefSizes[i].width;
			int minWidth = minSizes[i].width;
			int maxWidth = maxSizes[i].width;
			Rectangle newBounds = new Rectangle(x, y, prefWidth, prefHeight);

			child = (IFigure)children.get(i);
			// only difference with super : stretch the last item, whatever the
			// policy.
			// this enables to draw scrollbars for the last compartment.
			if(getStretchMajorAxis() || i == numChildren - 1) {
				if(amntShrinkHeight > 0 && prefMinSumHeight != 0) {
					amntShrinkCurrentHeight = (int)((long)(prefHeight - minHeight) * amntShrinkHeight / (prefMinSumHeight));
				} else if(amntShrinkHeight < 0 && totalHeight != 0) {
					amntShrinkCurrentHeight = (int)(((maxHeight - prefHeight) / prefMaxSumHeight) * amntShrinkHeight);
				}
			}

			int width = Math.min(prefWidth, maxWidth);
			if(matchWidth) {
				width = maxWidth;
			}
			width = Math.max(minWidth, Math.min(clientArea.width, width));
			newBounds.width = width;

			int adjust = clientArea.width - width;
			switch(minorAlignment) {
			case ALIGN_TOPLEFT:
				adjust = 0;
				break;
			case ALIGN_CENTER:
				adjust /= 2;
				break;
			case ALIGN_BOTTOMRIGHT:
				break;
			}
			newBounds.x += adjust;
			if(newBounds.height - amntShrinkCurrentHeight > maxHeight) {
				amntShrinkCurrentHeight = newBounds.height - maxHeight;
			}
			newBounds.height -= amntShrinkCurrentHeight;
			child.setBounds(transposer.t(newBounds));

			amntShrinkHeight -= amntShrinkCurrentHeight;
			prefMinSumHeight -= (prefHeight - minHeight);
			prefMaxSumHeight -= (maxHeight - prefHeight);
			totalHeight -= prefHeight;
			y += newBounds.height + spacing;
		}
		if(minorAlignment == ALIGN_CENTER) {
			alignVerticalCenter(totalMinHeight, totalHeight, container);
		}

	}

	private void alignVerticalCenter(int minHeight, int totalHeight, IFigure container) {
		//calculus of space for y
		int containerHeight = container.getBounds().height;
		int heightContent = 0;
		Iterator iter = container.getChildren().iterator();
		while(iter.hasNext()) {
			IFigure f = (IFigure)iter.next();
			Dimension dim = f.getPreferredSize();
			heightContent = heightContent + dim.height;
		}


		int spaceY = (containerHeight - heightContent) / 3;
		if(spaceY > 0) {
			iter = container.getChildren().iterator();
			while(iter.hasNext()) {
				IFigure f = (IFigure)iter.next();
				f.invalidate();
				Dimension dim = f.getPreferredSize();
				Rectangle rec = f.getBounds();
				rec.y = rec.y + spaceY;
				rec.height = dim.height;
				f.setBounds(rec);

				//System.err.println(f);
			}
		}

	}


	/**
	 * Gets the list of children after applying the layout options of ignore
	 * invisible children & reverse children
	 */
	private List getChildren(IFigure container) {
		List children = new ArrayList(container.getChildren());
		if(getIgnoreInvisibleChildren()) {
			Iterator iter = children.iterator();
			while(iter.hasNext()) {
				IFigure f = (IFigure)iter.next();
				if(!f.isVisible()) {
					iter.remove();
				}
			}
		}
		if(isReversed()) {
			Collections.reverse(children);
		}
		return children;
	}

}
