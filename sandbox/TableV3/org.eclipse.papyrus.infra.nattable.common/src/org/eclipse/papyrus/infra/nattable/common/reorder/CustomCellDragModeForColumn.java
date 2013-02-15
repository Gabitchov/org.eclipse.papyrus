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
package org.eclipse.papyrus.infra.nattable.common.reorder;

import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.ui.action.CellDragMode;
import org.eclipse.papyrus.infra.nattable.common.manager.INattableModelManager;
import org.eclipse.swt.events.MouseEvent;

/**
 * 
 * This custom Cell Drag Mode allows to hide the phantom of the header when the drag of column is forbidden
 *
 */
public class CustomCellDragModeForColumn extends CellDragMode {

	/**
	 * The manager of the table
	 */
	private final INattableModelManager manager;
	
	/**
	 * 
	 * Constructor.
	 *
	 * @param manager
	 * the manager of the table
	 */
	public CustomCellDragModeForColumn(final INattableModelManager manager) {
		this.manager = manager;
	}
	
	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.ui.action.CellDragMode#mouseDown(org.eclipse.nebula.widgets.nattable.NatTable, org.eclipse.swt.events.MouseEvent)
	 *
	 * @param natTable
	 * @param event
	 */
	public void mouseDown(NatTable natTable, MouseEvent event) {
		if(this.manager.canReorderColumns()){
			super.mouseDown(natTable, event);
		}
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.ui.action.CellDragMode#mouseMove(org.eclipse.nebula.widgets.nattable.NatTable, org.eclipse.swt.events.MouseEvent)
	 *
	 * @param natTable
	 * @param event
	 */
	public void mouseMove(NatTable natTable, MouseEvent event) {
		if(this.manager.canReorderColumns()){
			super.mouseMove(natTable, event);
		}

	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.ui.action.CellDragMode#mouseUp(org.eclipse.nebula.widgets.nattable.NatTable, org.eclipse.swt.events.MouseEvent)
	 *
	 * @param natTable
	 * @param event
	 */
	public void mouseUp(NatTable natTable, MouseEvent event) {
		if(this.manager.canReorderColumns()){
			super.mouseUp(natTable, event);
		}

	}
	

}
