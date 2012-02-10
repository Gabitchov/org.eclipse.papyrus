/*****************************************************************************
 * Copyright (c) 2012 Cedric Dumoulin.
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

package org.eclipse.papyrus.infra.core.sasheditor.internal.eclipsecopy;

import org.eclipse.ui.IEditorSite;


/**
 * Interface implemented by site used by nested editors of MultiPageEditor.
 * This interface add the dispose() method.
 * This interface is added in order to allow different implementation of the site, 
 * mainly to have a version for 3.8 and 4.x.
 * 
 * @since 0.9
 * 
 * @author cedric dumoulin
 *
 */
public interface IMultiPageEditorSite extends IEditorSite {

	/**
	 * Method called when the Site should be disposed.
	 * After calling this method, the site is no longer available.
	 */
	public void dispose();
}
