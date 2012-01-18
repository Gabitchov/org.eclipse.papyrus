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

import java.util.Collection;
import java.util.Collections;

import org.eclipse.e4.ui.css.core.dom.properties.ICSSPropertyHandlerProvider;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.e4.ui.css.core.impl.dom.CSSComputedStyleImpl;
import org.w3c.dom.css.CSSStyleDeclaration;


@SuppressWarnings("restriction")
public class UMLPropertyHandlerProvider implements ICSSPropertyHandlerProvider {

	public Collection getCSSPropertyHandlers(String property) throws Exception {
		return Collections.singleton(new UMLPropertyHandler());
	}

	public CSSStyleDeclaration getDefaultCSSStyleDeclaration(CSSEngine engine, Object element, CSSStyleDeclaration newStyle, String pseudoE) throws Exception {
		return new CSSComputedStyleImpl(Collections.EMPTY_LIST);
	}

}
