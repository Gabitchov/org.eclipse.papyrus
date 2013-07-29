/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Adapted code from EMF-Facet Nattable integration
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.utils;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;

public final class DefaultSizeUtils {

	private static final float MARGINE = 4;

	private static final float FONT_CELL_RATIO = 2;

	private static final float WIDTH_HEIGHT_RATIO = 8;

	private static final float ROW_HEADER_RATIO = 2; //Row header width height ratio

	private static final float DEFAULT_DPI = 96;

	private DefaultSizeUtils() {
		// Must not be used.
	}

	/**
	 * windows : 150%
	 * dipX=dpiY = 150
	 * fontName = Segoe UI
	 * fontHeight = 9
	 * value = 33
	 * 
	 * windows 125% :
	 * dipX = dpiY = 120
	 * fontName = Segoe UI
	 * fontHeight = 9
	 * value = 27,5
	 * 
	 * windows 100%
	 * dipX = dpiY = 96
	 * fontName = Segoe UI
	 * fontHeight = 9
	 * value = 22
	 * 
	 * @return
	 *         the default cell height to use, according to the dpi used by the system
	 */
	public static int getDefaultCellHeight() {
		float dpiY = Display.getDefault().getDPI().y;
		FontData[] fd = Display.getDefault().getSystemFont().getFontData();
		//fd[0].getName();
		float height = (fd[0].getHeight() * DefaultSizeUtils.FONT_CELL_RATIO) + DefaultSizeUtils.MARGINE;
		float value = height * (dpiY / DEFAULT_DPI);
		return (int)Math.ceil(value);
	}

	/**
	 * 
	 * @return
	 *         the default cell width to use, according to the dpi used by the system
	 */
	public static int getDefaultCellWidth() {
		float width = DefaultSizeUtils.getDefaultCellHeight() * DefaultSizeUtils.WIDTH_HEIGHT_RATIO;
		return (int)Math.ceil(width);
	}

	//not used
	public static int getDefaultRowHeaderWidth() {
		float width = DefaultSizeUtils.getDefaultCellHeight() * DefaultSizeUtils.ROW_HEADER_RATIO;
		return (int)Math.ceil(width);
	}

	//not used
	public static Font getHeaderFont() {
		FontData[] fd = Display.getDefault().getSystemFont().getFontData().clone();
		fd[0].setStyle(SWT.BOLD);
		Font headerFont = new Font(Display.getDefault(), fd);
		return headerFont;
	}
}
