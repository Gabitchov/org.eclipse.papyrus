/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher (CEA LIST) ansgar.radermacher@cea.fr - Initial API and implementation
 *  Based on edit policy view from patrick.tessier@cea.fr
 */
package org.eclipse.papyrus.infra.extendedtypes.elementtypeview.view;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.extendedtypes.elementtypeview.Activator;
import org.eclipse.papyrus.infra.services.edit.internal.context.TypeContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

/**
 * This class shows the figure hierarchy attached to a edit-part
 * 
 */
public class ElementTypeView extends ViewPart {

	private ISelectionListener myEditPartlistener;

	private TreeViewer viewer;

	private CLabel selectedElement;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	public void setFocus() {
		Viewer viewer = getViewer();
		if(viewer != null && !viewer.getControl().isDisposed()) {
			viewer.getControl().setFocus();
		}
	}

	/**
	 * Create the main tree control
	 * 
	 * @param parent
	 * @return Tree
	 */
	protected Tree createTree(Composite parent) {
		Tree tree = new Tree(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI | SWT.FULL_SELECTION);
		tree.setLinesVisible(true);
		return tree;
	}

	/**
	 * Return the viewer.
	 * 
	 * @return TreeViewer
	 */
	protected TreeViewer getViewer() {
		return viewer;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public ElementTypeView() {
		myEditPartlistener = new ISelectionListener() {

			public void selectionChanged(IWorkbenchPart part, ISelection selection) {
				if(selection instanceof IStructuredSelection) {
					Object selectedobject = ((IStructuredSelection)selection).getFirstElement();
					IClientContext papyrusContext;
					try {
						papyrusContext = TypeContext.getContext();
					} catch (ServiceException e) {
						Activator.log.error(e);
						if(viewer != null) {
							viewer.setInput(new Object[0]);
							viewer.expandAll();
						}
						return;
					}
					EObject selectedEObject = null;
					if(selectedobject instanceof EObject) {
						selectedEObject = (EObject)selectedobject;
					} else if(selectedobject instanceof IAdaptable) {
						selectedEObject = (EObject)((IAdaptable)selectedobject).getAdapter(EObject.class);
					}
					
					if(selectedElement != null && !selectedElement.isDisposed()) {
						selectedElement.setText((selectedEObject != null ) ? selectedEObject.toString() : ""  );
					}
					
					if(viewer != null) {
						if(selectedEObject ==null) {
							viewer.setInput(new IElementType[0]);
						} else {
							viewer.setInput(ElementTypeRegistry.getInstance().getAllTypesMatching(selectedEObject, papyrusContext));
							viewer.expandAll();	
						}
					}
				}
			}
		};
		ISelectionService selectionService = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();
		selectionService.addSelectionListener(myEditPartlistener);
	}

	protected void createColumns() {
		viewer.getTree().setHeaderVisible(true);
		viewer.getTree().setLinesVisible(true);
		TreeColumn tcName = new TreeColumn(viewer.getTree(), SWT.LEFT);
		tcName.setText("Element Type");
		tcName.setWidth(300);
		TreeColumn tcIdentifier = new TreeColumn(viewer.getTree(), SWT.LEFT);
		tcIdentifier.setText("Identifier");
		tcIdentifier.setWidth(250);
		//		TreeColumn tcLayoutManager = new TreeColumn(viewer.getTree(), SWT.LEFT);
		//		tcLayoutManager.setText("Layout manager");
		//		tcLayoutManager.setWidth(150);
		//		TreeColumn tcBorder = new TreeColumn(viewer.getTree(), SWT.LEFT);
		//		tcBorder.setText("Border");
		//		tcBorder.setWidth(150);
	}

	@Override
	public void createPartControl(final org.eclipse.swt.widgets.Composite parent) {
		final IToolBarManager tbm = getViewSite().getActionBars().getToolBarManager();
		tbm.add(getClearViewAction());
		Composite composite = new Composite(parent, SWT.BORDER);
		composite.setLayout(new GridLayout(1, true));
		selectedElement = new CLabel(composite, SWT.NONE);
		selectedElement.setText("<no element>");
		selectedElement.setLayoutData(new GridData(SWT.FILL,  SWT.FILL, true, false));
		Tree tree= createTree(composite);
		tree.setLayoutData(new GridData(SWT.FILL,  SWT.FILL, true, true));
		viewer = new TreeViewer(tree);
		viewer.setContentProvider(getContentProvider());
		viewer.setLabelProvider(getLabelProvider());
		createColumns();
	}

	protected ITableLabelProvider getLabelProvider() {
		return new ElementTypeLabelProvider();
	}

	protected Action getClearViewAction() {
		return new Action() {

			@Override
			public void run() {
				clear();
			}

			@Override
			public boolean isEnabled() {
				return true;
			}

			@Override
			public String getToolTipText() {
				return getText();
			}

			@Override
			public String getText() {
				return "Clear the view";
			}
		};
	}

	protected IContentProvider getContentProvider() {
		return new ITreeContentProvider() {

			public Object[] getElements(final Object inputElement) {
				if(inputElement instanceof IElementType[]) {
					return (IElementType[])inputElement;
				}
				return null;
			}

			public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
				// nothing
			}

			public void dispose() {
				// nothing
			}

			public boolean hasChildren(final Object element) {
				return false;
			}

			public Object getParent(final Object element) {
				return null;
			}

			public Object[] getChildren(final Object parentElement) {
				return new Object[0];
			}
		};
	}

	@Override
	public void dispose() {
		super.dispose();
		ISelectionService selectionService = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();
		selectionService.removeSelectionListener(myEditPartlistener);
	}

	private void clear() {
		selectedElement.setText("");
		viewer.setInput(null);
	}
}
