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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.activity.commands.CreateActionLocalConditionViewCommand;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityActivityContentCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;

/**
 * This Edit Policy applies on an action. It enables to create a local condition linked with this action, in the parent compartment.
 */
public class CreateActionLocalConditionEditPolicy extends AbstractEditPolicy {


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
				if(UMLElementTypes.Constraint_3011.equals((creationRequest).getElementTypes().get(0))) {
					return new CreateActionLocalConditionViewCommand((IHintedType)UMLElementTypes.Constraint_3011, compartementPart, action, getHost());
				} else if(UMLElementTypes.Constraint_3012.equals((creationRequest).getElementTypes().get(0))) {
					return new CreateActionLocalConditionViewCommand((IHintedType)UMLElementTypes.Constraint_3012, compartementPart, action, getHost());
				}
			}
		}
		return super.getCommand(request);
	}
}
