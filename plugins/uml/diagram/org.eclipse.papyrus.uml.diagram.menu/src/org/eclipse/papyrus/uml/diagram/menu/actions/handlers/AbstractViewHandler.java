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
package org.eclipse.papyrus.uml.diagram.menu.actions.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * 
 * This handler is used to modify some preferences for the diagram view (these preferences are currently not stored when Eclipse is closed)
 * For example, we can choose to display : the rulers, the grid, or the page breaks;
 * 
 */
public abstract class AbstractViewHandler extends AbstractParametricHandler {/* extends AbstractHandler { */

	/** the id of the preference to modify */
	protected String id;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param id
	 *        the id of the preference to modify
	 */
	public AbstractViewHandler(String id) {
		super(null);
		this.id = id;
	}

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		((DiagramGraphicalViewer)getDiagramGraphicalViewer()).getWorkspaceViewerPreferenceStore().setValue(id, !isChecked());
		//to set all the menu with this action in the same state

		//to store the value, you should use another state provider for the command in the plugin.xml : 
		//like org.eclipse.ui.handlers.RegistryToggleState
		HandlerUtil.toggleCommandState(event.getCommand());
		return null;
	}

	/**
	 * Returns the current state of the action
	 * 
	 * @return
	 *         the current state of the action
	 */
	protected boolean isChecked() {
		return ((DiagramGraphicalViewer)getDiagramGraphicalViewer()).getWorkspaceViewerPreferenceStore().getBoolean(id);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.menu.actions.handlers.AbstractParametricHandler#setEnabled(java.lang.Object)
	 * 
	 * @param evaluationContext
	 */
	@Override
	public void setEnabled(Object evaluationContext) {
		setBaseEnabled(getDiagramGraphicalViewer() != null);
	}

}
