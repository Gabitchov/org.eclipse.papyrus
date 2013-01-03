/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayeredPane;
import org.eclipse.draw2d.ScalableFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;

public final class FigureUtils {

	private FigureUtils() {
		// utility class
	}

	/**
	 * Returns a child figure of the given type recursively contained in the given parent figure.
	 * 
	 * @param parent
	 *            the parent figure
	 * @param childFigureClass
	 *            the type of the child figure that is looked for
	 * @return the child figure if found, or <code>null</code> if the parent figure contains no child figure of the
	 *         given type
	 */
	@SuppressWarnings("unchecked")
	public static <T extends IFigure> T findChildFigureInstance(final IFigure parent, final Class<T> childFigureClass) {
		final List<IFigure> children = parent.getChildren();
		for (final IFigure child : children) {
			if (childFigureClass.isAssignableFrom(child.getClass())) {
				return (T) child;
			}
			// look recursively
			final IFigure subresult = findChildFigureInstance(child, childFigureClass);
			if (subresult != null) {
				return (T) subresult;
			}
		}
		// not found
		return null;
	}

	public static <T extends IFigure> List<T> findChildFigureInstances(final IFigure parent, final Class<T> childFigureClass) {
		final List<T> result = new ArrayList<T>();
		internalFindChildFigureInstances(parent, result, childFigureClass);
		return result;
	}

	@SuppressWarnings("unchecked")
	public static <T extends IFigure> void internalFindChildFigureInstances(final IFigure parent, final List<T> result, final Class<T> childFigureClass) {
		final List<IFigure> children = parent.getChildren();
		for (final IFigure child : children) {
			if (childFigureClass.isAssignableFrom(child.getClass())) {
				result.add((T) child);
			} else {
				internalFindChildFigureInstances(child, result, childFigureClass);
			}

		}
	}

	/**
	 * Returns the first parent figure of the given type recursively containing the given figure.
	 * 
	 * @param figure
	 *            the figure
	 * @param parentFigureClass
	 *            the type of the parent figure that is looked for
	 * @return the parent figure if found, or <code>null</code> if the figure is not contained by any figure of the
	 *         given type
	 */
	@SuppressWarnings("unchecked")
	public static <T extends IFigure> T findParentFigureInstance(final IFigure figure, final Class<T> parentFigureClass) {
		IFigure parent = figure.getParent();
		while (parent != null) {
			if (parentFigureClass.isAssignableFrom(parent.getClass())) {
				return (T) parent;
			}
			parent = parent.getParent();
		}
		return null;
	}

	/**
	 * Constrain the given bounds (whose presumed purpose is to become the new bounds for the given Figure), so that
	 * they don't stick out of the bounds of the {@link ResizableCompartmentFigure} in which the given figure is
	 * contained. Returns the original bounds if the given Figure is not contained in a
	 * {@link ResizableCompartmentFigure}.
	 * 
	 * @param bounds
	 *            The bounds to constrain (will not be modified)
	 * @param figure
	 *            the figure in the containing {@link ResizableCompartmentFigure} of which the bound must be constrained
	 * @return the bounds, constrained so that they don't stick out of the {@link ResizableCompartmentFigure} in which
	 *         the Figure is contained
	 * 
	 */
	public static Rectangle constrainBoundsWithinContainingCompartment(final Rectangle bounds, final IFigure figure) {
		final Rectangle result = new Rectangle(bounds);
		final ResizableCompartmentFigure parentCompartment = FigureUtils.findParentFigureInstance(figure, ResizableCompartmentFigure.class);
		if (parentCompartment == null) {
			return result;
		}
		final Rectangle parentBounds = parentCompartment.getBounds();
		result.x = Math.max(result.x, 0);
		result.y = Math.max(result.y, 0);
		result.x = Math.min(result.x, parentBounds.width - result.width);
		result.y = Math.min(result.y, parentBounds.height - result.height);
		return result;
	}

	/**
	 * @return The origin of the coordinate system applied to the given figure (i.e.: the amount scrolled in the scroll
	 *         pane)
	 */
	public static Point getLayeredPaneOrigin(final IFigure figure) {
		final LayeredPane layeredPane = FigureUtils.findChildFigureInstance(FigureUtilities.getRoot(figure), LayeredPane.class);
		final Point origin = new Point(0, 0);
		layeredPane.translateToRelative(origin);
		return origin;
	}

	/**
	 * @return The scale applied to the given figure (i.e.: the zoom set by the user)
	 */
	public static double getScale(final IFigure figure) {
		final ScalableFigure scalableFigure = FigureUtils.findParentFigureInstance(figure, ScalableFigure.class);
		return scalableFigure.getScale();
	}

	public static Point scaleByZoom(final Point delta, final IFigure figure) {
		return new Point(delta).scale(1.0 / getScale(figure));
	}

}
