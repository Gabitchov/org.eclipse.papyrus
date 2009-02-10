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
package org.eclipse.papyrus.sasheditor.extension;

import org.eclipse.gef.ui.actions.RedoRetargetAction;
import org.eclipse.gef.ui.actions.UndoRetargetAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.papyrus.sasheditor.gef.GefMultiPagesActionBarContributor;
import org.eclipse.ui.actions.ActionFactory;

/**
 * Action bar contributor for multi diagram editor. This action bar contributor takes in charge toolbar buttons declared in extensions by diagram plugins.
 */
public abstract class MultiDiagramActionBarContributor extends GefMultiPagesActionBarContributor {

	/**
	 * Load actions declared in extensions, and load default actions (undo/redo/delete)
	 * 
	 * @see org.eclipse.gef.ui.actions.ActionBarContributor#buildActions()
	 */
	protected void buildActions() {
		addRetargetAction(new UndoRetargetAction());
		addRetargetAction(new RedoRetargetAction());
	}

	/**
	 * Return the EditorRegistry for nested editor descriptors.
	 * <p>
	 * Subclass should implements this method in order to return the registry associated to the extension point namespace.
	 * </p>
	 * 
	 * @return the EditorRegistry for nested editor descriptors.
	 */
	abstract protected EditorFactoryRegistry getEditorRegistry();

	/**
	 * Add retarget actions to the given toolbar.
	 * 
	 * @see org.eclipse.ui.part.EditorActionBarContributor#contributeToToolBar(org.eclipse.jface.action.IToolBarManager)
	 */
	public void contributeToToolBar(IToolBarManager toolBarManager) {
		toolBarManager.add(getAction(ActionFactory.UNDO.getId()));
		toolBarManager.add(getAction(ActionFactory.REDO.getId()));
	}

}