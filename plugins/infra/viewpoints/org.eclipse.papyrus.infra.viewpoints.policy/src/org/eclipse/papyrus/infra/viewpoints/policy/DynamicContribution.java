/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.viewpoints.policy;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.CompoundContributionItem;

/**
 * Represent the dynamic contribution of a policy to some UI elements
 * 
 * @author Laurent Wouters
 */
public abstract class DynamicContribution extends CompoundContributionItem {

	/**
	 * Creation message prefix
	 */
	protected static final String CREATE_MESSAGE = "Create a new ";

	/**
	 * Constructor.
	 */
	protected DynamicContribution() {
	}

	/**
	 * Constructor.
	 */
	protected DynamicContribution(String id) {
	}

	/**
	 * @see org.eclipse.ui.actions.CompoundContributionItem#isDynamic()
	 */
	@Override
	public boolean isDynamic() {
		return true;
	}

	/**
	 * Gets the current selection as an EObject
	 * 
	 * @return The current selection, or <code>null</code> if it is not an EObject
	 */
	protected EObject getSelection() {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (window == null)
			return null;
		ISelection selection = window.getSelectionService().getSelection();
		if (selection == null)
			return null;
		if (selection.isEmpty())
			return null;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection struct = (IStructuredSelection) selection;
			Object obj = struct.getFirstElement();
			return EMFHelper.getEObject(obj);
		}
		return null;
	}
}
