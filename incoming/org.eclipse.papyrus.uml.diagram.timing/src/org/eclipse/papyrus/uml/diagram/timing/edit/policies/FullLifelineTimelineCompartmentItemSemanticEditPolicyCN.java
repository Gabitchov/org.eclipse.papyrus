/*
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.uml.diagram.timing.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType;
import org.eclipse.papyrus.infra.extendedtypes.util.ElementTypeUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.commands.DestructionOccurrenceSpecificationCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.commands.DurationConstraintCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.commands.DurationObservationCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.commands.FullStateInvariantCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.commands.GeneralOrderingCreateCommand;
import org.eclipse.papyrus.uml.diagram.timing.edit.commands.MessageOccurrenceSpecificationCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.commands.OccurrenceSpecificationCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.commands.TimeConstraintCreateCommand;
import org.eclipse.papyrus.uml.diagram.timing.edit.commands.TimeObservationCreateCommand;
import org.eclipse.papyrus.uml.diagram.timing.providers.UMLElementTypes;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
public class FullLifelineTimelineCompartmentItemSemanticEditPolicyCN extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public FullLifelineTimelineCompartmentItemSemanticEditPolicyCN() {
		super(UMLElementTypes.Lifeline_19);
	}

	/**
	 * @generated
	 */
	@Override
	protected Command getCreateCommand(final CreateElementRequest req) {
		final IElementType requestElementType = req.getElementType();
		if (requestElementType == null) {
			return super.getCreateCommand(req);
		}
		IElementType baseElementType = requestElementType;
		boolean isExtendedType = false;
		if (requestElementType instanceof IExtendedHintedElementType) {
			baseElementType = ElementTypeUtils.getClosestDiagramType(requestElementType);
			if (baseElementType != null) {
				isExtendedType = true;
			} else {
				// no reference element type ID. using the closest super element type to give more opportunities, but
				// can lead to bugs.
				baseElementType = ElementTypeUtils.findClosestNonExtendedElementType((IExtendedHintedElementType) requestElementType);
				isExtendedType = true;
			}
		}
		if (UMLElementTypes.StateInvariant_11 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new FullStateInvariantCreateCommandCN(req));
		}
		if (UMLElementTypes.OccurrenceSpecification_12 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new OccurrenceSpecificationCreateCommandCN(req));
		}
		if (UMLElementTypes.MessageOccurrenceSpecification_13 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new MessageOccurrenceSpecificationCreateCommandCN(req));
		}
		if (UMLElementTypes.DestructionOccurrenceSpecification_27 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new DestructionOccurrenceSpecificationCreateCommandCN(req));
		}
		if (UMLElementTypes.DurationConstraint_18 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new DurationConstraintCreateCommandCN(req));
		}
		if (UMLElementTypes.DurationObservation_17 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new DurationObservationCreateCommandCN(req));
		}
		if (UMLElementTypes.TimeConstraint_15 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new TimeConstraintCreateCommand(req));
		}
		if (UMLElementTypes.TimeObservation_16 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new TimeObservationCreateCommand(req));
		}
		if (UMLElementTypes.GeneralOrdering_67 == baseElementType) {
			if (isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType) requestElementType);
			}
			return getGEFWrapper(new GeneralOrderingCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
