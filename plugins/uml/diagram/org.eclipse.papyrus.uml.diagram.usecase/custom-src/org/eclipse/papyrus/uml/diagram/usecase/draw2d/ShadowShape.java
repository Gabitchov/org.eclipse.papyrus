/*****************************************************************************
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.usecase.draw2d;

import org.eclipse.draw2d.AbstractBorder;
import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

/**
 * The Class ShadowShape is used to draw StickMan figure. This class comes from
 * org.eclipse.uml2.diagram.usecase.draw2d provided by Eclipse.org
 */
public abstract class ShadowShape extends AbstractProportionalShape {

	/** The Constant SHADOW_COLOR. */
	private static final Color SHADOW_COLOR = new Color(null, 150, 150, 150);

	/** The Constant SHADOW_SIZE. */
	protected static final int SHADOW_SIZE = 3;

	/** The Constant SHADOW_INSETS. */
	private static final Insets SHADOW_INSETS = new Insets(0, 0, SHADOW_SIZE, SHADOW_SIZE);

	/** The my3 d. */
	private boolean my3D;

	/** The my border. */
	private Border myBorder;

	/**
	 * Instantiates a new shadow shape.
	 * 
	 * @param is3D
	 *        the is3 d
	 * @param backgroundColor
	 *        the background color
	 * @param foregroundColor
	 *        the foreground color
	 */
	public ShadowShape(boolean is3D, Color backgroundColor, Color foregroundColor) {
		setForegroundColor(foregroundColor);
		setBackgroundColor(backgroundColor);
		myBorder = new ShadowBorder();
		setBorder(myBorder);
		set3D(is3D);
	}

	/**
	 * Checks if is 3 d.
	 * 
	 * @return true, if is 3 d
	 */
	protected boolean is3D() {
		return my3D;
	}

	/**
	 * Sets the 3 d.
	 * 
	 * @param is3D
	 *        the new 3 d
	 */
	public void set3D(boolean is3D) {
		if(my3D == is3D) {
			return;
		}
		my3D = is3D;
		repaint();
	}

	/**
	 * {@inheritDoc}
	 */
	public Dimension getPreferredSize(int wHint, int hHint) {
		Dimension original = super.getPreferredSize(wHint, hHint);
		if(is3D()) {
			original.expand(SHADOW_SIZE, SHADOW_SIZE);
		}
		return original;
	}

	/**
	 * Paints this figure, including its border and children. Border is painted first.
	 * 
	 * @param graphics
	 *        the graphics
	 */
	public void paint(Graphics graphics) {
		paintBorder(graphics);
		if(getBackgroundColor() != null)
			graphics.setBackgroundColor(getBackgroundColor());
		if(getForegroundColor() != null)
			graphics.setForegroundColor(getForegroundColor());
		if(getFont() != null)
			graphics.setFont(getFont());
		paintFigure(graphics);
		paintClientArea(graphics);
	}

	/**
	 * {@inheritDoc}
	 */
	protected void fillShape(Graphics graphics) {
		fillShape(graphics, getProportionalBounds());
	}

	/**
	 * Fill shape.
	 * 
	 * @param graphics
	 *        the graphics
	 * @param bounds
	 *        the bounds
	 */
	protected abstract void fillShape(Graphics graphics, Rectangle bounds);

	/**
	 * {@inheritDoc}
	 */
	protected void outlineShape(Graphics graphics) {
		outlineShape(graphics, getProportionalBounds());
	}

	/**
	 * Outline shape.
	 * 
	 * @param graphics
	 *        the graphics
	 * @param bounds
	 *        the bounds
	 */
	protected abstract void outlineShape(Graphics graphics, Rectangle bounds);

	/**
	 * The Class ShadowBorder.
	 */
	private class ShadowBorder extends AbstractBorder {

		/**
		 * {@inheritDoc}
		 */
		public Insets getInsets(IFigure figure) {
			return is3D() ? SHADOW_INSETS : IFigure.NO_INSETS;
		}

		/**
		 * {@inheritDoc}
		 */
		public boolean isOpaque() {
			return is3D();
		}

		/**
		 * {@inheritDoc}
		 */
		public void paint(IFigure figure, Graphics graphics, Insets insets) {
			if(!is3D()) {
				return;
			}
			graphics.setBackgroundColor(SHADOW_COLOR);
			Rectangle rec = getProportionalBounds().getTranslated(SHADOW_SIZE, SHADOW_SIZE);
			graphics.pushState();
			graphics.clipRect(rec);
			// graphics.setClip(new Rectangle(rec.x, rec.y + rec.height - getShift(), rec.width,
			// getShift()));
			fillShape(graphics, rec);
			graphics.popState();
			// graphics.setClip(new Rectangle(rec.x + rec.width - getShift(), rec.y, getShift(),
			// rec.height));
			// fillShape(graphics, rec);
		}
	}
}
