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
package org.eclipse.papyrus.sasheditor.editor.actionbarcontributor;

import org.eclipse.ui.IEditorPart;

/**
 * Interface implemented by ActionBarContributor dedicated to MultiEditor. ActionBarContributor that
 * want to be advised of a page change should implement this interface. Another way should be to use
 * a Observer/Observee mechanism, allowing to remove the dependancy from the editor to the
 * ActionBarContributor ?
 * 
 * @author dumoulin
 * 
 */
public interface IMultiPageEditorActionBarContributor {

	/**
	 * Sets the active page of the the multi-page editor to be the given editor. Redirect actions to
	 * the given editor if actions are not already being sent to it.
	 * <p>
	 * This method is called whenever the page changes. Subclasses must implement this method to
	 * redirect actions to the given editor (if not already directed to it).
	 * </p>
	 * 
	 * @param activeEditor
	 *            the new active editor, or <code>null</code> if there is no active page, or if the
	 *            active page does not have a corresponding editor
	 */
	void setActivePage(IEditorPart activeEditor);

}