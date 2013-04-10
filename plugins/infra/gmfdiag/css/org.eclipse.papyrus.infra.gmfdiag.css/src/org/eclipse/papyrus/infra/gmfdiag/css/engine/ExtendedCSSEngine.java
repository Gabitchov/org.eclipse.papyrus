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

import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.listener.StyleSheetChangeListener;
import org.eclipse.papyrus.infra.gmfdiag.css.lists.ExtendedStyleSheetList;
import org.w3c.dom.Element;
import org.w3c.dom.css.CSSValue;

/**
 * An extended, lazy version of a CSSEngine
 * 
 * @author Camille Letavernier
 */
@SuppressWarnings("restriction")
public interface ExtendedCSSEngine extends LazyCSSEngine, CSSEngine {

	/**
	 * Adds a listener to be notified each time a StyleSheet has changed
	 * 
	 * @param listener
	 */
	public void addStyleSheetChangeListener(StyleSheetChangeListener listener);

	/**
	 * Removes a StyleSheetChangeListener
	 * 
	 * @param listener
	 */
	public void removeStyleSheetChangedListener(StyleSheetChangeListener listener);

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

	/**
	 * {@inheritDoc}
	 * 
	 * Should be called when the StyleSheets have changed
	 */
	public void reset();

	/**
	 * Resets the CSS cache
	 * 
	 * Should be called when the semantic model has changed.
	 */
	public void resetCache();

	/**
	 * Notifies a change from the given Element
	 * 
	 * @param element
	 */
	public void notifyChange(Element element);

	/**
	 * Notifies the Engine that the given widget has been disposed
	 * 
	 * @param nativeWidget
	 */
	public void handleDispose(Object nativeWidget);

	/**
	 * {@inheritDoc}
	 */
	public Element getElement(Object node);
}
