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
package org.eclipse.papyrus.infra.nattable.utils;

import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.ui.IWorkbenchPart;

/**
 * Utilities for INattableModelManager
 * 
 * @author vl222926
 * 
 */
public class INattableModelManagerUtils {


	private INattableModelManagerUtils() {
		//to prevent instanciation
	}

	/**
	 * 
	 * 
	 * @param activeWorkbenchPart
	 * @return
	 *         the table manager from the workbench part
	 */
	public static INattableModelManager getTableManagerFromWorkbenchPart(final IWorkbenchPart activeWorkbenchPart) {
		if(activeWorkbenchPart != null) {
			return (INattableModelManager)activeWorkbenchPart.getAdapter(INattableModelManager.class);
		}
		return null;
	}


}
