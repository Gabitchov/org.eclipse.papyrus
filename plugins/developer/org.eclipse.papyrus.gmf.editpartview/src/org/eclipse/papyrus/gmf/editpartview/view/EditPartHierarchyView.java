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
package org.eclipse.papyrus.gmf.editpartview.view;

import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

/**
 * This view shows the edit-part hierarchy when an edit part is selected
 */
public class EditPartHierarchyView extends ViewPart {

	private ISelectionListener myEditPartlistener;

	private TreeViewer viewer;

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
		Tree tree = new Tree(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI
			| SWT.FULL_SELECTION);
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
	public EditPartHierarchyView() {
		myEditPartlistener = new ISelectionListener() {

			public void selectionChanged(IWorkbenchPart part, ISelection selection) {

				if(selection instanceof IStructuredSelection) {
					Object selectedobject = ((IStructuredSelection)selection).getFirstElement();
					if(selectedobject instanceof GraphicalEditPart) {
						GraphicalEditPart graphicalEP = ((GraphicalEditPart)selectedobject);

						if(viewer != null) {
							viewer.setInput(new Object[]{ graphicalEP });
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
		tcName.setText("EditPart");
		tcName.setWidth(150);
		TreeColumn tcModelElement = new TreeColumn(viewer.getTree(), SWT.LEFT);
		tcModelElement.setText("Model element");
		tcModelElement.setWidth(150);
		TreeColumn tcFigure = new TreeColumn(viewer.getTree(), SWT.LEFT);
		tcFigure.setText("Figure");
		tcFigure.setWidth(150);
		TreeColumn tcFigBounds = new TreeColumn(viewer.getTree(), SWT.LEFT);
		tcFigBounds.setText("Figure bounds");
		tcFigBounds.setWidth(150);
	}

	@Override
	public void createPartControl(final org.eclipse.swt.widgets.Composite parent) {
		final IToolBarManager tbm = getViewSite().getActionBars().getToolBarManager();
		tbm.add(getClearViewAction());
		viewer = new TreeViewer(createTree(parent));
		viewer.setContentProvider(getContentProvider());
		viewer.setLabelProvider(getLabelProvider());
		createColumns();

	}

	protected ITableLabelProvider getLabelProvider() {
		return new EditPartLabelProvider();
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
				if(inputElement instanceof Object[]) {
					return (Object[])inputElement;
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

				return getChildren(element).length != 0;
			}

			public Object getParent(final Object element) {
				return null;
			}

			public Object[] getChildren(final Object parentElement) {
				if(parentElement instanceof GraphicalEditPart) {
					return ((GraphicalEditPart)parentElement).getChildren().toArray();
				}
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
		viewer.setInput(null);
	}
}
