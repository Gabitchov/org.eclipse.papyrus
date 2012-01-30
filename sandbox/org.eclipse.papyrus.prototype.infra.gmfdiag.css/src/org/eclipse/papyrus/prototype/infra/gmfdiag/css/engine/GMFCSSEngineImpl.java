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
import java.io.InputStream;
import java.net.URL;

import org.eclipse.e4.ui.css.core.dom.ExtendedDocumentCSS;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.e4.ui.css.core.impl.engine.CSSEngineImpl;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.Activator;
import org.w3c.dom.Element;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSStyleSheet;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.css.DocumentCSS;
import org.w3c.dom.css.ViewCSS;
import org.w3c.dom.stylesheets.StyleSheet;

//TODO : Observe the resource for modifications
//TODO : Remove the refresh timer
//TODO : Read CSS file from ModelSet
public class GMFCSSEngineImpl extends CSSEngineImpl {

	private long lastInit;

	private GMFCSSEngineImpl() {
		setErrorHandler(new GMFErrorHandler());
		//Set converters
		init();
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

		lastInit = System.currentTimeMillis();
		reset();

		//		addStyleSheet("platform:/plugin/" + Activator.PLUGIN_ID + "/resources/papyrus_base.css");
		//		addStyleSheet("platform:/plugin/" + Activator.PLUGIN_ID + "/resources/papyrus.css");
		//		addStyleSheet("platform:/plugin/" + Activator.PLUGIN_ID + "/resources/papyrus_simple.css");
		//		addStyleSheet("platform:/plugin/" + Activator.PLUGIN_ID + "/resources/papyrus_theme.css");
		//		addStyleSheet("platform:/plugin/" + Activator.PLUGIN_ID + "/resources/papyrus.cssx"); //Sample CSSX engine (Proto)

		addStyleSheet("platform:/plugin/" + Activator.PLUGIN_ID + "/resources/papyrus_fill.css");
		addStyleSheet("platform:/plugin/" + Activator.PLUGIN_ID + "/resources/papyrus_base.css");
	}

	@Override
	public String retrieveCSSProperty(Object widget, String property, String pseudo) {
		CSSStyleDeclaration style = getViewCSS().getComputedStyle((Element)element, pseudo);
		if(style == null) {
			return null;
		}
		
		String value = style.getPropertyCSSValue(propertyName)tPropertyValue(property);
		
		return value;
	}

	private void addStyleSheet(String url) {
		try {
			URL styleSheetURL = new URL(url);
			InputStream inputStream = styleSheetURL.openStream();
			if(url.endsWith(".cssx")) {
				parsePapyrusStyleSheet(inputStream);
			} else {
				parseStyleSheet(inputStream);
			}
		} catch (FileNotFoundException ex) {
			Activator.log.error(ex);
		} catch (IOException ex) {
			Activator.log.error(ex);
		}
	}

	private StyleSheet parsePapyrusStyleSheet(InputStream inputStream) {
		SampleCSSXParser parser = new SampleCSSXParser();
		CSSStyleSheet s = parser.createStyleSheet();

		DocumentCSS documentCSS = getDocumentCSS();
		if(documentCSS instanceof ExtendedDocumentCSS) {
			((ExtendedDocumentCSS)documentCSS).addStyleSheet(s);
		}
		return s;
	}
}
