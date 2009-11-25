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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.jface.action.IAction;
import org.eclipse.papyrus.sasheditor.eclipsecopy.MultiPageEditorActionBarContributor;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.actions.RetargetAction;
import org.eclipse.ui.part.EditorActionBarContributor;

/**
 * This class is an attempt to merge gef ActionBarContributor and MultiPagesActionBarContributor.
 */
public abstract class GefMultiPagesActionBarContributor extends MultiPageEditorActionBarContributor {

	/** The registry of the Contributor */
	private ActionRegistry registry = new ActionRegistry();

	/** The registry of the active page. Initialized when the page is switched or set */
	private ActionRegistry activePageRegistry;

	/** The registry of the multipage editor. Initialized when the editor is switched */
	private ActionRegistry rootEditorRegistry;

	/** Remember the active editor */
	protected IEditorPart rootEditor;

	/**
	 * Contains the {@link RetargetAction}s that are registered as global action handlers. We need to hold on to these so that we can remove them as
	 * PartListeners in dispose().
	 */
	private List<RetargetAction> retargetActions = new ArrayList<RetargetAction>();

	/** table that maintains references to global actions */
	private Set<String> globalActionKeys = new HashSet<String>();

	/**
	 * Adds the given action to the action registry.
	 * 
	 * @param action
	 *        the action to add
	 */
	protected void addAction(IAction action) {
		getActionRegistry().registerAction(action);
	}

	/**
	 * Indicates the existence of a global action identified by the specified key. This global action is defined outside the scope of this
	 * contributor, such as the Workbench's undo action, or an
	 * action provided by a workbench ActionSet. The list of global action keys is used whenever the active editor is changed (
	 * {@link #setActiveEditor(IEditorPart)}). Keys provided here will result in
	 * corresponding actions being obtained from the active editor's <code>ActionRegistry</code>, and those actions will be registered with the
	 * ActionBars for this contributor. The editor's action
	 * handler and the global action must have the same key.
	 * 
	 * @param key
	 *        the key identifying the global action
	 */
	public void addGlobalActionKey(String key) {
		globalActionKeys.add(key);
	}

	/**
	 * Adds the specified RetargetAction to this contributors <code>ActionRegistry</code>. The RetargetAction is also added as a
	 * <code>IPartListener</code> of the contributor's page. Also, the
	 * retarget action's ID is flagged as a global action key, by calling {@link #addGlobalActionKey(String)}.
	 * 
	 * @param action
	 *        the retarget action being added
	 */
	public void addRetargetAction(RetargetAction action) {
		addAction(action);
		retargetActions.add(action);
		getPage().addPartListener(action);
		addGlobalActionKey(action.getId());
	}

	/**
	 * Creates and initializes Actions managed by this contributor.
	 */
	protected abstract void buildActions();

	/**
	 * Subclasses must implement to declare additional global actions IDs. Only IDs which were not already added directly or indirectly using
	 * {@link #addGlobalActionKey(String)} need to be added.
	 * 
	 * @see #addGlobalActionKey(String)
	 */
	protected abstract void declareGlobalActionKeys();

	/**
	 * Disposes the contributor. Removes all {@link RetargetAction}s that were {@link org.eclipse.ui.IPartListener}s on the
	 * {@link org.eclipse.ui.IWorkbenchPage} and disposes them. Also disposes the
	 * action registry.
	 * <P>
	 * Subclasses may extend this method to perform additional cleanup.
	 * 
	 * @see org.eclipse.ui.part.EditorActionBarContributor#dispose()
	 */
	@Override
	public void dispose() {
		// hook gmf part
		// hook gef part
		for(int i = 0; i < retargetActions.size(); i++) {
			RetargetAction action = (RetargetAction)retargetActions.get(i);
			getPage().removePartListener(action);
			action.dispose();
		}
		registry.dispose();
		retargetActions = null;
		registry = null;
	}

	/**
	 * Retrieves an action from the action registry using the given ID. Lookup in both registries (root editor and current page)
	 * 
	 * @param id
	 *        the ID of the sought action
	 * @return <code>null</code> or the action if found
	 */
	protected IAction getAction(String id) {
		return registry.getAction(id);
	}

	/**
	 * returns this contributor's ActionRegsitry.
	 * 
	 * @return the ActionRegistry
	 */
	protected ActionRegistry getActionRegistry() {
		return registry;
	}

	/**
	 * @see EditorActionBarContributor#init(IActionBars)
	 */
	public void init(IActionBars bars) {
		buildActions();
		declareGlobalActionKeys();
		super.init(bars);
		// Hook gmf part
	}

	/**
	 * Sets the active page of the the multi-page editor to be the given editor. Redirect actions to the given editor if actions are not already being
	 * sent to it.
	 * <p>
	 * This method is called whenever the page changes (from MultiPageEditorPart.pageChange(int)). Subclasses must implement this method to redirect
	 * actions to the given editor (if not already directed to it).
	 * </p>
	 * 
	 * @param activeEditor
	 *        the new active editor, or <code>null</code> if there is no active page, or if the active page does not have a corresponding editor
	 */
	public void setActivePage(IEditorPart editor) {
		// switch the global action handlers:
		// switch the current root registry
		activePageRegistry = (ActionRegistry)editor.getAdapter(ActionRegistry.class);
		// Connect the actions
		connectActions();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setActiveEditor(IEditorPart editor) {
		super.setActiveEditor(editor);
		rootEditor = editor;
		// Switch the current page registry
		rootEditorRegistry = (ActionRegistry)editor.getAdapter(ActionRegistry.class);
		// Connect the actions
		connectActions();
	}

	/**
	 * Connect the actions registered in the globalActionKeys. Lookup actions implementation in the rootEditor registry and in the current page
	 * registry.
	 */
	protected void connectActions() {
		System.out.println("scribe.connectActions()");
		IActionBars bars = getActionBars();
		Iterator<String> iter = globalActionKeys.iterator();
		while(iter.hasNext()) {
			String id = iter.next();
			System.out.println("connect(" + id + ", " + getEditorAction(id) + ")");
			bars.setGlobalActionHandler(id, getEditorAction(id));
			bars.updateActionBars();
		}
	}

	/**
	 * Get the action from one of the registry
	 * 
	 * @param key
	 *        retrieves the action for the given key
	 */
	protected IAction getEditorAction(String key) {
		IAction action = null;

		if(activePageRegistry != null) {
			action = activePageRegistry.getAction(key);
		}
		if(action == null && rootEditorRegistry != null) {
			action = rootEditorRegistry.getAction(key);
		}
		return action;
	}

}
