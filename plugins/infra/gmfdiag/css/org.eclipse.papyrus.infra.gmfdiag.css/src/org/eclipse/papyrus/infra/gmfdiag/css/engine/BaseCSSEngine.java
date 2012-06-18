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

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.e4.ui.css.core.dom.IElementProvider;
import org.eclipse.e4.ui.css.core.engine.CSSElementContext;
import org.eclipse.papyrus.infra.gmfdiag.css.Activator;
import org.w3c.dom.Element;

/**
 * The base CSS Engine. It contains the default stylesheet, which will be applied
 * in all cases (With the lowest priority).
 * 
 * It should not be used directly.
 * 
 * @author Camille Letavernier
 * 
 * @see DiagramCSSEngine
 */
@SuppressWarnings("restriction")
public class BaseCSSEngine extends ExtendedCSSEngineImpl {

	private BaseCSSEngine() {
		try {
			styleSheetURLs.add(new URL("platform:/plugin/" + Activator.PLUGIN_ID + "/resources/base.css")); //$NON-NLS-1$ //$NON-NLS-2$
		} catch (MalformedURLException ex) {
			Activator.log.error(ex);
		}
	}

	/**
	 * The Singleton instance of BaseCSSEngine
	 */
	public static ExtendedCSSEngine instance = new BaseCSSEngine();

	//Unsupported operations. The BaseCSSEngine should never be used directly.

	@Override
	public Element getElement(Object node) {
		throw new UnsupportedOperationException();
	}

	@Override
	public IElementProvider getElementProvider() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setElementProvider(IElementProvider elementProvider) {
		throw new UnsupportedOperationException();
	}

	@Override
	public CSSElementContext getCSSElementContext(Object node) {
		throw new UnsupportedOperationException();
	}
}
