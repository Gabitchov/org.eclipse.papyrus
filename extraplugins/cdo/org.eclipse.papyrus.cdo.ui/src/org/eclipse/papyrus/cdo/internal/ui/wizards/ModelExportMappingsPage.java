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

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;
import org.eclipse.papyrus.cdo.core.exporter.IModelExportMapping;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferConfiguration;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferListener;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferMappingListener;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferNode;
import org.eclipse.papyrus.cdo.core.importer.ModelTransferListenerAdapter;
import org.eclipse.papyrus.cdo.core.importer.ModelTransferMappingListenerAdapter;
import org.eclipse.papyrus.cdo.internal.ui.l10n.Messages;
import org.eclipse.papyrus.cdo.internal.ui.providers.ModelImportNodeLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * This is the ModelExportMappingsPage type. Enjoy.
 */
public class ModelExportMappingsPage extends ModelImportWizardPage {

	private static final String MESSAGE = Messages.ModelExportMappingsPage_0;

	private IModelTransferConfiguration exportConfig;

	private IModelTransferListener exportConfigListener;

	private IPapyrusRepository repository;

	private IModelExportMapping mapping;

	private IModelTransferMappingListener mappingListener;

	private TableViewer mappingTable;

	private IContainer initialDestination;

	public ModelExportMappingsPage(EventBus bus) {
		super("mappings", Messages.ModelExportMappingsPage_2, null, bus, MESSAGE); //$NON-NLS-1$
	}

	public void createControl(Composite parent) {
		initializeDialogUnits(parent);

		Composite result = new Composite(parent, SWT.NONE);
		result.setLayout(new GridLayout());

		mappingTable = new TableViewer(result);
		mappingTable.getControl().setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());
		TableViewerColumn column = new TableViewerColumn(mappingTable, SWT.NONE);
		column.getColumn().setText(Messages.ModelExportMappingsPage_3);
		column.getColumn().setWidth(convertWidthInCharsToPixels(30));
		column = new TableViewerColumn(mappingTable, SWT.NONE);
		column.getColumn().setText(Messages.ModelExportMappingsPage_4);
		column.getColumn().setWidth(convertWidthInCharsToPixels(45));
		column.setEditingSupport(new MappingPathEditingSupport(mappingTable, 1));
		mappingTable.getTable().setHeaderVisible(true);
		mappingTable.getTable().setLinesVisible(true);
		mappingTable.setContentProvider(new MappingContentProvider());
		mappingTable.setLabelProvider(new MappingLabelProvider());

		if(exportConfig != null) {
			mappingTable.setInput(exportConfig);
		}

		setControl(result);

		validatePage();
	}

	@Override
	public void dispose() {
		if(exportConfig != null) {
			exportConfig.removeModelTransferListener(getImportConfigListener());
		}

		// I didn't create it, so don't dispose it
		exportConfig = null;

		super.dispose();
	}

	@Override
	protected Diagnostic doValidatePage() {
		return (mapping == null) ? Diagnostic.CANCEL_INSTANCE : mapping.validate();
	}

	public void setInitialDestination(IContainer container) {
		this.initialDestination = container;
	}

	public IModelExportMapping getMapping() {
		return mapping;
	}

	@Subscribe
	public void setConfiguration(IModelTransferConfiguration config) {
		this.exportConfig = config;

		if(config != null) {
			config.addModelTransferListener(getImportConfigListener());
		}

		setMapping(IModelExportMapping.Factory.DEFAULT.create(config));

		if(mappingTable != null) {
			mappingTable.setInput(config);
		}

		validatePage();
	}

	private IModelTransferListener getImportConfigListener() {
		if(exportConfigListener == null) {
			exportConfigListener = new ModelTransferListenerAdapter() {

				@Override
				public void modelsToTransferChanged(IModelTransferConfiguration configuration) {
					if((mappingTable != null) && !mappingTable.getControl().isDisposed()) {
						mappingTable.refresh();
					}

					initializeMappings();
				}
			};
		}

		return exportConfigListener;
	}

	private void setMapping(IModelExportMapping mapping) {
		if(this.mapping != null) {
			this.mapping.removeModelTransferMappingListener(getMappingListener());
		}

		this.mapping = mapping;

		if(this.mapping != null) {
			this.mapping.addModelTransferMappingListener(getMappingListener());
			this.mapping.setRepository(repository);
			initializeMappings();
		}
	}

	private void initializeMappings() {
		if((initialDestination != null) && (mapping != null)) {
			IPath basePath = initialDestination.getFullPath();
			for(IModelTransferNode next : exportConfig.getModelsToTransfer()) {
				if(mapping.getMapping(next) == null) {
					mapping.mapTo(next, basePath.append(next.getPrimaryResourceURI().lastSegment()));
				}
			}
		}
	}

	private IModelTransferMappingListener getMappingListener() {
		if(mappingListener == null) {
			mappingListener = new ModelTransferMappingListenerAdapter() {

				@Override
				public void modelTransferMappingChanged(IModelTransferNode node) {
					IPath mapping = ModelExportMappingsPage.this.mapping.getMapping(node);
					if((mapping != null) && (mappingTable != null)) {
						mappingTable.refresh();
					}
				}
			};
		}

		return mappingListener;
	}

	@Subscribe
	public void setRepository(IPapyrusRepository repository) {
		this.repository = repository;

		if(mapping != null) {
			mapping.setRepository(repository);
		}

		validatePage();
	}

	private boolean setMapping(IModelTransferNode node, IPath path) {
		if((mapping != null) && (node != null)) {
			mapping.mapTo(node, path);
		}

		validatePage();

		return true;
	}

	//
	// Nested types
	//

	private static class MappingContentProvider implements IStructuredContentProvider {

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

	private class MappingLabelProvider extends ModelImportNodeLabelProvider implements ITableLabelProvider {

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
				if(mapping != null) {
					IPath path = mapping.getMapping((IModelTransferNode)element);
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

	private class MappingPathEditingSupport extends EditingSupport {

		private DialogCellEditor editor;

		private final int columnIndex;

		MappingPathEditingSupport(ColumnViewer columnViewer, int columnIndex) {
			super(columnViewer);

			this.columnIndex = columnIndex;
		}

		@Override
		protected CellEditor getCellEditor(Object element) {
			if(editor == null) {
				editor = new DialogCellEditor((Composite)getViewer().getControl()) {

					@Override
					protected Object openDialogBox(Control cellEditorWindow) {
						ContainerSelectionDialog dlg = new ContainerSelectionDialog(cellEditorWindow.getShell(), null, true, Messages.ModelExportMappingsPage_6);
						dlg.setTitle(Messages.ModelExportMappingsPage_7);
						dlg.setHelpAvailable(false);

						Object[] result = (dlg.open() == Window.OK) ? dlg.getResult() : null;

						return ((result == null) || (result.length == 0)) ? null : (IPath)result[0];
					}
				};
			}
			return editor;
		}

		@Override
		protected boolean canEdit(Object element) {
			return true;
		}

		@Override
		protected Object getValue(Object element) {
			IPath path = mapping.getMapping((IModelTransferNode)element);
			return (path == null) ? "" : path.removeLastSegments(1).toString(); //$NON-NLS-1$
		}

		@Override
		protected void setValue(final Object element, Object value) {
			// the 'value' will be a string if the user double-clicks without opening the dialog
			IPath newPath = (value instanceof IPath) ? (IPath)value : null;

			if(newPath != null) {
				String name = ((IModelTransferNode)element).getPrimaryResourceURI().lastSegment();
				newPath = newPath.append(name);

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
}
