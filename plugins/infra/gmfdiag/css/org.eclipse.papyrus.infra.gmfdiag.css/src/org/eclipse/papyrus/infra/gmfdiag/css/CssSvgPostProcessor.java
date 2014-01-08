/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Wouters <laurent.wouters@cea.fr> CEA LIST - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.e4.ui.css.core.impl.dom.CSSStyleRuleImpl;
import org.eclipse.e4.ui.css.core.impl.sac.ExtendedSelector;
import org.eclipse.e4.ui.css.xml.engine.CSSXMLEngineImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.StringValueStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.handler.IRefreshHandlerPart;
import org.eclipse.papyrus.infra.gmfdiag.common.handler.RefreshHandler;
import org.eclipse.papyrus.infra.gmfdiag.common.service.shape.SVGPostProcessor;
import org.eclipse.ui.IEditorPart;
import org.w3c.css.sac.SelectorList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSStyleRule;
import org.w3c.dom.css.CSSStyleSheet;
import org.w3c.dom.css.DocumentCSS;
import org.w3c.dom.stylesheets.StyleSheet;
import org.w3c.dom.svg.SVGDocument;

/**
 * Represents a SVG post-processor that applies the current CSS style provided by the view
 * 
 * @author Laurent Wouters
 */
public class CssSvgPostProcessor implements SVGPostProcessor, IRefreshHandlerPart {

	/**
	 * The name of the CSS property that points to the CSS file for the SVG figure
	 */
	private static final String CSS_PROPERTY_SVG_STYLESHEET = "svgCSSFile";

	/**
	 * The name of the CSS property that defines the name of the CSS class to look for in the SVG figure
	 */
	private static final String CSS_PROPERTY_SVG_CLASS = "svgCSSClass";

	/**
	 * The CSS engine for this post-processor
	 */
	private CSSEngine engine;

	/**
	 * Maps of URIs for CSS stylesheets refered to with relative paths
	 */
	private WeakHashMap<Resource, Map<String, URI>> relativePaths;

	/**
	 * List of the loaded stylesheets
	 */
	private Collection<URI> loadedSheets;

	/**
	 * List of stylesheets that could not be loaded
	 */
	private Collection<URI> failedSheets;

	/**
	 * Hive of styled SVG element per document that stores the original style of the SVG elements
	 */
	private Map<SVGDocument, Map<Element, Map<String, String>>> styledDocuments;

	/**
	 * Initializes this processor
	 */
	@SuppressWarnings("restriction")
	public CssSvgPostProcessor() {
		engine = new CSSXMLEngineImpl();
		relativePaths = new WeakHashMap<Resource, Map<String, URI>>();
		loadedSheets = new ArrayList<URI>();
		failedSheets = new ArrayList<URI>();
		styledDocuments = new HashMap<SVGDocument, Map<Element, Map<String, String>>>();
		RefreshHandler.register(this);
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.handler.IRefreshHandlerPart#refresh(org.eclipse.ui.IEditorPart)
	 */
	public void refresh(IEditorPart editorPart) {
		relativePaths.clear();
		loadedSheets.clear();
		failedSheets.clear();
		styledDocuments.clear();
		engine.reset();
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.service.shape.SVGPostProcessor#postProcess(org.eclipse.emf.ecore.EObject, org.w3c.dom.svg.SVGDocument)
	 */
	@SuppressWarnings("restriction")
	public void postProcess(EObject view, SVGDocument document) {
		if (view instanceof CSSShapeImpl) {
			View shape = (View) view;
			// Retrieve the applied CSS stylesheet if necessary
			StringValueStyle nsURI = (StringValueStyle) shape.getNamedStyle(NotationPackage.eINSTANCE.getStringValueStyle(), CSS_PROPERTY_SVG_STYLESHEET);
			if (nsURI != null)
				loadStylesheet(getCanonicalURI(shape.getElement(), nsURI.getStringValue()));
			// Retrieve the applied CSS class
			StringValueStyle nsClassName = (StringValueStyle) shape.getNamedStyle(NotationPackage.eINSTANCE.getStringValueStyle(), CSS_PROPERTY_SVG_CLASS);
			String className = "";
			if (nsClassName != null)
				className = nsClassName.getStringValue();
			// Apply the style
			document.getDocumentElement().setAttribute("class", className);
			applyStyles(document);
		}
	}

	/**
	 * Loads the stylesheet at the given URI into the CSS engine
	 * 
	 * @param uri
	 *            The URI to load the stylesheet from
	 */
	private void loadStylesheet(URI uri) {
		if (uri == null || uri.isEmpty())
			return;
		if (loadedSheets.contains(uri))
			return;
		if (failedSheets.contains(uri))
			return;
		InputStream stream;
		try {
			stream = URIConverter.INSTANCE.createInputStream(uri);
		} catch (IOException e) {
			Activator.log.error("Failed to locate stylesheet from " + uri, e);
			failedSheets.add(uri);
			return;
		}
		StyleSheet sheet = null;
		try {
			sheet = engine.parseStyleSheet(stream);
		} catch (IOException e) {
			Activator.log.error("Failed to load stylesheet at " + uri, e);
			failedSheets.add(uri);
		} finally {
			try {
				stream.close();
			} catch (IOException e) {
			}
		}
		if (sheet != null) {
			loadedSheets.add(uri);
		}
	}

	/**
	 * Translates the given uri as a string to a canonical Eclipse URI
	 * The URI may be relative to the currently edited EMF resource
	 * 
	 * @param model
	 *            The model element used to retrieve the EMF resource that is currently edited
	 * @param uri
	 *            The potentially relative URI of a stylesheet
	 * @return The canonical URI of the resource
	 */
	private URI getCanonicalURI(EObject model, String uri) {
		if (uri.startsWith("platform:/"))
			return URI.createURI(uri);

		Map<String, URI> resMap = relativePaths.get(model.eResource());
		if (resMap == null) {
			resMap = new HashMap<String, URI>();
			relativePaths.put(model.eResource(), resMap);
		}
		URI canonical = resMap.get(uri);
		if (canonical != null)
			return canonical;

		URI resURI = model.eResource().getURI();
		if (!resURI.isPlatform())
			return null;
		StringBuilder builder = new StringBuilder("platform:/");
		String[] segments = resURI.segments();
		for (int i = 0; i < segments.length - 1; i++) {
			builder.append(segments[i]);
			builder.append("/");
		}
		builder.append(uri);
		canonical = URI.createURI(builder.toString());
		resMap.put(uri, canonical);
		return canonical;
	}


	/**
	 * Applies the CSS styles to the given SVG document
	 * 
	 * @param document
	 *            The SVG document
	 */
	private void applyStyles(SVGDocument document) {
		List<CSSStyleRule> rules = getAllRulesIn(engine.getDocumentCSS());
		Map<Element, Map<String, String>> originals = styledDocuments.get(document);
		if (originals == null) {
			originals = new HashMap<Element, Map<String, String>>();
			styledDocuments.put(document, originals);
		}
		applyStyles(document.getDocumentElement(), rules, originals);
	}

	/**
	 * Recursively applies the CSS rule on this SVG element
	 * 
	 * @param element
	 *            The SVG element
	 * @param rules
	 *            The CSS rules in effect
	 * @param originals
	 *            The original styling properties of the elements
	 */
	private void applyStyles(Element element, List<CSSStyleRule> rules, Map<Element, Map<String, String>> originals) {
		// recursively apply to DOM elements
		for (int i = 0; i != element.getChildNodes().getLength(); i++) {
			Node child = element.getChildNodes().item(i);
			if (child instanceof Element)
				applyStyles((Element) child, rules, originals);
		}

		// make a copy of the original styling properties
		Map<String, String> style = originals.get(element);
		if (style == null) {
			style = getBaseStyle(element);
			originals.put(element, style);
		}
		style = new HashMap<String, String>(style);

		// get the applicable CSS rules
		List<CSSStyleRule> applicable = getApplicableRules(element, rules);
		// apply the CSS rules to the styling properties
		for (CSSStyleRule rule : applicable)
			applyRuleTo(rule, style);

		// serialize the result and put it back into the DOM
		StringBuilder builder = new StringBuilder();
		int count = 0;
		for (Entry<String, String> entry : style.entrySet()) {
			if (count != 0)
				builder.append(";");
			builder.append(entry.getKey());
			builder.append(":");
			builder.append(entry.getValue());
			count++;
		}
		element.setAttribute("style", builder.toString());
	}

	/**
	 * Builds a list of the CSS style rules for the given CSS document
	 * 
	 * @param css
	 *            The CSS document
	 * @return The CSS style rules
	 */
	private List<CSSStyleRule> getAllRulesIn(DocumentCSS css) {
		List<CSSStyleRule> result = new ArrayList<CSSStyleRule>();
		for (int i = 0; i != css.getStyleSheets().getLength(); i++) {
			StyleSheet ss = css.getStyleSheets().item(i);
			if (ss instanceof CSSStyleSheet) {
				CSSStyleSheet cs = (CSSStyleSheet) ss;
				for (int j = 0; j != cs.getCssRules().getLength(); j++) {
					CSSRule rule = cs.getCssRules().item(j);
					if (rule.getType() == CSSRule.STYLE_RULE)
						result.add((CSSStyleRule) rule);
				}
			}
		}
		return result;
	}

	/**
	 * Filters the CSS rules that applies for the given SVG element
	 * 
	 * @param svgElement
	 *            A SVG element
	 * @param rules
	 *            The set of active rules
	 * @return The matching rules
	 */
	@SuppressWarnings("restriction")
	private List<CSSStyleRule> getApplicableRules(Element svgElement, List<CSSStyleRule> rules) {
		List<CSSStyleRule> matching = new ArrayList<CSSStyleRule>();

		// Matches the rules using the selectors
		for (CSSStyleRule rule : rules) {
			SelectorList selectors = ((CSSStyleRuleImpl) rule).getSelectorList();
			boolean match = true;
			for (int i = 0; i != selectors.getLength(); i++) {
				ExtendedSelector xs = (ExtendedSelector) selectors.item(i);
				if (!xs.match(svgElement, null)) {
					match = false;
					break;
				}
			}
			if (match)
				matching.add(rule);
		}

		// No match => stop
		if (matching.isEmpty())
			return matching;

		// Remove the parent rules
		boolean[] available = new boolean[matching.size()];
		Arrays.fill(available, 0, available.length, true);
		for (int i = 0; i != matching.size(); i++) {
			CSSStyleRule rule = matching.get(i);
			if (rule != null && rule.getParentRule() != null) {
				for (int j = 0; j != matching.size(); j++) {
					if (matching.get(i) == rule.getParentRule()) {
						available[i] = false;
						break;
					}
				}
			}
		}
		List<CSSStyleRule> result = new ArrayList<CSSStyleRule>();
		for (int i = 0; i != matching.size(); i++)
			if (available[i])
				result.add(matching.get(i));
		return result;
	}

	/**
	 * Loads the styling properties of a SVG element from the DOM
	 * 
	 * @param element
	 *            The SVG element
	 * @return The styling properties in the DOM
	 */
	private Map<String, String> getBaseStyle(Element element) {
		HashMap<String, String> result = new HashMap<String, String>();
		String styleValue = element.getAttribute("style");
		if (styleValue != null && !styleValue.isEmpty()) {
			String[] props = styleValue.split(";");
			for (int i = 0; i != props.length; i++) {
				String[] temp = props[i].split(":");
				if (temp.length == 2) {
					result.put(temp[0], temp[1]);
				} else if (temp.length > 2) {
					StringBuilder builder = new StringBuilder(temp[1]);
					for (int j = 2; j != temp.length; j++) {
						builder.append(":");
						builder.append(temp[j]);
					}
					result.put(temp[0], builder.toString());
				}
			}
		}
		return result;
	}

	/**
	 * Recursively applies the given CSS rule and its parent on the map of properties
	 * 
	 * @param rule
	 *            The CSS rule to apply
	 * @param properties
	 *            The map of CSS properties to build
	 */
	private void applyRuleTo(CSSStyleRule rule, Map<String, String> properties) {
		if (rule.getParentRule() != null)
			applyRuleTo((CSSStyleRule) rule.getParentRule(), properties);
		for (int i = 0; i != rule.getStyle().getLength(); i++) {
			String name = rule.getStyle().item(i);
			String value = rule.getStyle().getPropertyCSSValue(name).getCssText();
			properties.put(name, value);
		}
	}
}
