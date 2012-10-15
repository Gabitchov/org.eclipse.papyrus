/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Hemery (Atos) vincent.hemery@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.resourceloading.handler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.sasheditor.SashModelUtils;
import org.eclipse.papyrus.infra.services.resourceloading.util.LoadingUtils;
import org.eclipse.papyrus.views.modelexplorer.handler.AbstractCommandHandler;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * Handler for the load resource action.
 * This actions load a resource in the model set, which is not yet loaded (due to resource loading strategy).
 */
public class UnloadResourceHandler extends AbstractCommandHandler {


	/**
	 * @see org.eclipse.papyrus.views.modelexplorer.handler.AbstractCommandHandler#getCommand()
	 * @return the command
	 */
	@Override
	protected Command getCommand() {
		TransactionalEditingDomain editingDomain = getEditingDomain();
		List<EObject> selection = getSelectedElements();
		if(editingDomain != null && editingDomain.getResourceSet() instanceof ModelSet && selection.size() > 0) {
			final ModelSet set = (ModelSet)editingDomain.getResourceSet();
			CompoundCommand command = new CompoundCommand();
			List<URI> handledURI = new ArrayList<URI>();
			// ensure main URI is never unloaded
			URI mainURI = SashModelUtils.getSashModel(set).getResourceURI().trimFileExtension();
			handledURI.add(mainURI);
			for(EObject sel : selection) {
				if(!sel.eIsProxy()) {
					final URI uriTrim = sel.eResource().getURI().trimFileExtension();
					if(!handledURI.contains(uriTrim)) {
						handledURI.add(uriTrim);
						Command cmd = new AbstractCommand() {

							public void redo() {
								LoadingUtils.unloadResourcesFromModelSet(set, uriTrim);
							}

							public void execute() {
								redo();
							}

							@Override
							public boolean canExecute() {
								return true;
							}
						};
						command.append(cmd);
					}
				}
			}
			return command;
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Get currently opened editor
	 * 
	 * @return editor
	 */
	protected IEditorPart getEditor() {
		IEditorPart editor = null;
		IWorkbenchWindow activeWorkbenchWindow = getActiveWorkbenchWindow();
		if(activeWorkbenchWindow != null) {
			IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
			if(activePage != null) {
				editor = activePage.getActiveEditor();
			}
		}
		return editor;
	}

	/**
	 * Get the active workbench window
	 * 
	 * @return window
	 */
	protected IWorkbenchWindow getActiveWorkbenchWindow() {
		IWorkbench workbench = PlatformUI.getWorkbench();
		if(workbench != null) {
			return workbench.getActiveWorkbenchWindow();
		}
		return null;
	}

}
