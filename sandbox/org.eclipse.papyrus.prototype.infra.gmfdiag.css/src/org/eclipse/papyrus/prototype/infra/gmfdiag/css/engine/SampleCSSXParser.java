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

import org.eclipse.e4.ui.css.core.css2.CSS2PrimitiveValueImpl;
import org.eclipse.e4.ui.css.core.dom.CSSProperty;
import org.eclipse.e4.ui.css.core.impl.dom.CSSPropertyImpl;
import org.eclipse.e4.ui.css.core.impl.dom.CSSRuleListImpl;
import org.eclipse.e4.ui.css.core.impl.dom.CSSStyleDeclarationImpl;
import org.eclipse.e4.ui.css.core.impl.dom.CSSStyleRuleImpl;
import org.eclipse.e4.ui.css.core.impl.dom.CSSStyleSheetImpl;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.engine.selector.CSSXSelector;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.engine.selector.CSSXSelectorList;
import org.w3c.css.sac.Selector;
import org.w3c.dom.css.CSSRuleList;
import org.w3c.dom.css.CSSStyleSheet;
import org.w3c.dom.css.CSSValue;

/**
 * 
 * CSSX Proof of Concept
 * The parser doesn't actually parse anything
 * It simply returns a Java implementation of the CSS Rules
 * 
 * @author Camille Letavernier
 * 
 */
public class SampleCSSXParser {

	public CSSStyleSheet createStyleSheet() {
		CSSStyleSheetImpl s = new CSSStyleSheetImpl();

		CSSRuleList rules = createRuleList();

		s.setRuleList(rules);

		return s;
	}

	public CSSRuleList createRuleList() {
		CSSRuleListImpl rules = new CSSRuleListImpl();

		CSSXSelectorList selectorList = new CSSXSelectorList();

		Selector selector = new CSSXSelector();
		selectorList.addSelector(selector);

		CSSStyleRuleImpl rule = new CSSStyleRuleImpl(null, null, selectorList);
		rule.setStyle(createStyleDeclaration());
		rules.add(rule);

		return rules;
	}

	private CSSStyleDeclarationImpl createStyleDeclaration() {
		CSSStyleDeclarationImpl styleDeclaration = new CSSStyleDeclarationImpl(null);

		styleDeclaration.addProperty(createCSSProperty());

		return styleDeclaration;
	}

	private CSSProperty createCSSProperty() {
		CSSValue value = new CSS2PrimitiveValueImpl("red") {

			@Override
			public String getCssText() {
				return getStringValue();
			}
		};

		CSSPropertyImpl property = new CSSPropertyImpl("lineColor", value, false);
		return property;
	}
}
