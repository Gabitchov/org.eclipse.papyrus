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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.Activator;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.engine.handlers.UMLPropertyHandlerProvider;
import org.w3c.dom.css.ViewCSS;

public class GMFCSSEngineImpl extends AbstractGMFCSSEngineImpl {

	private long lastInit;

	private GMFCSSEngineImpl() {
		init();
		registerCSSPropertyHandlerProvider(new UMLPropertyHandlerProvider());
	}

	public static CSSEngine instance = new GMFCSSEngineImpl();

	@Override
	public ViewCSS getViewCSS() {
		init();
		return super.getViewCSS();
	}

	private void init() {
		if(lastInit + 5000 > System.currentTimeMillis()) {
			return;
		}

		//		System.out.println("Refreshing styleSheet");
		lastInit = System.currentTimeMillis();
		try {
			reset();
			URL styleSheetURL = new URL("platform:/plugin/" + Activator.PLUGIN_ID + "/resources/papyrus.css");
			parseStyleSheet(styleSheetURL.openStream());
		} catch (FileNotFoundException ex) {
			Activator.log.error(ex);
		} catch (IOException ex) {
			Activator.log.error(ex);
		}
	}
}
