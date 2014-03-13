/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.notation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Constants for the CSS-specific properties
 * 
 * @author Camille Letavernier
 */
public interface CSSStyles {

	/**
	 * The css id property
	 */
	public static final String CSS_GMF_ID_KEY = "cssId"; //$NON-NLS-1$

	/**
	 * The css class property
	 */
	public static final String CSS_GMF_CLASS_KEY = "cssClass"; //$NON-NLS-1$

	/**
	 * The css style property
	 */
	public static final String CSS_GMF_STYLE_KEY = "cssStyle"; //$NON-NLS-1$

	/**
	 * The Diagram Stylesheets key
	 */
	public static final String CSS_DIAGRAM_STYLESHEETS_KEY = "css_stylesheets"; //$NON-NLS-1$
	/**
	 * The Model Stylesheets key
	 */
	public static final String CSS_MODEL_STYLESHEETS_KEY = "modelStyleSheets"; //$NON-NLS-1$

	/**
	 * The list of reserved CSS Keywords used in GMF NamedStyle
	 * 
	 * Note: In general, all values prefixed with css* are potentially reserved for the CSS Engine
	 */
	public static final Set<String> RESERVED_KEYWORDS = new HashSet<String>(Arrays.asList(new String[]{
			CSS_GMF_ID_KEY,
			CSS_GMF_CLASS_KEY,
			CSS_GMF_STYLE_KEY,
			CSS_DIAGRAM_STYLESHEETS_KEY,
			CSS_MODEL_STYLESHEETS_KEY
	}));

}
