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
package org.eclipse.papyrus.table.menu.handler.states;

import org.eclipse.jface.commands.ToggleState;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

/**
 * Abstract class for the command using toggle state
 * In order refresh command state, this class adds a listener on the SelectionService
 * 
 * 
 */
public abstract class AbstractToggleStateProvider extends ToggleState implements ISelectionListener {


	/** the selection service */
	private ISelectionService serv = null;

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public AbstractToggleStateProvider() {
		addSelectionListener();
		refreshState();
	}

	/**
	 * add a listener on the selection service
	 */
	protected void addSelectionListener() {
		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				serv = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();
				if(serv != null) {
					//serv.addSelectionListener(this);
					serv.addSelectionListener(AbstractToggleStateProvider.this);
				}
			}
		});

	}

	/**
	 * 
	 * @see org.eclipse.core.commands.State#dispose()
	 * 
	 */
	@Override
	public void dispose() {
		if(this.serv != null) {
			this.serv.removeSelectionListener(this);
		}
		super.dispose();
	}

	/**
	 * 
	 * @see org.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
	 * 
	 * @param part
	 * @param selection
	 */
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		refreshState();
	}

	/**
	 * Refresh the status of the command
	 */
	protected abstract void refreshState();
}
