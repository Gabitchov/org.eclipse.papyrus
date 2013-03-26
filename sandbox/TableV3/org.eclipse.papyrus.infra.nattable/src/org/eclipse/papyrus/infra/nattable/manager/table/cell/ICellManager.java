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
package org.eclipse.papyrus.infra.nattable.manager.table.cell;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.nattable.messages.Messages;


//FIXME : the extension point should be declared on an Abstract class instead an Interface (to add method easily?)=
public interface ICellManager {

	/**
	 * The string displayed for Not_AVAILABLE
	 */
	public static final String NOT_AVALAIBLE = Messages.ICellManager_NotAvailable;


	public boolean handles(final Object obj1, final Object obj2);//FIXME : add the table as parameter

	public boolean handlersAxisElement(final Object obj);

	/**
	 * 
	 * @param axisElement1
	 *        one of the axis
	 * @param axisElement2
	 *        the other axis
	 * @return
	 *         the value of the cell or {@value #NOT_AVALAIBLE} if the cell is meaningless for the couple of parameters
	 * 
	 *         THIS METHOD MUST NOT BE USED IN REPLACEMENT OF A SPECIFIC LABEL PROVIDER
	 */
	public Object getValue(final Object axisElement1, final Object axisElement2);

	public void setValue(final EditingDomain domain, final Object obj1, final Object obj2, final Object newValue);

	public boolean isCellEditable(final Object obj1, final Object obj2);

	public Command getSetValueCommand(final EditingDomain domain, final Object obj1, final Object obj2, final Object newValue);

	//	public ICellEditor getCellEditor(final Table table, final Object obj1);


}
