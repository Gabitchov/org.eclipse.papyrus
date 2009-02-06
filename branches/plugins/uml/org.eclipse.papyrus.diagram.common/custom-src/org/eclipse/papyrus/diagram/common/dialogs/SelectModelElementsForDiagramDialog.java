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
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.uml2.uml.NamedElement;

// TODO: Auto-generated Javadoc
/**
 * The Class SelectModelElementsForDiagramDialog.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
public class SelectModelElementsForDiagramDialog extends WizardPage {

	/** The selection tree. */
	private TreeViewer selectionTree = null;

	/** The root element label. */
	private Label rootElementLabel = null;

	/** The element provider. */
	private IWizardModelElementProvider elementProvider = null;

	/** The label provider. */
	private IBaseLabelProvider labelProvider = null;

	/** The content provider. */
	private IContentProvider contentProvider = null;

	/** The was shown. */
	private boolean wasShown = false;

	/**
	 * Instantiates a new select model elements for diagram dialog.
	 * 
	 * @param elementProvider
	 *            the element provider
	 * @param contentProvider
	 *            the content provider
	 * @param labelProvider
	 *            the label provider
	 */
	public SelectModelElementsForDiagramDialog(IWizardModelElementProvider elementProvider, IContentProvider contentProvider, IBaseLabelProvider labelProvider) {
		super("Select model elements for diagram");
		setTitle("Model objects");
		setDescription("Select model objects that must appear in the diagram");
		this.elementProvider = elementProvider;
		this.contentProvider = contentProvider;
		this.labelProvider = labelProvider;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.DialogPage#setVisible(boolean)
	 */
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			EObject input = elementProvider.getModelElement();
			selectionTree.setInput(input);

			String label = "";
			label += "<" + input.eClass().getName() + "> ";
			if (input instanceof NamedElement) {
				label += ((NamedElement) input).getName() + " ";
			}
			label += " is the root element";
			rootElementLabel.setText(label);
			selectionTree.expandAll();
			selectAllSelected();
			wasShown = true;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		Composite root = new Composite(parent, SWT.NONE);
		GridLayout gridLayout = new GridLayout();
		root.setLayout(gridLayout);
		Composite composite = new Composite(root, 0);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		gridLayout = new GridLayout();
		composite.setLayout(gridLayout);
		createDialogArea(composite);
		setControl(root);
	}

	/**
	 * Gets the selected e objects.
	 * 
	 * @return the selected e objects
	 */
	public List<EObject> getSelectedEObjects() {
		if (selectionTree == null) {
			return Collections.EMPTY_LIST;
		}

		if (!wasShown) {
			EObject input = elementProvider.getModelElement();
			selectionTree.setInput(input);
			selectionTree.expandAll();
			selectAllSelected();
		}

		TreeItem[] items = selectionTree.getTree().getItems();
		List<EObject> selectedEObjects = new ArrayList<EObject>();

		for (TreeItem item : items) {
			addCheckedEObjectsToList(selectedEObjects, item);
		}

		return selectedEObjects;
	}

	/**
	 * Adds the checked e objects to list.
	 * 
	 * @param list
	 *            the list
	 * @param item
	 *            the item
	 */
	private void addCheckedEObjectsToList(List<EObject> list, TreeItem item) {
		if (item.getChecked()) {
			Object data = item.getData();
			if (data instanceof EObject) {
				list.add((EObject) data);
			}
		}
		for (TreeItem treeItem : item.getItems()) {
			addCheckedEObjectsToList(list, treeItem);
		}
	}

	/**
	 * Creates the dialog area.
	 * 
	 * @param parent
	 *            the parent
	 */
	protected void createDialogArea(Composite parent) {
		createLabel(parent);
		createTreeSelector(parent);
		createButtons(parent);
	}

	/**
	 * Creates the label.
	 * 
	 * @param parent
	 *            the parent
	 */
	private void createLabel(Composite parent) {
		rootElementLabel = new Label(parent, 0);
		GridData data = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		rootElementLabel.setLayoutData(data);
	}

	/**
	 * Creates the tree selector.
	 * 
	 * @param parent
	 *            the parent
	 */
	private void createTreeSelector(Composite parent) {
		Tree tree = new Tree(parent, SWT.CHECK | SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		TreeViewer treeViewer = new TreeViewer(tree);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.heightHint = 300;
		data.widthHint = 300;
		tree.setLayoutData(data);
		selectionTree = treeViewer;

		treeViewer.setContentProvider(contentProvider);
		treeViewer.setLabelProvider(labelProvider);

		tree.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				return;
			}

			public void widgetSelected(SelectionEvent e) {
				treeSelectionChanged(e);
			}
		});
	}

	/**
	 * Creates the buttons.
	 * 
	 * @param parent
	 *            the parent
	 */
	private void createButtons(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(4, true));
		GridData gridData = new GridData(SWT.FILL, SWT.END, true, false);
		composite.setLayoutData(gridData);

		Button selectAllButton = new Button(composite, SWT.PUSH);
		selectAllButton.setText("Select All");
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		selectAllButton.setLayoutData(data);
		selectAllButton.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				selectAllSelected();
			}
		});

		Button deselectAllButton = new Button(composite, SWT.PUSH);
		deselectAllButton.setText("Deselect All");
		data = new GridData(SWT.FILL, SWT.FILL, true, true);
		deselectAllButton.setLayoutData(data);
		deselectAllButton.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				deselectAllSelected();
			}
		});
	}

	/** The changing. */
	private boolean changing = false;

	/**
	 * Select all selected.
	 */
	private void selectAllSelected() {
		Tree tree = selectionTree.getTree();
		TreeItem[] items = tree.getItems();
		for (TreeItem item : items) {
			setTreeItemSelection(item, true);
		}
	}

	/**
	 * Deselect all selected.
	 */
	private void deselectAllSelected() {
		Tree tree = selectionTree.getTree();
		TreeItem[] items = tree.getItems();
		for (TreeItem item : items) {
			setTreeItemSelection(item, false);
		}
	}

	/**
	 * Tree selection changed.
	 * 
	 * @param event
	 *            the event
	 */
	private void treeSelectionChanged(SelectionEvent event) {
		Widget item = event.item;
		if (changing || !(item instanceof TreeItem)) {
			return;
		}

		changing = true;
		TreeItem treeItem = (TreeItem) item;
		setTreeItemSelection(treeItem, treeItem.getChecked());
		if (treeItem.getChecked() && treeItem.getParentItem() != null) {
			setTreeItemParentChecked(treeItem.getParentItem());
		}
		changing = false;
	}

	/**
	 * Sets the tree item selection.
	 * 
	 * @param item
	 *            the item
	 * @param checked
	 *            the checked
	 */
	private void setTreeItemSelection(TreeItem item, boolean checked) {
		item.setChecked(checked);
		TreeItem[] items = item.getItems();
		for (TreeItem ti : items) {
			setTreeItemSelection(ti, checked);
		}
	}

	/**
	 * Sets the tree item parent checked.
	 * 
	 * @param parent
	 *            the new tree item parent checked
	 */
	private void setTreeItemParentChecked(TreeItem parent) {
		parent.setChecked(true);
		if (parent.getParentItem() != null) {
			setTreeItemParentChecked(parent.getParentItem());
		}
	}
}
