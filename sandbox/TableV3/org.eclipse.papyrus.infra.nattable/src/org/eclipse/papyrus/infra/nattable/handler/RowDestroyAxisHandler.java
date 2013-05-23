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

import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager;

/**
 * The handler used to destroy the element represented by the selected rows
 * 
 * @author VL222926
 * 
 */
public class RowDestroyAxisHandler extends AbstractTableHandler {

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
		final IAxisManager axisManager = getRowAxisManager();
		if(axisManager != null) {
			axisManager.destroyAxis(getFullSelectedRowsIndex(this.eventData));
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#setEnabled(java.lang.Object)
	 * 
	 * @param evaluationContext
	 */
	@Override
	public void setEnabled(Object evaluationContext) {
		final IAxisManager axisManager = getRowAxisManager();
		if(axisManager != null) {
			this.eventData = getNatEventData(evaluationContext);
			final List<Integer> rows = getFullSelectedRowsIndex(this.eventData);
			setBaseEnabled(axisManager.canDestroyAxis(rows));
		}
		super.setBaseEnabled(false);
	}
}
