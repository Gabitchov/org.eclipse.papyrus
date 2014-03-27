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
package org.eclipse.papyrus.gmf.figureview.view;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
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
 * This class shows the figure hierarchy attached to a edit-part
 * 
 */
public class FigureHierarchyView extends ViewPart {

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
	public FigureHierarchyView() {
		myEditPartlistener = new ISelectionListener() {

			public void selectionChanged(IWorkbenchPart part, ISelection selection) {

				if(selection instanceof IStructuredSelection) {
					Object selectedobject = ((IStructuredSelection)selection).getFirstElement();
					if(selectedobject instanceof GraphicalEditPart) {
						GraphicalEditPart graphicalEP = ((GraphicalEditPart)selectedobject);
						IFigure figure = graphicalEP.getContentPane();

						if(viewer != null) {
							viewer.setInput(new Object[]{ figure });
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
		tcName.setText("Figure"); //$NON-NLS-1$
		tcName.setWidth(300);
		TreeColumn tcFigBounds = new TreeColumn(viewer.getTree(), SWT.LEFT);
		tcFigBounds.setText("Figure bounds"); //$NON-NLS-1$
		tcFigBounds.setWidth(250);
		TreeColumn tcLayoutManager = new TreeColumn(viewer.getTree(), SWT.LEFT);
		tcLayoutManager.setText("Layout manager"); //$NON-NLS-1$
		tcLayoutManager.setWidth(150);
		TreeColumn tcBorder = new TreeColumn(viewer.getTree(), SWT.LEFT);
		tcBorder.setText("Border (width)"); //$NON-NLS-1$
		tcBorder.setWidth(150);
		TreeColumn tcLineWidth = new TreeColumn(viewer.getTree(), SWT.LEFT);
		tcLineWidth.setText("Line width"); //$NON-NLS-1$
		tcLineWidth.setWidth(100);
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
		return new FigureLabelProvider();
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
				if(parentElement instanceof IFigure) {
					return ((IFigure)parentElement).getChildren().toArray();
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
