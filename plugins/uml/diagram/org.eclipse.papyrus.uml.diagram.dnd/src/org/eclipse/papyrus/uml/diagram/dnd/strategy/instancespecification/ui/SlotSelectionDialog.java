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
package org.eclipse.papyrus.uml.diagram.dnd.strategy.instancespecification.ui;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TreeViewer;
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
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;

/**
 * A dialog which lets the user choose the properties he wishes to instantiate,
 * from a list of classifiers.
 * 
 * The dialog returns the list of selected properties.
 * 
 * @author Camille Letavernier
 */
public class SlotSelectionDialog extends SelectionDialog {

	private final InstanceSpecification specification;

	private final List<Classifier> classifiers;

	private final Map<Property, Boolean> properties;

	public SlotSelectionDialog(Shell parentShell, InstanceSpecification specification, List<Classifier> classifiers) {
		super(parentShell);
		this.specification = specification;
		this.classifiers = classifiers;
		properties = new LinkedHashMap<Property, Boolean>();
	}

	@Override
	public void create() {
		setTitle("Select the slots to create");
		super.create();

		getShell().setImage(org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage("icons/papyrus.png"));

		Composite parent = getDialogArea();

		Label label = new Label(parent, SWT.NONE);
		label.setText("Select the slots you wish to create. Existing slots cannot be removed here");

		TreeViewer viewer = new TreeViewer(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);

		viewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		Tree tree = viewer.getTree();

		TableLayout layout = new TableLayout();

		TreeColumn propertyColumn = new TreeColumn(tree, SWT.CENTER);
		propertyColumn.setText("Property");
		layout.addColumnData(new ColumnWeightData(30, 150, true));

		TreeColumn ownerColumn = new TreeColumn(tree, SWT.CENTER);
		ownerColumn.setText("Qualified name");
		layout.addColumnData(new ColumnWeightData(60, 300, true));

		TreeColumn checkColumn = new TreeColumn(tree, SWT.CENTER);
		checkColumn.setText("Create slot");
		layout.addColumnData(new ColumnWeightData(10, 70, true));

		tree.setLayout(layout);
		tree.setHeaderVisible(true);

		viewer.setContentProvider(new ClassifierPropertiesContentProvider());
		viewer.setLabelProvider(new ClassifierPropertiesLabelProvider());

		viewer.setInput(classifiers);
		viewer.expandAll();

		for(TreeItem classifierItem : tree.getItems()) {
			for(TreeItem propertyItem : classifierItem.getItems()) {
				final Property property = (Property)propertyItem.getData();
				properties.put(property, select(property));

				final Button checkbox = new Button(tree, SWT.CHECK);

				checkbox.setSelection(true);
				checkbox.setEnabled(select(property));

				checkbox.addSelectionListener(new SelectionListener() {

					public void widgetSelected(SelectionEvent e) {
						properties.put(property, checkbox.getSelection());
					}

					public void widgetDefaultSelected(SelectionEvent e) {
						//Nothing
					}

				});

				TreeEditor editor = new TreeEditor(tree);
				editor.horizontalAlignment = SWT.CENTER;
				editor.grabHorizontal = true;

				editor.setEditor(checkbox, propertyItem, 2);
			}
		}

		parent.layout();

		getShell().pack();
	}

	protected boolean select(Property property) {
		//Checks whether a slot already represents the given property
		for(Slot slot : specification.getSlots()) {
			if(slot.getDefiningFeature() == property) {
				return false;
			}
		}
		return true;
	}

	@Override
	protected void okPressed() {
		List<Property> result = new LinkedList<Property>();
		for(Map.Entry<Property, Boolean> entry : properties.entrySet()) {
			if(entry.getValue()) {
				result.add(entry.getKey());
			}
		}
		setResult(result);
		super.okPressed();
	}

	@Override
	public Composite getDialogArea() {
		return (Composite)super.getDialogArea();
	}

	@Override
	public boolean isResizable() {
		return true;
	}

}
