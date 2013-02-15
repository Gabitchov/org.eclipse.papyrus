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
package org.eclipse.papyrus.infra.nattable.common.manager;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.nattable.common.messages.Messages;


//FIXME : the extension point should be declared on an Abstract class instead an Interface (to add method easily?)=
public interface ICellManager {

	/**
	 * The string displayed for Not_AVAILABLE
	 */
	public static final String NOT_AVALAIBLE = Messages.ICellManager_NotAvailable;

	public boolean handles(final Object obj1, final Object obj2);

	public Object getValue(final Object obj1, final Object obj2);

	public void setValue(final EditingDomain domain, final Object rowElement, final Object lineElement, final Object newValue);

	public boolean isCellEditable(final Object obj1, final Object obj2);

	public Command getSetValueCommand(final EditingDomain domain, final Object rowElement, final Object lineElement, final Object newValue);

}
