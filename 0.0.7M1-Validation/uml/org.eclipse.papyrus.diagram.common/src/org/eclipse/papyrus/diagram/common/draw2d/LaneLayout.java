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

import java.util.HashMap;
import java.util.List;

import org.eclipse.draw2d.AbstractHintLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Transposer;

public class LaneLayout extends AbstractHintLayout {

	public static int HORIZONTAL = 0;

	public static int VERTICAL = 1;

	private static final Insets NO_INSETS = new Insets(0, 0, 0, 0);

	private int myLaneOrientation;

	private Insets myInsets;

	// Transposer object used in layout calculations
	private Transposer myTransposer;

	private HashMap<IFigure, Object> myConstraints;

	public LaneLayout() {
		this(HORIZONTAL, NO_INSETS);
	}

	public LaneLayout(Insets insets) {
		this(HORIZONTAL, insets);
	}

	public LaneLayout(int laneOrientation, Insets insets) {
		myConstraints = new HashMap<IFigure, Object>();
		myTransposer = new Transposer();
		setLaneOrientation(laneOrientation);
		setInsets(insets);
	}

	public void setLaneOrientation(int orientation) {
		if (orientation != HORIZONTAL && orientation != VERTICAL) {
			throw new IllegalArgumentException("Incorrect lane orientation constant: " + orientation); //$NON-NLS-1$
		}
		myTransposer.setEnabled(orientation == VERTICAL);
		myLaneOrientation = orientation;
	}

	public int getLaneOrientation() {
		return myLaneOrientation;
	}

	public void setInsets(Insets insets) {
		myInsets = insets != null ? insets : NO_INSETS;
	}

	public Insets getInsets() {
		return myInsets;
	}

	@Override
	protected Dimension calculateMinimumSize(IFigure container, int wHint, int hHint) {
		Insets insets = container.getInsets();
		List children = container.getChildren();
		int childWHint = getLaneOrientation() == HORIZONTAL ? Math.max(0, wHint - insets.getWidth()) : (wHint
				- insets.getWidth() > 0 ? wHint - insets.getWidth() / children.size() : wHint);
		int childHHint = getLaneOrientation() == VERTICAL ? Math.max(0, hHint - insets.getHeight()) : (hHint
				- insets.getHeight() > 0 ? hHint - insets.getHeight() / children.size() : hHint);

		int height = 0, width = 0;
		for (int i = 0; i < children.size(); i++) {
			IFigure child = (IFigure) children.get(i);
			Rectangle constraint = (Rectangle) getConstraint(child);
			Dimension childSize = myTransposer.t(myTransposer.t(constraint).height > -1 ? constraint.getSize() : child
					.getMinimumSize(childWHint, childHHint));
			height += childSize.height;
			width = Math.max(width, childSize.width);
		}
		return myTransposer.t(new Dimension(width, height)).expand(insets.getWidth(), insets.getHeight()).union(
				getBorderPreferredSize(container));
	}

	@Override
	protected Dimension calculatePreferredSize(IFigure container, int wHint, int hHint) {
		Insets insets = container.getInsets();
		List children = container.getChildren();
		int childWHint = getLaneOrientation() == HORIZONTAL ? Math.max(0, wHint - insets.getWidth()) : (wHint
				- insets.getWidth() > 0 ? wHint - insets.getWidth() / children.size() : wHint);
		int childHHint = getLaneOrientation() == VERTICAL ? Math.max(0, hHint - insets.getHeight()) : (hHint
				- insets.getHeight() > 0 ? hHint - insets.getHeight() / children.size() : hHint);

		int height = 0, width = 0;
		for (int i = 0; i < children.size(); i++) {
			IFigure child = (IFigure) children.get(i);
			Rectangle constraint = (Rectangle) getConstraint(child);
			Dimension childSize = myTransposer.t(myTransposer.t(constraint).height > -1 ? constraint.getSize() : child
					.getPreferredSize(childWHint, childHHint));
			height += childSize.height;
			width = Math.max(width, childSize.width);
		}
		return myTransposer.t(new Dimension(width, height)).expand(insets.getWidth(), insets.getHeight()).union(
				getBorderPreferredSize(container));
	}

	@Override
	public void setConstraint(IFigure child, Object constraint) {
		super.setConstraint(child, constraint);
		if (constraint != null) {
			myConstraints.put(child, constraint);
		}
	}

	@Override
	public Object getConstraint(IFigure child) {
		return myConstraints.get(child);
	}

	@Override
	public void remove(IFigure child) {
		super.remove(child);
		myConstraints.remove(child);
	}

	public void layout(IFigure container) {
		List children = container.getChildren();
		int numChildren = children.size();
		if (numChildren > 0) {
			Dimension prefSizes[] = new Dimension[numChildren];
			Dimension minSizes[] = new Dimension[numChildren];

			Insets insets = getInsets();
			int wHint = getLaneOrientation() == HORIZONTAL ? Math.max(0,
					container.getClientArea(Rectangle.SINGLETON).width - insets.getWidth()) : -1;
			int hHint = getLaneOrientation() == VERTICAL ? Math.max(0,
					container.getClientArea(Rectangle.SINGLETON).height - insets.getHeight()) : -1;

			int totalPrefHeight = 0;
			int nonExpansibleNum = 0;

			for (int i = 0; i < numChildren; i++) {
				IFigure child = (IFigure) children.get(i);

				Rectangle constraint = (Rectangle) getConstraint(child);
				boolean isResizedByUser = myTransposer.t(constraint).height > -1;
				prefSizes[i] = myTransposer.t(isResizedByUser ? constraint.getSize() : child.getPreferredSize(wHint,
						hHint));
				minSizes[i] = myTransposer.t(isResizedByUser ? constraint.getSize() : child
						.getMinimumSize(wHint, hHint));

				totalPrefHeight += prefSizes[i].height;
				if (isResizedByUser) {
					nonExpansibleNum++;
				}
			}

			Rectangle clientArea = myTransposer.t(container.getClientArea().getCopy().crop(insets));
			int expansion = totalPrefHeight < clientArea.height && children.size() > nonExpansibleNum ? (clientArea.height - totalPrefHeight)
					/ (children.size() - nonExpansibleNum)
					: 0;

			int x = clientArea.x;
			int y = clientArea.y;
			for (int i = 0; i < numChildren; i++) {
				int prefHeight = prefSizes[i].height;
				int prefWidth = prefSizes[i].width;
				int minWidth = minSizes[i].width;
				Rectangle newBounds = new Rectangle(x, y, prefWidth, prefHeight);

				IFigure child = (IFigure) children.get(i);
				Rectangle constraint = myTransposer.t((Rectangle) getConstraint(child));
				boolean isResizedByUser = constraint.height > -1;
				newBounds.width = Math.max(minWidth, clientArea.width);
				if (isResizedByUser) {
					/*
					 * If all element are resized by user and summary preferred heigh is less then
					 * client area, last element should cover spare space.
					 */
					if (numChildren == nonExpansibleNum && totalPrefHeight < clientArea.height && i == numChildren - 1) {
						newBounds.height += clientArea.height - totalPrefHeight;
					}
				} else {
					newBounds.height += expansion;
				}
				child.setBounds(myTransposer.t(newBounds));

				y += newBounds.height;
			}
		}
	}
}
