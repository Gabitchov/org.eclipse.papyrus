/****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Thibault Landre (Atos Origin) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.preferences.utils;

import java.util.StringTokenizer;

import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.notation.GradientStyle;
import org.eclipse.gmf.runtime.notation.datatype.GradientData;
import org.eclipse.swt.graphics.RGB;

/**
 * An utility class to ease the use of gradient preference within Papyrus. It converts the
 * preference into gradientData, RGB color and int (transparency and style) and vice versa
 * 
 * @author tlandre
 * 
 */
public class GradientPreferenceConverter {

	private static final int GRADIENT_COLOR1 = 0;

	private static final int GRADIENT_COLOR2 = 1;

	private static final int GRADIENT_STYLE = 2;

	private static final int GRADIENT_TRANSPARENCY = 3;

	private int fStyle = GradientStyle.HORIZONTAL;

	private int fTransparency = 0;

	private RGB fColor1;

	private RGB fColor2;

	/**
	 * Constructor
	 * 
	 * @param pPreference
	 *            the preference. It must be formated like this : <br>
	 *            <code>RGB {x, x, x};RGB {x, x,
	 * x};style;transparency</code> <br>
	 *            where style and transparency are <code>int</code>
	 */
	public GradientPreferenceConverter(String pPreference) {
		initFieldFromPreference(pPreference);
	}

	/**
	 * Constructor
	 * 
	 * @param pColor1
	 *            the first color used
	 * @param pColor2
	 *            the second color used
	 * @param pStyle
	 *            the style of the gradient. It can be GradientStyle.VERTICAL or
	 *            GradientStyle.HORIZONTAL
	 * @param pTransparency
	 *            the transparency. It must be contained in [0,100]
	 */
	public GradientPreferenceConverter(RGB pColor1, RGB pColor2, int pStyle, int pTransparency) {
		fColor1 = pColor1;
		fColor2 = pColor2;
		fStyle = pStyle;
		fTransparency = pTransparency;
	}

	/**
	 * Constructor
	 * 
	 * @param pColor1
	 *            the first color used
	 * @param pColor2
	 *            the second color used
	 * @param pStyle
	 *            the style of the gradient. It can be GradientStyle.VERTICAL or
	 *            GradientStyle.HORIZONTAL
	 * @param pTransparency
	 *            the transparency. It must be contained in [0,100]
	 */
	// @unused
	public GradientPreferenceConverter(int pColor1, int pColor2, int pStyle, int pTransparency) {
		fColor1 = FigureUtilities.integerToRGB(pColor1);
		fColor2 = FigureUtilities.integerToRGB(pColor2);
		fStyle = pStyle;
		fTransparency = pTransparency;
	}

	private void initFieldFromPreference(String pPreference) {
		String[] values = pPreference.split(";"); //$NON-NLS-1$
		if (values.length == 4) {
			fColor1 = getRGBColor(values[GRADIENT_COLOR1]);
			fColor2 = getRGBColor(values[GRADIENT_COLOR2]);
			fStyle = Integer.parseInt(values[GRADIENT_STYLE]);
			fTransparency = Integer.parseInt(values[GRADIENT_TRANSPARENCY]);
		}
	}

	/**
	 * Get the transparency of the gradient
	 * 
	 * @return
	 */
	public int getTransparency() {
		return fTransparency;
	}

	/**
	 * Get the gradientData of the gradient
	 * 
	 * @return
	 */
	public GradientData getGradientData() {
		GradientData gd = GradientData.getDefaultGradientData();
		if (fColor1 != null && fColor2 != null) {
			gd = new GradientData(FigureUtilities.RGBToInteger(fColor1), FigureUtilities.RGBToInteger(fColor2), fStyle);
		}
		return gd;
	}

	/**
	 * Get the first color used for the gradient.
	 * 
	 * @return
	 */
	public RGB getColor1() {
		RGB color;
		if (fColor1 != null) {
			color = fColor1;
		} else {
			color = FigureUtilities.integerToRGB(GradientData.getDefaultGradientData().getGradientColor1());
		}
		return color;
	}

	/**
	 * Get the second color used for the gradient.
	 * 
	 * @return
	 */
	// @unused
	public RGB getColor2() {
		RGB color;
		if (fColor1 != null) {
			color = fColor2;
		} else {
			color = FigureUtilities.integerToRGB(GradientData.getDefaultGradientData().getGradientColor2());
		}
		return color;
	}

	/**
	 * Get the style of the gradient
	 * 
	 * @return GradientStyle.HORIZONTAL or GradientStyle.VERTICAL
	 */
	public int getStyle() {
		return fStyle;
	}

	/**
	 * Extract the values of the RGB color contained in the string "RGB {x, x, x}"
	 * 
	 * @param string
	 *            a string of format "RGB {x, x, x}"
	 * @return the corresponding color
	 */
	private static RGB getRGBColor(String string) {
		StringTokenizer st = new StringTokenizer(string, "RGB ,{}"); //$NON-NLS-1$
		int red = Integer.parseInt(st.nextToken());
		int green = Integer.parseInt(st.nextToken());
		int blue = Integer.parseInt(st.nextToken());

		return new RGB(red, green, blue);
	}

	/**
	 * Get a string that can be store The value is in the following format : <br>
	 * <b>RGB {x, x, x};RGB {x, x, x};style;transparency</b> <br>
	 * where style and transparency are <b>int</b>
	 * 
	 * @return the string
	 */
	public String getPreferenceValue() {
		StringBuffer sb = new StringBuffer(30);
		sb.append(fColor1.toString());
		sb.append(";"); //$NON-NLS-1$
		sb.append(fColor2.toString());
		sb.append(";"); //$NON-NLS-1$
		sb.append(fStyle);
		sb.append(";"); //$NON-NLS-1$
		sb.append(fTransparency);
		return sb.toString().trim();
	}
}
