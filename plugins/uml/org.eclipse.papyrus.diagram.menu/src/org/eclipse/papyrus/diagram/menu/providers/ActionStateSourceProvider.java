/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.menu.providers;

import org.eclipse.papyrus.diagram.common.providers.AbstractActionStateSourceProvider;
import org.eclipse.papyrus.diagram.menu.actions.handlers.ShowHideCompartmentHandler;
import org.eclipse.papyrus.diagram.menu.actions.handlers.ShowHideContentsHandler;
import org.eclipse.ui.ISources;

/**
 * This class provides the state of the actions. It's used to refresh
 * the status of these actions in the menu. (in toolbar and popup, it's not needed)
 * 
 * To get the status, we listen the selection service AND the part service!
 * The part service is used to know if the selection is in the Model Explorer or not!
 * When the selection is not in the model explorer, the handlers listening the variable need to be disabled
 */
public class ActionStateSourceProvider extends AbstractActionStateSourceProvider {

	/**
	 * The name of the variable to check.
	 */
	public static final String SHOW_HIDE_CONTENTS = "showHideContents"; //$NON-NLS-1$

	public static final String SHOW_HIDE_COMPARTMENTS = "showHideCompartments"; //$NON-NLS-1$

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public ActionStateSourceProvider() {
		super();
		currentState.put(SHOW_HIDE_CONTENTS, DISABLED);
		currentState.put(SHOW_HIDE_COMPARTMENTS, DISABLED);
	}


	/**
	 * 
	 * @see org.eclipse.ui.ISourceProvider#getProvidedSourceNames()
	 * 
	 * @return
	 */
	@Override
	public String[] getProvidedSourceNames() {
		return new String[]{ SHOW_HIDE_CONTENTS, SHOW_HIDE_COMPARTMENTS };
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.common.providers.AbstractActionStateSourceProvider#refreshActions()
	 * 
	 */
	@Override
	protected void refreshActions() {
		refreshShowHideContentsAction();
		refreshShowHideCompartmentsAction();
	}


	/**
	 * Refresh the state of the Delete Action
	 */
	protected void refreshShowHideContentsAction() {
		String oldState = currentState.get(SHOW_HIDE_CONTENTS);
		String newState = (testShowHideContents() ? ENABLED : DISABLED);

		if(oldState != newState) {
			currentState.put(SHOW_HIDE_CONTENTS, newState);
			fireSourceChanged(ISources.WORKBENCH, SHOW_HIDE_CONTENTS, newState);
		}
	}

	/**
	 * Tests if the action ShowHideContentsHandler can be executed
	 * 
	 * @return
	 *         <code>true</code> if the action ShowHideContentsHandler can be executed <code>false</code> if not
	 */
	protected boolean testShowHideContents() {
		ShowHideContentsHandler handler = new ShowHideContentsHandler();
		return isSelectionInDiagram() && handler.isEnabled();
	}


	/**
	 * Refresh the state of the Delete Action
	 */
	protected void refreshShowHideCompartmentsAction() {
		String oldState = currentState.get(SHOW_HIDE_COMPARTMENTS);
		String newState = (testShowHideCompartments() ? ENABLED : DISABLED);

		if(oldState != newState) {
			currentState.put(SHOW_HIDE_COMPARTMENTS, newState);
			fireSourceChanged(ISources.WORKBENCH, SHOW_HIDE_COMPARTMENTS, newState);
		}
	}


	/**
	 * Tests if the action ShowHideCompartmentsHandler can be executed
	 * 
	 * @return
	 *         <code>true</code> if the action ShowHideCompartmentsHandler can be executed <code>false</code> if not
	 */
	protected boolean testShowHideCompartments() {
		ShowHideCompartmentHandler handler = new ShowHideCompartmentHandler();
		return isSelectionInDiagram() && handler.isEnabled();
	}
}
