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
package org.eclipse.papyrus.uml.diagram.common.actions.handlers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.uml.diagram.common.actions.AbstractShowHideAction;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * 
 * Abstract Handler for the ShowHideActions
 * 
 */

abstract public class AbstractShowHideHandler extends AbstractHandler {

	/** the current action */
	private AbstractShowHideAction action = null;

	/** the EditPolicy key for this action */
	private final String editpolicy;

	/** the current selection */
	private final List<IGraphicalEditPart> selection = new ArrayList<IGraphicalEditPart>();

	/**
	 * 
	 * Constructor.
	 * 
	 * @param action
	 *        to execute
	 * @param key
	 *        the key representing the EditPolicy providing this action
	 */
	public AbstractShowHideHandler(AbstractShowHideAction action, String key) {
		this.action = action;
		this.editpolicy = key;
	}

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// buildSelection();
		if(!selection.isEmpty()) {
			this.action.setSelection(selection);
			this.action.run(null);
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#isEnabled()
	 * 
	 * @return
	 */
	@Override
	public boolean isEnabled() {
		buildSelection();
		return !this.selection.isEmpty();
	}

	/**
	 * Fill {@link #selection} with the EditPart owning the EditPolicy {@link #editpolicy}
	 */
	protected void buildSelection() {
		this.selection.clear();
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (activeWorkbenchWindow!=null){
			ISelectionService selectionService = activeWorkbenchWindow.getSelectionService();
			ISelection selectionTmp = selectionService.getSelection();
			if((selectionTmp != null) && (!selectionTmp.isEmpty())) {
				if(selectionTmp instanceof StructuredSelection) {
					Iterator<?> it = ((StructuredSelection)selectionTmp).iterator();
					while(it.hasNext()) {
						Object current = it.next();
						if(current instanceof IGraphicalEditPart) {
							EditPolicy editpolicy = ((IGraphicalEditPart)current).getEditPolicy(this.editpolicy);
							if(editpolicy != null) {
								this.selection.add((IGraphicalEditPart)current);
							}
						}
					}
				}
			}			
		}

	}
}
