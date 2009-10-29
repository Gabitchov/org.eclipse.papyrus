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
 * @author dumoulin
 * 
 */
public class MultiPageSelectionSynchronizer extends SelectionSynchronizer {

	/** The current page viewer */
	private EditPartViewer currentViewer;

	/**
	 * Set the current viewer. Remove the old current viewer from the list. This method allows to
	 * switch the current viewer. The current viewer is the one from the selected page. This method
	 * is called by the multipageEditor when the page change.
	 * 
	 * @param viewer
	 *            the viewer
	 */
	public void setCurrentViewer(EditPartViewer viewer) {
		if (currentViewer == viewer)
			return;
		if (currentViewer != null)
			removeViewer(currentViewer);
		// add current viewer.
		currentViewer = viewer;
		addViewer(viewer);
	}

}
