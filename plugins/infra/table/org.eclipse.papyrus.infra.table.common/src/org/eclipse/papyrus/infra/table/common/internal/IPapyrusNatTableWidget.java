/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.infra.table.common.internal;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.widgets.nattable.INatTableWidget;

/**
 * 
 * This interface is used to add some useful method to INatTableWidget
 * 
 * 
 */
@Deprecated
/**
 * I think this interface is deprecated, because the 2 methods provided by this interfaces are obsolete. 
 * Now we use TriggerListener in the table, so the command for the synchronization are executed in a best way
 * @author VL222926
 *
 */
public interface IPapyrusNatTableWidget extends INatTableWidget {

	/**
	 * This method allow to add elements in the table without execute the command in the command stack
	 * 
	 * @param elementsToAdd
	 *        the list of the elements to add
	 */
	@Deprecated
	public void addRowsOutOfCommandStack(List<EObject> elementsToAdd);

	/**
	 * This method allow to remove elements from the table without execute the command in the command stack
	 * 
	 * @param elementsToDelete
	 *        the list of the element to delete
	 */
	@Deprecated
	public void removeRowsOutOfCommandStack(List<EObject> elementsToDelete);
}
