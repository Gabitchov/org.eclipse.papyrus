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
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType;
import org.eclipse.papyrus.infra.extendedtypes.util.ElementTypeUtils;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.CombinedFragmentCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.CommentCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.ConsiderIgnoreFragmentCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.ConstraintCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.InteractionUseCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.LifelineCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;

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
		IElementType requestElementType = req.getElementType();
		if(requestElementType == null) {
			return super.getCreateCommand(req);
		}
		IElementType baseElementType = requestElementType;
		boolean isExtendedType = false;
		if(requestElementType instanceof IExtendedHintedElementType) {
			baseElementType = ElementTypeUtils.getClosestDiagramType(requestElementType);
			if(baseElementType != null) {
				isExtendedType = true;
			} else {
				// no reference element type ID. using the closest super element type to give more opportunities, but can lead to bugs.
				baseElementType = ElementTypeUtils.findClosestNonExtendedElementType((IExtendedHintedElementType)requestElementType);
				isExtendedType = true;
			}
		}
		if(UMLElementTypes.ConsiderIgnoreFragment_3007 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ConsiderIgnoreFragmentCreateCommand(req));
		}
		if(UMLElementTypes.CombinedFragment_3004 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new CombinedFragmentCreateCommand(req));
		}
		if(UMLElementTypes.Lifeline_3001 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new LifelineCreateCommand(req));
		}
		if(UMLElementTypes.InteractionUse_3002 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new InteractionUseCreateCommand(req));
		}
		if(UMLElementTypes.Constraint_3008 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ConstraintCreateCommand(req));
		}
		if(UMLElementTypes.Comment_3009 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new CommentCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}
}
