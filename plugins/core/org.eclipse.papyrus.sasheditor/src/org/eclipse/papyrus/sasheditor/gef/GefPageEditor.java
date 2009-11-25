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
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sasheditor.gef;

import org.eclipse.gef.EditPartViewer;

/**
 * Interface that should be implemented by PageEditor used with GefMultiPageEditorPart. Editor implementing this interface can participate in the
 * SelectionSynchronizer mechanism.
 * 
 * @author dumoulin
 * 
 */
public interface GefPageEditor {

	/**
	 * Return the underlying graphical viewer. Used by the multipage editor to set the current viwer for selection synchronization.
	 * 
	 * @return
	 */
	public EditPartViewer getGraphicalViewer();

}
