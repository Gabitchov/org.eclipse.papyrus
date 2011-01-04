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
package org.eclipse.papyrus.diagram.menu.actions.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * 
 * This handler is used to modify some preferences for the diagram view (these preferences are currently not stored when Eclipse is closed)
 * For example, we can choose to display : the rulers, the grid, or the page breaks;
 * 
 */
public abstract class AbstractViewHandler extends AbstractHandler {

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
	 * @see org.eclipse.core.commands.AbstractHandler#isEnabled()
	 * 
	 * @return
	 */
	@Override
	public boolean isEnabled() {
		return getDiagramGraphicalViewer() != null;
	}

	/**
	 * A utility method to return the active <code>DiagramEditPart</code> if
	 * the current part implements <code>IDiagramWorkbenchPart</code>
	 * 
	 * @return The current diagram if the parts implements <code>IDiagramWorkbenchPart</code>; <code>null</code> otherwise
	 */
	protected IDiagramGraphicalViewer getDiagramGraphicalViewer() {
		IDiagramWorkbenchPart part = getDiagramWorkbenchPart();
		return part != null ? part.getDiagramGraphicalViewer() : null;
	}

	/**
	 * A utility method to return the active part if it implements
	 * or adapts to the <code>IDiagramWorkbenchPart</code> interface
	 * 
	 * @return The current part if it implements or adapts to <code>IDiagramWorkbenchPart</code>; <code>null</code> otherwise
	 */
	protected IDiagramWorkbenchPart getDiagramWorkbenchPart() {
		IDiagramWorkbenchPart diagramPart = null;
		IWorkbenchPart part = getWorkbenchPart();

		if(part instanceof IDiagramWorkbenchPart) {
			diagramPart = (IDiagramWorkbenchPart)part;

		} else if(part != null) {
			diagramPart = (IDiagramWorkbenchPart)part.getAdapter(IDiagramWorkbenchPart.class);
		}

		return diagramPart;
	}

	/**
	 * Retrieves the value of the <code>workbenchPart</code> instance
	 * variable.
	 * 
	 * @return The value of the <code>workbenchPart</code> instance variable.
	 */
	protected final IWorkbenchPart getWorkbenchPart() {
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();
	}

	/**
	 * A utility method to return the active <code>DiagramEditPart</code> if
	 * the current part implements <code>IDiagramWorkbenchPart</code>
	 * 
	 * @return The current diagram if the parts implements <code>IDiagramWorkbenchPart</code>; <code>null</code> otherwise
	 */
	protected DiagramEditPart getDiagramEditPart() {
		IDiagramWorkbenchPart part = getDiagramWorkbenchPart();
		return part != null ? part.getDiagramEditPart() : null;
	}

}
