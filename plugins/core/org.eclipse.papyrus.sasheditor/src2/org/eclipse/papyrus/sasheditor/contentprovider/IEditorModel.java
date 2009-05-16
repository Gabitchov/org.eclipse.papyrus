 /*****************************************************************************
 * Copyright (c) 2009 CEA LIST & LIFL 
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.sasheditor.contentprovider;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorActionBarContributor;

/**
 * This model indicate that an Editor should be drawn in the sash window folder.
 * @author dumoulin
 *
 */
public interface IEditorModel extends IPageModel {

	/**
	 * Create the IEditor that should be shown.
	 * Editor life cycle methods are not called.
	 * @return A new instance of the IEditor.
	 */
	public IEditorPart createIEditorPart() throws PartInitException;

	/**
	 * Get the EditorActionBarContributor that should be associated with the editor .
	 * 
	 * @return
	 */
	public EditorActionBarContributor getActionBarContributor();

}
