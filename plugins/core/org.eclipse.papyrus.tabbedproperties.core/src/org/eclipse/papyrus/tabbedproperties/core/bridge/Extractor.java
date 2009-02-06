/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.tabbedproperties.core.bridge;

import org.eclipse.uml2.uml.Element;

/**
 * this interface defines the transformation of an element into text
 * 
 * @author Patrick Tessier
 * 
 */
public interface Extractor {

	/**
	 * transform this part of model into text
	 * 
	 * @param element
	 *            the element to transform
	 * @return the string that represent the element
	 */
	public String extract(Element element);

}
