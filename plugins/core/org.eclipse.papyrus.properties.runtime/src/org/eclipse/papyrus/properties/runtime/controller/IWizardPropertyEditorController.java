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
package org.eclipse.papyrus.properties.runtime.controller;

import java.awt.Window;
import java.util.List;

import org.eclipse.core.commands.operations.IUndoableOperation;
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
	 * @return the result of the open dialog (@see {@link Window})
	 */
	public int openPostCreationDialog(Shell shell);

}
