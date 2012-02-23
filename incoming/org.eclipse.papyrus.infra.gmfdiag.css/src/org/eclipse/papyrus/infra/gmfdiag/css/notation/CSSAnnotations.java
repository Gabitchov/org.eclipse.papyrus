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

public interface CSSAnnotations {

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
	public static final Object CSS_DIAGRAM_STYLESHEETS_KEY = "styleSheets"; //$NON-NLS-1$

	/**
	 * The name of the EAnnotation containing css informations
	 * 
	 * @see CSS_GMF_ID_KEY
	 * @see CSS_GMF_CLASS_KEY
	 * @see CSS_GMF_STYLE_KEY
	 */
	public static final String CSS_ANNOTATION = "PapyrusCSS"; //$NON-NLS-1$

	/**
	 * The name of the EAnnotation containing the list of feature names
	 * for which the value has been forced by the user.
	 */
	public static final String CSS_FORCE_VALUE = "PapyrusCSSForceValue"; //$NON-NLS-1$
}
