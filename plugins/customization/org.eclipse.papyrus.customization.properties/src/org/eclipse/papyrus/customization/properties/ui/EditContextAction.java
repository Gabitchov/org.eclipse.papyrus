/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.properties.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.papyrus.customization.properties.util.ProjectUtil;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

/**
 * An action to edit an existing context.
 * The context must not be read-only, which means it should not have been
 * registered via a plug-in extension
 * 
 * @author Camille Letavernier
 */
public class EditContextAction {

	/**
	 * Opens an Eclipse Editor to edit the given context.
	 * 
	 * @param context
	 *        The context to edit
	 * @throws Exception
	 *         If the context cannot be edited
	 */
	public void openEditor(Context context) throws Exception {
		IFile contextFile = ProjectUtil.getContextFile(context);

		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(new FileEditorInput(contextFile), "org.eclipse.papyrus.customization.properties.UIEditor", true); //$NON-NLS-1$
	}
}
