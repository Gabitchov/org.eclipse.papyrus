/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.widgets.util;

import java.util.List;

/**
 * this interface is used to reveal element that are given in parameter. Example
 * of the use case: the class that implements this interface can be a diagram
 * that select all editparts that are linked to the given list of semantic
 * element
 * 
 */
public interface IRevealSemanticElement {

	/**
	 * reveal all elements that represent an element in the given list.
	 * 
	 * @param elementList
	 *        list of semantic element that we want to reveal, <B> cannot be
	 *        null</B>
	 */
	public void revealSemanticElement(List<?> elementList);
}
