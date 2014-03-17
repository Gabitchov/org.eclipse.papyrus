/*****************************************************************************
 * Copyright (c) 2009, 2014 CEA LIST and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA LIST) - adapted for CDO repository resource hyperlinks
 *  Christian W. Damus (CEA) - adapt to source-incompatible API change in CDO Luna M6
 *
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.hyperlink;

import java.util.List;

import org.eclipse.emf.cdo.eresource.CDOFileResource;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.eresource.util.EresourceSwitch;
import org.eclipse.emf.cdo.ui.CDOEditorUtil;
import org.eclipse.emf.cdo.util.CDOURIUtil;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.net4j.util.ui.UIUtil;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.cdo.internal.core.IInternalPapyrusRepository;
import org.eclipse.papyrus.cdo.internal.core.PapyrusRepositoryManager;
import org.eclipse.papyrus.cdo.internal.ui.editors.PapyrusCDOEditorManager;
import org.eclipse.papyrus.cdo.internal.ui.views.DIResourceQuery;
import org.eclipse.papyrus.cdo.internal.ui.views.ModelRepositoriesView;
import org.eclipse.papyrus.infra.hyperlink.Activator;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkObject;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.statushandlers.StatusManager;

/**
 * The hyperlink abstraction for links to documents in CDO repositories.
 */
public class CDOResourceHyperlink extends HyperLinkObject {

	/**
	 * Gets the hyperlinked resource URI.
	 * 
	 * @return the hyperlinked resource URI
	 */
	public URI getHyperlink() {
		return (URI)super.getObject();
	}

	/**
	 * Sets the hyperlinked resource URI.
	 * 
	 * @param uri
	 *        the new hyperlinked resource URI
	 */
	public void setHyperlink(URI uri) {
		super.setObject(uri);
	}

	@Override
	public void openLink() {
		try {
			// open the appropriate editor
			URI uri = getHyperlink();

			IInternalPapyrusRepository repo = PapyrusRepositoryManager.INSTANCE.getRepositoryForURI(uri, false);
			if(repo == null) {
				MessageDialog.openError(UIUtil.getActiveWorkbenchWindow().getShell(), Messages.CDOResourceHyperlink_openError, Messages.CDOResourceHyperlink_notConnected);
			} else if(!repo.isConnected()) {
				repo.connect();
				if(!repo.isConnected()) {
					MessageDialog.openError(UIUtil.getActiveWorkbenchWindow().getShell(), Messages.CDOResourceHyperlink_openError, Messages.CDOResourceHyperlink_notConnected);
				}
			}

			// we may have connected a previously disconnected repo, above
			if((repo != null) && repo.isConnected()) {
				CDOView master = repo.getMasterView();

				String path = CDOURIUtil.extractResourcePath(uri);
				if(!master.hasResource(path)) {
					MessageDialog.openError(UIUtil.getActiveWorkbenchWindow().getShell(), Messages.CDOResourceHyperlink_openError, NLS.bind(Messages.CDOResourceHyperlink_noSuchResource, path));
				} else {
					CDOResourceNode node = master.getResourceNode(path);
					openResource(node);
				}
			}
		} catch (Exception e) {
			Activator.log.error(e);
		}
	}

	protected void openResource(CDOResourceNode node) {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final IWorkbenchPage page = window.getActivePage();

		new EresourceSwitch<Void>() {

			@Override
			public <IO> Void caseCDOFileResource(CDOFileResource<IO> object) {
				CDOEditorUtil.openEditor(page, object);
				return null;
			}

			@Override
			public Void caseCDOResource(CDOResource object) {
				try {
					if(object.isRoot()) {
						// the root resource is a proxy for the repository
						IInternalPapyrusRepository repo = PapyrusRepositoryManager.INSTANCE.getRepositoryForURI(object.getURI());
						ModelRepositoriesView reposView = (ModelRepositoriesView)page.showView(ModelRepositoriesView.ID);
						reposView.selectReveal(new StructuredSelection(repo));
					} else {
						CDOResource diResource = DIResourceQuery.getAffiliateResource(object);

						if(diResource == null) {
							// open regular CDO model resource
							CDOEditorUtil.openEditor(page, object);
						} else {
							// open Papyrus model
							PapyrusCDOEditorManager.INSTANCE.openEditor(page, diResource);
						}
					}
				} catch (PartInitException e) {
					StatusManager.getManager().handle(e.getStatus(), StatusManager.SHOW);
				}

				return null;
			}
		}.doSwitch(node);
	}

	@Override
	public void executeEditMousePressed(List<HyperLinkObject> list, EObject aModel) {
		CDOResourceHyperlinkEditorShell editor = new CDOResourceHyperlinkEditorShell();
		editor.setHyperlink(this);
		if(editor.open()) {
			int index = list.indexOf(this);
			list.set(index, editor.getHyperlink());
		}
	}

	@Override
	public boolean needsOpenCommand() {
		return false;
	}
}
