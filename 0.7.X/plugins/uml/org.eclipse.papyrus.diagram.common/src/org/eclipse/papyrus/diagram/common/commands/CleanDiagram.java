/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.commands;

import java.util.ArrayList;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.diagram.common.helper.CleanDiagramHelper;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;


/**
 * The Class CleanDiagram.
 */
public class CleanDiagram implements IObjectActionDelegate {

	/** The view to remove. */
	protected ArrayList<View> viewToRemove = new ArrayList<View>();


	/** The selected element. */
	private DiagramEditPart selectedElement;

	/**
	 * Instantiates a new clean diagram.
	 */
	public CleanDiagram() {
	}

	/**
	 * {@inheritDoc}
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {

	}

	/**
	 * {@inheritDoc}
	 */
	public void run(IAction action) {
		CleanDiagramHelper.getInstance().run(selectedElement);
	}

	/**
	 * {@inheritDoc}
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		if(selection instanceof IStructuredSelection) {
			Object selectedobject = ((IStructuredSelection)selection).getFirstElement();
			if(selectedobject instanceof DiagramEditPart) {
				selectedElement = (DiagramEditPart)selectedobject;
			}
		}

	}

}
