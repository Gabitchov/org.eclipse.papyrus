/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.sequence.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.sequence.edit.commands.CombinedFragmentCreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.ConsiderIgnoreFragmentCreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.InteractionUseCreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.LifelineCreateCommand;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;

/**
 * @generated
 */
public class InteractionInteractionCompartmentItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public InteractionInteractionCompartmentItemSemanticEditPolicy() {
		super(UMLElementTypes.Interaction_2001);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.Lifeline_3001 == req.getElementType()) {
			return getGEFWrapper(new LifelineCreateCommand(req));
		}
		if(UMLElementTypes.InteractionUse_3002 == req.getElementType()) {
			return getGEFWrapper(new InteractionUseCreateCommand(req));
		}
		if(UMLElementTypes.ConsiderIgnoreFragment_3007 == req.getElementType()) {
			return getGEFWrapper(new ConsiderIgnoreFragmentCreateCommand(req));
		}
		if(UMLElementTypes.CombinedFragment_3004 == req.getElementType()) {
			return getGEFWrapper(new CombinedFragmentCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
