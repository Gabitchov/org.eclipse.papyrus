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
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;
import java.util.Collection;
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
import org.eclipse.papyrus.infra.gmfdiag.common.helper.DiagramHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.converters.BooleanConverter;
import org.eclipse.papyrus.infra.gmfdiag.css.converters.ColorToGMFConverter;
import org.eclipse.papyrus.infra.gmfdiag.css.converters.IntegerConverter;
import org.eclipse.papyrus.infra.gmfdiag.css.converters.StringConverter;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.enginecopy.ExtendedViewCSSImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.listener.StyleSheetChangeListener;
import org.eclipse.papyrus.infra.gmfdiag.css.lists.ExtendedStyleSheetList;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.EmbeddedStyleSheet;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheet;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheetReference;
import org.eclipse.swt.widgets.Display;
import org.w3c.css.sac.ConditionFactory;
import org.w3c.dom.Element;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.css.ViewCSS;
import org.w3c.dom.stylesheets.StyleSheetList;

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

	private final Map<String, Collection<String>> availableClasses = new HashMap<String, Collection<String>>();

	/**
	 * Owned stylesheets
	 */
	protected final List<StyleSheet> styleSheets = new LinkedList<StyleSheet>();

	/**
	 * Owned stylesheets, by URL
	 */
	protected final List<URL> styleSheetURLs = new LinkedList<URL>();

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

		setErrorHandler(new GMFErrorHandler());
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
	public CSSValue retrievePropertyValue(Object node, String property) {
		if(node == null || property == null) {
			return null;
		}

		CSSStyleDeclaration declaration = getStyleDeclaration(node);

		return declaration.getPropertyCSSValue(property);
	}

	private CSSStyleDeclaration getStyleDeclaration(Object node) {
		return getStyleDeclaration(node, null);
	}

	private CSSStyleDeclaration getStyleDeclaration(Object node, String pseudo) {
		Element element = getElement(node);
		if(!declarationsCache.containsKey(element)) {
			declarationsCache.put(element, getViewCSS().getComputedStyle(element, pseudo));
		}
		return declarationsCache.get(element);
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

	/**
	 * Reloads the CSS Stylesheets for this engine.
	 * The default implementation does nothing, because stylesheets are
	 * not added dynamically.
	 */
	protected void reloadStyleSheets() {
		//Do nothing
	}

	//FIXME : Determine precisely the lifecycle of the cache
	//When is it built ; when is it cleaned
	/**
	 * {@inheritDoc}
	 */
	public void resetCache() {
		declarationsCache.clear();
		styleSheetsList = null;
		availableClasses.clear();
	}

	/**
	 * Reloads and parses this engine's stylesheets
	 */
	protected void parseStyleSheets() {
		reloadStyleSheets();
		for(URL styleSheet : styleSheetURLs) {
			try {
				parseStyleSheet(styleSheet.openStream());
			} catch (IOException ex) {
				handleExceptions(ex);
			}
		}
		for(StyleSheet styleSheet : styleSheets) {
			try {
				if(styleSheet instanceof EmbeddedStyleSheet) {
					parseStyleSheet((EmbeddedStyleSheet)styleSheet);
				} else if(styleSheet instanceof StyleSheetReference) {
					parseStyleSheet((StyleSheetReference)styleSheet);
				}
			} catch (IOException ex) {
				handleExceptions(ex);
			} catch (Exception ex) {
				handleExceptions(ex);
			}
		}
	}

	private void parseStyleSheet(EmbeddedStyleSheet styleSheet) throws IOException {
		Reader reader = new StringReader(styleSheet.getContent());
		parseStyleSheet(reader);
	}

	protected void parseStyleSheet(StyleSheetReference styleSheet) throws IOException {
		String path = styleSheet.getPath();
		if(path.startsWith("/")) {
			path = "platform:/resource" + path;
		}

		URL url = new URL(path);
		parseStyleSheet(url.openStream());
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

	/**
	 * Handles a notification from a parent CSS Engine: a parent stylesheet has
	 * changed. Resets this engine and forwards the event to children
	 * stylesheets
	 */
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

	/**
	 * {@inheritDoc}
	 */
	public void removeStyleSheetChangedListener(StyleSheetChangeListener listener) {
		styleSheetListeners.remove(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	public ExtendedStyleSheetList getAllStylesheets() {
		if(styleSheetsList == null) {
			parseStyleSheets();
			styleSheetsList = new ExtendedStyleSheetList();
			if(parent != null) {
				styleSheetsList.addAll((StyleSheetList)parent.getAllStylesheets());
			}
			styleSheetsList.addAll(getDocumentCSS().getStyleSheets());
		}

		return styleSheetsList;
	}

	/**
	 * {@inheritDoc}
	 */
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		styleSheetListeners.clear();
		if(parent != null) {
			parent.removeStyleSheetChangedListener(this);
		}

		getElementsContext(); //FIXME: Avoid a NullPointerException in super.dispose()...
		super.dispose();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Handles a notification that an Element has changed.
	 * 
	 * Source: GMFElementAdapter
	 */
	public void notifyChange(Element elementAdapter) {
		resetCache(); //TODO: We should only refresh a subset of the cache
		Display.getCurrent().asyncExec(new Runnable() {

			public void run() {
				DiagramHelper.refreshDiagrams(); //TODO: Contextual refresh
			}
		});

	}

	/**
	 * {@inheritDoc}
	 * 
	 * Handles a notification that a graphical widget has been disposed.
	 * 
	 * Source: GMFElementAdapter
	 */
	public void handleDispose(Object nativeWidget) {
		super.handleWidgetDisposed(nativeWidget);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Resets the CSS cache
	 * 
	 * @see #resetCache()
	 */
	public void reapply() {
		resetCache();
	}
}
