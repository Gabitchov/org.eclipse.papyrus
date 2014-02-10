/**
 *  Copyright (c) 2012 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Gregoire Dupe (Mia-Software) - Bug 361794 - [Restructuring] New customization meta-model
 */
package org.eclipse.emf.facet.custom.ui.internal.custompt;

import org.eclipse.emf.facet.custom.metamodel.custompt.IColor;

public class Color implements IColor {

	private static final long serialVersionUID = 240076770346261769L;
	private static final int BYTE_SIZE = Byte.SIZE;
	private static final int TWO_BYTE_SIZE = Byte.SIZE * 2;
	public static final int MAX_VALUE = 255;

	private final int red;
	private final int green;
	private final int blue;

	public Color(final int red, final int green, final int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	public Color getColor() {
		return this.getColor();
	}

	public int getRed() {
		return this.red;
	}

	public int getGreen() {
		return this.green;
	}

	public int getBlue() {
		return this.blue;
	}

	@Override
	public boolean equals(final Object obj) {
		boolean result = false;
		if (obj instanceof Color) {
			final Color color = (Color) obj;
			result = (color.getRed() == this.red)
					&& (color.getGreen() == this.green)
					&& (color.getBlue() == this.blue);
		}
		return result;
	}

	@Override
	public int hashCode() {
		return this.red & (this.green << Color.BYTE_SIZE)
				& (this.blue << Color.TWO_BYTE_SIZE);
	}

}
