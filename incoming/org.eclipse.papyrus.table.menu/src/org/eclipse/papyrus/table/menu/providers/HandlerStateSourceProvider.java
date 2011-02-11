package org.eclipse.papyrus.table.menu.providers;

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



import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.papyrus.diagram.common.providers.AbstractActionStateSourceProvider;
import org.eclipse.papyrus.table.menu.handler.AddToCurrentTableHandler;
import org.eclipse.ui.ISources;

/**
 * This class provides the state of the Handlers. It's used to refresh
 * the status of these Handlers in the menu. (in toolbar and popup, it's not needed)
 * 
 * To get the status, we listen the selection service AND the part service!
 * The part service is used to know if the selection is in the Model Explorer or not!
 * When the selection is not in the model explorer, the handlers listening the variable need to be disabled
 */
public class HandlerStateSourceProvider extends AbstractActionStateSourceProvider {

	/**
	 * The names of the variable to check.
	 */
	public static final String ADD_TO_TABLE = "addToOpenedTable"; //$NON-NLS-1$

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public HandlerStateSourceProvider() {
		super();
		currentState.put(ADD_TO_TABLE, DISABLED);
	}


	/**
	 * 
	 * @see org.eclipse.ui.ISourceProvider#getProvidedSourceNames()
	 * 
	 * @return
	 */
	@Override
	public String[] getProvidedSourceNames() {
		return new String[]{ ADD_TO_TABLE };

	}


	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.common.providers.AbstractActionStateSourceProvider#refreshActions()
	 * 
	 */
	@Override
	protected void refreshActions() {
		refresh(ADD_TO_TABLE, new AddToCurrentTableHandler());
	}

	/**
	 * Refresh the state of the handlers
	 * 
	 * @param key
	 *        the key used to refresh the handler status
	 * @param handler
	 *        the handler to refresh
	 */
	protected void refresh(String key, AbstractHandler handler) {
		String oldState = currentState.get(key);
		String newState = (test(handler) ? ENABLED : DISABLED);

		if(oldState != newState) {
			currentState.put(key, newState);
			fireSourceChanged(ISources.WORKBENCH, key, newState);
		}
	}

	/**
	 * 
	 * @param handler
	 *        the handler to refresh
	 * @return
	 *         <code>true</code> if the status of the handler is enabled
	 */
	protected boolean test(AbstractHandler handler) {
		return handler.isEnabled();
	}
}
