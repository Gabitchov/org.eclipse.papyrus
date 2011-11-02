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
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.RGB;

/**
 * Initialize a node view with the properties contained in a preference store
 * <p>
 * The following properties can be initialized :
 * <ul>
 * <li>{@link org.eclipse.gmf.runtime.notation.FillStyle#getFillColor() <em> FillColor</em>}</li>
 * </ul>
 * </p>
 * 
 * @author tlandre
 */
// @unused
public class NodeViewInitializer extends AbstractViewInitializer {

	/**
	 * Default Constructor
	 * 
	 * @param view
	 *        the node view to initialize
	 * @param store
	 *        the preference store to use
	 */
	// @unused
	public NodeViewInitializer(View view, IPreferenceStore store) {
		super(view, store);
	}

	/**
	 * Initialize the fill color.
	 * 
	 * @param preferenceFillColorName
	 *        the name of the preference where is stored the value of the color.
	 */
	// @unused
	public void initFillColor(String preferenceFillColorName) {
		FillStyle fillStyle = (FillStyle)getView().getStyle(NotationPackage.Literals.FILL_STYLE);
		if(fillStyle != null) {
			// fill color
			RGB fillRGB = PreferenceConverter.getColor(getStore(), preferenceFillColorName);
			fillStyle.setFillColor(FigureUtilities.RGBToInteger(fillRGB).intValue());
		}
	}
}
