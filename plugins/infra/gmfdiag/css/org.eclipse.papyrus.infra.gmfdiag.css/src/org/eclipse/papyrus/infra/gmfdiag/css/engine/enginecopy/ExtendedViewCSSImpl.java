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
package org.eclipse.papyrus.infra.gmfdiag.css.engine.enginecopy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.e4.ui.css.core.dom.CSSStylableElement;
import org.eclipse.e4.ui.css.core.dom.ExtendedCSSRule;
import org.eclipse.e4.ui.css.core.impl.sac.ExtendedSelector;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.lists.ExtendedStyleSheetList;
import org.w3c.css.sac.Selector;
import org.w3c.css.sac.SelectorList;
import org.w3c.dom.Element;
import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSRuleList;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSStyleRule;
import org.w3c.dom.css.CSSStyleSheet;
import org.w3c.dom.css.ViewCSS;
import org.w3c.dom.stylesheets.StyleSheet;
import org.w3c.dom.views.DocumentView;

//Implementation based on org.eclipse.e4.ui.css.core.impl.dom.ViewCSSImpl
@SuppressWarnings("restriction")
public class ExtendedViewCSSImpl implements ViewCSS {

	protected ExtendedCSSEngine engine;

	public ExtendedViewCSSImpl(ExtendedCSSEngine extendedCSSEngine) {
		this.engine = extendedCSSEngine;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Implementation based on {@link ViewCSSImpl#getComputedStyle(Element, String)}.
	 * The base implementations returns the first CSSStyleDeclaration.
	 * 
	 * When a StyleDeclaration is found in a StyleSheet, it is added to a list of declarations.
	 * Then, these declarations are merged
	 */
	public CSSStyleDeclaration getComputedStyle(Element elt, String pseudo) {

		ExtendedStyleSheetList styleSheetList = engine.getAllStylesheets();

		List<StyleWrapper> declarations = new ArrayList<StyleWrapper>();

		//Stylesheets
		for(StyleSheet styleSheet : styleSheetList) {
			List<StyleWrapper> styleWrappers = getStyleWrappers((CSSStyleSheet)styleSheet, elt, pseudo, declarations.size());
			declarations.addAll(styleWrappers);
		}

		//Local styles
		String localStyles = ((CSSStylableElement)elt).getCSSStyle();
		if(localStyles != null) {
			StyleWrapper wrapper = getStyleWrapper(localStyles);
			if(wrapper != null) {
				declarations.add(wrapper);
			}
		}

		return new CSSComputedStyleImpl(declarations);
	}

	private StyleWrapper getStyleWrapper(String localStyles) {
		CSSStyleDeclaration style;
		try {
			style = engine.parseStyleDeclaration(localStyles);
			StyleWrapper wrapper = new StyleWrapper(style, Integer.MAX_VALUE, 0);
			return wrapper;
		} catch (IOException ex) {
			engine.handleExceptions(ex);
		}
		return null;
	}

	/**
	 * Implementation based on {@link ViewCSSImpl#getComputedStyle(CSSStyleSheet, Element, String)}
	 * 
	 * Returns the StyleWrappers instead of a StyleDeclaration
	 */
	private List<StyleWrapper> getStyleWrappers(CSSStyleSheet styleSheet, Element elt, String pseudoElt, int position) {
		List<StyleWrapper> styleDeclarations = new ArrayList<StyleWrapper>();
		CSSRuleList ruleList = styleSheet.getCssRules();
		int length = ruleList.getLength();
		for(int i = 0; i < length; i++) {
			CSSRule rule = ruleList.item(i);
			if(rule.getType() == CSSRule.STYLE_RULE) {
				CSSStyleRule styleRule = (CSSStyleRule)rule;
				if(rule instanceof ExtendedCSSRule) {
					ExtendedCSSRule r = (ExtendedCSSRule)rule;
					SelectorList selectorList = r.getSelectorList();
					// Loop for SelectorList
					int l = selectorList.getLength();
					for(int j = 0; j < l; j++) {
						Selector selector = selectorList.item(j);
						if(selector instanceof ExtendedSelector) {
							ExtendedSelector extendedSelector = (ExtendedSelector)selector;
							if(extendedSelector.match(elt, pseudoElt)) {
								CSSStyleDeclaration style = styleRule.getStyle();
								int specificity = extendedSelector.getSpecificity();
								StyleWrapper wrapper = new StyleWrapper(style, specificity, position++);
								styleDeclarations.add(wrapper);
							}
						} else {
							// TODO : selector is not batik ExtendedSelector,
							// Manage this case...
						}
					}
				} else {
					// TODO : CSS rule is not ExtendedCSSRule,
					// Manage this case...
				}
			}
		}

		return styleDeclarations;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Unsupported
	 * TODO : Do we need an implementation ?
	 */
	public DocumentView getDocument() {
		return null;
	}
}
