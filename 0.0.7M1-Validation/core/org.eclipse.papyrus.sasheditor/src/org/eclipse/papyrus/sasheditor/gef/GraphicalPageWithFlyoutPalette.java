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

import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.MultiPageEditorPart;

/**
 * GEF GraphicalEditorWithFlyoutPalette suitable for use in a MultiPageEditorPart. This adaptation class overide the selectionChanged() method in order to update the selectionActions when the page is
 * selected.
 */
public abstract class GraphicalPageWithFlyoutPalette extends GraphicalEditorWithFlyoutPalette {

	/**
	 * Mark the command stack of all sub-editors
	 */
	public void markSaveLocation() {
		getCommandStack().markSaveLocation();
	}

	/**
	 * Update the selectionActions list when the editor is selected as a page of a MultiPageEditorPart.
	 */
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		IEditorPart editor = getSite().getPage().getActiveEditor();
		if (editor instanceof MultiPageEditorPart) {
			// if( this.equals(((MultiPageEditorPart)editor))
			updateActions(getSelectionActions());
		}
		super.selectionChanged(part, selection);
	}

	/**
	 * Return the underlying graphical viewer. Used by the multipage editor to set the current viwer for selection synchronization.
	 */
	@Override
	public GraphicalViewer getGraphicalViewer() {
		return super.getGraphicalViewer();
	}
}
