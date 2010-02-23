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
package org.eclipse.papyrus.diagram.activity.edit.policies;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.activity.commands.CreateActionLocalConditionViewCommand;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityActivityContentCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;

/**
 * This Edit Policy applies on an action. It enables to create a local condition linked with this action, in the parent compartment.
 */
public class CreateActionLocalConditionEditPolicy extends AbstractEditPolicy {

	/** The list of element types this action handles */
	private static final List<IElementType> localConditionTypes = Arrays.asList(UMLElementTypes.Constraint_3011, UMLElementTypes.Constraint_3012, UMLElementTypes.InteractionConstraint_3030, UMLElementTypes.InteractionConstraint_3031, UMLElementTypes.IntervalConstraint_3032, UMLElementTypes.IntervalConstraint_3033, UMLElementTypes.DurationConstraint_3034, UMLElementTypes.DurationConstraint_3035, UMLElementTypes.TimeConstraint_3036, UMLElementTypes.TimeConstraint_3037);

	public CreateActionLocalConditionEditPolicy() {
		super();
	}

	@Override
	public Command getCommand(Request request) {
		if(RequestConstants.REQ_CREATE.equals(request.getType()) && request instanceof CreateUnspecifiedTypeRequest) {
			CreateUnspecifiedTypeRequest creationRequest = (CreateUnspecifiedTypeRequest)request;
			EditPart parentEditPart = getHost().getParent();
			if(parentEditPart instanceof ActivityActivityContentCompartmentEditPart) {
				ActivityActivityContentCompartmentEditPart compartementPart = (ActivityActivityContentCompartmentEditPart)parentEditPart;
				EObject action = ViewUtil.resolveSemanticElement((View)getHost().getModel());
				Object hintedType = creationRequest.getElementTypes().get(0);
				if(localConditionTypes.contains(hintedType)) {
					return new CreateActionLocalConditionViewCommand((IHintedType)hintedType, compartementPart, action, getHost());
				}
			}
		}
		return super.getCommand(request);
	}
}
