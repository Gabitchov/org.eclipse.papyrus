/*****************************************************************************
 * Copyright (c) 2010, 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *      Vincent Lorenzo (CEA-LIST) vincent.lorenzo@cea.fr
 *      Christian W. Damus (CEA) - Refactoring package/profile import/apply UI for CDO
 *      
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.handler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForHandlers;
import org.eclipse.papyrus.views.modelexplorer.Activator;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * <pre>
 * 
 * This abstract command handler manages:
 * - current selection in order to build a list of the selected {@link EObject}
 * - execute the command (returned by children) in Papyrus {@link TransactionalEditingDomain}
 * - calculate the command enablement and visibility regarding the command executability
 * (the command is now shown in menu if not executable).
 * 
 * </pre>
 */
public abstract class AbstractCommandHandler extends AbstractModelExplorerHandler {

	private List<?> selection = Collections.EMPTY_LIST;
	
	/**
	 * <pre>
	 * 
	 * Returns the command to execute (to be implemented
	 * in children implementing this class)
	 * 
	 * @return the command to execute
	 * 
	 * </pre>
	 */
	protected abstract Command getCommand();

	protected List<?> getSelection() {
		return selection;
	}
	
	/**
	 * <pre>
	 * Get the selected element, the first selected element if several are selected or null
	 * if no selection or the selection is not an {@link EObject}.
	 * 
	 * @return selected {@link EObject} or null
	 * </pre>
	 * 
	 */
	protected EObject getSelectedElement() {
		EObject eObject = null;

		// Get current selection
		List<?> selection = getSelection();

		// Treat non-null selected object (try to adapt and return EObject)
		if (!selection.isEmpty()) {

			// Get first element if the selection is an IStructuredSelection
			Object first = selection.get(0);


			EObject businessObject = EMFHelper.getEObject(first);
			if(businessObject != null) {
				eObject = businessObject;
			}
		}

		return eObject;
	}

	/**
	 * <pre>
	 * Parse current selection and extract the list of {@link EObject} from
	 * this selection.
	 * 
	 * This also tries to adapt selected element into {@link EObject}
	 * (for example to get the {@link EObject} from a selection in the ModelExplorer).
	 * 
	 * @return a list of currently selected {@link EObject}
	 * </pre>
	 * 
	 */
	protected List<EObject> getSelectedElements() {

		List<EObject> selectedEObjects = new ArrayList<EObject>();

		// Get current selection
		Collection<?> selection = getSelection();

		// Treat non-null selected object (try to adapt and return EObject)
		if (!selection.isEmpty()) {

			// Parse current selection
			for (Object current : selection) {
				// Adapt current selection to EObject
				EObject selectedEObject = EMFHelper.getEObject(current);
				if (selectedEObject != null) {
					//we avoid to add null element in the list!
					selectedEObjects.add(selectedEObject);
				}
			}
		}

		return selectedEObjects;
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
			this.selection = (selection instanceof IStructuredSelection)
				? ((IStructuredSelection) selection).toList()
				: Collections.EMPTY_LIST;
			
			ServiceUtilsForHandlers.getInstance()
				.getTransactionalEditingDomain(event).getCommandStack()
				.execute(getCommand());
		} catch (ServiceException e) {
			Activator.log.error("Unexpected error while executing command.", e); //$NON-NLS-1$
		} finally {
			// clear the selection
			this.selection = Collections.EMPTY_LIST;
		}

		return null;
	}

	protected boolean computeEnabled() {
		boolean result = false;
		
		Command command = getCommand();
		if (command != null) {
			result = getCommand().canExecute();
			command.dispose();
		}
		
		return result;
	}

	@Override
	public void setEnabled(Object evaluationContext) {
		if (evaluationContext instanceof IEvaluationContext) {
			Object selection = ((IEvaluationContext) evaluationContext).getDefaultVariable();
			if (selection instanceof Collection<?>) {
				this.selection = (selection instanceof List<?>)
					? (List<?>) selection
					: new java.util.ArrayList<Object>((Collection<?>) selection);
				setBaseEnabled(computeEnabled());
				this.selection = Collections.EMPTY_LIST;
			}
		}
		super.setEnabled(evaluationContext);
	}
}
