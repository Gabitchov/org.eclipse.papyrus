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
package org.eclipse.papyrus.infra.nattable.actions;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.infra.nattable.manager.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.utils.Constants;

/**
 * Handler used to sort the columns
 * 
 * @author Vincent Lorenzo
 * 
 */
public class SortColumnsHandler extends AbstractTableHandler {

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
		boolean alphabeticOrder = "true".equals(directionParameter);
		manager.sortColumnsByName(alphabeticOrder);
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
			setBaseEnabled(manager.canReorderColumns());
		}
		super.setEnabled(evaluationContext);
	}
}
