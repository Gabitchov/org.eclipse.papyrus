package org.eclipse.papyrus.diagram.common.editparts;

import java.util.Iterator;

import org.eclipse.gef.editparts.AbstractEditPart;

/**
 * All edit part that implements this interface make accessible the set of eventListener
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
