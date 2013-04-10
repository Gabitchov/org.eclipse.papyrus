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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.menu.actions.handlers;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * This handler can use a parameter
 * 
 * He provides a method to get the selection
 * 
 * The handler can use parameter
 * 
 */
public abstract class AbstractParametricHandler extends AbstractHandler implements IExecutableExtension {

	/** parameter for this handler */
	protected String parameter = null;

	/** parameter ID */
	protected String parameterID = null;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parameterID
	 */
	public AbstractParametricHandler(String parameterID) {
		this.parameterID = parameterID;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parameterID
	 *        the id of the parameter
	 * @param parameter
	 *        the value of the parameter
	 */
	public AbstractParametricHandler(String parameterID, String parameter) {
		this.parameterID = parameterID;
		this.parameter = parameter;
	}

	/**
	 * 
	 * @see org.eclipse.core.runtime.IExecutableExtension#setInitializationData(org.eclipse.core.runtime.IConfigurationElement, java.lang.String,
	 *      java.lang.Object)
	 * 
	 * @param config
	 * @param propertyName
	 * @param data
	 * @throws CoreException
	 */
	@SuppressWarnings("rawtypes")
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data) throws CoreException {
		if(data instanceof Hashtable && this.parameterID != null) {
			this.parameter = (String)((Hashtable)data).get(this.parameterID);
		}
	}

	/**
	 * Iterate over current selection and build a list of the {@link IGraphicalEditPart} contained in
	 * the selection.
	 * 
	 * @return the currently selected {@link IGraphicalEditPart}
	 */
	protected List<IGraphicalEditPart> getSelectedElements() {
		List<IGraphicalEditPart> editparts = new ArrayList<IGraphicalEditPart>();


		// Get current selection
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		Object selection = (activeWorkbenchWindow != null) ? activeWorkbenchWindow.getSelectionService().getSelection() : null;

		// Treat non-null selected object (try to adapt and return EObject)
		if(selection != null) {
			if(selection instanceof IStructuredSelection) {

				IStructuredSelection structuredSelection = (IStructuredSelection)selection;

				Iterator<?> it = structuredSelection.iterator();
				while(it.hasNext()) {
					Object object = it.next();
					if(object instanceof IGraphicalEditPart) {
						editparts.add((IGraphicalEditPart)object);
					}
				}

			} else if(selection instanceof IGraphicalEditPart) {
				editparts.add((IGraphicalEditPart)selection);
			}
		}
		return editparts;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setEnabled(Object evaluationContext) {
		setBaseEnabled(true);
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

		// Get current selection
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

		// Treat non-null selected object (try to adapt and return EObject)
		if((activeWorkbenchWindow != null) && (activeWorkbenchWindow.getActivePage() != null)) {
			return activeWorkbenchWindow.getActivePage().getActivePart();
		}

		return null;
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
