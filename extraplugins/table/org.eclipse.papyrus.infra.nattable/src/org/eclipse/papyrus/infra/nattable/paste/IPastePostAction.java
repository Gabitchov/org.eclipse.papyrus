/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.paste;

import java.util.Map;

import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;

/**
 * Common interface for paste post actions
 * 
 * @author vl222926
 * 
 */

public interface IPastePostAction {

	/**
	 * 
	 * @param postActionId
	 *        the id of the post action
	 * @return
	 *         <code>true</code> if this id is managed by the PostAction
	 */
	public boolean accept(final String postActionId);

	/**
	 * This method will be called one time by new pasted axis
	 * 
	 * @param tableManager
	 *        the table manager
	 * @param postActionId
	 *        the post action id
	 * @param editedElement
	 *        the edited element
	 * @param sharedMap
	 *        the map where the class managing the paste and the set value can store interesting information
	 * 
	 * 
	 * 
	 */
	public void doPostAction(final INattableModelManager tableManager, final String postActionId, final Object editedElement, final Map<Object, Object> sharedMap);


	/**
	 * This method will be called one time, at the end of the paste action
	 * 
	 * @param tableManager
	 *        the table manager
	 * @param postActionId
	 *        the post action id
	 * @param sharedMap
	 *        the map where the class managing the paste and the set value can store interesting information
	 */
	public void doAfterAddPastedElementCommand(final INattableModelManager tableManager, final String postActionId, final Map<Object, Object> sharedMap);

}
