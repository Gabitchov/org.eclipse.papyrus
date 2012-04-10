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

/**
 * Color consists of four elements: alpha, blue, green and red.
 * 
 * @author yyang
 */
public class Point {

	public static final Point[] EMPTY_ARRAY = new Point[]{};

	private double x;

	private double y;

	public Point() {
	}

	public Point(double x, double y) {
		setX(x);
		setY(y);
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
		if(!(obj instanceof Point)) {
			return false;
		}
		Point point = (Point)obj;
		return x == point.getX() && y == point.getY();
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

}
