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

import org.w3c.dom.Element;
import org.w3c.dom.css.CSSValue;


/**
 * An interface for Lazy CSS Engine
 * 
 * The Engine doesn't modify an Element. Instead, for an element, it returns the
 * value of the required property.
 * 
 * @author Camille Letavernier
 */
public interface LazyCSSEngine {

	public CSSValue retrievePropertyValue(Element element, String property);

}
