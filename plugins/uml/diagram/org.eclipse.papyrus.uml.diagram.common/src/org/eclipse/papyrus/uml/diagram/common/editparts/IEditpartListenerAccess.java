/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editparts;

import java.util.Iterator;

/**
 * All edit part that implements this interface make accessible the set of
 * eventListener
 * 
 * @see AbstractEditPart
 * 
 */
public interface IEditpartListenerAccess {

	/**
	 * Returns an iterator for the specified type of listener
	 * 
	 * @param clazz
	 *        the Listener type over which to iterate
	 * @return Iterator
	 */
	public Iterator getEventListenerIterator(Class clazz);
}
