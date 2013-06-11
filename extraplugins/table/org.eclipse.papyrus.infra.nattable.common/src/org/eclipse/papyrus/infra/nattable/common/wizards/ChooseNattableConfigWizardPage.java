/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.common.wizards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.ViewerColumn;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.papyrus.infra.nattable.common.messages.Messages;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration;
import org.eclipse.papyrus.infra.nattable.nattableconfiguration.NattableConfigurationRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

/**
 * Wizard page (unique) to select the desired table configurations.
 * 
 */
public class ChooseNattableConfigWizardPage extends WizardPage {

	private Map<TableConfiguration, Integer> selectedConfigs = new HashMap<TableConfiguration, Integer>();

	private Map<TableConfiguration, String> tableNames = new HashMap<TableConfiguration, String>();

	private Object context;

	private static final Image CHECKED = org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage("org.eclipse.papyrus.infra.nattable.common", "icons/checked.gif"); //$NON-NLS-1$ //$NON-NLS-2$

	private static final Image UNCHECKED = org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage("org.eclipse.papyrus.infra.nattable.common", "icons/unchecked.gif"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * 
	 * Constructor.
	 * 
	 * @param pageName
	 * @param context
	 */
	protected ChooseNattableConfigWizardPage(String pageName, EObject context) {
		super(pageName);
		this.context = context;
	}

	/**
	 * 
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {
		setPageComplete(false);
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;

		createTableViewer(container);
		setControl(container);
	}



	/**
	 * Create the table to display the catalog of existing configurations
	 * 
	 * @param container
	 */
	public void createTableViewer(final Composite container) {
		final TableViewer viewer = new TableViewer(container, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		viewer.setContentProvider(new ArrayContentProvider());
		final Table table = viewer.getTable();
		table.setHeaderVisible(true);
		ViewerColumn colCheckbox = createTableViewerColumn("", 20, viewer); //$NON-NLS-1$
		Collection<TableConfiguration> configs = loadConfigs();
		colCheckbox.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				return ""; //$NON-NLS-1$
			}

			@Override
			public Image getImage(Object element) {
				if(selectedConfigs.containsKey(element)) {
					return CHECKED;
				} else {
					return UNCHECKED;
				}
			}

		});
		colCheckbox.setEditingSupport(new EditingSupport(viewer) {

			private CheckboxCellEditor checkboxCellEditor;

			@Override
			protected void setValue(Object element, Object value) {
				if(checkboxCellEditor.getValue() == Boolean.TRUE) {
					selectedConfigs.put((TableConfiguration)element, 1);
				} else {
					selectedConfigs.remove(element);
				}
				viewer.update(element, null);
			}

			@Override
			protected Object getValue(Object element) {
				return selectedConfigs.containsKey(element);
			}

			@Override
			protected CellEditor getCellEditor(Object element) {
				checkboxCellEditor = new CheckboxCellEditor(container, SWT.CHECK | SWT.READ_ONLY);
				return checkboxCellEditor;
			}

			@Override
			protected boolean canEdit(Object element) {
				return true;
			}
		});
		TableViewerColumn colType = createTableViewerColumn(Messages.ChooseNattableConfigWizardPage_6, 200, viewer);
		colType.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				TableConfiguration tc = (TableConfiguration)element;
				return tc.getType();
			}

			@Override
			public Image getImage(Object element) {
				TableConfiguration tc = (TableConfiguration)element;
				Image image = org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage(tc.getIconPath());
				return image;
			}


		});

		TableViewerColumn colName = createTableViewerColumn(Messages.ChooseNattableConfigWizardPage_7, 100, viewer);
		colName.setEditingSupport(new EditingSupport(viewer) {

			@Override
			protected void setValue(Object element, Object value) {
				tableNames.put((TableConfiguration)element, (String)value);
				viewer.update(element, null);
			}

			@Override
			protected Object getValue(Object element) {
				if(tableNames.containsKey(element)) {
					return tableNames.get(element);
				}
				return ""; //$NON-NLS-1$
			}

			@Override
			protected CellEditor getCellEditor(Object element) {
				return new TextCellEditor(viewer.getTable());
			}

			@Override
			protected boolean canEdit(Object element) {
				return true;
			}
		});
		colName.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				return tableNames.get(element);
			}
		});

		TableViewerColumn colQuantity = createTableViewerColumn(Messages.ChooseNattableConfigWizardPage_9, 70, viewer);
		colQuantity.setEditingSupport(new EditingSupport(viewer) {

			@Override
			protected void setValue(Object element, Object value) {
				selectedConfigs.put((TableConfiguration)element, Integer.parseInt((String)value));
				viewer.update(element, null);
			}

			@Override
			protected Object getValue(Object element) {
				if(selectedConfigs.containsKey(element)) {
					return selectedConfigs.get(element).toString();
				}
				return "0"; //$NON-NLS-1$
			}

			@Override
			protected CellEditor getCellEditor(Object element) {
				TextCellEditor textCellEditor = new TextCellEditor(viewer.getTable());
				textCellEditor.setValidator(new ICellEditorValidator() {

					public String isValid(Object value) {
						if(!(value instanceof Integer)) {
							return null;
						}
						return value.toString();
					}
				});
				return textCellEditor;
			}

			@Override
			protected boolean canEdit(Object element) {
				return true;
			}
		});
		colQuantity.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				if(selectedConfigs.containsKey(element)) {
					return selectedConfigs.get(element).toString();
				}
				return ""; //$NON-NLS-1$
			}
		});

		TableViewerColumn colDescription = createTableViewerColumn(Messages.ChooseNattableConfigWizardPage_12, 400, viewer);
		colDescription.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				TableConfiguration tc = (TableConfiguration)element;
				return tc.getDescription();
			}

		});
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				if(selectedConfigs.size() > 0) {
					setPageComplete(true);
				} else {
					setPageComplete(false);
				}
			}
		});
		GridData gridData = new GridData();
		gridData.verticalAlignment = GridData.FILL;
		gridData.horizontalSpan = 2;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		viewer.getControl().setLayoutData(gridData);
		viewer.setInput(configs);
	}

	/**
	 * Constructor.
	 * 
	 * @param title
	 * @param bound
	 * @param viewer
	 * @return
	 */
	private TableViewerColumn createTableViewerColumn(String title, int bound, TableViewer viewer) {
		final TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(title);
		column.setWidth(bound);
		column.setResizable(false);
		column.setMoveable(false);
		return viewerColumn;
	}

	/**
	 * Get configurations from the configuration registry with their default names
	 * 
	 * @return
	 */
	public Collection<TableConfiguration> loadConfigs() {
		Collection<TableConfiguration> tableConfigurations = new ArrayList<TableConfiguration>(NattableConfigurationRegistry.INSTANCE.getTableConfigurations());

		final ArrayList<TableConfiguration> tableConfigurationsToRemove = new ArrayList<TableConfiguration>();
		for(TableConfiguration tableConfiguration : tableConfigurations) {

			if(NattableConfigurationRegistry.INSTANCE.canCreateTable(tableConfiguration.getType(), context).isOK()) {

				tableNames.put(tableConfiguration, tableConfiguration.getName());
			} else {
				tableConfigurationsToRemove.add(tableConfiguration);
			}
		}
		tableConfigurations.removeAll(tableConfigurationsToRemove);
		return tableConfigurations;
	}


	/**
	 * Getter for selected table configurations
	 * 
	 * @return
	 */
	public Map<TableConfiguration, Integer> getSelectedConfigs() {
		return selectedConfigs;
	}


	/**
	 * Getter for the selected table names
	 * 
	 * @return
	 */
	public Map<TableConfiguration, String> getTableNames() {
		return tableNames;
	}



}
