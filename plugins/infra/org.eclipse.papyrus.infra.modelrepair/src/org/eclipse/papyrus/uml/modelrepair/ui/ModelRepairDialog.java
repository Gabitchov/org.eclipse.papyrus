/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.modelrepair.ui;


import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.uml.modelrepair.ui.providers.ResourceLabelProvider;
import org.eclipse.papyrus.uml.modelrepair.ui.providers.ResourceLinksContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;


public class ModelRepairDialog extends TrayDialog {

	private ResourceSet resourceSet;

	public ModelRepairDialog(Shell shell, ResourceSet resourceSet) {
		super(shell);

		this.resourceSet = resourceSet;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite contents = (Composite)super.createDialogArea(parent);

		Composite self = new Composite(contents, SWT.NONE);
		self.setLayout(new FillLayout());
		self.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		TreeViewer viewer = new TreeViewer(self, SWT.FULL_SELECTION | SWT.BORDER);
		Tree tree = viewer.getTree();
		TableLayout layout = new TableLayout(true);
		tree.setLayout(layout);
		tree.setHeaderVisible(true);


		TreeColumn nameColumn = new TreeColumn(tree, SWT.NONE);
		nameColumn.setText("Resource");
		layout.addColumnData(new ColumnWeightData(25, 250, true));

		TreeColumn locationColumn = new TreeColumn(tree, SWT.NONE);
		locationColumn.setText("Location");
		layout.addColumnData(new ColumnWeightData(45, 450, true));

		TreeColumn versionColumn = new TreeColumn(tree, SWT.NONE);
		versionColumn.setText("Read-only");
		layout.addColumnData(new ColumnWeightData(10, 100, true));


		viewer.setContentProvider(new ResourceLinksContentProvider());
		viewer.setLabelProvider(new ResourceLabelProvider(resourceSet));
		viewer.setInput(resourceSet);

		return contents;
	}

	@Override
	public void create() {
		super.create();
		getShell().setText("Edit model links");
		getShell().pack();
	}


	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	public boolean isHelpAvailable() {
		return false;
	}

}
