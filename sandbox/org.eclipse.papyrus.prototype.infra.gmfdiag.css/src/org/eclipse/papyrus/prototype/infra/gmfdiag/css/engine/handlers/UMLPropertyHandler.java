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
package org.eclipse.papyrus.prototype.infra.gmfdiag.css.engine.handlers;

import org.eclipse.e4.ui.css.core.dom.properties.ICSSPropertyHandler;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.w3c.dom.Element;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSValue;


public class UMLPropertyHandler implements ICSSPropertyHandler {

	public boolean applyCSSProperty(Object element, String property, CSSValue value, String pseudo, CSSEngine engine) throws Exception {
		return true;
	}

	public String retrieveCSSProperty(Object element, String property, String pseudo, CSSEngine engine) throws Exception {
		//		System.out.println("Break");
		CSSStyleDeclaration style = engine.getViewCSS().getComputedStyle((Element)element, pseudo);
		CSSValue value = style.getPropertyCSSValue(property);
		if(value == null) {
			return null;
		}
		return value.getCssText();

		//		StyleSheetList styleSheets = engine.getDocumentCSS().getStyleSheets();
		//		for(int i = 0; i < styleSheets.getLength(); i++) {
		//			StyleSheet styleSheet = styleSheets.item(i);
		//			if(!styleSheet.getDisabled()) {
		//				if(styleSheet instanceof CSSStyleSheet) {
		//					CSSStyleSheet cssSheet = (CSSStyleSheet)styleSheet;
		//					CSSRuleList rules = cssSheet.getCssRules();
		//					for(int j = 0; j < rules.getLength(); j++) {
		//						CSSRule rule = rules.item(j);
		//						if (rule instanceof ExtendedCSSRule){
		//							ExtendedCSSRule cssRule = (ExtendedCSSRule)rule;
		//							SelectorList selectors = cssRule.getSelectorList();
		//							for (int k = 0; k < selectors.getLength(); k++){
		//								Selector selector = selectors.item(k);
		//								if (selector instanceof ExtendedSelector){
		//									ExtendedSelector cssSelector = (ExtendedSelector)selector;
		//									if (cssSelector.match(e, pseudo)){
		//										
		//									}
		//								}
		//							}
		//						}
		//					}
		//				}
		//			}
		//		}

		//		return "";
	}

}
