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
package org.eclipse.papyrus.extensionpoints.editors.configuration;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Shell;


/**
 * Interface that should be implemented by advanced direct editors for Papyrus.
 */
public interface IAdvancedEditorConfiguration extends IDirectEditorConfiguration {

	/**
	 * Creates the dialog for this direct editor
	 * 
	 * @return the dialog created
	 */
	public Dialog createDialog(Shell shell, EObject objectToEdit, String textToEdit);

}
