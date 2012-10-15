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
package org.eclipse.papyrus.uml.diagram.common.util;

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.ui.IEditorPart;

/**
 * This class provides method to force the load of the view service see bug
 * 302555
 */
public class ViewServiceUtil {

	/**
	 * To load a service, we build a dummy command and we test if it can be
	 * executed
	 * 
	 */
	public static void forceLoad() {
		IEditorPart activeEditor = MDTUtil.getActiveEditor();
		if(activeEditor != null) {
			if(activeEditor instanceof IMultiDiagramEditor) {
				Diagram diagram = (Diagram)((IMultiDiagramEditor)activeEditor).getAdapter(Diagram.class);
				if(diagram != null) {
					String diagramSemanticHint = diagram.getType();
					DiagramEditPart host = (DiagramEditPart)((IMultiDiagramEditor)activeEditor).getAdapter(DiagramEditPart.class);

					// When we don't have the semanticHint, the command can't be
					// executed, if the ViewService is not started
					// The goal of this class is to launch the view service
					ViewDescriptor descriptor = new ViewDescriptor(new EObjectAdapter(diagram), Diagram.class, diagramSemanticHint, ViewUtil.APPEND, false, ((IGraphicalEditPart)host).getDiagramPreferencesHint());
					CreateCommand dummyCommand = new CreateCommand(((IGraphicalEditPart)host).getEditingDomain(), descriptor, ((View)host.getModel()));

					// this action force the load of the ViewService
					dummyCommand.canExecute();
				}
			}
		}

	}

}
