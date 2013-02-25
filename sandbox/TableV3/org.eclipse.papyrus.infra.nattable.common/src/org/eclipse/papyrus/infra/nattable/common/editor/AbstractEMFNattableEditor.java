/*****************************************************************************
 * Copyright (c) 2009 CEA LIST & LIFL
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *  Vincent Lorenzo (CEA-LIST) vincent.lorenzo@cea.fr
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.common.editor;


import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.config.EditableRule;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.config.IConfiguration;
import org.eclipse.nebula.widgets.nattable.coordinate.Range;
import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.nebula.widgets.nattable.edit.EditConfigAttributes;
import org.eclipse.nebula.widgets.nattable.grid.layer.CornerLayer;
import org.eclipse.nebula.widgets.nattable.grid.layer.GridLayer;
import org.eclipse.nebula.widgets.nattable.layer.DataLayer;
import org.eclipse.nebula.widgets.nattable.layer.ILayer;
import org.eclipse.nebula.widgets.nattable.layer.ILayerListener;
import org.eclipse.nebula.widgets.nattable.layer.cell.ColumnOverrideLabelAccumulator;
import org.eclipse.nebula.widgets.nattable.layer.event.ILayerEvent;
import org.eclipse.nebula.widgets.nattable.print.config.DefaultPrintBindings;
import org.eclipse.nebula.widgets.nattable.reorder.ColumnReorderLayer;
import org.eclipse.nebula.widgets.nattable.reorder.event.ColumnReorderEvent;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.nebula.widgets.nattable.ui.binding.UiBindingRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.nattable.common.Activator;
import org.eclipse.papyrus.infra.nattable.common.configuration.EditConfiguration;
import org.eclipse.papyrus.infra.nattable.common.configuration.InvertAxisOnCornerConfiguration;
import org.eclipse.papyrus.infra.nattable.common.dataprovider.BodyDataProvider;
import org.eclipse.papyrus.infra.nattable.common.dataprovider.ColumnHeaderDataProvider;
import org.eclipse.papyrus.infra.nattable.common.dataprovider.CornerDataProvider;
import org.eclipse.papyrus.infra.nattable.common.dataprovider.RowHeaderDataProvider;
import org.eclipse.papyrus.infra.nattable.common.layerstack.BodyLayerStack;
import org.eclipse.papyrus.infra.nattable.common.layerstack.ColumnHeaderLayerStack;
import org.eclipse.papyrus.infra.nattable.common.layerstack.RowHeaderLayerStack;
import org.eclipse.papyrus.infra.nattable.common.listener.NatTableDropListener;
import org.eclipse.papyrus.infra.nattable.common.manager.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.common.manager.NattableModelManager;
import org.eclipse.papyrus.infra.nattable.common.provider.TableSelectionProvider;
import org.eclipse.papyrus.infra.nattable.common.solver.CellManagerFactory;
import org.eclipse.papyrus.infra.nattable.common.utils.TableEditorInput;
import org.eclipse.papyrus.infra.nattable.model.nattable.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.menus.IMenuService;
import org.eclipse.ui.part.EditorPart;


/**
 * Abstract class for TableEditor
 * 
 * 
 * 
 */
public abstract class AbstractEMFNattableEditor extends EditorPart {

	/** the service registry */
	protected ServicesRegistry servicesRegistry;

	/** the table instance */
	protected Table rawModel;

	protected INattableModelManager tableManager;

	private NatTable natTable;

	private MenuManager menuMgr;

	private TableSelectionProvider selectionProvider;

	private PartNameSynchronizer synchronizer;

	/**
	 * @param servicesRegistry
	 * @param rawModel
	 * 
	 */
	public AbstractEMFNattableEditor(final ServicesRegistry servicesRegistry, final Table rawModel) {
		this.servicesRegistry = servicesRegistry;
		this.rawModel = rawModel;
		this.synchronizer = new PartNameSynchronizer(rawModel);
	}


	/**
	 * 
	 * @see org.eclipse.emf.facet.widgets.nattable.workbench.editor.NatTableEditor#init(org.eclipse.ui.IEditorSite, org.eclipse.ui.IEditorInput)
	 * 
	 * @param site
	 * @param input
	 * @throws PartInitException
	 */
	@Override
	public void init(final IEditorSite site, final IEditorInput input) throws PartInitException {
		final TableEditorInput tableEditorInput = new TableEditorInput(this.rawModel, getEditingDomain());
		setSite(site);
		setInput(tableEditorInput);
		setPartName(this.rawModel.getName());
	}

	/**
	 * 
	 * @see org.eclipse.emf.facet.widgets.nattable.workbench.editor.NatTableEditor#getEditingDomain()
	 * 
	 * @return
	 */
	public EditingDomain getEditingDomain() {
		try {
			return ServiceUtils.getInstance().getTransactionalEditingDomain(this.servicesRegistry);
		} catch (final ServiceException e) {
			Activator.log.error(e);
		}
		return null;
	}

	@Override
	public void doSave(final IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getAdapter(final Class adapter) {
		if(adapter == NatTable.class) {
			return this.natTable;
		}
		return super.getAdapter(adapter);
	}

	@Override
	public void dispose() {
		this.selectionProvider.dispose();
		this.tableManager.dispose();
		this.synchronizer.dispose();
		super.dispose();

	}

	/**
	 * A class taking in charge the synchronization of the partName and the table name.
	 * When table name change, the other is automatically updated.
	 * 
	 * 
	 */
	public class PartNameSynchronizer {

		/** the papyrus table */
		private Table papyrusTable;

		/**
		 * Listener on diagram name change.
		 */
		private final Adapter tableNameListener = new AdapterImpl() {

			/**
			 * 
			 * @see org.eclipse.emf.common.notify.Adapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
			 * 
			 * @param notification
			 */
			@Override
			public void notifyChanged(final Notification notification) {
				if(notification.getFeature() == NattablePackage.eINSTANCE.getTable_Name()) {
					setPartName(PartNameSynchronizer.this.papyrusTable.getName());
				}
			}
		};

		/**
		 * 
		 * Constructor.
		 * 
		 * @param diagram
		 */
		public PartNameSynchronizer(final Table papyrusTable) {
			setTable(papyrusTable);
		}

		public void dispose() {
			this.papyrusTable.eAdapters().remove(this.tableNameListener);
			this.papyrusTable = null;
		}

		/**
		 * Change the associated diagram.
		 * 
		 * @param papyrusTable
		 */
		public void setTable(final Table papyrusTable) {
			// Remove from old table, if any
			if(this.papyrusTable != null) {
				papyrusTable.eAdapters().remove(this.tableNameListener);
			}
			// Set new table
			this.papyrusTable = papyrusTable;
			// Set editor name
			setPartName(papyrusTable.getName());
			// Listen to name change
			papyrusTable.eAdapters().add(this.tableNameListener);
		}
	}



	@Override
	public void createPartControl(final Composite parent) {
		this.natTable = createNattable(parent);
	}


	private NatTable createNattable(final Composite parent) {
		this.tableManager = new NattableModelManager(this.rawModel);

		final BodyDataProvider bodyDataProvider = new BodyDataProvider(this.tableManager);
		final BodyLayerStack bodyLayerStack = new BodyLayerStack(bodyDataProvider, this.tableManager);;

		final IDataProvider columnHeaderDataProvider = new ColumnHeaderDataProvider(this.tableManager);
		final ColumnHeaderLayerStack columnHeaderLayer = new ColumnHeaderLayerStack(columnHeaderDataProvider, bodyLayerStack, bodyDataProvider);

		final IDataProvider rowHeaderDataProvider = new RowHeaderDataProvider(this.tableManager);


		final RowHeaderLayerStack rowHeaderLayerStack = new RowHeaderLayerStack(rowHeaderDataProvider, bodyLayerStack);


		final IDataProvider cornerDataProvider = new CornerDataProvider(columnHeaderDataProvider, rowHeaderDataProvider);
		final CornerLayer cornerLayer = new CornerLayer(new DataLayer(cornerDataProvider), rowHeaderLayerStack, columnHeaderLayer);
		cornerLayer.addConfiguration(new InvertAxisOnCornerConfiguration(tableManager));
		final GridLayer gridLayer = new GridLayer(bodyLayerStack, columnHeaderLayer, rowHeaderLayerStack, cornerLayer);
		gridLayer.addConfiguration(new DefaultPrintBindings());
		//		gridLayer.addConfiguration(new StyleConfiguration());
		//		fBodyLayer.getBodyDataLayer().addConfiguration(new StyleConfiguration());
		//		fBodyLayer.addConfiguration(new StyleConfiguration());




		NatTable natTable = new NatTable(parent, gridLayer, false);


		//for the edition
		configureEdition(natTable, bodyLayerStack);

		natTable.addConfiguration(new IConfiguration() {

			@Override
			public void configureUiBindings(UiBindingRegistry uiBindingRegistry) {
				// TODO Auto-generated method stub

			}

			@Override
			public void configureRegistry(IConfigRegistry configRegistry) {
				configRegistry.registerConfigAttribute(EditConfigAttributes.CELL_EDITABLE_RULE, new EditableRule() {

					@Override
					public boolean isEditable(int columnIndex, int rowIndex) {

						final Object obj1 = rowHeaderDataProvider.getDataValue(1, rowIndex);
						final Object obj2 = columnHeaderDataProvider.getDataValue(columnIndex, 1);
						return CellManagerFactory.INSTANCE.isCellEditable(obj1, obj2);
					}
				});

				configRegistry.registerConfigAttribute(EditConfigAttributes.CELL_EDITOR, null, DisplayMode.EDIT, ""); //$NON-NLS-1$

			}

			@Override
			public void configureLayer(ILayer layer) {
				// TODO Auto-generated method stub

			}
		});
		natTable.configure();



		addColumnReorderListener(bodyLayerStack.getColumnReorderLayer());
		addDragAndDropSupport(natTable, gridLayer, bodyLayerStack);
		//we create a menu manager
		this.menuMgr = new MenuManager("#PopUp", "org.eclipse.papyrus.infra.nattable.common.editor") { //$NON-NLS-1$ //$NON-NLS-2$

			@Override
			public void add(final IAction action) {
				//				System.out.println(action);
				super.add(action);
			}

			@Override
			public void add(final IContributionItem item) {
				// TODO Auto-generated method stub
				//				System.out.println(item);
				super.add(item);
			}
		}; //$NON-NLS-1$
		this.menuMgr.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));

		this.menuMgr.setRemoveAllWhenShown(true);

		final Menu menu = this.menuMgr.createContextMenu(natTable);
		natTable.setMenu(menu);

		this.selectionProvider = new TableSelectionProvider(bodyLayerStack.getSelectionLayer());
		getSite().registerContextMenu(this.menuMgr, this.selectionProvider);
		getSite().setSelectionProvider(this.selectionProvider);
		IMenuService menuService = (IMenuService)PlatformUI.getWorkbench().getService(IMenuService.class);
//		menuService.
		return natTable;
	}

	private void configureEdition(final NatTable nattable, final BodyLayerStack bodyLayerStack) {
		final ColumnOverrideLabelAccumulator columnLabelAccumulator = new ColumnOverrideLabelAccumulator(bodyLayerStack);
		bodyLayerStack.setConfigLabelAccumulator(columnLabelAccumulator);
		nattable.addConfiguration(new EditConfiguration(this.tableManager, bodyLayerStack));
	}

	/**
	 * Enable the table to receive dropped elements
	 * 
	 * @param fBodyLayer
	 * @param gridLayer
	 */
	private void addDragAndDropSupport(final NatTable nattable, GridLayer gridLayer, BodyLayerStack fBodyLayer) {
		final int operations = DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_DEFAULT;
		final DropTarget target = new DropTarget(nattable, operations);
		final LocalTransfer localTransfer = LocalTransfer.getInstance();
		final Transfer[] types = new Transfer[]{ localTransfer };
		target.setTransfer(types);
		final NatTableDropListener dropListener = new NatTableDropListener(nattable, this.tableManager, this.rawModel, gridLayer, fBodyLayer);
		target.addDropListener(dropListener);
	}

	/**
	 * Add a listener on the column reorder layer in order to update the model
	 * 
	 * @param columnReorderLayer
	 *        the column reorder layer
	 */
	private void addColumnReorderListener(final ColumnReorderLayer columnReorderLayer) {
		columnReorderLayer.addLayerListener(new ILayerListener() {

			@Override
			public void handleLayerEvent(final ILayerEvent event) {
				if(event instanceof ColumnReorderEvent) {
					ColumnReorderEvent columnReorderEvent = (ColumnReorderEvent)event;
					int start = -1;
					int end = columnReorderEvent.getBeforeToColumnPosition();
					for(Range range : columnReorderEvent.getBeforeFromColumnPositionRanges()) {
						start = range.start;
						break;
					}
					if(start != -1) {
						// This solve an index difference between moving
						// a column from right to left and moving a
						// column from left to right
						if(start >= 0 && start < end) {
							end--;
						}
						final List<IAxis> allAxis = AbstractEMFNattableEditor.this.rawModel.getVerticalContentProvider().getAxis();
						final IAxis axisToMove = allAxis.get(start);
						if(axisToMove != null) {
							tableManager.reorderColumnsElements(axisToMove, end);
						}
					}
				}
			}
		});
	}
}
