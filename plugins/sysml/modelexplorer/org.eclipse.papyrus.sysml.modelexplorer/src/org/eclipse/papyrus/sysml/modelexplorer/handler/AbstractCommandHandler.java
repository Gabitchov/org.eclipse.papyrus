/*****************************************************************************
 * Copyright (c) 2010-2011 CEA LIST.
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
package org.eclipse.papyrus.sysml.modelexplorer.handler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.LinkItem;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.infra.emf.utils.BusinessModelResolver;
import org.eclipse.papyrus.sysml.modelexplorer.Activator;
import org.eclipse.papyrus.views.modelexplorer.CommandContext;
import org.eclipse.papyrus.views.modelexplorer.ICommandContext;
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
	 * @deprecated
	 */
	@Deprecated
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

			// Treat non-null selected object (try to adapt and return EObject)
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
	 * @deprecated
	 */
	@Deprecated
	protected List<EObject> getSelectedElements() {

		List<EObject> selectedEObjects = new ArrayList<EObject>();

		// Get current selection
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		Object selection = (activeWorkbenchWindow != null) ? activeWorkbenchWindow.getSelectionService().getSelection() : null;

		// Treat non-null selected object (try to adapt and return EObject)
		if(selection != null) {

			if(selection instanceof IStructuredSelection) {
				IStructuredSelection structuredSelection = (IStructuredSelection)selection;
				for(Object current : structuredSelection.toArray()) {
					// Adapt current selection to EObject
					if(current instanceof IAdaptable) {
						selectedEObjects.add((EObject)((IAdaptable)current).getAdapter(EObject.class));
					}
				}
			} else { // Not a IStructuredSelection
						// Adapt current selection to EObject
				if(selection instanceof IAdaptable) {
					selectedEObjects.add((EObject)((IAdaptable)selection).getAdapter(EObject.class));
				}
			}
		}

		return selectedEObjects;
	}

	/**
	 * <pre>
	 * Parse current selection and extract the command context (can be null).
	 * 
	 * @return the command context based on current selection
	 * </pre>
	 */
	protected ICommandContext getCommandContext() {

		// Get current selection from workbench
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		Object selection = (activeWorkbenchWindow != null) ? activeWorkbenchWindow.getSelectionService().getSelection() : null;

		// If the selection is null, return null command context.
		if(selection == null) {
			return null;
		}

		// Get first element if the selection is an IStructuredSelection
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection)selection;
			selection = structuredSelection.getFirstElement();
		}

		// Treat non-null selected object (try to adapt and return EObject or EReference)
		EObject container = null;
		EReference reference = null;

		if(selection instanceof IAdaptable) {

			container = (EObject)((IAdaptable)selection).getAdapter(EObject.class);

			if(container == null) {
				reference = (EReference)((IAdaptable)selection).getAdapter(EReference.class);

				// The following part introduce a dependency to EMF Facet.
				// Although the selection can be adapted to EReference, the link parent is required but
				// no API allows to get this element except LinkItem or ITreeElement.
				if((reference != null) && (selection instanceof LinkItem)) {
					container = ((LinkItem)selection).getParent();
				}
			}
		}

		// Prepare the command context
		ICommandContext context = null;
		if(container != null) {
			if(reference != null) {
				context = new CommandContext(container, reference);
			} else {
				context = new CommandContext(container);
			}
		}

		// Return the context	
		return context;
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

		Command creationcommand = null;

		try {

			ServiceUtilsForActionHandlers util = ServiceUtilsForActionHandlers.getInstance();
			creationcommand = getCommand();

			util.getTransactionalEditingDomain().getCommandStack().execute(creationcommand);

			return creationcommand.getResult();

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
		return getCommand().canExecute();
	}

	/**
	 * 
	 * @return true (visible) when the command can be executed.
	 */
	public boolean isVisible() {
		return getCommand().canExecute();
	}
}
