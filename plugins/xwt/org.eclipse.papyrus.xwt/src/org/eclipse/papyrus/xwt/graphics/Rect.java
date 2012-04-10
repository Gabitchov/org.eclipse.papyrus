/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.xwt.graphics;

import org.eclipse.swt.graphics.Rectangle;

/**
 * Color consists of four elements: alpha, blue, green and red.
 * 
 * @author yyang
 */
public class Rect {

	private double x;

	private double y;

	private double width;

	private double height;

	public Rect() {
	}

	public Rect(double x, double y, double width, double height) {
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
	}

	public Rect(Rectangle rectangle) {
		setX(rectangle.x);
		setY(rectangle.y);
		setWidth(rectangle.width);
		setHeight(rectangle.height);
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Rect)) {
			return false;
		}
		Rect rect = (Rect)obj;
		return x == rect.getX() && y == rect.getY() && width == rect.getWidth() && height == rect.getHeight();
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ", " + width + ", " + height + ")";
	}

	/**
	 * Returns <code>true</code> if the point specified by the arguments is
	 * inside the area specified by the receiver, and <code>false</code> otherwise.
	 * 
	 * @param x
	 *        the x coordinate of the point to test for containment
	 * @param y
	 *        the y coordinate of the point to test for containment
	 * @return <code>true</code> if the rectangle contains the point and <code>false</code> otherwise
	 */
	public boolean contains(double x, double y) {
		return (x >= this.x) && (y >= this.y) && x < (this.x + width) && y < (this.y + height);
	}

	/**
	 * Returns <code>true</code> if the given point is inside the area specified
	 * by the receiver, and <code>false</code> otherwise.
	 * 
	 * @param pt
	 *        the point to test for containment
	 * @return <code>true</code> if the rectangle contains the point and <code>false</code> otherwise
	 * 
	 * @exception IllegalArgumentException
	 *            <ul>
	 *            <li>ERROR_NULL_ARGUMENT - if the argument is null</li>
	 *            </ul>
	 */
	public boolean contains(Point pt) {
		return contains(pt.getX(), pt.getY());
	}
}
