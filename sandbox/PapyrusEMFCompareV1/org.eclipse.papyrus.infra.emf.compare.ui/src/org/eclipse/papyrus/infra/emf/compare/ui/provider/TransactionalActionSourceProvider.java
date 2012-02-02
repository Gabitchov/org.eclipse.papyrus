/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare.ui.provider;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.papyrus.infra.emf.compare.ui.handlers.RedoHandler;
import org.eclipse.papyrus.infra.emf.compare.ui.handlers.UndoHandler;
import org.eclipse.ui.ISources;


public class TransactionalActionSourceProvider extends AbstractActionStateSourceProvider{

	public static final String UNDO_ACTION = "undoAction";
	public static final String REDO_ACTION = "redoAction";
	public TransactionalActionSourceProvider() {
	super();
	currentState.put(UNDO_ACTION, DISABLED);
	currentState.put(REDO_ACTION, DISABLED);
	}

	@Override
	public String[] getProvidedSourceNames() {

		return new String[]{UNDO_ACTION,REDO_ACTION};
	}
public void refresh(){
	refreshActions();
}
	@Override
	protected void refreshActions() {
	refresh(UNDO_ACTION, new UndoHandler());
	refresh(REDO_ACTION, new RedoHandler());
		
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

//		if(oldState != newState) {
			//currentState.put(key, newState);
		currentState.put(key, ENABLED);
			fireSourceChanged(ISources.WORKBENCH, key, newState);
//		}
	}
	
	/**
	 * 
	 * @param handler
	 *        the handler to refresh
	 * @return
	 *         <code>true</code> if the status of the handler is enabled
	 */
	protected boolean test(AbstractHandler handler) {
		return /*isSelectionInDiagram() && */handler.isEnabled();
	}
	
}
