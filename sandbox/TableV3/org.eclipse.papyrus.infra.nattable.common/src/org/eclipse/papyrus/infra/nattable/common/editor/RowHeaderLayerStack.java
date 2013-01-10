package org.eclipse.papyrus.infra.nattable.common.editor;

import org.eclipse.nebula.widgets.nattable.config.IConfiguration;
import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.nebula.widgets.nattable.edit.action.MouseEditAction;
import org.eclipse.nebula.widgets.nattable.grid.layer.RowHeaderLayer;
import org.eclipse.nebula.widgets.nattable.layer.AbstractLayerTransform;
import org.eclipse.nebula.widgets.nattable.layer.DataLayer;
import org.eclipse.nebula.widgets.nattable.selection.SelectionLayer;
import org.eclipse.nebula.widgets.nattable.selection.config.DefaultSelectionBindings;
import org.eclipse.nebula.widgets.nattable.ui.binding.UiBindingRegistry;
import org.eclipse.nebula.widgets.nattable.ui.matcher.MouseEventMatcher;
import org.eclipse.papyrus.infra.nattable.common.editor.ColumnHeaderLayerStack.CustomConfig;
import org.eclipse.swt.SWT;


public class RowHeaderLayerStack extends AbstractLayerTransform {

	private static final int DEFAULT_COLUMN_WIDTH = 50;

	private static final int DEFAULT_ROW_HEIGHT = 20;

	public RowHeaderLayerStack(final IDataProvider dataProvider, final BodyLayerStack bodyLayer) {
		DataLayer dataLayer = new DataLayer(dataProvider, RowHeaderLayerStack.DEFAULT_COLUMN_WIDTH, RowHeaderLayerStack.DEFAULT_ROW_HEIGHT);
		//I know that selection layer is probably false
		RowHeaderLayer rowHeaderLayer = new RowHeaderLayer(dataLayer, bodyLayer, /* bodyLayer.getSelectionLayer() */new SelectionLayer(dataLayer));

		IConfiguration configuration = new CustomConfig();
		//		setUnderlyingLayer(sortHeaderLayer);
		rowHeaderLayer.addConfiguration(configuration);

		setUnderlyingLayer(rowHeaderLayer);
	}

	public class CustomConfig extends DefaultSelectionBindings {

		protected void configureRowHeaderMouseClickBindings(UiBindingRegistry uiBindingRegistry) {

			//			uiBindingRegistry.registerDoubleClickBinding(MouseEventMatcher.columnHeaderLeftClick(SWT.NONE), new SelectCellAction());
			uiBindingRegistry.registerDoubleClickBinding(MouseEventMatcher.columnHeaderLeftClick(SWT.NONE), new MouseEditAction());
			//			new BodyCellEditorMouseEventMatcher(TextCellEditor.class),
			//			new MouseEditAction());
			//			uiBindingRegistry.registerSingleClickBinding(MouseEventMatcher.columnHeaderLeftClick(SWT.NONE), new ViewportSelectColumnAction(false, false));
			//			uiBindingRegistry.registerSingleClickBinding(MouseEventMatcher.columnHeaderLeftClick(SWT.SHIFT), new ViewportSelectColumnAction(true, false));
			//			uiBindingRegistry.registerSingleClickBinding(MouseEventMatcher.columnHeaderLeftClick(SWT.CONTROL), new ViewportSelectColumnAction(false, true));
			//			uiBindingRegistry.registerSingleClickBinding(MouseEventMatcher.columnHeaderLeftClick(SWT.SHIFT | SWT.CONTROL), new ViewportSelectColumnAction(true, true));
		}
	}
}
