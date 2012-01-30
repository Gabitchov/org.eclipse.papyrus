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

import java.util.Set;

import org.eclipse.e4.ui.css.core.impl.sac.ExtendedSelector;
import org.w3c.dom.Element;


public class CSSXSelector implements ExtendedSelector {

	public short getSelectorType() {
		return 1001;
	}

	public boolean match(Element e, String pseudoE) {
		return true;
	}

	public int getSpecificity() {
		return 0;
	}

	public void fillAttributeSet(Set attrSet) {

	}

}
