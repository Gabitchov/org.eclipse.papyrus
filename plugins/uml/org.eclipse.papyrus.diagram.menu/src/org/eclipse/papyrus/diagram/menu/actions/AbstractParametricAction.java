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
package org.eclipse.papyrus.diagram.menu.actions;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;


public abstract class AbstractParametricAction {

	/**
	 * parameter for the action
	 */
	private String parameter;

	/**
	 * selected EditPart
	 */
	private List<IGraphicalEditPart> selection;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parameter
	 *        parameter for the action
	 * @param selectedEditPart
	 *        the selectedEditPart for the action
	 */
	public AbstractParametricAction(String parameter, List<IGraphicalEditPart> selectedEditPart) {
		this.parameter = parameter;
		this.selection = selectedEditPart;
	}

	/**
	 * Returns the selected Editparts for this action
	 * 
	 * @return
	 *         {@link #selection}
	 */
	protected List<IGraphicalEditPart> getSelection() {
		return selection;
	}

	/**
	 * Test if the command can be build
	 * 
	 * @return
	 *         <code>true</code> if the command can be build
	 */
	public boolean isEnabled() {
		return !selection.isEmpty();
	}

	/**
	 * Gets the parameter.
	 * 
	 * @return the parameter
	 */
	public String getParameter() {
		return parameter;
	}


	/**
	 * Sets the parameter.
	 * 
	 * @param parameter
	 *        the new parameter
	 */
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	/**
	 * executes the action
	 */
	public void doRun(IProgressMonitor progressMonitor) {
		//may be implemented by inherited class
	};

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
}
