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
 * The handler used to destroy the elements represented by the selected columns
 * 
 * @author VL222926
 * 
 */
public class ColumnDestroyAxisElementHandler extends AbstractTableHandler {

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
		final IAxisManager axisManager = getColumnAxisManager();
		if(axisManager != null) {
			axisManager.destroyAxisElement(getFullSelectedColumnsIndex(this.eventData));
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
		boolean enabled = false;
		final IAxisManager axisManager = getColumnAxisManager();
		if(axisManager != null) {
			this.eventData = getNatEventData(evaluationContext);
			final List<Integer> col = getFullSelectedColumnsIndex(this.eventData);
			enabled = axisManager.canDestroyAxisElement(col);
		}
		setBaseEnabled(enabled);

	}
}
