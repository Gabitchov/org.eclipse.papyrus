package org.eclipse.papyrus.infra.nattable.common.editor;

import org.eclipse.nebula.widgets.nattable.config.IConfiguration;
import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.nebula.widgets.nattable.edit.action.MouseEditAction;
import org.eclipse.nebula.widgets.nattable.edit.editor.TextCellEditor;
import org.eclipse.nebula.widgets.nattable.grid.GridRegion;
import org.eclipse.nebula.widgets.nattable.grid.layer.ColumnHeaderLayer;
import org.eclipse.nebula.widgets.nattable.layer.AbstractLayerTransform;
import org.eclipse.nebula.widgets.nattable.layer.DataLayer;
import org.eclipse.nebula.widgets.nattable.selection.SelectionLayer;
import org.eclipse.nebula.widgets.nattable.selection.action.SelectCellAction;
import org.eclipse.nebula.widgets.nattable.selection.config.DefaultSelectionBindings;
import org.eclipse.nebula.widgets.nattable.ui.binding.UiBindingRegistry;
import org.eclipse.nebula.widgets.nattable.ui.matcher.BodyCellEditorMouseEventMatcher;
import org.eclipse.nebula.widgets.nattable.ui.matcher.MouseEventMatcher;
import org.eclipse.nebula.widgets.nattable.viewport.action.ViewportSelectColumnAction;
import org.eclipse.swt.SWT;


public class ColumnHeaderLayerStack extends AbstractLayerTransform {

	private final DataLayer dataLayer;

	public ColumnHeaderLayerStack(final IDataProvider dataProvider, final BodyLayerStack bodyLayer, final BodyDataProvider bodyDataProvider) {
		this.dataLayer = new DataLayer(dataProvider);
		//FIXME : changes the data layer
		ColumnHeaderLayer colHeaderLayer = new ColumnHeaderLayer(this.dataLayer, bodyLayer, new SelectionLayer(dataLayer));

		//		ISortModel sortModel = new ISortModel() {
		//
		//			private int sortedColumn = -1;
		//
		//			private SortDirectionEnum fSortDirection = SortDirectionEnum.NONE;
		//
		//			public void sort(final int columnIndex, final SortDirectionEnum sortDirection, final boolean accumulate) {
		//				this.sortedColumn = columnIndex;
		//				this.fSortDirection = sortDirection;
		//
		//				bodyDataProvider.sort(columnIndex, sortDirection);
		//				bodyLayer.fireLayerEvent(new StructuralRefreshEvent(bodyLayer.getBodyDataLayer()));
		//			}
		//
		//			public boolean isColumnIndexSorted(final int columnIndex) {
		//				return columnIndex == this.sortedColumn && this.fSortDirection != SortDirectionEnum.NONE;
		//			}
		//
		//			public int getSortOrder(final int columnIndex) {
		//				return 0;
		//			}
		//
		//			public SortDirectionEnum getSortDirection(final int columnIndex) {
		//				if(columnIndex == this.sortedColumn) {
		//					return this.fSortDirection;
		//				}
		//				return SortDirectionEnum.NONE;
		//			}
		//
		//			public void clear() {
		//				this.sortedColumn = -1;
		//				this.fSortDirection = SortDirectionEnum.NONE;
		//			}
		//		};
		//
		//		SortHeaderLayer<ISortModel> sortHeaderLayer = new SortHeaderLayer<ISortModel>(colHeaderLayer, sortModel, true);

		IConfiguration configuration = new CustomConfig();
		//		setUnderlyingLayer(sortHeaderLayer);
		colHeaderLayer.addConfiguration(configuration);
		setUnderlyingLayer(colHeaderLayer);
	}

	public DataLayer getDataLayer() {
		return this.dataLayer;
	}

	public class CustomConfig extends DefaultSelectionBindings {

		protected void configureColumnHeaderMouseClickBindings(UiBindingRegistry uiBindingRegistry) {
			//edit sur double click
			uiBindingRegistry.registerDoubleClickBinding(MouseEventMatcher.columnHeaderLeftClick(SWT.NONE), new MouseEditAction());

			//			uiBindingRegistry.registerDoubleClickBinding(MouseEventMatcher.columnHeaderLeftClick(SWT.NONE), new SelectCellAction());

			//			new BodyCellEditorMouseEventMatcher(TextCellEditor.class),
			//			new MouseEditAction());
			//			uiBindingRegistry.registerSingleClickBinding(MouseEventMatcher.columnHeaderLeftClick(SWT.NONE), new ViewportSelectColumnAction(false, false));
			//			uiBindingRegistry.registerSingleClickBinding(MouseEventMatcher.columnHeaderLeftClick(SWT.SHIFT), new ViewportSelectColumnAction(true, false));
			//			uiBindingRegistry.registerSingleClickBinding(MouseEventMatcher.columnHeaderLeftClick(SWT.CONTROL), new ViewportSelectColumnAction(false, true));
			//			uiBindingRegistry.registerSingleClickBinding(MouseEventMatcher.columnHeaderLeftClick(SWT.SHIFT | SWT.CONTROL), new ViewportSelectColumnAction(true, true));
		}
	}
}
