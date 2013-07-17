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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.manager.cell;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.messages.Messages;

/**
 * The interface to implements for a cell manager
 * 
 * @author Vincent Lorenzo
 * 
 */
public interface ICellManager {

	/**
	 * The string displayed for Not_AVAILABLE
	 */
	public static final String NOT_AVALAIBLE = Messages.ICellManager_NotAvailable;

	/**
	 * 
	 * @param columnElement
	 *        the column element as described in the model (you must ignore the invert axis)
	 * @param rowElement
	 *        the row element as described in the model (you must ignore the invert axis)
	 * @return
	 */
	public boolean handles(final Object columnElement, final Object rowElement);


	/**
	 * 
	 * @param columnElement
	 *        the column element as described in the model (you must ignore the invert axis)
	 * @param rowElement
	 *        the row element as described in the model (you must ignore the invert axis)
	 * @param tableManager
	 *        the table manager
	 * @return
	 *         the value of the cell or {@value #NOT_AVALAIBLE} if the cell is meaningless for the couple of parameters
	 * 
	 *         THIS METHOD MUST NOT BE USED IN REPLACEMENT OF A SPECIFIC LABEL PROVIDER
	 */
	public Object getValue(final Object columnElement, final Object rowElement, final INattableModelManager tableManager);

	/**
	 * Set the newValue to the intersection of the 2 objects
	 * 
	 * @param domain
	 *        the editing domain
	 * @param columnElement
	 *        the column element as described in the model (so you must ignore the invert axis)
	 * @param rowElement
	 *        the row element as described in the model (you must ignore the invert axis)
	 * @param newValue
	 *        the new value
	 * @param tableManager
	 *        the table manager
	 */
	public void setValue(final TransactionalEditingDomain domain, final Object columnElement, final Object rowElement, final Object newValue, final INattableModelManager tableManager);

	/**
	 * 
	 * @param columnElement
	 *        the column element as described in the model (you must ignore the invert axis)
	 * @param rowElement
	 *        the row element as described in the model (you must ignore the invert axis)
	 * @return
	 *         <code>true</code> if the intersection of the 2 objects is editable
	 */
	public boolean isCellEditable(final Object columnElement, final Object rowElement);

	/**
	 * 
	 * @param domain
	 *        the editing domain
	 * @param columnElement
	 *        the column element as described in the model (you must ignore the invert axis)
	 * @param rowElement
	 *        the row element as described in the model (you must ignore the invert axis)
	 * @param newValue
	 *        the new value to set to the intersection of these 2 objects
	 * @param tableManager
	 * @return
	 *         the command to set the value
	 */
	public Command getSetValueCommand(final TransactionalEditingDomain domain, final Object columnElement, final Object rowElement, final Object newValue, final INattableModelManager tableManager);
}
