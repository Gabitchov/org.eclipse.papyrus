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
package org.eclipse.papyrus.infra.gmfdiag.css.lists;

import java.util.Collection;
import java.util.LinkedList;

import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSRuleList;

/**
 * More usable implementation for CSSRuleList
 * 
 * @author Camille Letavernier
 */
public class ExtendedCSSRuleList extends LinkedList<CSSRule> implements CSSRuleList {

	private static final long serialVersionUID = 1L;

	/**
	 * Builds an empty ExtendedCSSRuleList
	 */
	public ExtendedCSSRuleList() {

	}

	/**
	 * Builds an ExtendedCSSRuleList by making a copy of a CSSRuleList
	 * 
	 * @param listToCopy
	 *        The CSSRuleList to copy
	 */
	public ExtendedCSSRuleList(CSSRuleList listToCopy) {
		for(int i = 0; i < listToCopy.getLength(); i++) {
			add(listToCopy.item(i));
		}
	}

	/**
	 * Builds an ExtendedCSSRuleList by making a copy of a Collection of
	 * CSSRules
	 * 
	 * @param listToCopy
	 *        The list of CSSRule to copy
	 */
	public ExtendedCSSRuleList(Collection<? extends CSSRule> listToCopy) {
		super(listToCopy);
	}

	public int getLength() {
		return size();
	}

	public CSSRule item(int index) {
		return get(index);
	}

}
