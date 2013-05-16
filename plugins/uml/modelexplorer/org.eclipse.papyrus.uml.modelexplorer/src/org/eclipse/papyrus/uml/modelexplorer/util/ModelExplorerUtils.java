/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.modelexplorer.util;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.LinkItem;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.uml.service.types.utils.CommandContext;
import org.eclipse.papyrus.uml.service.types.utils.ICommandContext;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * Utilities for capturing elements in the model explorer.
 */
public class ModelExplorerUtils {

	/**
	 * <pre>
	 * Parse current selection and extract the command context (can be null).
	 * 
	 * @return the command context based on current selection
	 * </pre>
	 */
	public static ICommandContext getSelectionCommandContext() {
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

}
