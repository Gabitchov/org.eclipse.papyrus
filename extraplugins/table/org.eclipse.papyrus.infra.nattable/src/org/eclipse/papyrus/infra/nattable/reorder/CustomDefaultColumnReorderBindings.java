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
package org.eclipse.papyrus.infra.nattable.reorder;

import org.eclipse.nebula.widgets.nattable.reorder.config.DefaultColumnReorderBindings;
import org.eclipse.nebula.widgets.nattable.ui.action.AggregateDragMode;
import org.eclipse.nebula.widgets.nattable.ui.binding.UiBindingRegistry;
import org.eclipse.nebula.widgets.nattable.ui.matcher.MouseEventMatcher;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.swt.SWT;

/**
 * 
 * This bindings allows to move the columns, only when the manager allows it.
 * 
 */
public class CustomDefaultColumnReorderBindings extends DefaultColumnReorderBindings {

	/**
	 * the table manager
	 */
	private final INattableModelManager manager;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param manager
	 *        the table manager
	 */
	public CustomDefaultColumnReorderBindings(final INattableModelManager manager) {
		this.manager = manager;
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.reorder.config.DefaultReorderBindings#configureUiBindings(org.eclipse.nebula.widgets.nattable.ui.binding.UiBindingRegistry)
	 * 
	 * @param uiBindingRegistry
	 */
	@Override
	public void configureUiBindings(UiBindingRegistry uiBindingRegistry) {
		assert manager != null;
		uiBindingRegistry.registerMouseDragMode(MouseEventMatcher.columnHeaderLeftClick(SWT.NONE), new AggregateDragMode(new CustomCellDragModeForColumn(this.manager), new CustomColumnReorderDragMode(this.manager)));
	}

}
