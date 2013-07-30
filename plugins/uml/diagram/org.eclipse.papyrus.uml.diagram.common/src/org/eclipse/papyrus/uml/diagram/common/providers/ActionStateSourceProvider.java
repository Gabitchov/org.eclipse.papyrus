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
package org.eclipse.papyrus.uml.diagram.common.providers;

import org.eclipse.papyrus.uml.diagram.common.handlers.DeleteFromDiagramCommandHandler;
import org.eclipse.papyrus.uml.diagram.common.handlers.RenamedElementHandler;
import org.eclipse.ui.ISources;

/**
 * This class provides the state of the actions. It's used to refresh the status
 * of these actions in the menu. (in toolbar and popup, it's not needed)
 * 
 * To get the status, we listen the selection service AND the part service! The
 * part service is used to know if the selection is in the Model Explorer or
 * not! When the selection is not in the model explorer, the handlers listening
 * the variable need to be disabled
 */
public class ActionStateSourceProvider extends AbstractActionStateSourceProvider {

	/**
	 * The name of the variables to check.
	 */
	public static final String DELETE_IN_DIAGRAM = "deleteInDiagram"; //$NON-NLS-1$

	public static final String RENAME_NAMED_ELEMENT = "renameNamedElement";//$NON-NLS-1$

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public ActionStateSourceProvider() {
		super();
		currentState.put(DELETE_IN_DIAGRAM, DISABLED);
		currentState.put(RENAME_NAMED_ELEMENT, DISABLED);
	}

	/**
	 * 
	 * @see org.eclipse.ui.ISourceProvider#getProvidedSourceNames()
	 * 
	 * @return
	 */
	@Override
	public String[] getProvidedSourceNames() {
		return new String[]{ DELETE_IN_DIAGRAM, RENAME_NAMED_ELEMENT };
	}

	/**
	 * Refresh the state of the Delete Action
	 */
	protected void refreshDeleteAction() {
		String oldState = currentState.get(DELETE_IN_DIAGRAM);
		String newState = (testDeleteFromDiagram() ? ENABLED : DISABLED);

		if(oldState != newState) {
			currentState.put(DELETE_IN_DIAGRAM, newState);
			fireSourceChanged(ISources.WORKBENCH, currentState);
		}
	}

	/**
	 * Tests if the action DeleteFromDiagram (now called Delete Selected Element
	 * can be executed
	 * 
	 * @return <code>true</code> if the action DeleteFromDiagram (now called
	 *         Delete Selected Element can be executed <code>false</code> if not
	 */
	protected boolean testDeleteFromDiagram() {
		DeleteFromDiagramCommandHandler handler = new DeleteFromDiagramCommandHandler();
		return isSelectionInDiagram() && handler.isEnabled();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.providers.AbstractActionStateSourceProvider#refreshActions()
	 * 
	 */
	@Override
	protected void refreshActions() {
		refreshDeleteAction();
		refreshRenamedNamedElement();
	}

	/**
	 * Refresh the status of the handlers which listen {@link #RENAME_NAMED_ELEMENT}
	 */
	protected void refreshRenamedNamedElement() {
		RenamedElementHandler handler = new RenamedElementHandler();
		boolean newValue = handler.isEnabled();

		String oldState = currentState.get(RENAME_NAMED_ELEMENT);
		String newState = (newValue ? ENABLED : DISABLED);

		if(oldState != newState) {
			currentState.put(RENAME_NAMED_ELEMENT, newState);
			fireSourceChanged(ISources.WORKBENCH, currentState);
		}

	}
}
