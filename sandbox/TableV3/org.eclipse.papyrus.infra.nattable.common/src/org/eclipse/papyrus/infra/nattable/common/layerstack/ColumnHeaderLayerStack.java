package org.eclipse.papyrus.infra.nattable.common.layerstack;

import org.eclipse.nebula.widgets.nattable.config.ConfigRegistry;
import org.eclipse.nebula.widgets.nattable.config.IConfiguration;
import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.nebula.widgets.nattable.edit.action.MouseEditAction;
import org.eclipse.nebula.widgets.nattable.grid.layer.ColumnHeaderLayer;
import org.eclipse.nebula.widgets.nattable.layer.AbstractLayerTransform;
import org.eclipse.nebula.widgets.nattable.layer.DataLayer;
import org.eclipse.nebula.widgets.nattable.selection.SelectionLayer;
import org.eclipse.nebula.widgets.nattable.selection.config.DefaultSelectionBindings;
import org.eclipse.nebula.widgets.nattable.ui.binding.UiBindingRegistry;
import org.eclipse.nebula.widgets.nattable.ui.matcher.MouseEventMatcher;
import org.eclipse.papyrus.infra.nattable.common.configuration.PapyrusDefaultColumnStyleStyleConfiguration;
import org.eclipse.papyrus.infra.nattable.common.dataprovider.BodyDataProvider;
import org.eclipse.swt.SWT;


public class ColumnHeaderLayerStack extends AbstractLayerTransform {

	private final DataLayer dataLayer;

	public ColumnHeaderLayerStack(final IDataProvider dataProvider, final BodyLayerStack bodyLayer, final BodyDataProvider bodyDataProvider) {
		this.dataLayer = new DataLayer(dataProvider);
		//FIXME : changes the data layer
		final ColumnHeaderLayer colHeaderLayer = new ColumnHeaderLayer(this.dataLayer, bodyLayer, new SelectionLayer(this.dataLayer));



		final IConfiguration configuration = new CustomConfig();
		//		setUnderlyingLayer(sortHeaderLayer);
		colHeaderLayer.addConfiguration(new PapyrusDefaultColumnStyleStyleConfiguration());
		setUnderlyingLayer(colHeaderLayer);
	}

	public DataLayer getDataLayer() {
		return this.dataLayer;
	}

	@Override
	public void configure(final ConfigRegistry configRegistry, final UiBindingRegistry uiBindingRegistry) {
		super.configure(configRegistry, uiBindingRegistry);
	}
	public class CustomConfig extends DefaultSelectionBindings {

		@Override
		protected void configureColumnHeaderMouseClickBindings(final UiBindingRegistry uiBindingRegistry) {
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
