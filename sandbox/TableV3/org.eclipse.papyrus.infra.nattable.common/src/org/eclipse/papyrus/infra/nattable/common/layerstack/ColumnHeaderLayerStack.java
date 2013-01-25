package org.eclipse.papyrus.infra.nattable.common.layerstack;

import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.config.ConfigRegistry;
import org.eclipse.nebula.widgets.nattable.config.IConfiguration;
import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.nebula.widgets.nattable.edit.action.MouseEditAction;
import org.eclipse.nebula.widgets.nattable.grid.layer.ColumnHeaderLayer;
import org.eclipse.nebula.widgets.nattable.layer.AbstractLayerTransform;
import org.eclipse.nebula.widgets.nattable.layer.DataLayer;
import org.eclipse.nebula.widgets.nattable.print.command.TurnViewportOffCommand;
import org.eclipse.nebula.widgets.nattable.print.command.TurnViewportOnCommand;
import org.eclipse.nebula.widgets.nattable.selection.SelectionLayer;
import org.eclipse.nebula.widgets.nattable.selection.config.DefaultSelectionBindings;
import org.eclipse.nebula.widgets.nattable.ui.binding.UiBindingRegistry;
import org.eclipse.nebula.widgets.nattable.ui.matcher.MouseEventMatcher;
import org.eclipse.nebula.widgets.nattable.viewport.ViewportLayer;
import org.eclipse.nebula.widgets.nattable.viewport.action.ViewportSelectColumnAction;
import org.eclipse.papyrus.infra.nattable.common.configuration.PapyrusDefaultColumnStyleStyleConfiguration;
import org.eclipse.papyrus.infra.nattable.common.dataprovider.BodyDataProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;


public class ColumnHeaderLayerStack extends AbstractLayerTransform {

	private final DataLayer dataLayer;

	private final SelectionLayer selectionLayer;

	private final ColumnHeaderLayer colHeaderLayer;

	public ColumnHeaderLayerStack(final IDataProvider dataProvider, final BodyLayerStack bodyLayer, final BodyDataProvider bodyDataProvider) {
		this.dataLayer = new DataLayer(dataProvider);
		//		this.selectionLayer = null;//new SelectionLayer(this.dataLayer);
		//FIXME : changes the data layer
		//		ViewportLayer viewportLayer = new ViewportLayer(selectionLayer);

		//		this.colHeaderLayer = new ColumnHeaderLayer(this.dataLayer, bodyLayer, this.selectionLayer);


		final SelectionLayer selectionLayer = new SelectionLayer(new DataLayer(bodyDataProvider));
		final ViewportLayer viewportLayer = new ViewportLayer(selectionLayer);
		this.selectionLayer = bodyLayer.getSelectionLayer();
		this.colHeaderLayer = new ColumnHeaderLayer(this.dataLayer, bodyLayer.getViewportLayer(), bodyLayer.getSelectionLayer());



		final IConfiguration configuration = new CustomConfig();
		//		setUnderlyingLayer(sortHeaderLayer);
		this.colHeaderLayer.addConfiguration(new PapyrusDefaultColumnStyleStyleConfiguration());
		//		this.colHeaderLayer.addConfiguration(configuration);
		setUnderlyingLayer(this.colHeaderLayer);
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
			uiBindingRegistry.registerSingleClickBinding(MouseEventMatcher.columnHeaderLeftClick(SWT.NONE), new CustomSelectionViewPortAction(false, false));
			//			uiBindingRegistry.registerDoubleClickBinding(MouseEventMatcher.columnHeaderLeftClick(SWT.NONE), new SelectCellAction());

			//			new BodyCellEditorMouseEventMatcher(TextCellEditor.class),
			//			new MouseEditAction());
			//			uiBindingRegistry.registerSingleClickBinding(MouseEventMatcher.columnHeaderLeftClick(SWT.NONE), new ViewportSelectColumnAction(false, false));
			//			uiBindingRegistry.registerSingleClickBinding(MouseEventMatcher.columnHeaderLeftClick(SWT.SHIFT), new ViewportSelectColumnAction(true, false));
			//			uiBindingRegistry.registerSingleClickBinding(MouseEventMatcher.columnHeaderLeftClick(SWT.CONTROL), new ViewportSelectColumnAction(false, true));
			//			uiBindingRegistry.registerSingleClickBinding(MouseEventMatcher.columnHeaderLeftClick(SWT.SHIFT | SWT.CONTROL), new ViewportSelectColumnAction(true, true));
		}
	}

	public SelectionLayer getSelectionLayer() {
		return this.selectionLayer;
	}

	public class CustomSelectionViewPortAction extends ViewportSelectColumnAction {

		public CustomSelectionViewPortAction(final boolean withShiftMask, final boolean withControlMask) {
			super(withShiftMask, withControlMask);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void run(final NatTable natTable, final MouseEvent event) {
			final int xPos = ColumnHeaderLayerStack.this.dataLayer.getColumnPositionByX(event.x);
			final int yPos = ColumnHeaderLayerStack.this.dataLayer.getRowPositionByIndex(event.y);
			//			System.out.println(xPos);
			//			System.out.println(yPos);
			final int xPos1 = ColumnHeaderLayerStack.this.colHeaderLayer.getColumnPositionByX(event.x);
			final int yPos1 = ColumnHeaderLayerStack.this.colHeaderLayer.getRowPositionByY(event.y);
			//			System.out.println(xPos1);
			//			System.out.println(yPos2);
			//natTable.doCommand(new ViewportSelectColumnAction(withShiftMask, withControlMask))
			//			ColumnHeaderLayerStack.this.selectionLayer.selectColumn(yPos2, xPos1, false, false);

			final int xPos2 = ColumnHeaderLayerStack.this.selectionLayer.getColumnPositionByX(event.x);
			final int yPos2 = ColumnHeaderLayerStack.this.selectionLayer.getRowPositionByIndex(event.y);

			natTable.doCommand(new TurnViewportOffCommand());
			//			natTable.doCommand(new PrintCommand(natTable.getConfigRegistry(), natTable.getShell()));

			ColumnHeaderLayerStack.this.selectionLayer.selectColumn(xPos1, yPos1, false, false);
			natTable.doCommand(new TurnViewportOnCommand());
			//			natTable.doCommand(new ViewportSelectColumnCommand(ColumnHeaderLayerStack.this.dataLayer, natTable.getColumnPositionByX(event.x), false, false));
		}

	}
}
