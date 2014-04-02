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
package org.eclipse.papyrus.infra.gmfdiag.menu.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gmf.runtime.common.ui.action.ActionManager;
import org.eclipse.gmf.runtime.common.ui.action.IActionWithProgress;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IEditorPart;

/**
 * 
 * 
 */
public abstract class AbstractDiagramActionHandler extends AbstractDiagramHandler {

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final ActionManager manager = getActionManager();
		if(manager != null) {
			final IAction globalActionHandler = getGlobalActionHandler();
			if(globalActionHandler instanceof IActionWithProgress) {
				((IActionWithProgress)globalActionHandler).refresh();
				manager.run(((IActionWithProgress)globalActionHandler));
			} else if(globalActionHandler !=null){
				globalActionHandler.runWithEvent(null);
				
			}
		}
		return null;
	}

	/**
	 * 
	 * @return
	 *         the action to execute
	 */
	private IAction getGlobalActionHandler() {
		final IDiagramWorkbenchPart workbenchPart = getDiagramWorkbenchPart();
		if(workbenchPart instanceof IEditorPart) {
			final IEditorPart editor = (IEditorPart)workbenchPart;
			IAction action = editor.getEditorSite().getActionBars().getGlobalActionHandler(getActionId());
			return action;
		}
		return null;
	}

	/**
	 * 
	 * @return
	 *         the action manager to use
	 */
	private ActionManager getActionManager() {
		IDiagramWorkbenchPart part = getDiagramWorkbenchPart();
		if(part != null) {
			return (ActionManager)part.getAdapter(ActionManager.class);
		}
		return null;
	}


	/**
	 * 
	 * @return
	 *         the id of the action to execute
	 */
	protected abstract String getActionId();

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#setEnabled(java.lang.Object)
	 * 
	 * @param evaluationContext
	 */
	@Override
	public void setEnabled(Object evaluationContext) {
		final IAction action = getGlobalActionHandler();
		if(action instanceof IActionWithProgress) {
			((IActionWithProgress)action).refresh();
			setBaseEnabled(((IActionWithProgress)action).isRunnable());
		}  else if(action !=null) {
			setBaseEnabled(action.isEnabled());
		} else {
			setBaseEnabled(false);
		}
	}
}
