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
package org.eclipse.papyrus.prototype.infra.gmfdiag.css.engine.selector;

import java.util.LinkedList;
import java.util.List;

import org.w3c.css.sac.Selector;
import org.w3c.css.sac.SelectorList;


public class CSSXSelectorList implements SelectorList {

	private List<Selector> selectors = new LinkedList<Selector>();

	public int getLength() {
		return selectors.size();
	}

	public Selector item(int index) {
		return selectors.get(index);
	}

	public void addSelector(Selector selector) {
		selectors.add(selector);
	}
}
