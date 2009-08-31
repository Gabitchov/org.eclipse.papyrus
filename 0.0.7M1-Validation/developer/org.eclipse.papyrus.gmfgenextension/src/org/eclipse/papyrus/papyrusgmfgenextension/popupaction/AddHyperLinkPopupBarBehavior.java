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
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IViewPart;

/**
 * Implementation class for AddGenLinkStereotypeDisplayBehavior action
 */
public class AddHyperLinkPopupBarBehavior extends Action {

	public static final String POPUP_POLICY_KEY = "org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE"; //$NON-NLS-1$
	public static final String HYPERLINK_POPUPBAR_POLICY_CLASS = "org.eclipse.papyrus.diagram.common.editpolicies.HyperLinkPopupBarEditPolicy"; //$NON-NLS-1$


	public static final String URI_NOTATION_GENMODEL = "org.eclipse.gmf.runtime.notation/model/notation.genmodel"; //$NON-NLS-1$

	public static final String URI_UML_GENMODEL = "org.eclipse.uml2.uml/model/UML.genmodel"; //$NON-NLS-1$

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
			if (eObject instanceof GenNode) {

				// Create the behavior required by stereotype management (if not already created)
				if (!hasCustomBehavior((GenNode) eObject)) {
					addCustomBehavior((GenNode) eObject);
				}

			}
		}
	}

	/**
	 * Add the CustomBehavior for Applied Stereotype label display to the GenLink node given as parameter
	 * 
	 * @param genNode
	 *            where the CustomBehavior is added
	 */
	private void addCustomBehavior(GenNode genNode) {

		CustomBehaviour behavior = GMFGenFactory.eINSTANCE.createCustomBehaviour();
		behavior.setKey(POPUP_POLICY_KEY);
		behavior.setEditPolicyQualifiedClassName(HYPERLINK_POPUPBAR_POLICY_CLASS);

		genNode.getBehaviour().add(behavior);
	}

	/**
	 * Check if the CustomBehavior for Applied Stereotype label display is already added
	 * 
	 * @param genNode
	 *            the GenLink to test
	 * @return true if the behavior with correct key already exists
	 */
	private boolean hasCustomBehavior(GenNode genNode) {

		boolean hasCustomBehavior = false;

		Iterator<Behaviour> it = genNode.getBehaviour().iterator();
		while (it.hasNext() && !(hasCustomBehavior)) {
			Behaviour behaviour = it.next();

			if (behaviour instanceof CustomBehaviour) {
				CustomBehaviour customBehavior = (CustomBehaviour) behaviour;
				if (POPUP_POLICY_KEY.equals(customBehavior.getKey())) {
					hasCustomBehavior = true;
				}
			}
		}

		return hasCustomBehavior;
	}





}
