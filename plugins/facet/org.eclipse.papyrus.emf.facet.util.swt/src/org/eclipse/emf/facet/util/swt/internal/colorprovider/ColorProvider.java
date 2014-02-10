/*******************************************************************************
 * Copyright (c) 2013 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *      Grégoire Dupé (Mia-Software) - Bug 424122 - [Table] Images, fonts and colors are not shared between the instances of table
 ******************************************************************************/
package org.eclipse.emf.facet.util.swt.internal.colorprovider;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.facet.util.swt.colorprovider.IColorProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.RGB;

public class ColorProvider implements IColorProvider {

	private Map<RGB, Color> cash = new HashMap<RGB, Color>();
	private Device device;

	public ColorProvider(final Device device) {
		this.device = device;
	}
	
	public Color getColor(final RGB rgb) {
		Color result = this.cash.get(rgb);
		if (result == null) {
			result = new Color(this.device, rgb);
			this.cash.put(rgb, result);
		}
		return result;
	}

}
