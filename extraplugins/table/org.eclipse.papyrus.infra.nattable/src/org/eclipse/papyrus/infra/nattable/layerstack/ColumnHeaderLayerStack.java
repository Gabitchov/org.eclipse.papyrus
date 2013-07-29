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

import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.nebula.widgets.nattable.grid.GridRegion;
import org.eclipse.nebula.widgets.nattable.grid.layer.ColumnHeaderLayer;
import org.eclipse.nebula.widgets.nattable.layer.AbstractLayerTransform;
import org.eclipse.nebula.widgets.nattable.layer.DataLayer;
import org.eclipse.papyrus.infra.nattable.configuration.PapyrusColumnHeaderStyleConfiguration;
import org.eclipse.papyrus.infra.nattable.configuration.PapyrusColumnResizeBindingsConfiguration;
import org.eclipse.papyrus.infra.nattable.dataprovider.BodyDataProvider;
import org.eclipse.papyrus.infra.nattable.utils.DefaultSizeUtils;


public class ColumnHeaderLayerStack extends AbstractLayerTransform {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param dataProvider
	 * @param bodyLayer
	 * @param bodyDataProvider
	 */
	public ColumnHeaderLayerStack(final IDataProvider dataProvider, final BodyLayerStack bodyLayer, final BodyDataProvider bodyDataProvider) {
		DataLayer dataLayer = new DataLayer(dataProvider, DefaultSizeUtils.getDefaultCellWidth(), DefaultSizeUtils.getDefaultCellHeight());
		ColumnHeaderLayer colHeaderLayer = new ColumnHeaderLayer(dataLayer, bodyLayer.getViewportLayer(), bodyLayer.getSelectionLayer(), false);
		colHeaderLayer.addConfiguration(new PapyrusColumnResizeBindingsConfiguration());
		colHeaderLayer.addConfiguration(new PapyrusColumnHeaderStyleConfiguration());
		setUnderlyingLayer(colHeaderLayer);
		setRegionName(GridRegion.COLUMN_HEADER);
	}
}
