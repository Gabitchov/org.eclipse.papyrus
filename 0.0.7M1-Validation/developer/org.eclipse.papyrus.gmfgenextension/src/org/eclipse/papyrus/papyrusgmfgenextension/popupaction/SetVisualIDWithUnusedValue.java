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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IViewPart;

/**
 * Implementation class for SetVisualIDWithUnusedValue action
 */
public class SetVisualIDWithUnusedValue extends Action {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IViewActionDelegate#init(org.eclipse.ui.IViewPart)
	 */
	public void init(IViewPart view) {
		// NO OP
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {

		Iterator<EObject> it = getSelectedEObject().iterator();
		while (it.hasNext()) {
			EObject eObject = it.next();

			// Action should not be available on objects that are not GenCommonBase
			if (eObject instanceof GenCommonBase) {
				GenCommonBase genCommonBase = (GenCommonBase) eObject;
				int visualID = getNewVisualID(genCommonBase.eResource(), genCommonBase.getClass());

				genCommonBase.setVisualID(visualID);
			}

		}
	}

	/**
	 * This method returns an unused VisualID The method first parse all the VisualID of a particular kind of node (clazz) to find the highest. The new VisualID is the highest + 1 (also tested against
	 * the case another kind of node uses same id)
	 * 
	 * @param gmfgen
	 *            the gmfgen model
	 * @param clazz
	 *            kind of GenCommonBase node tested
	 * @return an unused VisualID (following the highest VisualID used by same kind of node)
	 */
	public static int getNewVisualID(Resource gmfgen, Class<?> clazz) {
		int visualID = -1;

		// Find the highest VisualID used by the chosen kind of node (given by clazz)
		int lastUsed = 0;
		Iterator<EObject> it = gmfgen.getAllContents();
		while (it.hasNext()) {
			EObject eObject = it.next();
			if (clazz.isInstance(eObject)) {
				GenCommonBase genCommonBase = (GenCommonBase) eObject;
				if (lastUsed < genCommonBase.getVisualID()) {
					lastUsed = genCommonBase.getVisualID();
				}
			}
		}

		// Check if another kind of node does not already use visualID
		// increment result in such a case
		visualID = lastUsed + 1;
		while (isUsedVisualID(gmfgen, visualID)) {
			visualID++;
		}
		return visualID;
	}

	/**
	 * Tests if the VisualID parameter is already used in the resource
	 * 
	 * @param gmfgen
	 *            the gmfgen model
	 * @param visualID
	 *            the id to check
	 * @return true if visualID is already used, else returns false
	 */
	public static boolean isUsedVisualID(Resource gmfgen, int visualID) {

		boolean used = false;

		// Iterate over the gmfgen model
		Iterator<EObject> it = gmfgen.getAllContents();
		while (it.hasNext() && !used) {
			EObject eObject = it.next();

			// Most Gen node inherits from GenCommonBase (owns VisualID)
			if (eObject instanceof GenCommonBase) {
				GenCommonBase genCommonBase = (GenCommonBase) eObject;
				if (visualID == genCommonBase.getVisualID()) {
					used = true;
				}
			}
		}

		return used;
	}
}
