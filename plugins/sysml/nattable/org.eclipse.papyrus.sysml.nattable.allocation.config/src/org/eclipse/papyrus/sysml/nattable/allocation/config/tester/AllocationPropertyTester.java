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
package org.eclipse.papyrus.sysml.nattable.allocation.config.tester;

import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.utils.NattableWidgetPropertyTester;
import org.eclipse.papyrus.sysml.nattable.allocation.config.handler.CreateAllocateHandler;


public class AllocationPropertyTester extends NattableWidgetPropertyTester {

	private static final String IS_ALLOCATION_TABLE = "isAllocationTable"; //$NON-NLS-1$

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		final INattableModelManager manager = getNattableModelManager();
		if(manager != null) {
			if(IS_ALLOCATION_TABLE.equals(property) && expectedValue instanceof Boolean) {
				return expectedValue.equals(manager.getTable().getTableConfiguration().getType().equals(CreateAllocateHandler.TABLE_ALLOCATION_TYPE));
			}
		}
		return false;
	}
}
