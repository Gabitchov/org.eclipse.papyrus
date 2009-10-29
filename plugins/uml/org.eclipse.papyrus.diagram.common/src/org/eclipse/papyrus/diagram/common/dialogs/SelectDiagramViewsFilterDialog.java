/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.dialogs;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.papyrus.diagram.common.providers.BaseViewInfoContentProvider;
import org.eclipse.papyrus.diagram.common.providers.BaseViewInfoLabelProvider;
import org.eclipse.papyrus.diagram.common.providers.ViewInfo;
import org.eclipse.papyrus.diagram.common.util.MDTUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TreeItem;

// TODO: Auto-generated Javadoc
/**
 * The Class SelectDiagramViewsFilterDialog.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
public class SelectDiagramViewsFilterDialog extends Dialog {

	/** The diagram. */
	private DiagramEditPart diagram = null;

	/** The view info. */
	private ViewInfo viewInfo = null;

	/** The tree viewer. */
	private TreeViewer treeViewer = null;

	/** The selected. */
	private Collection<Integer> selected = null;

	/**
	 * Instantiates a new select diagram views filter dialog.
	 * 
	 * @param parentShell
	 *            the parent shell
	 * @param diagram
	 *            the diagram
	 */
	// @unused
	public SelectDiagramViewsFilterDialog(IShellProvider parentShell, DiagramEditPart diagram) {
		super(parentShell);
		this.diagram = diagram;
	}

	/**
	 * Instantiates a new select diagram views filter dialog.
	 * 
	 * @param parentShell
	 *            the parent shell
	 * @param diagram
	 *            the diagram
	 */
	public SelectDiagramViewsFilterDialog(Shell parentShell, DiagramEditPart diagram) {
		super(parentShell);
		this.diagram = diagram;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 */
	@Override
	protected void okPressed() {
		buildSelected();
		super.okPressed();
	}

	/**
	 * Gets the diagram edit part.
	 * 
	 * @return the diagram edit part
	 */
	public DiagramEditPart getDiagramEditPart() {
		return diagram;
	}

	/**
	 * Gets the view info.
	 * 
	 * @return the view info
	 */
	public ViewInfo getViewInfo() {
		if (viewInfo == null) {
			Object adapter = getDiagramEditPart().getAdapter(ViewInfo.class);
			if (adapter instanceof ViewInfo) {
				viewInfo = (ViewInfo) adapter;
			}
		}
		return viewInfo;
	}

	/**
	 * Gets the tree viewer.
	 * 
	 * @return the tree viewer
	 */
	public TreeViewer getTreeViewer() {
		return treeViewer;
	}

	/**
	 * Gets the selected.
	 * 
	 * @return the selected
	 */
	public Collection<Integer> getSelected() {
		if (selected == null) {
			buildSelected();
		}
		return selected;
	}

	/**
	 * Builds the selected.
	 */
	protected void buildSelected() {
		selected = new ArrayList<Integer>();
		if (getTreeViewer() == null || getTreeViewer().getTree() == null
				|| getTreeViewer().getTree().getItems().length <= 0) {
			return;
		}
		for (TreeItem item : getTreeViewer().getTree().getItems()) {
			if (item.getChecked() == false) {
				Object data = item.getData();
				if (data instanceof ViewInfo) {
					selected.add(((ViewInfo) data).getVisualID());
				}
			}
			addViewInfos(item, selected);
		}
		return;
	}

	/**
	 * Adds the view infos.
	 * 
	 * @param root
	 *            the root
	 * @param infos
	 *            the infos
	 */
	protected void addViewInfos(TreeItem root, Collection<Integer> infos) {
		for (TreeItem item : root.getItems()) {
			if (item.getChecked() == false) {
				Object data = item.getData();
				if (data instanceof ViewInfo) {
					infos.add(((ViewInfo) data).getVisualID());
				}
			}
			addViewInfos(item, infos);
		}
	}

	/**
	 * Gets the diagram.
	 * 
	 * @return the diagram
	 */
	protected Diagram getDiagram() {
		if (getDiagramEditPart() != null) {
			return (Diagram) getDiagramEditPart().getNotationView();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets .Composite)
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		getShell().setText("Select the views to filter:");
		// create a checked treeviewer
		Composite composite = new Composite(parent, 0);
		GridData data = new GridData(GridData.FILL_HORIZONTAL, GridData.FILL_VERTICAL, true, true);
		data.widthHint = 600;
		data.heightHint = 400;
		composite.setLayoutData(data);
		composite.setLayout(new GridLayout());
		treeViewer = new TreeViewer(composite, SWT.CHECK | SWT.BORDER);
		treeViewer.setLabelProvider(new BaseViewInfoLabelProvider());
		treeViewer.setContentProvider(new BaseViewInfoContentProvider());
		treeViewer.setInput(getViewInfo());
		data = new GridData(GridData.FILL_HORIZONTAL, GridData.FILL_VERTICAL, true, true);
		data.widthHint = 600;
		data.heightHint = 400;
		treeViewer.getTree().setLayoutData(data);
		getTreeViewer().expandAll();
		populateTree();
		return composite;
	}

	/**
	 * Populate tree.
	 */
	protected void populateTree() {
		if (getTreeViewer() == null || getTreeViewer().getTree() == null || getViewInfo() == null
				|| getDiagram() == null) {
			return;
		}
		Diagram diagram = getDiagram();
		Collection<Integer> filters = MDTUtil.getAllViewsToFilterFromDiagram(diagram);
		for (TreeItem item : getTreeViewer().getTree().getItems()) {
			Object data = item.getData();
			if (data instanceof ViewInfo) {
				ViewInfo info = (ViewInfo) data;
				if (filters.contains(info.getVisualID())) {
					item.setChecked(false);
				} else {
					item.setChecked(true);
				}
			}
			setChecked(item, filters);
		}
	}

	/**
	 * Sets the checked.
	 * 
	 * @param root
	 *            the root
	 * @param filters
	 *            the filters
	 */
	protected void setChecked(TreeItem root, Collection<Integer> filters) {
		for (TreeItem item : root.getItems()) {
			Object data = item.getData();
			if (data instanceof ViewInfo) {
				ViewInfo info = (ViewInfo) data;
				if (filters.contains(info.getVisualID())) {
					item.setChecked(false);
				} else {
					item.setChecked(true);
				}
			}
			setChecked(item, filters);
		}
	}

}
