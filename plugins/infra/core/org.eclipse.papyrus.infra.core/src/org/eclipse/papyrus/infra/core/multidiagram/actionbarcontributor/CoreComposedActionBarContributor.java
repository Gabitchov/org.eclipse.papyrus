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
package org.eclipse.papyrus.infra.core.multidiagram.actionbarcontributor;

import java.util.List;

import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.infra.core.editor.BackboneException;
import org.eclipse.papyrus.infra.core.sasheditor.editor.actionbarcontributor.ComposedActionBarContributor;
import org.eclipse.papyrus.infra.core.sasheditor.editor.actionbarcontributor.IMultiPageEditorActionBarContributor;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.part.EditorActionBarContributor;

/**
 * 
 * An ActionBarContributor composed of ActionBarContributor from multi editor.
 * This ActionBarContributor switch to the contributor dedicated to the active
 * editor in a MultiPageEditor environement.
 * 
 * @author dumoulin
 * 
 */
public class CoreComposedActionBarContributor extends ComposedActionBarContributor implements IMultiPageEditorActionBarContributor {

	/**
	 * The registry. Used to initialize the registered actionBars.
	 */
	protected ActionBarContributorRegistry actionBarContributorRegistry;

	protected List<EditorActionBarContributor> contributors;

	/**
	 * Constructor.
	 * 
	 * @throws BackboneException
	 */
	public CoreComposedActionBarContributor() throws BackboneException {
		// Init the contributors
		loadContributors();
	}

	/**
	 * 
	 * @throws BackboneException
	 */
	private void loadContributors() throws BackboneException {
		actionBarContributorRegistry = new ActionBarContributorRegistry(Activator.PLUGIN_ID);

		contributors = actionBarContributorRegistry.getActionBarContributors();
	}

	/**
	 * @return the actionBarContributorRegistry
	 */
	public ActionBarContributorRegistry getActionBarContributorRegistry() {
		return actionBarContributorRegistry;
	}

	/**
	 * Dispose all nested ActionBarContributors.
	 */
	@Override
	public void dispose() {
		// Dispose nested contributors.
		for(EditorActionBarContributor contributor : contributors) {
			contributor.dispose();
		}
		super.dispose();
	}

	/**
	 * Call the same method on each registered nested ActionBarContributors.
	 */
	@Override
	public void init(IActionBars bars, IWorkbenchPage page) {
		super.init(bars, page);
		buildActions();

		// init nested contributors.
		for(EditorActionBarContributor contributor : contributors) {
			contributor.init(bars, page);
			// remove GMF GlobalSaveAction from bar, fix bug 407854 - [Editor] The save action is disabled in Papyrus
			bars.setGlobalActionHandler("save", null);	// GMF is not using IWorkbenchCommandConstants.FILE_SAVE as ID //$NON-NLS-1$
		}

	}

	/**
	 * Load default actions (undo/redo/delete)
	 * 
	 * @see org.eclipse.gef.ui.actions.ActionBarContributor#buildActions()
	 */
	protected void buildActions() {
		// getActionBars().getToolBarManager().add(new UndoRetargetAction());
		// getActionBars().getToolBarManager().add(new RedoRetargetAction());
	}

	@Override
	public void setActiveEditor(IEditorPart part) {
		super.setActiveEditor(part);
		for(EditorActionBarContributor contributor : contributors) {
			if(part != null) {
				contributor.setActiveEditor(part);
			}
		}

	}

}
