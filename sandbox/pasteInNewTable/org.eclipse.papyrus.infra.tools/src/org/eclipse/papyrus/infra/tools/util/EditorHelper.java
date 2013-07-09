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
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.tools.util;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * 
 * a helper for the Editor
 * 
 */
public class EditorHelper {

	private EditorHelper() {
		//nothing to do
	}

	/**
	 * 
	 * @return
	 *         the current editor or <code>null</code> if not found
	 */
	public static final IEditorPart getCurrentEditor() {
		final IWorkbench workbench = PlatformUI.getWorkbench();
		if(workbench != null) {
			final IWorkbenchWindow activeWorkbench = workbench.getActiveWorkbenchWindow();
			if(activeWorkbench != null) {
				final IWorkbenchPage activePage = activeWorkbench.getActivePage();
				if(activePage != null) {
					return activePage.getActiveEditor();
				}
			}
		}
		return null;
	}
}
