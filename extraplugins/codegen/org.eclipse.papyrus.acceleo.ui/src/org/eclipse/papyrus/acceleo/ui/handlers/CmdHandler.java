/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *   
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher (CEA LIST) ansgar.radermacher@cea.fr - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.acceleo.ui.handlers;


import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.BusinessModelResolver;
import org.eclipse.ui.PlatformUI;


/**
 * Superclass for handlers. It converts a selection into an EObject
 */
public abstract class CmdHandler extends AbstractHandler {

	/**
	 * Convert selected elements within model explorer or diagram to an eObject
	 */
	public void updateSelectedEObject() {
		// Retrieve selected elements
		IStructuredSelection selection = (IStructuredSelection)PlatformUI
				.getWorkbench().getActiveWorkbenchWindow()
				.getSelectionService().getSelection();

		if(selection != null) {
			Object selectedObject = BusinessModelResolver.getInstance().getBusinessModel(selection.getFirstElement());
			if (selectedObject instanceof EObject) {
				selectedEObject = (EObject) selectedObject;
			}
		}
	}

	/**
	 * Store the selected EObject. Accessible for subclasses
	 */
	protected EObject selectedEObject;
}
