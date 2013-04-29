/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies.semantic;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomCombinedFragmentCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomConsiderIgnoreFragmentCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomConstraintCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomDurationConstraintCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomDurationObservationCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomInteractionUseCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomLifelineCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomTimeObservationCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.CommentCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.InteractionInteractionCompartmentItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomInteractionInteractionCompartmentItemSemanticEditPolicy extends InteractionInteractionCompartmentItemSemanticEditPolicy {

	/**
	 * @Override
	 */
	@Override
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.ConsiderIgnoreFragment_3007 == req.getElementType()) {
			return getGEFWrapper(new CustomConsiderIgnoreFragmentCreateCommand(req));
		}
		if(UMLElementTypes.CombinedFragment_3004 == req.getElementType()) {
			return getGEFWrapper(new CustomCombinedFragmentCreateCommand(req));
		}
		if(UMLElementTypes.Lifeline_3001 == req.getElementType()) {
			return getGEFWrapper(new CustomLifelineCreateCommand(req));
		}
		if(UMLElementTypes.InteractionUse_3002 == req.getElementType()) {
			return getGEFWrapper(new CustomInteractionUseCreateCommand(req));
		}
		if(UMLElementTypes.Constraint_3008 == req.getElementType()) {
			return getGEFWrapper(new CustomConstraintCreateCommand(req));
		}
		if(UMLElementTypes.Comment_3009 == req.getElementType()) {
			return getGEFWrapper(new CommentCreateCommand(req));
		}
		if(UMLElementTypes.TimeObservation_3020 == req.getElementType()) {
			return getGEFWrapper(new CustomTimeObservationCreateCommand(req));
		}
		if(UMLElementTypes.DurationObservation_3024 == req.getElementType()) {
			return getGEFWrapper(new CustomDurationObservationCreateCommand(req));
		}
		if(UMLElementTypes.DurationConstraint_3021 ==  req.getElementType()) {
			return getGEFWrapper(new CustomDurationConstraintCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}
}
