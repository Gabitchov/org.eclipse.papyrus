/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.modelexplorer.handlers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.views.modelexplorer.NavigatorUtils;
import org.eclipse.papyrus.views.modelexplorer.handler.AbstractCommandHandler;
import org.eclipse.ui.PlatformUI;


public abstract class AbstractDiagramCommandHandler extends AbstractCommandHandler {
	/**
	 * Returns the list of selected diagrams
	 * 
	 * @return
	 *         the list of selected diagrams
	 */
	protected List<Diagram> getSelectedDiagrams() {
		List<Diagram> diagrams = new ArrayList<Diagram>();
		ISelection selection = null;

		// Get current selection
		selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();

		// Get first element if the selection is an IStructuredSelection
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection)selection;
			Iterator<?> iter = structuredSelection.iterator();
			while(iter.hasNext()) {
				Object current = iter.next();
				/**
				 * Get the diagram object.
				 * This getElement is used in order to use IAdaptabel mechanisme
				 * For example for Facet Elements
				 */
				EObject diag = NavigatorUtils.getElement(current, EObject.class);
				if(diag instanceof Diagram) {
					diagrams.add((Diagram)diag);
				}
			}
		}

		return diagrams;
	}
}
