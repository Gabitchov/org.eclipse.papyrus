/**
 * Copyright (c) 2011 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Nicolas Guyomar (Mia-Software) - Bug 349546 - EMF Facet facetSet editor
 */
package org.eclipse.papyrus.emf.facet.efacet.ui.internal.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.IFacetUIFactory;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.exported.wizard.IFacetChildrenWizard;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

/**
 * This class handle the action "Add facet operation parameter"
 */
@Deprecated
//TODO @Deprecated must be removed after a refactoring planed by https://bugs.eclipse.org/bugs/show_bug.cgi?id=364601
public class AddFacetParameterOperationHandler extends AbstractHandler {

	public Object execute(final ExecutionEvent event) throws ExecutionException {
		ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();

		// Retrieve the editor
		IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		// Retrieve the editing domain
		EditingDomain editingDomain = ((IEditingDomainProvider) editor).getEditingDomain();

		IFacetChildrenWizard dialog = IFacetUIFactory.INSTANCE.createAddFacetOperationParameterWizardDialog(selection, editingDomain);
		dialog.canChangeFacet(false);
		dialog.setLowerBound(0);
		dialog.setUpperBound(0);
		dialog.open();
		return null;
	}

}