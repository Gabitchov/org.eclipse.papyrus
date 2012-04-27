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
package org.eclipse.papyrus.infra.gmfdiag.css.provider;

import java.text.Collator;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.e4.ui.css.core.impl.dom.CSSStyleRuleImpl;
import org.eclipse.e4.ui.css.core.impl.sac.CSSClassConditionImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.widgets.providers.AbstractStaticContentProvider;
import org.w3c.css.sac.CombinatorCondition;
import org.w3c.css.sac.Condition;
import org.w3c.css.sac.ConditionalSelector;
import org.w3c.css.sac.DescendantSelector;
import org.w3c.css.sac.ElementSelector;
import org.w3c.css.sac.Selector;
import org.w3c.css.sac.SiblingSelector;
import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSStyleSheet;

/**
 * A ContentProvider which retrieves the available CSS Classes to be applied
 * on the selected element. The classes are retrieved from the current css
 * engine's stylesheets.
 * 
 * The resulting classes are sorted alphabetically.
 * 
 * @author Camille Letavernier
 * 
 */
@SuppressWarnings("restriction")
public class CSSClassContentProvider extends AbstractStaticContentProvider {

	private String elementName;

	private ExtendedCSSEngine engine;

	/**
	 * 
	 * @param elementName
	 *        The localName of the element (Typically, the semantic metaclass name or diagram type)
	 * @param engine
	 *        The stylesheets of this CSS Engine will be used to retrieve compatible CSS Classes
	 */
	public CSSClassContentProvider(String elementName, ExtendedCSSEngine engine) {
		this.elementName = elementName;
		this.engine = engine;
	}

	public Object[] getElements() {
		return getAvailableClasses().toArray();
	}

	/**
	 * Returns a sorted collection of CSS Classes compatible with the element
	 * 
	 * @return
	 */
	public Collection<String> getAvailableClasses() {
		Set<String> result = new TreeSet<String>(Collator.getInstance());

		for(org.w3c.dom.stylesheets.StyleSheet stylesheet : engine.getAllStylesheets()) {
			if(stylesheet instanceof CSSStyleSheet) {
				CSSStyleSheet cssStylesheet = (CSSStyleSheet)stylesheet;
				for(int i = 0; i < cssStylesheet.getCssRules().getLength(); i++) {
					CSSRule cssRule = cssStylesheet.getCssRules().item(i);
					if(cssRule instanceof CSSStyleRuleImpl) {
						CSSStyleRuleImpl rule = (CSSStyleRuleImpl)cssRule;

						for(int j = 0; j < rule.getSelectorList().getLength(); j++) {
							Selector selector = rule.getSelectorList().item(j);

							result.addAll(findClassesFromSelector(selector));
						}
					}
				}
			}
		}

		return result;
	}

	private List<String> findClassesFromSelector(Selector selector) {
		List<String> result = new LinkedList<String>();
		if(selector instanceof ConditionalSelector) {
			result.addAll(findClassesFromSelector((ConditionalSelector)selector));
		} else if(selector instanceof DescendantSelector) { //A B | A > B
			result.addAll(findClassesFromSelector(((DescendantSelector)selector).getSimpleSelector()));
			result.addAll(findClassesFromSelector(((DescendantSelector)selector).getAncestorSelector()));
		} else if(selector instanceof SiblingSelector) { //A + B
			result.addAll(findClassesFromSelector(((SiblingSelector)selector).getSelector()));
			result.addAll(findClassesFromSelector(((SiblingSelector)selector).getSiblingSelector()));
		}
		return result;
	}

	private List<String> findClassesFromSelector(ConditionalSelector selector) {
		List<String> result = new LinkedList<String>();

		Selector simpleSelector = selector.getSimpleSelector();

		if(simpleSelector instanceof ElementSelector) {
			ElementSelector elementSelector = (ElementSelector)simpleSelector;
			String localName = elementSelector.getLocalName();
			if("*".equals(localName) || "*".equals(elementName) || elementName.equals(localName) || localName == null) {
				Condition condition = selector.getCondition();
				result.addAll(findClassesFromCondition(condition));
			}
		}

		return result;
	}

	private List<String> findClassesFromCondition(Condition condition) {
		if(condition instanceof CSSClassConditionImpl) {
			return Collections.singletonList(((CSSClassConditionImpl)condition).getValue());
		} else if(condition instanceof CombinatorCondition) {
			CombinatorCondition combinatorCondition = (CombinatorCondition)condition;
			List<String> result = new LinkedList<String>();
			result.addAll(findClassesFromCondition(combinatorCondition.getFirstCondition()));
			result.addAll(findClassesFromCondition(combinatorCondition.getSecondCondition()));
			return result;
		}

		return Collections.emptyList();
	}

}
