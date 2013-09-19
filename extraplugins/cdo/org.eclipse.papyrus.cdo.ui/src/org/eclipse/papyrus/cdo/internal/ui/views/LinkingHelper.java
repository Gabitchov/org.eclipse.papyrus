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
import org.eclipse.emf.cdo.eresource.CDOResourceLeaf;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.ui.CDOEditorInput;
import org.eclipse.emf.cdo.util.CDOURIUtil;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.papyrus.cdo.core.IPapyrusRepositoryManager;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;
import org.eclipse.papyrus.cdo.internal.core.IInternalPapyrusRepository;
import org.eclipse.papyrus.cdo.internal.ui.Activator;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchSite;
import org.eclipse.ui.PartInitException;

import com.google.common.base.Objects;

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

	public LinkingHelper(IWorkbenchSite site, IPapyrusRepositoryManager repositoryManager, StructuredViewer viewer) {

		super();

		this.site = site;
		this.repositoryManager = repositoryManager;
		this.viewer = viewer;
	}

	public void dispose() {
		if(linkingPartListener != null) {
			site.getPage().removePartListener(linkingPartListener);
		}
		if(linkingSelectionListener != null) {
			viewer.removeSelectionChangedListener(linkingSelectionListener);
		}
	}

	public boolean isLinkWithEditor() {
		return linkWithEditor;
	}

	public void setLinkWithEditor(boolean link) {
		if(link != linkWithEditor) {
			this.linkWithEditor = link;

			if(link) {
				IWorkbenchPart active = site.getPage().getActivePart();
				if((active != null) && (active.getSite() == site)) {
					// select the current model editor (if any)
					selectEditor();
				} else {
					handleEditor(site.getPage().getActiveEditor());
				}

				site.getPage().addPartListener(getLinkingPartListener());
				viewer.addSelectionChangedListener(getLinkingSelectionListener());
			} else {
				site.getPage().removePartListener(getLinkingPartListener());
				viewer.removeSelectionChangedListener(getLinkingSelectionListener());
			}
		}
	}

	protected void selectEditor() {
		URI uri = null;

		DIModel model = getDIModelFromSelection();
		if(model != null) {
			uri = model.getResource().getURI();
		} else {
			// just some other resource, then?
			CDOResourceLeaf resource = getCDOResourceFromSelection();
			if(resource != null) {
				uri = resource.getURI();
			}
		}

		if(uri != null) {
			for(IEditorReference next : site.getPage().getEditorReferences()) {
				try {
					IEditorInput input = next.getEditorInput();
					URI editorURI = EditorUtils.getResourceURI(input);
					if(editorURI == null) {
						// could be a CDO-ish editor
						editorURI = getURIFromCDOInput(input);
					}

					if(Objects.equal(uri, editorURI)) {
						site.getPage().activate(next.getPart(true));
						break;
					}
				} catch (PartInitException e) {
					Activator.log.error(e);
				}
			}
		}
	}

	protected void handleEditor(IEditorPart activeEditor) {
		if(activeEditor != null) {
			IEditorInput input = activeEditor.getEditorInput();
			if(input instanceof URIEditorInput) {
				URI uri = ((URIEditorInput)input).getURI();

				DIModel selected = getDIModelFromSelection();
				if((selected == null) || !selected.getResource().getURI().equals(uri)) {

					// change the selection
					DIModel model = findDIModel(uri);
					if(model != null) {
						viewer.setSelection(new StructuredSelection(model), true);
					}
				}
			} else {
				URI uri = getURIFromCDOInput(input);

				if(uri != null) {
					CDOResourceLeaf selected = getCDOResourceFromSelection();
					if((selected == null || !selected.getURI().equals(uri))) {
						// change the selected
						CDOResourceLeaf resource = findCDOResource(uri);
						if(resource != null) {
							viewer.setSelection(new StructuredSelection(resource), true);
						}
					}
				}
			}
		}
	}

	private URI getURIFromCDOInput(IEditorInput input) {
		URI result = null;

		if(input instanceof CDOEditorInput) {
			CDOEditorInput cdoInput = (CDOEditorInput)input;

			try {
				CDOResourceNode node = cdoInput.getView().getResourceNode(cdoInput.getResourcePath());
				result = node.getURI();
			} catch (Exception e) {
				// normal case of no such resource in this view
			}
		} else if(input instanceof org.eclipse.emf.cdo.internal.ui.CDOLobEditorInput) {
			org.eclipse.emf.cdo.internal.ui.CDOLobEditorInput cdoInput = (org.eclipse.emf.cdo.internal.ui.CDOLobEditorInput)input;
			result = cdoInput.getResource().getURI();
		}

		return result;
	}

	protected DIModel getDIModelFromSelection() {
		IStructuredSelection sel = (viewer == null) ? StructuredSelection.EMPTY : (IStructuredSelection)viewer.getSelection();

		return sel.isEmpty() ? null : getDIModelFromSelection(sel.getFirstElement());
	}

	protected DIModel getDIModelFromSelection(Object selected) {
		DIModel result = null;

		if(selected instanceof DIModel) {
			result = (DIModel)selected;
		} else if(selected instanceof CDOResource) {
			Object parent = ((ITreeContentProvider)viewer.getContentProvider()).getParent(selected);
			if(parent instanceof DIModel) {
				result = (DIModel)parent;
			}
		}

		return result;
	}

	protected DIModel findDIModel(URI uri) {
		DIModel result = null;

		CDOResource res = CDOUtils.tryCast(findCDOResource(uri), CDOResource.class);
		if((res != null) && res.isLoaded()) {
			result = DIModel.getInstance(res, true);
		}

		return result;
	}

	protected CDOResourceLeaf getCDOResourceFromSelection() {
		IStructuredSelection sel = (viewer == null) ? StructuredSelection.EMPTY : (IStructuredSelection)viewer.getSelection();

		return sel.isEmpty() ? null : getCDOResourceFromSelection(sel.getFirstElement());
	}

	protected CDOResourceLeaf getCDOResourceFromSelection(Object selected) {
		// we adapt things usually to CDOResourceNode interface, not CDOResourceLeaf
		return CDOUtils.tryCast(CDOUtils.adapt(selected, CDOResourceNode.class), CDOResourceLeaf.class);
	}

	protected CDOResourceLeaf findCDOResource(URI uri) {
		CDOResourceLeaf result = null;

		IInternalPapyrusRepository repo = (IInternalPapyrusRepository)repositoryManager.getRepositoryForURI(uri);
		if(repo != null) {
			CDOView mainView = repo.getMasterView();
			if((mainView != null) && !mainView.isClosed()) {
				try {
					result = CDOUtils.tryCast(mainView.getResourceNode(CDOURIUtil.extractResourcePath(uri)), CDOResourceLeaf.class);
				} catch (Exception e) {
					// normal consequence of no such resource
				}
			}
		}

		return result;
	}

	private IPartListener getLinkingPartListener() {
		if(linkingPartListener == null) {
			linkingPartListener = new IPartListener() {

				@Override
				public void partActivated(IWorkbenchPart part) {
					if(part instanceof IEditorPart) {
						handleEditor((IEditorPart)part);
					}
				}

				@Override
				public void partOpened(IWorkbenchPart part) {
					// pass
				}

				@Override
				public void partDeactivated(IWorkbenchPart part) {
					// pass
				}

				@Override
				public void partClosed(IWorkbenchPart part) {
					// pass
				}

				@Override
				public void partBroughtToTop(IWorkbenchPart part) {
					// pass
				}
			};
		}

		return linkingPartListener;
	}

	private ISelectionChangedListener getLinkingSelectionListener() {
		if(linkingSelectionListener == null) {
			linkingSelectionListener = new ISelectionChangedListener() {

				@Override
				public void selectionChanged(SelectionChangedEvent event) {
					selectEditor();
				}
			};
		}

		return linkingSelectionListener;
	}

}
