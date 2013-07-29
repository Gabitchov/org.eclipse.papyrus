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
package org.eclipse.papyrus.uml.diagram.common.handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils;
import org.eclipse.papyrus.infra.services.resourceloading.util.LoadingUtils;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * Handler for the load resource action. This actions load a resource in the
 * model set, which is not yet loaded (due to resource loading strategy).
 */
public class UnloadHandler extends GraphicalCommandHandler {

	/**
	 * @see org.eclipse.papyrus.views.modelexplorer.handler.AbstractCommandHandler#getCommand()
	 * @return the command
	 */
	@Override
	protected Command getCommand() {
		TransactionalEditingDomain editingDomain = getEditingDomain();
		List<IGraphicalEditPart> selection = getSelectedElements();
		if(editingDomain != null && editingDomain.getResourceSet() instanceof ModelSet && selection.size() > 0) {
			final ModelSet set = (ModelSet)editingDomain.getResourceSet();
			CompoundCommand command = new CompoundCommand();
			List<URI> handledURI = new ArrayList<URI>();
			// ensure main URI is never unloaded
			URI mainURI = NotationUtils.getNotationModel(set).getResourceURI().trimFileExtension();
			handledURI.add(mainURI);
			for(IGraphicalEditPart selPart : selection) {
				View view = (View)((IAdaptable)selPart).getAdapter(View.class);
				if(view != null) {
					EObject sel = view.getElement();
					// note: the element may be null if the View is notational only
					if(sel != null && !sel.eIsProxy()) {
						final URI uriTrim = sel.eResource().getURI().trimFileExtension();
						if(!handledURI.contains(uriTrim)) {
							handledURI.add(uriTrim);
							Command cmd = new Command() {

								@Override
								public void redo() {
									LoadingUtils.unloadResourcesFromModelSet(set, uriTrim);
								}

								@Override
								public void execute() {
									redo();
								}

								@Override
								public boolean canExecute() {
									return true;
								}
							};
							command.add(cmd);
						}
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
