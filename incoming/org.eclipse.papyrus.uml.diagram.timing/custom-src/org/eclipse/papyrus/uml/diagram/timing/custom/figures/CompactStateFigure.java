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
package org.eclipse.papyrus.uml.diagram.timing.custom.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.GradientStyle;
import org.eclipse.gmf.tooling.runtime.draw2d.CenterLayout;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusUMLElementFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusNodeFigure;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Pattern;
import org.eclipse.swt.widgets.Display;

public class CompactStateFigure extends PapyrusNodeFigure implements IPapyrusUMLElementFigure {

	public static final int PREFERRED_HEIGHT = 32;
	private final WrappingLabel label;
	private boolean infinite;

	/**
	 * @param infinite
	 *            Whether the state has an end cap (the last state doesn't end)
	 */
	public void setInfinite(final boolean infinite) {
		this.infinite = infinite;
	}

	public boolean isInfinite() {
		return this.infinite;
	}

	public CompactStateFigure() {
		super();
		setLayoutManager(new CenterLayout());
		this.label = new WrappingLabel();
		this.label.setAlignment(PositionConstants.CENTER);
		add(this.label);
	}

	@Override
	public void paintFigure(final Graphics g) {
		// super.paintFigure(g);

		g.pushState();
		final int height = Math.min(PREFERRED_HEIGHT, this.bounds.height);
		final int middleY = this.bounds.y + this.bounds.height / 2;
		final int x = this.bounds.x;
		final int w = this.bounds.width - 1;
		final int y = middleY - height / 2;
		final int h = height - 1;

		g.setLineWidth(1);

		final int cornerSize = Math.min(h / 3, w / 3);

		final int[] polygon;
		if (this.infinite) {
			polygon = new int[] { x, middleY, x + cornerSize, y, x + w + 1, y, x + w + 1, y + h, x + cornerSize, y + h };
		} else {
			polygon = new int[] { x, middleY, x + cornerSize, y, x + w - cornerSize, y, x + w, middleY, x + w - cornerSize, y + h, x + cornerSize, y + h };
		}
		g.setAntialias(SWT.ON);
		if (isUsingGradient()) {
			applyTransparency(g);
			final Pattern pattern;
			// apparently, patterns are not scaled automatically, so we need to scale the pattern so that it fits the
			// current zoom level
			final double scale = g.getAbsoluteScale();
			final int xScaled = (int) (this.bounds.x * scale);
			final int yScaled = (int) (this.bounds.y * scale);
			final int widthScaled = (int) (this.bounds.width * scale);
			final int heightScaled = (int) (height * scale);
			if (getGradientStyle() == GradientStyle.VERTICAL) {
				pattern = new Pattern(Display.getCurrent(), xScaled, yScaled, xScaled, yScaled + heightScaled, FigureUtilities.integerToColor(Integer
						.valueOf(getGradientColor2())), FigureUtilities.integerToColor(Integer.valueOf(getGradientColor1())));
			} else {
				pattern = new Pattern(Display.getCurrent(), xScaled, yScaled, xScaled + widthScaled, this.bounds.y, FigureUtilities.integerToColor(Integer
						.valueOf(getGradientColor2())), FigureUtilities.integerToColor(Integer.valueOf(getGradientColor1())));
			}
			g.setBackgroundPattern(pattern);
			g.fillPolygon(polygon);
			g.drawPolygon(polygon);
			pattern.dispose();
		} else {
			g.setBackgroundColor(getBackgroundColor());
			g.setForegroundColor(getForegroundColor());
			// FIXME: the figure is not filled because the default fill color is black
			// g.fillPolygon(polygon);
			g.drawPolygon(polygon);
		}
		g.popState();
		// displayDebugFigure(g);
	}

	// private void displayDebugFigure(final Graphics g) {
	// g.pushState();
	// g.setForegroundColor(ColorConstants.red);
	// for (int x = 0; x < this.bounds.width - 1; x++) {
	// final int y = computeHalfHeightAtAbscissa(x, this.bounds.width, this.bounds.height, this.infinite);
	// g.drawRectangle(this.bounds.x + x, this.bounds.y + this.bounds.height / 2 - y, 1, 1);
	// g.drawRectangle(this.bounds.x + x, this.bounds.y + this.bounds.height / 2 + y - 1, 1, 1);
	// }
	// g.popState();
	// }

	/**
	 * Compute the half height of a CompactStateFigure with the given width and height, at the given abscissa.
	 * <p>
	 * This function is useful in order to place an OccurrenceSpecification along the border of a StateInvariant.
	 * 
	 * @param x
	 *            the x coordinate at which to compute the height
	 * @param figureWidth
	 *            the width of the CompactStateFigure
	 * @param figureHeight
	 *            the height of the CompactStateFigure
	 * @param infinite
	 *            whether the figure ends with a cap (not infinite) or not (infinite)
	 * @return the half height at the given position
	 */
	public static int computeHalfHeightAtAbscissa(final int x, final int figureWidth, final int figureHeight, final boolean infinite) {
		final int height = Math.min(PREFERRED_HEIGHT, figureHeight);
		final int width = figureWidth;
		final int halfHeight = figureHeight / 2;
		final int cornerSize = Math.min(height / 3, width / 3);

		final int resultY;
		if (x < cornerSize) {
			// on the left corner
			final double slope = (height / 2.0) / cornerSize;
			resultY = (int) (x * slope);
		} else if (infinite) {
			// on the straight border
			resultY = halfHeight;
		} else if (x < width - cornerSize) {
			// on the straight border
			resultY = halfHeight;
		} else {
			// on the right corner
			final double slope = (double) halfHeight / cornerSize;
			resultY = (int) (halfHeight - ((x - width + cornerSize) * slope));
		}
		return resultY;
	}

	public WrappingLabel getCompactStateInvariantLabel() {
		return this.label;
	}

	@Override
	public Dimension getPreferredSize(final int wHint, final int hHint) {
		return new Dimension(-1, PREFERRED_HEIGHT);
	}

	@Override
	protected void paintBorder(final Graphics graphics) {
		// no border
	}

	public void setStereotypeDisplay(final String stereotypes, final Image image) {
		// TODO Auto-generated method stub

	}
}
