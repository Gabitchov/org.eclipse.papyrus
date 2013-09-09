/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.infra.nattable.configuration;

import org.eclipse.nebula.widgets.nattable.config.AbstractUiBindingConfiguration;
import org.eclipse.nebula.widgets.nattable.grid.GridRegion;
import org.eclipse.nebula.widgets.nattable.resize.action.ColumnResizeCursorAction;
import org.eclipse.nebula.widgets.nattable.resize.event.ColumnResizeEventMatcher;
import org.eclipse.nebula.widgets.nattable.resize.mode.ColumnResizeDragMode;
import org.eclipse.nebula.widgets.nattable.ui.action.ClearCursorAction;
import org.eclipse.nebula.widgets.nattable.ui.action.NoOpMouseAction;
import org.eclipse.nebula.widgets.nattable.ui.binding.UiBindingRegistry;
import org.eclipse.nebula.widgets.nattable.ui.matcher.MouseEventMatcher;
import org.eclipse.swt.SWT;

/**
 * Adapted code from DefaultRowResizeBindings. Allow to resize the columns on all regions of the table (corner, body, row header, column header)
 * 
 * @author vl222926
 * 
 */
public class PapyrusColumnResizeBindingsConfiguration extends AbstractUiBindingConfiguration {

	@Override
	public void configureUiBindings(UiBindingRegistry uiBindingRegistry) {
		// Mouse move - Show resize cursor
		uiBindingRegistry.registerFirstMouseMoveBinding(new ColumnResizeEventMatcher(SWT.NONE, GridRegion.COLUMN_HEADER, 0), new ColumnResizeCursorAction());
		uiBindingRegistry.registerFirstMouseMoveBinding(new ColumnResizeEventMatcher(SWT.NONE, GridRegion.ROW_HEADER, 0), new ColumnResizeCursorAction());
		uiBindingRegistry.registerFirstMouseMoveBinding(new ColumnResizeEventMatcher(SWT.NONE, GridRegion.CORNER, 0), new ColumnResizeCursorAction());
		uiBindingRegistry.registerFirstMouseMoveBinding(new ColumnResizeEventMatcher(SWT.NONE, GridRegion.BODY, 0), new ColumnResizeCursorAction());

		uiBindingRegistry.registerMouseMoveBinding(new MouseEventMatcher(), new ClearCursorAction());

		// Column resize
		uiBindingRegistry.registerFirstMouseDragMode(new ColumnResizeEventMatcher(SWT.NONE, GridRegion.COLUMN_HEADER, 1), new ColumnResizeDragMode());
		uiBindingRegistry.registerFirstMouseDragMode(new ColumnResizeEventMatcher(SWT.NONE, GridRegion.ROW_HEADER, 1), new ColumnResizeDragMode());
		uiBindingRegistry.registerFirstMouseDragMode(new ColumnResizeEventMatcher(SWT.NONE, GridRegion.CORNER, 1), new ColumnResizeDragMode());
		uiBindingRegistry.registerFirstMouseDragMode(new ColumnResizeEventMatcher(SWT.NONE, GridRegion.BODY, 1), new ColumnResizeDragMode());

		//			uiBindingRegistry.registerDoubleClickBinding(new ColumnResizeEventMatcher(SWT.NONE, GridRegion.COLUMN_HEADER, 1), new AutoResizeColumnAction());
		uiBindingRegistry.registerSingleClickBinding(new ColumnResizeEventMatcher(SWT.NONE, GridRegion.COLUMN_HEADER, 1), new NoOpMouseAction());
	}
}
