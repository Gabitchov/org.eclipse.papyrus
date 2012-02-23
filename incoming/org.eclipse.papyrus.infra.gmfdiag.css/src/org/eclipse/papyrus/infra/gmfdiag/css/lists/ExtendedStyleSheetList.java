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

import org.w3c.dom.stylesheets.StyleSheet;
import org.w3c.dom.stylesheets.StyleSheetList;


public class ExtendedStyleSheetList extends LinkedList<StyleSheet> implements StyleSheetList {

	private static final long serialVersionUID = 1L;

	public ExtendedStyleSheetList() {

	}

	public ExtendedStyleSheetList(StyleSheetList listToCopy) {
		for(int i = 0; i < listToCopy.getLength(); i++) {
			add(listToCopy.item(i));
		}
	}

	public ExtendedStyleSheetList(Collection<? extends StyleSheet> listToCopy) {
		super(listToCopy);
	}

	public int getLength() {
		return size();
	}

	public StyleSheet item(int index) {
		return get(index);
	}

}
