/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.handlers;

import java.awt.Toolkit;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.diagram.common.helper.CleanDiagramHelper;
import org.eclipse.papyrus.uml.diagram.common.service.PasteCommandService;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 * @Deprecated seems unused, use org.eclipse.papyrus.uml.diagram.menu.handlers.PasteWithModelHandler
 */
@Deprecated // seems unused, use org.eclipse.papyrus.uml.diagram.menu.handlers.PasteWithModelHandler
public class PasteWithModelHandler extends AbstractHandler {

	/**
	 * The constructor.
	 */
	public PasteWithModelHandler() {

	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart diagramEditor = HandlerUtil.getActiveEditorChecked(event);
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if(selection instanceof IStructuredSelection) {
			if(((IStructuredSelection)selection).getFirstElement() instanceof GraphicalEditPart) {
				GraphicalEditPart targetEditPart = (GraphicalEditPart)((IStructuredSelection)selection).getFirstElement();
				if(targetEditPart != null) {
					// get the paste command with model form the service
					ICommand pastecommand = PasteCommandService.getInstance().getPasteWithModelCommand(targetEditPart, Toolkit.getDefaultToolkit().getSystemClipboard(), targetEditPart.getEditingDomain().getClipboard());

					if(pastecommand.canExecute()) {
						targetEditPart.getEditingDomain().getCommandStack().execute(new GMFtoEMFCommandWrapper(pastecommand));
						RootEditPart topEditPart = targetEditPart.getRoot();
						if(topEditPart.getChildren().get(0) instanceof DiagramEditPart) {
							CleanDiagramHelper.getInstance().run((DiagramEditPart)topEditPart.getChildren().get(0));
						}
					}
				}
			}
		}

		return null;
	}
}
