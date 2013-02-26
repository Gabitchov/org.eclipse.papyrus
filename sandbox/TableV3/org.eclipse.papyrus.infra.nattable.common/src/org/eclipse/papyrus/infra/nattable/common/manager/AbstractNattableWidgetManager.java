/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.common.manager;

import java.util.List;

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
import org.eclipse.nebula.widgets.nattable.grid.GridRegion;
import org.eclipse.nebula.widgets.nattable.grid.layer.CornerLayer;
import org.eclipse.nebula.widgets.nattable.grid.layer.GridLayer;
import org.eclipse.nebula.widgets.nattable.layer.DataLayer;
import org.eclipse.nebula.widgets.nattable.layer.ILayer;
import org.eclipse.nebula.widgets.nattable.layer.ILayerListener;
import org.eclipse.nebula.widgets.nattable.layer.LabelStack;
import org.eclipse.nebula.widgets.nattable.layer.cell.ColumnOverrideLabelAccumulator;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.layer.event.ILayerEvent;
import org.eclipse.nebula.widgets.nattable.print.config.DefaultPrintBindings;
import org.eclipse.nebula.widgets.nattable.reorder.ColumnReorderLayer;
import org.eclipse.nebula.widgets.nattable.reorder.event.ColumnReorderEvent;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.nebula.widgets.nattable.ui.binding.UiBindingRegistry;
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
import org.eclipse.papyrus.infra.nattable.common.provider.TableSelectionProvider;
import org.eclipse.papyrus.infra.nattable.common.solver.CellManagerFactory;
import org.eclipse.papyrus.infra.nattable.common.utils.LocationValue;
import org.eclipse.papyrus.infra.nattable.common.utils.TableGridRegion;
import org.eclipse.papyrus.infra.nattable.model.nattable.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPartSite;

/**
 * 
 * This class allows to create, configure and manipulate NatTable
 * 
 */
public abstract class AbstractNattableWidgetManager implements INattableModelManager {

	/**
	 * the managed table
	 */
	protected Table table;

	/**
	 * the nattable widget
	 */
	private NatTable natTable;

	/**
	 * the grid layer
	 */
	private GridLayer gridLayer;

	/**
	 * the columnHeaderLayerStack
	 */
	private ColumnHeaderLayerStack columnHeaderLayerStack;

	/**
	 * the rowHeaderLayerStack
	 */
	private RowHeaderLayerStack rowHeaderLayerStack;

	/**
	 * the selection provider
	 */
	private TableSelectionProvider selectionProvider;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param table
	 *        the model of the table
	 */
	public AbstractNattableWidgetManager(final Table table) {
		this.table = table;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.common.manager.INattableModelManager#createNattable(org.eclipse.swt.widgets.Composite, int,
	 *      org.eclipse.ui.IWorkbenchPartSite)
	 * 
	 * @param parent
	 * @param style
	 * @param site
	 * @return
	 */
	public NatTable createNattable(final Composite parent, final int style, final IWorkbenchPartSite site) {
		final BodyDataProvider bodyDataProvider = new BodyDataProvider(this);
		final BodyLayerStack bodyLayerStack = new BodyLayerStack(bodyDataProvider, this);;

		final IDataProvider columnHeaderDataProvider = new ColumnHeaderDataProvider(this);
		columnHeaderLayerStack = new ColumnHeaderLayerStack(columnHeaderDataProvider, bodyLayerStack, bodyDataProvider);

		final IDataProvider rowHeaderDataProvider = new RowHeaderDataProvider(this);


		rowHeaderLayerStack = new RowHeaderLayerStack(rowHeaderDataProvider, bodyLayerStack);


		final IDataProvider cornerDataProvider = new CornerDataProvider(columnHeaderDataProvider, rowHeaderDataProvider);
		final CornerLayer cornerLayer = new CornerLayer(new DataLayer(cornerDataProvider), rowHeaderLayerStack, columnHeaderLayerStack);
		cornerLayer.addConfiguration(new InvertAxisOnCornerConfiguration(this));
		this.gridLayer = new GridLayer(bodyLayerStack, columnHeaderLayerStack, rowHeaderLayerStack, cornerLayer);
		gridLayer.addConfiguration(new DefaultPrintBindings());
		//		gridLayer.addConfiguration(new StyleConfiguration());
		//		fBodyLayer.getBodyDataLayer().addConfiguration(new StyleConfiguration());
		//		fBodyLayer.addConfiguration(new StyleConfiguration());




		this.natTable = new NatTable(parent, gridLayer, false);


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
		addDragAndDropSupport(natTable);


		if(site != null) {
			final MenuManager menuMgr = createMenuManager(natTable);
			final Menu menu = menuMgr.createContextMenu(natTable);
			natTable.setMenu(menu);

			this.selectionProvider = new TableSelectionProvider(bodyLayerStack.getSelectionLayer());
			site.registerContextMenu(menuMgr, this.selectionProvider);
			site.setSelectionProvider(this.selectionProvider);
		}

		return null;
	}

	/**
	 * 
	 * @param nattable
	 * @param bodyLayerStack
	 */
	protected void configureEdition(final NatTable nattable, final BodyLayerStack bodyLayerStack) {
		final ColumnOverrideLabelAccumulator columnLabelAccumulator = new ColumnOverrideLabelAccumulator(bodyLayerStack);
		bodyLayerStack.setConfigLabelAccumulator(columnLabelAccumulator);
		nattable.addConfiguration(new EditConfiguration(this, bodyLayerStack));
	}

	/**
	 * 
	 * @param natTable
	 * @return
	 */
	public MenuManager createMenuManager(final NatTable natTable) {
		final MenuManager menuManager = new MenuManager("#PopUp", "org.eclipse.papyrus.infra.nattable.widget.menu") { //$NON-NLS-1$ //$NON-NLS-2$

			@Override
			public void add(final IAction action) {
				super.add(action);
			}

			@Override
			public void add(final IContributionItem item) {
				super.add(item);
			}
		};
		menuManager.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));

		menuManager.setRemoveAllWhenShown(true);
		return menuManager;
	}

	/**
	 * Enable the table to receive dropped elements
	 * 
	 * @param nattable
	 *        the nattable widget in which we add the drag&drop support
	 */
	protected void addDragAndDropSupport(final NatTable nattable) {
		final int operations = DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_DEFAULT;
		final DropTarget target = new DropTarget(nattable, operations);
		final LocalTransfer localTransfer = LocalTransfer.getInstance();
		final Transfer[] types = new Transfer[]{ localTransfer };
		target.setTransfer(types);
		final NatTableDropListener dropListener = new NatTableDropListener(this);
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
						final List<IAxis> allAxis = table.getVerticalContentProvider().getAxis();
						final IAxis axisToMove = allAxis.get(start);
						if(axisToMove != null) {
							reorderColumnsElements(axisToMove, end);
						}
					}
				}
			}
		});
	}



	/**
	 * 
	 * @param event
	 *        an event
	 * @return
	 *         a LocationValue for the point, which contains informations about this location (TableGridRegion, row and column index, row and column
	 *         elements, the cell, the point and its translation).
	 *         Some of these values can be <code>null</code> or not depending of the region of the table
	 */
	public LocationValue getLocationInTheTable(final Point absolutePoint) {
		final Point widgetPoint = this.natTable.toControl(absolutePoint.x, absolutePoint.y);
		TableGridRegion kind = TableGridRegion.UNKNOWN;
		int columnPosition = this.natTable.getColumnPositionByX(widgetPoint.x);
		int columnIndex = this.natTable.getColumnIndexByPosition(columnPosition);
		int rowPosition = this.natTable.getRowPositionByY(widgetPoint.y);
		int rowIndex = this.natTable.getRowIndexByPosition(rowPosition);
		final ILayerCell cell = this.natTable.getCellByPosition(columnPosition, rowPosition);
		Object columnObject = null;
		Object rowObject = null;
		if(rowIndex == -1 && columnIndex == -1) {
			kind = TableGridRegion.UNKNOWN;
		} else if(rowIndex == -1) {
			kind = TableGridRegion.AFTER_ROW_HEADER;
		} else if(columnIndex == -1) {
			kind = TableGridRegion.AFTER_COLUMN_HEADER;
		} else {

			if(cell != null) {
				LabelStack label = cell.getConfigLabels();
				if(label.hasLabel(GridRegion.ROW_HEADER)) {
					kind = TableGridRegion.ROW_HEADER;

				} else if(label.hasLabel(GridRegion.COLUMN_HEADER)) {
					kind = TableGridRegion.COLUMN_HEADER;

				} else if(label.hasLabel(GridRegion.CORNER)) {
					kind = TableGridRegion.CORNER;
				} else if(label.hasLabel(GridRegion.BODY)) {
					kind = TableGridRegion.CELL;
					columnObject = getColumnElement(columnIndex);
					rowObject = getRowElement(rowIndex);
				}
			}
		}
		return new LocationValue(absolutePoint, widgetPoint, kind, cell, columnIndex, rowIndex, columnObject, rowObject);
	}
}
