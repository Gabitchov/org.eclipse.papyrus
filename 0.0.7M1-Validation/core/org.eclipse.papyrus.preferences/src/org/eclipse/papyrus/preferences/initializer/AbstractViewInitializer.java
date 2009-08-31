/****************************************************************************
 * Copyright (c) 2008 Atos Origin.
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
package org.eclipse.papyrus.preferences.initializer;

import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.LineStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;

/**
 * Initialize a view with the properties contained in a preference store
 * 
 * <p>
 * The following properties can be initialized :
 * <ul>
 * <li>{@link org.eclipse.gmf.runtime.notation.FontStyle#getFontName() <em>Font</em>}</li>
 * <li>{@link org.eclipse.gmf.runtime.notation.FontStyle#getFontColor() <em>Font Color</em>}</li>
 * <li>{@link org.eclipse.gmf.runtime.notation.LineStyle#getLineColor() <em>Line Color</em>}</li>
 * </ul>
 * </p>
 * 
 * @author tlandre
 */
public abstract class AbstractViewInitializer {

	/** The view to initialize */
	private View view;

	/** The preference store to use */
	private IPreferenceStore store;

	/**
	 * Constructor
	 * 
	 * @param view
	 *            the view to initialize
	 * @param store
	 *            the preference store where the properties are.
	 */
	public AbstractViewInitializer(View view, IPreferenceStore store) {
		this.view = view;
		this.store = store;
	}

	/**
	 * Initialize the font.
	 * 
	 * @param preferenceFontName
	 *            the name of the preference where is stored the value of the font.
	 */
	public void initFont(String preferenceFontName) {
		FontStyle fontStyle = (FontStyle) view.getStyle(NotationPackage.Literals.FONT_STYLE);

		if (fontStyle != null) {
			// default font
			FontData fontData = PreferenceConverter.getFontData(store, preferenceFontName);
			fontStyle.setFontName(fontData.getName());
			fontStyle.setFontHeight(fontData.getHeight());
			fontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			fontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			// font color
			RGB fontRGB = PreferenceConverter.getColor(store, preferenceFontName);
			fontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
	}

	/**
	 * Initialize the font color.
	 * 
	 * @param preferenceFontColorName
	 *            the name of the preference where is stored the value of the color.
	 */
	public void initFontColor(String preferenceFontColorName) {
		FontStyle fontStyle = (FontStyle) view.getStyle(NotationPackage.Literals.FONT_STYLE);

		if (fontStyle != null) {
			// font color
			RGB fontRGB = PreferenceConverter.getColor(store, preferenceFontColorName);
			fontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
	}

	/**
	 * Initialize the line color.
	 * 
	 * @param preferenceLineColorName
	 *            the name of the preference where is stored the value of the color.
	 */
	public void initLineColor(String preferenceLineColorName) {
		LineStyle lineStyle = (LineStyle) view.getStyle(NotationPackage.Literals.LINE_STYLE);
		if (lineStyle != null) {
			// line color
			RGB lineRGB = PreferenceConverter.getColor(store, preferenceLineColorName);

			lineStyle.setLineColor(FigureUtilities.RGBToInteger(lineRGB).intValue());
		}
	}

	/**
	 * Get the preference store used for this view
	 * 
	 * @return the preference store used
	 */
	public IPreferenceStore getStore() {
		return store;
	}

	/**
	 * Get the view for this initializer
	 * 
	 * @return the view used
	 */
	public View getView() {
		return view;
	}

}
