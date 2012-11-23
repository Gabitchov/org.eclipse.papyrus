/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.helper;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.ui.IEditorPart;


public class DiagramHelper {

	public static void refresh(EditPart editPart, boolean recursive) {
		editPart.refresh();
		if(recursive) {
			for(EditPart childEditPart : (List<EditPart>)editPart.getChildren()) {
				refresh(childEditPart, true);
			}
		}
	}

	public static void refresh(DiagramEditPart diagramEditPart, boolean recursive) {
		diagramEditPart.refresh();
		if(recursive) {
			for(EditPart childEditPart : (List<EditPart>)diagramEditPart.getChildren()) {
				refresh(childEditPart, true);
			}
			for(EditPart childEditPart : (List<EditPart>)diagramEditPart.getConnections()) {
				refresh(childEditPart, true);
			}
		}
	}

	/**
	 * Refreshes all diagrams in this IEditorPart (Including nested editors when necessary)
	 * 
	 * @param editorPart
	 */
	//FIXME: The current implementation only refreshes the active editor diagram 
	public static void refresh(IEditorPart editorPart) {
		if(editorPart instanceof IMultiDiagramEditor) {
			editorPart = ((IMultiDiagramEditor)editorPart).getActiveEditor();
		}

		if(editorPart instanceof DiagramEditor) {
			DiagramEditor diagramEditor = (DiagramEditor)editorPart;
			DiagramEditPart topEditPart = diagramEditor.getDiagramEditPart();
			if(topEditPart != null) {
				DiagramHelper.refresh(topEditPart, true);
			}
		}
	}

	/**
	 * Refreshes all opened diagrams
	 */
	//FIXME: The current implementation only refreshes the active diagrams
	public static void refreshDiagrams() {
		for(IMultiDiagramEditor activeMultiEditor : EditorUtils.getMultiDiagramEditors()) {
			refresh(activeMultiEditor);
		}
	}
}
