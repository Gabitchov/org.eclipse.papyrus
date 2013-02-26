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
package org.eclipse.papyrus.views.modelexplorer.handler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.views.modelexplorer.Activator;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

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

		// Get current selection
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		Object selection = (activeWorkbenchWindow != null) ? activeWorkbenchWindow.getSelectionService().getSelection() : null;

		// Treat non-null selected object (try to adapt and return EObject)
		if(selection != null) {

			// Get first element if the selection is an IStructuredSelection
			if(selection instanceof IStructuredSelection) {
				IStructuredSelection structuredSelection = (IStructuredSelection)selection;
				selection = structuredSelection.getFirstElement();
			}

			if(selection instanceof IAdaptable) {
				selection = ((IAdaptable)selection).getAdapter(EObject.class);
			}

			EObject businessObject = EMFHelper.getEObject(selection);
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
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		Object selection = (activeWorkbenchWindow != null) ? activeWorkbenchWindow.getSelectionService().getSelection() : null;

		// Treat non-null selected object (try to adapt and return EObject)
		if(selection != null) {

			// Parse current selection
			if(selection instanceof IStructuredSelection) {
				IStructuredSelection structuredSelection = (IStructuredSelection)selection;
				for(Object current : structuredSelection.toArray()) {
					// Adapt current selection to EObject
					EObject selectedEObject = EMFHelper.getEObject(current);
					//we avoid to add null element in the list!
					if(selectedEObject != null) {
						selectedEObjects.add(selectedEObject);
					}
				}
			} else { // Not a IStructuredSelection
				// Adapt current selection to EObject
				EObject selectedElement = null;
				if(selection instanceof IAdaptable) {
					selectedElement = (EObject)((IAdaptable)selection).getAdapter(EObject.class);
				}
				if(selectedElement == null) {
					selectedElement = (EObject)Platform.getAdapterManager().getAdapter(selection, EObject.class);
				}
				if(selectedElement != null) { //we avoid to add null element in the list!
					selectedEObjects.add(selectedElement);
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
			ServiceUtilsForActionHandlers.getInstance().getTransactionalEditingDomain().getCommandStack().execute(getCommand());
		} catch (ServiceException e) {
			Activator.log.error("Unexpected error while executing command.", e); //$NON-NLS-1$
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEnabled() {
		Command command = getCommand();
		return command != null && getCommand().canExecute();
	}

}
