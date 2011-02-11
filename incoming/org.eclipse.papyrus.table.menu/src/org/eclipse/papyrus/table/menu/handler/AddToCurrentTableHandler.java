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
package org.eclipse.papyrus.table.menu.handler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.table.menu.actions.AddToCurrentTableAction;
import org.eclipse.ui.PlatformUI;

/**
 * 
 * 
 * This handler is used to add element in a open table
 * 
 * @deprecated : a drop action provided by the Model Explorer should replace this action
 */
@Deprecated
public class AddToCurrentTableHandler extends org.eclipse.papyrus.diagram.menu.actions.handlers.AbstractGraphicalCommandHandler {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public AddToCurrentTableHandler() {
		super(""); //$NON-NLS-1$
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.menu.actions.handlers.AbstractGraphicalCommandHandler#getCommand()
	 * 
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected Command getCommand() throws ExecutionException {
		AddToCurrentTableAction action = new AddToCurrentTableAction(getSelection());
		return action.getCommand();
	}

	/**
	 * 
	 * @return
	 *         the selected element
	 */
	protected List<EObject> getSelection() {
		List<EObject> selectedElements = new ArrayList<EObject>();
		ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
		if(selection instanceof IStructuredSelection) {

			IStructuredSelection structuredSelection = (IStructuredSelection)selection;

			Iterator<?> it = structuredSelection.iterator();
			while(it.hasNext()) {
				Object object = it.next();
				if(object instanceof IAdaptable) {
					EObject currentEObject = (EObject)((IAdaptable)object).getAdapter(EObject.class);

					if(currentEObject != null) {
						selectedElements.add(currentEObject);
					}
				}

			}
		}
		return selectedElements;
	}
}
