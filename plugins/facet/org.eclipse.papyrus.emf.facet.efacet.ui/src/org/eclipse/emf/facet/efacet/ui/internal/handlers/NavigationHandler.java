/**
 * Copyright (c) 2011-2012 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	 Gregoire Dupe (Mia-Software) - Bug 364325 - [Restructuring] The user must be able to navigate into a model using the Facet.
 *   Nicolas Bros (Mia-Software) - Bug 379395 - Navigate should replace elements
 */
package org.eclipse.emf.facet.efacet.ui.internal.handlers;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.facet.efacet.ui.internal.exported.view.INavigationView;
import org.eclipse.emf.facet.efacet.ui.internal.exported.view.INavigationViewFactory;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

/**
 * This class handle the action "Add facet attribute"
 */
public class NavigationHandler extends AbstractHandler {

	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final ISelection selection = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getSelectionService()
				.getSelection();

		// Retrieve the editor
		final IEditorPart editor = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		// Retrieve the editing domain

		EditingDomain editingDomain = null;
		if (editor instanceof IEditingDomainProvider) {
			final IEditingDomainProvider edProvider = (IEditingDomainProvider) editor;
			editingDomain = edProvider.getEditingDomain();
		}

		final List<EObject> eObjects = new LinkedList<EObject>();
		final INavigationView view = INavigationViewFactory.DEFAULT
				.openNavigationView(editingDomain);
		if (selection instanceof IStructuredSelection) {
			final IStructuredSelection sSelection = (IStructuredSelection) selection;
			for (Object object : sSelection.toList()) {
				if (object instanceof EObject) {
					final EObject eObject = (EObject) object;
					eObjects.add(eObject);
				}
			}
		}
		view.removeAllEObjects();
		view.addEObjects(eObjects);
		return null;
	}

}
