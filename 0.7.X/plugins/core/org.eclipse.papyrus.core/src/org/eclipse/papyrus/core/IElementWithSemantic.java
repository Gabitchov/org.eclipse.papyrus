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
package org.eclipse.papyrus.core;

/**
 * 
 * all implementation is used to give the semantic element form a wrapper
 *
 * the implementation can call method getAdapter for example
 * for notation element return semantic element, for edit part return the semantic
 * element and not the view...
 */
public interface IElementWithSemantic {

	/**
	 * return the semantic element linked to this wrapper
	 * @param wrapper an object that wrapped or are linked to a semantic element <B>cannot be null</B>
	 * @return null or the semantic element
	 */
	public Object getSemanticElement(Object wrapper);
}
