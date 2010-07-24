/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.edit.policies;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;

/**
 * This class provide customization of the CreationEditPolicy to support the case where
 * a Port is created in a Compartment. In such a case the Port should be added to the compartment owner.
 * 
 * Class created from PinInCompartmentCreationEditPolicy (composite diagram)
 * 
 */
public class ActivityParameterNodeInCompartmentCreationEditPolicy extends CreationEditPolicy {

	@Override
	public EditPart getTargetEditPart(Request request) {

		if(request instanceof CreateUnspecifiedTypeRequest) {
			CreateUnspecifiedTypeRequest createUnspecifiedTypeRequest = (CreateUnspecifiedTypeRequest)request;

			if(understandsRequest(request)) {
				List<?> elementTypes = createUnspecifiedTypeRequest.getElementTypes();
				// Treat the case where only one element type is listed
				// Only take Port element type into account
				if((elementTypes.size() == 1) && ((IElementType)(elementTypes.get(0)) == UMLElementTypes.ActivityParameterNode_3059)) {
					// If the target is a compartment replace by its parent edit part
					if((getHost() instanceof ShapeCompartmentEditPart)) {
						return getHost().getParent();
					}
				}
			}
		}
		return super.getTargetEditPart(request);
	}

}
