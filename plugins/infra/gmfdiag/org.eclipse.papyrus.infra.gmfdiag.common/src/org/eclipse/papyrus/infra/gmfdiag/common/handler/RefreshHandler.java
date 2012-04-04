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
package org.eclipse.papyrus.infra.gmfdiag.common.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.DiagramHelper;
import org.eclipse.ui.IEditorPart;

/**
 * Handles the refresh command on the Papyrus editor (F5)
 * 
 * Refreshes the active diagram
 * 
 * @author Camille Letavernier
 */
//TODO: To be refactored. Move to infra/gmfdiag/menu when the plugin exists
public class RefreshHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IMultiDiagramEditor multiDiagramEditor = EditorUtils.getMultiDiagramEditor();
		if(multiDiagramEditor != null) {
			IEditorPart activeEditor = multiDiagramEditor.getActiveEditor();
			if(activeEditor instanceof DiagramEditor) {
				DiagramEditor diagramEditor = (DiagramEditor)activeEditor;
				DiagramEditPart topEditPart = diagramEditor.getDiagramEditPart();
				if(topEditPart != null) {
					DiagramHelper.refresh(topEditPart, true);
				}
			}
		}
		return null;
	}
}
