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

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.e4.ui.css.core.dom.ExtendedDocumentCSS;
import org.eclipse.e4.ui.css.core.dom.parsers.CSSParser;
import org.eclipse.e4.ui.css.core.dom.parsers.CSSParserFactory;
import org.eclipse.e4.ui.css.core.dom.parsers.ICSSParserFactory;
import org.eclipse.e4.ui.css.core.dom.properties.converters.ICSSValueConverter;
import org.eclipse.e4.ui.css.core.impl.engine.AbstractCSSEngine;
import org.eclipse.e4.ui.css.core.impl.sac.CSSConditionFactoryImpl;
import org.eclipse.e4.ui.css.core.impl.sac.CSSSelectorFactoryImpl;
import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.infra.gmfdiag.css.converters.BooleanConverter;
import org.eclipse.papyrus.infra.gmfdiag.css.converters.ColorToGMFConverter;
import org.eclipse.papyrus.infra.gmfdiag.css.converters.IntegerConverter;
import org.eclipse.papyrus.infra.gmfdiag.css.converters.StringConverter;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.enginecopy.ExtendedViewCSSImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.listener.StyleSheetChangeListener;
import org.eclipse.papyrus.infra.gmfdiag.css.lists.ExtendedStyleSheetList;
import org.w3c.css.sac.ConditionFactory;
import org.w3c.dom.Element;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.css.ViewCSS;

/**
 * Base implementation for a hierarchic, lazy CSS Engine.
 * 
 * @author Camille Letavernier
 */
//TODO : Listen on stylesheet modifications
@SuppressWarnings("restriction")
public abstract class ExtendedCSSEngineImpl extends AbstractCSSEngine implements ExtendedCSSEngine, StyleSheetChangeListener {

	public static final ConditionFactory CONDITIONFACTORY_INSTANCE = new CSSConditionFactoryImpl(null, "class", null, "id");

	private final Map<Element, CSSStyleDeclaration> declarationsCache = new HashMap<Element, CSSStyleDeclaration>();

	private ExtendedViewCSSImpl viewCSS;

	protected ExtendedCSSEngine parent;

	private ExtendedStyleSheetList styleSheetsList;

	private final Set<StyleSheetChangeListener> styleSheetListeners = new HashSet<StyleSheetChangeListener>();

	/**
	 * Owned stylesheets
	 */
	private final List<URL> styleSheets = new LinkedList<URL>();

	public ExtendedCSSEngineImpl() {
		this(null);
	}

	public ExtendedCSSEngineImpl(ExtendedCSSEngine parent) {
		super();
		init(parent);
	}

	public ExtendedCSSEngineImpl(ExtendedCSSEngine parent, ExtendedDocumentCSS documentCSS) {
		super(documentCSS);
		init(parent);
	}

	private void init(ExtendedCSSEngine parent) {
		if(parent != null) {
			parent.addStyleSheetChangeListener(this);
		}
		viewCSS = new ExtendedViewCSSImpl(this);
		this.parent = parent;

		this.registerCSSValueConverter(new ColorToGMFConverter());
		this.registerCSSValueConverter(new IntegerConverter());
		this.registerCSSValueConverter(new StringConverter());
		this.registerCSSValueConverter(new BooleanConverter());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String retrieveCSSProperty(Object widget, String property, String pseudo) {
		Element element;
		if(widget instanceof Element) {
			element = (Element)widget;
		} else {
			element = getElement(widget);
		}
		CSSValue value = retrievePropertyValue(element, property);
		if(value == null) {
			return null;
		}
		return value.getCssText();
	}

	/**
	 * {@inheritDoc}
	 */
	public CSSValue retrievePropertyValue(Element element, String property) {
		if(element == null || property == null) {
			return null;
		}

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

	/**
	 * {@inheritDoc}
	 */
	public void addStyleSheet(URL styleSheetURL) {
		styleSheets.add(styleSheetURL);
		reset();
	}

	/**
	 * {@inheritDoc}
	 */
	public void addStyleSheet(URL inputURL, boolean extended) {
		//TODO : Extended CSS
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void reset() {
		resetCache();
		super.reset();
		fireStyleSheetChanged();
	}

	//FIXME : Determine precisely the lifecycle of the cache
	//When is it built ; when is it cleaned
	/**
	 * {@inheritDoc}
	 */
	public void resetCache() {
		declarationsCache.clear();
		styleSheetsList = null;
	}

	private void parseStyleSheets() {
		for(URL styleSheetURL : styleSheets) {
			try {
				parseStyleSheet(styleSheetURL.openStream());
			} catch (IOException ex) {
				Activator.log.error("Cannot parse styleSheet at URL : " + styleSheetURL, ex);
			}
		}
	}

	@Override
	public CSSParser makeCSSParser() {
		//TODO : Extended parser (CSSX)
		//if(isExtended) {
		//		return makeExtendedCSSParser();
		//}

		// Create CSS Parser
		ICSSParserFactory factory = CSSParserFactory.newInstance();
		CSSParser parser = factory.makeCSSParser();

		// Register Batik CSS Selector factory.
		parser.setSelectorFactory(CSSSelectorFactoryImpl.INSTANCE);

		// Register Custom CSS Condition factory.
		parser.setConditionFactory(CONDITIONFACTORY_INSTANCE);

		return parser;
	}

	@Override
	public ViewCSS getViewCSS() {
		return viewCSS;
	}

	public void styleSheetChanged(ExtendedCSSEngine owner) {
		reset();
	}

	/**
	 * {@inheritDoc}
	 */
	private void fireStyleSheetChanged() {
		for(StyleSheetChangeListener listener : styleSheetListeners) {
			listener.styleSheetChanged(this);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void addStyleSheetChangeListener(StyleSheetChangeListener listener) {
		styleSheetListeners.add(listener);
	}

	public ExtendedStyleSheetList getAllStylesheets() {
		if(styleSheetsList == null) {
			parseStyleSheets();
			styleSheetsList = new ExtendedStyleSheetList(getDocumentCSS().getStyleSheets());
			if(parent != null) {
				styleSheetsList.addAll(parent.getAllStylesheets());
			}
		}

		return styleSheetsList;
	}

	@Override
	public Object convert(CSSValue value, Object toType, Object context) {
		try {
			return super.convert(value, toType, context);
		} catch (Exception ex) {
			//Activator.log.warn("Unsupported CSS value: " + value.getCssText() + ". Trying to convert it...");
			return convert(value, toType); //FIXME: Sometimes, the conversion is not supported by the AbstractCSSEngine 
		}
	}

	//Smaller implementation of convert(). Doesn't rely on cache nor any kind of registry
	//Call this method when the super implementation fails (UnsupportedOperationException...)
	protected Object convert(CSSValue value, Object toType) {
		ICSSValueConverter converter = getCSSValueConverter(toType);
		if(converter != null) {
			try {
				return converter.convert(value, this, null);
			} catch (Exception ex) {
				handleExceptions(ex);
			}
		}
		return value;
	}

	@Override
	public void dispose() {
		getElementsContext(); //FIXME: Avoid a NullPointerException in super.dispose()...
		super.dispose();
	}
}
