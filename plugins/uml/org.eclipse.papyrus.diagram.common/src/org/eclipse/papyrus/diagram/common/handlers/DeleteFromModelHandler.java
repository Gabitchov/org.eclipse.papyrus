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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.diagram.common.actions.DeleteFromModelAction;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;


/**
 * 
 * This class provides
 * <ul>
 * <li>keybinding for Delete From Model action</li>
 * <li>the "Delete From Model" action for the popup menu</li>
 * </ul>
 * 
 * 
 */
public class DeleteFromModelHandler extends AbstractHandler implements IObjectActionDelegate {

	/** the workbenchpage */
	private IWorkbenchPage workbenchPage = null;

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * 
	 */
	public Object execute(ExecutionEvent event) {

		this.workbenchPage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		DeleteFromModelAction action = new DeleteFromModelAction(workbenchPage);
		action.init();
		if(action.isEnabled()) {
			action.run();
		}

		return null;
	}

	/**
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 * 
	 * @param action
	 */
	public void run(IAction action) {
		this.execute(null);

	}

	/**
	 * 
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
	 * 
	 * @param action
	 * @param selection
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * @see org.eclipse.ui.IObjectActionDelegate#setActivePart(org.eclipse.jface.action.IAction, org.eclipse.ui.IWorkbenchPart)
	 * 
	 * @param action
	 * @param targetPart
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// TODO Auto-generated method stub

	}
}
