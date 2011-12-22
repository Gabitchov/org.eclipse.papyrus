/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.runtime.propertyeditor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.commands.CheckedOperationHistory;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.controller.ILabelProviderController;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.PlatformUI;


/**
 * Abstract class for all table editors
 */
public abstract class AbstractTablePropertyEditor extends AbstractPropertyEditor {

	/** main composite created by this property editor */
	protected Composite composite;

	/** button to add a reference or modify existing one */
	protected Button addButton;

	/** button to remove reference */
	protected Button removeButton;

	/** table area that displays the values */
	protected Table table;

	/** viewer on the previous table */
	protected TableViewer viewer;

	/** current Value in the editor */
	protected List<Object> currentValue;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Composite createContent(Composite parent) {
		composite = getWidgetFactory().createComposite(parent, SWT.NONE);
		int columnNu = getColumnNumber();
		GridLayout layout = new GridLayout(columnNu, false);
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		composite.setLayout(layout);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, false);
		composite.setLayoutData(data);

		// creates label. No TOP/DOWN/etc. position, always on top
		createLabel(composite);

		if(!getIsReadOnly()) {
			// create Button area
			addButton = getWidgetFactory().createButton(composite, "", SWT.NONE);
			addButton.setImage(Activator.getImageFromDescriptor(Activator.imageDescriptorFromPlugin(Activator.ID, "icons/Add_12x12.gif")));
			data = new GridData(SWT.FILL, SWT.CENTER, false, false);
			addButton.setLayoutData(data);
			addButton.addMouseListener(new MouseListener() {

				/**
				 * {@inheritDoc}
				 */
				public void mouseUp(MouseEvent e) {
					performAddButtonPressed();
				}

				/**
				 * {@inheritDoc}
				 */
				public void mouseDown(MouseEvent e) {
				}

				/**
				 * {@inheritDoc}
				 */
				public void mouseDoubleClick(MouseEvent e) {
				}
			});

			removeButton = getWidgetFactory().createButton(composite, "", SWT.NONE);
			removeButton.setImage(Activator.getImageFromDescriptor(Activator.imageDescriptorFromPlugin(Activator.ID, "icons/Delete_12x12.gif")));
			data = new GridData(SWT.FILL, SWT.CENTER, false, false);
			removeButton.setLayoutData(data);
			removeButton.addMouseListener(new MouseListener() {

				/**
				 * {@inheritDoc}
				 */
				public void mouseUp(MouseEvent e) {
					performRemoveButtonPressed();
				}

				/**
				 * {@inheritDoc}
				 */
				public void mouseDown(MouseEvent e) {

				}

				/**
				 * {@inheritDoc}
				 */
				public void mouseDoubleClick(MouseEvent e) {

				}
			});

			if(getController().canMoveValues(new ArrayList<Integer>(), 0)) { // only checks if virtual elements can be moved, not real move, so a 0-delta is fine
				Button upButton = getWidgetFactory().createButton(composite, "", SWT.NONE);
				upButton.setImage(Activator.getImageFromDescriptor(Activator.imageDescriptorFromPlugin(Activator.ID, "icons/Up_12x12.gif")));
				data = new GridData(SWT.FILL, SWT.CENTER, false, false);
				upButton.setLayoutData(data);
				upButton.addMouseListener(new MouseListener() {

					/**
					 * {@inheritDoc}
					 */
					public void mouseUp(MouseEvent e) {
						performUpButtonPressed();
					}

					/**
					 * {@inheritDoc}
					 */
					public void mouseDown(MouseEvent e) {
					}

					/**
					 * {@inheritDoc}
					 */
					public void mouseDoubleClick(MouseEvent e) {
					}
				});

				Button downButton = getWidgetFactory().createButton(composite, "", SWT.NONE);
				downButton.setImage(Activator.getImageFromDescriptor(Activator.imageDescriptorFromPlugin(Activator.ID, "icons/Down_12x12.gif")));
				data = new GridData(SWT.FILL, SWT.CENTER, false, false);
				downButton.setLayoutData(data);
				downButton.addMouseListener(new MouseListener() {

					/**
					 * {@inheritDoc}
					 */
					public void mouseUp(MouseEvent e) {
						performDownButtonPressed();
					}

					/**
					 * {@inheritDoc}
					 */
					public void mouseDown(MouseEvent e) {
					}

					/**
					 * {@inheritDoc}
					 */
					public void mouseDoubleClick(MouseEvent e) {
					}
				});
			}
		}

		Composite tableComposite = getWidgetFactory().createComposite(composite, SWT.NONE);
		data = new GridData(SWT.FILL, SWT.FILL, true, true, columnNu, 1);
		data.heightHint = 80;
		data.widthHint = 200;
		tableComposite.setLayoutData(data);
		// creates table for the display of references
		table = new Table(tableComposite, SWT.BORDER | SWT.MULTI);
		viewer = new TableViewer(table);
		TableColumnLayout tableLayout = new TableColumnLayout();
		tableComposite.setLayout(tableLayout);
		final TableViewerColumn tableViewerColumn = new TableViewerColumn(viewer, SWT.NONE);
		TableColumn tableColumn = tableViewerColumn.getColumn();
		tableLayout.setColumnData(tableColumn, new ColumnWeightData(100, 0, true));
		tableColumn.setText("Value");
		tableViewerColumn.setEditingSupport(createEditingSupport());
		viewer.setUseHashlookup(true);
		viewer.setContentProvider(new IStructuredContentProvider() {

			/**
			 * {@inheritDoc}
			 */
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

			}

			/**
			 * {@inheritDoc}
			 */
			public void dispose() {

			}

			/**
			 * {@inheritDoc}
			 */
			public Object[] getElements(Object inputElement) {
				if(inputElement instanceof List<?>) {
					return ((List<?>)inputElement).toArray();
				}
				return new Object[0];
			}
		});

		if(getController() instanceof ILabelProviderController) {
			viewer.setLabelProvider(((ILabelProviderController)getController()).getEditorLabelProvider());
		} else {
			viewer.setLabelProvider(new LabelProvider());
		}
		viewer.getControl().setToolTipText(getTooltipText());
		return composite;
	}

	/**
	 * Creates the editing support for the table viewer
	 * 
	 * @return the editing support for the table viewer
	 */
	protected abstract EditingSupport createEditingSupport();

	/**
	 * performs the action handled by the "Add" button
	 */
	protected void performAddButtonPressed() {
		// pops up a window to ask for a new reference
		Display display = Display.getCurrent();
		if(display == null && PlatformUI.isWorkbenchRunning()) {
			display = PlatformUI.getWorkbench().getDisplay();
		}
		display = (display != null) ? display : Display.getDefault();

		List<IUndoableOperation> operations = getController().getCreateValueOperations();

		// either one or more options
		// in case there are several, open a sub-menu
		// otherwise, execute the operation
		if(operations == null || operations.isEmpty()) {
			return;
		}
		if(operations.size() == 1) {
			try {
				CheckedOperationHistory.getInstance().execute(operations.get(0), new NullProgressMonitor(), null);
			} catch (ExecutionException e1) {
				Activator.log.error(e1);
			}
		} else {
			Menu menu = new Menu(addButton);
			for(final IUndoableOperation operation : operations) {
				MenuItem item = new MenuItem(menu, SWT.NONE);
				item.setText(operation.getLabel());
				item.addSelectionListener(new SelectionListener() {

					public void widgetSelected(SelectionEvent e) {
						try {
							CheckedOperationHistory.getInstance().execute(operation, new NullProgressMonitor(), null);
						} catch (ExecutionException e1) {
							Activator.log.error(e1);
						}
					}

					public void widgetDefaultSelected(SelectionEvent e) {

					}
				});
			}
			menu.setVisible(true);
		}

		// now select the new value added. Assumes this is the last one
		int lastIndex = table.getItemCount() - 1;
		table.select(lastIndex);

	}

	/**
	 * performs the action handled by the "Remove" button
	 */
	protected void performRemoveButtonPressed() {
		// use selection to remove element
		// retrieve selected element(s)
		IStructuredSelection selection = (IStructuredSelection)viewer.getSelection();
		if(selection == null || selection.isEmpty()) {
			// nothing selected. 
			return;
		}

		int[] selectedIndexes = table.getSelectionIndices();
		Arrays.sort(selectedIndexes);
		List<Integer> indexes = new ArrayList<Integer>();
		for(int i = selectedIndexes.length - 1; i >= 0; i--) {
			indexes.add(selectedIndexes[i]);
		}
		IUndoableOperation operation = getController().getDeleteValueOperation(indexes);
		if(operation != null && operation.canExecute()) {
			try {
				CheckedOperationHistory.getInstance().execute(operation, new NullProgressMonitor(), null);
			} catch (ExecutionException e1) {
				Activator.log.error(e1);
			}
		}
	}

	/**
	 * performs the action handled by the "Up" button
	 */
	protected void performUpButtonPressed() {
		int[] selectionIndices = table.getSelectionIndices();
		final List<Integer> selectionList = new ArrayList<Integer>();
		final List<Integer> newSelectionList = new ArrayList<Integer>();
		for(int i : selectionIndices) {
			selectionList.add(i);
			newSelectionList.add(i - 1);
		}
		IUndoableOperation moveOperation = getController().getMoveCurrentValuesOperation(selectionList, -1);
		if(moveOperation != null && moveOperation.canExecute()) {
			try {
				CheckedOperationHistory.getInstance().execute(moveOperation, new NullProgressMonitor(), null);
				// try to restore selection in the view
				int[] newSelection = new int[newSelectionList.size()];
				for(int i = 0; i < newSelectionList.size(); i++) {
					newSelection[i] = newSelectionList.get(i);
				}
				table.select(newSelection);
			} catch (ExecutionException e1) {
				Activator.log.error(e1);
			}
		}
	}

	/**
	 * performs the action handled by the "Down" button
	 */
	protected void performDownButtonPressed() {
		// use selection to remove element
		// retrieve selected element(s)
		int[] selectionIndices = table.getSelectionIndices();
		final List<Integer> selectionList = new ArrayList<Integer>();
		final List<Integer> newSelectionList = new ArrayList<Integer>();
		for(int i : selectionIndices) {
			selectionList.add(i);
			newSelectionList.add(i + 1);
		}
		IUndoableOperation moveOperation = getController().getMoveCurrentValuesOperation(selectionList, +1);
		if(moveOperation != null && moveOperation.canExecute()) {
			try {
				CheckedOperationHistory.getInstance().execute(moveOperation, new NullProgressMonitor(), null);
				// try to restore selection in the view
				int[] newSelection = new int[newSelectionList.size()];
				for(int i = 0; i < newSelectionList.size(); i++) {
					newSelection[i] = newSelectionList.get(i);
				}
				table.select(newSelection);
			} catch (ExecutionException e1) {
				Activator.log.error(e1);
			}
		}
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createLabel(Composite parent) {
		GridData data = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		return createLabel(parent, data);
	}

	/**
	 * Returns the number of column for the composite
	 * 
	 * @return the number of column for the composite
	 */
	protected int getColumnNumber() {
		if(getIsReadOnly()) {
			return 1;
		}
		if(getController().canMoveValues(new ArrayList<Integer>(), 0)) {
			return 5;
		}
		return 3;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleContentChanged() {
		// this should tells the controller that the input has to be applied to the model
		getController().updateModel();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStatus init(IPropertyEditorDescriptor descriptor) {
		setDescriptor(descriptor);
		setTooltipText(descriptor.getTooltipText());
		return Status.OK_STATUS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Object> getValue() {
		return currentValue;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void setValue(Object valueToEdit) {
		if(!isValid(table)) {
			return;
		}
		if(valueToEdit instanceof List<?>) {
			currentValue = (List<Object>)valueToEdit;
		} else if(valueToEdit == null) {
			currentValue = null;
		} else {
			Activator.log.error(valueToEdit + " is not a list of Object for current table: " + getDescriptor().getLabel(), null);
		}
		viewer.setInput((currentValue != null) ? currentValue : Collections.emptyList());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		if(isValid(composite)) {
			composite.dispose();
			composite = null;
			setController(null);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDisposed() {
		if(composite == null) {
			return true;
		}
		return composite.isDisposed();
	}
}
