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
package org.eclipse.papyrus.cdo.internal.ui.views;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.papyrus.cdo.core.IPapyrusRepositoryManager;
import org.eclipse.papyrus.cdo.internal.core.IInternalPapyrusRepository;
import org.eclipse.papyrus.cdo.internal.ui.editors.PapyrusCDOEditorInput;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchSite;

/**
 * This is the LinkingHelper type. Enjoy.
 */
class LinkingHelper {

	private final IWorkbenchSite site;

	private final IPapyrusRepositoryManager repositoryManager;

	private final StructuredViewer viewer;

	private boolean linkWithEditor;

	private IPartListener linkingPartListener;

	private ISelectionChangedListener linkingSelectionListener;

	public LinkingHelper(IWorkbenchSite site,
			IPapyrusRepositoryManager repositoryManager, StructuredViewer viewer) {

		super();

		this.site = site;
		this.repositoryManager = repositoryManager;
		this.viewer = viewer;
	}

	public void dispose() {
		if (linkingPartListener != null) {
			site.getPage().removePartListener(linkingPartListener);
		}
		if (linkingSelectionListener != null) {
			viewer.removeSelectionChangedListener(linkingSelectionListener);
		}
	}

	public boolean isLinkWithEditor() {
		return linkWithEditor;
	}

	public void setLinkWithEditor(boolean link) {
		if (link != linkWithEditor) {
			this.linkWithEditor = link;

			if (link) {
				IWorkbenchPart active = site.getPage().getActivePart();
				if ((active != null) && (active.getSite() == site)) {
					// select the current model editor (if any)
					selectEditor();
				} else {
					handleEditor(site.getPage().getActiveEditor());
				}

				site.getPage().addPartListener(getLinkingPartListener());
				viewer
					.addSelectionChangedListener(getLinkingSelectionListener());
			} else {
				site.getPage().removePartListener(getLinkingPartListener());
				viewer
					.removeSelectionChangedListener(getLinkingSelectionListener());
			}
		}
	}

	protected void selectEditor() {
		DIModel model = getDIModelFromSelection();
		if (model != null) {
			URI uri = model.getResource().getURI();
			IEditorInput input = new PapyrusCDOEditorInput(uri);

			IEditorPart editor = site.getPage().findEditor(input);
			if (editor != null) {
				site.getPage().activate(editor);
			}
		}
	}

	protected void handleEditor(IEditorPart activeEditor) {
		if (activeEditor != null) {
			IEditorInput input = activeEditor.getEditorInput();
			if (input instanceof URIEditorInput) {
				URI uri = ((URIEditorInput) input).getURI();

				DIModel selected = getDIModelFromSelection();
				if ((selected == null)
					|| !selected.getResource().getURI().equals(uri)) {

					// change the selection
					DIModel model = findDIModel(uri);
					if (model != null) {
						viewer.setSelection(new StructuredSelection(model),
							true);
					}
				}
			}
		}
	}

	protected DIModel getDIModelFromSelection() {
		IStructuredSelection sel = (viewer == null)
			? StructuredSelection.EMPTY
			: (IStructuredSelection) viewer.getSelection();

		return sel.isEmpty()
			? null
			: getDIModelFromSelection(sel.getFirstElement());
	}

	protected DIModel getDIModelFromSelection(Object selected) {
		DIModel result = null;

		if (selected instanceof DIModel) {
			result = (DIModel) selected;
		} else if (selected instanceof CDOResource) {
			Object parent = ((ITreeContentProvider) viewer.getContentProvider())
				.getParent(selected);
			if (parent instanceof DIModel) {
				result = (DIModel) parent;
			}
		}

		return result;
	}

	protected DIModel findDIModel(URI uri) {
		DIModel result = null;

		IInternalPapyrusRepository repo = (IInternalPapyrusRepository) repositoryManager
			.getRepositoryForURI(uri);
		if (repo != null) {
			CDOView mainView = repo.getMasterView();
			if ((mainView != null) && !mainView.isClosed()) {
				Resource res = mainView.getResourceSet()
					.getResource(uri, false);

				if ((res instanceof CDOResource) && res.isLoaded()) {
					result = DIModel.getInstance((CDOResource) res, true);
				}
			}
		}

		return result;
	}

	private IPartListener getLinkingPartListener() {
		if (linkingPartListener == null) {
			linkingPartListener = new IPartListener() {

				public void partActivated(IWorkbenchPart part) {
					if (part instanceof IEditorPart) {
						handleEditor((IEditorPart) part);
					}
				}

				public void partOpened(IWorkbenchPart part) {
					// pass
				}

				public void partDeactivated(IWorkbenchPart part) {
					// pass
				}

				public void partClosed(IWorkbenchPart part) {
					// pass
				}

				public void partBroughtToTop(IWorkbenchPart part) {
					// pass
				}
			};
		}

		return linkingPartListener;
	}

	private ISelectionChangedListener getLinkingSelectionListener() {
		if (linkingSelectionListener == null) {
			linkingSelectionListener = new ISelectionChangedListener() {

				public void selectionChanged(SelectionChangedEvent event) {
					selectEditor();
				}
			};
		}

		return linkingSelectionListener;
	}

}
