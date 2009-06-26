/*******************************************************************************
 * Copyright (c) 2009 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are property of the CEA, their use is subject to specific agreement 
 * with the CEA.
 * 
 * Contributors:
 *    CEA LIST - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.papyrusgmfgenextension.popupaction;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public abstract class Action implements IObjectActionDelegate {

	private List<EObject> selectedListEObject;

	/**
	 * Convert each selected elements from the explorer menu, or modeling view to an EObject and add it to a list
	 * 
	 * @return list of EObject
	 */
	public void updateSelectedEObject(IStructuredSelection selection) {

		List<EObject> selectedCurrentListEObjects = new LinkedList<EObject>();

		Iterator<Object> eltIt = selection.iterator();
		while (eltIt.hasNext()) {

			Object currentObject = eltIt.next();
			if (currentObject instanceof EObject) {
				selectedCurrentListEObjects.add((EObject) currentObject);
			}
		}
		selectedListEObject = selectedCurrentListEObjects;
	}

	public List<EObject> getSelectedEObject() {
		return selectedListEObject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		// Convert selection into EObject list
		updateSelectedEObject((IStructuredSelection) selection);
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// NO OP.
	}
}
