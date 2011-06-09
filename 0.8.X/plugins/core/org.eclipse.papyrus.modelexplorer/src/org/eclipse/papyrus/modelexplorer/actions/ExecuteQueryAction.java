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
 *
 *****************************************************************************/
package org.eclipse.papyrus.modelexplorer.actions;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;

/**
 * This class is used to execute an action (modisco query)
 */
public class ExecuteQueryAction extends
		org.eclipse.emf.facet.infra.query.ui.actions.ExecuteQueryAction {

	/**
	 * Create a new ExecuteQueryAction.
	 */
	public ExecuteQueryAction() {
		// nothing here
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("rawtypes")
	public void selectionChanged(final IAction action,
			final ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			ArrayList<EObject> select = new ArrayList<EObject>();
			Iterator iterator = ((IStructuredSelection) selection).toList()
					.iterator();
			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				if (object instanceof IAdaptable) {
					EObject eObject = (EObject) ((IAdaptable) object)
							.getAdapter(EObject.class);
					if (eObject != null) {
						select.add(eObject);
					}

				}

			}
			if (select.size() > 0) {
				super.selectionChanged(action, new StructuredSelection(select));
			} else {
				super.selectionChanged(action, new StructuredSelection(
						selection));
			}
		}

	}
}
