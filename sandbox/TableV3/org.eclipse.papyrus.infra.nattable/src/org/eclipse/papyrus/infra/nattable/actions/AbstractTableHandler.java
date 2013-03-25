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
package org.eclipse.papyrus.infra.nattable.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.papyrus.infra.nattable.manager.INattableModelManager;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;


public abstract class AbstractTableHandler extends AbstractHandler {

	protected IWorkbenchPart getActivePart() {
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();
	}

	protected INattableModelManager getCurrentNattableModelManager() {
		final IWorkbenchPart currentPart = getActivePart();
		if(currentPart != null) {
			final INattableModelManager manager = (INattableModelManager)currentPart.getAdapter(INattableModelManager.class);
			return manager;
		}
		return null;
	}

	@Override
	public boolean isEnabled() {
		return getCurrentNattableModelManager() != null;
	}

	protected TransactionalEditingDomain getEditingDomain() {
		return TransactionUtil.getEditingDomain(getCurrentNattableModelManager().getTable());//FIXME
	}
}
