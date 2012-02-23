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


public class ExtendedCSSRuleList extends LinkedList<CSSRule> implements CSSRuleList {

	private static final long serialVersionUID = 1L;

	public ExtendedCSSRuleList() {

	}

	public ExtendedCSSRuleList(CSSRuleList listToCopy) {
		for(int i = 0; i < listToCopy.getLength(); i++) {
			add(listToCopy.item(i));
		}
	}

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
