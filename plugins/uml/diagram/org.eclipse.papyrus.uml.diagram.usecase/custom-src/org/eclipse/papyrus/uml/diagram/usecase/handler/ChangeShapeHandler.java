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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.usecase.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.ServiceUtilsForEditPart;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * This class is an abstract class in charge to transform a editpart into another editpart
 * 
 */
public abstract class ChangeShapeHandler extends AbstractHandler {

	protected TransactionalEditingDomain transactionalEditingDomain = null;

	protected org.eclipse.uml2.uml.Element selectedElement = null;

	public ChangeShapeHandler() {
		super();
	}

	protected abstract AbstractTransactionalCommand getChangeShapeCommand(final GraphicalEditPart editPart);

	/**
	 * 
	 * @return null or the selected editPart
	 */
	protected GraphicalEditPart getSelectedGraphicalEditpart() {
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (activeWorkbenchWindow!=null){
			ISelectionService selectionService = activeWorkbenchWindow.getSelectionService();
			ISelection selection = selectionService.getSelection();
			if(selection instanceof IStructuredSelection) {
				Object selectedobject = ((IStructuredSelection)selection).getFirstElement();
				if(selectedobject instanceof GraphicalEditPart) {
					return (GraphicalEditPart)selectedobject;
				}
			}			
		}
		return null;
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
		final GraphicalEditPart editPart = getSelectedGraphicalEditpart();
		ServiceUtilsForEditPart util = ServiceUtilsForEditPart.getInstance();
		try {
			transactionalEditingDomain = util.getTransactionalEditingDomain(editPart);
		} catch (Exception e) {
			System.err.println("impossible to get the Transactional Editing Domain " + e);
		}
		try {
			editPart.getEditingDomain().runExclusive(new Runnable() {

				public void run() {
					Display.getCurrent().asyncExec(new Runnable() {

						public void run() {
							AbstractTransactionalCommand command = getChangeShapeCommand(editPart);
							Request deleteViewRequest = new GroupRequest(RequestConstants.REQ_DELETE);
							Command deleteCommand = editPart.getCommand(deleteViewRequest);
							org.eclipse.emf.common.command.CompoundCommand compoundCommand = new org.eclipse.emf.common.command.CompoundCommand("change Shape"); //$NON-NLS-1$
							compoundCommand.append(new GMFtoEMFCommandWrapper(command));
							compoundCommand.append(new GEFtoEMFCommandWrapper(deleteCommand));
							editPart.getEditingDomain().getCommandStack().execute(compoundCommand);
						}
					});
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
