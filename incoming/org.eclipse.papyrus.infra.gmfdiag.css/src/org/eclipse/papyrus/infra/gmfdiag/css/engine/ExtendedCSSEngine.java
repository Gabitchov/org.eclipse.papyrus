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
package org.eclipse.papyrus.infra.gmfdiag.css.engine;

import java.net.URL;

import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.listener.StyleSheetChangeListener;
import org.eclipse.papyrus.infra.gmfdiag.css.lists.ExtendedStyleSheetList;
import org.eclipse.papyrus.infra.gmfdiag.css.modelstylesheets.StyleSheet;
import org.w3c.dom.css.CSSValue;

@SuppressWarnings("restriction")
public interface ExtendedCSSEngine extends LazyCSSEngine, CSSEngine {

	/**
	 * Adds a stylesheet from a given StyleSheet model.
	 * 
	 * @param inputURL
	 */
	public void addStyleSheet(StyleSheet styleSheet);

	/**
	 * Adds a stylesheet from a given URL.
	 * 
	 * @param inputURL
	 */
	public void addStyleSheet(URL inputURL);

	/**
	 * Resets the CSS cache
	 */
	public void resetCache();

	/**
	 * Adds a listener to be notified each time a StyleSheet has changed
	 * 
	 * @param listener
	 */
	public void addStyleSheetChangeListener(StyleSheetChangeListener listener);

	/**
	 * @return The list of all stylesheets for this Engine, including the
	 *         parent ones
	 */
	public ExtendedStyleSheetList getAllStylesheets();

	/**
	 * {@inheritDoc}
	 * 
	 * This method never throws an Exception
	 */
	public Object convert(CSSValue cssValue, Object toType, Object context);
}
