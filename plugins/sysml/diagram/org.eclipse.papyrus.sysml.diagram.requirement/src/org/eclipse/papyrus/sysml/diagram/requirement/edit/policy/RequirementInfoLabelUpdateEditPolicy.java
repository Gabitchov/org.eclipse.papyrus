/*****************************************************************************
 * Copyright (c) 2012 ATOS.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Olivier Mélois (ATOS) - Initial API and implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.sysml.diagram.requirement.edit.policy;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AbstractAppliedStereotypeDisplayEditPolicy;
import org.eclipse.uml2.uml.Element;


/**
 * Edit policy used to refresh the label that display the id and the text of a requirement.
 * 
 */
public class RequirementInfoLabelUpdateEditPolicy extends AbstractAppliedStereotypeDisplayEditPolicy {

	@Override
	public void refreshDisplay() {
		EditPart host = this.getHost();
		host.refresh();
	}

	@Override
	protected Element getUMLElement() {
		EditPart host = this.getHost();
		//Reminder : the label is in the compartment, which is in the class edit part.
		EditPart compartment = host.getParent();
		EditPart classEditPart = compartment.getParent();
		//Getting the class out of the edit part.
		Element clazz = (Element)((View)classEditPart.getModel()).getElement();
		return clazz;
	}


}
