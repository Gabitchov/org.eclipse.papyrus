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
package org.eclipse.papyrus.papyrusgmfgenextension.popupaction;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.jface.action.IAction;


public class AddNodeShowHideContentsBehavior extends Action {

	/** the key for the EditPolicy to add. */
	public static final String SHOW_HIDE_CLASSIFIER_CONTENTS_POLICY_KEY = "org.eclipse.papyrus.diagram.common.editpolicies.ShowHideClassifierContentsEditPolicy.SHOW_HIDE_CLASSIFIER_CONTENTS_POLICY"; //$NON-NLS-1$

	/** the path for the EditPolicy */
	public static final String SHOW_HIDE_CLASSIFIER_CONTENTS_POLICY_CLASS = "org.eclipse.papyrus.diagram.common.editpolicies.ShowHideClassifierContentsEditPolicy"; //$NON-NLS-1$


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {
		// Parse selected GenLink(s) and add the desired CustomBehavior
		Iterator<EObject> it = getSelectedEObject().iterator();
		while(it.hasNext()) {
			EObject eObject = it.next();
			if(eObject instanceof GenNode) {
				//test if it has got a external node to display applied stereotype
				if(!hasCustomBehavior(((GenNode)eObject), SHOW_HIDE_CLASSIFIER_CONTENTS_POLICY_KEY)) {
					addCustomBehavior((GenNode)eObject, SHOW_HIDE_CLASSIFIER_CONTENTS_POLICY_KEY, SHOW_HIDE_CLASSIFIER_CONTENTS_POLICY_CLASS);
				}
			}
		}
	}
}
