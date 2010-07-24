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


import org.eclipse.gmf.runtime.diagram.ui.actions.internal.DeleteFromDiagramAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.diagram.common.Messages;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

/**
 * 
 * This class provides the "Delete From Diagram" for the popup menu
 * 
 */
public class DeleteFromDiagramHandler implements IActionDelegate {

	/** the workbenchpage */
	private IWorkbenchPage workbenchPage = null;

	/** the delete from model action */
	private DeleteFromDiagramAction myAction = null;

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public DeleteFromDiagramHandler() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 * 
	 * @param action
	 */
	public void run(IAction action) {
		if(myAction != null && myAction.isEnabled()) {
			myAction.run();
		}
		myAction = null;

	}

	public void selectionChanged(IAction action, ISelection selection) {
		this.workbenchPage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		this.myAction = new DeleteFromDiagramAction(workbenchPage);
		myAction.init();
		action.setEnabled(myAction.isEnabled());
		if(selection instanceof StructuredSelection) {
			if(((StructuredSelection)selection).size() > 1) {
				action.setText(Messages.DeleteFromDiagramHandler_HideTextPlural);
				action.setToolTipText(Messages.DeleteFromDiagramHandler_HideToolTipPlural);
			} else {
				action.setText(Messages.DeleteFromDiagramHandler_HideToolTipSingular);
				action.setToolTipText(Messages.DeleteFromDiagramHandler_HideTextSingular);
			}
		}

	}

}
