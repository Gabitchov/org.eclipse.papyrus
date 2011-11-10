/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.runtime.controller;

import java.util.List;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Shell;

/**
 * Interface implemented by property editors that are able to create elements
 */
public interface IWizardPropertyEditorController {

	/**
	 * Returns the list of available creation commands for the current set of objects to edit
	 * 
	 * @return the list of available creation commands for the current set of objects to edit or an empty list if no commands are available
	 */
	public List<IUndoableOperation> getAvailableCreationOperations();

	/**
	 * Opens the dialog after the creation of the element
	 * 
	 * @param shell
	 *        the shell for the dialog
	 * @return the result of the open dialog (@see {@link Dialog})
	 */
	public int openPostCreationDialog(Shell shell);

	/**
	 * Returns the command that deletes the given list of elements
	 * 
	 * @param objectsToDelete
	 *        the list of objects to delete
	 * @return the operation in charge of the destruction or <code>null</code>
	 */
	public IUndoableOperation getDeleteOperation(List<Object> objectsToDelete);


}
