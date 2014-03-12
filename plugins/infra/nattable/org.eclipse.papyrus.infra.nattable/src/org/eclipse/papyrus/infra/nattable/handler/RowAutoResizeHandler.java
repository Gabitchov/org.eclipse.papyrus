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
package org.eclipse.papyrus.infra.nattable.handler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.resize.command.InitializeAutoResizeRowsCommand;
import org.eclipse.nebula.widgets.nattable.util.GCFactory;

/**
 * Handler used to resize rows
 * 
 * @author VL222926
 * 
 */
public class RowAutoResizeHandler extends AbstractTableHandler {

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final NatTable natTable = this.eventData.getNatTable();
		natTable.doCommand(new InitializeAutoResizeRowsCommand(natTable, this.eventData.getRowPosition(), natTable.getConfigRegistry(), new GCFactory(natTable)));
		return null;
	}

}
