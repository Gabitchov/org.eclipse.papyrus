/*****************************************************************************
 * Copyright (c) 2013 Cedric Dumoulin.
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
package org.eclipse.papyrus.infra.core.sasheditor.editor;

import org.eclipse.swt.widgets.Control;


/**
 * Allows to access to properties of a Sash Page.
 * This interface allows to read the data. User should not attent to modifiy or write the data in anyway.
 * This interface is provided as parameter of the {@link IPageChangedListener#pageChanged(IFolder)} event.
 * 
 * @author cedric dumoulin
 * 
 */
public interface IFolder {

	/**
	 * Get the raw model corresponding to this folder.
	 * 
	 * @return
	 */
	public Object getRawModel();

	/**
	 * Get the control associated to this folder.
	 * Warning : The returned control is internal implementation dependent. Use with care.
	 * <br>
	 * There is no guarantee that the real type of the control will always be the same.
	 * 
	 * @return
	 */
	public Control getControl();
}
