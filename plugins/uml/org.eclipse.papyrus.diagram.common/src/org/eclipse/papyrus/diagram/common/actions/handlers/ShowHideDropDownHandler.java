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
package org.eclipse.papyrus.diagram.common.actions.handlers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.diagram.common.actions.AbstractShowHideAction;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;


/**
 * 
 * This handler can be used to do an action when the user clicks on the corresponding menu in the toolbar.
 * This class is necessary to have a pulldown menu in the toolbar.
 * Currently, nothing is done by this handler.
 * 
 * 
 */

public class ShowHideDropDownHandler extends AbstractHandler {

	/** the last executed action */
	public static AbstractShowHideAction lastAction = null;

	/** selected EditParts */
	private List<EditPart> selection = new ArrayList<EditPart>();

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public ShowHideDropDownHandler() {
		super();

	}


	/**
	 * Execute {@link #lastAction} if this action is not <code>null</code>
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		if(lastAction != null) {
			buildSelection();
			if(!selection.isEmpty()) {
				//				lastAction.setSelection(selection);
				//				lastAction.run(null);
			}
		}
		return null;
	}

	/**
	 * Fill {@link #selection}
	 */
	private void buildSelection() {
		this.selection.clear();
		ISelectionService selectionService = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();
		ISelection selectionTmp = selectionService.getSelection();
		if((selectionTmp != null) && (!selectionTmp.isEmpty())) {
			if(selectionTmp instanceof StructuredSelection) {
				Iterator<?> it = ((StructuredSelection)selectionTmp).iterator();
				while(it.hasNext()) {
					Object current = it.next();
					if(current instanceof EditPart) {
						EditPolicy editpolicy = ((EditPart)current).getEditPolicy(lastAction.getEditPolicyKey());
						if(editpolicy != null) {
							this.selection.add((EditPart)current);
						}
					}
				}
			}
		}
	}

}
