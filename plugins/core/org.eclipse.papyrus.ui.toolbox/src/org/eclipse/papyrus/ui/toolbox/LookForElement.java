/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.ui.toolbox;

import org.eclipse.gef.commands.CommandStack;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

/**
 * The Class LookForElement that contains method that allows looking for elements.
 */
public class LookForElement {

	/**
	 * Gets the command stack.
	 * 
	 * @return the command stack
	 */
	public static CommandStack getCommandStack() {
		// getCommandStack
		if((PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage() != null)
				&& (PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor() != null)) {

			IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
					.getActiveEditor();

			if(editorPart instanceof IMultiDiagramEditor) {
				IEditorPart multiEditorPart;
				multiEditorPart = ((IMultiDiagramEditor)editorPart).getActiveEditor();
				CommandStack stack = (CommandStack)multiEditorPart.getAdapter(CommandStack.class);
				return stack;
			} else {
				return (CommandStack)editorPart.getAdapter(CommandStack.class);
			}
		}
		return null;
	}


}
