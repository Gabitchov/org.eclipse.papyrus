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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.handlers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.command.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.ui.PlatformUI;

/**
 * This abstract command handler:
 * - calculates the current selection
 * - calculates the visibility and enablement based on command executability
 * - executes the command in Papyrus command stack
 * 
 */
public abstract class GraphicalCommandHandler extends AbstractHandler {

	protected abstract Command getCommand() throws ExecutionException;

	/**
	 * Iterate over current selection and build a list of the {@link IGraphicalEditPart} contained in
	 * the selection.
	 * 
	 * @return the currently selected {@link IGraphicalEditPart}
	 */
	protected List<IGraphicalEditPart> getSelectedElements() {
		List<IGraphicalEditPart> editparts = new ArrayList<IGraphicalEditPart>();

		ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
		if(selection instanceof IStructuredSelection) {

			IStructuredSelection structuredSelection = (IStructuredSelection)selection;

			Iterator<?> it = structuredSelection.iterator();
			while(it.hasNext()) {
				Object object = it.next();
				if(object instanceof IGraphicalEditPart) {
					editparts.add((IGraphicalEditPart)object);
				}
			}

		} else if(selection instanceof IGraphicalEditPart) {
			editparts.add((IGraphicalEditPart)selection);
		}

		return editparts;
	}

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return null
	 * @throws ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		TransactionalEditingDomain editingDomain = getEditingDomain();
		if(editingDomain != null) {
			editingDomain.getCommandStack().execute(new GEFtoEMFCommandWrapper(getCommand()));
		}

		return null;
	}

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#isEnabled()
	 * 
	 * @return true is the command can be executed
	 */
	public boolean isEnabled() {

		try {
			if(getCommand().canExecute()) {
				return true;
			}
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * 
	 * @return true if the command can be executed
	 */
	public boolean isVisible() {
		try {
			if(getCommand().canExecute()) {
				return true;
			}
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * Retrieves the TransactionalEditingDomain
	 * 
	 * @return the editing domain (can be null)
	 */
	protected TransactionalEditingDomain getEditingDomain() {
		ServiceUtilsForActionHandlers serviceUtils = new ServiceUtilsForActionHandlers();
		TransactionalEditingDomain editingDomain = null;
		try {
			editingDomain = serviceUtils.getTransactionalEditingDomain();

		} catch (ServiceException e) {
			Activator.log.error(e);
		}

		return editingDomain;
	}
}
