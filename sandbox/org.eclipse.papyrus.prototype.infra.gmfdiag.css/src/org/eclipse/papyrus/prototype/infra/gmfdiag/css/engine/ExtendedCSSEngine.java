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
package org.eclipse.papyrus.prototype.infra.gmfdiag.css.engine;

import java.net.URL;

import org.eclipse.e4.ui.css.core.engine.CSSEngine;


public interface ExtendedCSSEngine extends LazyCSSEngine, CSSEngine {

	public static final ExtendedCSSEngine instance = new ExtendedCSSEngineImpl();

	/**
	 * Parses a stylesheet from a given URL.
	 * The kind of stylesheet (CSS vs CSSX) is determined according to the
	 * file's extension (Standard parser for CSS, extended parser for CSSX)
	 * 
	 * @param inputURL
	 */
	public void parseStyleSheet(URL inputURL);

	/**
	 * Parses a stylesheet from a given URL.
	 * If extended is true, the CSSX parser will be used. Otherwise,
	 * the standard CSS parser is used.
	 * 
	 * @param inputURL
	 * @param extended
	 */
	public void parseStyleSheet(URL inputURL, boolean extended);

	/**
	 * Resets the CSS cache
	 */
	public void resetCache();
}
