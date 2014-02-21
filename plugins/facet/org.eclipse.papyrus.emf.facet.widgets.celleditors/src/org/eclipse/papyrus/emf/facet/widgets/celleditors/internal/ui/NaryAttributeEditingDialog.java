/*******************************************************************************
 * Copyright (c) 2010, 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas Bros (Mia-Software) - initial API and implementation
 *   Nicolas Guyomar (Mia-Software) - Bug 339554 - org.eclipse.emf.facet.widgets.celleditors API cleaning
 *   Nicolas Guyomar (Mia-Software) - Bug 342451 - To be able to edit derived facet attributes and derived facet references in a table
 *******************************************************************************/
package org.eclipse.emf.facet.widgets.celleditors.internal.ui;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.facet.widgets.celleditors.IModelCellEditHandler;
import org.eclipse.emf.facet.widgets.celleditors.internal.Messages;
import org.eclipse.emf.facet.widgets.internal.CustomizableLabelProvider;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

/** A dialog to edit a multiplicity-many {@link EAttribute} */
public class NaryAttributeEditingDialog<T extends Object> extends AbstractNaryEditingDialog<T> {

	private static final int NUM_COLUMNS = 2;
	private TableViewer featureValuesTableViewer;
	
	private final Object newValuePlaceholder = new Object();

	private Button addButton;
	private Button removeButton;
	private Button upButton;
	private Button downButton;

	private final ColumnLabelProvider labelProvider = new ColumnLabelProvider() {
		private final LabelProvider delegateLabelProvider = new CustomizableLabelProvider();

		@Override
		public Image getImage(final Object element) {
			return this.delegateLabelProvider.getImage(element);
		}

		@Override
		public String getText(final Object element) {
			if (element == NaryAttributeEditingDialog.this.newValuePlaceholder) {
				return Messages.NaryAttributeEditingDialog_enterNewValuePlaceholder;
			}
			return this.delegateLabelProvider.getText(element);
		}

		@Override
		public Color getForeground(final Object element) {
			if (element == NaryAttributeEditingDialog.this.newValuePlaceholder) {
				return Display.getDefault().getSystemColor(SWT.COLOR_DARK_GRAY);
			}
			return null;
		}
	};

	/**
	 * @param parent
	 *            the parent {@link Shell}
	 * @param values
	 *            the current values
	 * @param editHandler
	 * 			  the edit handler to perform the commit.           
	 * @param feature
	 *            the feature to edit
	 * @param eObject
	 * 				the eObject being currently edited. Should not be modified in this dialog.
	 */
	public NaryAttributeEditingDialog(final Shell shell, final List<T> values,
			final IModelCellEditHandler editHandler, final EObject eObject, final EStructuralFeature feature) {
		super(shell, values, editHandler, eObject, feature);
	}


	@Override
	protected void configureShell(final Shell shell) {
		super.configureShell(shell);
		shell.setText(NLS.bind(Messages.NaryReferenceEditingDialog_shellTitle,
				getFeature().getName(), geteObject().eClass().getName()));
		// prevent Escape or Enter from closing the dialog
		// when a cell editor is active
		shell.addListener(SWT.Traverse, new Listener() {
			public void handleEvent(final Event e) {
				if ((e.detail == SWT.TRAVERSE_ESCAPE || e.detail == SWT.TRAVERSE_RETURN)
						&& NaryAttributeEditingDialog.this.featureValuesTableViewer
								.isCellEditorActive()) {
					e.doit = false;
					NaryAttributeEditingDialog.this.featureValuesTableViewer.cancelEditing();
				}
			}
		});
	}

	@Override
	protected Control createDialogArea(final Composite parent) {
		final Composite contents = (Composite) super.createDialogArea(parent);

		final GridLayout contentsGridLayout = (GridLayout) contents.getLayout();
		contentsGridLayout.numColumns = NaryAttributeEditingDialog.NUM_COLUMNS;

		final GridData contentsGridData = (GridData) contents.getLayoutData();
		contentsGridData.horizontalAlignment = SWT.FILL;
		contentsGridData.verticalAlignment = SWT.FILL;

		createValuesPane(contents);
		createButtonsPane(contents);

		this.featureValuesTableViewer.addOpenListener(new IOpenListener() {
			public void open(final OpenEvent event) {
				editSelectedElement();
			}
		});

		this.upButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent event) {
				upButtonClicked();
			}
		});

		this.downButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent event) {
				downButtonClicked();
			}
		});

		this.addButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent event) {
				addButtonClicked();
			}
		});

		this.removeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent event) {
				removeButtonClicked();
			}
		});

		return contents;
	}

	@SuppressWarnings("unchecked") // type erasure on generic
	private void addButtonClicked() {
		getValues().add(0, (T) NaryAttributeEditingDialog.this.newValuePlaceholder);
		refresh();
		this.featureValuesTableViewer.editElement(this.newValuePlaceholder, 0);
	}

	@SuppressWarnings("unchecked") // type erasure on generic
	private void removeButtonClicked() {
		final IStructuredSelection selection = (IStructuredSelection) this.featureValuesTableViewer
				.getSelection();

		for (final Iterator<T> it = selection.iterator(); it.hasNext();) {
			final Object element = it.next();

			if (getValues().contains(element)) {
				getValues().remove(element);				
			}
		}
		refresh();
	}

	private void spacer(final Composite parent) {
		@SuppressWarnings("unused")
		Label label = new Label(parent, SWT.NONE);
	}

	private void createButtonsPane(final Composite contents) {
		final Composite buttonsComposite = new Composite(contents, SWT.NONE);
		final GridData buttonsCompositeGridData = new GridData();
		buttonsCompositeGridData.verticalAlignment = SWT.FILL;
		buttonsCompositeGridData.horizontalAlignment = SWT.FILL;
		buttonsComposite.setLayoutData(buttonsCompositeGridData);
		buttonsComposite.setLayout(new GridLayout());

		// spacer
		spacer(buttonsComposite);

		this.addButton = new Button(buttonsComposite, SWT.PUSH);
		this.addButton.setText(Messages.NaryAttributeEditingDialog_add);
		final GridData addButtonGridData = new GridData();
		addButtonGridData.verticalAlignment = SWT.FILL;
		addButtonGridData.horizontalAlignment = SWT.FILL;
		this.addButton.setLayoutData(addButtonGridData);

		this.removeButton = new Button(buttonsComposite, SWT.PUSH);
		this.removeButton.setText(Messages.NaryAttributeEditingDialog_delete);
		final GridData removeButtonGridData = new GridData();
		removeButtonGridData.verticalAlignment = SWT.FILL;
		removeButtonGridData.horizontalAlignment = SWT.FILL;
		this.removeButton.setLayoutData(removeButtonGridData);

		spacer(buttonsComposite);

		this.upButton = new Button(buttonsComposite, SWT.PUSH);
		this.upButton.setText(Messages.NaryReferenceEditingDialog_up);
		final GridData upButtonGridData = new GridData();
		upButtonGridData.verticalAlignment = SWT.FILL;
		upButtonGridData.horizontalAlignment = SWT.FILL;
		this.upButton.setLayoutData(upButtonGridData);

		this.downButton = new Button(buttonsComposite, SWT.PUSH);
		this.downButton.setText(Messages.NaryReferenceEditingDialog_down);
		final GridData downButtonGridData = new GridData();
		downButtonGridData.verticalAlignment = SWT.FILL;
		downButtonGridData.horizontalAlignment = SWT.FILL;
		this.downButton.setLayoutData(downButtonGridData);
	}

	private void createValuesPane(final Composite contents) {
		final Composite featureComposite = new Composite(contents, SWT.NONE);
		final GridData featureCompositeData = new GridData(SWT.FILL, SWT.FILL, true, true);
		featureCompositeData.horizontalAlignment = SWT.END;
		featureComposite.setLayoutData(featureCompositeData);

		final GridLayout featureCompositeLayout = new GridLayout();
		featureCompositeData.horizontalAlignment = SWT.FILL;
		featureCompositeLayout.marginHeight = 0;
		featureCompositeLayout.marginWidth = 0;
		featureCompositeLayout.numColumns = 1;
		featureComposite.setLayout(featureCompositeLayout);

		final Label featureLabel = new Label(featureComposite, SWT.NONE);
		featureLabel.setText(Messages.NaryReferenceEditingDialog_values);
		final GridData valuesLabelGridData = new GridData();
		valuesLabelGridData.horizontalSpan = 2;
		valuesLabelGridData.horizontalAlignment = SWT.FILL;
		valuesLabelGridData.verticalAlignment = SWT.FILL;
		featureLabel.setLayoutData(valuesLabelGridData);

		final Table table = new Table(featureComposite, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		final GridData tableGridData = new GridData();
		tableGridData.widthHint = AbstractNaryEditingDialog.AVAILABLE_VALUES_TREE_WIDTH;
		tableGridData.heightHint = AbstractNaryEditingDialog.AVAILABLE_VALUES_TREE_HEIGHT;
		tableGridData.verticalAlignment = SWT.FILL;
		tableGridData.horizontalAlignment = SWT.FILL;
		tableGridData.grabExcessHorizontalSpace = true;
		tableGridData.grabExcessVerticalSpace = true;
		table.setLayoutData(tableGridData);
		final TableColumn tableColumn = new TableColumn(table, SWT.CENTER);

		// full-width column
		table.addControlListener(new ControlListener() {
			public void controlResized(final ControlEvent e) {
				tableColumn.setWidth(table.getClientArea().width);
			}

			public void controlMoved(final ControlEvent e) {
				//
			}
		});

		this.featureValuesTableViewer = new TableViewer(table);
		this.featureValuesTableViewer.setContentProvider(new AssignedValuesContentProvider());
		// this.fFeatureValuesTableViewer.setLabelProvider(this.labelProvider);
		this.featureValuesTableViewer
				.setInput(getValues());

		final TableViewerColumn tableViewerColumn = new TableViewerColumn(
				this.featureValuesTableViewer, tableColumn);
		tableViewerColumn.setLabelProvider(this.labelProvider);

		tableViewerColumn.setEditingSupport(new ModelCellsEditingSupport<T>(
				this.featureValuesTableViewer, getFeature(), geteObject(),
				this.newValuePlaceholder, getValues()));

		// keyboard accessibility
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				if (e.keyCode == SWT.F2) {
					editSelectedElement();
				}
				if (e.keyCode == SWT.DEL) {
					if (NaryAttributeEditingDialog.this.removeButton.isEnabled()) {
						NaryAttributeEditingDialog.this.removeButton.notifyListeners(
								SWT.Selection, null);
					}
				}
				if (e.keyCode == SWT.ARROW_UP
						&& ((e.stateMask & SWT.COMMAND) != 0 || (e.stateMask & SWT.CONTROL) != 0)) {
					if (NaryAttributeEditingDialog.this.upButton.isEnabled()) {
						NaryAttributeEditingDialog.this.upButton.notifyListeners(SWT.Selection,
								null);
					}
				}
				if (e.keyCode == SWT.ARROW_DOWN
						&& ((e.stateMask & SWT.COMMAND) != 0 || (e.stateMask & SWT.CONTROL) != 0)) {
					if (NaryAttributeEditingDialog.this.downButton.isEnabled()) {
						NaryAttributeEditingDialog.this.downButton.notifyListeners(SWT.Selection,
								null);
					}
				}
			}
		});

	}

	private void editSelectedElement() {
		ISelection selection = NaryAttributeEditingDialog.this.featureValuesTableViewer
				.getSelection();
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.getFirstElement() != null) {
				NaryAttributeEditingDialog.this.featureValuesTableViewer.editElement(
						structuredSelection.getFirstElement(), 0);
			}
		}
	}

	@Override
	public void refresh() {
		this.featureValuesTableViewer.refresh();
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	protected void createButtonsForButtonBar(final Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
	}


	@Override
	public ISelection getSelection() {
		return this.featureValuesTableViewer.getSelection();
	}
}
