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
 * 
 * 		Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *      Vincent Lorenzo (CEA-LIST) vincent.lorenzo@cea.fr
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.validation.handler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.BusinessModelResolver;
import org.eclipse.ui.PlatformUI;

/**
 * <pre>
 * 
 * This abstract command handler manages:
 * - current selection in order to build a list of the selected {@link EObject}
 * - execute the command (returned by children)
 * - calculate the command enablement and visibility regarding the command executability
 * (the command is now shown in menu if not executable).
 * 
 * </pre>
 */
public abstract class AbstractCommandHandler extends AbstractHandler {

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
		Object selection = null;

		// Get current selection
		selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();

		// Get first element if the selection is an IStructuredSelection
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection)selection;
			selection = structuredSelection.getFirstElement();
		}

		// Treat non-null selected object (try to adapt and return EObject)
		if(selection != null) {
			if(selection instanceof IAdaptable) {
				selection = ((IAdaptable)selection).getAdapter(EObject.class);
			}

			Object businessObject = BusinessModelResolver.getInstance().getBusinessModel(selection);
			if(businessObject instanceof EObject) {
				eObject = (EObject)businessObject;
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

		// Parse current selection
		ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection)selection;
			for(Object current : structuredSelection.toArray()) {
				// Adapt current selection to EObject
				if(current instanceof IAdaptable) {
					selectedEObjects.add((EObject)((IAdaptable)current).getAdapter(EObject.class));
				}
			}
		} else { // Not a IStructuredSelection
			if(selection != null) {
				// Adapt current selection to EObject
				if(selection instanceof IAdaptable) {
					selectedEObjects.add((EObject)((IAdaptable)selection).getAdapter(EObject.class));
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
		//		try {
		//			ServiceUtilsForActionHandlers util = new ServiceUtilsForActionHandlers();
		//			util.getTransactionalEditingDomain().getCommandStack().execute(getCommand());
		//			
		//		} catch (ServiceException e) {
		//			Activator.log.error("Unexpected error while executing command.", e); //$NON-NLS-1$
		//		}

		getCommand().execute(); //Validation commands should not be executed in the stack trace

		return null;
	}
	@Override
	public void setEnabled(Object evaluationContext) {
		setBaseEnabled(getCommand().canExecute());
	}

	/**
	 * 
	 * @return true (visible) when the command can be executed.
	 */
	public boolean isVisible() {
		return getCommand().canExecute();
	}


}
