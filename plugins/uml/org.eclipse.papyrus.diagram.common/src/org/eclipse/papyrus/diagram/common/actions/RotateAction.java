/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.actions;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.diagram.common.Messages;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class RotateAction implements IObjectActionDelegate {

	/** The Constant ID. */
	// @unused
	public final static String ID = "org.eclipse.papyrus.diagram.common.actions.RotateAction.id"; //$NON-NLS-1$

	private ShapeNodeEditPart selectedElement;

	public void run(IAction action) {
		if(selectedElement == null) {
			return;
		}

		Dimension size = selectedElement.getSize();

		int x = (Integer)selectedElement.getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_X());
		int y = (Integer)selectedElement.getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_Y());

		Rectangle rectangle = new Rectangle(x + size.width / 2 - size.height / 2, y - size.width / 2 + size.height / 2, size.height, size.width);
		SetBoundsCommand command = new SetBoundsCommand(selectedElement.getEditingDomain(), Messages.RotateAction_rotate_command, new EObjectAdapter(selectedElement.getNotationView()), rectangle);
		selectedElement.getDiagramEditDomain().getDiagramCommandStack().execute(new ICommandProxy(command));
	}

	public void selectionChanged(IAction action, ISelection selection) {
		selectedElement = null;
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection)selection;
			if(structuredSelection.getFirstElement() instanceof ShapeNodeEditPart) {
				selectedElement = (ShapeNodeEditPart)structuredSelection.getFirstElement();
			}
		}
		action.setEnabled(selectedElement != null);
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

}
