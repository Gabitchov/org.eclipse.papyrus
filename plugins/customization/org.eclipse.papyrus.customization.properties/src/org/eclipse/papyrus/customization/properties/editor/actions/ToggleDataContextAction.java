/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.properties.editor.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.customization.properties.editor.UIEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

/**
 * An action to toggle the display of the DataContextElements in the UIEditor
 * 
 * @author Camille Letavernier
 * 
 */
public class ToggleDataContextAction extends AbstractHandler {

	/**
	 * Indicates if the DataContextElements should be displayed
	 */
	public static boolean showDataContext = false;

	public Object execute(ExecutionEvent event) throws ExecutionException {
		showDataContext = !showDataContext;
		IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if(editor instanceof UIEditor) {
			UIEditor uiEditor = (UIEditor)editor;
			uiEditor.getViewer().refresh();
		}

		//		State state = event.getCommand().getState("org.eclipse.papyrus.customization.properties.displayContextState"); //$NON-NLS-1$
		//		state.setValue(showDataContext);
		return null;
	}

}
