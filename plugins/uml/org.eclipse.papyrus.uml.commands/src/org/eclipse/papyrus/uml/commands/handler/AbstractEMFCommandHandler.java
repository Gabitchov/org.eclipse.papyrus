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
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.commands.handler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.emf.utils.BusinessModelResolver;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForHandlers;
import org.eclipse.papyrus.uml.commands.Activator;
import org.eclipse.swt.widgets.Display;
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
@Deprecated // use org.eclipse.papyrus.infra.gmfdiag.modelexplorer.handlers.AbstractEMFCommandHandler
public abstract class AbstractEMFCommandHandler extends AbstractHandler {

	/**
	 * Returns the current editing domain
	 * 
	 * @return
	 *         the current editing domain
	 */
	protected TransactionalEditingDomain getEditingDomain() {
		TransactionalEditingDomain editingDomain = null;
		try {
			editingDomain = org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers.getInstance().getTransactionalEditingDomain();
		} catch (ServiceException e) {
			//we are closing the editor, so the model explorer has nothing to display
			//			e.printStackTrace();
		}
		return editingDomain;
	}

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
	protected abstract Command getCommand(ServicesRegistry registry);

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

			eObject=EMFHelper.getEObject(selection);
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

		//FIXME: This method should always be called from the UI Thread. 
		//TODO: Fix the tests and remove the syncExec call 
		// Parse current selection
		RunnableWithResult<ISelection> runnable;
		Display.getDefault().syncExec(runnable = new RunnableWithResult.Impl<ISelection>() {

			public void run() {
				setResult(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection());
			}
		});

		ISelection selection = runnable.getResult();
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection)selection;
			for(Object current : structuredSelection.toArray()) {
				// Adapt current selection to EObject
				EObject eobject=EMFHelper.getEObject(current);
				if(eobject != null) {
					selectedEObjects.add(eobject);
				}

			}
		} else { // Not a IStructuredSelection
			if(selection != null) {
				// Adapt current selection to EObject
				EObject eobject=EMFHelper.getEObject(selection);
					if(eobject != null) {
						selectedEObjects.add(eobject);
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
			ServicesRegistry registry = ServiceUtilsForHandlers.getInstance().getServiceRegistry(event);
			Command emfCommand = getCommand(registry);

			ServiceUtils.getInstance().getTransactionalEditingDomain(registry).getCommandStack().execute(emfCommand);

			return emfCommand.getResult();

		} catch (ServiceException e) {

			Activator.log.error("Unexpected error while executing command.", e);

		}

		return null;
	}

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#isEnabled()
	 * 
	 * @return true (enabled) when the command can be executed.
	 */
	@Override
	public boolean isEnabled() {
		return getCommand(getServicesRegistryFromSelection()).canExecute();
	}

	protected ServicesRegistry getServicesRegistryFromSelection() {
		for(EObject selectedElement : getSelectedElements()) {
			try {
				ServicesRegistry registry = ServiceUtilsForEObject.getInstance().getServiceRegistry(selectedElement);
				if(registry != null) {
					return registry;
				}
			} catch (ServiceException ex) {
				//Ignore it and keep searching for a ServicesRegistry
			}
		}

		return null;
	}

	/**
	 * 
	 * @return true (visible) when the command can be executed.
	 */
	public boolean isVisible() {
		return getCommand(getServicesRegistryFromSelection()).canExecute();
	}
}
