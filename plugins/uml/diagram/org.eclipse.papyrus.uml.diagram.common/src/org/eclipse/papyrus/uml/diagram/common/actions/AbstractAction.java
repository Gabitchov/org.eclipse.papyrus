/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * This class is the common base for actions. It provide helper to access to
 * current diagram and selection.
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public abstract class AbstractAction extends Action {

	/** The graphical edit part **/
	private IGraphicalEditPart host;

	/**
	 * @return the current diagram or null if not found. TODO : throw
	 *         appropriate exception if not found ?
	 */
	protected Diagram getCurrentDiagram() {
		IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if(editorPart instanceof IMultiDiagramEditor) {
			editorPart = ((IMultiDiagramEditor)editorPart).getActiveEditor();
			if(editorPart instanceof DiagramEditor) {
				host = ((DiagramEditor)editorPart).getDiagramEditPart();
				View view = (View)host.getModel();
				Diagram diagram = view.getDiagram();
				return diagram;
			}
		}
		return null;
	}

	/**
	 * @return the graphical edit part
	 */
	public IGraphicalEditPart getHost() {
		return host;
	}

	/**
	 * @return a list of selected objects view
	 */
	protected List<View> getSelection() {
		List<View> viewSelected = new ArrayList<View>();
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (activeWorkbenchWindow!=null){
			ISelection selection = activeWorkbenchWindow.getSelectionService().getSelection();
			if(false == selection instanceof IStructuredSelection) {
				return Collections.emptyList();
			}
			for(Object object : ((IStructuredSelection)selection).toList()) {
				if(false == object instanceof IGraphicalEditPart) {
					continue;
				}
				if(object instanceof DiagramEditPart) {
					continue;
				}
				View view = ((IGraphicalEditPart)object).getNotationView();
				if(view.getEAnnotation("Shortcut") != null) {
					continue;
				}
				viewSelected.add(view);
			}			
		}
		return viewSelected;
	}

}
