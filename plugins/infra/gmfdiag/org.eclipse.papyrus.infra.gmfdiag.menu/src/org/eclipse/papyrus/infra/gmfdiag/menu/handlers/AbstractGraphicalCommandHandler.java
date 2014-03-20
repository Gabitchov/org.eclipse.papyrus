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
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.menu.handlers;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForHandlers;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.ServiceUtilsForEditPart;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * This abstract command handler: - calculates the current selection -
 * calculates the visibility and enablement based on command executability -
 * executes the command in Papyrus command stack
 * 
 */
public abstract class AbstractGraphicalCommandHandler extends AbstractHandler {

	protected abstract Command getCommand();

	/**
	 * Iterate over current selection and build a list of the {@link IGraphicalEditPart} contained in the selection.
	 * 
	 * @return the currently selected {@link IGraphicalEditPart}
	 */
	protected List<IGraphicalEditPart> getSelectedElements() {
		List<IGraphicalEditPart> result = new LinkedList<IGraphicalEditPart>();
		for(Object element : getSelection()) {
			if(element instanceof IGraphicalEditPart) {
				result.add((IGraphicalEditPart)element);
			}
		}

		return result;
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
		try {
			ISelection selection = HandlerUtil.getCurrentSelection(event);
			this.selection = (selection instanceof IStructuredSelection) ? ((IStructuredSelection)selection).toList() : Collections.EMPTY_LIST;

			getEditingDomain(event).getCommandStack().execute(new GEFtoEMFCommandWrapper(getCommand()));
		} finally {
			// clear the selection
			this.selection = Collections.EMPTY_LIST;
		}

		return null;
	}

	protected TransactionalEditingDomain getEditingDomain(ExecutionEvent event) {
		try {
			return ServiceUtilsForHandlers.getInstance().getTransactionalEditingDomain(event);
		} catch (ServiceException ex) {
			return null;
		}
	}

	protected TransactionalEditingDomain getEditingDomain() {
		TransactionalEditingDomain editingDomain = null;
		for(IGraphicalEditPart editPart : getSelectedElements()) {
			try {
				editingDomain = ServiceUtilsForEditPart.getInstance().getTransactionalEditingDomain(editPart);
				if(editingDomain != null) {
					break;
				}
			} catch (ServiceException ex) {
				//Keep searching
			}
		}

		//TODO: From active editor?

		return editingDomain;
	}

	@Override
	public void setEnabled(Object evaluationContext) {
		if(evaluationContext instanceof IEvaluationContext) {
			Object selection = ((IEvaluationContext)evaluationContext).getDefaultVariable();
			if(selection instanceof Collection<?>) {
				this.selection = (selection instanceof List<?>) ? (List<?>)selection : new java.util.ArrayList<Object>((Collection<?>)selection);
				setBaseEnabled(computeEnabled());
				this.selection = Collections.EMPTY_LIST;
			}
		}
		super.setEnabled(evaluationContext);
	}

	protected boolean computeEnabled() {
		boolean result = false;

		Command command = getCommand();
		if(command != null) {
			result = getCommand().canExecute();
			command.dispose();
		}

		return result;
	}

	protected List<?> getSelection() {
		return selection;
	}

	private List<?> selection = Collections.EMPTY_LIST;

	/**
	 * 
	 * @return true if the command can be executed
	 */
	public boolean isVisible() {
		return isEnabled();
	}
}
