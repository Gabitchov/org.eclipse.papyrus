package org.eclipse.papyrus.prototype.infra.gmfdiag.css.engine.enginecopy;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.e4.ui.css.core.dom.ExtendedCSSRule;
import org.eclipse.e4.ui.css.core.impl.dom.ViewCSSImpl;
import org.eclipse.e4.ui.css.core.impl.sac.ExtendedSelector;
import org.w3c.css.sac.Selector;
import org.w3c.css.sac.SelectorList;
import org.w3c.dom.Element;
import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSRuleList;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSStyleRule;
import org.w3c.dom.css.CSSStyleSheet;
import org.w3c.dom.css.DocumentCSS;
import org.w3c.dom.stylesheets.StyleSheetList;


@SuppressWarnings("restriction")
public class ExtendedViewCSSImpl extends ViewCSSImpl {

	public ExtendedViewCSSImpl(DocumentCSS documentCSS) {
		super(documentCSS);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Implementation based on {@link ViewCSSImpl#getComputedStyle(Element, String)} The base implementations returns the first CSSStyleDeclaration.
	 * 
	 * When a StyleDeclaration is found in a StyleSheet, it is added to a list of declarations.
	 * Then, these declarations are merged
	 */
	@Override
	public CSSStyleDeclaration getComputedStyle(Element elt, String pseudo) {
		StyleSheetList styleSheetList = documentCSS.getStyleSheets();

		List<StyleWrapper> declarations = new ArrayList<StyleWrapper>();

		int l = styleSheetList.getLength();
		for(int i = 0; i < l; i++) {
			CSSStyleSheet styleSheet = (CSSStyleSheet)styleSheetList.item(i);
			List<StyleWrapper> styleWrappers = getStyleWrappers(styleSheet, elt, pseudo);
			declarations.addAll(styleWrappers);
		}

		return new CSSComputedStyleImpl(declarations);
	}

	/**
	 * Implementation based on {@link ViewCSSImpl#getComputedStyle(CSSStyleSheet, Element, String)}
	 * 
	 * Returns the StyleWrappers instead of a StyleDeclaration
	 */
	private List<StyleWrapper> getStyleWrappers(CSSStyleSheet styleSheet, Element elt, String pseudoElt) {
		List<StyleWrapper> styleDeclarations = new ArrayList<StyleWrapper>();
		CSSRuleList ruleList = styleSheet.getCssRules();
		int length = ruleList.getLength();
		int position = 0;
		for(int i = 0; i < length; i++) {
			CSSRule rule = ruleList.item(i);
			switch(rule.getType()) {
			case CSSRule.STYLE_RULE:
			{
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
		}

		return styleDeclarations;
	}
}
