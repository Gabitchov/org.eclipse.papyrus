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

import org.eclipse.nebula.widgets.nattable.config.AbstractUiBindingConfiguration;
import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.nebula.widgets.nattable.edit.action.MouseEditAction;
import org.eclipse.nebula.widgets.nattable.grid.GridRegion;
import org.eclipse.nebula.widgets.nattable.grid.layer.RowHeaderLayer;
import org.eclipse.nebula.widgets.nattable.layer.AbstractLayerTransform;
import org.eclipse.nebula.widgets.nattable.layer.DataLayer;
import org.eclipse.nebula.widgets.nattable.reorder.action.RowReorderDragMode;
import org.eclipse.nebula.widgets.nattable.selection.SelectionLayer;
import org.eclipse.nebula.widgets.nattable.selection.config.DefaultSelectionBindings;
import org.eclipse.nebula.widgets.nattable.ui.action.AggregateDragMode;
import org.eclipse.nebula.widgets.nattable.ui.action.CellDragMode;
import org.eclipse.nebula.widgets.nattable.ui.binding.UiBindingRegistry;
import org.eclipse.nebula.widgets.nattable.ui.matcher.MouseEventMatcher;
import org.eclipse.papyrus.infra.nattable.configuration.PapyrusRowHeaderStyleConfiguration;
import org.eclipse.swt.SWT;


public class RowHeaderLayerStack extends AbstractLayerTransform {

	private static final int DEFAULT_COLUMN_WIDTH = 50;

	private static final int DEFAULT_ROW_HEIGHT = 20;

	public RowHeaderLayerStack(final IDataProvider dataProvider, final BodyLayerStack bodyLayer) {
		final DataLayer dataLayer = new DataLayer(dataProvider, RowHeaderLayerStack.DEFAULT_COLUMN_WIDTH, RowHeaderLayerStack.DEFAULT_ROW_HEIGHT);
		//I know that selection layer is probably false
		final RowHeaderLayer rowHeaderLayer = new RowHeaderLayer(dataLayer, bodyLayer, /* bodyLayer.getSelectionLayer() */new SelectionLayer(dataLayer));

		//ne marche pas! but : avoir le même type de cellule dans les headers des lignes et des colonnes
		rowHeaderLayer.addConfiguration(new PapyrusRowHeaderStyleConfiguration());
		//		final IConfiguration configuration = new CustomConfig();
		//		setUnderlyingLayer(sortHeaderLayer);
		//		rowHeaderLayer.addConfiguration(configuration);
		//		rowHeaderLayer.addConfiguration(new RowOnlySelectionBindings());
		setUnderlyingLayer(rowHeaderLayer);
		setRegionName(GridRegion.ROW_HEADER);
	}

	public class CustomConfig extends DefaultSelectionBindings {



		@Override
		protected void configureRowHeaderMouseClickBindings(final UiBindingRegistry uiBindingRegistry) {

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

	public class ReoderRowConfid extends AbstractUiBindingConfiguration {//This configuration should be added by the same kind of layer that DefaultColumnReorderLayerConfiguration but for row!

		public void configureUiBindings(final UiBindingRegistry uiBindingRegistry) {
			uiBindingRegistry.registerMouseDragMode(MouseEventMatcher.rowHeaderLeftClick(SWT.NONE), new AggregateDragMode(new CellDragMode(), new RowReorderDragMode()));
		}
	}
}
