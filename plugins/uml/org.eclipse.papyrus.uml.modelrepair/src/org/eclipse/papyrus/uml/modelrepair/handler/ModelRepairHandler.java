/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.modelrepair.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.utils.DiResourceSet;
import org.eclipse.papyrus.uml.modelrepair.Activator;
import org.eclipse.papyrus.uml.modelrepair.ui.ModelRepairDialog;
import org.eclipse.ui.handlers.HandlerUtil;


public class ModelRepairHandler extends AbstractHandler {

	//Prototype.
	//Not visible.
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if(currentSelection.isEmpty() || !(currentSelection instanceof IStructuredSelection)) {
			return null;
		}

		IStructuredSelection selection = (IStructuredSelection)currentSelection;

		Object selectedElement = selection.getFirstElement();

		Object selectedAdapter = Platform.getAdapterManager().getAdapter(selectedElement, IFile.class);

		if(selectedAdapter instanceof IFile) {
			IFile selectedFile = (IFile)selectedAdapter;
			ModelSet modelSet = new DiResourceSet();
			EditingDomain editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(modelSet);

			IPath workspacePath = selectedFile.getFullPath();

			URI workspaceURI = URI.createPlatformResourceURI(workspacePath.toString(), true);

			try {
				modelSet.loadModels(workspaceURI);
				ModelRepairDialog dialog = new ModelRepairDialog(HandlerUtil.getActiveShell(event), modelSet, editingDomain);
				dialog.open();
				modelSet.unload();
			} catch (ModelMultiException e) {
				Activator.log.error(e);
			}
		}

		return null;
	}

}
