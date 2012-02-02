/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.infra.emf.compare.utils;

import org.eclipse.papyrus.infra.emf.compare.Activator;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;


public class Utils {

	private Utils() {
		//nothing to do
	}

	//FIXME refactore this class in an upper plugin->yes!
	public static final IEditorPart getCurrentEditor() {
		final IWorkbench workbench = PlatformUI.getWorkbench();
		if(workbench != null) {
			final IWorkbenchWindow activeWorkbench = workbench.getActiveWorkbenchWindow();
			if(activeWorkbench != null) {
				final IWorkbenchPage activePage = activeWorkbench.getActivePage();
				if(activePage != null) {
					activePage.getActiveEditor();
				}
			}
		}
		return null;
	}


	public static boolean useEditService() {
		final CompareEditorConfiguration config = Utils.getConfiguration();
		return config != null && config.isEditServiceUsing();
	}

	public static CompareEditorConfiguration getConfiguration() {
		final IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		return Activator.getDefault().getConfigurationFor(editor);
	}
}
