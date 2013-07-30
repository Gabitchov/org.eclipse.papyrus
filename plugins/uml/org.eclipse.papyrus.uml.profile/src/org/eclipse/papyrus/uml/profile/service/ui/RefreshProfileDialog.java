/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.profile.service.ui;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.uml.profile.providers.AppliedProfileContentProvider;
import org.eclipse.papyrus.uml.profile.providers.AppliedProfileLabelProvider;
import org.eclipse.papyrus.uml.tools.utils.ProfileUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.dialogs.SelectionDialog;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;

public class RefreshProfileDialog extends SelectionDialog {

	protected final Map<Package, Collection<Profile>> profilesToReapply;

	protected Runnable callback;

	protected Package rootPackage;

	public RefreshProfileDialog(Shell parentShell, Package rootPackage) {
		super(parentShell);
		setBlockOnOpen(false);
		this.rootPackage = rootPackage;
		profilesToReapply = new HashMap<Package, Collection<Profile>>();
		setTitle("Some profiles have changed");
	}

	public void setCallback(Runnable callback) {
		this.callback = callback;
	}

	@Override
	public void create() {
		super.create();

		Label descriptionLabel = new Label(getDialogArea(), SWT.WRAP);
		descriptionLabel.setText("Some local profiles have changed. Select the ones you want to re-apply");

		TreeViewer viewer = new TreeViewer(getDialogArea());
		viewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Tree tree = viewer.getTree();

		TableLayout layout = new TableLayout();

		TreeColumn propertyColumn = new TreeColumn(tree, SWT.CENTER);
		propertyColumn.setText("Package");
		layout.addColumnData(new ColumnWeightData(30, 300, true));

		TreeColumn ownerColumn = new TreeColumn(tree, SWT.CENTER);
		ownerColumn.setText("Profile");
		layout.addColumnData(new ColumnWeightData(60, 150, true));

		TreeColumn checkColumn = new TreeColumn(tree, SWT.CENTER);
		checkColumn.setText("Reapply");
		layout.addColumnData(new ColumnWeightData(10, 70, true));

		tree.setLayout(layout);
		tree.setHeaderVisible(true);

		viewer.setContentProvider(new AppliedProfileContentProvider(rootPackage));
		viewer.setLabelProvider(new AppliedProfileLabelProvider());

		viewer.setInput(new Object());

		installEditors(viewer);

		getDialogArea().layout();

		getShell().pack();
	}

	protected void installEditors(TreeViewer viewer) {
		viewer.expandAll();
		for(TreeItem item : viewer.getTree().getItems()) {
			installEditors(item, rootPackage);
		}
	}

	protected void installEditors(TreeItem treeItem, final Package parentPackage) {
		Package currentPackage = (Package)treeItem.getData();
		if(currentPackage instanceof Profile) {

			final Profile profile = (Profile)currentPackage;

			if(ProfileUtil.isDirty(parentPackage, profile)) {
				Tree tree = treeItem.getParent();

				final Button checkbox = new Button(tree, SWT.CHECK);

				checkbox.setSelection(true);
				getProfilesToReapply(parentPackage).add(profile);

				checkbox.addSelectionListener(new SelectionListener() {

					public void widgetSelected(SelectionEvent e) {
						if(checkbox.getSelection()) {
							getProfilesToReapply(parentPackage).add(profile);
						} else {
							getProfilesToReapply(parentPackage).remove(profile);
						}
					}

					public void widgetDefaultSelected(SelectionEvent e) {
						//Nothing
					}

				});

				TreeEditor editor = new TreeEditor(tree);
				editor.horizontalAlignment = SWT.CENTER;
				editor.grabHorizontal = true;

				editor.setEditor(checkbox, treeItem, 2);
			}
		}

		for(TreeItem subitem : treeItem.getItems()) {
			installEditors(subitem, currentPackage);
		}
	}

	@Override
	protected Composite getDialogArea() {
		return (Composite)super.getDialogArea();
	}

	protected Collection<Profile> getProfilesToReapply(Package currentPackage) {
		if(!profilesToReapply.containsKey(currentPackage)) {
			profilesToReapply.put(currentPackage, new LinkedHashSet<Profile>());
		}

		return profilesToReapply.get(currentPackage);
	}

	@Override
	protected void okPressed() {
		setSelectionResult(profilesToReapply.values().toArray());
		if(callback != null) {
			callback.run();
		}
		super.okPressed();
	}

	public Map<Package, Collection<Profile>> getProfilesToReapply() {
		return profilesToReapply;
	}

}
