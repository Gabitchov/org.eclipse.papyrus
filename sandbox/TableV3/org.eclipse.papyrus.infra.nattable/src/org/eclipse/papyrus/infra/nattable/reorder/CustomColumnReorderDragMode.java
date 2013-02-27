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

import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.reorder.action.ColumnReorderDragMode;
import org.eclipse.papyrus.infra.nattable.manager.INattableModelManager;
import org.eclipse.swt.events.MouseEvent;

/**
 * 
 * This custom Drag Mode for columns allows to restrict the Drag of the Column
 * 
 */
public class CustomColumnReorderDragMode extends ColumnReorderDragMode {

	/**
	 * the table manager
	 */
	private INattableModelManager manager;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param manager
	 *        the table manager
	 */
	public CustomColumnReorderDragMode(final INattableModelManager manager) {
		this.manager = manager;
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.reorder.action.ColumnReorderDragMode#mouseDown(org.eclipse.nebula.widgets.nattable.NatTable,
	 *      org.eclipse.swt.events.MouseEvent)
	 * 
	 * @param natTable
	 * @param event
	 */
	public void mouseDown(NatTable natTable, MouseEvent event) {
		if(this.manager.canReorderColumns()) {
			super.mouseDown(natTable, event);
		}
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.reorder.action.ColumnReorderDragMode#mouseMove(org.eclipse.nebula.widgets.nattable.NatTable,
	 *      org.eclipse.swt.events.MouseEvent)
	 * 
	 * @param natTable
	 * @param event
	 */
	public void mouseMove(NatTable natTable, MouseEvent event) {
		if(this.manager.canReorderColumns()) {
			super.mouseMove(natTable, event);
		}
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.reorder.action.ColumnReorderDragMode#mouseUp(org.eclipse.nebula.widgets.nattable.NatTable,
	 *      org.eclipse.swt.events.MouseEvent)
	 * 
	 * @param natTable
	 * @param event
	 */
	public void mouseUp(NatTable natTable, MouseEvent event) {
		if(this.manager.canReorderColumns()) {
			super.mouseUp(natTable, event);
		}
	}
}
