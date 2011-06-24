/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) Remi.Schnekenburger@cea.fr - Initial API and implementation
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - customization for Parameter
 *
 *****************************************************************************/
package org.eclipse.papyrus.parsers.texteditor.parameterlabel;

import org.eclipse.swt.graphics.RGB;

/**
 * Used colors constants definitions.
 */
public interface IParameterLabelColorConstants {

	/** DEFAULT definition */
	public final String DEFAULT = "default";

	/** KEYWORD definition */
	public final String KEYWORD = "keyword";

	/** STRING definition */
	public final String STRING = "string";

	/** SYMBOL definition */
	public final String SYMBOL = "symbol";

	/** DEFAULT color value definition */
	public final RGB RGB_DEFAULT = new RGB(0, 0, 0);

	/** CONSTANT color value definition */
	public final RGB RGB_CONSTANT = new RGB(120, 120, 120);

	/** BACKGROUND color value definition */
	public final RGB RGB_BACKGROUND = new RGB(255, 255, 255);

	/** KEYWORD color value definition */
	public final RGB RGB_KEYWORD = new RGB(127, 0, 85);

	/** STRING color value definition */
	public final RGB RGB_STRING = new RGB(85, 200, 85);

	/** SYMBOL color value definition */
	public final RGB RGB_SYMBOL = new RGB(42, 0, 255);
}
