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
package org.eclipse.papyrus.uml.diagram.common.actions;

import java.awt.Toolkit;

import org.eclipse.gef.RootEditPart;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.diagram.common.helper.CleanDiagramHelper;
import org.eclipse.papyrus.uml.pastemanager.service.PasteCommandService;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class PasteWithModelAction implements IObjectActionDelegate {

	protected GraphicalEditPart targetEditPart = null;

	public void run(IAction action) {

		/* Get the selected edit parts */

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

	public void selectionChanged(IAction action, ISelection selection) {
		if(selection instanceof IStructuredSelection) {
			Object selectedElement = ((IStructuredSelection)selection).getFirstElement();
			if(selectedElement instanceof GraphicalEditPart) {
				targetEditPart = (GraphicalEditPart)selectedElement;
			}
		}

	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// TODO Auto-generated method stub

	}

}
