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
package org.eclipse.papyrus.diagram.usecase.draw2d;

import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * The Class AbstractProportionalShape. This class comes from org.eclipse.uml2.diagram.usecase.draw2d provided by Eclipse.org
 */
public abstract class AbstractProportionalShape extends Shape {

	private float w2HRatio = 1.0f;

	private boolean keepingProportions;

	public AbstractProportionalShape() {
	}

	/**
	 * Sets the w2 h ratio.
	 * 
	 * @param w2hRatio
	 *            the new w2 h ratio
	 */
	protected void setW2HRatio(float w2hRatio) {
		w2HRatio = w2hRatio;
		keepingProportions = true;
	}

	/**
	 * Sets the keeping proportions.
	 * 
	 * @param newValue
	 *            the new keeping proportions
	 */
	protected void setKeepingProportions(boolean newValue) {
		keepingProportions = newValue;
	}

	/**
	 * Checks if is keeping proportions.
	 * 
	 * @return true, if is keeping proportions
	 */
	protected boolean isKeepingProportions() {
		return keepingProportions;
	}

	/**
	 * If keeping proportions, returns the maximum rectangle that is fully inside the bounds and has the specified proportions. Otherwise, returns the bounds.
	 */
	public Rectangle getProportionalBounds() {
		Rectangle area = getClientArea();
		if (!keepingProportions || w2HRatio == 0.0f || area.height == 0) {
			return new Rectangle(area);
		}

		int newX = area.x;
		int newY = area.y;
		int newW = area.width;
		int newH = area.height;

		float currentRatio = ((float) newW) / ((float) newH);
		float discrepancy = currentRatio / w2HRatio;

		if (discrepancy < 1) {
			// we are too high.
			newH = Math.round(newH * discrepancy);
			newY += (area.height - newH) / 2;
		} else {
			// we are too wide
			newW = Math.round(newW / discrepancy);
			newX += (area.width - newW) / 2;
		}
		return new Rectangle(newX, newY, newW, newH);
	}

	/**
	 * If keeping proportions, returns the dimension tweaked by the same factor as the proportional bounds relate to the original bounds. Otherwise, returns the original dimension.
	 */
	public Dimension adjustDimension(Dimension d) {
		Rectangle area = getClientArea();
		if (!keepingProportions || w2HRatio == 0.0f || area.height == 0) {
			return new Dimension(d);
		}

		float currentRatio = ((float) area.width) / ((float) area.height);
		float discrepancy = currentRatio / w2HRatio;

		if (discrepancy < 1) {
			return new Dimension(d.width, (int) (d.height * discrepancy));
		} else {
			return new Dimension((int) (d.width / discrepancy), d.height);
		}
	}
}