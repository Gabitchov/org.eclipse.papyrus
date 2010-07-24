/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tatiana Fesenko (Borland) - initial API and implementation
 */
package org.eclipse.papyrus.diagram.common.part;

import java.util.Collections;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.edit.provider.IWrapperItemProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.WorkspaceEditingDomainFactory;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

public class UMLElementChooserDialog extends Dialog {

	private final AdapterFactory myItemProvidersAdapterFactory;

	private TreeViewer myTreeViewer;

	private URI mySelectedModelElementURI;

	private TransactionalEditingDomain myEditingDomain = WorkspaceEditingDomainFactory.INSTANCE.createEditingDomain();

	public UMLElementChooserDialog(Shell parentShell, AdapterFactory itemProvidersAdapterFactory) {
		super(parentShell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		myItemProvidersAdapterFactory = itemProvidersAdapterFactory;
	}

	@Override
	protected Control createContents(Composite parent) {
		Control control = super.createContents(parent);
		setSelection(myTreeViewer);
		return control;
	}

	protected void setSelection(TreeViewer treeViewer) {

	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite)super.createDialogArea(parent);
		getShell().setText("Select model element");
		createModelBrowser(composite);
		setInput(myTreeViewer);
		return composite;
	}

	@Override
	protected Control createButtonBar(Composite parent) {
		Control buttonBar = super.createButtonBar(parent);
		setOkButtonEnabled(false);
		return buttonBar;
	}

	private void createModelBrowser(Composite composite) {
		myTreeViewer = new TreeViewer(composite, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		GridData layoutData = new GridData(GridData.FILL_BOTH);
		layoutData.heightHint = 300;
		layoutData.widthHint = 300;
		myTreeViewer.getTree().setLayoutData(layoutData);
		myTreeViewer.setContentProvider(new ModelElementsTreeContentProvider());
		myTreeViewer.setLabelProvider(new ModelElementsTreeLabelProvider());
		myTreeViewer.addSelectionChangedListener(new OkButtonEnabler());
	}

	protected void setInput(TreeViewer treeViewer) {

	}

	private void setOkButtonEnabled(boolean enabled) {
		getButton(IDialogConstants.OK_ID).setEnabled(enabled);
	}

	public URI getSelectedModelElementURI() {
		return mySelectedModelElementURI;
	}

	@Override
	public int open() {
		int result = super.open();
		for(Iterator it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();) {
			Resource resource = (Resource)it.next();
			resource.unload();
		}
		myEditingDomain.dispose();
		return result;
	}

	protected boolean isValid(EObject selectedElement) {
		return false;
	}

	private class ModelElementsTreeContentProvider implements ITreeContentProvider {

		private ITreeContentProvider myWorkbenchContentProvider = new WorkbenchContentProvider();

		private AdapterFactoryContentProvider myAdapterFctoryContentProvier = new AdapterFactoryContentProvider(myItemProvidersAdapterFactory);

		public Object[] getChildren(Object parentElement) {
			Object[] result = myWorkbenchContentProvider.getChildren(parentElement);
			if(result != null && result.length > 0) {
				return result;
			}
			if(parentElement instanceof IFile) {
				IFile modelFile = (IFile)parentElement;
				IPath resourcePath = modelFile.getFullPath();
				ResourceSet resourceSet = myEditingDomain.getResourceSet();
				try {
					Resource modelResource = resourceSet.getResource(URI.createPlatformResourceURI(resourcePath.toString(), true), true);
					return myAdapterFctoryContentProvier.getChildren(modelResource);
				} catch (WrappedException e) {
					e.printStackTrace();
					//
				}
				return Collections.EMPTY_LIST.toArray();
			}
			return myAdapterFctoryContentProvier.getChildren(parentElement);
		}

		public Object getParent(Object element) {
			Object parent = myWorkbenchContentProvider.getParent(element);
			if(parent != null) {
				return parent;
			}
			if(false == element instanceof EObject) {
				return null;
			}
			EObject eObject = (EObject)element;
			if(eObject.eContainer() == null && eObject.eResource().getURI().isFile()) {
				String path = eObject.eResource().getURI().path();
				return ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(new Path(path));
			}
			return myAdapterFctoryContentProvier.getParent(eObject);
		}

		public boolean hasChildren(Object element) {
			if(element instanceof IFile) {
				return isValidModelFile((IFile)element);
			}
			return myWorkbenchContentProvider.hasChildren(element) || myAdapterFctoryContentProvier.hasChildren(element);
		}

		private boolean isValidModelFile(IFile file) {
			String fileExtension = file.getFullPath().getFileExtension();
			return "uml".equals(fileExtension); //$NON-NLS-1$
		}

		public Object[] getElements(Object inputElement) {
			Object[] elements = myWorkbenchContentProvider.getElements(inputElement);
			if(elements != null && elements.length > 0) {
				return elements;
			}
			if(false == inputElement instanceof Resource) {
				return Collections.EMPTY_LIST.toArray();
			}
			Resource modelResource = (Resource)inputElement;
			return myAdapterFctoryContentProvier.getChildren(modelResource);
		}

		public void dispose() {
			myAdapterFctoryContentProvier.dispose();
			myWorkbenchContentProvider.dispose();
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			myWorkbenchContentProvider.inputChanged(viewer, oldInput, newInput);
			myAdapterFctoryContentProvier.inputChanged(viewer, oldInput, newInput);
		}

	}

	private class ModelElementsTreeLabelProvider implements ILabelProvider {

		private WorkbenchLabelProvider myWorkbenchLabelProvider = new WorkbenchLabelProvider();

		private AdapterFactoryLabelProvider myAdapterFactoryLabelProvider = new AdapterFactoryLabelProvider(myItemProvidersAdapterFactory);

		public Image getImage(Object element) {
			Image result = myWorkbenchLabelProvider.getImage(element);
			return result != null ? result : myAdapterFactoryLabelProvider.getImage(element);
		}

		public String getText(Object element) {
			String result = myWorkbenchLabelProvider.getText(element);
			return result != null && result.length() > 0 ? result : myAdapterFactoryLabelProvider.getText(element);
		}

		public void addListener(ILabelProviderListener listener) {
			myWorkbenchLabelProvider.addListener(listener);
			myAdapterFactoryLabelProvider.addListener(listener);
		}

		public void dispose() {
			myWorkbenchLabelProvider.dispose();
			myAdapterFactoryLabelProvider.dispose();
		}

		public boolean isLabelProperty(Object element, String property) {
			return myWorkbenchLabelProvider.isLabelProperty(element, property) || myAdapterFactoryLabelProvider.isLabelProperty(element, property);
		}

		public void removeListener(ILabelProviderListener listener) {
			myWorkbenchLabelProvider.removeListener(listener);
			myAdapterFactoryLabelProvider.removeListener(listener);
		}

	}

	private class OkButtonEnabler implements ISelectionChangedListener {

		public void selectionChanged(SelectionChangedEvent event) {
			if(event.getSelection() instanceof IStructuredSelection) {
				IStructuredSelection selection = (IStructuredSelection)event.getSelection();
				if(selection.size() == 1) {
					Object selectedElement = selection.getFirstElement();
					if(selectedElement instanceof IWrapperItemProvider) {
						selectedElement = ((IWrapperItemProvider)selectedElement).getValue();
					}
					if(selectedElement instanceof FeatureMap.Entry) {
						selectedElement = ((FeatureMap.Entry)selectedElement).getValue();
					}
					if(selectedElement instanceof EObject) {
						EObject selectedModelElement = (EObject)selectedElement;
						setOkButtonEnabled(isValid(selectedModelElement));
						mySelectedModelElementURI = EcoreUtil.getURI(selectedModelElement);
						return;
					}
				}
			}
			mySelectedModelElementURI = null;
			setOkButtonEnabled(false);
		}
	}

}
