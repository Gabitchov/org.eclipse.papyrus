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

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.WorkspaceEditingDomainFactory;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLDiagramEditorPlugin;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
public class UMLDomainNavigatorContentProvider implements ICommonContentProvider {

	/**
	 * @generated
	 */
	private AdapterFactoryContentProvider myAdapterFctoryContentProvier;

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
	public UMLDomainNavigatorContentProvider() {
		this.myAdapterFctoryContentProvier = new AdapterFactoryContentProvider(UMLDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());
		final TransactionalEditingDomain editingDomain = WorkspaceEditingDomainFactory.INSTANCE.createEditingDomain();
		this.myEditingDomain = (AdapterFactoryEditingDomain)editingDomain;
		this.myEditingDomain.setResourceToReadOnlyMap(new HashMap() {

			@Override
			public Object get(final Object key) {
				if(!containsKey(key)) {
					put(key, Boolean.TRUE);
				}
				return super.get(key);
			}
		});
		this.myViewerRefreshRunnable = new Runnable() {

			public void run() {
				if(UMLDomainNavigatorContentProvider.this.myViewer != null) {
					UMLDomainNavigatorContentProvider.this.myViewer.refresh();
				}
			}
		};
		this.myWorkspaceSynchronizer = new WorkspaceSynchronizer(editingDomain, new WorkspaceSynchronizer.Delegate() {

			public void dispose() {
			}

			public boolean handleResourceChanged(final Resource resource) {
				for(final Object element : UMLDomainNavigatorContentProvider.this.myEditingDomain.getResourceSet().getResources()) {
					final Resource nextResource = (Resource)element;
					nextResource.unload();
				}
				if(UMLDomainNavigatorContentProvider.this.myViewer != null) {
					UMLDomainNavigatorContentProvider.this.myViewer.getControl().getDisplay().asyncExec(UMLDomainNavigatorContentProvider.this.myViewerRefreshRunnable);
				}
				return true;
			}

			public boolean handleResourceDeleted(final Resource resource) {
				for(final Object element : UMLDomainNavigatorContentProvider.this.myEditingDomain.getResourceSet().getResources()) {
					final Resource nextResource = (Resource)element;
					nextResource.unload();
				}
				if(UMLDomainNavigatorContentProvider.this.myViewer != null) {
					UMLDomainNavigatorContentProvider.this.myViewer.getControl().getDisplay().asyncExec(UMLDomainNavigatorContentProvider.this.myViewerRefreshRunnable);
				}
				return true;
			}

			public boolean handleResourceMoved(final Resource resource, final URI newURI) {
				for(final Object element : UMLDomainNavigatorContentProvider.this.myEditingDomain.getResourceSet().getResources()) {
					final Resource nextResource = (Resource)element;
					nextResource.unload();
				}
				if(UMLDomainNavigatorContentProvider.this.myViewer != null) {
					UMLDomainNavigatorContentProvider.this.myViewer.getControl().getDisplay().asyncExec(UMLDomainNavigatorContentProvider.this.myViewerRefreshRunnable);
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
		for(final Object element : this.myEditingDomain.getResourceSet().getResources()) {
			final Resource resource = (Resource)element;
			resource.unload();
		}
		((TransactionalEditingDomain)this.myEditingDomain).dispose();
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
		if(parentElement instanceof IFile) {
			final IFile file = (IFile)parentElement;
			final URI fileURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			final Resource resource = this.myEditingDomain.getResourceSet().getResource(fileURI, true);
			return wrapEObjects(this.myAdapterFctoryContentProvier.getChildren(resource), parentElement);
		}

		if(parentElement instanceof UMLDomainNavigatorItem) {
			return wrapEObjects(this.myAdapterFctoryContentProvier.getChildren(((UMLDomainNavigatorItem)parentElement).getEObject()), parentElement);
		}
		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	public Object[] wrapEObjects(final Object[] objects, final Object parentElement) {
		final Collection result = new ArrayList();
		for(final Object object : objects) {
			if(object instanceof EObject) {
				result.add(new UMLDomainNavigatorItem((EObject)object, parentElement, this.myAdapterFctoryContentProvier));
			}
		}
		return result.toArray();
	}

	/**
	 * @generated
	 */
	public Object getParent(final Object element) {
		if(element instanceof UMLAbstractNavigatorItem) {
			final UMLAbstractNavigatorItem abstractNavigatorItem = (UMLAbstractNavigatorItem)element;
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
