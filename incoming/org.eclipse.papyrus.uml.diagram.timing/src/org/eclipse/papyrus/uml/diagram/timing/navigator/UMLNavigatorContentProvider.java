/*
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.uml.diagram.timing.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.WorkspaceEditingDomainFactory;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimingDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLVisualIDRegistry;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
public class UMLNavigatorContentProvider implements ICommonContentProvider {
	/**
	 * @generated
	 */
	private static final Object[] EMPTY_ARRAY = new Object[0];
	/**
	 * @generated
	 */
	private Viewer myViewer;
	/**
	 * @generated
	 */
	private AdapterFactoryEditingDomain myEditingDomain;
	/**
	 * @generated
	 */
	private WorkspaceSynchronizer myWorkspaceSynchronizer;
	/**
	 * @generated
	 */
	private Runnable myViewerRefreshRunnable;

	/**
	 * @generated
	 */
	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	public UMLNavigatorContentProvider() {
		final TransactionalEditingDomain editingDomain = WorkspaceEditingDomainFactory.INSTANCE.createEditingDomain();
		this.myEditingDomain = (AdapterFactoryEditingDomain) editingDomain;
		this.myEditingDomain.setResourceToReadOnlyMap(new HashMap() {
			@Override
			public Object get(final Object key) {
				if (!containsKey(key)) {
					put(key, Boolean.TRUE);
				}
				return super.get(key);
			}
		});
		this.myViewerRefreshRunnable = new Runnable() {
			public void run() {
				if (UMLNavigatorContentProvider.this.myViewer != null) {
					UMLNavigatorContentProvider.this.myViewer.refresh();
				}
			}
		};
		this.myWorkspaceSynchronizer = new WorkspaceSynchronizer(editingDomain, new WorkspaceSynchronizer.Delegate() {
			public void dispose() {
			}

			public boolean handleResourceChanged(final Resource resource) {
				for (final Object element : UMLNavigatorContentProvider.this.myEditingDomain.getResourceSet().getResources()) {
					final Resource nextResource = (Resource) element;
					nextResource.unload();
				}
				if (UMLNavigatorContentProvider.this.myViewer != null) {
					UMLNavigatorContentProvider.this.myViewer.getControl().getDisplay().asyncExec(UMLNavigatorContentProvider.this.myViewerRefreshRunnable);
				}
				return true;
			}

			public boolean handleResourceDeleted(final Resource resource) {
				for (final Object element : UMLNavigatorContentProvider.this.myEditingDomain.getResourceSet().getResources()) {
					final Resource nextResource = (Resource) element;
					nextResource.unload();
				}
				if (UMLNavigatorContentProvider.this.myViewer != null) {
					UMLNavigatorContentProvider.this.myViewer.getControl().getDisplay().asyncExec(UMLNavigatorContentProvider.this.myViewerRefreshRunnable);
				}
				return true;
			}

			public boolean handleResourceMoved(final Resource resource, final URI newURI) {
				for (final Object element : UMLNavigatorContentProvider.this.myEditingDomain.getResourceSet().getResources()) {
					final Resource nextResource = (Resource) element;
					nextResource.unload();
				}
				if (UMLNavigatorContentProvider.this.myViewer != null) {
					UMLNavigatorContentProvider.this.myViewer.getControl().getDisplay().asyncExec(UMLNavigatorContentProvider.this.myViewerRefreshRunnable);
				}
				return true;
			}
		});
	}

	/**
	 * @generated
	 */
	public void dispose() {
		this.myWorkspaceSynchronizer.dispose();
		this.myWorkspaceSynchronizer = null;
		this.myViewerRefreshRunnable = null;
		for (final Object element : this.myEditingDomain.getResourceSet().getResources()) {
			final Resource resource = (Resource) element;
			resource.unload();
		}
		((TransactionalEditingDomain) this.myEditingDomain).dispose();
		this.myEditingDomain = null;
	}

	/**
	 * @generated
	 */
	public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
		this.myViewer = viewer;
	}

	/**
	 * @generated
	 */
	public Object[] getElements(final Object inputElement) {
		return getChildren(inputElement);
	}

	/**
	 * @generated
	 */
	public void restoreState(final IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(final IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void init(final ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public Object[] getChildren(final Object parentElement) {
		if (parentElement instanceof IFile) {
			final IFile file = (IFile) parentElement;
			final URI fileURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			final Resource resource = this.myEditingDomain.getResourceSet().getResource(fileURI, true);
			final Collection result = new ArrayList();
			return result.toArray();
		}

		if (parentElement instanceof UMLNavigatorGroup) {
			final UMLNavigatorGroup group = (UMLNavigatorGroup) parentElement;
			return group.getChildren();
		}

		if (parentElement instanceof UMLNavigatorItem) {
			final UMLNavigatorItem navigatorItem = (UMLNavigatorItem) parentElement;
			if (navigatorItem.isLeaf() || !isOwnView(navigatorItem.getView())) {
				return EMPTY_ARRAY;
			}
			return getViewChildren(navigatorItem.getView(), parentElement);
		}

		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Object[] getViewChildren(final View view, final Object parentElement) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {

		}
		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Collection getLinksSourceByType(final Collection edges, final String type) {
		final Collection result = new ArrayList();
		for (final Iterator it = edges.iterator(); it.hasNext();) {
			final Edge nextEdge = (Edge) it.next();
			final View nextEdgeSource = nextEdge.getSource();
			if (type.equals(nextEdgeSource.getType()) && isOwnView(nextEdgeSource)) {
				result.add(nextEdgeSource);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getLinksTargetByType(final Collection edges, final String type) {
		final Collection result = new ArrayList();
		for (final Iterator it = edges.iterator(); it.hasNext();) {
			final Edge nextEdge = (Edge) it.next();
			final View nextEdgeTarget = nextEdge.getTarget();
			if (type.equals(nextEdgeTarget.getType()) && isOwnView(nextEdgeTarget)) {
				result.add(nextEdgeTarget);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getOutgoingLinksByType(final Collection nodes, final String type) {
		final Collection result = new ArrayList();
		for (final Iterator it = nodes.iterator(); it.hasNext();) {
			final View nextNode = (View) it.next();
			result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getIncomingLinksByType(final Collection nodes, final String type) {
		final Collection result = new ArrayList();
		for (final Iterator it = nodes.iterator(); it.hasNext();) {
			final View nextNode = (View) it.next();
			result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getChildrenByType(final Collection nodes, final String type) {
		final Collection result = new ArrayList();
		for (final Iterator it = nodes.iterator(); it.hasNext();) {
			final View nextNode = (View) it.next();
			result.addAll(selectViewsByType(nextNode.getChildren(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getDiagramLinksByType(final Collection diagrams, final String type) {
		final Collection result = new ArrayList();
		for (final Iterator it = diagrams.iterator(); it.hasNext();) {
			final Diagram nextDiagram = (Diagram) it.next();
			result.addAll(selectViewsByType(nextDiagram.getEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection selectViewsByType(final Collection views, final String type) {
		final Collection result = new ArrayList();
		for (final Iterator it = views.iterator(); it.hasNext();) {
			final View nextView = (View) it.next();
			if (type.equals(nextView.getType()) && isOwnView(nextView)) {
				result.add(nextView);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(final View view) {
		return TimingDiagramEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(view));
	}

	/**
	 * @generated
	 */
	private Collection createNavigatorItems(final Collection views, final Object parent, final boolean isLeafs) {
		final Collection result = new ArrayList();
		for (final Iterator it = views.iterator(); it.hasNext();) {
			result.add(new UMLNavigatorItem((View) it.next(), parent, isLeafs));
		}
		return result;
	}

	/**
	 * @generated
	 */
	public Object getParent(final Object element) {
		if (element instanceof UMLAbstractNavigatorItem) {
			final UMLAbstractNavigatorItem abstractNavigatorItem = (UMLAbstractNavigatorItem) element;
			return abstractNavigatorItem.getParent();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean hasChildren(final Object element) {
		return element instanceof IFile || getChildren(element).length > 0;
	}

}
