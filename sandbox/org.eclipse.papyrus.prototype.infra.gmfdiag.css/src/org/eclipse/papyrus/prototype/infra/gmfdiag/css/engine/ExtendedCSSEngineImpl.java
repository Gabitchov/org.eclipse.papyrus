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

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.e4.ui.css.core.dom.ExtendedDocumentCSS;
import org.eclipse.e4.ui.css.core.dom.parsers.CSSParser;
import org.eclipse.e4.ui.css.core.dom.parsers.CSSParserFactory;
import org.eclipse.e4.ui.css.core.dom.parsers.ICSSParserFactory;
import org.eclipse.e4.ui.css.core.impl.engine.AbstractCSSEngine;
import org.eclipse.e4.ui.css.core.impl.sac.CSSConditionFactoryImpl;
import org.eclipse.e4.ui.css.core.impl.sac.CSSSelectorFactoryImpl;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.Activator;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.engine.enginecopy.ExtendedViewCSSImpl;
import org.w3c.css.sac.ConditionFactory;
import org.w3c.dom.Element;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.css.ViewCSS;


/**
 * An Implementation of a Lazy, Extended CSS Engine
 * 
 * Lazy means the engine doesn't apply a style to an element. Instead,
 * the element requests a value for a given property.
 * 
 * Extended means the engine can parse CSSX files, which can handle custom
 * query selectors, as well as standard CSS files.
 * 
 * @author Camille Letavernier
 */
@SuppressWarnings("restriction")
public class ExtendedCSSEngineImpl extends AbstractCSSEngine implements ExtendedCSSEngine {

	public static final ConditionFactory CONDITIONFACTORY_INSTANCE = new CSSConditionFactoryImpl(null, "class", null, "id");

	private boolean isExtended = false;

	private long lastInit;

	private final Map<Element, CSSStyleDeclaration> declarationsCache = new HashMap<Element, CSSStyleDeclaration>();

	ExtendedViewCSSImpl viewCSS;

	public ExtendedCSSEngineImpl() {
		super();
		init();
	}

	public ExtendedCSSEngineImpl(ExtendedDocumentCSS documentCSS) {
		super(documentCSS);
		init();
	}

	private void init() {
		viewCSS = new ExtendedViewCSSImpl(getDocumentCSS());
	}

	private void refreshStyleSheets() {
		if(lastInit + 3000 > System.currentTimeMillis()) {
			return;
		}

		lastInit = System.currentTimeMillis();
		reset();

		addStyleSheet("platform:/plugin/" + Activator.PLUGIN_ID + "/resources/papyrus_base.css");
		//		addStyleSheet("platform:/plugin/" + Activator.PLUGIN_ID + "/resources/papyrus_fill.css");
		//		addStyleSheet("platform:/plugin/" + Activator.PLUGIN_ID + "/resources/papyrus.css");
		//		addStyleSheet("platform:/plugin/" + Activator.PLUGIN_ID + "/resources/papyrus_simple.css");
		addStyleSheet("platform:/plugin/" + Activator.PLUGIN_ID + "/resources/papyrus_theme.css");
		//		addStyleSheet("platform:/plugin/" + Activator.PLUGIN_ID + "/resources/papyrus.cssx"); //Sample CSSX engine (Proto)
	}

	private void addStyleSheet(String styleSheet) {
		try {
			URL styleSheetURL = new URL(styleSheet);
			parseStyleSheet(styleSheetURL);
		} catch (MalformedURLException ex) {
			Activator.log.error("Cannot find the specified stylesheet : " + styleSheet, ex);
		}
	}

	@Override
	public String retrieveCSSProperty(Object widget, String property, String pseudo) {
		CSSValue value = retrievePropertyValue((Element)widget, property);
		if(value == null) {
			return null;
		}
		return value.getCssText();
	}

	/**
	 * Implements the right priority between css declaration in different stylesheets
	 * 
	 * - First, look for rule specificity in all declared StyleSheet
	 * - Then, if two rules have the same specificity, returns the last declared rule
	 */
	public CSSValue retrievePropertyValue(Element element, String property) {
		refreshStyleSheets();

		CSSStyleDeclaration declaration = getStyleDeclaration(element);

		return declaration.getPropertyCSSValue(property);
	}

	private CSSStyleDeclaration getStyleDeclaration(Element element) {
		return getStyleDeclaration(element, null);
	}

	private CSSStyleDeclaration getStyleDeclaration(Element element, String pseudo) {
		if(!declarationsCache.containsKey(element)) {
			declarationsCache.put(element, getViewCSS().getComputedStyle(element, pseudo));
		}
		return declarationsCache.get(element);
	}

	@Override
	public ViewCSS getViewCSS() {
		return viewCSS;
	}

	@Override
	public void reset() {
		resetCache();
		super.reset();
	}

	@Override
	public CSSParser makeCSSParser() {
		if(isExtended) {
			return makeExtendedCSSParser();
		}

		// Create CSS Parser
		ICSSParserFactory factory = CSSParserFactory.newInstance();
		CSSParser parser = factory.makeCSSParser();

		// Register Batik CSS Selector factory.
		parser.setSelectorFactory(CSSSelectorFactoryImpl.INSTANCE);

		// Register Custom CSS Condition factory.
		parser.setConditionFactory(CONDITIONFACTORY_INSTANCE);

		return parser;
	}

	private CSSParser makeExtendedCSSParser() {
		throw new UnsupportedOperationException();
	}

	public void parseStyleSheet(URL inputURL) {
		boolean extended = inputURL.getPath().endsWith(".cssx");
		parseStyleSheet(inputURL, extended);
	}

	public void parseStyleSheet(URL inputURL, boolean extended) {
		if(extended) {
			isExtended = true;
		}
		try {
			parseStyleSheet(inputURL.openStream());
		} catch (IOException ex) {
			Activator.log.error("Cannot open the required URL", ex);
		} finally {
			isExtended = false;
		}
	}

	public void resetCache() {
		declarationsCache.clear();
	}
}
