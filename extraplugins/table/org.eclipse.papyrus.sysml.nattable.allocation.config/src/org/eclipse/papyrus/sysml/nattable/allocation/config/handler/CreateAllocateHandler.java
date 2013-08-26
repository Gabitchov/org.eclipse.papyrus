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
package org.eclipse.papyrus.sysml.nattable.allocation.config.handler;

import org.eclipse.emf.common.command.Command;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.utils.INattableModelManagerUtils;
import org.eclipse.papyrus.sysml.nattable.menu.handlers.AllocateHandler;

/**
 * This handler allows to create an Allocate object, only if the table is a PapyrusSysMLAllocationTable
 * 
 * @author vl222926
 * 
 */
public class CreateAllocateHandler extends AllocateHandler {

	/**
	 * the id used for the Papyrus SysML Allocation Table
	 */
	public static final String TABLE_ALLOCATION_TYPE = "PapyrusSysMLAllocationTable"; //$NON-NLS-1$

	/**
	 * 
	 * @see org.eclipse.papyrus.sysml.nattable.menu.handlers.AbstractSysmlNattableCreateCommandHandler#setEnabled(java.lang.Object)
	 * 
	 * @param evaluationContext
	 */
	@Override
	public void setEnabled(Object evaluationContext) {
		Command command = getCommand();
		boolean isEnabled = command.canExecute();
		INattableModelManager tableManager = INattableModelManagerUtils.getTableManagerFromWorkbenchPart(getActiveWorkbenchPart());
		isEnabled = isEnabled && tableManager.getTable().getTableConfiguration().getType().equals(TABLE_ALLOCATION_TYPE);
		if(isEnabled) {
			IElementType newElementType = getElementTypeToCreate();
			String id = newElementType.getId();
			isEnabled = tableManager.canCreateRowElement(id);
		}
		setBaseEnabled(isEnabled);

	}

}
