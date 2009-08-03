/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tatiana Fesenko (Borland) - initial API and implementation
 */
package org.eclipse.papyrus.diagram.common.parameter;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.diagram.common.parameter.celleditors.BooleanCellEditor;
import org.eclipse.papyrus.diagram.common.parameter.celleditors.DirectionCellEditor;
import org.eclipse.papyrus.diagram.common.parameter.celleditors.PositiveIntegerCellEditor;
import org.eclipse.papyrus.diagram.common.parameter.celleditors.TypeDialogCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.uml2.uml.Expression;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

public class EditPropertyParametersDialog extends TrayDialog {

	private static final int TABLE_HEIGHT = 100;

	private static final int ADD_ID = IDialogConstants.CLIENT_ID + 1;

	private static final int REMOVE_ID = ADD_ID + 1;

	private static final int UP_ID = REMOVE_ID + 1;

	private static final int DOWN_ID = UP_ID + 1;

	private TableViewer myTableViewer;

	private final Operation myOperation;

	private final Operation myOldOperation;

	public static final Type NULL_TYPE = UMLFactory.eINSTANCE.createClass();

	private final AdapterFactory myAdapterFactory;

	public EditPropertyParametersDialog(Shell parentShell, Operation operation, AdapterFactory af) {
		super(parentShell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		myAdapterFactory = af;
		myOldOperation = operation;
		myOperation = (Operation) EcoreUtil.copy(operation);
		setHelpAvailable(false);
	}

	@Override
	protected Control createButtonBar(Composite parent) {
		Control buttonSection = super.createButtonBar(parent);
		((GridData) buttonSection.getLayoutData()).grabExcessVerticalSpace = false;
		return buttonSection;
	}

	@Override
	protected void okPressed() {
		try {
			new EditPropertyParametersCommand(myOldOperation, myOperation).execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			e.printStackTrace();
		} finally {
			super.okPressed();
		}
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		getShell().setText("Select Parameters for Operation");
		Composite parentComposite = (Composite) super.createDialogArea(parent);

		createAddRemoveButtonBar(parentComposite);

		Table table = buildTable(parentComposite);
		GridData tableLayoutData = new GridData(SWT.FILL, SWT.FILL, true, true);
		tableLayoutData.heightHint = TABLE_HEIGHT;
		table.setLayoutData(tableLayoutData);
		myTableViewer = createTableViewer(table);
		myTableViewer.setInput(myOperation);
		return parentComposite;
	}

	private Table buildTable(Composite parent) {
		Table table = new Table(parent, SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION
				| SWT.HIDE_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		TableColumn name = new TableColumn(table, SWT.LEFT, 0);
		name.setText(EditParametersTableConstants.NAME);
		name.setWidth(70);

		TableColumn types = new TableColumn(table, SWT.LEFT, 1);
		types.setText(EditParametersTableConstants.TYPES);
		types.setWidth(70);

		TableColumn direction = new TableColumn(table, SWT.LEFT, 2);
		direction.setText(EditParametersTableConstants.DIRECTION);
		direction.setWidth(70);

		TableColumn multiplicity = new TableColumn(table, SWT.LEFT, 3);
		multiplicity.setText(EditParametersTableConstants.MULTIPLICITY);
		multiplicity.setWidth(70);

		TableColumn defaultValue = new TableColumn(table, SWT.LEFT, 4);
		defaultValue.setText(EditParametersTableConstants.DEFAULT_VALUE);
		defaultValue.setWidth(70);

		TableColumn isOrdered = new TableColumn(table, SWT.LEFT, 5);
		isOrdered.setText(EditParametersTableConstants.IS_ORDERED);
		isOrdered.setWidth(70);

		TableColumn isUnique = new TableColumn(table, SWT.LEFT, 6);
		isUnique.setText(EditParametersTableConstants.IS_UNIQUE);
		isUnique.setWidth(70);
		return table;
	}

	private Control createAddRemoveButtonBar(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		layout.horizontalSpacing = 0;
		layout.numColumns = 0; // this is incremented by createButton
		composite.setLayout(layout);
		final GridData data = new GridData(SWT.END, SWT.BEGINNING, false, false);
		composite.setLayoutData(data);
		composite.setFont(parent.getFont());
		createAddButton(composite);
		createRemoveButton(composite);
		createUpButton(composite);
		createDownButton(composite);
		return composite;
	}

	private void createRemoveButton(Composite composite) {
		Button removeButton = createButton(composite, REMOVE_ID, "Remove", false);
		removeButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection selection = (IStructuredSelection) myTableViewer.getSelection();
				Object selected = selection.getFirstElement();
				myOperation.getOwnedParameters().remove(selected);
				myTableViewer.refresh();
				myTableViewer.getControl().setFocus();
			}
		});
	}

	private void createAddButton(Composite composite) {
		Button addButton = createButton(composite, ADD_ID, "Add", false);
		addButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Parameter newParameter = UMLFactory.eINSTANCE.createParameter();
				newParameter.setName("Parameter");
				newParameter.createDefaultValue(null, null, UMLPackage.eINSTANCE.getLiteralString());
				myOperation.getOwnedParameters().add(newParameter);
				myTableViewer.refresh();
				myTableViewer.getControl().setFocus();
				myTableViewer.setSelection(new StructuredSelection(newParameter));
			}

		});
	}

	private void createUpButton(Composite composite) {
		Button addButton = createButton(composite, UP_ID, "Up", false);
		addButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection selection = (IStructuredSelection) myTableViewer.getSelection();
				Parameter selected = (Parameter) selection.getFirstElement();
				if (selected == null) {
					return;
				}
				int index = myOperation.getOwnedParameters().indexOf(selected);
				if (index - 1 < 0) {
					return;
				}
				myOperation.getOwnedParameters().remove(selected);
				myOperation.getOwnedParameters().add(index - 1, selected);
				myTableViewer.refresh();
				myTableViewer.getControl().setFocus();
			}

		});
	}

	private void createDownButton(Composite composite) {
		Button addButton = createButton(composite, DOWN_ID, "Down", false);
		addButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection selection = (IStructuredSelection) myTableViewer.getSelection();
				Parameter selected = (Parameter) selection.getFirstElement();
				if (selected == null) {
					return;
				}
				int index = myOperation.getOwnedParameters().indexOf(selected);
				if (index + 1 > myOperation.getOwnedParameters().size() - 1) {
					return;
				}
				myOperation.getOwnedParameters().remove(selected);
				myOperation.getOwnedParameters().add(index + 1, selected);
				myTableViewer.refresh();
				myTableViewer.getControl().setFocus();
			}

		});
	}

	private TableViewer createTableViewer(Table table) {
		final TableViewer viewer = new TableViewer(table);
		viewer.setColumnProperties(EditParametersTableConstants.COLUMN_PROPERTIES);
		viewer.setUseHashlookup(true);
		viewer.setContentProvider(new ParametersContentProvider());

		addCellEditors(table, viewer);
		viewer.setCellModifier(new ParametersCellModifier() {

			@Override
			public void updateViewer(Parameter parameter, String property) {
				viewer.update(parameter, new String[] { property });
			}
		});
		viewer.setLabelProvider(new ParameterLabelProvider());
		return viewer;
	}

	private void addCellEditors(Table table, TableViewer viewer) {
		CellEditor name = new TextCellEditor(table);
		// CellEditor types = new TypeCellEditor(table, getTypeProposals());
		CellEditor types = new TypeDialogCellEditor(table, TransactionUtil.getEditingDomain(myOldOperation),
				myAdapterFactory);
		CellEditor direction = new DirectionCellEditor(table);
		CellEditor multiplicity = new PositiveIntegerCellEditor(table);
		CellEditor defaultValue = new TextCellEditor(table);
		CellEditor isOrdered = new BooleanCellEditor(table);
		CellEditor isUnique = new BooleanCellEditor(table);

		CellEditor[] editors = new CellEditor[] { name, types, direction, multiplicity, defaultValue, isOrdered,
				isUnique };
		viewer.setCellEditors(editors);
	}

	private class ParametersContentProvider implements IStructuredContentProvider {

		public Object[] getElements(Object inputElement) {
			return ((Operation) inputElement).getOwnedParameters().toArray();
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}

	private static class ParameterLabelProvider extends LabelProvider implements ITableLabelProvider {

		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			Parameter p = (Parameter) element;
			switch (columnIndex) {
			case EditParametersTableConstants.NAME_POS:
				return p.getName();
			case EditParametersTableConstants.TYPES_POS:
				return p.getType() != null ? p.getType().getName() : "";
			case EditParametersTableConstants.MULTIPLICITY_POS:
				return Integer.toString(p.getUpper());
			case EditParametersTableConstants.DIRECTION_POS:
				return p.getDirection().toString();
			case EditParametersTableConstants.DEFAULT_VALUE_POS:
				ValueSpecification defValue = p.getDefaultValue();
				if (defValue == null) {
					return "";
				}
				return new ValueSpecificationToStringConverter().doSwitch(defValue);
			case EditParametersTableConstants.IS_ORDERED_POS:
				return Boolean.toString(p.isOrdered());
			case EditParametersTableConstants.IS_UNIQUE_POS:
				return Boolean.toString(p.isUnique());
			default:
				return "-";
			}
		}
	}

	public static class ValueSpecificationToStringConverter extends org.eclipse.uml2.uml.util.UMLSwitch<String> {

		private static final String EMPTY_VALUE = "";

		@Override
		public String caseLiteralString(LiteralString object) {
			String value = object.getValue();
			return value != null ? value : EMPTY_VALUE;
		}

		@Override
		public String caseLiteralInteger(LiteralInteger object) {
			String value = Integer.toString(object.getValue());
			return value != null ? value : EMPTY_VALUE;
		}

		@Override
		public String caseExpression(Expression object) {
			String value = object.getSymbol();
			return value != null ? value : EMPTY_VALUE;
		}

		@Override
		public String defaultCase(EObject object) {
			return EMPTY_VALUE;
		}

	};

	public static class SetValueToSpecification extends org.eclipse.uml2.uml.util.UMLSwitch<ValueSpecification> {

		private final String myNewValue;

		public SetValueToSpecification(String value) {
			myNewValue = value;
		}

		@Override
		public ValueSpecification caseLiteralString(LiteralString object) {
			object.setValue(myNewValue);
			return object;
		}

		@Override
		public ValueSpecification caseLiteralInteger(LiteralInteger object) {
			Integer intValue = Integer.parseInt(myNewValue);
			object.setValue(intValue);
			return object;
		};

		@Override
		public ValueSpecification caseExpression(Expression object) {
			object.setSymbol(myNewValue);
			return object;
		}

		@Override
		public ValueSpecification defaultCase(EObject object) {
			return null;
		}

	}

}
