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
package org.eclipse.papyrus.infra.nattable.layerstack;

import org.eclipse.nebula.widgets.nattable.config.ConfigRegistry;
import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.nebula.widgets.nattable.edit.action.KeyEditAction;
import org.eclipse.nebula.widgets.nattable.grid.GridRegion;
import org.eclipse.nebula.widgets.nattable.hideshow.ColumnHideShowLayer;
import org.eclipse.nebula.widgets.nattable.layer.AbstractLayerTransform;
import org.eclipse.nebula.widgets.nattable.layer.DataLayer;
import org.eclipse.nebula.widgets.nattable.reorder.ColumnReorderLayer;
import org.eclipse.nebula.widgets.nattable.selection.SelectionLayer;
import org.eclipse.nebula.widgets.nattable.ui.binding.UiBindingRegistry;
import org.eclipse.nebula.widgets.nattable.ui.matcher.KeyEventMatcher;
import org.eclipse.nebula.widgets.nattable.viewport.ViewportLayer;
import org.eclipse.papyrus.infra.nattable.configuration.StyleConfiguration;
import org.eclipse.papyrus.infra.nattable.manager.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.reorder.CustomDefaultColumnReorderBindings;
import org.eclipse.swt.SWT;



public class BodyLayerStack extends AbstractLayerTransform {

	private final SelectionLayer selectionLayer;

	private final DataLayer bodyDataLayer;

	private final ViewportLayer viewportLayer;

	private final ColumnHideShowLayer columnHideShowLayer;

	private final ColumnReorderLayer columnReorderLayer;

//	private final RowReorderLayer rowReoderLayer;

	public BodyLayerStack(final IDataProvider dataProvider, final INattableModelManager manager) {
		this.bodyDataLayer = new DataLayer(dataProvider);
		this.bodyDataLayer.addConfiguration(new StyleConfiguration());
		this.bodyDataLayer.setDefaultColumnWidth(200);

		this.columnReorderLayer = new ColumnReorderLayer(this.bodyDataLayer, false);

		//we register a custom configuration to manage the case where the reorder is forbidden
		this.columnReorderLayer.addConfiguration(new CustomDefaultColumnReorderBindings(manager));


		//to allow the reorder on the lines
//		this.rowReoderLayer = null;
		//		this.rowReoderLayer = new RowReorderLayer(columnReorderLayer);
		//		this.columnHideShowLayer = new ColumnHideShowLayer(this.rowReoderLayer);

		this.columnHideShowLayer = new ColumnHideShowLayer(this.columnReorderLayer);



		this.selectionLayer = new SelectionLayer(this.columnHideShowLayer);
		this.viewportLayer = new ViewportLayer(this.selectionLayer);
		setUnderlyingLayer(this.viewportLayer);
		setRegionName(GridRegion.BODY);
	}


	public SelectionLayer getSelectionLayer() {
		return this.selectionLayer;
	}

	public DataLayer getBodyDataLayer() {
		return this.bodyDataLayer;
	}

	public ViewportLayer getViewportLayer() {
		return this.viewportLayer;
	}

	public ColumnHideShowLayer getColumnHideShowLayer() {
		return this.columnHideShowLayer;
	}

	public ColumnReorderLayer getColumnReorderLayer() {
		return this.columnReorderLayer;
	}

	@Override
	public void configure(ConfigRegistry configRegistry, UiBindingRegistry uiBindingRegistry) {
		super.configure(configRegistry, uiBindingRegistry);
		uiBindingRegistry.registerKeyBinding(new KeyEventMatcher(SWT.NONE, SWT.F2), new KeyEditAction());
		//		configRegistry.registerConfigAttribute(EditConfigAttributes.CELL_EDITABLE_RULE, IEditableRule.ALWAYS_EDITABLE);
		//		uiBindingRegistry.registerKeyBinding(new Mouse, new KeyEditAction());
		//		uiBindingRegistry.
		//		configRegistry.registerConfigAttribute(CellConfigAttributes.CELL_PAINTER, new CustomizedCellPainter(), DisplayMode.NORMAL, GridRegion.BODY);
	}


//	public RowReorderLayer getRowReoderLayer() {
//		return this.rowReoderLayer;
//	}
}
