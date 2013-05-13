/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import java.lang.reflect.Field;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Tool;
import org.eclipse.gef.tools.SelectionTool;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionHandleEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * Fixed bug about displaying diagram assistant handles.
 * In GMF DiagramAssistantEditPolicy, isDiagramPartActive() is only available for IDiagramWorkbenchPart, but we use PapyrusMultiDiagramEditor.
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class SequenceConnectionHandleEditPolicy extends ConnectionHandleEditPolicy {

	@Override
	protected boolean shouldShowDiagramAssistant() {
		if(!(getHost().isActive() && isPreferenceOn() && isHostEditable() && isHostResolvable() && isDiagramPartActive())) {
			return false;
		}
		if(hasHandles() || !isSelectionToolActive()) {
			return false;
		}
		return true;
	}

	/**
	 * Check if the handles is displayed.
	 */
	private boolean hasHandles() {
		try {
			Field f = ConnectionHandleEditPolicy.class.getDeclaredField("handles");
			f.setAccessible(true);
			Object handles = f.get(this);
			return handles != null;
		} catch (Exception e) {
			return false;
		}
	}

	private boolean isSelectionToolActive() {
		// getViewer calls getParent so check for null
		if(getHost().getParent() != null) {
			Tool theTool = getHost().getViewer().getEditDomain().getActiveTool();
			if((theTool != null) && theTool instanceof SelectionTool) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if the diagram part is active.
	 * 
	 * @return True if the diagram part is active; false otherwise.
	 */
	private boolean isDiagramPartActive() {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if(window != null) {
			IWorkbenchPage page = window.getActivePage();
			if(page != null) {
				IWorkbenchPart activePart = page.getActivePart();
				IDiagramWorkbenchPart editorPart = null;
				if(activePart instanceof IDiagramWorkbenchPart) {
					editorPart = (IDiagramWorkbenchPart)activePart;
				} else if(activePart instanceof IAdaptable) {
					editorPart = (IDiagramWorkbenchPart)((IAdaptable)activePart).getAdapter(IDiagramWorkbenchPart.class);
				}
				if(editorPart == null) {
					return false;
				}
				return editorPart.getDiagramEditPart().getRoot().equals(((IGraphicalEditPart)getHost()).getRoot());
			}
		}
		return false;
	}

	/**
	 * Checks if the host editpart is editable.
	 * 
	 * @return True if the host is editable; false otherwise.
	 */
	private boolean isHostEditable() {
		if(getHost() instanceof GraphicalEditPart) {
			return ((GraphicalEditPart)getHost()).isEditModeEnabled();
		}
		return true;
	}

	/**
	 * Is the host's semantic reference resolvable (if applicable)?
	 * 
	 * @return true if the semantic reference is resolvable, true if there is no
	 *         semantic reference, and false otherwise
	 */
	private boolean isHostResolvable() {
		final View view = (View)getHost().getModel();
		EObject element = view.getElement();
		if(element != null) {
			return !element.eIsProxy();
		}
		return true;
	}
}
