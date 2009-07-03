/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
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
package org.eclipse.papyrus.diagram.common.helper;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.uml2.uml.Element;

/**
 * The Class LinkMappingHelper is used as a declaration of contract. This class is used to express the mapping of link at semantic level. for a semantic what is the source what is the target?
 */
public class LinkMappingHelper {

	/**
	 * Gets the source.
	 * 
	 * @param link
	 *            the link
	 * 
	 * @return the source
	 */
	public static Collection<?> getSource(Element link) {
		return Collections.emptyList();
	}

	/**
	 * Gets the target.
	 * 
	 * @param link
	 *            the link
	 * 
	 * @return the target
	 */
	public static Collection<?> getTarget(Element link) {
		return Collections.emptyList();
	}
}
