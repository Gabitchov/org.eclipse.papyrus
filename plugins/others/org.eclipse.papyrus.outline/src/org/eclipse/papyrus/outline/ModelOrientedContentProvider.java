/***********************************************************************
 * Copyright (c) 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 * 
 * $Id$
 **********************************************************************/
package org.eclipse.papyrus.outline;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IWrapperItemProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.gmf.runtime.diagram.ui.util.SelectInDiagramHelper;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.core.Activator;
import org.eclipse.papyrus.core.editor.MultiDiagramEditor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;
import org.eclipse.uml2.uml.edit.providers.UMLItemProviderAdapterFactory;

/**
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques Lescot</a>
 */
public class ModelOrientedContentProvider implements ICommonContentProvider {

	private AdapterFactoryContentProvider myAdapterFactoryContentProvider;

	private static final Object[] EMPTY_ARRAY = new Object[0];

	private AdditionalResources resources;

	private Diagram currentDiagram;

	private TreeViewer viewer;

	private Adapter modelListener = new AdapterImpl() {

		/**
		 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
		 */
		@Override
		public void notifyChanged(Notification msg) {
			refreshViewer(true);
		}

	};

	public ModelOrientedContentProvider() {
		List<AdapterFactory> factories = new ArrayList<AdapterFactory>();
		factories.add(new UMLItemProviderAdapterFactory());
		factories.add(new EcoreItemProviderAdapterFactory());
		factories.add(new ResourceItemProviderAdapterFactory());
		factories.add(new ReflectiveItemProviderAdapterFactory());
		myAdapterFactoryContentProvider = new AdapterFactoryContentProvider(new ComposedAdapterFactory(factories));
	}

	public TreeViewer getTreeViewer() {
		return viewer;
	}

	/**
	 * Refresh the tree viewer in the UI thread if we are in a different thread
	 */
	protected final void refreshViewer() {
		refreshViewer(false);
	}

	/**
	 * Refresh the tree viewer in the UI thread if we are in a different thread
	 * 
	 * @param updateLabel
	 *            <code>true</code> if the label must be refreshed
	 */
	protected final void refreshViewer(final boolean updateLabel) {
		if ((viewer != null) && !viewer.getControl().isDisposed()) {
			if (Display.getCurrent() != Display.getDefault()) {
				syncRefreshViewer(updateLabel);
			} else {
				viewer.refresh(updateLabel);
			}
		}
	}

	/**
	 * Refresh the tree viewer in the UI thread
	 * 
	 * @param updateLabel
	 *            <code>true</code> if the label must be refreshed
	 */
	private void syncRefreshViewer(final boolean updateLabel) {
		viewer.getControl().getDisplay().syncExec(new Runnable() {

			public void run() {
				viewer.refresh(updateLabel);
			}
		});
	}

	/**
	 * Add listeners : <br>
	 * - on the model<br>
	 */
	protected void hookListeners() {
		// As when a Resource is modified, unload() is called on each Resource,
		// we need to ensure that currentDiagram.eResource() is not null
		if (currentDiagram != null && currentDiagram.eResource() != null && !currentDiagram.eResource().eAdapters().contains(modelListener)) {
			currentDiagram.eResource().eAdapters().add(modelListener);
		}
		this.getTreeViewer().addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				handleDoubleClickEvent();
			}
		});
	}

	/**
	 * Remove listeners
	 */
	protected void unhookListeners() {
		if (currentDiagram != null && currentDiagram.eResource() != null && currentDiagram.eResource().eAdapters().contains(modelListener)) {
			currentDiagram.eResource().eAdapters().remove(modelListener);
		}
	}

	public void dispose() {
		// Dispose objects
		unhookListeners();
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.viewer = (TreeViewer) viewer;
		myAdapterFactoryContentProvider.inputChanged(viewer, oldInput, newInput);
	}

	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof Diagram) {

			if (((Diagram) inputElement).eResource() != null) {
				currentDiagram = (Diagram) inputElement;

				EObject eObject = currentDiagram.getElement();
				Resource modelResource = EcoreUtil.getRootContainer(eObject).eResource();

				List<Object> children = new ArrayList<Object>(modelResource.getContents());

				resources = new AdditionalResources(modelResource.getResourceSet());
				children.add(resources);

				hookListeners();
				return children.toArray();
			}
		}

		return EMPTY_ARRAY;
	}

	public void restoreState(IMemento aMemento) {
	}

	public void saveState(IMemento aMemento) {
	}

	public void init(ICommonContentExtensionSite aConfig) {
	}

	public Object[] getChildren(Object parentElement) {
		// Only display diagram (no graphNodes or graphEdges)
		if (parentElement instanceof Diagram) {
			return EMPTY_ARRAY;
		}

		if (parentElement instanceof AdditionalResources) {
			return ((AdditionalResources) parentElement).getResources().toArray();
		}

		// In the case of a domain element :
		List<Object> children = new ArrayList<Object>();

		// 1. Retrieve children elements
		Object[] modelChildren = myAdapterFactoryContentProvider.getChildren(parentElement);
		for (int i = 0; i < modelChildren.length; i++) {
			Object child = modelChildren[i];
			children.add(child);
		}

		// 2. and associated diagrams
		if (parentElement instanceof EObject || parentElement instanceof IWrapperItemProvider || parentElement instanceof FeatureMap.Entry) {
			children.addAll(findAllExistingDiagram(currentDiagram.eResource(), (EObject) AdapterFactoryEditingDomain.unwrap(parentElement)));
		}

		return children.toArray();
	}

	private Collection<Diagram> findAllExistingDiagram(Resource diagramResource, EObject modelObject) {
		List<Diagram> diagrams = new ArrayList<Diagram>();
		if (diagramResource != null) {
			for (EObject content : diagramResource.getContents()) {
				if (content instanceof Diagram) {
					if (modelObject.equals(((Diagram) content).getElement())) {
						diagrams.add((Diagram) content);
					}
				}
			}
		}
		return diagrams;
	}

	public Object getParent(Object element) {
		// The parent of a diagram is the model object that contains it.
		if (element instanceof Diagram) {
			return ((Diagram) element).getElement();
		}

		// Delegates
		if (element instanceof IWrapperItemProvider || element instanceof FeatureMap.Entry || element instanceof EObject) {
			return myAdapterFactoryContentProvider.getParent(element);
		}

		return null;
	}

	public boolean hasChildren(Object element) {
		if (element instanceof Diagram) {
			return false;
		}

		return getChildren(element).length > 0;
	}

	private IEditorInput getEditorInput(Diagram diagram) {
		URI parentUri = diagram.eResource().getURI();
		URI uri = parentUri.appendFragment(diagram.eResource().getURIFragment(diagram));
		return new URIEditorInput(uri);
	}

	/**
	 * Handles a double click on the outline tree : if the selected element is a diagram, the currently edited diagram is switch in the editor.
	 */
	protected void handleDoubleClickEvent() {
		IStructuredSelection selection = (IStructuredSelection) this.getTreeViewer().getSelection();
		Object selectedObject = selection.getFirstElement();

		if (selectedObject != null && selectedObject instanceof Diagram) {
			// activate the selected Diagram
			if (SelectInDiagramHelper.activateDiagram((Diagram) selectedObject) == null) {
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				try {
					page.openEditor(getEditorInput((Diagram) selectedObject), getEditorID());
				} catch (PartInitException e) {
					Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Can't open UML Diagram Editor!"));
				}
			}
		}
	}

	/**
	 * Return the Editor ID
	 * 
	 * @return String the editor ID
	 */
	protected String getEditorID() {
		return MultiDiagramEditor.ID;
	}

}// No newline at end of file
