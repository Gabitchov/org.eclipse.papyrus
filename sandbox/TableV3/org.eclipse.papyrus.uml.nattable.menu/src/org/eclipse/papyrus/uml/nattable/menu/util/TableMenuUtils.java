/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.nattable.menu.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.sasheditor.editor.AbstractMultiPageSashEditor;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.uml.service.types.utils.CommandContext;
import org.eclipse.papyrus.uml.service.types.utils.ICommandContext;
import org.eclipse.ui.IWorkbenchPart;

/**
 * Utilities for the creation of contextual menus from the Nattable editor
 */
public class TableMenuUtils {

	/**
	 * FIXME move me in an upper plugin
	 * 
	 * @param tableManager
	 *        the table manager
	 * @return
	 *         the command context to use to create new elements in the table
	 */
	public static ICommandContext getTableCommandContext(INattableModelManager tableManager) {
		INattableModelManager manager = tableManager;
		if(manager != null) {
			final EObject container = manager.getTable().getContext();
			ICommandContext context = null;
			if(container != null) {
				context = new CommandContext(container);
			}
			return context;
		}
		return null;
	}

	/**
	 * FIXME move me in an upper plugin
	 * 
	 * @param activeWorkbenchPart
	 * @return
	 *         the table manager from the workbench part
	 */
	public static INattableModelManager getTableManager(IWorkbenchPart activeWorkbenchPart) {
		IWorkbenchPart activePart = activeWorkbenchPart;
		if(activePart instanceof AbstractMultiPageSashEditor) {
			activePart = ((AbstractMultiPageSashEditor)activePart).getActiveEditor();
			if(activePart != null) {
				return (INattableModelManager)activePart.getAdapter(INattableModelManager.class);
			}

		}
		return null;
	}

}
