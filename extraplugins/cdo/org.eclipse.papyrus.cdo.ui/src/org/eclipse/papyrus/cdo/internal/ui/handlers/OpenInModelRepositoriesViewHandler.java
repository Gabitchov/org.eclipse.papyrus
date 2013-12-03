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

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.cdo.admin.CDOAdminClient;
import org.eclipse.emf.cdo.admin.CDOAdminClientRepository;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.net4j.util.ui.UIUtil;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;
import org.eclipse.papyrus.cdo.core.IPapyrusRepositoryManager;
import org.eclipse.papyrus.cdo.internal.core.PapyrusRepositoryManager;
import org.eclipse.papyrus.cdo.internal.ui.Activator;
import org.eclipse.papyrus.cdo.internal.ui.actions.ConnectRepositoryAction;
import org.eclipse.papyrus.cdo.internal.ui.views.ModelRepositoriesView;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * This is the OpenInModelRepositoriesViewHandler type. Enjoy.
 */
public class OpenInModelRepositoriesViewHandler extends AbstractHandler {

	private final IPapyrusRepositoryManager manager = PapyrusRepositoryManager.INSTANCE;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		ISelection selection = HandlerUtil.getCurrentSelection(event);
		CDOAdminClientRepository adminRepository = UIUtil.adaptElement(selection, CDOAdminClientRepository.class);
		if(adminRepository != null) {
			CDOAdminClient client = adminRepository.getAdmin();
			String url = String.format("%s?repositoryName=%s", client.getURL(), adminRepository.getName()); //$NON-NLS-1$

			IPapyrusRepository repository = manager.getRepository(url);
			if(repository == null) {
				repository = manager.createRepository(url);
				repository.setName(adminRepository.getName());
				manager.saveRepositories();
			}

			IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);

			if(window != null) {
				selectReveal(window, repository);
			}

			if(!repository.isConnected()) {
				new ConnectRepositoryAction(HandlerUtil.getActivePart(event)).run(repository);
			}
		}

		return null;
	}

	protected void selectReveal(IWorkbenchWindow window, IPapyrusRepository repository) {
		IWorkbenchPage page = window.getActivePage();
		if(page != null) {
			try {
				IViewPart view = page.showView(ModelRepositoriesView.ID);
				view.getSite().getSelectionProvider().setSelection(new StructuredSelection(repository));
			} catch (PartInitException e) {
				Activator.log.error(e);
			}
		}
	}
}
