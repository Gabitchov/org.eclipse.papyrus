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
import org.eclipse.nebula.widgets.nattable.ui.NatEventData;
import org.eclipse.papyrus.infra.nattable.manager.table.AbstractNattableWidgetManager;
import org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager;

//TODO : this handler should be declare on org.eclipse.ui.edit (or something like this) to be binded on F2

public class ColumnEditAliasHeaderHandler extends AbstractTableHandler {

	//TODO : this attribute must be removed when we introduce the dependency on e4.
	private NatEventData eventData;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if(this.eventData != null) {
			AbstractNattableWidgetManager manager = (AbstractNattableWidgetManager)getCurrentNattableModelManager();
			manager.openEditColumnAliasDialog(this.eventData);
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
	public void setEnabled(Object evaluationContext) {//it must be the nattable selection event
		final NatEventData eventData = getNatEventData(evaluationContext);
		this.eventData = eventData;
		final NattableModelManager manager = (NattableModelManager)getCurrentNattableModelManager();
		if(eventData != null && manager != null) {
			setBaseEnabled(manager.canEditColumnHeader(eventData));
		} else {
			setBaseEnabled(false);
		}
	}


}
