/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.newchild;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

/**
 * This listener is used to launch the command associated to a menu
 *
 */
class CreationMenuListener implements SelectionListener {
	protected TransactionalEditingDomain	editingDomain;
	protected Command cmd;
	
	/**
	 * 
	 * Constructor.
	 *
	 * @param cmd the command associated to the menu
	 * @param editingDomain the editing domain needed to execute the command
	 */
	public CreationMenuListener(Command cmd ,TransactionalEditingDomain	editingDomain) {
		this.cmd= cmd;
		this.editingDomain=editingDomain;
	}
	/**
	 * 
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 *
	 * @param e
	 */
	public void widgetSelected(SelectionEvent e) {
		editingDomain.getCommandStack().execute(cmd);
	}
	/**
	 * 
	 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
	 *
	 * @param e
	 */
	public void widgetDefaultSelected(SelectionEvent e) {
		editingDomain.getCommandStack().execute(cmd);
	}



}