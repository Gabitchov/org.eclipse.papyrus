/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.validation.internal.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.ui.IWorkbenchSite;
import org.eclipse.ui.actions.ActionFactory;

/**
 * This is the SelectAllAction type. Enjoy.
 */
public class SelectAllAction
		extends Action {

	private IWorkbenchSite site;

	public SelectAllAction(IWorkbenchSite site) {
		super("Select All");

		this.site = site;

		setActionDefinitionId(ActionFactory.SELECT_ALL.getCommandId());
	}

	@Override
	public void run() {
		ISelectionProvider selectionProvider = site.getSelectionProvider();
		if (selectionProvider instanceof StructuredViewer) {
			StructuredViewer viewer = (StructuredViewer) selectionProvider;
			IStructuredContentProvider content = (IStructuredContentProvider) viewer
				.getContentProvider();
			viewer.setSelection(new StructuredSelection(content
				.getElements(viewer.getInput())));
		}
	}
}
