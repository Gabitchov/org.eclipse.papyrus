/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.wizards;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;
import org.eclipse.papyrus.cdo.core.importer.IModelImportMapping;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferConfiguration;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferListener;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferMappingListener;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferNode;
import org.eclipse.papyrus.cdo.core.importer.ModelTransferListenerAdapter;
import org.eclipse.papyrus.cdo.core.importer.ModelTransferMappingListenerAdapter;
import org.eclipse.papyrus.cdo.internal.ui.l10n.Messages;
import org.eclipse.papyrus.cdo.internal.ui.providers.ModelImportNodeLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.google.common.collect.Iterables;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * This is the RepositorySelectionPage type. Enjoy.
 */
public class ModelMappingsPage extends ModelImportWizardPage {

	private static final String MESSAGE = Messages.ModelMappingsPage_0;

	private IModelTransferConfiguration importConfig;

	private IModelTransferListener importConfigListener;

	private IPapyrusRepository repository;

	private IModelImportMapping manyToOne;

	private IModelTransferMappingListener manyToOneListener;

	private IModelImportMapping oneToOne;

	private IModelTransferMappingListener oneToOneListener;

	private IModelImportMapping selectedMapping;

	private Button manyToOneRadio;

	private Text manyToOnePathText;

	private Button oneToOneRadio;

	private TableViewer oneToOnePathsTable;

	public ModelMappingsPage(EventBus bus) {
		super("mappings", Messages.ModelMappingsPage_2, null, bus, MESSAGE); //$NON-NLS-1$
	}

	public void createControl(Composite parent) {
		initializeDialogUnits(parent);

		Composite result = new Composite(parent, SWT.NONE);
		result.setLayout(new GridLayout(2, false));

		manyToOneRadio = new Button(result, SWT.RADIO);
		manyToOneRadio.setText(Messages.ModelMappingsPage_3);
		manyToOneRadio.setLayoutData(GridDataFactory.swtDefaults().span(2, 1).create());

		Label label = new Label(result, SWT.NONE);
		label.setText(Messages.ModelMappingsPage_4);
		label.setLayoutData(GridDataFactory.swtDefaults().indent(convertWidthInCharsToPixels(5), 0).create());

		manyToOnePathText = new Text(result, SWT.BORDER);
		manyToOnePathText.setLayoutData(GridDataFactory.fillDefaults().grab(true, false).create());
		manyToOnePathText.setEnabled(false);

		oneToOneRadio = new Button(result, SWT.RADIO);
		oneToOneRadio.setText(Messages.ModelMappingsPage_5);
		oneToOneRadio.setLayoutData(GridDataFactory.swtDefaults().span(2, 1).create());
		oneToOneRadio.setSelection(true);

		oneToOnePathsTable = new TableViewer(result);
		oneToOnePathsTable.getControl().setLayoutData(GridDataFactory.fillDefaults().grab(true, true).span(2, 1).indent(convertWidthInCharsToPixels(5), 0).create());
		TableViewerColumn column = new TableViewerColumn(oneToOnePathsTable, SWT.NONE);
		column.getColumn().setText(Messages.ModelMappingsPage_6);
		column.getColumn().setWidth(convertWidthInCharsToPixels(30));
		column = new TableViewerColumn(oneToOnePathsTable, SWT.NONE);
		column.getColumn().setText(Messages.ModelMappingsPage_7);
		column.getColumn().setWidth(convertWidthInCharsToPixels(45));
		column.setEditingSupport(new OneToOneMappingPathEditingSupport(oneToOnePathsTable, 1));
		oneToOnePathsTable.getTable().setHeaderVisible(true);
		oneToOnePathsTable.getTable().setLinesVisible(true);
		oneToOnePathsTable.setContentProvider(new OneToOneMappingContentProvider());
		oneToOnePathsTable.setLabelProvider(new OneToOneMappingLabelProvider());

		if(importConfig != null) {
			oneToOnePathsTable.setInput(importConfig);
		}

		SelectionListener radioListener = new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if(((Button)e.widget).getSelection()) {
					if(e.widget == manyToOneRadio) {
						oneToOneRadio.setSelection(false);
						oneToOnePathsTable.getControl().setEnabled(false);
						manyToOnePathText.setEnabled(true);
					} else {
						manyToOneRadio.setSelection(false);
						manyToOnePathText.setEnabled(false);
						oneToOnePathsTable.getControl().setEnabled(true);
					}

					if(e.widget.getData() != null) {
						selectedMapping((IModelImportMapping)e.widget.getData());
					}

					validatePage();
				}
			}
		};
		manyToOneRadio.addSelectionListener(radioListener);
		oneToOneRadio.addSelectionListener(radioListener);

		manyToOnePathText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				manyToOnePathChanged(((Text)e.widget).getText().trim());
			}
		});

		setControl(result);

		validatePage();
	}

	@Override
	public void dispose() {
		if(importConfig != null) {
			importConfig.removeModelTransferListener(getImportConfigListener());
		}

		// I didn't create it, so don't dispose it
		importConfig = null;

		super.dispose();
	}

	void selectedMapping(IModelImportMapping mapping) {
		selectedMapping = mapping;
		post(mapping);
	}

	@Override
	protected Diagnostic doValidatePage() {
		Diagnostic result = Diagnostic.CANCEL_INSTANCE;

		if(selectedMapping != null) {
			result = selectedMapping.validate();
		}

		return result;
	}

	public IModelImportMapping getSelectedMapping() {
		return selectedMapping;
	}

	@Subscribe
	public void setConfiguration(IModelTransferConfiguration config) {
		this.importConfig = config;

		if(config != null) {
			config.addModelTransferListener(getImportConfigListener());
		}

		setManyToOneMapping(IModelImportMapping.Factory.MANY_TO_ONE.create(config));
		setOneToOneMapping(IModelImportMapping.Factory.ONE_TO_ONE.create(config));

		if(oneToOnePathsTable != null) {
			oneToOnePathsTable.setInput(config);
		}

		validatePage();
	}

	private IModelTransferListener getImportConfigListener() {
		if(importConfigListener == null) {
			importConfigListener = new ModelTransferListenerAdapter() {

				@Override
				public void modelsToTransferChanged(IModelTransferConfiguration configuration) {

					if((oneToOnePathsTable != null) && !oneToOnePathsTable.getControl().isDisposed()) {

						oneToOnePathsTable.refresh();
					}
				}
			};
		}

		return importConfigListener;
	}

	private void setManyToOneMapping(IModelImportMapping mapping) {
		if(manyToOne != null) {
			manyToOne.removeModelTransferMappingListener(getManyToOneListener());
		}

		manyToOne = mapping;

		if(manyToOne != null) {
			manyToOne.addModelTransferMappingListener(getManyToOneListener());
			manyToOne.setRepository(repository);
			if(manyToOneRadio != null) {
				manyToOneRadio.setData(manyToOne);
				if(manyToOneRadio.getSelection()) {
					selectedMapping(manyToOne);
				}

				IModelTransferNode node = Iterables.getFirst(importConfig.getModelsToTransfer(), null);
				if(node != null) {
					updateManyToOneMapping(node);
				}
			}
		}
	}

	private IModelTransferMappingListener getManyToOneListener() {
		if(manyToOneListener == null) {
			manyToOneListener = new ModelTransferMappingListenerAdapter() {

				@Override
				public void modelTransferMappingChanged(IModelTransferNode node) {
					updateManyToOneMapping(node);
				}
			};
		}

		return manyToOneListener;
	}

	void updateManyToOneMapping(IModelTransferNode node) {
		IPath mapping = manyToOne.getMapping(node);
		if((mapping != null) && (manyToOnePathText != null)) {
			String path = mapping.toString();
			if(!manyToOnePathText.getText().equals(path)) {
				manyToOnePathText.setText(path);
			}
		}
	}

	private void setOneToOneMapping(IModelImportMapping mapping) {
		if(oneToOne != null) {
			oneToOne.removeModelTransferMappingListener(getOneToOneListener());
		}

		oneToOne = mapping;

		if(oneToOne != null) {
			oneToOne.addModelTransferMappingListener(getOneToOneListener());
			oneToOne.setRepository(repository);
			if(oneToOneRadio != null) {
				oneToOneRadio.setData(oneToOne);
				if(oneToOneRadio.getSelection()) {
					selectedMapping(oneToOne);
				}
			}
		}
	}

	private IModelTransferMappingListener getOneToOneListener() {
		if(oneToOneListener == null) {
			oneToOneListener = new ModelTransferMappingListenerAdapter() {

				@Override
				public void modelTransferMappingChanged(IModelTransferNode node) {
					IPath mapping = oneToOne.getMapping(node);
					if((mapping != null) && (oneToOnePathsTable != null)) {
						oneToOnePathsTable.refresh();
					}
				}
			};
		}

		return oneToOneListener;
	}

	@Subscribe
	public void setRepository(IPapyrusRepository repository) {
		this.repository = repository;

		if(manyToOne != null) {
			manyToOne.setRepository(repository);
		}
		if(oneToOne != null) {
			oneToOne.setRepository(repository);
		}

		validatePage();
	}

	private void manyToOnePathChanged(String newPath) {
		try {
			IModelTransferNode node = Iterables.getFirst(importConfig.getModelsToTransfer(), null);
			setMapping(node, newPath);
		} catch (Exception e) {
			setMessage(Messages.ModelMappingsPage_8, IMessageProvider.ERROR);
		}
	}

	private boolean setMapping(IModelTransferNode node, String newPath) {
		boolean result = false;

		IPath path = new Path(newPath);
		if(path.isEmpty()) {
			setMessage(Messages.ModelMappingsPage_9, IMessageProvider.ERROR);
			setPageComplete(false);
		} else if(path.hasTrailingSeparator()) {
			setMessage(Messages.ModelMappingsPage_10, IMessageProvider.ERROR);
			setPageComplete(false);
		} else {
			result = true;

			if((selectedMapping != null) && (node != null)) {
				selectedMapping.mapTo(node, path);
			}

			validatePage();
		}

		return result;
	}

	//
	// Nested types
	//

	private static class OneToOneMappingContentProvider implements IStructuredContentProvider {

		public Object[] getElements(Object inputElement) {
			return ((IModelTransferConfiguration)inputElement).getModelsToTransfer().toArray();
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// pass
		}

		public void dispose() {
			// pass
		}

	}

	private class OneToOneMappingLabelProvider extends ModelImportNodeLabelProvider implements ITableLabelProvider {

		public Image getColumnImage(Object element, int columnIndex) {
			return (columnIndex == 0) ? getImage(element) : null;
		}

		public String getColumnText(Object element, int columnIndex) {
			String result = null;

			switch(columnIndex) {
			case 0: // Model
				result = getText(element);
				break;
			case 1: // Path
				if(oneToOne != null) {
					IPath path = oneToOne.getMapping((IModelTransferNode)element);
					if(path != null) {
						result = path.toString();
					}
				}

				if(result == null) {
					result = ""; //$NON-NLS-1$
				}
				break;
			}

			return result;
		}
	}

	private class OneToOneMappingPathEditingSupport extends EditingSupport {

		private TextCellEditor editor;

		private final int columnIndex;

		OneToOneMappingPathEditingSupport(ColumnViewer columnViewer, int columnIndex) {

			super(columnViewer);

			this.columnIndex = columnIndex;
		}

		@Override
		protected CellEditor getCellEditor(Object element) {
			if(editor == null) {
				editor = new TextCellEditor((Composite)getViewer().getControl());
			}
			return editor;
		}

		@Override
		protected boolean canEdit(Object element) {
			return true;
		}

		@Override
		protected Object getValue(Object element) {
			IPath path = oneToOne.getMapping((IModelTransferNode)element);
			return (path == null) ? "" : path.toString(); //$NON-NLS-1$
		}

		@Override
		protected void setValue(final Object element, Object value) {
			String newPath = (value == null) ? "" : String.valueOf(value); //$NON-NLS-1$

			if(!setMapping((IModelTransferNode)element, newPath)) {
				// continue editing
				getViewer().getControl().getDisplay().asyncExec(new Runnable() {

					public void run() {
						getViewer().editElement(element, columnIndex);
					}
				});
			}
		}

	}
}
