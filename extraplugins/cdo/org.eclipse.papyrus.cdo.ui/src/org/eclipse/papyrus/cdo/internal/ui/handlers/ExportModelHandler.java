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
package org.eclipse.papyrus.cdo.internal.ui.handlers;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;
import org.eclipse.papyrus.cdo.internal.core.IInternalPapyrusRepository;
import org.eclipse.papyrus.cdo.internal.core.PapyrusRepositoryManager;
import org.eclipse.papyrus.cdo.internal.ui.views.DIModel;
import org.eclipse.papyrus.cdo.internal.ui.wizards.ModelExportWizard;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import com.google.common.collect.Lists;

/**
 * This is the ExportModelHandler type. Enjoy.
 */
public class ExportModelHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {

		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if(selection instanceof IStructuredSelection) {
			IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);

			if(window != null) {
				exportModels(window, null, (IStructuredSelection)selection);
			}
		}

		return null;
	}

	public static void exportModels(IWorkbenchWindow window, IContainer destination, IStructuredSelection selection) {
		ModelExportWizard wizard = new ModelExportWizard();
		wizard.init(window.getWorkbench(), selection);
		wizard.setInitialDestination(destination);

		new WizardDialog(window.getShell(), wizard).open();
	}

	public static void exportModels(IContainer destination, Iterable<URI> resourceURIs) {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

		List<DIModel> models = Lists.newArrayList();
		for(URI next : resourceURIs) {
			IPapyrusRepository repo = PapyrusRepositoryManager.INSTANCE.getRepositoryForURI(next);
			if(repo != null) {
				CDOView view = ((IInternalPapyrusRepository)repo).getMasterView();
				if(view != null) { // the repository could be disconnected by now
					Resource resource = view.getResourceSet().getResource(next, true);
					if(resource instanceof CDOResource) {
						models.add(DIModel.getInstance((CDOResource)resource, true));
					}
				}
			}
		}

		if((window != null) && !models.isEmpty()) {
			exportModels(window, destination, new StructuredSelection(models));
		}
	}
}
