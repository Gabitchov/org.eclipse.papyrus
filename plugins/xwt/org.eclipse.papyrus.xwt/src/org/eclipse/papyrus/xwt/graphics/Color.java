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
public class Color {

	private int alaha = 0xFF;

	private int blue;

	private int green;

	private int red;

	private org.eclipse.swt.graphics.Color swtColor;

	public Color() {
	}

	public Color(org.eclipse.swt.graphics.Color swtColor) {
		setValue(swtColor);
	}

	public int getBlue() {
		return blue;
	}

	public void setBlue(int blue) {
		this.blue = blue;
	}

	public int getGreen() {
		return green;
	}

	public void setGreen(int green) {
		this.green = green;
	}

	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getAlpha() {
		return alaha;
	}

	public void setAlaha(int alaha) {
		this.alaha = alaha;
	}

	public org.eclipse.swt.graphics.Color toSWTColor() {
		if(swtColor == null) {
			swtColor = new org.eclipse.swt.graphics.Color(null, red, green, blue);
		}
		return swtColor;
	}

	public void setValue(org.eclipse.swt.graphics.Color swtColor) {
		this.swtColor = swtColor;
		this.blue = swtColor.getBlue();
		this.red = swtColor.getRed();
		this.green = swtColor.getGreen();
	}
}
