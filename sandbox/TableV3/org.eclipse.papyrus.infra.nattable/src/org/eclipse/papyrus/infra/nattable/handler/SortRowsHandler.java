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
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.utils.Constants;

/**
 * The handler for the sort rows action
 * 
 * @author Vincent Lorenzo
 * 
 */
public class SortRowsHandler extends AbstractTableHandler {

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final String directionParameter = event.getParameter(Constants.SORT_COMMAND_PARAMETER);
		INattableModelManager manager = getCurrentNattableModelManager();
		boolean alphabeticOrder = Boolean.TRUE.toString().equals(directionParameter);
		manager.sortRowsByName(alphabeticOrder);
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
		INattableModelManager manager = getCurrentNattableModelManager();
		if(manager != null) {
			setBaseEnabled(manager.canMoveColumns());
		}
		super.setBaseEnabled(false);
	}
}
