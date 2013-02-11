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
package org.eclipse.papyrus.infra.nattable.common.layerstack;

import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.nebula.widgets.nattable.grid.GridRegion;
import org.eclipse.nebula.widgets.nattable.hideshow.ColumnHideShowLayer;
import org.eclipse.nebula.widgets.nattable.layer.AbstractLayerTransform;
import org.eclipse.nebula.widgets.nattable.layer.DataLayer;
import org.eclipse.nebula.widgets.nattable.reorder.ColumnReorderLayer;
import org.eclipse.nebula.widgets.nattable.selection.SelectionLayer;
import org.eclipse.nebula.widgets.nattable.viewport.ViewportLayer;
import org.eclipse.papyrus.infra.nattable.common.configuration.StyleConfiguration;



public class BodyLayerStack extends AbstractLayerTransform {

	private final SelectionLayer selectionLayer;

	private final DataLayer bodyDataLayer;

	private final ViewportLayer viewportLayer;

	private final ColumnHideShowLayer columnHideShowLayer;

	private final ColumnReorderLayer columnReorderLayer;

	public BodyLayerStack(final IDataProvider dataProvider) {
		this.bodyDataLayer = new DataLayer(dataProvider);
		this.bodyDataLayer.addConfiguration(new StyleConfiguration());
		this.bodyDataLayer.setDefaultColumnWidth(200);

		this.columnReorderLayer = new ColumnReorderLayer(this.bodyDataLayer);
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
}
