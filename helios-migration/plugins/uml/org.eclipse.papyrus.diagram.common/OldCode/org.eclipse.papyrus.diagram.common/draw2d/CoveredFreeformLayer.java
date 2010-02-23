/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Sergey Gribovsky (Borland) - initial API and implementation
 */
package org.eclipse.papyrus.diagram.common.draw2d;

import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.FreeformFigure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Translatable;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemsAwareFreeFormLayer;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;

/**
 * Freeform layer that expands children to cover client area of the figure at whole.
 */
public class CoveredFreeformLayer extends BorderItemsAwareFreeFormLayer {

	@Override
	public Rectangle getFreeformExtent() {
		if (myFreeformExtent != null) {
			return myFreeformExtent;
		}

		List children = getChildren();
		for (int i = 0; i < children.size(); i++) {
			IFigure child = (IFigure) children.get(i);
			Rectangle childBounds;
			if (child instanceof FreeformFigure) {
				childBounds = ((FreeformFigure) child).getFreeformExtent();
			} else {
				Dimension size = child.getPreferredSize().getCopy();
				size.width += getMarginInsets().getWidth();
				size.height += getMarginInsets().getHeight();
				childBounds = new Rectangle(0, 0, size.width, size.height);
			}
			if (myFreeformExtent == null) {
				myFreeformExtent = childBounds.getCopy();
			} else {
				myFreeformExtent.union(childBounds);
			}
		}
		Insets insets = getInsets();
		if (myFreeformExtent == null) {
			myFreeformExtent = new Rectangle(0, 0, insets.getWidth(), insets.getHeight());
		} else {
			translateToParent(myFreeformExtent);
			myFreeformExtent.expand(insets);
		}
		return myFreeformExtent;
	}

	@Override
	public void setFreeformBounds(Rectangle bounds) {
		setBounds(bounds);
		bounds = bounds.getCopy();
		translateFromParent(bounds);
		List children = getChildren();
		for (int i = 0; i < children.size(); i++) {
			IFigure child = (IFigure) children.get(i);
			if (child instanceof FreeformFigure) {
				((FreeformFigure) child).setFreeformBounds(bounds);
			} else {
				Insets insets = getMarginInsets();
				int x = insets.left;
				int y = insets.top;

				Dimension size = bounds.getSize().getCopy().shrink(insets.getWidth(), insets.getHeight());

				final Rectangle childBounds = new Rectangle(x, y, size.width, size.height);
				if (child instanceof BorderedNodeFigure) {
					validateSideAffixedElements((BorderedNodeFigure) child, childBounds);
				}
				child.setBounds(childBounds);
			}
		}
	}

	@Override
	public void invalidate() {
		super.invalidate();
		myFreeformExtent = null;
	}

	public final Insets getMarginInsets() {
		TranslatableInsets insets = new TranslatableInsets(myMarginInsets);
		translateToRelative(insets);
		return insets;
	}

	public void setMarginInsets(Insets insets) {
		myMarginInsets = insets;
	}

	private void validateSideAffixedElements(BorderedNodeFigure parent, Rectangle area) {
		List borderItems = parent.getBorderItemContainer().getChildren();
		for (Iterator borderItemsIterator = borderItems.iterator(); borderItemsIterator.hasNext();) {
			IFigure borderItem = (IFigure) borderItemsIterator.next();
			if (borderItem instanceof BorderedNodeFigure) {
				validateSideAffixedElements((BorderedNodeFigure) borderItem, area);
			} else if (borderItem instanceof WrapLabel) {
				Rectangle labelBounds = borderItem.getBounds();
				if (!area.contains(labelBounds)) {
					Rectangle union = area.getCopy().union(labelBounds);
					int xShift = union.width - area.width;
					int x = area.x == union.x ? -xShift : xShift;
					int yShift = union.height - area.height;
					int y = area.y == union.y ? -yShift : yShift;
					((BorderItemNameLocator) parent.getBorderItemContainer().getLayoutManager().getConstraint(
							borderItem)).getConstraint().translate(x, y);
				}
			}
		}
	}

	private Rectangle myFreeformExtent;

	private Insets myMarginInsets;

	private double myMarginRatio = 0.1;

	private static class TranslatableInsets extends Insets implements Translatable {

		public TranslatableInsets(Insets insets) {
			super(insets);
		}

		public void performScale(double factor) {
			top = (int) (Math.floor(top * factor));
			bottom = (int) (Math.floor(bottom * factor));
			left = (int) (Math.floor(left * factor));
			right = (int) (Math.floor(right * factor));
		}

		public void performTranslate(int dx, int dy) {
			// do nothing
		}
	}
}
