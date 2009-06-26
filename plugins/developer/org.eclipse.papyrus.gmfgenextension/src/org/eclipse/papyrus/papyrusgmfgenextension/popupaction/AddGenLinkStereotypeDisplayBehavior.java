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
import org.eclipse.gmf.codegen.gmfgen.Behaviour;
import org.eclipse.gmf.codegen.gmfgen.CustomBehaviour;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IViewPart;

/**
 * Implementation class for AddGenLinkStereotypeDisplayBehavior action
 */
public class AddGenLinkStereotypeDisplayBehavior extends Action {

	private static String STEREOTYPE_LABEL_POLICY_KEY = "org.eclipse.papyrus.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY"; //$NON-NLS-1$

	private static String STEREOTYPE_LABEL_POLICY_CLASS = "org.eclipse.papyrus.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy"; //$NON-NLS-1$

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

		// Parse selected GenLink(s) and add the desired CustomBehavior
		Iterator<EObject> it = getSelectedEObject().iterator();
		while (it.hasNext()) {
			EObject eObject = it.next();
			if (eObject instanceof GenLink) {
				if (!hasCustomBehavior((GenLink) eObject)) {
					addCustomBehavior((GenLink) eObject);
				}
			}
		}
	}

	/**
	 * Add the CustomBehavior for Applied Stereotype label display to the GenLink node given as parameter
	 * 
	 * @param genlink
	 *            where the CustomBehavior is added
	 */
	private void addCustomBehavior(GenLink genlink) {

		CustomBehaviour behavior = GMFGenFactory.eINSTANCE.createCustomBehaviour();
		behavior.setKey(STEREOTYPE_LABEL_POLICY_KEY);
		behavior.setEditPolicyQualifiedClassName(STEREOTYPE_LABEL_POLICY_CLASS);

		genlink.getBehaviour().add(behavior);
	}

	/**
	 * Check if the CustomBehavior for Applied Stereotype label display is already added
	 * 
	 * @param genlink
	 *            the GenLink to test
	 * @return true if the behavior with correct key already exists
	 */
	private boolean hasCustomBehavior(GenLink genlink) {

		boolean hasCustomBehavior = false;

		Iterator<Behaviour> it = genlink.getBehaviour().iterator();
		while (it.hasNext() && !(hasCustomBehavior)) {
			Behaviour behaviour = it.next();

			if (behaviour instanceof CustomBehaviour) {
				CustomBehaviour customBehavior = (CustomBehaviour) behaviour;
				if (STEREOTYPE_LABEL_POLICY_KEY.equals(customBehavior.getKey())) {
					hasCustomBehavior = true;
				}
			}
		}

		return hasCustomBehavior;
	}
}
