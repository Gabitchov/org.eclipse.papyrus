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

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.infra.nattable.manager.INattableModelManager;


public class ExportToXLSHandler extends AbstractTableHandler {

	public Object execute(ExecutionEvent arg0) throws ExecutionException {
		final INattableModelManager manager = getCurrentNattableModelManager();
		if(manager != null) {
			manager.exportToXLS();
		}
		return null;
	}

}
